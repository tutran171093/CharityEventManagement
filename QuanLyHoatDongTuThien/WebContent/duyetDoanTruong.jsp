<%@page import="model.bean.ThanhVien"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Duyệt yêu cầu đăng ký Leader</title>
<link href="./Wisdom of Life_files/css/style.css" rel="stylesheet" type="text/css" />
<link href="./Wisdom of Life_files/css/red.css" rel="stylesheet" type="text/css" />
<!-- // Javascripts // -->
<script type="text/javascript" charset="UTF-8" src="./Wisdom of Life_files/jsc/jquery-1.11.0.js"></script>
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
			<div class="clear"></div>
			<div class="columns">
				<div class="static">
					
					<div  class="fullwidth left">
						<div class="tab_menu_container backcolr">
							<ul id="tab_menu">
								<li><a class="current" rel="feeds">Duyệt yêu cầu đăng ký leader</a></li>
							</ul>
							<div class="clear"></div>
						</div>
						<div class="clear"></div>
						<div class="tables">
							<table class="tableFB" border="0" cellspacing="0" cellpadding="0">
								<tbody>
									<tr class="upper backcolr">
										<th scope="col" class="c1">
										<h6 class="white bold">STT</h6>
										</th>
										
										<th scope="col" class="c2">
										<h6 class="white bold">Tên đăng nhập</h6>
										</th>
										
										<th scope="col" class="c3">
										<h6 class="white bold">Họ tên</h6>
										</th>
										
										<th scope="col" class="c4">
										<h6 class="white bold"></h6>
										</th>
										
										<th scope="col" class="c5">
										<h6 class="white bold"></h6>
										</th>	
									</tr>
									<logic:iterate name="thanhVienForm"
											property="danhSachDoanTruong" id="tenDangNhap">
									<tr>
										<bean:define id="STTN" name="tenDangNhap" property="soThuTu"></bean:define>
												<bean:define id="STT" type="java.lang.String" value="${STTN}"></bean:define>
										<td class="c1"><bean:write name="STT"/></td>
										<td class="c2"><bean:write name="tenDangNhap"
														property="tenDangNhap"/></td>
										<bean:define id="maLeader" name="tenDangNhap"
														property="tenDangNhap"></bean:define>
										<td class="c3"><a href="xemThanhVien.do?maLeader=<%=maLeader%>"><bean:write name="tenDangNhap"
														property="hoTen"/></a></td>
														
														<bean:define id="tenDangNhapN"
														name="tenDangNhap" property="tenDangNhap"></bean:define>
										<td class="c4">
											<img 
															src="./Wisdom of Life_files/images/Check.png" width="30px"
															height="30px" onclick="XacNhanDuyet('${tenDangNhapN}')"></img>
										</td>
										<td class="c5">
											
														<img 
															src="./Wisdom of Life_files/images/del.png" width="30px"
															height="30px" onclick="XacNhanXoa('${tenDangNhapN}')"></img>
													
										</td>
										
									</tr>
									</logic:iterate>
									
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
    <div class="clear"></div>
    <!-- Footer -->
    <jsp:include page="footer.jsp"></jsp:include>
    
</div>
</body>
</html>
<script>
	
	function XacNhanXoa(TenDangNhap) {
		if (confirm("Bạn có thực sự muốn xóa không?")) {
			location.href = "xoaDuyetDoanTruong.do?tenDangNhap=" +TenDangNhap;
		}
	}
	function XacNhanDuyet(TenDangNhap) {
		if (confirm("Bạn có thực sự muốn cho người này làm đoàn trưởng không?")) {
			location.href = "duyetXongDoanTruong.do?tenDangNhap=" +TenDangNhap;
		}
	}
</script>
