
<%@page import="model.bean.BaiDang"%>
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
		<title>Duyệt bài đăng</title>
		<link href="./Wisdom of Life_files/css/style.css" rel="stylesheet"type="text/css"/>
		<link href="./Wisdom of Life_files/css/red.css" rel="stylesheet" type="text/css"/>
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
		<jsp:include page="header.jsp" />
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
									<li><a class="current" rel="feeds">Duyệt bài đăng</a></li>
								</ul>
								<div class="clear"></div>
							</div>
							<div class="clear"></div>
							<div class="tables">
							<div>
							<html:form action="/duyetBai" styleId="form" method="post">
							
								<select onchange="sapXep123()" name="sapXep" >
									<option>---Chọn---</option>
									<option value="NgayDi" >Ngày đi</option>
									<option value="TenDangNhapLeader">Tên</option>
								</select>
							
							</html:form>
							</div>
								<table class="tableFB" border="0" cellspacing="0" cellpadding="0">
									<tbody>
										<tr class="upper backcolr">
											<th scope="col" class="w1">
												<h6 class="white bold">STT</h6>
											</th>

											<th scope="col" class="w2">
												<h6 class="white bold">Tiêu đề</h6>
											</th>

											<th scope="col" class="w3">
												<h6 class="white bold">Tên đoàn trưởng</h6>
											</th>

											<th scope="col" class="w4">
												<h6 class="white bold">Thời gian</h6>
											</th>

											<th scope="col" class="w5">
												<h6 class="white bold"></h6>
											</th>

											<th scope="col" class="w6">
												<h6 class="white bold"></h6>
											</th>
										</tr>

										<logic:iterate name="duyetDangBaiForm"
											property="danhSachBaiDang" id="maBaiDang">
											<tr>
												<bean:define id="STTN" name="maBaiDang" property="soThuTu"></bean:define>
												<bean:define id="STT" type="java.lang.String" value="${STTN}"></bean:define>
												<td class="w1"><bean:write name="STT" /></td>
														<bean:define name="maBaiDang" property="maBaiDang" id="m" ></bean:define>
												<td class="w2"><a href="chiTietDuyetBai.do?maBaiDang=<%=m%>"><bean:write
															name="maBaiDang" property="tieuDe" /></a></td>
															<bean:define name="maBaiDang" property="tenDangNhapLeader" id="tdn" ></bean:define>
												<td class="w3"><a href="xemThanhVien.do?tenDangNhap=<%=tdn %>"><bean:write name="maBaiDang"
														property="tenDangNhapLeader" /></a></td>
												<td class="w4"><bean:write name="maBaiDang"
														property="ngayDang" /></td>

												<td class="w5"><bean:define id="maBaiDangN"
														name="maBaiDang" property="maBaiDang"></bean:define>
														 

														<img property="XacNhan"
															src="./Wisdom of Life_files/images/Check.png" width="30px"
															height="30px" onclick="XacNhan('${maBaiDangN}')"></img>
													</td>
												<td class="w6">

														<img property="XacNhanXoa"
															src="./Wisdom of Life_files/images/del.png" width="30px"
															height="30px" onclick="XacNhanXoa('${maBaiDangN}')"></img>
													</td>

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
	
		<jsp:include page="footer.jsp"></jsp:include>
	
	</div>
	
	<script type="text/javascript">
	
	function sapXep123(){
		
		document.getElementById("form").submit();
		
		//window.location.href = "duyetbai.do?sapXep=" +str;
	}
		function XacNhanXoa(maBaiDang) {
			if (confirm("Bạn có thực sự muốn xóa không?")) {
				location.href = "xoaBaiDang.do?maBaiDang=" +maBaiDang;
			}
		}
		function XacNhan(maBaiDang) {
			if (confirm("Bạn có thực sự xác nhận duyệt?")) {
				location.href = "suaBaiDang.do?maBaiDang=" +maBaiDang;
			}
		}
		
		
	</script>
</body>
</html>
