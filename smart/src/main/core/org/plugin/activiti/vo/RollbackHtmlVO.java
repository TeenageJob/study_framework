package org.plugin.activiti.vo;

import org.smart.framework.core.bean.BaseBean;

public class RollbackHtmlVO extends BaseBean {

    private String business_id;
    private String html;
    private String service;

    public String getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(String business_id) {
        this.business_id = business_id;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
