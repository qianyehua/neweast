package com.skyjoo.neweast.biz.common.upload;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import com.eyeieye.melos.util.ArrayUtil;
import com.eyeieye.melos.util.StringUtil;
import com.eyeieye.melos.util.UUIDGenerator;

/**
 * �ϴ��ļ�ʵ����
 * 
 * @author zhengwei
 */
//@Service("uploadManager")
public class UploadManagerImpl implements UploadManager {

    protected final Log           logger                 = LogFactory.getLog(this.getClass());

    /**
     * ����ļ��ĸ�·��
     */
    @Value("${upload.root.path}")
    private String                rootPath               = "d:/upload";

    /**
     * �ļ�·���ָ��
     */
    private static final String   FILE_SEPARATOR         = "/";

    /**
     * Ĭ��ͼƬ��ʽ
     */
    private static final String[] DEFAULT_IMAGE_SUFFIXS  = new String[] { "jpg", "jpeg", "png",
            "gif", "JPG", "JPEG", "PNG", "GIF", "bmp", "BMP" };

    /**
     * Ĭ��ͼƬ��С�������1M
     */
    private static final long     DEFAULT_IMAGE_MAX_SIZE = 1024 * 1024;

    /**
     * ����ͼƬ������ƣ�Ĭ��1M
     */
    private long                  imageMaxSize           = DEFAULT_IMAGE_MAX_SIZE;

    /**
     * �ļ�������ƣ�Ĭ��10M
     */
    private long                  maxSize                = 10 * 1024 * 1024;                  // 10M

    /**
     * ����ļ��ϴ�ʱ�������ַ���·���ķָ���
     */
    private String                splitStr               = "|";

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public void setMaxSize(long maxSize) {
        this.maxSize = maxSize;
    }

    @PostConstruct
    public void init() {
        if (StringUtil.isBlank(rootPath)) {
            throw new RuntimeException("�������ļ��ϴ���·��");
        }

        if (!rootPath.endsWith(FILE_SEPARATOR)) {
            rootPath = rootPath + FILE_SEPARATOR;
        }

        if (maxSize <= 0) {
            throw new RuntimeException("�������ļ�����ϴ�����");
        }
    }

    @Override
    public UploadFileResult uploadFile(MultipartFile multipartFile) throws UploadFileException {
        return this.uploadFile(multipartFile, null);
    }

    @Override
    public UploadFileResult uploadFile(MultipartFile multipartFile, String subPath)
                                                                                   throws UploadFileException {
        return this.uploadFile(multipartFile, subPath, null);
    }

    @Override
    public UploadFileResult uploadFile(MultipartFile multipartFile, String subPath, String[] suffixs)
                                                                                                     throws UploadFileException {
        return this.uploadFile(multipartFile, subPath, suffixs, maxSize);
    }

    @Override
    public UploadFilesResult uploadFiles(MultipartFile[] multipartFiles) throws UploadFileException {
        return this.uploadFiles(multipartFiles, null);
    }

    @Override
    public UploadFilesResult uploadFiles(MultipartFile[] multipartFiles, String subPath)
                                                                                        throws UploadFileException {
        return this.uploadFiles(multipartFiles, subPath, null);
    }

    @Override
    public UploadFilesResult uploadFiles(MultipartFile[] multipartFiles, String subPath,
                                         String[] suffixs) throws UploadFileException {
        return this.uploadFiles(multipartFiles, subPath, suffixs, maxSize);
    }

    @SuppressWarnings("unchecked")
    @Override
    public UploadFilesResult uploadFiles(MultipartFile[] multipartFiles, String subPath,
                                         String[] suffixs, long maxSize) throws UploadFileException {
        UploadFilesResult result = new UploadFilesResult();
        if (multipartFiles == null || multipartFiles.length == 0) {
            return UploadFilesResult.ERROR_FILE_EMPTY;
        }

        List<MultipartFile> list = ArrayUtil.toList(multipartFiles);

        StringBuilder filePaths = new StringBuilder();

        for (MultipartFile multipartFile : list) {
            UploadFileResult uploadResult = uploadFile(multipartFile, subPath, suffixs, maxSize);
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
    public UploadFileResult uploadFile(MultipartFile multipartFile, String subPath,
                                       String[] suffixs, long size) throws UploadFileException {
        UploadFileResult result = null;

        result = checkUploadFile(multipartFile, size, suffixs);
        if (!result.isSuccess()) {
            return result;
        }

        // �ļ���
        String fileName = genratorUploadFileName(multipartFile);

        // subPath + filename
        String relativePath = genRelativePath(subPath, fileName);

        // rootpath + relativePath
        String realPath = genRealPath(relativePath);

        File f = new File(realPath);
        if (!f.exists()) {
            f.mkdirs();
        }

        try {
            multipartFile.transferTo(f);
        } catch (Exception e) {
            throw new UploadFileException("upload file error.", e);
        }

        result.setFilePath(relativePath);
        result.setFile(f);

        return result;
    }

    @Override
    public UploadFileResult uploadImage(MultipartFile image, boolean isCompress)
                                                                                throws UploadFileException {
        return this.uploadImage(image, isCompress, null);
    }

    @Override
    public UploadFileResult uploadImage(MultipartFile image, boolean isCompress, String subPath)
                                                                                                throws UploadFileException {
        return this.uploadImage(image, isCompress, subPath, DEFAULT_IMAGE_SUFFIXS);
    }

    @Override
    public UploadFileResult uploadImage(MultipartFile image, boolean isCompress, String subPath,
                                        String[] suffixs) throws UploadFileException {
        return this.uploadImage(image, isCompress, subPath, suffixs, imageMaxSize);
    }

    @Override
    public UploadFilesResult uploadImages(MultipartFile[] images, boolean isCompress)
                                                                                     throws UploadFileException {
        return this.uploadImages(images, isCompress, null);
    }

    @Override
    public UploadFilesResult uploadImages(MultipartFile[] images, String subPath)
                                                                                 throws UploadFileException {
        return this.uploadImages(images, false, subPath);
    }

    @Override
    public UploadFilesResult uploadImages(MultipartFile[] images, boolean isCompress, String subPath)
                                                                                                     throws UploadFileException {
        return this.uploadImages(images, isCompress, subPath, DEFAULT_IMAGE_SUFFIXS);
    }

    @Override
    public UploadFilesResult uploadImages(MultipartFile[] images, boolean isCompress,
                                          String subPath, String[] suffixs)
                                                                           throws UploadFileException {
        return this.uploadImages(images, isCompress, subPath, suffixs, imageMaxSize);
    }

    @SuppressWarnings("unchecked")
    @Override
    public UploadFilesResult uploadImages(MultipartFile[] images, boolean isCompress,
                                          String subPath, String[] suffixs, long maxSize)
                                                                                         throws UploadFileException {
        UploadFilesResult result = new UploadFilesResult();
        images = filterAttachmentFiles(images);
        if (images == null || images.length == 0) {
            return UploadFilesResult.ERROR_FILE_EMPTY;
        }

        List<MultipartFile> list = ArrayUtil.toList(images);

        StringBuilder filePaths = new StringBuilder();

        for (MultipartFile image : list) {
            UploadFileResult uploadResult = uploadImage(image, isCompress, subPath, suffixs,
                maxSize);
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

    private MultipartFile[] filterAttachmentFiles(MultipartFile[] attachmentFiles) {

        int realyLen = getAttachmentFilesLen(attachmentFiles);

        MultipartFile[] files = new MultipartFile[realyLen];
        int index = 0;
        for (int i = 0; i < attachmentFiles.length; i++) {
            MultipartFile file = attachmentFiles[i];
            if (!file.isEmpty() && StringUtil.isNotBlank(file.getOriginalFilename())) {
                files[index] = file;
                index++;
            }
        }

        return files;
    }

    @Override
    public int getAttachmentFilesLen(MultipartFile[] attachmentFiles) {
        int len = 0;

        for (int i = 0; i < attachmentFiles.length; i++) {
            MultipartFile file = attachmentFiles[i];
            if (!file.isEmpty() && StringUtil.isNotBlank(file.getOriginalFilename())) {
                len++;
            }
        }

        return len;
    }

    @Override
    public UploadFileResult uploadImage(MultipartFile image, boolean isCompress, String subPath,
                                        String[] suffixs, long size) throws UploadFileException {

        UploadFileResult result = null;

        result = checkUploadFile(image, size, suffixs);
        if (!result.isSuccess()) {
            return result;
        }

        // �ļ���
        String fileName = genratorUploadFileName(image);

        // subPath + filename
        String relativePath = genRelativePath(subPath, fileName);

        // rootpath + relativePath
        String realPath = genRealPath(relativePath);

        File f = new File(realPath);
        if (!f.exists()) {
            f.mkdirs();
        }

        try {
            image.transferTo(f);
            // �Ƿ��������ͼ
            if (isCompress) {
                // ����ͼ���ƣ��ϴ�ͼƬ����+"_s"
                String smallFileName = getSmallFileName(fileName);
                String smallRelativePath = genRelativePath(subPath, smallFileName);
                String smallRealPath = genRealPath(smallRelativePath);
                File descFile = new File(smallRealPath);
                if (!compressPic(f, descFile))
                    return UploadFileResult.ERROR_COMPRESS_PIC;
            }
        } catch (Exception e) {
            throw new UploadFileException("upload file error.", e);
        }

        result.setFilePath(relativePath);
        result.setFile(f);

        return result;
    }

    @Override
    public void deleteFile(String subPath, String file) {
        if (StringUtil.isBlank(file)) {
            return;
        }

        if (subPath == null) {
            subPath = "";
        } else if (StringUtil.isNotBlank(subPath) && !subPath.endsWith(FILE_SEPARATOR)) {
            subPath = subPath + FILE_SEPARATOR;
        }

        String[] files = null;
        if (file.contains(";")) {
            files = file.split(";");
        } else {
            files = new String[] { file };
        }

        File f = null;
        for (String filePath : files) {
            if (StringUtil.isNotBlank(filePath)) {
                f = new File(rootPath + subPath + filePath);
                if (f.exists()) {
                    f.delete();
                }
            }

        }
    }

    /**
     * ����ϴ��ļ��Ĵ�С���Ƿ�Ϊ��
     * 
     * @param multipartFile
     * @param size
     * @param suffixs
     * @throws UploadFileException
     */
    private UploadFileResult checkUploadFile(MultipartFile multipartFile, long size,
                                             String[] suffixs) throws UploadFileException {
        UploadFileResult result = new UploadFileResult();

        if (multipartFile == null || multipartFile.isEmpty()) {
            return UploadFileResult.ERROR_FILE_EMPTY;
        }

        if (size > maxSize) {
            size = maxSize;
        }

        if (multipartFile.getSize() > size) {
            // throw new UploadFileException("the upload file size can not larger than" + maxSize / 1024 + " KB.");
            return new UploadFileResult("file_large", "�ļ�̫�󣬲��ܳ���" + size / 1024 + " KB.");
        }

        String suffix = getFileSuffix(multipartFile); // ԭ�ļ���׺

        if (suffixs != null) {
            if (!ArrayUtil.contains(suffixs, suffix)) {
                return new UploadFileResult("file_suffix", "�ļ���ʽ����ȷ, " + ArrayUtil.toList(suffixs));
            }
        }

        result.setSuccess(true);
        return result;
    }

    /**
     * �������·��
     * 
     * @param subPath
     * @param fileName
     * @return
     */
    private String genRelativePath(String subPath, String fileName) {
        if (subPath == null) {
            subPath = "";
        }
        if (StringUtil.isNotBlank(subPath)) {
            if (subPath.startsWith(FILE_SEPARATOR)) {
                subPath = subPath.substring(1);
            }

            if (!subPath.endsWith(FILE_SEPARATOR)) {
                subPath = subPath + FILE_SEPARATOR;
            }
        }
        return subPath + fileName;
    }

    /**
     * ��������·��
     * 
     * @param relativePath
     * @return
     */
    private String genRealPath(String relativePath) {
        return rootPath + relativePath;
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
        uploadFileName.append(getFileSuffix(multipartFile.getOriginalFilename()));
        return uploadFileName.toString();
    }

    private String getFileSuffix(String fileName) {
        return StringUtil.substring(fileName, StringUtil.lastIndexOf(fileName, ".") + 1);
    }

    private String getFileSuffix(MultipartFile multipartFile) {
        return getFileSuffix(multipartFile.getOriginalFilename());
    }

    private String getFileName(String fileName) {
        return StringUtil.substring(fileName, 0, StringUtil.lastIndexOf(fileName, "."));
    }

    private String getSmallFileName(String fileName) {
        return getFileName(fileName) + "_s" + "." + getFileSuffix(fileName);
    }

    /**
     * ��������ͼ
     * 
     * @param srcFile
     * @param descFile
     * @param quality
     * @return
     */
    private boolean compressPic(File srcFile, File descFile) {
        BufferedImage src = null;
        FileOutputStream out = null;
        BufferedImage tag = null;
        try {
            src = ImageIO.read(srcFile);
            int width = 100;
            int height = 80;
            tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            tag.getGraphics().drawImage(src, 0, 0, width, height, null); // draw the small image
            out = new FileOutputStream(descFile);
            // ����ͼ��
            ImageIO.write(src, "jpg", out);
        } catch (Exception e) {
            logger.error("compress error:" + srcFile.getPath(), e);
            return false;
        }
        out = null;
        src = null;
        tag = null;
        return true;
    }

    public String getSplitStr() {
        return splitStr;
    }

    public void setSplitStr(String splitStr) {
        this.splitStr = splitStr;
    }

    public long getImageMaxSize() {
        return imageMaxSize;
    }

    public void setImageMaxSize(long imageMaxSize) {
        this.imageMaxSize = imageMaxSize;
    }

}
