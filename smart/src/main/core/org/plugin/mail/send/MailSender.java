package org.plugin.mail.send;

public interface MailSender {
	
    void addCc(String[] cc);

    void addBcc(String[] bcc);
    //附件
    void addAttachment(String path);
    //发送
    void send();
}
