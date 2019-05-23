<%@ tag import="org.smart.plugin.common.web.pagebean.impl.PageBean" %>
<%@ tag import="org.smart.plugin.common.util.PageUtil" %>
<%@ tag import="java.util.List" %>
<%@ tag import="org.smart.framework.util.CollectionUtil" %>
<%@ tag import="org.smart.framework.util.StringUtil" %>
<%@tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<%--@doc--%>
<%@tag description='checkbox组件' display-name="checkbox" %>
<%@attribute description='id，设置是否不可用' name='id' type='java.lang.String' %>
<%@attribute description='名称，设置是否不可用' name='name' type='java.lang.String' %>
<%@attribute description='值' name='value' type='java.lang.String' %>
<%@attribute description='另外值' name='val' type='java.lang.String' %>
<%@attribute description='onchange事件' name='onchange' type='java.lang.String' %>
<%
    PageBean pageBean = PageUtil.getPageBean();
    List<String> list = pageBean.getPropertyById(id);
    String readonly, disabled, hide, enable, show, required, disrequired, focus, checked = "";
    List<String> propertyList = pageBean.getPropertyById(id);
    if (CollectionUtil.isNotEmpty(propertyList)) {
        for (String key : propertyList) {
            switch (key) {
                case "readonly":
                    break;
                case "disabled":
                    break;
                case "hide":
                    break;
                case "enable":
                    break;
                case "show":
                    break;
                case "required":
                    break;
                case "disrequired":
                    break;
                case "focus":
                    break;
                case "checked":
                    checked = "checked";
                    break;
            }
        }
    }

%>
<%--@doc--%>
<div id="${id}_div" span="1">
    <label class="checkbox-inline checkbox-css">
        <input type="checkbox" name="${id}" aid="${name}" id="${id}" value="${value}"
            <%if(StringUtil.isNotEmpty(checked)){%>
               checked="<%=checked%>"
            <%}%>
               val="${val}"
        >${name}
    </label>
</div>
<script type="text/javascript">
    var span_1 = parseFloat($("#${id}_div").parent().attr("cols"));
    var span_2 = $("#${id}_div").attr("span");
    var span = parseFloat(span_2) / parseFloat(span_1);
    $("#${id}_div").attr("style",
        "margin-top:15px;flex:0 0 " + span * 100 + "%");
</script>