package org.smart.plugin.mail;

import org.junit.Test;
import org.plugin.mail.send.MailSender;
import org.plugin.mail.send.impl.HtmlMailSender;

public class SendHtmlMailTest {

    private static final String subject = "测试";
    private static final String content = "" +
        "<p><a href='http://my.oschina.net/huangyong/blog/158380'>欢迎使用 Smart Framework！</a></p>" +
        "<p><a href='http://my.oschina.net/huangyong'><img src='http://static.oschina.net/uploads/user/111/223750_100.jpg'></a></p>";
    private static final String[] to = {"田源<46490630@qq.com>"};

    @Test
    public void sendTest() {
        MailSender mailSender = new HtmlMailSender(subject, content, to);
        mailSender.addAttachment("http://www.oschina.net/img/logo_s2.png");
        mailSender.send();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
