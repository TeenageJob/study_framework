package org.plugin.search.bean;

import org.plugin.search.IndexFieldName;
import org.smart.framework.core.bean.BaseBean;

public class IndexField extends BaseBean {

    /**
	 * create by ty on TY 2017年11月10日 下午2:17:25
	 */
	private static final long serialVersionUID = 4196988041990056615L;
	private IndexFieldName name;
    private String value;

    public IndexField(IndexFieldName name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name.name();
    }

    public String getValue() {
        return value;
    }
}
