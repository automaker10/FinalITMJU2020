<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>แก้ไขข้อมูลเจ้าหน้าที่ศูนย์ให้ความช่วยเหลือบุคคลไร้รัฐไร้สัญชาติ</title>
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
					<form action="/liststaff" method="post">
						<input type="hidden" name='username' class='form-control'
							value="${username}" /> <input type='hidden' name='password'
							class='form-control' value="${password}" /> <input type='hidden'
							name='telcenter' class='form-control' value="${telcenter}" />
						<button type="submit" class="home">รายชื่อเจ้าหน้าที่ภายในศูนย์ฯ</button>
					</form>
				</ul>
				<ul class="nav navbar-nav">
					<a href="${pageContext.request.contextPath}/logout"><input
						type="button" name="logout" value="ออกจากระบบ" class="logout"></a>
				</ul>
			</div>
			</nav>

			<div class="container">
				<h3>เพิ่มเจ้าหน้าที่ศูนย์ให้ความช่วยเหลือฯ</h3>
				<br>
				<form action='/createstaff/updatestaff' method='post'>
					<input type="hidden" name='usernamepresident' class='form-control'
						value="${username}" /> <input type='hidden'
						name='passwordpresident' class='form-control' value="${password}" />
					<input type='hidden' name='telcenter' class='form-control'
						value="${telcenter}" /> <input type='hidden' name='usernamestaff'
						class='form-control' value="${staff.username}" /> <font
						color="red"><center>
							<b><c:out value="${danger}"></c:out></b>
						</center></font>

					<tr>
						<c:set var="nameperson1"
							value="${fn:replace(staff.nameperson, '%2F', '/')}" />
						<c:set var="nameperson2"
							value="${fn:replace(nameperson1, '%2C', ',')}" />
						<c:set var="nameperson3"
							value="${fn:replace(nameperson2, '+', ' ')}" />
						<td><b>ชื่อ-นามสกุล</b></td>
						<td><input type='text' name='nameperson'
							value="${nameperson3}" class='form-control' required /></td>
					</tr>

					<tr>
						<td><b>ตำแหน่ง</b></td>
						<td><c:set var="position1"
								value="${fn:replace(staff.position, '%2F', '/')}" /> <c:set
								var="position2" value="${fn:replace(position1, '%2C', ',')}" />
							<c:set var="position3" value="${fn:replace(position2, '+', ' ')}" />
							<input type='text' name='position' value="${position3}"
							class='form-control' required /></td>
					</tr>

					<tr>
						<td><b>อีเมลล์</b></td>
						<td><input type='text' name='emailperson'
							value="${staff.emailperson}" class='form-control' size="20"
							required /></td>

					</tr>
					<tr>
						<td><b>เบอร์โทร</b></td>
						<td><input type='text' name='telperson'
							value="${staff.telperson}" class='form-control' size="20"
							required /></td>

					</tr>
					<tr>
						<c:set var="address1"
							value="${fn:replace(staff.address, '%2F', '/')}" />
						<c:set var="address2" value="${fn:replace(address1, '%2C', ',')}" />
						<c:set var="address3" value="${fn:replace(address2, '+', ' ')}" />
						<td><b>ที่อยู่</b></td>
						<td><textarea type='text' name='address' class='form-control'
								size="20" required>${address3}</textarea></td>

					</tr>

					<tr>
						<td></td>
						<br>
						<td>
							<button type="submit" class="btn btn-primary">แก้ไขข้อมูล</button>
						</td>
					</tr>

					</table>
				</form>
			</div>
		</c:otherwise>
	</c:choose>

</body>
</html>