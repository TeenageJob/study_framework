<%@tag import="org.smart.plugin.common.web.pagebean.IPageBean" %>
<%@tag import="org.smart.framework.util.MapUtil" %>
<%@tag import="org.smart.framework.util.ValidataUtil" %>
<%@tag import="org.smart.framework.mvc.DataContext" %>
<%@tag import="java.util.Map" %>
<%@tag import="org.smart.plugin.common.util.PageUtil" %>
<%@tag language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="c" %>
<%@tag import="org.smart.framework.util.StringUtil" %>
<%@ tag import="java.util.List" %>
<%@ tag import="org.smart.framework.util.CollectionUtil" %>


<%--@doc--%>
<%@tag description='文本框' display-name="text" %>
<%@attribute name="icon" type="java.lang.String" description="是否显示图标" required="false" %>
<%@attribute name="colorpicker" type="java.lang.String" description="是否将输入框作为颜色板" %>
<%@attribute name='columnWidth' type='java.lang.String'
             description='设置layout为column布局的时候自定义占用宽度百分比，可设置值为0-1之间的小数，如:0.1' %>
<%@attribute name='width' type='java.lang.String'
             description='with' %>
<%@attribute name='cssClass' type='java.lang.String'
             description='给该组件添加自定义样式class，如:cssClass="no-padding"' %>
<%@attribute name='cssStyle' type='java.lang.String'
             description='给该组件添加自定义样式，如:cssStyle="padding-top：10px"' %>
<%@attribute name='disabled' type='java.lang.String'
             description='设置页面初始化的时候改组件不可用，同时表单提交时不会传值到后台' %>
<%@attribute name='display' type='java.lang.String'
             description='设置是否显示，默认为显示：true' %>
<%@attribute name='id' required='true' type='java.lang.String'
             description='组件id页面唯一' %>
<%@attribute name='toolTip' type='java.lang.String'
             description='当required属性为true时，设置默认错误提示信息' %>
<%@attribute name='name' type='java.lang.String'
             description='组件的label标签' %>
<%@attribute name='onBlur' type='java.lang.String'
             description='onBlur事件，当失去焦点时调用，此处填写函数调用如onBlur="fnBlur(this)"' %>
<%@attribute name='onChange' type='java.lang.String'
             description='onChange事件，当文本框值发生改变并失去焦点时调用，此处填写函数调用如onChange="fnChange(this)"' %>
<%@attribute name='onClick' type='java.lang.String'
             description='onClick事件，当单击控件时调用，此处填写函数调用如onClick="fnClick(this)"' %>
<%@attribute name='onFocus' type='java.lang.String'
             description='onFocus事件，当控件获取焦点时，此处填写函数调用如onFocus="fnFocus(this)"' %>
<%@attribute name='required' type='java.lang.String'
             description='true/false,设置是否必输，默认false，设置后代小红星' %>
<%@attribute name='span' type='java.lang.String'
             description='当该容器被父容器作为column方式布局的时候，设置span表明当前组件需要占用多少列，如span=‘2’表示跨两列' %>
<%@attribute name='value' type='java.lang.String'
             description='组件页面初始化的时候的默认值' %>
<%@attribute name='labelWidth' type='java.lang.String'
             description='label占的宽度，如labelWidth="120"' %>
<%@attribute name='labelStyle' type='java.lang.String'
             description='label自定义样式' %>
<%@attribute name='maxLength' type='java.lang.String'
             description='最大字符数' %>
<%@attribute name='max' type='java.lang.String'
             description='最大字符数' %>
<%@attribute name='min' type='java.lang.String'
             description='最小字符数' %>
<%@attribute name='minLength' type='java.lang.String'
             description='最小字符数' %>
<%@attribute name='readOnly' type='java.lang.String'
             description='true/false,设置为只读，默认为false' %>
<%@attribute name='type' type='java.lang.String'
             description='可以设置input元素的类型，如：password，text，file等，默认text' %>
<%@attribute name='diff' type='java.lang.String'
             description='设置必须有不同的内容' %>
<%@attribute name='placeholder' type='java.lang.String'
             description='提示文字' %>
<%@attribute name='email' type='java.lang.String'
             description='验证邮箱' %>
<%@attribute name='equals' type='java.lang.String'
             description='验证邮箱' %>
<%@attribute name='inputType' type='java.lang.String'
             description='输入要验证的类型：NoChainese,number,自己写' %>
<%@attribute name='url' type='java.lang.String'
             description=' 验证数据库是否有该值' %>
<%-- @doc --%>


<%
    //获取后台传来数据
    IPageBean pageBean = PageUtil.getPageBean();
    //判断id是否为空
    value = "";
    if (!StringUtil.isEmpty(id)) {
        String val = pageBean.getData(id).toString();
        value = "false".equals(val) ? "" : val;
    }
    if ("false".equals(display) || "none".equals(display)) {
        if (cssStyle == null) {
            cssStyle = "display:none;";
        } else {
            cssStyle += ";display:none;";
        }
    }

    if (StringUtil.isEmpty(type)) {
        type = "text";
    }

    if (null != cssClass) {
        cssClass = "form-control " + cssClass;
    } else {
        cssClass = "form-control";
    }
    if (null != labelWidth) {
        labelStyle += " width:" + labelWidth + "px;";
    }

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
                    break;
            }
        }
    }

    String readonly = MapUtil.isContainValue(pageBean.getProperty(), id, "readonly") ? "true" : null;
    if (ValidataUtil.isEmpty(readonly)) {
        if ("true".equals(readOnly)) {
            readOnly = "readonly";
        }
    } else {
        readOnly = "readonly";
    }
    String disableds = MapUtil.isContainValue(pageBean.getProperty(), id, "disabled") ? "disabled" : "";
    if (!ValidataUtil.isEmpty(disableds)) {
        disabled = "disabled";
    }
%>
<div class=".col-md- form-inline form-group colorpicker-component" id="${id }_div"
        <%if (StringUtil.isNotEmpty(span)) { %> span="<%=span %>" <%} else { %>
     span="1" <%} %>>
    <% if (StringUtil.isNotEmpty(name)) {%>
    <label class="label-css" style="<%=labelStyle%>;width:90px;text-align:right;font-size: 12px">${name}：</label>
    <%}%>
    <input
            id="${id}" name="${id}" class="form-control ${cssClass}"
            type="<%=type %>"
            <% if (StringUtil.isNotEmpty(value)) {%>
            value="<%=value %>"
            <%} else {%>
            value="${value }"
            <%} %>
            <% if (StringUtil.isNotEmpty(diff)) {%>
            diff="<%=diff %>"
            <%} else {%>
            diff="${diff }"
            <%} %>
            <% if (StringUtil.isNotEmpty(email)) {%>
            email="<%=email %>"
            <%} else {%>
            email="${email }"
            <%} %>
            <% if (StringUtil.isNotEmpty(equals)) {%>
            equals="<%=equals %>"
            <%} else {%>
            equals="${equals }"
            <%} %>
            <% if (StringUtil.isNotEmpty(inputType)) {%>
            inputType="<%=inputType %>"
            <%} else {%>
            inputType="${inputType }"
            <%} %>
            <% if (StringUtil.isNotEmpty(url)) {%>
            url="<%=url %>"
            <%} else {%>
            url="${url }"
            <%} %>
            <% if (cssClass != null) {%>
            class="form-control <%=cssClass %>" <%}%>
            <% if (onBlur != null) {%>
            onBlur="<%=onBlur %>" <%}%>
            <% if (onChange != null) {%>
            onChange="<%=onChange %>" <%}%>
            <% if (onClick != null) {%>
            onClick="<%=onClick %>" <%}%>
            <% if (onFocus != null) {%>
            onFocus="<%=onFocus %>" <%}%>
            <% if (maxLength != null) {%>
            maxLength="<%=maxLength %>"   <%} %>
            <% if (max != null) {%>
            max="<%=max %>"   <%} %>
            <% if (min != null) {%>
            min="<%=min %>" <%}%>
            <% if (minLength != null) {%>
            minLength="<%=minLength %>" <%}%>
            <% if (readOnly != null) {%>
            readOnly="<%=readOnly %>" <%}%>
            <% if (disabled != null) {%>
            disabled="<%=disabled %>" <%}%>
            <% if (required != null) {%>
            required="<%=required %>" <%}%>
            <% if (placeholder != null) {%>
            placeholder="<%=placeholder %>" <%}%>
            <%if (StringUtil.isNotEmpty(width)) {%>
            style="width:${width};<%=cssStyle %>"
            <%} else {%>
            style="width:160px;<%=cssStyle %>"
            <%}%>
            colorpicker="${colorpicker}"
    />
    <%if (StringUtil.isNotEmpty(icon) && icon.equalsIgnoreCase("true")) {%>
    <button id="${id}_btn" class="btn btn-default" data-placement="top" data-icon="glyphicon-bold"
            style="margin-left:-68px;margin-top:-2px;border: none;" role="iconpicker"/>
    <%}%>
    <%if (StringUtil.isNotEmpty(colorpicker) && colorpicker.equalsIgnoreCase("true")) {%>
    <span class="form-control input-group-addon"
          style="margin-left: -45px;  padding-top: 8px;background-color:transparent;border: none "><i></i></span>
    <%}%>
</div>
<script type="text/javascript">

    $(function () {
        init();
        //$('#${id}_btn').iconpicker();
    });

    function init() {
        var s = ${colorpicker}+"";
        if (s != "" && s == "true") {
            $("#${id }_div").colorpicker();
        }

    }

    $("#${id}_btn").on('change', function (e) {
        if (e != undefined && e.icon != "undefined") {
            $("#${id}").val(e.icon);
        }
    });
    var nodes = {
        validators: {
            stringLength: {
                min: $("#${id}").attr("minLength") == null ? 0 : eval($("#${id}").attr("minLength")),
                max: $("#${id}").attr("maxLength") == null ? 100 : eval($("#${id}").attr("maxLength")),
                message: '*'
            },
            regexp: {
                regexp: ($("#${id}").attr("inputType") == "number" ? /^[0-9_\.]+$/ :
                    $("#${id}").attr("inputType") == "NoChainese" ? /^[a-zA-Z0-9_\.]+$/ : $("#${id}").attr("inputType")),
                message: '*'
            }
        }
    }
    $("#form_ty").bootstrapValidator("addField", "${id}", nodes);
</script>


<script>
    var id =${id};
    if (id != "" && id != null) {
        var span_1 = parseFloat($("#${id}").parent().parent().attr("cols"));
        var span_2 = $("#${id}_div").attr("span");
        var span = parseFloat(span_2) / parseFloat(span_1);
        $("#${id}_div").attr("style",
            "flex:0 0 " + span * 100 + "%;");
    }
</script>
