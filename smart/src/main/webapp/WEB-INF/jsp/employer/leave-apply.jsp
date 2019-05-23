<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
<input type="hidden" name="startTime"/>
<input type="hidden" name="endTime"/>
<ty:form method="post" url="employerInsure/save.do">
    <ty:activitiBPMN/>
    <ty:panel id="panl_1" cols="1">
    <legend>
        <small>请假申请</small>
    </legend>
    <div class="control-group">
        <label class="control-label">请假类型:</label>
        <div class="controls" >
            <select id="leaveType" name="leaveType" class="required">
                <option>公休</option>
                <option>病假</option>
                <option>调休</option>
                <option>事假</option>
                <option>婚假</option>
            </select>
        </div>
    </div>
    <ty:text id="txt_start_time" name="开始时间"/>
    <ty:text id="txt_end_time" name="结束时间"/>
    <ty:text id="txt_why" name="请假原因"/>
    <ty:button id="btn_save" type="submit" name="提交"/>
</ty:panel>
</ty:form>