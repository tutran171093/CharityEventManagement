<%@page import="model.bean.BaiDang"%>
<%@page import="model.bean.ThanhVien"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bo.ThanhVienBO"%>
<%@page import="model.bo.BaiDangBO"%>
<%@page import="model.bo.DangKyChuyenDiBO"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Chi tiết bài đăng</title>




<link href="./Wisdom of Life_files/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="./Wisdom of Life_files/css/red.css" rel="stylesheet"
	type="text/css" />
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

<link rel="stylesheet" href="./Wisdom of Life_files/css/elements.css" />
<script type="text/javascript" src="./Wisdom of Life_files/jsc/ga.js"></script>

<script type="text/javascript" src="./Wisdom of Life_files/jsc/my_js.js"></script>


<script type="text/javascript">
	var _gaq = _gaq || [];
	_gaq.push([ '_setAccount', 'UA-43981329-1' ]);
	_gaq.push([ '_trackPageview' ]);
	(function() {
		var ga = document.createElement('script');
		ga.type = 'text/javascript';
		ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl'
				: 'http://www')
				+ '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(ga, s);
	})();
</script>




<script type="text/javascript">
	function xoaChuyenDi(maChuyenDi) {
		if (confirm("Xóa chuyến đi?")) {
			window.location.href = "xoaChuyenDi.do?maChuyenDi=" + maChuyenDi;
		}
	}

	function xacNhanHoanThanh(maChuyenDi) {
		if (confirm("Xác nhận đã hoàn thành chuyến đi?")) {
			window.location.href = "xacNhanHoanThanhChuyenDi.do?maChuyenDi="
					+ maChuyenDi;
		}
	}
</script>


<style type="text/css">
a:hover {
	cursor: pointer;
}
</style>


<!--[if lte IE 7]><style>#controls{	margin:0px 0px 0px -80px;}</style><![endif]-->
</head>
<body id="bdy">


	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.0";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>

	<!-- Clouds effect -->
	<span class="grung backcolr">&nbsp;</span>
	<span class="blackstrip">&nbsp;</span>
	<span class="whitestrip">&nbsp;</span>
	<!-- Outer Wrapper -->
	<div id="outer_wrapper">
		<!-- Header -->
		<jsp:include page="header.jsp">
			<jsp:param name="current2" value="current-menu-item" />
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
				<div class="col1 left">

					<div class="blog">
						<!--Tiêu đề bài đăng-->
						<h4 class="heading backcolr">
							<bean:write name="chiTietBaiDang" property="tieuDe"></bean:write>
						</h4>
						<!-- Chi tiết bài đăng -->
						<div class="post detail">
							<div class="postoptions">
								<ul>
									<bean:define id="maLeader" name="chiTietBaiDang"
										property="tenDangNhapLeader"></bean:define>
									<li class="author"><a
										href="xemThanhVien.do?tenDangNhap=<%=maLeader%>"
										class="txthover"><bean:write name="chiTietBaiDang"
												property="tenChuTaiKhoanLeader"></bean:write></a></li>
									<li class="date"><bean:write name="chiTietBaiDang"
											property="ngayDang"></bean:write></li>
									<li class="coments"><bean:write name="chiTietBaiDang"
											property="soLuongBinhLuan"></bean:write> Comments</li>
								</ul>
							</div>

							<div class="thumb">
								<bean:define id="urlHinhAnh" name="chiTietBaiDang"
									property="urlHinhAnh"></bean:define>
								<a href=""><img src="<%=urlHinhAnh%>" alt="" width="703px"
									height="200px" /></a>
							</div>
							<div class="postdesc" style="word-wrap: break-word;">
								<p>
									<bean:write name="chiTietBaiDang" property="noiDung"></bean:write>
								</p>
							</div>

							<div class="clear"></div>
						</div>
					</div>
					<div class="clear"></div>
					<!-- Comments -->
					<div class="commentsec">
						<h4 class="heading backcolr">
							<bean:write name="chiTietBaiDang" property="soLuongBinhLuan"></bean:write>
							bình luận cho bài đăng này
						</h4>


						<div id="BinhLuan">


							<span class="newDiv" style="word-wrap: break-word"></span>


						</div>



						<div class="clear"></div>
						<!-- Pagination -->
						<div class="paging">
							<bean:define id="maChuyenDi" name="chiTietBaiDang"
								property="maBaiDang" type="java.lang.String"></bean:define>

							<ul class="left">
								<li>
									<h5 class="bold">Page</h5>
								</li>
								<bean:define id="trangSo" name="chiTietBaiDang"
									property="trangSo" type="java.lang.String"></bean:define>

								<%
									int count = 1;
								%>

								<logic:iterate name="chiTietBaiDang" property="soTrang"
									id="trang">
									<%
										count++;
									%>
								</logic:iterate>

								<logic:iterate name="chiTietBaiDang" property="soTrang"
									id="trang">
									<bean:define id="trangHienThi" name="trang"
										type="java.lang.String"></bean:define>

									<li><a id="<%=trang%>" class="backcolrhover"
										onclick="hienThiBinhLuan('<%=trang%>','<%=maChuyenDi%>','<%=count%>')"><bean:write
												name="trang" /></a></li>


								</logic:iterate>
							</ul>

						</div>
					</div>
					<div class="clear"></div>
					<!-- Leave A Reply -->
					<%
						if (session.getAttribute("tenDangNhap") != null) {
					%>
					<div class="respond">
						<h4 class="heading backcolr">Để lại bình luận</h4>

						<html:form method="POST"
							action="binhLuan.do?maChuyenDi=${maChuyenDi}&trangSo=1">

							<p>
								<label class="colr bold">Bình luận</label>
								<html:textarea styleId="binhLuan" property="noiDungBinhLuan"
									rows="5" cols=""></html:textarea>
							</p>
							<p class="form-submit">
								<input type="button" class="backcolr"
									onclick="capNhatBinhLuan('<%=maChuyenDi%>')" value="Bình luận" />
							</p>
						</html:form>
					</div>
					<%
						}
					%>

					<div class="clear"></div>
				</div>
				<div class="barsmall right">
					<!--THÔNG TIN VỀ CHUYẾN ĐI-->
					<div class="widget">
						<h4 class="headng backcolr">Thông tin</h4>
						<!-- Donation Widget -->
						<div class="donation">
							<p>
								Ngày đi: <b><bean:write name="chiTietBaiDang"
										property="ngayDi"></bean:write></b>
							</p>
							<p>
								Địa điểm: <b><bean:write name="chiTietBaiDang"
										property="diaDiem"></bean:write></b>
							</p>
							<bean:define id="kinhPhi" name="chiTietBaiDang"
								property="kinhPhiDuKien" type="java.lang.Long"></bean:define>
							<bean:define id="kinhPhiN" type="java.lang.String"
								value="${kinhPhi}"></bean:define>
							<p>
								Kinh phí dự kiến/người: <b><bean:write name="kinhPhiN"></bean:write></b>
							</p>
							<bean:define id="soNguoi" name="chiTietBaiDang"
								property="soNguoiDuKien" type="java.lang.Integer"></bean:define>
							<bean:define id="soNguoiN" type="java.lang.String"
								value="${soNguoi}"></bean:define>
							<p>
								Số người tham gia dự kiến: <b><bean:write name="soNguoiN"></bean:write></b>
							</p>
							<p>Số người đã đăng ký:</p>

							<div class="collection">
								<img onclick='table_show2()'
									src="./Wisdom of Life_files/images/like.png" width="60px"
									height="60px" style="margin-left: 50px"></img>
								<bean:define id="soNguoiDangKy" name="chiTietBaiDang"
									property="soNguoiDangKyThamGia" type="java.lang.Integer"></bean:define>
								<bean:define id="soNguoiDangKyN" type="java.lang.String"
									value="${soNguoiDangKy}"></bean:define>
								<span class="target bold" style="font-size: 40px"><bean:write
										name="soNguoiDangKyN"></bean:write></span>
							</div>
							<%
								BaiDang baiDangN = new BaiDangBO().getChuyenDi(maChuyenDi);
														if(baiDangN.getTrangThai() != 2){
																		if (session.getAttribute("tenDangNhap") == null) {

																		} else if (new ThanhVienBO().getTaiKhoan(
																				session.getAttribute("tenDangNhap").toString()).getQuyen() == 3) {
							%>

							<!--  -->
							<%
								
							%>
							<div>
								<a onclick="xoaChuyenDi('<%=maChuyenDi%>')"> <img
									src="./Wisdom of Life_files/images/exit.png" width="50px"
									height="50px" style="margin-left: 5px"></img>
								</a>
							</div>
							<%
								} else if (new BaiDangBO().kiemTraDoanTruongChuyenDi(session
																				.getAttribute("tenDangNhap").toString(), maChuyenDi)) {
													if(new BaiDangBO().getChuyenDi(maChuyenDi).getTrangThai() == 1)
													{
							%>
							<div>
								<a onclick="xacNhanHoanThanh('<%=maChuyenDi%>')"> <img
									src="./Wisdom of Life_files/images/Check.png" width="60px"
									height="60px"></img>
								</a>
							</div>
							<div>
								<a onclick="xoaChuyenDi('<%=maChuyenDi%>')"> <img
									src="./Wisdom of Life_files/images/exit.png" width="50px"
									height="50px" style="margin-left: 5px"></img>
								</a>
							</div>
							<div>
								<a onclick="table_show()"><img
									src="./Wisdom of Life_files/images/user_male.png" width="50px"
									height="50px" style="margin-left: 5px"></img></a>
							</div>
							<%
								}
							%>



							<%
								} else if (new DangKyChuyenDiBO().kiemTraDangKy(session
																				.getAttribute("tenDangNhap").toString(), maChuyenDi)) {
							%>
							<h2 class="bold backcolr donbtn">
								<a
									href="huyDangKyChuyenDi.do?tenDangNhap=<%=session.getAttribute("tenDangNhap").toString()%>&maChuyenDi=<%=maChuyenDi%>">Hủy
									đăng ký</a>
							</h2>
							<%
								} else {
							%>
							<h2 class="bold backcolr donbtn">
								<a
									href="dangKyChuyenDi.do?tenDangNhap=<%=session.getAttribute("tenDangNhap").toString()%>&maChuyenDi=<%=maChuyenDi%>">Đăng
									ký</a>
							</h2>
							<%
								}
												}
							%>
						</div>
					</div>


					<!-- Facebook -->
					<div class="widget">
						<!-- Facebook -->
						<div class="facebookwidget">

							<div class="fb-like"
								data-href="https://www.facebook.com/FacebookDevelopers"
								data-layout="standard" data-action="like" data-show-faces="true"
								data-share="true"></div>


							<div class="fb-facepile"
								data-href="https://www.facebook.com/FacebookDevelopers"
								data-max-rows="5" data-colorscheme="light" data-size="large"
								data-show-count="true"></div>

						</div>
					</div>



					<div class="widget">
						<div class="widgettabs">
							<!-- Tabs -->
							<div class="tab_menu_container backcolr">
								<ul id="tab_menu1">
									<li><a class="current" rel="blogswidget">Các chuyến đi
											mới nhất</a></li>
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
										<ul style="word-wrap: break-word;">

											<logic:iterate id="baiDang" name="chiTietBaiDang"
												property="danhSachChuyenDiMoiNhat">
												<li><bean:define id="maLeaderN" name="baiDang"
														property="tenDangNhapLeader"></bean:define>
													<div class="thumb">
														<a href="xemThanhVien.do?tenDangNhap=<%=maLeaderN%>">
															<bean:define id="urlHinhAnhCD" name="baiDang"
																property="urlHinhAnh"></bean:define> <img
															src="<%=urlHinhAnhCD%>" alt="" width="703px"
															height="200px" />
														</a>
													</div> <bean:define id="maBaiDang" name="baiDang"
														property="maBaiDang"></bean:define>
													<div>
														<b><a
															href="chiTietBaiDang.do?maChuyenDi=<%=maBaiDang%>&trangSo=1"><bean:write
																	name="baiDang" property="tieuDe"></bean:write></a></b> <br />
														<!--Giới thiệu ngắn về chuyến đi-->
														<p>
															<bean:write name="baiDang" property="noiDungVanTat"></bean:write>
														</p>
														<p style="padding-left: 70px;">
															Đoàn trưởng:
															<bean:write name="baiDang"
																property="tenChuTaiKhoanLeader"></bean:write>
														</p>
														<p style="margin-left: 70px">
															<bean:write name="baiDang" property="ngayDang"></bean:write>
														</p>
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




					<div id="table" style="display: none;">
						<!-- Popup div starts here -->
						<div id="popupDSthanhvien">
							<!-- contact us form -->
							<div class="formtable">
								<img src="./Wisdom of Life_files/images/close.png" id="close"
									onclick="table_hide()" />
								<h2>Danh sách thành viên đã đăng ký</h2>
								<hr />

								<div>
									<html:form action="checkThanhVien">
										<input type="hidden" name="maChuyenDiCheck"
											value="<%=maChuyenDi%>" />
										<table border="0" cellspacing="0" cellpadding="0"
											style="width: 450px !important;">
											<tbody>
												<tr class="upper backcolr">
													<th scope="col" width="10%">
														<h6 class="white bold">STT</h6>
													</th>

													<th scope="col" width="70%">
														<h6 class="white bold">Tên dăng nhập</h6>
													</th>

													<th scope="col" width="10%">
														<h6 class="white bold"></h6>
													</th>
												</tr>


												<%
													ArrayList<ThanhVien> danhSachThanhVienDangKy = new DangKyChuyenDiBO()
																																					.getDanhSachThanhVienDangKyDi(maChuyenDi);
																																					System.out.print(danhSachThanhVienDangKy.size());
																																			for (int i = 1; i <= danhSachThanhVienDangKy.size(); i++) {
																																				ThanhVien tv = danhSachThanhVienDangKy.get(i-1);
												%>
												<tr>
													<td width="10%"><%=i%></td>
													<td width="70%"><a
														href="xemThanhVien.do?tenDangNhap=<%=tv.getTenDangNhap()%>"
														target="_blank"><%=tv.getHoTen()%></a></td>
													<td width="10%">
														<%
															if(new DangKyChuyenDiBO().kiemTraDaXacNhanDi(tv.getTenDangNhap(), maChuyenDi))
																																							{
														%> <input type="checkbox" checked="checked"
														name="danhSachThanhVienN" value="<%=tv.getTenDangNhap()%>" />
														<%
															}
																																							else
																																							{
														%> <input type="checkbox" name="danhSachThanhVienN"
														value="<%=tv.getTenDangNhap()%>" /> <%
 	}
 %>
													</td>
												</tr>
												<%
													}
												%>
											</tbody>
										</table>
										<input type="submit" class="small button blue"
											value="Xác nhận"></input>
									</html:form>
									<div class="clear"></div>


								</div>
							</div>
						</div>
						<!-- Popup div ends here -->
					</div>






					<!-- Popup xem dang ky -->

					<div id="table2" style="display: none;">
						<!-- Popup div starts here -->
						<div id="popupDSthanhvien">
							<!-- contact us form -->
							<div class="formtable">
								<img src="./Wisdom of Life_files/images/close.png" id="close"
									onclick="table_hide2()" />
								<h2>Danh sách thành viên đã đăng ký</h2>
								<hr />

								<div>
									<html:form action="checkThanhVien">
										<input type="hidden" name="maChuyenDiCheck"
											value="<%=maChuyenDi%>" />
										<table border="0" cellspacing="0" cellpadding="0"
											style="width: 450px !important;">
											<tbody>
												<tr class="upper backcolr">
													<th scope="col" width="10%">
														<h6 class="white bold">STT</h6>
													</th>

													<th scope="col" width="70%">
														<h6 class="white bold">Thành viên</h6>
													</th>


												</tr>


												<%
													ArrayList<ThanhVien> danhSachThanhVienDangKy = new DangKyChuyenDiBO()
																																					.getDanhSachThanhVienDangKyDi(maChuyenDi);
																																					System.out.print(danhSachThanhVienDangKy.size());
																																			for (int i = 1; i <= danhSachThanhVienDangKy.size(); i++) {
																																				ThanhVien tv = danhSachThanhVienDangKy.get(i-1);
												%>
												<tr>
													<td width="10%"><%=i%></td>
													<td width="70%"><a
														href="xemThanhVien.do?tenDangNhap=<%=tv.getTenDangNhap()%>"
														target="_blank"><%=tv.getHoTen()%></a></td>

												</tr>
												<%
													}
												%>
											</tbody>
										</table>

									</html:form>
									<div class="clear"></div>


								</div>
							</div>
						</div>
						<!-- Popup div ends here -->
					</div>



					<!--  -->


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
		function hienThiBinhLuan(trang, maBaiDang, i) {

			$.ajax({
				type : "GET",
				url : "/QuanLyHoatDongTuThien/hienThiBinhLuan.do?trang="
						+ trang + "&maBaiDang=" + maBaiDang,
				//data: trang+"/"+maBaiDang,
				success : function(response) {
					// we have the response

					$(".newDiv").html(response);

				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});

			length = parseFloat(i);
			for (var j = 1; j < length; j++) {
				var NAME = document.getElementById("" + j);
				NAME.className = "backcolrhover";
			}

			var NAME = document.getElementById(trang);
			NAME.className = "backcolrhover backcolr";

		}

		function capNhatBinhLuan(maChuyenDi) {

			var noiDung = document.getElementById("binhLuan").value;
			$.ajax({
				type : "GET",
				url : "/QuanLyHoatDongTuThien/capNhatBinhLuan.do?noiDung="
						+ noiDung + "&maBaiDang=" + maChuyenDi,
				//data: trang+"/"+maBaiDang,
				success : function(response) {
					var str = response;
					window.location = "chiTietBaiDang.do?maChuyenDi="
							+ maChuyenDi + "&trangSo=" + str;
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		}
	</script>



	<script>
		var NAME = document.getElementById("1");
		NAME.className = "backcolrhover backcolr";
		hienThiBinhLuan('1',
	<%=maChuyenDi%>
		);
	</script>

	|
	<script>
		document.getElementById("binhLuan").value = null;
	</script>

	<script type="text/javascript">
		function table_show2() {
			document.getElementById('table2').style.display = "block";
		}

		// function to hide Popup Table
		function table_hide2() {
			document.getElementById('table2').style.display = "none";
		}
	</script>

</body>


</html>
