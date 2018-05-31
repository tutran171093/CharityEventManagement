<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@page import="model.bean.BaiDang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>Trang chủ</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Chi tiết bài đăng</title>
<link href="./Wisdom of Life_files/css/style.css" rel="stylesheet" type="text/css" />
<link href="./Wisdom of Life_files/css/red.css" rel="stylesheet" type="text/css" />
<!-- // Javascripts // -->

<script type="text/javascript" src="./Wisdom of Life_files/jsc/jquery-1.4.3.min.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/jquery.quicksand.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/main.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/scrolltopcontrol.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/sudo.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/contentslider.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/jquery.nivo.slider.pack.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/jquery.countdown.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/jquery.validate.pack.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/misc.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/animatedcollapse.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/jquery.fancybox-1.3.1.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/lightbox.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/ddsmoothmenu.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/tabs.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/tabswidget.js"></script>

<link rel="stylesheet" href="./Wisdom of Life_files/css/elements.css" />
<script type="text/javascript" src="./Wisdom of Life_files/jsc/ga.js"></script>
<script src="./Wisdom of Life_files/jsc/my_js.js"></script>	


<script type="text/javascript">
	var _gaq = _gaq || [];
	_gaq.push(['_setAccount', 'UA-43981329-1']);
	_gaq.push(['_trackPageview']);
	(function () {
	var ga = document.createElement('script');
	ga.type = 'text/javascript';
	ga.async = true;
	ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
	var s = document.getElementsByTagName('script')[0];
	s.parentNode.insertBefore(ga, s);
	})();
</script>

<!--[if lte IE 7]><style>#controls{	margin:0px 0px 0px -80px;}</style><![endif]-->
<script type="text/javascript" charset="UTF-8" src="./Wisdom of Life_files/jsc/common.js"></script><script type="text/javascript" charset="UTF-8" src="./Wisdom of Life_files/jsc/util.js"></script><script type="text/javascript" charset="UTF-8" src="./Wisdom of Life_files/jsc/stats.js"></script>
</head>
<body>
<!-- Clouds effect -->
<span class="grung backcolr">&nbsp;</span>
<span class="blackstrip">&nbsp;</span>
<span class="whitestrip">&nbsp;</span>
<!-- Outer Wrapper -->
<div id="outer_wrapper">
	<jsp:include page="header.jsp">
			<jsp:param name="current5" value="current-menu-item" />
		</jsp:include>
    <div class="clear"></div>
    <!-- Banner -->
    <div id="subbanner">
    	<div class="inner">
        	<a href="#"><img src="./Wisdom of Life_files/images/banner2.jpg" alt="" /></a>
        </div>
    </div>
    <div class="clear"></div>
    <!-- Content Section -->
    <div id="contentsec">
    	<div class="inner">
        	<!-- Columns -->
            <div class="col1 left">
                   
					<div class="blog">
						<!-- Tiêu đề bài đăng -->
						<h4 class="heading backcolr"><bean:write name="baiDangForm"
															property="tieuDe" /></h4>
						<!-- Chi tiết bài đăng -->
						<div class="post detail">
							
							<div class="thumb">
							
							<bean:define id="hinhAnh" name="baiDangForm" property="urlHinhAnh"></bean:define>
								<a href=""><img src="<%=hinhAnh%>" alt="" height="200" width="700"/></a>
							</div>
							<div class="postdesc">
							
								<p>
									<bean:write name="baiDangForm"
															property="noiDung" />
								</p>
							</div>
							
							<div class="clear"></div>
						</div>
					</div>
					<div class="clear"></div>
			</div>
			<html:form action="/chiTietDuyetBai" method="post">
			<div class="barsmall right">
				<!--Thông tin chuyến đi-->
				<div class="widget">
					<h4 class="headng backcolr">Thông tin</h4>
					<!-- Donation Widget -->
					
					<div class="donation">
						<p>Đoàn trưởng: <b><bean:write name="baiDangForm"
														property="tenDangNhapLeader" /></b></p>
						<p>Ngày đăng: <b><bean:write name="baiDangForm"
														property="ngayDang" /></b></p>
						<p>Ngày đi: <b><bean:write name="baiDangForm"
														property="ngayDi" /></b></p>
						<p>Địa điểm: <b><bean:write name="baiDangForm"
														property="diaDiem" /></b> </p>
						<p>Kinh phí dự kiến/1 người: <b><bean:write name="baiDangForm"
														property="kinhPhiDuKien" /></b></p>
						<p>Số người tham gia dự kiến: <b><bean:write name="baiDangForm"
														property="soNguoiDuKien" /></b></p>
					</div>
					
				</div>
				<div class="widget">
					<div class="clear"></div>
					<div class="donation">
					<bean:define id="maBaiDang"
							name="baiDangForm" property="maBaiDang"></bean:define>
						<h2 class="bold backcolr donbtn" style="margin-top:10px"><a href="suaBaiDang.do?maBaiDang=${maBaiDang}">Duyệt bài</a></h2>
						<h2 class="bold backcolr donbtn"><a href="xoaBaiDang.do?maBaiDang=${maBaiDang}">Xóa</a></h2>
					</div>
				</div>
			</div>
			</html:form>
			<div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
    <div class="clear"></div>
    <!-- Footer -->
    <jsp:include page="footer.jsp"></jsp:include>
    
</div>
</body>
</html>
<script type="text/javascript">
	
	function XacNhanXoa(maBaiDang) {
		if (confirm("Ban co thuc su muon xoa ko?")) {
			location.href = "/xoaBaiDang.do?maBaiDang=" +maBaiDang;
		}
	}
	function XacNhan(maBaiDang) {
		if (confirm("Ban co thuc su muon xac nhan duyet?")) {
			location.href = "/suaBaiDang.do?maBaiDang=" +maBaiDang;
		}
	}
</script>
