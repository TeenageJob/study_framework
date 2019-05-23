package org.plugin.search.bean;

import java.util.ArrayList;
import java.util.List;
import org.smart.framework.core.bean.BaseBean;

public class IndexDocument extends BaseBean {

    /**
	 * create by ty on TY 2017年11月10日 下午2:17:21
	 */
	private static final long serialVersionUID = -914060752211926837L;
	private List<IndexField> indexFieldList = new ArrayList<IndexField>();

    public void addIndexField(IndexField indexField) {
        if (indexField != null) {
            indexFieldList.add(indexField);
        }
    }

    public List<IndexField> getIndexFieldList() {
        return indexFieldList;
    }
}
