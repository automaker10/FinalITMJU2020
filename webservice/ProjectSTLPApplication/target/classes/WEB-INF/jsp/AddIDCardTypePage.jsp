<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>เพิ่มประเภทบัตรบุคคลไร้รัฐไร้สัญชาติ</title>
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
					<a href="${pageContext.request.contextPath}/logout"><input
						type="button" name="logout" value="ออกจากระบบ" class="logout"></a>
				</ul>
			</div>
			</nav>

			<div class="container">

				<h3>เพิ่มประเภทบัตรบุคคลไร้รัฐไร้สัญชาติ</h3>
				<br>
				<form action='/addidcardtype/saveidcardtype' method='post'>
					<font color="red"><center>
							<b><c:out value="${danger}"></c:out></b>
						</center></font>
					<table class='table table-hover table-responsive'>

						<tr>
							<td><b>#หมายเลขประเภทบัตร</b></td>
							<td><input type='text' name='idcardno' class='form-control'
								pattern="\d*" maxlength="13" required /></td>
						</tr>

						<tr>
							<td><b>คำเรียกประเภทบัตรฯ</b></td>
							<td><input type='text' name='idcardcall'
								class='form-control' required /></td>
						</tr>

						<tr>
							<td><b>หมายความประเภทบัตร</b></td>
							<td><textarea type='text' name='idcardmean'
									class='form-control' size="20" required></textarea></td>

						</tr>
						<tr>
							<td><b>งานที่สามารถทำได้</b></td>
							<td><textarea type='text' name='idcardjob'
									class='form-control' size="20" required></textarea></td>

						</tr>


						<tr>
							<td><b>สวัสดิการจากหน่วยงานภาครัฐ</b></td>
							<td><textarea type='text' name='benefitsfromgovern'
									class='form-control' size="20" required></textarea></td>

						</tr>

						<tr>
							<td></td>
							<td>
								<button type="submit" class="btn btn-primary">เพิ่มข้อมูล</button>
							</td>
						</tr>

					</table>
				</form>
			</div>
		</c:otherwise>
	</c:choose>

</body>
</html>