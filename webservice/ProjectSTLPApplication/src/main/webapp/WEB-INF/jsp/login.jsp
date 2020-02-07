<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>เข้าสู่ระบบ</title>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

form {
	border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>


</head>
<body>

	<form action="/index" method="post">

		<div class="container">
			<font color="red"><center>
					<b><c:out value="${danger}"></c:out></b>
				</center></font> <label for="username"><b>ชื่อผู้ใช้งาน</b></label> <input
				type="text" placeholder="กรุณาใส่ชื่อผู้ใช้งาน" name="username"
				required> <label for="password"><b>รหัสผ่าน</b></label> <input
				type="password" placeholder="กรุณาใส่รหัสผ่าน" name="password"
				required>

			<button type="submit">เข้าสู่ระบบ</button>
			<label> <input type="checkbox" name="remember">
				จดจำฉันไว้
			</label>
		</div>

		<div class="container" style="background-color: #f1f1f1">
			<button type="reset" class="cancelbtn">ยกเลิก</button>
			<span class="psw">ลืมรหัสผ่าน <a href="#">รหัสผ่าน?</a></span>
		</div>
	</form>
</body>
</html>