package org.smart.plugin.mail;

import org.junit.Test;
import org.plugin.mail.send.MailSender;
import org.plugin.mail.send.impl.TextMailSender;

public class SendTextMailTest {

    private static final String subject = "测试";
    private static final String content = "欢迎使用 Smart Framework！";
    private static final String[] to = {"田源<46490630@qq.com>"};

    @Test
    public void sendTest() {
        MailSender mailSender = new TextMailSender(subject, content, to);
        mailSender.addAttachment("http://www.oschina.net/img/logo_s2.png");
        mailSender.send();
        System.out.println("发送完毕！");
    }
}
