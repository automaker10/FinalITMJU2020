<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ประเภทบัตรบุคคลไร้รัฐไร้สัญชาติ</title>
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

				<h3>รายการประเภทบัตรบุคคลไร้รัฐไร้สัญชาติ</h3>
				<br>
				<table class="table table-hover">

					<thead>
						<tr>
							<th><b>#หมายเลขประเเภทบัตร</b></th>
							<th><b>คำเรียกประเภทบัตร</b></th>
							<th><b>ความหมายประเภทบัตร</b></th>
							<th><b>แก้ไข</b></th>
							<th><b>ลบ</b></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="idcardtype">
							<tr>
								<td><c:out value="${idcardtype.idcardno}"></c:out></td>
								<c:set var="idcardcall1"
									value="${fn:replace(idcardtype.idcardcall, '%2F', '/')}" />
								<c:set var="idcardcall2"
									value="${fn:replace(idcardcall1, '%2C', ',')}" />
								<c:set var="idcardcall3"
									value="${fn:replace(idcardcall2, '+', ' ')}" />
								<td><c:out value="${idcardcall3}"></c:out></td>
								<c:set var="idcardmean1"
									value="${fn:replace(idcardtype.idcardmean, '%2F', '/')}" />
								<c:set var="idcardmean2"
									value="${fn:replace(idcardmean1, '%2C', ',')}" />
								<c:set var="idcardmean3"
									value="${fn:replace(idcardmean2, '+', ' ')}" />
								<td><c:out value="${idcardmean3}"></c:out></td>

								<td>
									<form action="/editidcardtype" method="post">
										<input type="hidden" name="idcardno"
											value="${idcardtype.idcardno}">
										<button type="submit" class="btn btn-primary">แก้ไข</button>
									</form>
								</td>
								<td>
									<form action="/removeidcardtype/deleteidcardtype" method="post">
										<input type="hidden" name="idcardno"
											value="${idcardtype.idcardno}">
										<button type="submit" class="btn btn-primary"
											onclick="return confirm('ต้องการลบประเภทบัตรฯนี้หรือไม่?')">ลบ</button>
									</form>
								</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
			<footer class="footer">
			<div class="container">
				<form action="/addidcardtype" method="post">
					<button type="submit" class="btn btn-primary">เพิ่มประเภทบัตรบุคคลไร้รัฐไร้สัญชาติ</button>
				</form>
			</div>
			</footer>

		</c:otherwise>
	</c:choose>
</body>
</html>