package org.plugin.search.bean;

import java.util.ArrayList;
import java.util.List;
import org.smart.framework.core.bean.BaseBean;

public class IndexData extends BaseBean {

    /**
	 * create by ty on TY 2017年11月10日 下午2:17:17
	 */
	private static final long serialVersionUID = 4866865094626467095L;
	private List<IndexDocument> indexDocumentList = new ArrayList<IndexDocument>();

    public void addIndexDocument(IndexDocument indexDocument) {
        if (indexDocument != null) {
            indexDocumentList.add(indexDocument);
        }
    }

    public List<IndexDocument> getIndexDocumentList() {
        return indexDocumentList;
    }
}
