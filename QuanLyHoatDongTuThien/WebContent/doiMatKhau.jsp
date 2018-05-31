<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset= utf8" />
		<title>Đổi mật khẩu</title>
		<link href="./Wisdom of Life_files/css/style.css" rel="stylesheet" type="text/css"></link>
		<link href="./Wisdom of Life_files/css/red.css" rel="stylesheet" type="text/css"></link>
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
	
		<style>
		.spantext {
			width: 200px;
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
			<jsp:param name="current6" value="current-menu-item" />
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
			<div class="inner"><!-- Columns -->
				<div class="columns"><!-- Middle big section -->
					<div class="static">
						<div class="fullwidth left">
							<h4 class="heading backcolr">Đổi mật khẩu</h4>
							<div class="bigst">
								<html:form action="doiMatKhau">
									<ul style="width: 700px !important; margin-left:200px!important" class="dangbai">
									
										<li class="txt bold"><label> <span class="spantext">Mật khẩu cũ *</span>
										<html:password property="matKhauCu" styleClass="inputbox"></html:password>
										<div class="validate"><html:errors property="matKhauCu"/></div>
										</label>
										
										</li>
								
										<li class="txt bold"><label> <span class="spantext">Mật khẩu mới *</span> 
										<html:password property="matKhauMoi" styleClass="inputbox"></html:password>
										<div class="validate"><html:errors property="matKhau"/><html:errors property="matKhauKhongHopLe"/></div>
										</label></li>
								
										<li class="txt bold"><label> <span class="spantext">Xác nhận mật khẩu *</span>
										<html:password property="matKhauXacNhan" styleClass="inputbox"></html:password>
										<div class="validate"><html:errors property="matKhauXacNhan"/></div>
										</label></li>
								
										<li class="txt bold"><label style="margin-left: 220px">
										<html:submit styleClass="button medium" property="nutLuu" value="Lưu lại">Lưu</html:submit>
										</label> <label style="margin-left: 20px"> <html:button
											property="nutQuayLai" styleClass="button medium"
											onclick="history.go(-1);">Quay lại</html:button> </label></li>
									</ul>
								</html:form>
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
		<div id="footer">
	        <div class="inner">
	            <div class="clear"></div>
	            <!-- Footer Navigation -->
	            <div class="navi_bottom">
	            	<ul>
	                	<li><a href="" class="txthover">Trang chủ</a></li>
	                    <li><a href="" class="txthover">Danh sách chuyến đi</a></li>
	                    <li><a href="" class="txthover">Hình ảnh</a></li>
	                    <li><a href="" class="txthover">Liên lạc</a></li>
	                </ul>
	            </div>
	            <div class="clear"></div>
	        </div>
	    </div>
		
		<jsp:include page="footer.jsp"></jsp:include>
		
	</div>
	</body>
</html>
