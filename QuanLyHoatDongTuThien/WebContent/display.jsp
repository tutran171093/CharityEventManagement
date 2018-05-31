<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<script>
	
	function chuyenTiep()
	{
		window.location.href = "chiTietBaiDang.do?maChuyenDi="+<%=request.getAttribute("maChuyenDi")%>+"&trangSo=1";
	}
	chuyenTiep();
</script>

<body>
	

	
</body>
</html>