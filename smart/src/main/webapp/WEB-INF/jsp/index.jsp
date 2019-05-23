<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="shiro" uri="/security" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>田源社保系统</title>
    <%@ include file="/WEB-INF/jsp/common/script.jsp" %>
    <%@ include file="/WEB-INF/jsp/common/style.jsp" %>

    <style type="text/css">
        html, body {
            height: 100%;
            width: 100%;
            margin: 0;
            padding: 0;
            border: none;
        }

        .tubiao-div {
            position: absolute;
            left: 14%;
            margin: 0px;
            color: #79f990;
            z-index: 1000;
        }

        .tubiao-span {
            font-size: 30px;
        }

        .context-css {
            padding: 0;
            margin: 0;
            margin-left: 15% !important;
            max-width: 85% !important;
            color: #797979;
        }
    </style>
</head>
<body style="overflow: hidden;">

<ty:header>
    <ty:sidebar/>
</ty:header>
<div id="tubiao" class="tubiao-div" onclick="show_sidebar()">
    <span class="glyphicon glyphicon-chevron-left tubiao-span" aria-hidden="true"></span>
</div>
<div id="context" class="container-fluid context-css">
    <div id="context_div" style="display: inline-block;width: 100%;height: 100%;overflow-y: auto">

    </div>
    <div id="ty_alertDiv"></div>
</div>
<div id="loadJsp"></div>
<script>
    var context_body_height = $("#header").outerHeight();
    var panel_pandding_top = 6;
    var box_margin_bottom = 15;
    clienth_height = clienth_height - context_body_height;
    $(function () {
        $("#context").css("height", clienth_height + "px");
    })

    var flag_sidebar_show = true;

    function show_sidebar() {
        if (flag_sidebar_show == true) {
            $("#tubiao").css("left", "-1%");
            $("#header_sidebar").hide();

            $("#tubiao span").removeClass("glyphicon glyphicon-chevron-left");
            $("#tubiao span").addClass("glyphicon glyphicon-chevron-right");
            $("#context ").css("margin-left", "0px")
            $("#tubiao").show();
            flag_sidebar_show = false;
        } else {
            $("#tubiao").css("left", "14%");
            $("#context ").css("margin-left", "15%");
            $("#header_sidebar").show();
            $("#tubiao span").removeClass("glyphicon glyphicon-chevron-right");
            $("#tubiao span").addClass("glyphicon glyphicon-chevron-left");
            flag_sidebar_show = true;
        }
    }

    function clickUrl(name) {
        $(":contains(" + name + ")").parent().click();
    }
</script>
</body>
</html>
