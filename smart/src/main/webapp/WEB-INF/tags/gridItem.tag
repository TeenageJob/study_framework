<%@ tag import="org.smart.framework.util.ValidataUtil" %>
<%@ tag import="org.smart.framework.util.StringUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="radio" type="java.lang.String" description="radio" %>
<%@attribute name="checkbox" type="java.lang.String" description="checkbox" %>
<%@attribute name="field" type="java.lang.String" description="列字段名称。" required="true" %>
<%@attribute name="title" type="java.lang.String" description="列标题文本。" required="true" %>
<%@attribute name="titleTooltip" type="java.lang.String" description="列标题工具提示文本。该选项也支持标题HTML属性" %>
<%@attribute name="cssClass" type="java.lang.String" description="列类名称。" %>
<%@attribute name="rowspan" type="java.lang.String" description="指出一个单元应占用多少行。" %>
<%@attribute name="colspan" type="java.lang.String" description="指出一个单元应该占用多少列。" %>
<%@attribute name="align" type="java.lang.String" description="指示如何对齐列数据。可以使用'左'，'右'，'中心'。" %>
<%@attribute name="halign" type="java.lang.String" description="指示如何对齐表头。可以使用'左'，'右'，'中心'。" %>
<%@attribute name="falign" type="java.lang.String" description="指示如何对齐表格页脚。可以使用'左'，'右'，'中心'。" %>
<%@attribute name="valign" type="java.lang.String" description="指示如何对齐单元格数据。可以使用'顶部'，'中间'，'底部'。" %>
<%@attribute name="width" type="java.lang.String"
             description="列的宽度。如果未定义，宽度将自动展开以适应其内容。你也可以在你的号码中加'％'，bootstrapTable将使用百分比单位，否则，你可以在你的号码中加上或不加'px'，然后bootstrapTable将使用像素" %>
<%@attribute name="sortable" type="java.lang.String" description="真正允许列可以排序。" %>
<%@attribute name="order" type="java.lang.String" description="默认的排序顺序只能是'asc'或'desc'。" %>
<%@attribute name="visible" type="java.lang.String" description="假以隐藏列项目。" %>
<%@attribute name="cardVisible" type="java.lang.String" description="	False将列项目隐藏在卡片视图状态中。" %>
<%@attribute name="switchable" type="java.lang.String" description="假以禁用列项目的可切换性。" %>
<%@attribute name="clickToSelect" type="java.lang.String" description="选中该复选框或单选框后，单击该列即可。" %>
<%@attribute name="formatter" type="java.lang.String"
             description="上下文（this）是列Object。单元格格式化函数有三个参数：value：字段值。行：行记录数据。索引：行索引。" %>
<%@attribute name="footerFormatter" type="java.lang.String"
             description="上下文（this）是列Object。该函数采用一个参数：data：所有数据行的数组。该函数应返回一个字符串与文本显示在页脚单元格中。" %>
<%@attribute name="events" type="java.lang.String"
             description="在使用格式化函数时，单元格事件监听器需要三个参数：事件：jQuery事件。值：字段值。行：行记录数据。索引：行索引。" %>
<%@attribute name="sorter" type="java.lang.String"
             description="用于执行本地排序的自定义字段排序函数有两个参数：a：第一个字段值。b：第二个字段值。rowA：第一行。rowB：第二行。" %>
<%@attribute name="sortName" type="java.lang.String"
             description="提供可定制的排序名称，而不是标题中的默认排序名称或列的字段名称。例如，列可能会显示“html”的fieldName的值，例如“<b> <span style =”color：red“> abc </ span> </ b>”，但要排序的fieldName是“content “的值为”abc“。" %>
<%@attribute name="cellStyle" type="java.lang.String"
             description="单元样式格式化程序函数有三个参数：value：字段值。行：行记录数据。索引：行索引。字段：行字段。支持类或CSS。" %>
<%@attribute name="searchable" type="java.lang.String" description="正确搜索此列的数据。" %>
<%@attribute name="searchFormatter" type="java.lang.String" description="真正的搜索使用格式化的数据。" %>
<%@attribute name="escape" type="java.lang.String" description="转义字符串以插入HTML，替换＆，<，>，“，\`和'字符。" %>
<%@attribute name="showSelectTitle" type="java.lang.String"
             description="	如果显示带'radio'或'singleSelect''复选框'选项的列的标题，则为true。" %>
<%@attribute name="btn" type="java.lang.String"
             description="按钮" %>
<%@attribute name="btnNameEdit" type="java.lang.String" description="按钮名称" %>
<%@attribute name="btnNameDel" type="java.lang.String" description="按钮名称" %>
<%@attribute name="funEdit" type="java.lang.String" description="编辑按钮方法" %>
<%@attribute name="funDel" type="java.lang.String" description="删除按钮方法" %>
<%@attribute name="type" type="java.lang.String" description="表格类型" %>
<%--@doc--%>
<input id="${field}" type="hidden"
    <% if(StringUtil.isNotEmpty(width)){%>
       width="${width}"
    <%}%>
    <% if(StringUtil.isNotEmpty(radio)){%>
       radio="${radio}"
    <%}%>
    <% if(StringUtil.isNotEmpty(checkbox)){%>
       checkbox="${checkbox}"
    <%}%>
    <% if(StringUtil.isNotEmpty(field)){%>
       field="${field}"
    <%}%>
    <% if(StringUtil.isNotEmpty(title)){%>
       title="${title}"
    <%}%>
    <% if(StringUtil.isNotEmpty(titleTooltip)){%>
       titleTooltip="${titleTooltip}"
    <%}%>
    <% if(StringUtil.isNotEmpty(cssClass)){%>
       class="${cssClass}"
    <%}%>
    <% if(StringUtil.isNotEmpty(rowspan)){%>
       rowspan="${rowspan}"
    <%}%>
    <% if(StringUtil.isNotEmpty(colspan)){%>
       colspan="${colspan}"
    <%}%>
    <% if(StringUtil.isNotEmpty(align)){%>
       align="${align}"
    <%}else{%>
       align="center"
    <%}%>
    <% if(StringUtil.isNotEmpty(halign)){%>
       halign="${halign}"
    <%}%>
    <% if(StringUtil.isNotEmpty(falign)){%>
       falign="${falign}"
    <%}%>
    <% if(StringUtil.isNotEmpty(valign)){%>
       valign="${valign}"
    <%}%>
    <% if(StringUtil.isNotEmpty(sortable)){%>
       sortable="${sortable}"
    <%}%>
    <% if(StringUtil.isNotEmpty(order)){%>
       order="${order}"
    <%}%>
    <% if(StringUtil.isNotEmpty(visible)){%>
       visible="${visible}"
    <%}%>
    <% if(StringUtil.isNotEmpty(cardVisible)){%>
       cardVisible="${cardVisible}"
    <%}%>
    <% if(StringUtil.isNotEmpty(switchable)){%>
       switchable="${switchable}"
    <%}%>
    <% if(StringUtil.isNotEmpty(clickToSelect)){%>
       clickToSelect="${clickToSelect}"
    <%}%>
    <% if(StringUtil.isNotEmpty(footerFormatter)){%>
       footerFormatter="${footerFormatter}"
    <%}%>
    <% if(StringUtil.isNotEmpty(sorter)){%>
       sorter="${sorter}"
    <%}%>
    <% if(StringUtil.isNotEmpty(sortName)){%>
       sortName="${sortName}"
    <%}%>
    <% if(StringUtil.isNotEmpty(cellStyle)){%>
       cellStyle="${cellStyle}"
    <%}%>
    <% if(StringUtil.isNotEmpty(searchable)){%>
       searchable="${searchable}"
    <%}%>
    <% if(StringUtil.isNotEmpty(searchFormatter)){%>
       searchFormatter="${searchFormatter}"
    <%}%>
    <% if(StringUtil.isNotEmpty(type)){%>
       types="${type}"
    <%}%>
    <% if(StringUtil.isNotEmpty(escape)){%>
       escape="${escape}"
    <%}%>
    <% if(StringUtil.isNotEmpty(showSelectTitle)){%>
       showSelectTitle="${showSelectTitle}"
    <%}%>
    <% if(StringUtil.isNotEmpty(btnNameEdit)||StringUtil.isNotEmpty(btnNameDel)){%>
       formatter="btn" events="operateEvents"
    <%}%>
       btnNameEdit="${btnNameEdit}" btnNameDel="${btnNameDel}"
       funEdit="${funEdit}" funDel="${funDel}"


>

<script type="text/javascript">
    var Item_edit = $("#${field}").attr("btnNameEdit");
    var Item_del = $("#${field}").attr("btnNameDel");
    var funEdit = $("#${field}").attr("funEdit");
    var funDel = $("#${field}").attr("funDel");

    function btn(value, row, index) {
        var info = []
        if (Item_edit != null && Item_edit != "") {
            info.push('<input id="' + index + "btn_edit" + '" type="button" class="RoleOfedit btn btn-info" data-toggle="modal" style="display:inline"  value="${btnNameEdit}"/>');
        }
        if (Item_del != null && Item_del != "") {
            info.push('<input id="' + index + "btn_del" + '" type="button" class="RoleOfdelete btn btn-info" data-toggle="modal" style="display:inline;margin-left:5px;" value="${btnNameDel}"/>');
        }
        return info.join('');
    }

    window.operateEvents = {
        'click .RoleOfedit': function (e, value, row, index) {
            if (funEdit != null && funEdit != "") {
                funEdit = eval(funEdit);
                funEdit.call(this, e, row, index)

            }
        },
        'click .RoleOfdelete': function (e, value, row, index) {
            if (funDel != null && funDel != "") {
                funDel = eval(funDel);
                funDel.call(this, e, row, index)
            }
        }
    };
</script>


