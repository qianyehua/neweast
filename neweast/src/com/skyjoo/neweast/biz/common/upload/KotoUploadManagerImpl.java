package com.skyjoo.neweast.biz.common.upload;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.eyeieye.koto.remote.UploadResult;
import com.eyeieye.koto.remote.UploadSource;
import com.eyeieye.koto.remote.file.FileService;
import com.eyeieye.koto.remote.img.ImageService;
import com.eyeieye.melos.util.ArrayUtil;
import com.eyeieye.melos.util.StringUtil;

//@Service("uploadManager")
public class KotoUploadManagerImpl implements UploadManager {

	@Autowired
	private ImageService imageService;
	@Autowired
	private FileService fileService;
	 /**
     * 默认图片大小最大限制1M
     */
    private static final long     DEFAULT_IMAGE_MAX_SIZE = 1024 * 1024;
	 /**
     * 单个图片最大限制，默认1M
     */
    private long                  imageMaxSize           = DEFAULT_IMAGE_MAX_SIZE;
    /**
     * 默认图片格式
     */
    private static final String[] DEFAULT_IMAGE_SUFFIXS  = new String[] { "jpg", "jpeg", "png",
            "gif", "JPG", "JPEG", "PNG", "GIF" };
    /**
     * 多个文件上传时，返回字符串路径的分隔符
     */
    private String                splitStr               = "|";

	@Override
	public UploadFileResult uploadFile(MultipartFile multipartFile)
			throws UploadFileException {
		try {
			UploadSource source = new UploadSource();
			source.setBody(multipartFile.getBytes());
			source.setFilename(multipartFile.getOriginalFilename());
			UploadResult rs = this.fileService.store(source);
			UploadFileResult result = new UploadFileResult();
			result.setErrorMsg(rs.getErrorInfo());
			result.setFilePath(rs.getPath());
			result.setSuccess(rs.isSuccess());
			return result;
		} catch (IOException e) {
			throw new UploadFileException(e);
		}
	}

	@Override
	public UploadFileResult uploadFile(MultipartFile multipartFile,
			String subPath) throws UploadFileException {
		return uploadFile(multipartFile);
	}

	@Override
	public UploadFileResult uploadFile(MultipartFile multipartFile,
			String subPath, String[] suffixs) throws UploadFileException {
		return uploadFile(multipartFile);
	}

	@Override
	public UploadFileResult uploadFile(MultipartFile multipartFile,
			String subPath, String[] suffixs, long maxSize)
			throws UploadFileException {
		return uploadFile(multipartFile);
	}

	@Override
	public UploadFilesResult uploadFiles(MultipartFile[] multipartFiles)
			throws UploadFileException {
		try {
			UploadFilesResult result = new UploadFilesResult();
			for (MultipartFile mt : multipartFiles) {
				UploadSource source = new UploadSource();
				source.setBody(mt.getBytes());
				source.setFilename(mt.getOriginalFilename());
				UploadResult rs = this.fileService.store(source);
				// TODO:不知道怎么返回了...
			}
			return result;
		} catch (IOException e) {
			throw new UploadFileException(e);
		}
	}

	@Override
	public UploadFilesResult uploadFiles(MultipartFile[] multipartFiles,
			String subPath) throws UploadFileException {
		return uploadFiles(multipartFiles);
	}

	@Override
	public UploadFilesResult uploadFiles(MultipartFile[] multipartFiles,
			String subPath, String[] suffixs) throws UploadFileException {
		return uploadFiles(multipartFiles);
	}

	@Override
	public UploadFilesResult uploadFiles(MultipartFile[] multipartFiles,
			String subPath, String[] suffixs, long maxSize)
			throws UploadFileException {
		return uploadFiles(multipartFiles);
	}

	@Override
	public UploadFileResult uploadImage(MultipartFile image, boolean isCompress)
			throws UploadFileException {
		try {
			UploadSource source = new UploadSource();
			source.setBody(image.getBytes());
			source.setFilename(image.getOriginalFilename());
			UploadResult rs = this.imageService.store(source);
			UploadFileResult result = new UploadFileResult();
			result.setErrorMsg(rs.getErrorInfo());
			result.setFilePath(rs.getPath());
			result.setSuccess(rs.isSuccess());
			return result;
		} catch (IOException e) {
			throw new UploadFileException(e);
		}
	}

	@Override
	public UploadFileResult uploadImage(MultipartFile image,
			boolean isCompress, String subPath) throws UploadFileException {
		return uploadImage(image, isCompress);
	}

	@Override
	public UploadFileResult uploadImage(MultipartFile image,
			boolean isCompress, String subPath, String[] suffixs)
			throws UploadFileException {
		return uploadImage(image, isCompress);
	}

	@Override
	public UploadFileResult uploadImage(MultipartFile image,
			boolean isCompress, String subPath, String[] suffixs, long maxSize)
			throws UploadFileException {
		return uploadImage(image, isCompress);
	}

	public UploadFilesResult uploadImages(MultipartFile[] images)
			throws UploadFileException {
		try {
			UploadFilesResult result = new UploadFilesResult();
			result.setSuccess(true);
			StringBuilder sb = new StringBuilder();
			//验证图片格式和大小
			for (MultipartFile mt : images) {
				result = checkUploadFile(mt, imageMaxSize,DEFAULT_IMAGE_SUFFIXS);
				if (!result.isSuccess()) {
					return result;
				}
			}
			//保存图片
			for (MultipartFile mt : images) {
				UploadSource source = new UploadSource();
				source.setBody(mt.getBytes());
				source.setFilename(mt.getOriginalFilename());
				UploadResult rs = this.imageService.store(source);
				sb.append(rs.getPath()).append(this.splitStr);
			}
			sb.deleteCharAt(sb.length() - 1);
			result.setFilePaths(sb.toString());
			return result;
		} catch (IOException e) {
			throw new UploadFileException(e);
		}
	}

	@Override
	public UploadFilesResult uploadImages(MultipartFile[] images,
			boolean isCompress) throws UploadFileException {
		return uploadImages(images);
	}

	@Override
	public UploadFilesResult uploadImages(MultipartFile[] images, String subPath)
			throws UploadFileException {
		return uploadImages(images);
	}

	@Override
	public UploadFilesResult uploadImages(MultipartFile[] images,
			boolean isCompress, String subPath) throws UploadFileException {
		return uploadImages(images);
	}

	@Override
	public UploadFilesResult uploadImages(MultipartFile[] images,
			boolean isCompress, String subPath, String[] suffixs)
			throws UploadFileException {
		return uploadImages(images);
	}

	@Override
	public UploadFilesResult uploadImages(MultipartFile[] images,
			boolean isCompress, String subPath, String[] suffixs, long maxSize)
			throws UploadFileException {
		return uploadImages(images);
	}

	@Override
	public void deleteFile(String subPath, String file) {
		String[] paths = StringUtils.split(file, '|');
		// 这里没有删除file,只有删除image
		for (String s : paths) {
			this.imageService.removeByPath(s);
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
	
	/**
     * 检查上传文件的大小和是否为空
     * 
     * @param multipartFile
     * @param size
     * @param suffixs
     * @throws UploadFileException
     */
    private UploadFilesResult checkUploadFile(MultipartFile multipartFile, long size,
                                             String[] suffixs) throws UploadFileException {
    	UploadFilesResult result = new UploadFilesResult();

        if (multipartFile == null || multipartFile.isEmpty()) {
            return UploadFilesResult.ERROR_FILE_EMPTY;
        }

        if (size > imageMaxSize) {
            size = imageMaxSize;
        }

        if (multipartFile.getSize() > size) {
            // throw new UploadFileException("the upload file size can not larger than" + maxSize / 1024 + " KB.");
            return new UploadFilesResult("file_large", "文件太大，不能超过" + size / 1024 + " KB.");
        }

        String suffix = getFileSuffix(multipartFile); // 原文件后缀

        if (suffixs != null) {
            if (!ArrayUtil.contains(suffixs, suffix)) {
                return new UploadFilesResult("file_suffix", "文件格式不正确, " + ArrayUtil.toList(suffixs));
            }
        }

        result.setSuccess(true);
        return result;
    }
    private String getFileSuffix(String fileName) {
        return StringUtil.substring(fileName, StringUtil.lastIndexOf(fileName, ".") + 1);
    }

    private String getFileSuffix(MultipartFile multipartFile) {
        return getFileSuffix(multipartFile.getOriginalFilename());
    }

}
