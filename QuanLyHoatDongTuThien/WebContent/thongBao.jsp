
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />




<title>Đăng ký tài khoản</title>
<!-- KHÔNG ĐƯỢC XÓA CSS -->
<link href="./Wisdom of Life_files/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="./Wisdom of Life_files/css/red.css" rel="stylesheet"
	type="text/css" />
<link href="./Wisdom of Life_files/css/pikaday.css" rel="stylesheet"
	type="text/css" />
<link href="./Wisdom of Life_files/css/jquery-ui-1.10.4.custom.min.css"
	rel="stylesheet" type="text/css" />
<link href="./Wisdom of Life_files/css/jquery.ui.all.css"
	rel="stylesheet" />
<link href="./Wisdom of Life_files/css/demos.css" rel="stylesheet" />
<!-- // Javascripts // -->
<script type="text/javascript"
	src="./Wisdom of Life_files/jsc/jquery-1.4.3.min.js"></script>
<script type="text/javascript"
	src="./Wisdom of Life_files/jsc/jquery.easing.1.3.js"></script>
<script type="text/javascript"
	src="./Wisdom of Life_files/jsc/jquery.quicksand.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/main.js"></script>
<script type="text/javascript"
	src="./Wisdom of Life_files/jsc/scrolltopcontrol.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/sudo.js"></script>
<script type="text/javascript"
	src="./Wisdom of Life_files/jsc/contentslider.js"></script>
<script type="text/javascript"
	src="./Wisdom of Life_files/jsc/jquery.nivo.slider.pack.js"></script>
<script type="text/javascript"
	src="./Wisdom of Life_files/jsc/jquery.countdown.js"></script>
<script type="text/javascript"
	src="./Wisdom of Life_files/jsc/jquery.validate.pack.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/misc.js"></script>
<script type="text/javascript"
	src="./Wisdom of Life_files/jsc/animatedcollapse.js"></script>
<script type="text/javascript"
	src="./Wisdom of Life_files/jsc/jquery.fancybox-1.3.1.js"></script>
<script type="text/javascript"
	src="./Wisdom of Life_files/jsc/lightbox.js"></script>
<script type="text/javascript"
	src="./Wisdom of Life_files/jsc/ddsmoothmenu.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/tabs.js"></script>

<!--[if lte IE 7]><style>#controls{	margin:0px 0px 0px -80px;}</style><![endif]-->

<style>
.spantext {
	width: 200px;
	display: block;
	float: left;
	text-align: left;
	padding-top: 10px
}

.validate {
	margin-left: 220px;
}
</style>
</head>
<body>
	<!-- Clouds effect -->
	<span class="grung backcolr">&nbsp;</span>
	<span class="blackstrip">&nbsp;</span>
	<span class="whitestrip">&nbsp;</span>
	<!-- Outer Wrapper -->
	<div id="outer_wrapper">
		<!-- Header -->
		<jsp:include page="header.jsp">
			<jsp:param name="current8" value="current-menu-item" />
		</jsp:include>
		<div class="clear"></div>
		<!-- Banner -->
		<div id="subbanner">
			<div class="inner">
				<a href="#"><img src="./Wisdom of Life_files/images/banner2.jpg"
					alt="" /></a>
			</div>
		</div>
		<div class="clear"></div>
		<!-- Content Section -->
		<div id="contentsec">
			<div class="inner">
				<!-- Columns -->
				<div class="columns">

					<!-- Middle big section -->
					<div class="static">
						<div class="fullwidth left">
							<div class="tab_menu_container backcolr">
								<ul id="tab_menu">
									<li><a class="current" rel="feeds">Thông báo</a></li>
								</ul>
								<div class="clear"></div>
							</div>
							<div class="clear"></div>
							<div class="tables">
								<div class="newDiv"></div>
							</div>
						</div>
					</div>

				</div>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
		<!-- Footer -->
		<jsp:include page="footer.jsp"></jsp:include>
		
	</div>




	<%
		int trang = 1;
	%>



	<script type="text/javascript">
		function hienThiThongBao(trangSo) {
			$.ajax({
				type : "GET",
				url : "/QuanLyHoatDongTuThien/hienThiThongBao.do?trang="
						+ trangSo,
				//data: trang+"/"+maBaiDang,
				success : function(response) {
					$(".newDiv").html(response);
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});

		}
	</script>

	<script>
		hienThiThongBao('1');
	</script>

</body>
</html>
