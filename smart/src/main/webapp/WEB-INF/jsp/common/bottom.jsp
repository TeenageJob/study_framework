<%@ page pageEncoding="UTF-8"%>


<script type="text/javascript">
	$(".knob").knob();
	$(".panel-success").each(function(){
		if($(this).attr("key")=="_key"){
			$(this).css("border","0");
		}
	})
</script>