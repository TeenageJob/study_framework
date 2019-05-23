package org.smart.framework;

import org.smart.framework.core.ConfigHelper;

/**
 * 框架常量
 * 
 * @author TY
 * @Time 2017年9月20日 下午9:30:28
 * @since 1.0.0
 */
public interface FrameworkConstant {

    String UTF_8 = "UTF-8";

    /**
     * 配置文件名
     */
    String CONFIG_PROPS = "smart.properties";//配置文件名
    /**
     * sql配置文件
     */
    String SQL_PROPS = "smart-sql.properties";//配置文件名
    
    /**
     * 插件
     */
    String PLUGIN_PACKAGE = "org.plugin";//插件包名
    /**
     * jsp页面路经
     */
    String JSP_PATH = ConfigHelper.getString("smart.framework.app.jsp_path", "/WEB-INF/jsp/");
    /**
     * html页面路径
     */
    String HTML_PATH=ConfigHelper.getString("smart.framework.app.html_path","/WEB-INF/html/");
    /**
     * 静态公用资源
     */
    String WWW_PATH = ConfigHelper.getString("smart.framework.app.www_path", "/www/");
    String HOME_PAGE = ConfigHelper.getString("smart.framework.app.home_page", "/index.html");
    /**
     * 上传文件大小 MB
     */
    int UPLOAD_LIMIT = ConfigHelper.getInt("smart.framework.app.upload_limit", 10);
    
    String PK_NAME = "id";

    String JSON="AJAX";
}
