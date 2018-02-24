package com.skyjoo.neweast.biz.common.upload;

import java.io.File;

import com.skyjoo.neweast.biz.common.CommResult;

/**
 * 上传单个文件结果
 * 
 * @author zhengwei
 */
public class UploadFileResult extends CommResult {

    /**
     * 
     */
    private static final long            serialVersionUID   = 3381425662708235951L;

    /**
     * 返回的文件的路径
     */
    private String                       filePath;

    private File                         file;

    public static final UploadFileResult ERROR_DEFAULT      = new UploadFileResult("system", "系统错误.");

    public static final UploadFileResult ERROR_FILE_EMPTY   = new UploadFileResult("file_empty", "文件为空.");

    public static final UploadFileResult ERROR_FILE_LARGER  = new UploadFileResult("file_larger", "文件太大.");

    public static final UploadFileResult ERROR_COMPRESS_PIC = new UploadFileResult("compress_pic", "生成缩略图 错误.");

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
