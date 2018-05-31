
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Danh sách chuyến đi</title>
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

<style type="text/css">
a:hover {
	cursor: pointer;
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
			<jsp:param name="current3" value="current-menu-item" />
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

					<div class="col1 left">
						<!-- Blog -->
						<div class="blog">
							<h4 class="heading backcolr">Danh sách các chuyến đi của 
								 <bean:write name="danhSachChuyenDiDoanTruong" property="tenDoanTruong"></bean:write></h4>
							<!-- Post -->

							<div class="newDiv"></div>

							<bean:define id="maLeaderL" name="danhSachChuyenDiDoanTruong"
								property="maLeader"></bean:define>

							<div class="clear"></div>
							<!-- Pagination -->

							<div class="paging">
								<ul class="left">

									<li><h5 class="bold">Page</h5></li>
									<bean:define id="trangSo" name="danhSachChuyenDiDoanTruong"
										property="trangSo" type="java.lang.String"></bean:define>

									<%
										int count = 1;
									%>
									<logic:iterate name="danhSachChuyenDiDoanTruong"
										property="soTrang" id="trang">
										<%
											count++;
										%>
									</logic:iterate>


									<logic:iterate name="danhSachChuyenDiDoanTruong"
										property="soTrang" id="trang">

										<bean:define id="trangHienThi" name="trang"
											type="java.lang.String"></bean:define>


										<li><a id="<%=trang%>" class="backcolrhover"
											onclick="hienThiBinhLuan('<%=trang%>','<%=count%>','<%=maLeaderL%>')">
												<bean:write name="trang" />
										</a></li>


									</logic:iterate>

								</ul>


							</div>


						</div>
					</div>


					<!-- Small side bar left -->
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
												<logic:iterate id="thanhVien"
													name="danhSachChuyenDiDoanTruong"
													property="danhSachDoanTruongTieuBieu">
													<li><bean:define id="maLeader" name="thanhVien"
															property="tenDangNhap"></bean:define> <bean:define
															id="urlHinhAnhDaiDien" name="thanhVien"
															property="urlAnhDaiDien"></bean:define>
														<div class="thumb">
															<a href="xemThanhVien.do?tenDangNhap=<%=maLeader%>"><img
																src="<%=urlHinhAnhDaiDien%>" alt="" /></a>
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
															<div class="rating-container rating-gly-star">
																<div class="rating-stars" style="width: 100%;">
																	<img
																		src="./Wisdom of Life_files/images/star-rating.png"
																		style="width: 80px; height: 16px;" alt="" />
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
								<script type="text/javascript"
									src="./Wisdom of Life_files/jsc/tabswidget.js"></script>
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







	<script type="text/javascript">

	

	function hienThiBinhLuan(trang,i,maLeader)
	{	
		
		$.ajax({
			                  type: "GET",
			                    url: "/QuanLyHoatDongTuThien/hienThiDanhSachChuyenDiDoanTruong.do?trang="+trang+"&maLeader="+maLeader,
			                    success: function(response){
			                        // we have the response
			                       
			                        $(".newDiv").html(response);
			                       	
			                    },
			                    error: function(e){
			                        alert('Error: ' + e);
			                    }
			                });
		
		
		
		length = parseFloat(i);
		for(var j = 1; j < length; j++)
		{
			var NAME = document.getElementById("" + j);
			NAME.className = "backcolrhover";
		}
		
		var NAME = document.getElementById(trang);
		NAME.className = "backcolrhover backcolr";
		
						
	}
	
</script>



	<script>
	
	var NAME = document.getElementById("1");
	NAME.className = "backcolrhover backcolr";
	
	hienThiBinhLuan('1','<%=count%>','<%=maLeaderL%>');

	
</script>





</body>
</html>
