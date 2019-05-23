package org.smart.plugin.common.web.pagebean.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.smart.framework.util.JsonUtil;
import org.smart.framework.util.MapUtil;
import org.smart.plugin.common.web.pagebean.*;
import org.smart.plugin.common.web.pagebean.vo.TreeVO;

public class PageBean implements IPageBean {

    private final IFeedBackMessage message = new FeedBackMessage();//反馈消息
    private final IInputData input = new InputData();//输入组件信息
    private final ITableData table = new TableData();//表格
    private final ISelectData select = new SelectData();//下拉框
    private final IInputProperty property = new InputProperty();//组件属性
    private final ITree tree = new Tree();//下拉树
    //本次操作成功否
    private boolean success = true;
    //聚焦的组件确定
    private String focus;


    @Override
    public String getMessageType() {
        return message.getMessageType();
    }

    @Override
    public String getMessage() {
        return message.getMessage();
    }

    @Override
    public void setMessageType(String type) {
        message.setMessageType(type);
    }

    @Override
    public void setMessage(String msg) {
        message.setMessage(msg);
    }

    @Override
    public Map<String, Object> getInputsData() {
        return input.getInputsData();
    }

    @Override
    public void setData(String id, Object value) {
        input.setData(id, value);
    }

    @Override
    public void removeData(String id) {
        input.removeData(id);
    }

    @Override
    public Object getData(String id) {
        return input.getData(id);
    }

    @Override
    public Map<String, List<String>> getProperty() {
        return property.getProperty();
    }

    @Override
    public List<String> getPropertyById(String id) {
        return this.property.getPropertyById(id);
    }

    @Override
    public void setReadOnly(String id) {
        property.setReadOnly(id);
    }

    @Override
    public void setEnable(String id) {
        property.setEnable(id);
    }

    @Override
    public void setDisabled(String id) {
        property.setDisabled(id);
    }

    @Override
    public void setHide(String id) {
        property.setHide(id);
    }

    @Override
    public void setShow(String id) {
        property.setShow(id);
    }

    @Override
    public void setRequed(String id) {
        property.setRequed(id);
    }

    @Override
    public void setDisRequed(String id) {
        property.setDisRequed(id);
    }

    @Override
    public void setFocus(String id) {
        property.setFocus(id);
    }

    @Override
    public void setChecked(String id) {
        property.setChecked(id);
    }

    @Override
    public Map<String, List<?>> getSelectData() {
        return select.getSelectData();
    }

    @Override
    public List<?> getSelectDataById(String id) {
        return select.getSelectDataById(id);
    }

    @Override
    public void setSelectDataById(String id, List<?> list) {
        select.setSelectDataById(id, list);
    }

    @Override
    public void removeSelectDataById(String id) {
        select.removeSelectDataById(id);
    }

    @Override
    public Map<String, IPage<?>> getTablesPageData() {
        return table.getTablesPageData();
    }

    @Override
    public IPage<?> getTablePageData(String id) {
        return table.getTablePageData(id);
    }

    @Override
    public List<?> getTableListData(String id) {
        return table.getTableListData(id);
    }

    @Override
    public void setTableList(String id, List<?> list) {
        table.setTableList(id, list);
    }

    @Override
    public void setPage(String id, IPage<?> list) {
        table.setPage(id, list);
    }

    @Override
    public void setTablePage(String id, IPage<?> page) {
        table.setTablePage(id, page);
    }

    @Override
    public void removeTableData(String id) {
        table.removeTableData(id);
    }

    @Override
    public void setSuccess(boolean bool) {
        this.success = bool;
    }

    @Override
    public String toJson() {
        String msgType = this.getMessageType();
        String msg = this.getMessage();
        StringBuilder sb = new StringBuilder();
        sb.append("{").append("\"success\":\"").append(this.success).append("\"");
        //添加消息串
        if (msg != null) {
            sb.append(",\"message\":\"").append(msg).append("\"");
            if (msgType != null && !"".equals(msgType)) {
                sb.append(",\"messageType\":\"").append(msgType).append("\"");
            }
        }

        //添加test数据串
        if (MapUtil.isNotEmpty(getInputsData())) {
            sb.append(",\"inputData\":").append(JsonUtil.toJSON(getInputsData())).append("");
        }

        //设置焦点串
        if (this.focus != null && !"".equals(this.focus)) {
            sb.append(",\"focus\":\"").append(this.focus).append("\"");
        }

        //设置属性串
        if (this.getProperty() != null && this.getProperty().size() > 0) {
            sb.append(",\"operation\":").append(JsonUtil.toJSON(getProperty())).append("");
        }

        //设置表格串
        Iterator iterator;
        boolean noFirst;
        Entry next;
        if (this.table != null && this.table.getTablesPageData().size() > 0) {
            sb.append(",\"tableData\":{");
            iterator = this.table.getTablesPageData().entrySet().iterator();

            for (noFirst = false; iterator.hasNext(); noFirst = true) {
                next = (Entry) iterator.next();
                if (noFirst) {
                    sb.append(",");
                }

                sb.append("\"").append((String) next.getKey()).append("\":")
                        .append(JsonUtil.toJSON(next.getValue()));
            }

            sb.append("}");
        }

        //设置下拉框串
        if (this.select != null && this.select.getSelectData().size() > 0) {
            sb.append(",\"selectData\":{");
            iterator = this.select.getSelectData().entrySet().iterator();

            for (noFirst = false; iterator.hasNext(); noFirst = true) {
                next = (Entry) iterator.next();
                if (noFirst) {
                    sb.append(",");
                }

                sb.append("\"").append((String) next.getKey()).append("\":")
                        .append(JsonUtil.toJSON(next.getValue()));
            }

            sb.append("}");
        }

        sb.append("}");
        return sb.toString();
    }

    @Override
    public Map<String, TreeVO> getTreeData() {
        return tree.getTreeData();
    }

    @Override
    public TreeVO getTreeDataById(String id) {
        return tree.getTreeDataById(id);
    }

    @Override
    public void setTreeData(String id, TreeVO treeVO) {
        tree.setTreeData(id, treeVO);
    }

    @Override
    public void removeTreeData(String id) {
        tree.removeTreeData(id);
    }

    @Override
    public String treeToJson(String id) {
        return tree.treeToJson(id);
    }

}
