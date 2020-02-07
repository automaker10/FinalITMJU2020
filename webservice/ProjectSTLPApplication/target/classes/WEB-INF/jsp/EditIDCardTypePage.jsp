<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>แก้ไขประเภทบัตรบุคคลไร้รัฐไร้สัญชาติ</title>
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

				<h3>รายละเอียดประเภทบัตรบุคคลไร้รัฐไร้สัญชาติ</h3>
				<form action='/editidcardtype/updateidcardtype' method='post'>

					<table class='table table-hover table-responsive'>

						<tr>
							<td><b>#หมายเลขประเภทบัตร</b></td>
							<td><input type='text' name='idcardno' class='form-control'
								value="${idcardtype.idcardno}" readonly /></td>
						</tr>

						<tr>
							<c:set var="idcardcall1"
								value="${fn:replace(idcardtype.idcardcall, '%2F', '/')}" />
							<c:set var="idcardcall2"
								value="${fn:replace(idcardcall1, '%2C', ',')}" />
							<c:set var="idcardcall3"
								value="${fn:replace(idcardcall2, '+', ' ')}" />
							<c:set var="idcardcall4"
								value="${fn:replace(idcardcall3, '%0A', System.lineSeparator())}" />
							<c:set var="idcardcall5"
								value="${fn:replace(idcardcall4, '%29','-')}" />
							<c:set var="idcardcall6"
								value="${fn:replace(idcardcall5, '%28','-')}" />
							<td><b>คำเรียกประเภทบัตร</b></td>
							<td><input type='text' name='idcardcall'
								class='form-control' value="${idcardcall6}" required /></td>
						</tr>
						<tr>
							<c:set var="idcardmean1"
								value="${fn:replace(idcardtype.idcardmean, '%2F', '/')}" />
							<c:set var="idcardmean2"
								value="${fn:replace(idcardmean1, '%2C', ',')}" />
							<c:set var="idcardmean3"
								value="${fn:replace(idcardmean2, '+', ' ')}" />
							<c:set var="idcardmean4"
								value="${fn:replace(idcardmean3, '%0A', System.lineSeparator())}" />
							<c:set var="idcardmean5"
								value="${fn:replace(idcardmean4, '%29','-')}" />
							<c:set var="idcardmean6"
								value="${fn:replace(idcardmean5, '%28','-')}" />
							<td><b>ความหมายประเภทบัตร</b></td>
							<td><textarea type='text' name='idcardmean'
									class='form-control' size="20" required>${idcardmean6}</textarea></td>

						</tr>

						<tr>
							<c:set var="idcardjob1"
								value="${fn:replace(idcardtype.idcardjob, '%2F', '/')}" />
							<c:set var="idcardjob2"
								value="${fn:replace(idcardjob1, '%2C', ',')}" />
							<c:set var="idcardjob3"
								value="${fn:replace(idcardjob2, '+', ' ')}" />
							<c:set var="idcardjob4"
								value="${fn:replace(idcardjob3, '%0A', System.lineSeparator())}" />
							<c:set var="idcardjob5"
								value="${fn:replace(idcardjob4, '%29','-')}" />
							<c:set var="idcardjob6"
								value="${fn:replace(idcardjob5, '%28','-')}" />
							<td><b>งานที่สามารถทำได้</b></td>
							<td><textarea type='text' name='idcardjob'
									class='form-control' size="20" required>${idcardjob6}</textarea></td>

						</tr>

						<tr>
							<c:set var="benefitsfromgovern1"
								value="${fn:replace(idcardtype.benefitsfromgovern, '%2F', '/')}" />
							<c:set var="benefitsfromgovern2"
								value="${fn:replace(benefitsfromgovern1, '%2C', ',')}" />
							<c:set var="benefitsfromgovern3"
								value="${fn:replace(benefitsfromgovern2, '+', ' ')}" />
							<c:set var="benefitsfromgovern4"
								value="${fn:replace(benefitsfromgovern3, '%0A', System.lineSeparator())}" />
							<c:set var="benefitsfromgovern5"
								value="${fn:replace(benefitsfromgovern4, '%29','-')}" />
							<c:set var="benefitsfromgovern6"
								value="${fn:replace(benefitsfromgovern5, '%28','-')}" />
							<td><b>สวัสดิการจากหน่วยงานภาครัฐ</b></td>
							<td><textarea type='text' name=benefitsfromgovern
									class='form-control' size="20" required>${benefitsfromgovern6}</textarea></td>

						</tr>
						<tr>
							<td></td>
							<td><input type="hidden" name='username'
								class='form-control' size="20" value="${idcardtype.idcardno}" />
								<button type="submit" class="btn btn-primary">บันทึกข้อมูล</button>
							</td>
						</tr>

					</table>
				</form>
		</c:otherwise>
	</c:choose>
</body>
</html>