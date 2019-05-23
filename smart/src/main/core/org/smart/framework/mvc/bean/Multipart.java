package org.smart.framework.mvc.bean;

import java.io.InputStream;
import org.smart.framework.core.bean.BaseBean;

/**
 * 封装文件上传对象相关属性
 *
 * @author TY
 * @Time 2017年9月20日 下午9:38:45
 * @since 1.0.0
 */
public class Multipart extends BaseBean {

    /**
	 * create by ty on TY 2017年11月10日 下午2:15:43
	 */
	private static final long serialVersionUID = 7028616029238860186L;
	private String fieldName;
    private String fileName;
    private long fileSize;
    private String contentType;
    private InputStream inputStream;

    public Multipart(String fieldName, String fileName, long fileSize, String contentType, InputStream inputStream) {
        this.fieldName = fieldName;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.contentType = contentType;
        this.inputStream = inputStream;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFileName() {
        return fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getContentType() {
        return contentType;
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}
