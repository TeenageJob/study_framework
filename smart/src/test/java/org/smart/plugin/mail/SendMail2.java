package org.smart.plugin.mail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendMail2 {

    public static void main(String[] args) {
        boolean isSSL = true;
        String host = "smtp.163.com";
        int port = 465;
        String from = "18428327427@163.com";
        String to = "1098029419@qq.com";
        String username = "18428327427@163.com";
        String password = "qq136078";

        try {
            Email email = new SimpleEmail();
            email.setSSLOnConnect(isSSL);
            email.setHostName(host);
            email.setSmtpPort(port);
            email.setAuthentication(username, password);
            email.setFrom(from);
            email.addTo(to);
            email.setSubject("主题");
            email.setMsg("田源  邮件测试");
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }

        System.out.println("发送完毕！");
    }
}
