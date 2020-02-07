<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ศูนย์ให้ความช่วยเหลือบุคคลไร้รัฐไร้สัญชาติ</title>
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
					<a href="${pageContext.request.contextPath}/logout"><input type="button" name="logout" value="ออกจากระบบ"
						class="logout"></a>
				</ul>
			</div>
			</nav>
			<div class="container">

				<h3>รายชื่อศูนย์ให้ความช่วยเหลือบุคคลไร้รัฐไร้สัญชาติ</h3>
				<br>
				<table class="table table-hover">

					<thead>
						<tr>
							<th><b>#เบอร์โทร</b></th>
							<th><b>ชื่อศูนย์ให้ความช่วยเหลือฯ</b></th>
							<th><b>อีเมลล์</b></th>
							<th><b>ที่อยู่</b></th>
							<th><b>แก้ไข</b></th>
							<th><b>ลบ</b></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="center">
							<tr>
								<td><c:out value="${center.telcenter}"></c:out></td>
								<c:set var="namecenter1"
									value="${fn:replace(center.namecenter, '%2F', '/')}" />
								<c:set var="namecenter2"
									value="${fn:replace(namecenter1, '%2C', ',')}" />
								<c:set var="namecenter3"
									value="${fn:replace(namecenter2, '+', ' ')}" />
								<td><c:out value="${namecenter3}"></c:out></td>
								<td><c:out value="${center.emailcenter}"></c:out></td>
								<c:set var="addcenter1"
									value="${fn:replace(center.addresscenter, '%2F', '/')}" />
								<c:set var="addcenter2"
									value="${fn:replace(addcenter1, '%2C', ',')}" />
								<c:set var="addcenter3"
									value="${fn:replace(addcenter2, '+', ' ')}" />
								<td><c:out value="${addcenter3}"></c:out></td>

								<td>
									<form action="/listallcenter/editcenter" method="post">
										<input type="hidden" name="telcenter"
											value="${center.telcenter}"> <input type="hidden"
											name="namecenter" value="${center.namecenter}">
										<button type="submit" class="btn btn-primary">แก้ไข</button>
									</form>
								</td>
								<td>
									<form action="/removecenteradmin/deletecenter" method="post">
										<input type="hidden" name="telcenter"
											value="${center.telcenter}"> <input type="hidden"
											name="namecenter" value="${center.namecenter}">
										<button type="submit" class="btn btn-primary"
											onclick="return confirm('ต้องการลบหรือไม่?')">ลบ</button>
									</form>
								</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
			<footer class="footer">
			<div class="container">
				<form action="/createcenteradmin/addcenter" method="post">
					<button type="submit" class="btn btn-primary">เพิ่มศูนย์ให้ความช่วยเหลือฯ</button>
				</form>
			</div>
			</footer>
		</c:otherwise>
	</c:choose>
</body>
</html>