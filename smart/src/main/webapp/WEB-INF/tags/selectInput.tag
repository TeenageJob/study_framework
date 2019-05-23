<%@tag import="java.lang.String" %>
<%@tag import="java.util.Map" %>
<%@tag import="java.util.HashMap" %>
<%@tag import="java.util.ArrayList" %>
<%@tag import="java.util.List" %>
<%@tag import="org.smart.plugin.common.util.PageUtil" %>
<%@tag import="org.smart.plugin.common.web.pagebean.IPageBean" %>
<%@ tag import="org.mvc.ty.common.query.CommonQuery" %>
<%@ tag import="org.smart.framework.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%--@doc--%>
<%@tag description='下拉框' display-name='selectInput' %>
<%@attribute description='id'
             name='id' type='java.lang.String' required="true" %>
<%@attribute description='占格数'
             name='span' type='java.lang.String' %>
<%@attribute description='命名' name='name' type='java.lang.String' %>
<%@attribute description='开启多选' name='multiple ' type='java.lang.String' %>
<%@attribute description='chang方法' name='onchange' type='java.lang.String' %>
<%@attribute description='获取码表中的值' name='colletions' type='java.lang.String' %>
<%@attribute description='div样式' name='divStyle' type='java.lang.String' %>
<%@attribute description='样式' name='style' type='java.lang.String' %>
<%@attribute description='取消占格' name='flex' type='java.lang.String' %>
<%--@doc--%>


<%
    IPageBean pageBean = PageUtil.getPageBean();
    Map<String, String> map = new HashMap<>();
    List<String> collectionlist = new ArrayList<>();
    if (CollectionUtil.isNotEmpty(pageBean.getSelectDataById(id))) {
        List<?> list = pageBean.getSelectDataById(id);
        if (list.get(0) instanceof Map) {//list中只有一个长的map对象
            String slist = list.get(0).toString().substring(1, list.get(0).toString().length() - 1);
            String[] str = slist.split(ConstantUtil.COMMA_S);
            for (int i = 0; i < str.length; i++) {
                String[] str2 = str[i].split(ConstantUtil.EQUERY_S);
                map.put(str2[0].trim(), str2[1].trim());
            }
        } else {
            List<String> lists = (List<String>) list;
            for (String str : lists) {
                String[] str2 = str.split(ConstantUtil.COMMA_S);
                map.put(str2[0].trim(), str2[1].trim());
            }
        }
    } else if (StringUtil.isNotEmpty(colletions)) {
        collectionlist = CommonQuery.queryCollection(colletions);
        for (String str : collectionlist) {
            String[] val = str.split(ConstantUtil.COMMA_S);
            map.put(val[0].trim(), val[1].trim());
        }
    }
    String readonly, disabled, hide, enable, show, required, disrequired, focus, checked = null;
    List<String> propertyList = pageBean.getPropertyById(id);
    if (CollectionUtil.isNotEmpty(propertyList))
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
    String setData = (String) pageBean.getData(id);
%>
<div id="${id }_div"
        <%if (StringUtil.isNotEmpty(span)) { %>
     span="${span }"
        <%} else { %>
     span="1"
        <%} %>  >

    <%if (StringUtil.isNotEmpty(name)) {%>
    <label class="label-css" style="width: 90px;font-size: 12px; text-align: right;" for="${id }">${name }：</label>
    <%}%>
    <select name="${id}"
            <c:if test="${multiple}==“true">
                ${multiple}
            </c:if>
            id="${id}"
            class="selectpicker"
            data-live-search="true"
            onchanges="${onchange}"
    >

        <c:if test="<%=map.size() != 0%>">
            <c:forEach items="<%=map%>" var="sl">
                <option aid="${sl.key }" value="${sl.value }">${sl.value }</option>
            </c:forEach>
        </c:if>

    </select>
    <input type="hidden" value="${onchange}" id="onchangeValue"/>
</div>
<script type="text/javascript">
    $("#${id}").on('changed.bs.select', function (e, index) {
        var fun = $(this).attr("onchanges");
        if (fun) {
            var aid = $(this).find("option:selected").attr("aid");
            var value = $(this).find("option:selected").html();
            fun = eval(fun);
            fun.call(this, e, aid, value, index);
        }
    });

    $(function () {
        $("#${id }").selectpicker()
    });
    $('#${id}').selectpicker('val', '<%=setData%>');

    <%if(StringUtil.isNotEmpty(name)&&!ValidataUtil.isEquals(flex,"false")){%>
    var span_1 = parseFloat($("#${id}_div").parent().attr("cols"));
    var span_2 = $("#${id}_div").attr("span");
    var span = parseFloat(span_2) / parseFloat(span_1);
    $("#${id}_div").attr("style",
        "flex:0 0 " + span * 100 + "%;position:static;margin-bottom:15px;${divStyle}");
    <%}else{%>
    $("#${id}_div").attr("style",
        "position:static;margin-bottom:15px;${divStyle}");
    <%}%>
</script>

