package com.skyjoo.neweast.biz.common.upload;

import org.springframework.web.multipart.MultipartFile;

/**
 * �ļ��ϴ�������
 * 
 * @author zhengwei
 */
public interface UploadManager {

    /**
     * �ϴ��ļ�
     * 
     * @param multipartFile
     * @return
     * @throws UploadFileException
     */
    UploadFileResult uploadFile(MultipartFile multipartFile) throws UploadFileException;

    /**
     * �ϴ��ļ�
     * 
     * @param multipartFile �ļ�
     * @param subPath ��·��
     * @return
     * @throws UploadFileException
     */
    UploadFileResult uploadFile(MultipartFile multipartFile, String subPath) throws UploadFileException;

    /**
     * �����ļ��ϴ� filepath=rootpath + subpath + filename + ��׺
     * 
     * @param multipartFile
     * @param subPath ��·��
     * @param suffixs ��׺����
     * @return ���ص����ļ������·����subPath + filename
     */
    UploadFileResult uploadFile(MultipartFile multipartFile, String subPath, String[] suffixs)
                                                                                              throws UploadFileException;

    /**
     * �����ļ��ϴ� filepath=rootpath + subpath + filename + ��׺
     * 
     * @param multipartFile
     * @param subPath ��·��
     * @param suffixs ��׺����
     * @param maxSize ÿ���ļ���С����
     * @return
     * @throws UploadFileException
     */
    UploadFileResult uploadFile(MultipartFile multipartFile, String subPath, String[] suffixs, long maxSize)
                                                                                                            throws UploadFileException;

    /**
     * ����ļ��ϴ�
     * 
     * @param multipartFiles
     * @return
     * @throws UploadFileException
     */
    UploadFilesResult uploadFiles(MultipartFile[] multipartFiles) throws UploadFileException;

    /**
     * ����ļ��ϴ�
     * 
     * @param multipartFiles �ļ�
     * @param subPath ��·��
     * @return
     * @throws UploadFileException
     */
    UploadFilesResult uploadFiles(MultipartFile[] multipartFiles, String subPath) throws UploadFileException;

    /**
     * ����ļ��ϴ� filepath=rootpath + subpath + filename + ��׺
     * 
     * @param multipartFiles
     * @param subPath ��·��
     * @param suffixs ��׺����
     * @return ���ص����ļ������·����subPath + filename
     */
    UploadFilesResult uploadFiles(MultipartFile[] multipartFiles, String subPath, String[] suffixs)
                                                                                                   throws UploadFileException;

    /**
     * ����ļ��ϴ� filepath=rootpath + subpath + filename + ��׺
     * 
     * @param multipartFiles
     * @param subPath ��·��
     * @param suffixs ��׺����
     * @param maxSize ÿ���ļ���С����
     * @return
     * @throws UploadFileException
     */
    UploadFilesResult uploadFiles(MultipartFile[] multipartFiles, String subPath, String[] suffixs, long maxSize)
                                                                                                                 throws UploadFileException;

    /**
     * �ϴ�ͼƬ
     * 
     * @param image ͼƬ
     * @param isCompress �Ƿ���������ͼ
     * @return
     * @throws UploadFileException
     */
    UploadFileResult uploadImage(MultipartFile image, boolean isCompress) throws UploadFileException;

    /**
     * �ϴ�ͼƬ
     * 
     * @param image ͼƬ
     * @param isCompress �Ƿ���������ͼ
     * @param subPath ��·��
     * @return
     * @throws UploadFileException
     */
    UploadFileResult uploadImage(MultipartFile image, boolean isCompress, String subPath) throws UploadFileException;

    /**
     * ����ͼƬ�ϴ� filepath=rootpath + subpath + filename + ��׺
     * 
     * @param image ͼƬ
     * @param isCompress �Ƿ���������ͼ
     * @param subPath ��·��
     * @param suffixs ��׺����
     * @return ���ص����ļ������·����subPath + filename
     */
    UploadFileResult uploadImage(MultipartFile image, boolean isCompress, String subPath, String[] suffixs)
                                                                                                           throws UploadFileException;

    /**
     * ����ͼƬ�ϴ� filepath=rootpath + subpath + filename + ��׺
     * 
     * @param image ͼƬ
     * @param isCompress �Ƿ���������ͼ
     * @param subPath ��·��
     * @param suffixs ��׺����
     * @param maxSize ÿ��ͼƬ��С����
     * @return
     * @throws UploadFileException
     */
    UploadFileResult uploadImage(MultipartFile image, boolean isCompress, String subPath, String[] suffixs, long maxSize)
                                                                                                                         throws UploadFileException;

    /**
     * �ϴ����ͼƬ
     * 
     * @param images ͼƬ
     * @param isCompress �Ƿ���������ͼ
     * @return
     * @throws UploadFileException
     */
    UploadFilesResult uploadImages(MultipartFile[] images, boolean isCompress) throws UploadFileException;

    /**
     * �ϴ����ͼƬ
     * 
     * @param images ͼƬ
     * @param subPath ��·��
     * @return
     * @throws UploadFileException
     */
    UploadFilesResult uploadImages(MultipartFile[] images, String subPath) throws UploadFileException;

    /**
     * �ϴ����ͼƬ
     * 
     * @param images ͼƬ
     * @param isCompress �Ƿ���������ͼ
     * @param subPath ��·��
     * @return
     * @throws UploadFileException
     */
    UploadFilesResult uploadImages(MultipartFile[] images, boolean isCompress, String subPath)
                                                                                              throws UploadFileException;

    /**
     * ���ͼƬ�ϴ� filepath=rootpath + subpath + filename + ��׺
     * 
     * @param images ͼƬ
     * @param isCompress �Ƿ���������ͼ
     * @param subPath ��·��
     * @param suffixs ��׺����
     * @return ���ص����ļ������·����subPath + filename
     */
    UploadFilesResult uploadImages(MultipartFile[] images, boolean isCompress, String subPath, String[] suffixs)
                                                                                                                throws UploadFileException;

    /**
     * ���ͼƬ�ϴ� filepath=rootpath + subpath + filename + ��׺
     * 
     * @param images ͼƬ
     * @param isCompress �Ƿ���������ͼ
     * @param subPath ��·��
     * @param suffixs ��׺����
     * @param maxSize ÿ��ͼƬ��С����
     * @return
     * @throws UploadFileException
     */
    UploadFilesResult uploadImages(MultipartFile[] images, boolean isCompress, String subPath, String[] suffixs,
                                   long maxSize) throws UploadFileException;

    /**
     * ɾ��rootPath + subPath + file·�����ļ�
     * 
     * @param subPath ��·��
     * @param file
     */
    void deleteFile(String subPath, String file);
    
    /**
     * ����ϴ��ļ���Ч����
     * @param attachmentFiles
     * @return
     */
    public int getAttachmentFilesLen(MultipartFile[] attachmentFiles);
}
