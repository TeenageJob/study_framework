<%@tag import="org.smart.framework.util.StringUtil" %>
<%@tag import="org.smart.plugin.common.util.PageUtil" %>
<%@tag import="org.smart.plugin.common.web.pagebean.IPageBean" %>
<%@tag language="java" pageEncoding="UTF-8"
       trimDirectiveWhitespaces="true" %>

<%-- @doc --%>
<%@tag description='panel面板' display-name='panel' %>
<%@attribute name="id" type="java.lang.String"
             description="容器组件在页面上的唯一id" %>
<%@attribute name="name" type="java.lang.String"
             description="标题名称" %>
<%@attribute name="cols" type="java.lang.String"
             description="当该容器对子组件布局layout=column的时候，可以设置cols参数表面将容器分成多少列，默认不设置为1" %>
<%@attribute name="columnWidth" type="java.lang.String"
             description="设置layout为column布局的时候自定义占用宽度百分比，可设置值为0-1之间的小数，如:0.1" %>
<%@attribute name="cssStyle" type="java.lang.String"
             description='给该组件添加自定义样式，如:cssStyle="padding-top:10px"' %>
<%@attribute name="cssClass" type="java.lang.String"
             description='给该组件添加自定义样式class，如:cssClass="no-padding"' %>
<%@attribute name="value" type="java.lang.String"
             description="组件的label标签" %>
<%@attribute name="layout" type="java.lang.String"
             description="设置该容器对子组件的布局类型，有column/border，默认为column，cols=1" %>
<%@attribute name="layoutCfg" type="java.lang.String"
             description='json,设置layout为border布局的时候布局的参数配置，如:layoutCfg=\"{leftWidth:200,topHeight:90,rightWidth:200,bottomHeight:100}\"' %>
<%@attribute name="position" type="java.lang.String"
             description="top/left/center/right/bottom,设置父亲容器layout为border布局的时候该组件所在位置" %>
<%@attribute name="span" type="java.lang.String"
             description='数字，当该容器被父容器作为column方式布局的时候，设置span表明当前组件需要占用多少列' %>
<%@attribute name="icon" type="java.lang.String"
             description='标题图标class名称,如:icon-add,可以到icon.css查询' %>
<%@attribute name="expanded" type="java.lang.String"
             description='true/false ,是否展开，默认为false' %>
<%@attribute name="withToolBar" type="java.lang.String"
             description='true/false ,是否带有toolbar。默认false' %>
<%@attribute name="withButtonBar" type="java.lang.String"
             description='true/false ,是否带有ButtonBar。默认false' %>
<%@attribute name="bodyClass" type="java.lang.String"
             description='添加表格体部分的样式class' %>
<%@attribute name="bodyStyle" type="java.lang.String"
             description='添加表格体部分的样式style' %>
<%@attribute name="hasBorder" type="java.lang.String"
             description='true/false ,是否有外边框。默认true' %>
<%@attribute name="width" type="java.lang.String"
             description='自定义panel的宽度，如:width="100px"' %>
<%@attribute name="height" type="java.lang.String"
             description='自定义panel的高度，这个高度是除开标题的高度，如:height="100px"' %>
<%@attribute name="fit" type="java.lang.String"
             description='true/false,是否自动适应剩余高度,如果设置为true，那么该组件的所有父辈组件都要设置fit为true或height为固定值。&gt;/br&lt;该组件兄弟组件间只能有一个设置fit=true。&gt;/br&lt;如果兄弟组件在后面且可见，那么需要设置heightDiff高度补差' %>
<%@attribute name="heightDiff" type="java.lang.String"
             description='当fit设置为true的时候组件底部高度补差，后同级后面的组件留下一定高度，如:heightDiff="100",不需要加px' %>
<%@attribute name="padding" type="java.lang.String"
             description='当panel内部的组件和边框靠的太近可以通过设置该属性来增加一定的内边距，如:3或3px 2px 3px 2px(上、右、下、左)' %>
<%@attribute name="scalable" type="java.lang.String"
             description='true/false ,是否可缩放，默认为false' %>
<%@attribute name="minHeight" type="java.lang.String"
             description='true/false ,是否可缩放，默认为true' %>
<%@attribute name="titleAlign" type="java.lang.String"
             description='left/center/right,panel标题的位置，默认left' %>
<%@attribute name="headerButton" type="java.lang.String"
             description='在panel上面右边存在按钮,如[{"id":"button1","name":"提交","click":"fnClick()"}]' %>
<%@attribute description='是否需要权限控制' name='fieldsAuthorization'
             type='java.lang.String' %>
<%-- @doc --%>

<div class="panel  panel-success" style="z-index:100;max-height: 100%;${cssStyle}" id="${id}" key="${value}_key"
        <%if (StringUtil.isNotEmpty(span)) { %> span="<%=span %>" <%} else { %>
     span="1" <%} %>
>
    <!-- 标题 -->
    <%
        if (StringUtil.isNotEmpty(value) || StringUtil.isNotEmpty(name)) {
    %>
    <div style="width: 97.5%;height: 35px;margin-left:15px;margin-right: 15px;border-bottom:3px solid #2e2eff;
">
        <div class="panl-heading-left"></div>
        <div class="panl-heading-center">
            <h4 class="panel-h">${value}${name}</h4>
        </div>
        <div class="panl-heading-right"></div>
    </div>
    <%
        }
    %>
    <div class="container-fluid" style="clear:both">
        <div class="panel-css" style="padding-top:15px;" <%if (StringUtil.isNotEmpty(cols)) { %>
             cols="${cols}" <%} else { %> cols="1" <%} %>>
            <jsp:doBody/>
        </div>
    </div>
</div>