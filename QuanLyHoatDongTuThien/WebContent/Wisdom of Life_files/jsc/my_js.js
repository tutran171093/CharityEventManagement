

function table_show3() {
	alert('123');
}



// function to validate empty field
function check_empty() {
	if (document.getElementById('msg').value == "") {
		alert("Điền tất cả các ô!!!");
	} else {
		document.getElementById('form').submit();
		alert("Gửi thành công");
	}
}

// function to display Popup
function div_show1(tenDangNhap) {
	document.getElementById("tendoantruong").value = tenDangNhap;
	document.getElementById('abc').style.display = "block";
}

// function to hide Popup
function div_hide1() {
	document.getElementById('abc').style.display = "none";
}

// function to display Popup
function div_show(m) {
	document.getElementById('abc').style.display = "block";
	document.getElementById('msg').value = m;
}

// function to hide Popup
function div_hide() {
	document.getElementById('abc').style.display = "none";
}

// function to display Popup Table
function table_show() {
	document.getElementById('table').style.display = "block";
}

// function to hide Popup Table
function table_hide() {
	document.getElementById('table').style.display = "none";
}
