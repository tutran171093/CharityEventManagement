<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Đăng bài</title>
<link href="./Wisdom of Life_files/css/style.css" rel="stylesheet" type="text/css"/>
<link href="./Wisdom of Life_files/css/red.css" rel="stylesheet" type="text/css"/>
<link href="./Wisdom of Life_files/css/pikaday.css" rel="stylesheet" type="text/css"/>
<link href="./Wisdom of Life_files/css/jquery-ui-1.10.4.custom.min.css" rel="stylesheet" type="text/css"/>
<link href="./Wisdom of Life_files/css/jquery.ui.all.css" rel="stylesheet" />
<link href="./Wisdom of Life_files/css/demos.css" rel="stylesheet" />
<link rel="stylesheet" href="./Wisdom of Life_files/css/elements.css" />
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
<script type="text/javascript" src="./Wisdom of Life_files/jsc/tabswidget.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/ga.js"></script>
<script type="text/javascript" charset="UTF-8" src="./Wisdom of Life_files/jsc/jquery-1.10.2.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/jquery.ui.core.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/jquery.ui.widget.js"></script>
<script type="text/javascript" src="./Wisdom of Life_files/jsc/jquery.ui.datepicker.js"></script>

<script type="text/javascript">
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#blah').attr('src', e.target.result).width(635).height(200);
			};
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>
<script>
  $(function() {
    $( "#datepicker" ).datepicker({
    	changeMonth: true,
		changeYear: true
    });
  });
  </script>
<!--[if lte IE 7]><style>#controls{	margin:0px 0px 0px -80px;}</style><![endif]-->
<style>
.spantext {
	width: 300px;
	display: block;
	float: left;
	text-align: left;
	padding-top: 10px
}

.validate{
		margin-left:320px;
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
			<jsp:param name="current7" value="current-menu-item" />
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
					<div class="barbig left padright">
						<div class="clear"></div>
						<div class="tabssection">
							<div class="tab_menu_container backcolr" style="width: 1000px!important;">
	                            <ul id="tab_menu">
	                                <li><a class="current" rel="feeds">Đăng bài mới</a></li>
	                            </ul>
	                            <div class="clear"></div>
	                        </div>
	                        <div class="clear"></div>
	                        
	                        
								<html:form action="/dangbai" styleId="contact-form" enctype="multipart/form-data">
									<div class="quickenquiry">
										<div class="tab_container" style="width: 1000px!important;">
											<div class="tab_container_in">
												<div>
													
													<ul style="width: 700px !important;margin-left:150px; word-wrap:break-word">
										
														<li class="txt bold">
															<label>
																<span for="tieude" class="spantext">Tiêu đề *</span>
																<html:text property="tieuDe" styleClass="inputbox" value=""></html:text>
																<br/>
																<div class="validate">
																	<html:errors property="tieuDe"/>
																</div>
															</label>
														</li>
														
														<li class="txt bold"><label> <span for="hinhanh"
																class="spantext">Hình ảnh</span> <html:file
																	property="hinhAnh" size="50" onchange="readURL(this);"
																	accept="image/*" style="margin-left:20px;margin-top:10px" />
														</label></li>
														<li><img   id="blah" src=""
																	alt="chưa có hình"
																	style="margin: 20px 0px 20px 0px"
																	width="635px" height="200px" /></li>
														<li class="txt bold"><label> <span for="ngaydi"
																class="spantext">Ngày đi *</span> <html:text
																	property="ngayDi" styleId="datepicker" styleClass="inputbox" value=""></html:text>
																	<div class="validate">
																		<html:errors property="ngayDi" />
																		<html:errors property="ngayDiBe" />
																		<html:errors property="ngaySinhKhongHopLe" />
																	</div>
														</label></li>
														<li class="txt bold"><label> <span for="ngaydi"
																class="spantext">Địa điểm *</span> <html:text
																	property="diaDiem" styleClass="inputbox" value=""></html:text> 
																	<div class="validate">
																		<html:errors property="diaDiem" />
																	</div>
														</label></li>
														<li class="txt bold"><label> <span for="kinhphi"
																class="spantext">Kinh phí dự kiến (1 người VNĐ)*</span> <html:text
																	property="kinhPhiDuKien" styleClass="inputbox" value=""></html:text>
																	<div class="validate">
																		<html:errors property="kinhPhiDuKien" />
																		<html:errors property="dinhDangKinhPhi" />
																		<html:errors property="kinhPhiSoAm" />
																	</div>
														</label></li>
														<li class="txt bold"><label> <span for="songuoi"
																class="spantext">Số người tham gia dự kiến *</span> <html:text
																	property="soNguoiDuKien" styleClass="inputbox" value=""></html:text>
																	<div class="validate">
																		<html:errors property="soNguoiDuKien" />
																		<html:errors property="dinhDangSoNguoi" />
																		<html:errors property="soNguoiSoAm" />
																	</div>
														</label></li>
														<li class="txt bold"><label> <span for="noidung"
																class="spantext">Nội dung *</span> <html:textarea
																	property="noiDung" styleClass="noidung" rows="20"
																	cols="150" value=""></html:textarea> 
																	<div class="validate" style="margin-left:0px!important">
																		<html:errors property="noiDung" />
																	</div>
														</label></li>
														
														<div class="clear"></div>
														
														<li><input type="submit" value="Đăng bài" name="submit"
															class="button medium" /></li>
													</ul>
												
												</div>
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
</body>
</html>