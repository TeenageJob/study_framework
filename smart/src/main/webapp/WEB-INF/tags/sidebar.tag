<%@tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	
%>
<c:set var="flags" value="true" />
<c:forEach items="${INFO.menu }" var="tl">
	<c:choose>
		<c:when test="${flags=='true' }">
			<div role="tabpanel" class="tab-pane  active in"
				id="${tl.value.getTab_id() }" style="width:15%;">
				<c:set var="flags" value="false" />
		</c:when>
		<c:otherwise>  
			<div role="tabpanel" class="tab-pane "
				id="${tl.value.getTab_id() }" style="width:15%;">
		</c:otherwise>
	</c:choose>
		<div class="sidebar-css" id="sidebar">
			<div class="panel-group"  id="${tl.value.getWarp_id() }"
				role="tablist" aria-multiselectable="true">
				<c:forEach items="${tl.value.getBusiness()}" var="bs">
					<div class="panel panel-default sidebar-active sidebar-div-css">
						<div style="background: #2a3542; border: 0" class="panel-heading"
							role="tab" id="${bs.value.getId_flag() }">
							<h4 class="panel-title ">
								<a style="color: #aeb2b7; width: 100%; font-size: 14px;"
									role="button" data-toggle="collapse"
									data-parent="#${tl.value.getWarp_id() }"
									href="#${bs.value.getCollapse()}" aria-expanded="false"
									aria-controls="${bs.value.getCollapse()}" class="collapsed">
									<span
									class="${bs.value.getSpan_class() }"
									style="padding-right: 8px;" aria-hidden="true"></span>
									<span>${bs.value.getTitle_name()}</span>
									<div class="sidebar-a-span-div" >
									<span class="sidebar-a-span" id="${bs.value.getId_flag() }_span"  style="background-color:${bs.value.getSpan_style()}">
										5 </span>
									<span class="sidebar-a-span-flag"/>
									</div>
									</a>
							</h4>
						</div>
						<div id="${bs.value.getCollapse()}"
							class="sidebar-li-css panel-collapse collapse" role="tabpanel"
							aria-labelledby="${bs.value.getId_flag() }">
							<ul class="list-group sidebar-li-css"
								style="border-top: 0; padding-left: 21px;">
								<c:set var="conuts" value="0"/>
								<c:forEach items="${bs.value.getBusiness_url()}" var="bu" varStatus="count">
									<li class="list-group-item sidebar-li-css">
											<%--href="${bu.getUrl() }"--%>
										<a href="javascript:void(0);" onclick="show_page('${bu.getUrl() }')">
											<font style="vertical-align: inherit;">${bu.getUrl_name() }</font>
									</a></li>
									<c:set var="counts" value="${count.index+1 }"/>
								</c:forEach>
								<script type="text/javascript">
									$("#${bs.value.getId_flag() }_span").html(${counts}); 
								</script>
							</ul>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</c:forEach>
<script type="text/javascript">
	$('.sidebar-active').find('a').css("text-decoration", "none");
	$('.sidebar-active').on(
			'show.bs.collapse',
			function() {
				$(this).find('div').css("background", "#35404D");
				$(this).find('ul').css("background", "#35404D");
				$(this).find('li').css("background", "#35404D");
				$(this).find('a').css("color", "#fff");
				$(this).find('.sidebar-a-span-flag').css("background-position",
						"bottom");
			});
	$('.sidebar-active').on('hide.bs.collapse', function() {
		$(this).find('div').css("background", "#2a3542");
		$(this).find('ul').css("background", "#2a3542");
		$(this).find('li').css("background", "#2a3542");
		$(this).find('a').css("color", "#aeb2b7");
		$(this).find('.sidebar-a-span-flag').css("background-position", "top");
	});
</script>

