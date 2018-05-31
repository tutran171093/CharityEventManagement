<%@page import="model.bo.ThanhVienBO"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Trang cá nhân</title>
<link href="./Wisdom of Life_files/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="./Wisdom of Life_files/css/red.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="./Wisdom of Life_files/css/elements.css" />
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
<script type="text/javascript"
	src="./Wisdom of Life_files/jsc/tabswidget.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/ga.js"></script>
<script src="./Wisdom of Life_files/jsc/my_js.js"></script>
<!--[if lte IE 7]><style>#controls{	margin:0px 0px 0px -80px;}</style><![endif]-->
<script type="text/javascript" charset="UTF-8"
	src="./Wisdom of Life_files/jsc/common.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="./Wisdom of Life_files/jsc/util.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="./Wisdom of Life_files/jsc/stats.js"></script>
<!--[if lte IE 7]><style>#controls{	margin:0px 0px 0px -80px;}</style><![endif]-->

<style>
	.spantext {
		width: 100px;
		display: block;
		float: left;
		text-align: left; 
		padding-top:10px
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
	<div id="contentsec" >
		<div class="inner">
			<div class="columns">
				<div class="static">
					<div class="twcol right">
						<h5 class="heading white backcolr bold">Thông tin cá nhân</h5>
						
						<div class="twcolin">
							<div class="quickenquiry">
							<html:form action="xemThanhVien"  method="post">
								<div>
									<ul>
										<li class="txt bold">
											<label>
												<span for="hoten" class="spantext">Họ tên</span>
												<html:text name="trangCaNhanForm" property="hoTen" styleClass="inputbox" readonly="true"></html:text>
												
											</label>
										</li>
										
										<li class="txt bold">
											<label>
												<span for="email" class="spantext">Email</span>
												<html:text name="trangCaNhanForm" property="email"  styleClass="inputbox" readonly="true" ></html:text>
											</label>
										</li>
										
										<li class="txt bold">
											<label>
												<span for="ngaysinh" class="spantext">Ngày sinh</span>
												<html:text name="trangCaNhanForm" property="ngaySinh" styleClass="inputbox" readonly="true" ></html:text>
											</label>
										</li>
										
										<li class="txt bold">
											<label>
												<span for="gioitinh" class="spantext">Giới tính</span>
												<div style="width:200px;margin-left: 120px;display: block;padding-top: 10px;margin-bottom: 15px;">
													<html:radio name="trangCaNhanForm"  property="gioiTinh" value="1" disabled="true">Nam</html:radio>
													<html:radio property="gioiTinh" value="0" style="margin-left:20px" disabled="true">Nữ</html:radio>
												</div>
											</label>
										</li>
										
										<li class="txt bold">
											<label>
												<span for="cmnd" class="spantext">CMND</span>
												<html:text name="trangCaNhanForm" property="CMND" styleClass="inputbox" readonly="true"></html:text>
											</label>
										</li>
										
										<li class="txt bold">
											<label>
												<span for="diachi" class="spantext">Địa chỉ</span>										
												<html:text name="trangCaNhanForm" property="diaChi"  styleClass="inputbox" readonly="true"></html:text>
											</label>
										</li>
										
										<li class="txt bold">
											<label>
												<span for="noicongtac" class="spantext">Nơi công tác</span>
												<html:text name="trangCaNhanForm" property="noiCongTac" styleClass="inputbox" readonly="true"></html:text>
											</label>
										</li>
										
										<li class="txt bold">
											<label>
												<span for="nghenghiep" class="spantext">Nghề nghiệp</span>
												<html:text name="trangCaNhanForm" property="ngheNghiep"  styleClass="inputbox" readonly="true"></html:text>
											</label>
										</li>
										
										<li class="txt bold">
											<label>
												<span for="sdt" class="spantext">SDT</span>
												<html:text name="trangCaNhanForm" property="SDT"  styleClass="inputbox" readonly="true"></html:text>
											</label>
										</li>
									</ul>
								</div>
								</html:form>
								<div class="clear"></div>
							</div>
						</div>
						
					</div>
					<div class="smalcol nomarg left">
						<div class="smalcolin">
							<bean:define id="urlHinhAnh" name="trangCaNhanForm" property="urlAnhDaiDien"></bean:define>
							<img src="<%=urlHinhAnh%>" width="150px" height="150px" style=" margin-left: 38px; margin-top: 10px;" alt=""></img>
							<h3 style="text-align:center"> <bean:write name="trangCaNhanForm" property="hoTen" /> </h3>
							<br>
							<bean:define id="DND" name="trangCaNhanForm" property="diemNangDong" type="java.lang.Integer"></bean:define>
							<bean:define id="DNDO" value="${DND}" type="java.lang.String"></bean:define>
							<bean:define id="SLTC" name="trangCaNhanForm" property="soLanToChucThanhCong" type="java.lang.Integer"></bean:define>
							<bean:define id="SLTCO" value="${SLTC}" type="java.lang.String"></bean:define>
							<bean:define id="SLTB" name="trangCaNhanForm" property="soLanToChucThatBai" type="java.lang.Integer"></bean:define>
							<bean:define id="TDN" name="trangCaNhanForm" property="tenDangNhap" ></bean:define>
							<bean:define id="SLTBN" value="${SLTB}" type="java.lang.String"></bean:define>
							<h6>Điểm năng động: <bean:write name="DNDO"></bean:write></h6>
							<h6>Số chuyến đi tổ chức thành công: <bean:write name="SLTCO" /></h6>
							<%
							int ran = 0;
							ran = new ThanhVienBO().getTaiKhoan(TDN.toString()).getSoLanToChucThanhCong();
							String image = "";
							if (ran == 0) {
								image = "./Wisdom of Life_files/images/0.png";
							} else if (ran <= 5) {
								image = "./Wisdom of Life_files/images/1.png";
							} else if (ran <= 15) {
								image = "./Wisdom of Life_files/images/2.png";
							} else if (ran <= 30) {
								image = "./Wisdom of Life_files/images/3.png";
							} else if (ran <= 60) {
								image = "./Wisdom of Life_files/images/4.png";
							}else{
								image = "./Wisdom of Life_files/images/5.png";
							}
							%>
							<div class="rating-stars" style="width: 100%;">
								<img src="<%=image %>" style="width:80px;height:16px;" alt=""/>
							</div>
							<div class="clear"></div>
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
