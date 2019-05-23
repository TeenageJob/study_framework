<%@ tag import="org.smart.plugin.common.web.pagebean.IPageBean" %>
<%@ tag import="org.smart.plugin.common.util.PageUtil" %><%--
  Created by IntelliJ IDEA.
  User: tianyuan
  Date: 2018/3/12
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@tag language="java" pageEncoding="UTF-8"
       trimDirectiveWhitespaces="true" %>
<%
    IPageBean pageBean = PageUtil.getPageBean();
    String bpmn_service= (String) pageBean.getData("bpmn_service");
    String bpmn_page=(String)pageBean.getData("bpmn_page");
    String bpmn_model=(String)pageBean.getData("bpmn_model");
    String bpmn_user_name=(String)pageBean.getData("bpmn_user_name");
    String bpmn_user_id=(String)pageBean.getData("bpmn_user_id");
    String bpmn_user_email=(String)pageBean.getData("bpmn_user_email");
%>

<input name="bpmn_service" type="hidden" value="<%=bpmn_service%>" descript="service 值"/>
<input name="bpmn_page" type="hidden" value="<%=bpmn_page%>" descript="那个任务页面"/>
<input name="bpmn_model" type="hidden" value="<%=bpmn_model%>" descript="业务模型"/>
<input name="bpmn_user_name" type="hidden" value="<%=bpmn_user_name%>" descript="经办人姓名"/>
<input name="bpmn_user_id" type="hidden" value="<%=bpmn_user_id%>" descript="经办人id"/>
<input name="bpmn_user_email" type="hidden" value="<%=bpmn_user_email%>" descript="经办人邮箱"/>
<input name="bpmn_form_html" id="bpmn_form_html" type="hidden" value="" descript=""/>
<input name="" type="hidden" value="" descript=""/>
<input name="" type="hidden" value="" descript=""/>
<input name="" type="hidden" value="" descript=""/>
<input name="" type="hidden" value="" descript=""/>





