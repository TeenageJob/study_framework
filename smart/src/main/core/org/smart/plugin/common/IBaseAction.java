package org.smart.plugin.common;

import java.util.List;
import java.util.Map;

import org.smart.plugin.common.web.pagebean.IPage;
import org.smart.plugin.common.web.pagebean.IPageBean;
import org.smart.plugin.common.web.pagebean.vo.TreeVO;

public interface IBaseAction {

    String JSON = "AJAX";

    IPageBean setData(String id, Object value);

    /**
     * 增加输入表单值
     * <p>
     * <br>create by on TY
     * <br>2017年12月11日 下午4:03:43
     *
     * @param map     数据集
     * @param boolean clear 是否覆盖已有的值
     * @return
     */
    IPageBean setData(Map<String, Object> map, boolean clear);

    IPageBean setList(String id, List<?> value);

    IPageBean setList(String id, IPage<?> value);

    IPageBean setMessage(String id);

    IPageBean setMessage(String id, String value);

    IPageBean setReadOnly(String ids);

    IPageBean setDisabled(String ids);

    IPageBean setEnable(String ids);

    IPageBean setTabActive(String id);

    IPageBean setHide(String ids);

    IPageBean setChecked(String id);

    IPageBean setInvisible(String id);

    IPageBean setShow(String id);

    IPageBean resetForm(String id);

    IPageBean setFocus(String id);

    IPageBean setRequired(String id);

    IPageBean setDisRequired(String id);

    /**
     * 获取传输对象
     * <br>对象是request的Attribute
     * <br>键值为：_DATA_BEAN
     * <br>值为：PageBean（储存设置数据）
     * <p>
     * <br>create by on TY
     * <br>2017年12月11日 下午4:26:54
     *
     * @return
     */
    IPageBean getPageBean();

    void setSuccess(boolean id);

    IPageBean setSelectInputList(String id, List<?> list);

    IPageBean setTreeData(String id, TreeVO treeVO);

}
