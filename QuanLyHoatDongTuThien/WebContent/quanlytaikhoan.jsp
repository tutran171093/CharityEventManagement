

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý tài khoản</title>
<link href="./Wisdom of Life_files/css/style.css" rel="stylesheet" type="text/css">
<link href="./Wisdom of Life_files/css/red.css" rel="stylesheet" type="text/css">
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
<script type="text/javascript">
	function banNick(hoTen){
		var r = confirm("Ban vĩnh viễn thành viên " + hoTen);
		if (r == false){
			this.event.returnValue = false;
		}
	}
	
	function thayDoi(quyen, hoTen){
		var r = confirm("Thay đổi chức vụ của " + hoTen);
		if (r == false){
			this.event.returnValue = false;
		}
	}
</script>
<!--[if lte IE 7]><style>#controls{	margin:0px 0px 0px -80px;}</style><![endif]-->

<style>
.spantext {
	width: 350px;
	display: block;
	float: left;
	text-align: left;
	padding-top: 10px
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
						<div class="fullwidth left">
							<div class="tab_menu_container backcolr">
								<ul id="tab_menu">
									<li><a class="current" rel="feeds">Quản lý tài khoản</a></li>
								</ul>
								<div class="clear"></div>
							</div>
							<div class="clear"></div>
							<html:form action="timkiem.do?trangSo=1" method="get">
								<div style="margin-top: 25px">
									
									<html:text styleClass="inputbox" property="maTimKiem"></html:text>
									<span>Tìm kiếm theo</span>
									<html:select property="timTheo" styleClass="inputbox">
										<html:option value="1">Tên đăng nhập</html:option>
										<html:option value="2">Tên thành viên</html:option>
									</html:select>
									<html:submit styleClass="button backcolr">Tìm kiếm</html:submit>
								</div>
							</html:form>

							<html:form action="/quanlytaikhoan" method="get">
								<div class="tables">
									<table class="tableFB" border="0" cellspacing="0" cellpadding="0">
										<tbody>
											<tr class="upper backcolr">
												<th scope="col" class="w1">
													<h6 class="white bold">STT</h6>
												</th>

												<th scope="col" class="w2" style="width:100px!important">
													<h6 class="white bold">Mã tài khoản</h6>
												</th>

												<th scope="col" class="w3">
													<h6 class="white bold">Tên chủ tài khoản</h6>
												</th>

												<th scope="col" class="w4">
													<h6 class="white bold">Email</h6>
												</th>

												<th scope="col" class="w5" style="width:200px!important">
													<h6 class="white bold">Thành viên-Đoàn trưởng</h6>
												</th>

												<th scope="col" class="w6">
													<h6 class="white bold">Ban nick</h6>
												</th>
											</tr>

											<logic:iterate id="tv" name="quanLyTaiKhoanForm"
												property="dsThanhVien">

												<tr>
													<td class="w1">${tv.soThuTu }</td>
													<td class="w2" style="width:100px!important"><a href="xemThanhVien.do?tenDangNhap=${tv.tenDangNhap }"> ${tv.tenDangNhap }</a></td>
													<td class="w3"><a href="xemThanhVien.do?tenDangNhap=${tv.tenDangNhap }"> ${tv.hoTen }</a></td>
													<td class="w4"><bean:write name="tv" property="email" /></td>
													<td class="w5" style="width:200px!important"><a
														href="thaydoichucvu.do?tenDangNhap=${tv.tenDangNhap }&trangSo=1"
														onClick="thayDoi('${tv.quyen}', '${tv.hoTen}')"> <logic:equal
																value="${tv.quyen }" property="quyen1"
																name="quanLyTaiKhoanForm">
																<img src="./Wisdom of Life_files/images/tv.png" width="90px"
																	height="30px"></img>
															</logic:equal> <logic:equal value="${tv.quyen }" property="quyen2"
																name="quanLyTaiKhoanForm">
																<img src="./Wisdom of Life_files/images/dt.png" width="90px"
																	height="30px"></img>
															</logic:equal>
															<logic:equal value="${tv.quyen }" property="quyen4"
																name="quanLyTaiKhoanForm">
																<img src="./Wisdom of Life_files/images/tv.png" width="90px"
																	height="30px"></img>
															</logic:equal>
													</a></td>
													<td class="w6"><a
														href="bannick.do?tenDangNhap=${tv.tenDangNhap }"
														onClick="banNick('${tv.hoTen}')"><img
															src="./Wisdom of Life_files/images/ban_nick.png" width="30px"
															height="30px"></img></a></td>
												</tr>
											</logic:iterate>
										</tbody>
									</table>
								</div>

								<div class="clear"></div>

								<div class="paging">
									<ul class="left">
										<li><h5 class="bold">Trang</h5></li>

										<bean:define id="trangSo" name="quanLyTaiKhoanForm"
											property="trangSo" type="java.lang.String"></bean:define>
										<logic:iterate name="quanLyTaiKhoanForm" property="soTrang"
											id="trang">
											<bean:define id="trangHienThi" name="trang"
												type="java.lang.String"></bean:define>
											<logic:equal value="<%=trangSo%>" name="trang">
												<li>
												<% 
													if(session.getAttribute("maTimKiem") == null)
													{
														%>
															<a	href="quanlytaikhoan.do?trangSo=<%=trangHienThi%>"
																class="backcolrhover backcolr"><bean:write name="trang" />
															</a>
														<%
													}
													else
													{
														%>
														<a	href="timKiemPhanTrang.do?trangSo=<%=trangHienThi%>"
															class="backcolrhover backcolr"><bean:write name="trang" />
														</a>
													<%
													}
												%>
													
												</li>
											</logic:equal>
											<logic:notEqual value="<%=trangSo%>" name="trang">
												<li><% 
													if(session.getAttribute("maTimKiem") == null)
													{
														%>
															<a	href="quanlytaikhoan.do?trangSo=<%=trangHienThi%>"
																class="backcolrhover"><bean:write name="trang" />
															</a>
														<%
													}
													else
													{
														%>
														<a	href="timKiemPhanTrang.do?trangSo=<%=trangHienThi%>"
															class="backcolrhover"><bean:write name="trang" />
														</a>
													<%
													}
												%></li>
											</logic:notEqual>
										</logic:iterate>


									</ul>

								</div>

								<div class="clear"></div>

								

							</html:form>
						</div>
					</div>
				</div>

				<div class="clear"></div>
				<!-- Footer -->
				<jsp:include page="footer.jsp"></jsp:include>
				
			</div>
		</div>
	</div>
</body>
</html>
