package org.plugin.mail.fetch;

import org.smart.framework.core.bean.BaseBean;

public class MailInfo extends BaseBean {

    /**
	 * create by ty on TY 2017年11月10日 下午2:18:52
	 */
	private static final long serialVersionUID = -2193545567380434504L;
	private String subject;
    private String content;
    private String from;
    private String[] to;
    private String[] cc;
    private String[] bcc;
    private String date;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public String[] getBcc() {
        return bcc;
    }

    public void setBcc(String[] bcc) {
        this.bcc = bcc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
