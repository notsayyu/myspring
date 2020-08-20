package com.notsay.myspring.common;

/**
 * @description:
 * @author: dsy
 * @date: 2020/8/18 22:12
 */
public interface ConfigConstant {
    /**
     * 配置文件的名称
     */
    String CONFIG_FILE = "myspring.properties";

    /**
     * 数据源配置
     */
    String JDBC_DRIVER = "myspring.frameword.jdbc.driver-class-name";
    String JDBC_URL = "myspring.frameword.jdbc.url";
    String JDBC_USERNAME = "myspring.frameword.jdbc.username";
    String JDBC_PASSWORD = "myspring.frameword.jdbc.password";

    /**
     * java源码地址
     */
    String APP_BASE_PACKAGE = "myspring.frameword.app.base_package";
    /**
     * jsp页面路径
     */
    String APP_JSP_PATH = "myspring.frameword.app.jsp_path";
    /**
     * 静态资源路径
     */
    String APP_ASSET_PATH = "myspring.frameword.app.asset_path";

}
