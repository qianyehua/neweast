package com.skyjoo.neweast.biz.common.upload;

import java.io.File;

import com.skyjoo.neweast.biz.common.CommResult;

/**
 * �ϴ������ļ����
 * 
 * @author zhengwei
 */
public class UploadFileResult extends CommResult {

    /**
     * 
     */
    private static final long            serialVersionUID   = 3381425662708235951L;

    /**
     * ���ص��ļ���·��
     */
    private String                       filePath;

    private File                         file;

    public static final UploadFileResult ERROR_DEFAULT      = new UploadFileResult("system", "ϵͳ����.");

    public static final UploadFileResult ERROR_FILE_EMPTY   = new UploadFileResult("file_empty", "�ļ�Ϊ��.");

    public static final UploadFileResult ERROR_FILE_LARGER  = new UploadFileResult("file_larger", "�ļ�̫��.");

    public static final UploadFileResult ERROR_COMPRESS_PIC = new UploadFileResult("compress_pic", "��������ͼ ����.");

    public UploadFileResult() {

    }

    public UploadFileResult(String resultCode, String resultInfo) {
        super(false, resultCode, resultInfo);
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
