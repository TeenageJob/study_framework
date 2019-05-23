<%@ tag import="org.smart.framework.util.StringUtil" %>
<%@ tag import="org.smart.plugin.common.web.pagebean.IPageBean" %>
<%@ tag import="org.smart.plugin.common.util.PageUtil" %>
<%@tag language="java" pageEncoding="UTF-8"
       trimDirectiveWhitespaces="true" %>
<%@attribute name='name' type='java.lang.String'
             description='' %>
<%@attribute name='labelStyle' type='java.lang.String'
             description='' %>
<%@attribute name='span' type='java.lang.String'
             description='' %>
<%@attribute name='id' type='java.lang.String' required="true"
             description='' %>
<%@attribute name='width' type='java.lang.String'
             description='' %>
<%@attribute name='cssStyle' type='java.lang.String'
             description='' %>
<%@attribute name='value' type='java.lang.String'
             description='' %>
<%@attribute name='cssClass' type='java.lang.String'
             description='' %>
<%@attribute name='onBlur' type='java.lang.String'
             description='' %>
<%@attribute name='onChange' type='java.lang.String'
             description='' %>
<%@attribute name='onClick' type='java.lang.String'
             description='' %>
<%@attribute name='onFocus' type='java.lang.String'
             description='' %>
<%@attribute name='onKeydown' type='java.lang.String'
             description='' %>
<%@attribute name='readOnly' type='java.lang.String'
             description='' %>
<%@attribute name='disabled' type='java.lang.String'
             description='' %>

<%@attribute name='format' type='java.lang.String'
             description="默认值: 'mm/dd/yyyy'" %>
<%@attribute name='weekStart' type='java.lang.String'
             description="Integer. 默认值：0一周从哪一天开始。0（星期日）到6（星期六）" %>
<%@attribute name='startDate' type='java.lang.String'
             description="日期。默认值：开始时间可能选择的最早日期; 所有较早的日期将被禁用。" %>
<%@attribute name='endDate' type='java.lang.String'
             description="日期。默认值：结束时间可能选择的最新日期; 所有以后的日期将被禁用。" %>
<%@attribute name='daysOfWeekDisabled' type='java.lang.String'
             description="应该禁用的星期几。值为0（星期日）至6（星期六）。多个值应该用逗号分隔。例如：禁用周末：'0,6'或[0,6]。" %>
<%@attribute name='startView' type='java.lang.String'
             description="数字，字符串。默认值：2，'月'日期时间选择器打开之后首先显示的视图。可接受的值：小时视图为0或'小时'1或'日'为日视图2或月份视图（默认）3或“年”为12个月的概述4年或10年概览的“十年”。对于datetime datetimepickers很有用" %>
<%@attribute name='minView' type='java.lang.String'
             description="日期时间选择器所能够提供的最精确的时间选择视图。" %>
<%@attribute name='initialDate' type='java.lang.String'
             description="您可以使用日期初始化查看器" %>
<%@attribute name='showMeridian' type='java.lang.String'
             description="该选项将启用经络观点day和hour观点。" %>
<%@attribute name='viewSelect' type='java.lang.String'
             description="使用此选项，您可以选择将从中选择日期的视图。默认情况下它是最后一个，但是您可以选择第一个，所以每次点击时都会更新日期。" %>
<%@attribute name='pickerPosition' type='java.lang.String'
             description="此选项当前只在组件实现中提供支持。通过设置选项可以讲选择器放倒输入框下方" %>
<%@attribute name='minuteStep' type='java.lang.String'
             description="此数值被当做步进值用于构建小时视图。每个对于minuteStep都会生成一组预设时间（分钟）用于选择" %>
<%@attribute name='forceParse' type='java.lang.String'
             description="当选择器关闭的时候，是否强制解析输入框中的值。也就是说，当用户在输入框中输入了不正确的日期，选择器将会尽量解析输入的值，并将解析后的正确值给按照定的格式format设置到输入侧框中。" %>
<%@attribute name='keyboardNavigation' type='java.lang.String'
             description="是否允许通过方向键改变日期。" %>
<%@attribute name='todayHighlight' type='java.lang.String'
             description="如果为true，高亮当前日期。" %>
<%@attribute name='todayBtn' type='java.lang.String'
             description="如果此值为true或“linked”，则在日期时间选择器组件的底部显示一个“Today”按钮用于选择当前日期。如果是true的话，“Today”按钮仅仅将视图转到当天的日期，如果是 “链接”，当天日期将会被选中。" %>
<%@attribute name='autoclose' type='java.lang.String'
             description="当选择一个日期之后是否立即关闭此日期时间选择器" %>
<%@attribute name='maxView' type='java.lang.String'
             description="日期时间选择器最高能展示的选择范围视图。" %>
<%@attribute name='language' type='java.lang.String'
             description="用于月份和日期名称的双字母语言代码。这些也将被用作输入的值（并且在表单提交的情况下随后被发送到服务器）。目前有英语（'en'），德语（'de'），巴西（'br'）和西班牙语（'es'）翻译的船只，但也可以添加其他语言（见下面的I18N）。如果给出未知的语言代码，将使用英语。" %>
<%@attribute name='required' type='java.lang.String'
             description="是否必填" %>
<%
    //获取后台传来数据
    IPageBean pageBean = PageUtil.getPageBean();
    value = "";
    if (!StringUtil.isEmpty(id)) {
        String val = pageBean.getData(id).toString();
        value = "false".equals(val) ? "" : val;
    }
%>
<div class=".col-md- form-inline form-group colorpicker-component" id="${id }_div"
        <%if (StringUtil.isNotEmpty(span)) { %> span="<%=span %>" <%} else { %>
     span="1" <%} %>>
    <% if (StringUtil.isNotEmpty(name)) {%>
    <label class="label-css" style="<%=labelStyle%>;width:90px;text-align:right;font-size: 12px">${name}：</label>
    <%}%>
    <input type="text" class="form-control"
           id="${id}" name="${id}"
        <% if (StringUtil.isNotEmpty(value)) {%>
           value="<%=value %>"
        <%} else {%>
           value="${value }"
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
        <% if (onKeydown != null) {%>
           onKeydown="<%=onKeydown %>" <%}%>
        <% if (readOnly != null) {%>
           readOnly="<%=readOnly %>" <%}%>
        <% if (disabled != null) {%>
           disabled="<%=disabled %>" <%}%>
        <%if (StringUtil.isNotEmpty(width)) {%>
           style="width:${width};<%=cssStyle %>"
        <%} else {%>
           style="width:160px;<%=cssStyle %>"
        <%}%>
        <% if (StringUtil.isNotEmpty(format)) {%>
           format="${format}"
        <%}%>
        <% if (StringUtil.isNotEmpty(weekStart)) {%>
           weekStart="${weekStart}"
        <%}%>
        <% if (StringUtil.isNotEmpty(startDate)) {%>
           startDate="${startDate}"
        <%}%>
        <% if (StringUtil.isNotEmpty(endDate)) {%>
           endDate="${endDate}"
        <%}%>
        <% if (StringUtil.isNotEmpty(daysOfWeekDisabled)) {%>
           daysOfWeekDisabled="${daysOfWeekDisabled}"
        <%}%>
        <% if (StringUtil.isNotEmpty(autoclose)) {%>
           autoclose="${autoclose}"
        <%}%>
        <% if (StringUtil.isNotEmpty(startView)) {%>
           startView="${startView}"
        <%}%>
        <% if (StringUtil.isNotEmpty(minView)) {%>
           minView="${minView}"
        <%}%>
        <% if (StringUtil.isNotEmpty(maxView)) {%>
           maxView="${maxView}"
        <%}%>
        <% if (StringUtil.isNotEmpty(todayBtn)) {%>
           todayBtn="${todayBtn}"
        <%}%>
        <% if (StringUtil.isNotEmpty(todayHighlight)) {%>
           todayHighlight="${todayHighlight}"
        <%}%>
        <% if (StringUtil.isNotEmpty(keyboardNavigation)) {%>
           keyboardNavigation="${keyboardNavigation}"
        <%}%>
        <% if (StringUtil.isNotEmpty(language)) {%>
           language="${language}"
        <%}%>
        <% if (StringUtil.isNotEmpty(forceParse)) {%>
           forceParse="${forceParse}"
        <%}%>
        <% if (StringUtil.isNotEmpty(minuteStep)) {%>
           minuteStep="${minuteStep}"
        <%}%>
        <% if (StringUtil.isNotEmpty(pickerPosition)) {%>
           pickerPosition="${pickerPosition}"
        <%}%>
        <% if (StringUtil.isNotEmpty(viewSelect)) {%>
           viewSelect="${viewSelect}"
        <%}%>
        <% if (StringUtil.isNotEmpty(showMeridian)) {%>
           showMeridian="${showMeridian}"
        <%}%>
        <% if (StringUtil.isNotEmpty(initialDate)) {%>
           initialDate="${initialDate}"
        <%}%>



        <% if (required != null) {%>
           required="<%=required %>" <%}%>
    >
</div>

<script type="text/javascript">
    var $this = $("#${id}");
    var nodes = {};
    nodes.language = $this.attr("weekStart") == null ? 'zh-CN' : $this.attr("weekStart");
    nodes.format = $this.attr("format") == null ? 'yyyy-mm-dd' : $this.attr("format");
    nodes.weekStart = $this.attr("weekStart");
    nodes.startDate = $this.attr("startDate");
    nodes.endDate = $this.attr("endDate");
    nodes.daysOfWeekDisabled = $this.attr("daysOfWeekDisabled");
    nodes.autoclose = $this.attr("autoclose") == null ? 1 : eval($this.attr("autoclose"));
    nodes.startView = $this.attr("startView") == null ? 2 : eval($this.attr("startView"));
    nodes.minView = $this.attr("minView") == null ? 2 : eval($this.attr("minView"));
    nodes.maxView = $this.attr("maxView");
    nodes.todayBtn = $this.attr("todayBtn") == null ? true : eval($this.attr("todayBtn"));
    nodes.todayHighlight = $this.attr("todayHighlight") == null ? true : eval($this.attr("todayHighlight"));
    nodes.keyboardNavigation = $this.attr("keyboardNavigation");
    nodes.forceParse = $this.attr("forceParse");
    nodes.minuteStep = $this.attr("minuteStep");
    nodes.pickerPosition = $this.attr("pickerPosition");
    nodes.viewSelect = $this.attr("viewSelect");
    nodes.showMeridian = $this.attr("showMeridian");
    nodes.initialDate = $this.attr("initialDate");
    for (var key in nodes) {
        if (nodes[key] == null || nodes[key] == "") {
            delete nodes[key];
        }
    }
    $('#${id}').datetimepicker(nodes);
    //onchange事件
    $this.datetimepicker().on('changeDate', function (ev) {
        var onchange = $("#${id}").attr("onChange");
        var value=$("#${id}").val();
        if (onchange != null && onchange != "") {
            onchange=eval(onchange);
            onchange.call(this,ev,value);
        }
    })
    ;



    var nodes = {
        validators: {
            notEmpty: {
                message: '*'
            },
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
    $("#form_1").bootstrapValidator("addField", "${id}", nodes);


    var id =${id};
    if (id != "" && id != null) {
        var span_1 = parseFloat($("#${id}").parent().parent().attr("cols"));
        var span_2 = $("#${id}_div").attr("span");
        var span = parseFloat(span_2) / parseFloat(span_1);
        $("#${id}_div").attr("style",
            "flex:0 0 " + span * 100 + "%");
    }
</script>