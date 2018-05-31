<%@page import="model.bean.ThanhVien"%>
<%@page import="model.bo.DangKyChuyenDiBO"%>
<%@page import="model.bo.HinhAnhBO"%>
<%@page import="model.bean.BaiDang"%>
<%@page import="utils.ConfigDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.HinhAnh"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hình ảnh chuyến đi</title>
<link href="./Wisdom of Life_files/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="./Wisdom of Life_files/css/red.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="./Wisdom of Life_files/css/elements.css" />
<link href="./Wisdom of Life_files/css/style.css" rel="stylesheet"
	type="text/css">
<link href="./Wisdom of Life_files/css/red.css" rel="stylesheet"
	type="text/css">
<link rel='stylesheet' href='./Wisdom of Life_files/css/gallery.css'
	type='text/css' media='all' />
<link rel='stylesheet' href='./Wisdom of Life_files/css/elastislide.css'
	type='text/css' media='all' />
<link rel='stylesheet' href='./Wisdom of Life_files/css/memento.min.css'
	type='text/css' media='all' />
<link rel="stylesheet" href="./Wisdom of Life_files/css/memento.css"
	type="text/css" media="all" />
<link rel='stylesheet' href='./Wisdom of Life_files/css/gallery.css'
	type='text/css' media='all' />
<link rel='stylesheet' href='./Wisdom of Life_files/css/elastislide.css'
	type='text/css' media='all' />
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
	src="./Wisdom of Life_files/jsc/jquery.js"></script>
<script src="./Wisdom of Life_files/jsc/my_js.js"></script>

<script type="text/javascript">
	function danhSachTot() {
		document.getElementById('danhsachtot').style.display = "block";
	}

	function danhSachKhongTot() {
		document.getElementById('danhsachkhongtot').style.display = "block";
	}

	function dongDanhSach() {
		document.getElementById('danhsachtot').style.display = "none";
		document.getElementById('danhsachkhongtot').style.display = "none";
	}
</script>

<style>
.spantext {
	width: 350px;
	display: block;
	float: left;
	text-align: left;
	padding-top: 10px
}
</style>


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
			<jsp:param name="current4" value="current-menu-item" />
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
				<form method="post" action="UpHinhAction"
					enctype="multipart/form-data">
					<%
						String tenDangNhap = (String) request.getSession().getAttribute(
								"tenDangNhap");

						HinhAnhBO hinhAnhBO = new HinhAnhBO();
						String chucVu = hinhAnhBO.getChucVu(tenDangNhap);
						String maChuyenDi = "";
						if (request.getParameter("machuyendi") != null) {
							maChuyenDi = request.getParameter("machuyendi").toString();
						} else
							maChuyenDi = session.getAttribute("machuyendi").toString();
						session.setAttribute("machuyendi", maChuyenDi);
						BaiDang baiDang = hinhAnhBO.getThongTin(maChuyenDi);
						DangKyChuyenDiBO dangKyChuyenDiBO = new DangKyChuyenDiBO();
						int yes = dangKyChuyenDiBO.voteYes(maChuyenDi);
						int no = dangKyChuyenDiBO.voteNo(maChuyenDi);
						int banDaLike = dangKyChuyenDiBO.banDaVote(tenDangNhap, maChuyenDi);
					%>

					<div class="clear"></div>

					<div class="columns">
						<div class="static">
							<div class="twcol left">
								<h5 class="heading white backcolr bold">Thông tin chuyến đi</h5>
								<div class="twcolin bold">
									<h6>
										Tên chuyến đi:
										<%=baiDang.getTieuDe()%></h6>
									<h6>
										Ngày đi:
										<%=baiDang.getNgayDi()%></h6>
									<h6>
										Đoàn trưởng:
										<%=baiDang.getTenChuTaiKhoanLeader()%></h6>
								</div>
							</div>
							<!--NẾU LÀ LEADER THÌ HIỆN BẢNG UPLOAD-->
							<%
								if (!"3".equals(hinhAnhBO.getChucVu(tenDangNhap))) {
									if (baiDang.getTenDangNhapLeader().equals(tenDangNhap)) {
							%>
							<!-- Quyền đăng ảnh -->
							<div class="smalcol nomarg right">
								<h4 class="heading white backcolr bold">Upload</h4>
								<!-- Donation Widget -->
								<div class="donation">
									<div style="margin: 10px">
										<input type="file" name="dataFile" id="fileChooser" multiple />
									</div>
									<div class="clear"></div>
									<h2 class="bold backcolr donbtn">
										<input type="submit" value="Tải lên" />
									</h2>
								</div>
							</div>
							<%
								} else if (!("").equals(tenDangNhap)) {
										DangKyChuyenDiBO dangKyChuuyenDiBO = new DangKyChuyenDiBO();
										if (dangKyChuuyenDiBO.dieuKienDuocVote(maChuyenDi,
												tenDangNhap)) {
							%>
							<!-- Quyền vote chuyen di -->
							<div class="smalcol nomarg right">
								<h5 class="heading white backcolr bold">Đánh giá</h5>
								<%
									if (banDaLike == 1) {
								%>
								<ul style="list-style: none;">
									<li style="float: left; width: 230px;">
										<div>
											<a href="#"><img
												src="./Wisdom of Life_files/images/Check.png" width="50px"
												height="50px" style="float: left;"></img></a>
										</div>
										<div>
											<h6>
												<a onclick="danhSachTot()"
													style="float: left; padding-top: 15px; width: 170px">Bạn
													và <%=yes - 1%> người khác đã thích chuyến đi này
												</a>
											</h6>
										</div>
									</li>
								</ul>


								<!-- <div>
									<img src="./Wisdom of Life_files/images/Check.png" width="40px"
										height="40px" style="margin-left: 5px"> <a
										onclick="danhSachTot()">Bạn và <%=yes - 1%> người khác đã
										thích chuyến đi này
									</a>
								</div> -->


								<%
									} else {
								%>

								<ul style="list-style: none;">
									<li style="float: left; width: 230px;">
										<div>
											<a
												href="votechuyendi.jsp?tendangnhap=<%=tenDangNhap%>&machuyendi=<%=maChuyenDi%>&vote=1">
												<img src="./Wisdom of Life_files/images/Check.png"
												width="50px" height="50px" style="float: left;"></img>
											</a>
										</div>
										<div>
											<h6>
												<a onclick="danhSachTot()"
													style="float: left; padding-top: 15px; width: 170px">Có
													<%=yes%> người đã thích chuyến đi này
												</a>
											</h6>
										</div>
									</li>
								</ul>

								<!-- <div>
									<a
										href="votechuyendi.jsp?tendangnhap=<%=tenDangNhap%>&machuyendi=<%=maChuyenDi%>&vote=1">
										<img src="./Wisdom of Life_files/images/Check.png"
										width="40px" height="40px" style="margin-left: 5px">
									</a> 
									<a onclick="danhSachTot()">Có <%=yes%> người đã thích chuyến
										đi này
									</a>
								</div> -->


								<%
									}
												if (banDaLike == 2) {
								%>

								<ul style="list-style: none;">
									<li style="float: left; width: 230px;">
										<div>
											<img src="./Wisdom of Life_files/images/exit.png"
												width="50px" height="50px" style="float: left;"></img>
										</div>
										<div>
											<h6>
												<a onclick="danhSachKhongTot()"
													style="float: left; padding-top: 10px; width: 170px">Bạn
													và <%=no - 1%> người khác đã không thích chuyến đi này
												</a>
											</h6>
										</div>
									</li>
								</ul>

								<!-- <div>
									<img src="./Wisdom of Life_files/images/exit.png" width="40px"
										height="40px" style="margin-left: 5px"> <a
										onclick="danhSachKhongTot()">Bạn và <%=no - 1%> người khác đã
										không thích chuyến đi này
									</a>
								</div> -->
								<%
									} else {
								%>

								<ul style="list-style: none;">
									<li style="float: left; width: 230px;">
										<div>
											<a
												href="votechuyendi.jsp?tendangnhap=<%=tenDangNhap%>&machuyendi=<%=maChuyenDi%>&vote=2">
												<img src="./Wisdom of Life_files/images/exit.png"
												width="50px" height="50px" style="float: left;"></img>
											</a>
										</div>
										<div>
											<h6>
												<a onclick="danhSachKhongTot()"
													style="float: left; padding-top: 10px; width: 170px">Có
													<%=no%> người đã không thích chuyến đi này
												</a>
											</h6>
										</div>
									</li>
								</ul>

								<!-- <div>
									<a
										href="votechuyendi.jsp?tendangnhap=<%=tenDangNhap%>&machuyendi=<%=maChuyenDi%>&vote=2">
										<img src="./Wisdom of Life_files/images/exit.png" width="40px"
										height="40px" style="margin-left: 5px">
									</a> <a onclick="danhSachKhongTot()">Có <%=no%> người đã không thích
										chuyến đi này
									</a>
								</div> -->

								<%
									}
								%>
								<div class="clear"></div>
							</div>
							<%
								} else {//không được vote
							%>
							<div class="smalcol nomarg right">
								<h5 class="heading white backcolr bold">Đánh giá</h5>

								<ul style="list-style: none;">
									<li style="float: left; width: 230px;">
										<div>
											<img src="./Wisdom of Life_files/images/Check.png"
												width="50px" height="50px" style="float: left;"></img>
										</div>
										<div>
											<h6>
												<a onclick="danhSachTot()"
													style="float: left; padding-top: 15px; width: 170px">Có
													<%=yes%> người đã thích chuyến đi này
												</a>
											</h6>
										</div>
									</li>
								</ul>

								<!-- <div>
									<img src="./Wisdom of Life_files/images/Check.png" width="40px"
										height="40px" style="margin-left: 5px"> <a
										onclick="danhSachTot()">Có <%=yes%> người đã thích chuyến đi
										này
									</a>
								</div> -->


								<ul style="list-style: none;">
									<li style="float: left; width: 230px;">
										<div>
											<img src="./Wisdom of Life_files/images/exit.png"
												width="50px" height="50px" style="float: left;"></img>
										</div>
										<div>
											<h6>
												<a onclick="danhSachKhongTot()"
													style="float: left; padding-top: 10px; width: 170px">Có
													<%=no%> người đã không thích chuyến đi này
												</a>
											</h6>
										</div>
									</li>
								</ul>

								<!-- <div>
									<img src="./Wisdom of Life_files/images/exit.png" width="40px"
										height="40px" style="margin-left: 5px"> <a
										onclick="danhSachKhongTot()">Có <%=no%> người đã không thích
										chuyến đi này
									</a>
								</div> -->

								<div class="clear"></div>
							</div>
							<%
								}
									} else {//chưa đăng nhập
							%>
							<div class="smalcol nomarg right">
								<h5 class="heading white backcolr bold">Đánh giá</h5>

								<ul style="list-style: none;">
									<li style="float: left; width: 230px;">
										<div>
											<img src="./Wisdom of Life_files/images/Check.png"
												width="50px" height="50px" style="float: left;"></img>
										</div>
										<div>
											<h6>
												<a onclick="danhSachTot()"
													style="float: left; padding-top: 15px; width: 170px">Có
													<%=yes%> người đã thích chuyến đi này
												</a>
											</h6>
										</div>
									</li>
								</ul>

								<!-- <div>
									<img src="./Wisdom of Life_files/images/Check.png" width="40px"
										height="40px" style="margin-left: 5px"> <a
										onclick="danhSachTot()">Có <%=yes%> người đã thích chuyến đi
										này
									</a>

								</div> -->


								<ul style="list-style: none;">
									<li style="float: left; width: 230px;">
										<div>
											<img src="./Wisdom of Life_files/images/exit.png"
												width="50px" height="50px" style="float: left;"></img>
										</div>
										<div>
											<h6>
												<a onclick="danhSachKhongTot()"
													style="float: left; padding-top: 10px; width: 170px">Có
													<%=no%> người đã không thích chuyến đi này
												</a>
											</h6>
										</div>
									</li>
								</ul>

								<!-- <div>
									<img src="./Wisdom of Life_files/images/exit.png" width="40px"
										height="40px" style="margin-left: 5px"> <a
										onclick="danhSachKhongTot()">Có <%=no%> người đã không thích
										chuyến đi này
									</a>
								</div> -->

								<div class="clear"></div>
							</div>
							<%
								}
								} else {
							%>
							<div class="smalcol nomarg right">
								<h5 class="heading white backcolr bold">Đánh giá</h5>


								<ul style="list-style: none;">
									<li style="float: left; width: 230px;">
										<div>
											<img src="./Wisdom of Life_files/images/Check.png"
												width="50px" height="50px" style="float: left;"></img>
										</div>
										<div>
											<h6>
												<a onclick="danhSachTot()"
													style="float: left; padding-top: 15px; width: 170px">Có
													<%=yes%> người đã thích chuyến đi này
												</a>
											</h6>
										</div>
									</li>
								</ul>

								<!-- <div>
									<img src="./Wisdom of Life_files/images/Check.png" width="40px"
										height="40px" style="margin-left: 5px"> <a
										onclick="danhSachTot()">Có <%=yes%> người đã thích chuyến đi
										này
									</a>
								</div> -->

								<ul style="list-style: none;">
									<li style="float: left; width: 230px;">
										<div>
											<img src="./Wisdom of Life_files/images/exit.png"
												width="50px" height="50px" style="float: left;"></img>
										</div>
										<div>
											<h6>
												<a onclick="danhSachKhongTot()"
													style="float: left; padding-top: 15px; width: 170px">Có
													<%=no%> người đã không thích chuyến đi này
												</a>
											</h6>
										</div>
									</li>
								</ul>

								<!-- <div>
									<img src="./Wisdom of Life_files/images/exit.png" width="40px"
										height="40px" style="margin-left: 5px"> <a
										onclick="danhSachKhongTot()">Có <%=no%> người đã không thích
										chuyến đi này
									</a>
								</div> -->
								<div class="clear"></div>
							</div>
							<%
								}
							%>


							<div class="fullwidth left">

								<div class="clear"></div>

								<div id="content" class="group"
									style="margin-left: 115px; margin-top: 20px;">
									<div id="rg-gallery" class="rg-gallery">
										<div class="rg-thumbs">
											<!-- Elastislide Carousel Thumbnail Viewer -->
											<div class="es-carousel-wrapper">
												<div class="es-nav">
													<span class="es-nav-prev">Trước</span> <span
														class="es-nav-next">Sau</span>
												</div>
												<div class="es-carousel">
													<ul>
														<%
															ArrayList<HinhAnh> arr = new ArrayList<HinhAnh>();
															arr = hinhAnhBO.getDSHinhAnh(maChuyenDi);
															if (arr != null) {
																for (int i = 0; i < arr.size(); i++) {
														%>
														<li><a href="#"> <img
																src="<%=arr.get(i).getUrlHinhAnh()%>"
																data-large="<%=arr.get(i).getUrlHinhAnh()%>" alt="" />
														</a></li>
														<%
															}
															}
														%>

													</ul>
												</div>
											</div>
										</div>
									</div>
									<script type='text/javascript'
										src='./Wisdom of Life_files/jsc/jquery.tmpl.min.js'></script>
									<script type='text/javascript'
										src='./Wisdom of Life_files/jsc/jquery.elastislide.js'></script>
									<script type='text/javascript'
										src='./Wisdom of Life_files/jsc/gallery.js'></script>
									<script id="img-wrapper-tmpl" type="text/x-jquery-tmpl">
									<div class="rg-image-wrapper" style="width:500px;height:400px">
										{{if itemsCount > 1}}
											<div class="rg-image-nav">
												<a href="#" class="rg-image-nav-prev">Trước</a>
												<a href="#" class="rg-image-nav-next">Sau</a>
											</div>
										{{/if}}
										<div class="rg-image" ></div>
										<div class="rg-loading"></div>
									</div>      
									<div class="rg-caption-wrapper">
										<div class="rg-caption" style="display:none;">
											<p></p>
										</div>
									</div>
								</script>
								</div>


							</div>
						</div>
					</div>
				</form>

				<div id="danhsachtot" style="display: none;">
					<!-- Popup div starts here -->
					<div id="popupDSthanhvien">
						<%
							ArrayList<ThanhVien> arrTot = dangKyChuyenDiBO
									.getDanhSachThanhVienVoteTot(maChuyenDi, tenDangNhap);
						%>
						<!-- contact us form -->
						<div class="formtable">
							<img src="./Wisdom of Life_files/images/close.png" id="close"
								onclick="dongDanhSach()">
							<h2>Danh sách thành viên đã thích chuyến đi</h2>
							<hr style="width: 400px !important">
							<div>
								<table class="tableFB" border="0" cellspacing="0"
									cellpadding="0" style="width: 450px !important;">
									<tbody>
										<tr class="upper backcolr">
											<th scope="col" width="10%">
												<h6 class="white bold">STT</h6>
											</th>

											<th scope="col" width="70%">
												<h6 class="white bold">Tên dăng nhập</h6>
											</th>
										</tr>
										<%
											for (int i = 0; i < arrTot.size(); i++) {
										%>
										<tr>
											<td width="10%"><%=(i + 1)%></td>
											<td width="70%"><a
												href="xemThanhVien.do?tenDangNhap=<%=arrTot.get(i).getTenDangNhap()%>"
												target="_blank"><%=arrTot.get(i).getHoTen()%></a></td>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>
								<div class="clear"></div>
							</div>

						</div>
					</div>
					<!-- Popup div ends here -->
				</div>

				<div id="danhsachkhongtot" style="display: none;">
					<!-- Popup div starts here -->
					<div id="popupDSthanhvien">
						<%
							ArrayList<ThanhVien> arrKhongTot = dangKyChuyenDiBO
									.getDanhSachThanhVienVoteKhongTot(maChuyenDi, tenDangNhap);
						%>
						<!-- contact us form -->
						<div class="formtable">
							<img src="./Wisdom of Life_files/images/close.png" id="close"
								onclick="dongDanhSach()">
							<h2>Danh sách thành viên không thích chuyến đi</h2>
							<hr style="width: 400px !important">
							<div>
								<table class="tableFB" border="0" cellspacing="0"
									cellpadding="0" style="width: 450px !important;">
									<tbody>
										<tr class="upper backcolr">
											<th scope="col" width="10%">
												<h6 class="white bold">STT</h6>
											</th>

											<th scope="col" width="70%">
												<h6 class="white bold">Tên dăng nhập</h6>
											</th>
										</tr>
										<%
											for (int i = 0; i < arrKhongTot.size(); i++) {
										%>
										<tr>
											<td width="10%"><%=(i + 1)%></td>
											<td width="70%"><a
												href="xemThanhVien.do?tenDangNhap=<%=arrKhongTot.get(i).getTenDangNhap()%>"
												target="_blank"><%=arrKhongTot.get(i).getHoTen()%></a></td>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>
								<div class="clear"></div>
							</div>

						</div>
					</div>
					<!-- Popup div ends here -->
				</div>
				<div class="clear"></div>
				<!-- Footer -->
				<jsp:include page="footer.jsp"></jsp:include>
				

			</div>
		</div>
	</div>
</body>
</html>