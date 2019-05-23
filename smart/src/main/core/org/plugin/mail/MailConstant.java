package org.plugin.mail;

import org.smart.framework.core.ConfigHelper;

public interface MailConstant {
	// Debug 模式
    boolean IS_DEBUG = ConfigHelper.getBoolean("smart.plugin.mail.is_debug");

    interface Sender {
    	//协议
        String PROTOCOL = ConfigHelper.getString("smart.plugin.mail.sender.protocol");
        //SSL
        boolean IS_SSL = ConfigHelper.getBoolean("smart.plugin.mail.sender.protocol.ssl");
        //主机名 与 端口号
        String HOST = ConfigHelper.getString("smart.plugin.mail.sender.protocol.host");
        int PORT = ConfigHelper.getInt("smart.plugin.mail.sender.protocol.port");
        //From 地址
        String FROM = ConfigHelper.getString("smart.plugin.mail.sender.from");
        // 身份认证
        boolean IS_AUTH = ConfigHelper.getBoolean("smart.plugin.mail.sender.auth");
        //账户
        String AUTH_USERNAME = ConfigHelper.getString("smart.plugin.mail.sender.auth.username");
        //密码
        String AUTH_PASSWORD = ConfigHelper.getString("smart.plugin.mail.sender.auth.password");
    }

    interface Fetcher {
    	
        String PROTOCOL = ConfigHelper.getString("smart.plugin.mail.fetcher.protocol");
        boolean IS_SSL = ConfigHelper.getBoolean("smart.plugin.mail.fetcher.protocol.ssl");
        String HOST = ConfigHelper.getString("smart.plugin.mail.fetcher.protocol.host");
        int PORT = ConfigHelper.getInt("smart.plugin.mail.fetcher.protocol.port");
        String FOLDER = ConfigHelper.getString("smart.plugin.mail.fetcher.folder");
        boolean FOLDER_READONLY = ConfigHelper.getBoolean("smart.plugin.mail.fetcher.folder.readonly");
    }
}
