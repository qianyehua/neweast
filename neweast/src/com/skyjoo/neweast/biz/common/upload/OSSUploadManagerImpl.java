package com.skyjoo.neweast.biz.common.upload;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;
import com.eyeieye.melos.util.ArrayUtil;
import com.eyeieye.melos.util.StringUtil;
import com.eyeieye.melos.util.UUIDGenerator;

/**
 * �ϴ��ļ���aliyunʵ��
 * 
 * @author paul 2016-07-12 �޸�daodao�汾
 *
 */
public class OSSUploadManagerImpl implements UploadManager {

	protected final Log logger = LogFactory.getLog(this.getClass());

	// @Value("${upload.root.path}")
	// �ϴ��ĸ�Ŀ¼����ʵ��bucket��name
	private String rootPath;

	// ���ʽڵ�
	private String aliyunEndpoint;

	// aliyun����keyId
	private String accessKeyId;

	// aliyun����keySecret
	private String accessKeySecret;

	/**
	 * �ļ�·���ָ��
	 */
	private static final String FILE_SEPARATOR = "/";

	/**
	 * Ĭ��ͼƬ��ʽ
	 */
	private static final String[] DEFAULT_IMAGE_SUFFIXS = new String[] { "jpg",
			"jpeg", "png", "gif", "JPG", "JPEG", "PNG", "GIF", "bmp", "BMP" };

	/**
	 * Ĭ��ͼƬ��С�������1M
	 */
	private static final long DEFAULT_IMAGE_MAX_SIZE = 1024 * 1024;

	/**
	 * ����ͼƬ������ƣ�Ĭ��1M
	 */
	private long imageMaxSize = DEFAULT_IMAGE_MAX_SIZE;

	/**
	 * �ļ�������ƣ�Ĭ��10M
	 */
	private long maxSize = 10 * 1024 * 1024; // 10M

	/**
	 * aliyun��client
	 */
	private OSSClient client = null;

	/**
	 * ����ļ��ϴ�ʱ�������ַ���·���ķָ���
	 */
	private String splitStr = "|";

	@PostConstruct
	public void init() {
		// TODO Ҳ������Ҫ��ʱ���ٴ����������֪���ĸ����ĸ�С���������о��о�
		client = new OSSClient(aliyunEndpoint, accessKeyId, accessKeySecret);
	}

	@Override
	public UploadFileResult uploadFile(MultipartFile multipartFile)
			throws UploadFileException {
		return this.uploadFile(multipartFile, null);
	}

	@Override
	public UploadFileResult uploadFile(MultipartFile multipartFile,
			String subPath) throws UploadFileException {
		return this.uploadFile(multipartFile, subPath, null);
	}

	@Override
	public UploadFileResult uploadFile(MultipartFile multipartFile,
			String subPath, String[] suffixs) throws UploadFileException {
		return this.uploadFile(multipartFile, subPath, suffixs, maxSize);
	}

	@Override
	public UploadFileResult uploadFile(MultipartFile multipartFile,
			String subPath, String[] suffixs, long size)
			throws UploadFileException {
		UploadFileResult result = null;

		result = checkUploadFile(multipartFile, size, suffixs);
		if (!result.isSuccess()) {
			return result;
		}

		// �ļ���
		String fileName = genratorUploadFileName(multipartFile);

		// Ŀ¼·��
		String dirPath = genDirPath(subPath);

		// ���·��subPath + filename
		String relativePath = dirPath + fileName;

		// ֱ���ϴ��ļ���Ŀ¼���Զ�ʶ���
		try {
			putObject(multipartFile, relativePath);
		} catch (OSSException e) {
			logger.error("upload file error,get oss error", e);
			throw new UploadFileException("upload file error.", e);
		} catch (ClientException e) {
			logger.error("upload file error,get client error", e);
			throw new UploadFileException("upload file error.", e);
		} catch (IOException e) {
			logger.error("upload file error,get IO error", e);
			throw new UploadFileException("upload file error.", e);
		}

		result.setFilePath(relativePath);

		return result;
	}

	@Override
	public UploadFilesResult uploadFiles(MultipartFile[] multipartFiles)
			throws UploadFileException {
		return this.uploadFiles(multipartFiles, null);
	}

	@Override
	public UploadFilesResult uploadFiles(MultipartFile[] multipartFiles,
			String subPath) throws UploadFileException {
		return this.uploadFiles(multipartFiles, subPath, null);
	}

	@Override
	public UploadFilesResult uploadFiles(MultipartFile[] multipartFiles,
			String subPath, String[] suffixs) throws UploadFileException {
		return this.uploadFiles(multipartFiles, subPath, suffixs, maxSize);
	}

	@Override
	@SuppressWarnings("unchecked")
	public UploadFilesResult uploadFiles(MultipartFile[] multipartFiles,
			String subPath, String[] suffixs, long maxSize)
			throws UploadFileException {
		UploadFilesResult result = new UploadFilesResult();
		if (multipartFiles == null || multipartFiles.length == 0) {
			return UploadFilesResult.ERROR_FILE_EMPTY;
		}

		List<MultipartFile> list = ArrayUtil.toList(multipartFiles);

		StringBuilder filePaths = new StringBuilder();

		for (MultipartFile multipartFile : list) {
			UploadFileResult uploadResult = uploadFile(multipartFile, subPath,
					suffixs, maxSize);
			if (!uploadResult.isSuccess()) {
				return new UploadFilesResult(uploadResult.getErrorCode(),
						uploadResult.getErrorMsg());
			}

			filePaths.append(uploadResult.getFilePath()).append(this.splitStr);
			result.addFile(uploadResult.getFile());
		}

		filePaths.deleteCharAt(filePaths.length() - 1); // ɾ�����һ���ָ���
		result.setFilePaths(filePaths.toString());
		result.setSuccess(true);
		return result;
	}

	@Override
	public UploadFileResult uploadImage(MultipartFile image, boolean isCompress)
			throws UploadFileException {
		return this.uploadImage(image, isCompress, null);
	}

	@Override
	public UploadFileResult uploadImage(MultipartFile image,
			boolean isCompress, String subPath) throws UploadFileException {
		return this.uploadImage(image, isCompress, subPath,
				DEFAULT_IMAGE_SUFFIXS);
	}

	@Override
	public UploadFileResult uploadImage(MultipartFile image,
			boolean isCompress, String subPath, String[] suffixs)
			throws UploadFileException {
		return this.uploadImage(image, isCompress, subPath, suffixs,
				imageMaxSize);
	}

	@Override
	public UploadFileResult uploadImage(MultipartFile image,
			boolean isCompress, String subPath, String[] suffixs, long maxSize)
			throws UploadFileException {
		// TODO ��Ϊ����ѹ�����ǰ�����ʵʱ�������Բ���ѹ����ѹ��������һ�����ϴ���ʽ��ֱ�ӵ�ȡ���еķ���������
		return this.uploadFile(image, subPath, suffixs, maxSize);
	}

	@Override
	public UploadFilesResult uploadImages(MultipartFile[] images,
			boolean isCompress) throws UploadFileException {
		return this.uploadImages(images, isCompress, null);
	}

	@Override
	public UploadFilesResult uploadImages(MultipartFile[] images, String subPath)
			throws UploadFileException {
		return this.uploadImages(images, false, subPath);
	}

	@Override
	public UploadFilesResult uploadImages(MultipartFile[] images,
			boolean isCompress, String subPath) throws UploadFileException {
		return this.uploadImages(images, isCompress, subPath,
				DEFAULT_IMAGE_SUFFIXS);
	}

	@Override
	public UploadFilesResult uploadImages(MultipartFile[] images,
			boolean isCompress, String subPath, String[] suffixs)
			throws UploadFileException {
		return this.uploadImages(images, isCompress, subPath, suffixs,
				imageMaxSize);
	}

	@SuppressWarnings("unchecked")
	@Override
	public UploadFilesResult uploadImages(MultipartFile[] images,
			boolean isCompress, String subPath, String[] suffixs, long maxSize)
			throws UploadFileException {
		UploadFilesResult result = new UploadFilesResult();
		images = filterAttachmentFiles(images);
		if (images == null || images.length == 0) {
			return UploadFilesResult.ERROR_FILE_EMPTY;
		}

		List<MultipartFile> list = ArrayUtil.toList(images);

		StringBuilder filePaths = new StringBuilder();

		for (MultipartFile image : list) {
			UploadFileResult uploadResult = uploadImage(image, isCompress,
					subPath, suffixs, maxSize);
			if (!uploadResult.isSuccess()) {
				return new UploadFilesResult(uploadResult.getErrorCode(),
						uploadResult.getErrorMsg());
			}

			filePaths.append(uploadResult.getFilePath()).append(this.splitStr);
			result.addFile(uploadResult.getFile());
		}

		filePaths.deleteCharAt(filePaths.length() - 1); // ɾ�����һ���ָ���
		result.setFilePaths(filePaths.toString());
		result.setSuccess(true);
		return result;
	}

	@Override
	public void deleteFile(String subPath, String file) {
		if (StringUtil.isBlank(file)) {
			return;
		}

		String dirPath = this.genDirPath(subPath);

		String[] files = null;
		if (file.contains(";")) {
			files = file.split(";");
		} else {
			files = new String[] { file };
		}

		for (String filePath : files) {
			if (StringUtil.isNotBlank(filePath)) {
				client.deleteObject(rootPath, dirPath + filePath);
			}

		}

	}

	@Override
	public int getAttachmentFilesLen(MultipartFile[] attachmentFiles) {
		int len = 0;

		for (int i = 0; i < attachmentFiles.length; i++) {
			MultipartFile file = attachmentFiles[i];
			if (!file.isEmpty()
					&& StringUtil.isNotBlank(file.getOriginalFilename())) {
				len++;
			}
		}

		return len;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	public void setMaxSize(long maxSize) {
		this.maxSize = maxSize;
	}

	public void setAliyunEndpoint(String aliyunEndpoint) {
		this.aliyunEndpoint = aliyunEndpoint;
	}

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}

	/**
	 * ��object�ύ��Aliyun OSS������
	 * 
	 * @param multipartFile
	 * @param relativePath
	 * @return
	 * @throws IOException
	 * @throws ClientException
	 * @throws OSSException
	 */
	private void putObject(MultipartFile multipartFile, String relativePath)
			throws OSSException, ClientException, IOException {
		// �����ϴ�Object��Metadata
		ObjectMetadata meta = new ObjectMetadata();
		// ��������ContentLength
		meta.setContentLength(multipartFile.getSize());

		// �ϴ�Object.
		client.putObject(rootPath, relativePath,
				multipartFile.getInputStream(), meta);

	}

	/**
	 * ����ϴ��ļ��Ĵ�С���Ƿ�Ϊ��
	 * 
	 * @param multipartFile
	 * @param size
	 * @param suffixs
	 * @throws UploadFileException
	 */
	private UploadFileResult checkUploadFile(MultipartFile multipartFile,
			long size, String[] suffixs) throws UploadFileException {
		UploadFileResult result = new UploadFileResult();

		if (multipartFile == null || multipartFile.isEmpty()) {
			return UploadFileResult.ERROR_FILE_EMPTY;
		}

		if (size > maxSize) {
			size = maxSize;
		}

		if (multipartFile.getSize() > size) {
			// throw new
			// UploadFileException("the upload file size can not larger than" +
			// maxSize / 1024 + " KB.");
			return new UploadFileResult("file_large", "�ļ�̫�󣬲��ܳ���" + size / 1024
					+ " KB.");
		}

		String suffix = getFileSuffix(multipartFile); // ԭ�ļ���׺

		if (suffixs != null) {
			if (!ArrayUtil.contains(suffixs, suffix)) {
				return new UploadFileResult("file_suffix", "�ļ���ʽ����ȷ, "
						+ ArrayUtil.toList(suffixs));
			}
		}

		result.setSuccess(true);
		return result;
	}

	/**
	 * �����ϴ��ļ�������
	 * 
	 * @param multipartFile
	 * @return
	 */
	private String genratorUploadFileName(MultipartFile multipartFile) {
		StringBuilder uploadFileName = new StringBuilder();
		uploadFileName.append(UUIDGenerator.generate());
		uploadFileName.append(".");
		uploadFileName
				.append(getFileSuffix(multipartFile.getOriginalFilename()));
		return uploadFileName.toString();
	}

	/**
	 * ����Ŀ¼
	 * 
	 * @param subPath
	 * @return
	 */
	private String genDirPath(String subPath) {
		String newSubPath = subPath;
		if (subPath == null) {
			newSubPath = "";
		}
		if (StringUtil.isNotBlank(subPath)) {
			if (subPath.startsWith(FILE_SEPARATOR)) {
				newSubPath = subPath.substring(1);
			}

			if (!subPath.endsWith(FILE_SEPARATOR)) {
				newSubPath = newSubPath + FILE_SEPARATOR;
			}
		}
		return newSubPath;
	}

	/**
	 * ���˵�������Ҫ����ļ�����
	 * 
	 * @param attachmentFiles
	 * @return
	 */
	private MultipartFile[] filterAttachmentFiles(
			MultipartFile[] attachmentFiles) {

		int realyLen = getAttachmentFilesLen(attachmentFiles);

		MultipartFile[] files = new MultipartFile[realyLen];
		int index = 0;
		for (int i = 0; i < attachmentFiles.length; i++) {
			MultipartFile file = attachmentFiles[i];
			if (!file.isEmpty()
					&& StringUtil.isNotBlank(file.getOriginalFilename())) {
				files[index] = file;
				index++;
			}
		}

		return files;
	}

	private String getFileSuffix(String fileName) {
		return StringUtil.substring(fileName,
				StringUtil.lastIndexOf(fileName, ".") + 1);
	}

	private String getFileSuffix(MultipartFile multipartFile) {
		return getFileSuffix(multipartFile.getOriginalFilename());
	}

}
