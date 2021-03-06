package org.plugin.search.bean;

import org.smart.framework.core.bean.BaseBean;

public class SearchResult extends BaseBean {

    /**
	 * create by ty on TY 2017年11月10日 下午2:17:29
	 */
	private static final long serialVersionUID = 9203568386891641926L;
	private String type;
    private String title;
    private String content;
    private String link;
    private String created;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
