package org.smart.plugin.common;

import groovy.ui.SystemOutputInterceptor;
import org.activiti.engine.runtime.ProcessInstance;
import org.mvc.base.Sequence;
import org.mvc.ty.common.vo.UserInformationVO;
import org.mvc.ty.start.StartHelper;
import org.plugin.activiti.base.BaseActiviti;
import org.plugin.activiti.vo.ActYwVO;
import org.plugin.activiti.vo.RollbackHtmlVO;
import org.plugin.cache.smart.Cache;
import org.plugin.mongdb.MongDBHelper;
import org.plugin.security.SecurityHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.framework.dao.DatabaseHelper;
import org.smart.framework.ioc.BeanHelper;
import org.smart.framework.mvc.DataContext;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Transaction;
import org.smart.framework.util.JsonUtil;
import org.smart.plugin.common.web.pagebean.IPageBean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class ActivitiBPMN {

    protected Logger logger = LoggerFactory.getLogger(getClass());


    public void initActiviti() {
        String actionName = this.getClass().getName();
        String action = actionName.toLowerCase().substring(actionName.lastIndexOf(".") + 1, actionName.indexOf("$"));
        ActYwVO actYwVO = DatabaseHelper.queryEntity(ActYwVO.class, "select * from act_yw where Lower(action)=?", action);
        Cache<Object, Object> cache = StartHelper.getCache();
        UserInformationVO userInformationVO = (UserInformationVO) cache.get("userInfo");
        IPageBean pageBean = (IPageBean) DataContext.getRequest().getAttribute("_DATA_BEAN");
        pageBean.setData("bpmn_user_name", userInformationVO.getOperator());//经办人姓名
        pageBean.setData("bpmn_user_id", userInformationVO.getUsername());//经办人id
        pageBean.setData("bpmn_user_email", userInformationVO.getEmail());//经办人邮箱
        if (actYwVO != null) {
            pageBean.setData("bpmn_service", actYwVO.getService());//设置service
            pageBean.setData("bpmn_page", actYwVO.getPage());//设置任务名
            pageBean.setData("bpmn_model", actYwVO.getModel());//设置模型名
        }
    }

    /**
     * 调用service的saveYw方法
     */
    private Object callServiceSave(String service, Params params) throws Exception {
        try {
            Map<Class<?>, Object> services = BeanHelper.getServiceBeanMap(service);
            for (Map.Entry<Class<?>, Object> servicebean : services.entrySet()) {
                Class<?> cls = servicebean.getKey();
                Object obj = servicebean.getValue();
                Method method = cls.getMethod("saveYw", Params.class);
                method.setAccessible(true);
                return method.invoke(obj, params);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new Exception(e);
        }
        return null;
    }

    /**
     * 调用service的checkYw方法
     *
     * @param service
     */
    public void callServiceCheckYw(String service, String taskId) throws Exception {
        try {
            Map<Class<?>, Object> services = BeanHelper.getServiceBeanMap(service);
            for (Map.Entry<Class<?>, Object> servicebean : services.entrySet()) {
                Class<?> cls = servicebean.getKey();
                Object obj = servicebean.getValue();
                Method method = cls.getMethod("checkYw", String.class);
                method.setAccessible(true);
                method.invoke(obj, taskId);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new Exception(e);
        }
    }


    /**
     * 调用service的revocateYw方法
     *
     * @param service
     */
    public Object callServiceRevocateYw(String service, String taskId) throws Exception {
        try {
            Map<Class<?>, Object> services = BeanHelper.getServiceBeanMap(service);
            for (Map.Entry<Class<?>, Object> servicebean : services.entrySet()) {
                Class<?> cls = servicebean.getKey();
                Object obj = servicebean.getValue();
                Method method = cls.getMethod("revocateYw", String.class);
                method.setAccessible(true);
                return method.invoke(obj, taskId);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new Exception(e);
        }
        return null;
    }

    /**
     * 调用service的rollback方法
     *
     * @param service
     */
    public void callServiceRollbackYw(String service, String taskId) throws Exception {
        try {
            Map<Class<?>, Object> services = BeanHelper.getServiceBeanMap(service);
            for (Map.Entry<Class<?>, Object> servicebean : services.entrySet()) {
                Class<?> cls = servicebean.getKey();
                Object obj = servicebean.getValue();
                Method method = cls.getMethod("rollbackYw", String.class);
                method.setAccessible(true);
                method.invoke(obj, taskId);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new Exception(e);
        }
    }


    /**
     * 启动实例
     *
     * @param params
     */
    public Object process(Params params) throws Exception {
        Object obj = null;
        try {
            DatabaseHelper.beginTransaction();
            String model = params.getString("bpmn_model");
            String businessId = Sequence.getBusiness();
            // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
            // IdentityService中提供了SetAuthenticatedUserId方法用于将用户ID设置到当前的线程中
            BaseActiviti.getIdentityService().setAuthenticatedUserId(SecurityHelper.getUsername());
            //BaseActiviti.getTaskService().addCandidateGroup("salesmane");
            Map<String, Object> variables = new HashMap<>();
            variables.put("userId", "zhangsan,lisi");
            //ProcessInstance processInstance = BaseActiviti.getRuntimeService().startProcessInstanceByKey(model, businessId, variables);
            ProcessInstance processInstance = BaseActiviti.getRuntimeService().startProcessInstanceByKey(model, businessId);
            //将业务id添加到业务数据表中
            params.put("businessId", businessId);
            //将流程id添加到业务数据表中
            params.put("processInstanceId", processInstance.getId());
            // String json=JsonUtil.toJSON(params.getString("bpmn_form_html"));
            // MongDBHelper.put(businessId,json);
            saveHtml(businessId, removeScript(params.getString("bpmn_form_html")), params.getString("bpmn_service"));
            obj = callServiceSave(params.getString("bpmn_service"), params);
            DatabaseHelper.commitTransaction();
        } catch (Exception e) {
            DatabaseHelper.rollbackTransaction();
            throw new Exception(e);
        }
        return obj;
    }

    protected void saveHtml(String businessId, String html, String serivce) {
        String sql = "insert into bu_html(business_id,html,service)values(?,?,?)";
        DatabaseHelper.insertReturnPK(sql, businessId, html, serivce);
    }

    protected RollbackHtmlVO getHtml(String businessId) {
        String sql = "select business_id,html,service from bu_html where business_id=?";
        return DatabaseHelper.queryEntity(RollbackHtmlVO.class, sql, businessId);
    }

    private String removeScript(String html) {
        html = html.replaceAll("(?i)(<SCRIPT)[\\s\\S]*?((</SCRIPT>)|(/>))", "");//忽略大小写的正则
        html = html.replaceAll("^> +<$", "");
        html = html.replaceAll("\r\n", "");
        return html;
    }


}
