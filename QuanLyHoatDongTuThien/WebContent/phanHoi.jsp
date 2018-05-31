<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@page import="model.bean.PhanHoi"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Thông tin phản hồi</title>
<link href="./Wisdom of Life_files/css/style.css" rel="stylesheet" type="text/css" />
<link href="./Wisdom of Life_files/css/red.css" rel="stylesheet" type="text/css" />
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

<link rel="stylesheet" href="./Wisdom of Life_files/css/elements.css" />
<script type="text/javascript" async="" src="./Wisdom of Life_files/jsc/ga.js" ></script>
<script src="./Wisdom of Life_files/jsc/my_js.js"></script>	

<script type="text/javascript">
	var _gaq = _gaq || [];
	_gaq.push(['_setAccount', 'UA-43981329-1']);
	_gaq.push(['_trackPageview']);
	(function () {
	var ga = document.createElement('script');
	ga.type = 'text/javascript';
	ga.async = true;
	ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
	var s = document.getElementsByTagName('script')[0];
	s.parentNode.insertBefore(ga, s);
	})();
</script>

</head>
<body id="bdy">
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
					<div  class="fullwidth left">
						<div class="tab_menu_container backcolr">
							<ul id="tab_menu">
								<li><a class="current" rel="feeds">Thông tin phản hồi</a></li>
							</ul>
							<div class="clear"></div>
						</div>
						<div class="clear"></div>
						<div class="tables">
							<table class="tableFB" border="0" cellspacing="0" cellpadding="0">
								<tbody>
									<tr class="upper backcolr">
										<th scope="col" class="c1">
										<h6 class="white bold">STT</h6>
										</th>
										
										<th scope="col" class="c2">
										<h6 class="white bold">Tên thành viên</h6>
										</th>
										
										<th scope="col" class="c3">
										<h6 class="white bold">Tên đoàn trưởng</h6>
										</th>
										
										<th scope="col" class="c4">
										<h6 class="white bold">Ngay Dang</h6>
										</th>
									</tr>
									
									<logic:iterate name="phanHoiForm"
											property="danhSachPhanHoi" id="maFeedback">
									<tr>
									
										<td class="c1"><bean:write name="maFeedback"
														property="stt"/></td>
												<bean:define id="maUser" name="maFeedback" property="maUser"></bean:define>
										<td class="c2"><a href="xemThanhVien.do?maLeader=<%=maUser%>"><bean:write name="maFeedback"
														property="maUser"/></a></td>
										<bean:define id="maLeader" name="maFeedback" property="tenDangNhap"></bean:define>
										<td class="c3"><a href="xemThanhVien.do?maLeader=<%=maLeader%>"><bean:write name="maFeedback"
														property="tenDangNhap"/></a></td>
										<td class="c4"><bean:write name="maFeedback"
														property="ngayDang"/></td>
										
										<bean:define id="m" name="maFeedback" property="noiDung" ></bean:define>
										<bean:define id="n" name="maFeedback" property="maFeedback" ></bean:define>
										<td class="c5">
											<a onclick="div_show('${m}')"><img src="./Wisdom of Life_files/images/feedback.png" width="20px" height="20px"></img></a>
										</td>
										
										<td class="c6">
											<a>
												<img src="./Wisdom of Life_files/images/del.png" width="20px" height="20px" onclick="XacNhanXoa('${n}')"></img>
											</a>
										</td>
										</tr>		
										</logic:iterate>		
								</tbody>
							</table>
						</div>
					</div>
				
					<div id="abc" style="display: none;">
 
						<!-- Popup div starts here -->
						 <div id="popupContact"> 

							<!-- contact us form -->
								<div class="formfeedback">
									<img src="./Wisdom of Life_files/images/close.png" id="close" onclick="div_hide()">
									<h2>Thông tin phản hồi</h2><hr>
									<!--Hiện thông tin phản hồi ở đây-->
									
									<textarea name="message" placeholder="THÔNG TIN PHẢN HỒI" id="msg"  ></textarea>
								</div>
						 </div> 
					 <!-- Popup div ends here -->
					 </div>
				</div>
			</div>
		</div>
	</div>
	
	
	<jsp:include page="footer.jsp"></jsp:include>
	
</div>
</body>
<script type="text/javascript">
	
	function XacNhanXoa(maBaiDang) {
		if (confirm("Bạn có thực sự muốn xóa không?")) {
			location.href = "xoaPhanHoi.do?maFeedback="+maBaiDang;
		}
	}
	
</script>
</html>

