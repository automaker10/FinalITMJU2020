<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>แก้ไขศูนย์ให้ความช่วยเหลือบุคคลไร้รัฐไร้สัญชาติ</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
<link href="/css/sticky-footer-navbar.css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<style>
.home {
	position: relative;
	display: block;
	padding: 12px 15px;
	color: #fff;
	background-color: #080808;
}

.logout {
	position: relative;
	display: block;
	padding: 12px 15px;
	color: red;
	background-color: #080808;
}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${usernamesession == null}">
			<jsp:include page="login.jsp"></jsp:include>
			<br />
		</c:when>
		<c:otherwise>
		<nav class="navbar navbar-inverse">
	<div class="container-fluid">

		<ul class="nav navbar-nav">
			<form action="/listallcenter" method="post">
				<button type="submit" class="home">รายชื่อศูนย์ให้ความช่วยเหลือฯ</button>
			</form>
		</ul>
		<ul class="nav navbar-nav">
			<form action="/listidcardtype" method="post">
				<button type="submit" class="home">ประเภทบัตรบุคคลไร้รัฐไร้สัญชาติ</button>
			</form>
		</ul>
		<ul class="nav navbar-nav">
			<a href="${pageContext.request.contextPath}/logout"><input type="button" name="logout" value="ออกจากระบบ" class="logout"></a>
		</ul>
	</div>
	</nav>

	<div class="container">

		<h3>รายละเอียดศูนย์ให้ความช่วยเหลือฯ</h3>
		<form action='/listallcenter/updatecenter' method='post'>

			<table class='table table-hover table-responsive'>

				<tr>
					<td><b>#เบอร์โทร</b></td>
					<td><input type='text' name='telcenter' class='form-control'
						value="${center.telcenter}" required/></td>
				</tr>

				<tr>
					<c:set var="namecenter1"
						value="${fn:replace(center.namecenter, '%2F', '/')}" />
					<c:set var="namecenter2"
						value="${fn:replace(namecenter1, '%2C', ',')}" />
					<c:set var="namecenter3"
						value="${fn:replace(namecenter2, '+', ' ')}" />
					<td><b>ชื่อศูนย์ให้ความช่วยเหลือฯ</b></td>
					<td><input type='text' name='namecenter' class='form-control'
						value="${namecenter3}" required/></td>
				</tr>

				<tr>
					<td><b>อีเมลล์</b></td>
					<td><input type='text' name='emailcenter' class='form-control'
						size="20" value="${center.emailcenter}" required/></td>

				</tr>
				<tr>
					<c:set var="addcenter1"
						value="${fn:replace(center.addresscenter, '%2F', '/')}" />
					<c:set var="addcenter2"
						value="${fn:replace(addcenter1, '%2C', ',')}" />
					<c:set var="addcenter3" value="${fn:replace(addcenter2, '+', ' ')}" />
					<td><b>ที่อยู่</b></td>
					<td><textarea type='text' name='addresscenter'
							class='form-control' size="20" required>${addcenter3}</textarea></td>

				</tr>

				<tr>
					<c:set var="nameperson1"
						value="${fn:replace(president.nameperson, '%2F', '/')}" />
					<c:set var="nameperson2"
						value="${fn:replace(nameperson1, '%2C', ',')}" />
					<c:set var="nameperson3"
						value="${fn:replace(nameperson2, '+', ' ')}" />
					<td><b>ชื่อประธานศูนย์ให้ความช่วยเหลือฯ</b></td>
					<td><input type='text' name='nameperson' class='form-control'
						size="20" value="${nameperson3}" required/></td>

				</tr>

				<tr>
					<td><b>ตำแหน่ง</b></td>
					<td><input type='text' name='position' class='form-control'
						size="20" value="${president.position}" required/></td>

				</tr>

				<tr>
					<c:set var="address1"
						value="${fn:replace(president.address, '%2F', '/')}" />
					<c:set var="address2" value="${fn:replace(address1, '%2C', ',')}" />
					<c:set var="address3" value="${fn:replace(address2, '+', ' ')}" />
					<td><b>ที่อยู่ประธานศูนย์ให้ความช่วยเหลือฯ</b></td>
					<td><textarea type='text' name='address' class='form-control'
							size="20" required>${address3}</textarea></td>

				</tr>
				<tr>
					<td></td>
					<td><input type="hidden" name='username' class='form-control'
						size="20" value="${president.username}" />
						<button type="submit" class="btn btn-primary">บันทึกข้อมูล</button>
					</td>
				</tr>

			</table>
		</form>
		</c:otherwise>
	</c:choose>
</body>
</html>