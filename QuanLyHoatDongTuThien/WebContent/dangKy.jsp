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

<!-- KHÔNG ĐƯỢC XÓA -->
<script type="text/javascript"
	src="./Wisdom of Life_files/jsc/jquery.ui.core.js"></script>
<script type="text/javascript"
	src="./Wisdom of Life_files/jsc/jquery.ui.widget.js"></script>
<script type="text/javascript"
	src="./Wisdom of Life_files/jsc/jquery.ui.datepicker.js"></script>


<script>
	$(function() {
		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true
		});
	});
</script>

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
		<jsp:include page="header.jsp" />
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
					<div class="barbig left padright">
						<div class="clear"></div>
						<!-- Tabs Section -->
						<div class="tabssection">
							<!-- Tabs -->
							<div class="tab_menu_container backcolr"
								style="width: 1000px !important;">
								<ul id="tab_menu">
									<li><a class="current" rel="feeds">Đăng ký tài khoản</a></li>
								</ul>
								<div class="clear"></div>
							</div>
							<div class="clear"></div>
							<html:form action="dangKy">
								<!-- Tabs Container -->
								<div class="quickenquiry">
									<div class="tab_container" style="width: 1000px !important;">
										<div class="tab_container_in">
											<div>

												<ul style="width: 700px !important; margin-left: 200px">
													<li class="txt bold"><label> <span
															class="spantext">Tài khoản *</span> <html:text
																property="taiKhoan" styleId="username"
																onkeyup="kiemTraTaiKhoan()" value=""
																styleClass="inputbox"></html:text>
															<div class="validate">
																<html:errors property="taiKhoan" />
																<html:errors property="taiKhoanKhongHopLe" />
															</div>
													</label>
														<div class="checkTK"></div></li>

													<li class="txt bold"><label> <span
															for="password" class="spantext">Mật khẩu *</span> <html:password
																property="matKhau" styleId="username" value=""
																styleClass="inputbox"></html:password>
															<div class="validate">
																<html:errors property="matKhau" />
																<html:errors property="matKhauKhongHopLe" />
															</div>
													</label></li>

													<li class="txt bold"><label> <span
															for="confirmPassword" class="spantext">Xác nhận
																mật khẩu *</span> <html:password property="matKhauXN"
																styleId="username" value="" styleClass="inputbox"></html:password>
															<div class="validate">
																<html:errors property="matKhauXacNhan" />
															</div>
													</label></li>

													<li class="txt bold"><label> <span for="hoten"
															class="spantext">Họ tên *</span> <html:text
																property="hoTen" styleId="username" value=""
																styleClass="inputbox"></html:text>
															<div class="validate">
																<html:errors property="hoTen" />
															</div>
													</label></li>


													<li class="txt bold"><label> <span
															for="ngaysinh" class="spantext">Ngày sinh *</span> <html:text
																property="ngaySinh" styleId="datepicker"
																styleClass="inputbox"></html:text>
															<div class="validate">
																<html:errors property="ngaySinh" />
																<html:errors property="ngaySinhKhongHopLe" />
															</div>
													</label></li>

													<li class="txt bold"><label> <span
															class="spantext">Email *</span> <html:text
																property="email" styleId="username" value=""
																styleClass="inputbox"></html:text>
															<div class="validate">
																<html:errors property="email" />
															</div>
															<div class="validate">
																<html:errors property="emailKhongHopLe" />
															</div>
													</label></li>
													<!--checkbox Đồng ý với điều khoản-->



													<div class="clear"></div>
													<li class="txt bold"><label
														style="margin-left: 20px !important"> <span
															class="spantext" type="hidden"></span> <input
															type="submit" value="Đăng ký" name="submit"
															class="button medium" />
													</label></li>
												</ul>
											</div>
											<div class="clear"></div>
										</div>
									</div>
								</div>
							</html:form>

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







	<script type="text/javascript">
		function kiemTraTaiKhoan() {
			var trang = document.getElementById('username').value;
			$.ajax({
				type : "GET",
				url : "/QuanLyHoatDongTuThien/kiemTraTaiKhoan.do?search="
						+ trang,
				success : function(response) {
					$(".checkTK").html(response);
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});

		}
	</script>

</body>
</html>
