package com.skyjoo.neweast.biz.common.upload;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.skyjoo.neweast.biz.common.CommResult;


/**
 * 上传结果
 * 
 * @author zhengwei
 */
public class UploadFilesResult extends CommResult {

    /**
     * 
     */
    private static final long             serialVersionUID  = 1237430994391322451L;

    /**
     * 返回的文件的路径
     */
    private String                        filePaths;

    private List<File>                    files;

    public static final UploadFilesResult ERROR_DEFAULT     = new UploadFilesResult("system", "系统错误.");

    public static final UploadFilesResult ERROR_FILE_EMPTY  = new UploadFilesResult("file_empty", "文件为空.");

    public static final UploadFilesResult ERROR_FILE_LARGER = new UploadFilesResult("file_larger", "文件太大.");
    
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
