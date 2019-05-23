<%@ page contentType="text/html;charset=UTF-8" %>
<%
    request.setAttribute("BASEPATH", "/smart");
%>


<link href="${BASEPATH}/www/lib/bootstrap-table/bootstrap-table.css" rel="stylesheet"/>
<link href="${BASEPATH}/www/lib/bootstrap-table/extensions/editable/css/bootstrap-editable.css" rel="stylesheet"/>
<!--bootstrap-table-->
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap-table/bootstrap-table.js"></script>

<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
<!--防止中文乱码-->
<script type="text/javascript"
        src="${BASEPATH}/www/lib/js/jquery.base64.js"></script>
<!--导出组件-->
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap-table/extensions/export/libs/FileSaver/FileSaver.min.js"></script>
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap-table/extensions/export/libs/js-xlsx/xlsx.core.min.js"></script>
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap-table/extensions/export/libs/jsPDF/jspdf.min.js"></script>
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap-table/extensions/export/libs/jsPDF-AutoTable/jspdf.plugin.autotable.js"></script>
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap-table/extensions/export/libs/html2canvas/html2canvas.min.js"></script>
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap-table/extensions/export/libs/pdfmake/mirza_fonts.js"></script>
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap-table/extensions/export/libs/pdfmake/vfs_fonts.js"></script>
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap-table/extensions/export/libs/pdfmake/pdfmake.min.js"></script>
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap-table/extensions/export/bootstrap-table-export.js"></script>
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap-table/extensions/export/tableExport.min.js"></script>

<!-- 表格编辑组件 -->
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap-table/extensions/editable/bootstrap-table-editable.js"></script>
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap-table/extensions/editable/js/bootstrap-editable.min.js"></script>
