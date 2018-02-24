package com.skyjoo.neweast.biz.common.upload;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传工具类
 * 
 * @author zhengwei
 */
public interface UploadManager {

    /**
     * 上传文件
     * 
     * @param multipartFile
     * @return
     * @throws UploadFileException
     */
    UploadFileResult uploadFile(MultipartFile multipartFile) throws UploadFileException;

    /**
     * 上传文件
     * 
     * @param multipartFile 文件
     * @param subPath 子路径
     * @return
     * @throws UploadFileException
     */
    UploadFileResult uploadFile(MultipartFile multipartFile, String subPath) throws UploadFileException;

    /**
     * 单个文件上传 filepath=rootpath + subpath + filename + 后缀
     * 
     * @param multipartFile
     * @param subPath 子路径
     * @param suffixs 后缀限制
     * @return 返回的是文件的相对路径，subPath + filename
     */
    UploadFileResult uploadFile(MultipartFile multipartFile, String subPath, String[] suffixs)
                                                                                              throws UploadFileException;

    /**
     * 单个文件上传 filepath=rootpath + subpath + filename + 后缀
     * 
     * @param multipartFile
     * @param subPath 子路径
     * @param suffixs 后缀限制
     * @param maxSize 每个文件大小限制
     * @return
     * @throws UploadFileException
     */
    UploadFileResult uploadFile(MultipartFile multipartFile, String subPath, String[] suffixs, long maxSize)
                                                                                                            throws UploadFileException;

    /**
     * 多个文件上传
     * 
     * @param multipartFiles
     * @return
     * @throws UploadFileException
     */
    UploadFilesResult uploadFiles(MultipartFile[] multipartFiles) throws UploadFileException;

    /**
     * 多个文件上传
     * 
     * @param multipartFiles 文件
     * @param subPath 子路径
     * @return
     * @throws UploadFileException
     */
    UploadFilesResult uploadFiles(MultipartFile[] multipartFiles, String subPath) throws UploadFileException;

    /**
     * 多个文件上传 filepath=rootpath + subpath + filename + 后缀
     * 
     * @param multipartFiles
     * @param subPath 子路径
     * @param suffixs 后缀限制
     * @return 返回的是文件的相对路径，subPath + filename
     */
    UploadFilesResult uploadFiles(MultipartFile[] multipartFiles, String subPath, String[] suffixs)
                                                                                                   throws UploadFileException;

    /**
     * 多个文件上传 filepath=rootpath + subpath + filename + 后缀
     * 
     * @param multipartFiles
     * @param subPath 子路径
     * @param suffixs 后缀限制
     * @param maxSize 每个文件大小限制
     * @return
     * @throws UploadFileException
     */
    UploadFilesResult uploadFiles(MultipartFile[] multipartFiles, String subPath, String[] suffixs, long maxSize)
                                                                                                                 throws UploadFileException;

    /**
     * 上传图片
     * 
     * @param image 图片
     * @param isCompress 是否生成缩略图
     * @return
     * @throws UploadFileException
     */
    UploadFileResult uploadImage(MultipartFile image, boolean isCompress) throws UploadFileException;

    /**
     * 上传图片
     * 
     * @param image 图片
     * @param isCompress 是否生成缩略图
     * @param subPath 子路径
     * @return
     * @throws UploadFileException
     */
    UploadFileResult uploadImage(MultipartFile image, boolean isCompress, String subPath) throws UploadFileException;

    /**
     * 单个图片上传 filepath=rootpath + subpath + filename + 后缀
     * 
     * @param image 图片
     * @param isCompress 是否生成缩略图
     * @param subPath 子路径
     * @param suffixs 后缀限制
     * @return 返回的是文件的相对路径，subPath + filename
     */
    UploadFileResult uploadImage(MultipartFile image, boolean isCompress, String subPath, String[] suffixs)
                                                                                                           throws UploadFileException;

    /**
     * 单个图片上传 filepath=rootpath + subpath + filename + 后缀
     * 
     * @param image 图片
     * @param isCompress 是否生成缩略图
     * @param subPath 子路径
     * @param suffixs 后缀限制
     * @param maxSize 每个图片大小限制
     * @return
     * @throws UploadFileException
     */
    UploadFileResult uploadImage(MultipartFile image, boolean isCompress, String subPath, String[] suffixs, long maxSize)
                                                                                                                         throws UploadFileException;

    /**
     * 上传多个图片
     * 
     * @param images 图片
     * @param isCompress 是否生成缩略图
     * @return
     * @throws UploadFileException
     */
    UploadFilesResult uploadImages(MultipartFile[] images, boolean isCompress) throws UploadFileException;

    /**
     * 上传多个图片
     * 
     * @param images 图片
     * @param subPath 子路径
     * @return
     * @throws UploadFileException
     */
    UploadFilesResult uploadImages(MultipartFile[] images, String subPath) throws UploadFileException;

    /**
     * 上传多个图片
     * 
     * @param images 图片
     * @param isCompress 是否生成缩略图
     * @param subPath 子路径
     * @return
     * @throws UploadFileException
     */
    UploadFilesResult uploadImages(MultipartFile[] images, boolean isCompress, String subPath)
                                                                                              throws UploadFileException;

    /**
     * 多个图片上传 filepath=rootpath + subpath + filename + 后缀
     * 
     * @param images 图片
     * @param isCompress 是否生成缩略图
     * @param subPath 子路径
     * @param suffixs 后缀限制
     * @return 返回的是文件的相对路径，subPath + filename
     */
    UploadFilesResult uploadImages(MultipartFile[] images, boolean isCompress, String subPath, String[] suffixs)
                                                                                                                throws UploadFileException;

    /**
     * 多个图片上传 filepath=rootpath + subpath + filename + 后缀
     * 
     * @param images 图片
     * @param isCompress 是否生成缩略图
     * @param subPath 子路径
     * @param suffixs 后缀限制
     * @param maxSize 每个图片大小限制
     * @return
     * @throws UploadFileException
     */
    UploadFilesResult uploadImages(MultipartFile[] images, boolean isCompress, String subPath, String[] suffixs,
                                   long maxSize) throws UploadFileException;

    /**
     * 删除rootPath + subPath + file路径的文件
     * 
     * @param subPath 子路径
     * @param file
     */
    void deleteFile(String subPath, String file);
    
    /**
     * 检测上传文件有效个数
     * @param attachmentFiles
     * @return
     */
    public int getAttachmentFilesLen(MultipartFile[] attachmentFiles);
}
