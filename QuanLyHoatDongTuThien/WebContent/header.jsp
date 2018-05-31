<%@page import="model.bo.PhanHoiBO"%>
<%@page import="model.bo.BaiDangBO"%>
<%@page import="model.bo.ThongBaoBO"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.bo.ThanhVienBO"%>

<div id="header">
    	<div class="logo">
        	<a href="trangChuAction.do"><img src="./Wisdom of Life_files/images/logo.png" alt="" /></a>
        </div>
        <div class="righthead">
        	<%
        		String tenDangNhap = (String) session.getAttribute("tenDangNhap");
        		if(tenDangNhap!=null)
        		{
        			%>
        			 <ul class="links">
            			<li style="color:white;margin-top:4px; margin-right:10px">
							<h5>Xin chào, <label><%=session.getAttribute("tenDangNhap")%></label></h5>
						</li>
						<li>
							<h5><a href="huyDangNhap.do">Thoát</a></h5>
						</li>
           			 </ul>
        			<%	
        		}
        		else
        		{
        			%>
        			<ul class="links">
          			  	<li><a href="javascript:animatedcollapse.toggle('jason')" class="colr">Đăng nhập</a></li>
           			 </ul>
        			<%
        		}
        	%>
            <div id="jason" class="loginbox">
            	<h5 class="loghead backcolr">Đăng nhập</h5>
                <ul>
                
                <html:form action="dangNhap">
                	<li class="txt"><h6 class="bold black">Tên đăng nhập</h6></li>
                    <li class="field"><html:text styleClass="bar" property="tenDangNhap"></html:text></li>
                    <li class="txt"><h6 class="black bold">Mật khẩu</h6></li>
                    <li class="field"><html:password styleClass="bar" property="matKhau"></html:password></li>
                    <li class="txt"><a href="chuyenTiepDangKy.do" class="forgot">Chưa có tài khoản?</a></li>
					<li class="field"><input type="submit" value="Submit" class="go backcolr" /></li>
				</html:form>
				
                </ul>
            </div>
            <div class="clear"></div>
            <div class="search">
                <h3 class="white bold">Tìm kiếm</h3>
                <ul>
                    <li>
                        <input id="keyWordSearch" onkeyup="timKiem()"  type="text" placeholder="Tìm kiếm"  name="s"  onfocus="" class="txtfield"/>
                    </li>
                    <li class="right"><input type="submit" class="go backcolr" value="" /></li>
                </ul>
                
                
                <div id="newDiv1" class="newDiv1" onblur="anTimKiem()" style="width:80px; height:auto; background-color:#ffffff;z-index:1000" > 
                
                </div>
                
                
            </div>
            <div class="clear"></div>
        </div>
        <div class="navigation">
        	<div id="smoothmenu1" class="ddsmoothmenu">
                <ul>
                    <li class="${param.current1 }"><a href="trangChuAction.do">Trang chủ</a></li>
                    <li class="${param.current2 }"><a href="danhSachChuyenDi.do?trangSo=1">Danh sách chuyến đi</a></li>
                    
                    <% 
                    int quyen = new ThanhVienBO().getTaiKhoan(tenDangNhap).getQuyen(); 
                    if(quyen == 1 || quyen == 2 || quyen == 4 )
                	{
                    	%>
                    	<li class="${param.current3 }"><a href="danhSachTruongDoanAction.do">Danh sách đoàn trưởng</a></li>
                		<%
                	}
                    else if(quyen != 3)
                    {
                    	%>
                    	<li class="${param.current3 }"><a href="danhSachTruongDoanUserAction.do">Danh sách đoàn trưởng</a></li>
                    	<%
                    }
                    %>
                    
                    <li class="${param.current4 }"><a href="hinhAnh.do?trangSo=1">Hình ảnh</a></li>
                    
                    
                    <% 
                    	if(new ThanhVienBO().getTaiKhoan(tenDangNhap).getQuyen() == 3)
                    	{
                    		int soLuongThongBaoQuanTri = new ThongBaoBO().getSoLuongThongBaoQuanTri();
                    		int soLuongDuyetBai = new BaiDangBO().getListBaiDang().size();
                    		int soLuongPhanHoi = new PhanHoiBO().getDanhSachPhanHoi().size();
                    		int soLuongDangKyDoanTruong = new ThanhVienBO().getListThanhVien().size();
                    		%>
                    	<li class="${param.current5 }">
                    		<% 
                    			if(soLuongThongBaoQuanTri != 0)
                    			{
                    				%>
                    					<a href="">Quản trị hệ thống <sub style="color:orange; font-size:12px"><%=soLuongThongBaoQuanTri%></sub></a>
                    				<%
                    			}
                    			else
                    			{
                    				%>
                					<a href="">Quản trị hệ thống</a>
                				<%
                    			}
                    		%>
							
							<ul class="backcolr" style="top: 36px; visibility: visible; left: 0px; width: 250px; display: none;">
								<%
									if(soLuongDuyetBai != 0)
									{
										%>
											<li><a href="duyetBai.do">Duyệt bài đăng <sub style="color:orange; font-size:12px"><%=soLuongDuyetBai%></sub></a></li>
										<%			
									}
									else
									{
										%>
											<li><a href="duyetBai.do">Duyệt bài đăng</a></li>
										<%
									}
									%><li><a href="quanlytaikhoan.do?trangSo=1">Quản lý tài khoản</a></li><%
									
											if(soLuongDangKyDoanTruong != 0)
											{
												%>
													<li><a href="duyetDoanTruong.do">Duyệt yêu cầu đoàn trưởng <sub style="color:orange; font-size:12px"><%=soLuongDangKyDoanTruong%></sub></a></li>
												<%			
											}
											else
											{
												%>
													<li><a href="duyetDoanTruong.do">Duyệt yêu cầu đoàn trưởng</a></li>
												<%
											}
											
									if(soLuongPhanHoi != 0)
									{
										%>
											<li><a href="danhsachphanhoi.do">Thông tin phản hồi <sub style="color:orange; font-size:12px"><%=soLuongPhanHoi%></sub></a></li>
										<%			
									}
									else
									{
										%>
											<li><a href="danhsachphanhoi.do">Thông tin phản hồi</a></li>
										<%
									}
								%>
								
								
								
							</ul>
						</li>
                    		<%
                    	}
                    	else if(tenDangNhap != null)
                    	{
                    		%>
                    			<li class="${param.current6 }"><a href="trangThongTinCaNhan.do">Trang cá nhân</a></li>
                    		<%
                    	}
                    
                    	if(new ThanhVienBO().getTaiKhoan(tenDangNhap).getQuyen() == 2)
                    	{
                    		%>
                    			<li class="${param.current7 }"><a href="hienThiDangBai.do">Đăng bài</a></li>
                    		<%
                    	}
                    %>
                    
                    <%	if(tenDangNhap != null)
                    {
                    	int soLuongThongBaoMoi = new ThongBaoBO().getSoLuongThongBaoMoi(tenDangNhap); 
                    	if(soLuongThongBaoMoi != 0)
                    	{
                    		%>
                			<li class="${param.current8 }">
                				<a href="thongBao.do">Thông báo <sub style="color:orange; font-size:12px"><%=soLuongThongBaoMoi%></sub>   </a>
                			</li>
                			<%
                    	}
                    	else
                    	{
                    		%>
                    		<li class="${param.current8 }"><a href="thongBao.do">Thông báo</a></li>
                    		<%
                    	}
                    }
                    %>
                    
                    
                    
					
                </ul>
                <div class="clear"></div>
            </div>
        </div>
    </div>
    
   
   
   
   <script type="text/javascript">

	
   
   	function anTimKiem()
   	{
   		$('.newDiv1').hide();
   	}
   	
   	function hienThi()
   	{
   		$('.newDiv1').show();
   	}

	function timKiem()
	{	
		
		var str = document.getElementById("keyWordSearch").value;
		if(str.length > 0)
		{
			$.ajax({
			                  type: "GET",
			                    url: "/QuanLyHoatDongTuThien/timKiemChuyenDi.do?search="+str,
			                    success: function(response){
			                        // we have the response
			                       
			                        $(".newDiv1").html(response);
			                        $('.newDiv1').show();
			                    },
			                    error: function(e){
			                        alert('Error: ' + e);
			                    }
			                });
		}
		else
		{
			$('.newDiv1').hide();
		}
		
	
						
	}
</script>
    
    
 <script>
  $( document ).ready(function() {
	  //$( "#keyWordSearch" ).removeData();
	  var offset = $('#keyWordSearch').offset();
	  $('#newDiv1').css({ 
		    position: "absolute",
		    left: (offset.left+1),
		    top: (offset.top+36),
		    width : ($('#keyWordSearch').width()+90)
		    
		});
	});
  </script>
  

    