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

<title>Trang chủ</title>
<!-- // Stylesheets // -->
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
<script type="text/javascript"
	src="./Wisdom of Life_files/jsc/tabswidget.js"></script>
<script src="./Wisdom of Life_files/jsc/my_js.js"></script>
<!--[if lte IE 7]><style>#controls{	margin:0px 0px 0px -80px;}</style><![endif]-->
<script type="text/javascript" charset="UTF-8"
	src="./Wisdom of Life_files/jsc/common.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="./Wisdom of Life_files/jsc/util.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="./Wisdom of Life_files/jsc/stats.js"></script>

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
			<jsp:param name="current1" value="current-menu-item" />
			<jsp:param name="current2" value="" />
			<jsp:param name="current3" value="" />
			<jsp:param name="current4" value="" />
		</jsp:include>
		<div class="clear"></div>
		<!-- Banner -->
		<div id="banner">
			<div class="inner">
				<div class="slider-wrapper theme-default">
					<div class="ribbon"></div>
					<div id="slider" class="nivoSlider"
						style="position: relative; height: 316px; background: url(./Wisdom of Life_files/images/banner1.jpg) no-repeat">
						<a href="" class="nivo-imageLink" style="display: none;"><img
							src="./Wisdom of Life_files/images/banner1.jpg" title="#banner1"
							alt="" style="display: none;" /></a> <a href=""
							class="nivo-imageLink" style="display: block;"><img
							src="./Wisdom of Life_files/images/banner2.jpg" title="#banner2"
							alt="" style="display: none;" /></a> <a href=""
							class="nivo-imageLink" style="display: none;"><img
							src="./Wisdom of Life_files/images/banner3.jpg" title="#banner3"
							alt="" style="display: none;" /></a> <a href=""
							class="nivo-imageLink" style="display: none;"><img
							src="./Wisdom of Life_files/images/banner4.jpg" title="#banner4"
							alt="" style="display: none;" /></a>

						<div class="nivo-directionNav" style="display: none;">
							<a class="nivo-prevNav">Trước</a> <a class="nivo-nextNav">Sau</a>
						</div>

					</div>
				</div>
			</div>
		</div>
		<div class="clear"></div>
		<!-- Content Section -->
		<div id="contentsec">
			<div class="inner">

				<div class="clear"></div>
				<!-- Columns -->
				<div class="columns">

					<!-- Middle big section -->
					<div class="barbig left padright">
						<div class="clear"></div>
						<!-- Tabs Section -->
						<div class="tabssection">
							<!-- Tabs -->
							<div class="tab_menu_container backcolr">
								<ul id="tab_menu">
									<li><a class="current" rel="feeds">Các bài đăng mới</a></li>
								</ul>
								<div class="clear"></div>
							</div>
							<div class="clear"></div>
							<!-- Tabs Container -->
							<div class="tab_container">
								<div class="tab_container_in">
									<!-- News Feeds -->
									<div id="feeds" class="tab_sidebar_list feedsec"
										style="display: block;">
										<!-- Tab Banner -->
										<div class="tabbanner">
											<%
												int i = 0;
											%>
											<div class="captions bordercolr">
												<logic:iterate id="baiDang" name="trangChuForm"
													property="danhSachBaiDangNoiBat">
													<%
														String maChuyenDi = "";
															if (i == 0) {
													%>
													<bean:define id="chuyenDiTop" name="baiDang"></bean:define>
													<%
														i++;
															}
													%>

												</logic:iterate>

												<%
													if (i != 0) {
												%>
												<bean:define id="maChuyenDiTop" name="chuyenDiTop"
													property="maBaiDang"></bean:define>
												<bean:define id="urlHinhAnh" name="chuyenDiTop"
													property="urlHinhAnh"></bean:define>
												<h5>
													<a
														href="chiTietBaiDang.do?maChuyenDi=<%=maChuyenDiTop%>&trangSo=1"
														class="white bold"> <bean:write name="chuyenDiTop"
															property="tieuDe"></bean:write></a>
												</h5>
												<p>
													<bean:write name="chuyenDiTop" property="noiDungVanTat" />
												</p>




											</div>
											<a
												href="chiTietBaiDang.do?maChuyenDi=<%=maChuyenDiTop%>&trangSo=1"
												class="thumb"><img src="<%=urlHinhAnh%>"
												style="width: 700px; height: 200px" alt="" /></a>
											<%
												}
											%>
										</div>



										<!-- Feeds Listings -->
										<div class="feedlist testimonial_wrapp"
											style="overflow: hidden; position: relative; height: 72px;">
											<ul style="height: 0px; margin-top: -279px;">
												<logic:iterate id="baiDang" name="trangChuForm"
													property="danhSachBaiDangNoiBat">

													<li style="float: left; display: block; margin-top: 0px;">
														<bean:define id="maChuyenDi" name="baiDang"
															property="maBaiDang"></bean:define> <bean:define
															id="hinhAnh" name="baiDang" property="urlHinhAnh"></bean:define>
														<a
														href="chiTietBaiDang.do?maChuyenDi=<%=maChuyenDi%>&trangSo=1"
														class="thumb"> <img src="<%=hinhAnh%>" alt=""
															width="118px" height="70px" /></a>
														<div class="desc">
															<h5>
																<a
																	href="chiTietBaiDang.do?maChuyenDi=<%=maChuyenDi%>&trangSo=1"
																	class="bold txthover"><bean:write name="baiDang"
																		property="tieuDe" /></a>
															</h5>
															<p>
																<bean:write name="baiDang" property="noiDungVanTat" />
															</p>
															<bean:define id="docTiep" name="baiDang"
																property="maBaiDang"></bean:define>
															<a
																href="chiTietBaiDang.do?maChuyenDi=<%=maChuyenDi%>&trangSo=1"
																class="readmore txthover">Đọc tiếp</a>
														</div>
													</li>

												</logic:iterate>
											</ul>
										</div>

										<div class="slidebuttons">
											<p class="txt">
												<a href="danhSachChuyenDi.do?trangSo=1" class="txthover">Xem
													thêm các chuyến đi</a>
											</p>
										</div>
									</div>
									<!-- END -->
									<div class="clear"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="barsmall right">
						<!-- Widget -->
						<div class="widget">
							<div class="widgettabs">
								<!-- Tabs -->
								<div class="tab_menu_container backcolr">
									<ul id="tab_menu1">
										<li><a class="current" rel="blogswidget">Đoàn trưởng
												tiêu biểu</a></li>
									</ul>
									<div class="clear"></div>
								</div>
								<div class="clear"></div>
								<!-- widget tabs -->
								<div class="blogtweets">
									<div class="tab_container_in">
										<!-- News Feeds -->
										<div id="blogswidget" class="tab_sidebar_list blogsc"
											style="display: block;">
											<ul style="width: 240px">
												<logic:iterate id="thanhVien" name="trangChuForm"
													property="danhSachDoanTruongTieuBieu">
													<li><bean:define id="maLeader" name="thanhVien"
															property="tenDangNhap"></bean:define>
														<div class="thumb">
															<bean:define id="urlHinhAnhDaiDien" name="thanhVien"
																property="urlAnhDaiDien"></bean:define>
															<a href="xemThanhVien.do?tenDangNhap=<%=maLeader%>">
																<img src="<%=urlHinhAnhDaiDien%>" alt="" width=""
																height="" />
															</a>
														</div>
														<div>
															<bean:define id="soLanToChucChuyenDiTC" name="thanhVien"
																property="soLanToChucThanhCong"></bean:define>
															<bean:define id="soLanToChucChuyenDiTCN"
																value="${soLanToChucChuyenDiTC}" type="java.lang.String"></bean:define>

															<a href="xemThanhVien.do?tenDangNhap=<%=maLeader%>">
																<bean:write name="thanhVien" property="hoTen"></bean:write>
															</a> <br /> <label>Tổ chức thành công: <b><bean:write
																		name="soLanToChucChuyenDiTCN"></bean:write></b> chuyến đi
															</label>
															<!--Gắn sao chỗ này-->
															<%
																int ran = 0;
																	ran = new ThanhVienBO().getTaiKhoan(maLeader.toString()).getSoLanToChucThanhCong();
																	String image = "";
																	if (ran == 0) {
																		image = "./Wisdom of Life_files/images/0.png";
																	} else if (ran <= 5) {
																		image = "./Wisdom of Life_files/images/1.png";
																	} else if (ran <= 15) {
																		image = "./Wisdom of Life_files/images/2.png";
																	} else if (ran <= 30) {
																		image = "./Wisdom of Life_files/images/3.png";
																	} else if (ran <= 60){
																		image = "./Wisdom of Life_files/images/4.png";
																	} else{
																		image = "./Wisdom of Life_files/images/5.png";
																	}
															%>
															<div class="rating-container rating-gly-star">
																<div class="rating-stars" style="width: 100%;">
																	<img src="<%=image %>" style="width: 80px; height: 16px;" alt="" />
																</div>
															</div>
														</div></li>
												</logic:iterate>
											</ul>
										</div>

										<!-- END -->
										<div class="clear"></div>
									</div>

								</div>

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
</body>
</html>