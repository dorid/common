<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>菜单导航</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript"> 
		$(document).ready(function() {
			$(".accordion-heading a").click(function(){
				$('.accordion-toggle i').removeClass('icon-chevron-down');
				$('.accordion-toggle i').addClass('icon-chevron-right');
				if(!$($(this).attr('href')).hasClass('in')){
					$(this).children('i').removeClass('icon-chevron-right');
					$(this).children('i').addClass('icon-chevron-down');
				}
			});
			$(".accordion-body a").click(function(){
				$("#menu li").removeClass("active");
				$("#menu li i").removeClass("icon-white");
				$(this).parent().addClass("active");
				$(this).children("i").addClass("icon-white");
			});
			$(".accordion-body a:first i").click();
		});
	</script>
</head>
<body>
	<div class="accordion" id="menu">
		<div class="accordion-group">
		    <div class="accordion-heading">
                <a class="accordion-toggle" data-toggle="collapse" data-parent="#menu" href="#collapse28" title=""><i class="icon-chevron-down"></i>&nbsp;个人信息</a>		    </div>

            <div id="collapse28" class="accordion-body  collapse in">
                <div class="accordion-inner">
                    <ul class="nav nav-list">
                        <li><a href="${ctx}/sys/dict" target="mainFrame" ><i class="icon-user icon-white"></i>&nbsp;11111</a></li>
                        <li><a href="${ctx}/sys/dict" target="mainFrame" ><i class="icon-lock"></i>&nbsp;11111</a></li>
                    </ul>
                </div>
            </div>

        </div>
	</div>
</body>
</html>
