package org.plugin.activiti.vo;

import org.smart.framework.core.bean.BaseBean;

public class ActYwVO extends BaseBean {

    private String id="";//id
    private String model="";//使用的模型
    private String service="";//调用的service
    private String page="";//页面
    private String action="";//对应的action

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
