package com.skyjoo.neweast.biz.common.upload;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.skyjoo.neweast.biz.common.CommResult;


/**
 * �ϴ����
 * 
 * @author zhengwei
 */
public class UploadFilesResult extends CommResult {

    /**
     * 
     */
    private static final long             serialVersionUID  = 1237430994391322451L;

    /**
     * ���ص��ļ���·��
     */
    private String                        filePaths;

    private List<File>                    files;

    public static final UploadFilesResult ERROR_DEFAULT     = new UploadFilesResult("system", "ϵͳ����.");

    public static final UploadFilesResult ERROR_FILE_EMPTY  = new UploadFilesResult("file_empty", "�ļ�Ϊ��.");

    public static final UploadFilesResult ERROR_FILE_LARGER = new UploadFilesResult("file_larger", "�ļ�̫��.");
    
    public UploadFilesResult() {

    }

    public UploadFilesResult(String resultCode, String resultInfo) {
        super(false, resultCode, resultInfo);
    }

    public String getFilePaths() {
        return filePaths;
    }

    public void setFilePaths(String filePaths) {
        this.filePaths = filePaths;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public void addFile(File file) {
        if (this.files == null) {
            this.files = new ArrayList<File>();
        }
        this.files.add(file);
    }

}
