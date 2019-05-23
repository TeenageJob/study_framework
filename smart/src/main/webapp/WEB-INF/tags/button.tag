<%@tag import="org.smart.framework.util.StringUtil" %>
<%@tag import="org.smart.plugin.common.util.PageUtil" %>
<%@tag import="org.smart.plugin.common.web.pagebean.IPageBean" %>
<%@ tag import="java.util.List" %>
<%@ tag import="org.smart.framework.util.CollectionUtil" %>
<%@tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<%--@doc--%>
<%@tag description='button按钮' display-name='button' %>
<%@attribute name="width" type="java.lang.String" description="按钮长度"  %>
<%@attribute name="span" type="java.lang.String" description="占格" %>
<%@attribute name='hotKey' type='java.lang.String'
             description='热键，如果只输入一个英文字母默认是alt+字母的组合，还可以输入ctrl+s这样的值' %>
<%@attribute name='icon' type='java.lang.String'
             description='设置按钮图标:例如icon="icon-edit"' %>
<%@attribute name='asToolBarItem' type='java.lang.String'
             description='true/false,设置button为toolbar按钮样式，默认为false' %>
<%@attribute name='toolTip' type='java.lang.String'
             description='鼠标移过提示文本' %>
<%@attribute name='display' type='java.lang.String'
             description='设置是否显示，默认为显示:true' %>
<%@attribute name='id' type='java.lang.String' description='设置组件id，页面唯一' required="true" %>
<%@attribute name='name' type='java.lang.String'
             description='设置标题，不支持html格式文本' %>
<%@attribute name='cssClass' type='java.lang.String'
             description='给该组件添加自定义样式class，如:cssClass="no-padding"' %>
<%@attribute name='cssStyle' type='java.lang.String'
             description='给该组件添加自定义样式，如:cssStyle="padding-top:10px"' %>
<%@attribute name='disabled' type='java.lang.String'
             description='设置页面初始化的时候改组件不可用，同时表单提交时不会传值到后台' %>
<%@attribute name='onClick' type='java.lang.String'
             description='单击事件，例如:onClick="fnOnClick()",在javascript中，function fnOnClick(){alert(111)}' %>
<%@attribute name='columnWidth' type='java.lang.String'
             description='设置layout为column布局的时候自定义占用宽度百分比，可设置值为0-1之间的小数，如:0.1' %>
<%@attribute name='bpopTipMsg' type='java.lang.String'
             description='鼠标移过输入对象pop提示文本' %>
<%@attribute name='bpopTipWidth' type='java.lang.String'
             description='鼠标移过输入对象pop提示文本框的固定宽度，默认自适应大小' %>
<%@attribute name='bpopTipHeight' type='java.lang.String'
             description='鼠标移过输入对象pop提示文本框的固定高度，默认自适应大小' %>
<%@attribute name='bpopTipPosition' type='java.lang.String'
             description='鼠标移过输入对象pop提示文本框的默认位置{top,left,right,bottom}，默认top' %>
<%@attribute name='isok' type='java.lang.String'
             description='按钮样式，是否为确认类型，比如保存，更新等操作，默认false，只适用于163风格' %>
<%@attribute name='isShowIcon' type='java.lang.String'
             description='是否在新样式按钮上显示图标，默认false，不显示' %>
<%@attribute name='fieldsAuthorization' type='java.lang.String'
             description='是否需要权限控制' %>
<%@attribute name="type" type="java.lang.String"
             description='选择按钮类型：buttton submit' %>
<%--@doc--%>

<%
    IPageBean pageBean = PageUtil.getPageBean();
    List<String> list = pageBean.getPropertyById(id);
    if (CollectionUtil.isNotEmpty(list)) {
        for (String key : list) {
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
                    break;
            }
        }
    }
%>
<div id="${id}_div"
        <%if (StringUtil.isNotEmpty(span)) { %> span="<%=span %>" <%} else { %>
     span="1" <%} %> >
    <input id="${id}" class="btn btn-info" value="${name}" data-loading-text="Loading..."
           style="width:100px;" type="button"
            <% if (onClick != null) {%> onClick="<%=onClick %>"
            <%}%> />
</div>
<script type="text/javascript">
    var id = ${id}+"";
    if (id != "" && id != null) {
        var span_1 = parseFloat($("#${id}_div").parent().attr("cols"));
        var span_2 = $("#${id}_div").attr("span");
        var span = parseFloat(span_2) / parseFloat(span_1);
        $("#${id}_div").attr("style",
            "flex:0 0 " + span * 100 + "%;${cssStyle}");
    }
</script>