package org.smart.framework.mvc.bean;

import java.util.ArrayList;
import java.util.List;
import org.smart.framework.core.bean.BaseBean;

/**
 * 封装批量文件上传对象
 *
 * @author TY
 * @Time 2017年9月20日 下午9:38:55
 * @since 1.0.0
 */
public class Multiparts extends BaseBean {

    /**
	 * create by ty on TY 2017年11月10日 下午2:15:49
	 */
	private static final long serialVersionUID = -754971981086465894L;
	private List<Multipart> multipartList = new ArrayList<Multipart>();

    public Multiparts(List<Multipart> multipartList) {
        this.multipartList = multipartList;
    }

    public int size() {
        return multipartList.size();
    }

    public List<Multipart> getAll() {
        return multipartList;
    }

    public Multipart getOne() {
        return size() == 1 ? multipartList.get(0) : null;
    }
}
