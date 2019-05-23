<%@tag import="org.smart.framework.util.CollectionUtil" %>
<%@tag import="org.smart.framework.util.JsonUtil" %>
<%@tag import="org.smart.framework.util.StringUtil" %>
<%@tag import="org.smart.plugin.common.util.PageUtil" %>
<%@tag import="org.smart.plugin.common.web.pagebean.IPageBean" %>
<%@ tag import="java.util.List" %>
<%@tag language="java" pageEncoding="UTF-8"
       trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--@doc--%>
<%@tag description='datagrid组件' display-name='datagrid' %>
<%@attribute description='表格id，页面唯一' name='id' type='java.lang.String' %>
<%@attribute description='表格名称' name='name' type='java.lang.String' %>
<%@attribute description='占格数' name='span' type='java.lang.String' %>
<%@attribute name="btnOne" type="java.lang.String" description="第一个按钮" %>
<%@attribute name="btnTwo" type="java.lang.String" description="第二个按钮" %>
<%@attribute name="btnThree" type="java.lang.String" description="第三个按钮" %>
<%@attribute name="btnFour" type="java.lang.String" description="第四个按钮" %>
<%--@doc--%>


<%
    IPageBean pageBean = PageUtil.getPageBean();
    String datas = "";
    List list = (List) pageBean.getTableListData(id);
    if (CollectionUtil.isNotEmpty(list)) {
        datas = JsonUtil.ListToJson(list);
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
%>
<div id="${id}_div"  <%if (StringUtil.isNotEmpty(span)) { %> span="<%=span %>" <%} else { %>


     span="1" <%} %>>


    <!-- 工具容器 -->
    <div id="toolbar" class="btn-group">
        <%if (StringUtil.isNotEmpty(btnOne)) {%>
        <button type="button" style="font-size: 12px;margin-right: 3px" class="btn btn-primary"
                onclick="grid_btn_one()">
            <span class="glyphicon glyphicon-plus" style="color:rgb(71,255,49);" aria-hidden="true"></span>${btnOne}
        </button>
        <%}%>
        <%if (StringUtil.isNotEmpty(btnTwo)) {%>
        <button type="button" style="font-size: 12px;margin-right: 3px" class="btn btn-primary"
                onclick="grid_btn_two();">
            <span class="glyphicon glyphicon-pencil" style="color:rgba(69,65,255,1);" aria-hidden="true"></span>${btnTwo}
        </button>
        <%}%>
        <%if (StringUtil.isNotEmpty(btnThree)) {%>
        <button type="button" style="font-size: 12px;margin-right: 3px" class="btn btn-primary"
                onclick="grid_btn_three();">
            <span class="glyphicon glyphicon-remove" style="color:rgba(255,5,20,0.86);" aria-hidden="true"></span>${btnThree}
        </button>
        <%}%>
        <%if (StringUtil.isNotEmpty(btnFour)) {%>
        <button type="button" style="font-size: 12px;margin-right: 3px" class="btn btn-primary"
                onclick="grid_btn_four();">
            <span class="glyphicon glyphicon-plus" style="color:#a659fc" aria-hidden="true"></span>${btnFour}
        </button>
        <%}%>
    </div>


    <table id="${id}" name="${id}" style="max-width: 97.5%">
        <jsp:doBody/>
    </table>
</div>
<script>
    $(function () {
        var info = []
        $("#${id}").find("input:hidden").each(function () {
            var nodes = {}
            nodes.field = $(this).attr("field");
            nodes.title = $(this).attr("title");
            nodes.width = $(this).attr("width");
            nodes.nodeId = $(this).attr("id");
            nodes.radio = $(this).attr("radio");
            nodes.checkbox = $(this).attr("checkbox");
            nodes.field = $(this).attr("field");
            nodes.title = $(this).attr("title");
            nodes.titleTooltip = $(this).attr("titleTooltip");
            nodes.class = $(this).attr("class");
            nodes.rowspan = $(this).attr("rowspan");
            nodes.colspan = $(this).attr("colspan");
            nodes.align = $(this).attr("align");
            nodes.halign = $(this).attr("halign");
            nodes.falign = $(this).attr("falign");
            nodes.valign = $(this).attr("valign");
            nodes.sortable = $(this).attr("sortable");
            nodes.order = $(this).attr("order");
            nodes.visible = eval($(this).attr("visible"));
            nodes.cardVisible = $(this).attr("cardVisible");
            nodes.switchable = $(this).attr("switchable");
            nodes.clickToSelect = $(this).attr("clickToSelect");
            if ($(this).attr("formatter")) {
                nodes.formatter = eval($(this).attr("formatter"));
            }
            nodes.footerFormatter = $(this).attr("footerFormatter");
            nodes.events = $(this).attr("events");
            nodes.sorter = $(this).attr("sorter");
            nodes.sortName = $(this).attr("sortName");
            nodes.cellStyle = $(this).attr("cellStyle");
            nodes.searchable = $(this).attr("searchable");
            nodes.searchFormatter = $(this).attr("searchFormatter");
            nodes.escape = $(this).attr("escape");
            nodes.showSelectTitle = $(this).attr("showSelectTitle");
            if ($(this).attr("types")) {
                nodes.editable = {
                    type: $(this).attr("types") == null ? "text" : $(this).attr("types"),
                    //mode:"inline",
                    /* validate: function (value) {
                         if ($.trim(value) == '') {
                             return '姓名不能为空!';
                         }
                     }*/
                };
            }
            info.push(nodes);
        });
        //console.log(info);
        $("#${id}").bootstrapTable({
            pageNumber: 1,//如果设置了分页，首页页码
            showColumns: "true",//是否显示 内容列下拉框
            //showToggle: "true",//是否显示 切换试图（table/card）按钮
            pagination: true, //分页

            Icons: 'glyphicon-export',
            //showRefresh:true,//显示刷新按钮
            //showFullscreen:true,//显示全屏按钮
            search: true,//显示搜索框
            searchAlign: 'right',//搜索框
            striped: true,//设置为 true 会有隔行变色效果
            //paginationLoop:true,//设置为 true 启用分页条无限循环的功能。
            // showPaginationSwitch:true,//是否显示 数据条数选择框
            pageSize: 5,//如果设置了分页，页面数据条数
            paginationPreText: '‹',//指定分页条中上一页按钮的图标或文字,这里是<
            paginationNextText: '›',//指定分页条中下一页按钮的图标或文字,这里是>
            pageList: [5, 10, 20, 40],  //如果设置了分页，设置可供选择的页面数据条数。设置为All 则显示所有记录。
            onPostBody: function () {
            },
            onLoadSuccess: function (data) {
            },
            //导出文件
            showExport: true,
            buttonsAlign: "right",  //按钮位置
            exportTypes: ['json', 'xml', 'csv', 'txt', 'sql', 'excel'],  //导出文件类型
            exportOptions: {},
            //表格编辑
            editable: true,//开启编辑模式
            onEditableSave: function (field, row, oldValue, $el) {

            },
            //toolbar
            toolbar: "#toolbar",
            columns: info
        });
        <%if(StringUtil.isNotEmpty(datas)){%>
        $("#${id}").bootstrapTable('load', <%=datas%>);
        <%}%>
        console.log(info);
    });


    var id = ${id}+"";
    if (id != "" && id != null) {
        var span_1 = parseFloat($("#${id}_div").parent().attr("cols"));
        var span_2 = $("#${id}_div").attr("span");
        var span = parseFloat(span_2) / parseFloat(span_1);
        $("#${id}_div").attr("style",
            "flex:0 0 " + span * 100 + "%;${cssStyle}");
    }
</script>