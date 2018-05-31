<%@page import="model.bo.ThanhVienBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0049)http://www.extracoding.com/html/wisdom/index.html -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>Danh sách đoàn trưởng</title>
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

<!--[if lte IE 7]><style>#controls{	margin:0px 0px 0px -80px;}</style><![endif]-->
<link rel="stylesheet" href="./Wisdom of Life_files/css/elements.css" />
<script type="text/javascript" async="" src="./Wisdom of Life_files/jsc/ga.js" ></script>
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

</head>
<body id="bdy">
<!-- Clouds effect -->
	<span class="grung backcolr">&nbsp;</span>
	<span class="blackstrip">&nbsp;</span>
	<span class="whitestrip">&nbsp;</span>
<!-- Outer Wrapper -->
	<div id="outer_wrapper"><!-- Header -->
		<jsp:include page="header.jsp">
			<jsp:param name="current3" value="current-menu-item" />
		</jsp:include>
		
		<div class="clear"></div>
		
		<!-- Banner -->
		<div id="subbanner">
			<div class="inner">
				<a href="#">
					<img src="./Wisdom of Life_files/images/banner2.jpg" alt="" />
				</a>
			</div>
		</div>
		
		<div class="clear"></div>
		<!-- Content Section -->

		<div id="contentsec">
			<div class="inner">
				<div class="clear"></div>
				<div class="columns">
					<div class="static">
						<div class="fullwidth left">
							<div class="tab_menu_container backcolr">
								<ul id="tab_menu">
									<li><a class="current" rel="feeds">Danh sách đoàn trưởng</a></li>
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
												<h6 class="white bold">Họ tên</h6>
												</th>
									
												<th scope="col" class="c3">
												<h6 class="white bold">Email</h6>
												</th>
									
												<th scope="col" class="c4">
												<h6 class="white bold">Ðánh giá</h6>
												</th>
												
												<th scope="col" class="c4">
												<h6 class="white bold">Danh sách chuyến đi</h6>
												</th>
									
											</tr>
											<logic:iterate id="truongdoan" name="danhSachTruongDoanForm"
												property="danhSachTruongDoan">
												<tr>
													<td class="c1"><bean:write name="truongdoan" property="soThuTu" /></td>
													<bean:define id="tenDangNhap" name="truongdoan"
														property="tenDangNhap"></bean:define>
									
													<td class="c2"><html:link
														action="/xemThanhVien?tenDangNhap=${tenDangNhap}">
														<bean:write name="truongdoan" property="hoTen" />
													</html:link></td>
													<td class="c3"><bean:write name="truongdoan" property="email" /></td>
									
													<td class="c4"><a onclick="div_show1('${tenDangNhap}')"><img
														src="./Wisdom of Life_files/images/feedback.png" width="20px"
														height="20px"></img></a></td>
														
													<td><a href="danhSachChuyenDiDoanTruong.do?trangSo=1&maLeader=<%=tenDangNhap%>">Các chuyến đi</a></td>
												</tr>
									
											</logic:iterate>
										</tbody>	
									</table>
								<div id='abc' style="display: none;" >
										<!-- Popup div starts here -->
										<div id="popupContact"><!-- contact us form -->
										<div class="formfeedback"><html:form styleId="form"
											action="/guiPhanHoiAction.do">
											<html:img src="./Wisdom of Life_files/images/close.png" styleId="close"
												onclick="div_hide1()" />
											<h2>Gửi phản hồi</h2>
											<hr />
											<html:hidden property="hidden" styleId="tendoantruong"/>
											<html:textarea property="tinNhan" styleId="msg"></html:textarea>
											<html:button property="nutSubmit" onclick='check_empty()'>Gửi</html:button>
										</html:form></div>
										</div>
										<!-- Popup div ends here -->
										</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include>
		
	</body>
</html>
