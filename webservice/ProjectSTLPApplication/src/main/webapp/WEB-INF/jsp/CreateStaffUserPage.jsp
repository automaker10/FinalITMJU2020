<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>เพิ่มเจ้าหน้าที่ศูนย์ให้ความช่วยเหลือบุคคลไร้รัฐไร้สัญชาติ</title>
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
				<form action='/createstaff/savestaff' method='post'>
					<input type="hidden" name='usernamepresident' class='form-control'
						value="${username}" /> <input type='hidden'
						name='passwordpresident' class='form-control' value="${password}" />
					<input type='hidden' name='telcenter' class='form-control'
						value="${telcenter}" /> <font color="red"><center>
							<b><c:out value="${danger}"></c:out></b>
						</center></font>

					<tr>
						<td><b>ชื่อ-นามสกุล</b></td>
						<td><input type='text' name='nameperson' class='form-control'
							required /></td>
					</tr>

					<tr>
						<td><b>ตำแหน่ง</b></td>
						<td><input type='text' name='position' class='form-control'
							required /></td>
					</tr>

					<tr>
						<td><b>อีเมลล์</b></td>
						<td><input type='text' name='emailperson'
							class='form-control' size="20" required /></td>

					</tr>
					<tr>
						<td><b>เบอร์โทร</b></td>
						<td><input type='text' name='telperson' class='form-control'
							size="20" required /></td>

					</tr>
					<tr>
						<td><b>ที่อยู่</b></td>
						<td><textarea type='text' name='address' class='form-control'
								size="20" required></textarea></td>

					</tr>

					<tr>
						<td><b>ชื่อผู้ใช้งาน</b></td>
						<td><input type='text' name='username' class='form-control'
							size="20" required /></td>

					</tr>

					<tr>
						<td><b>รหัสผ่าน</b></td>
						<td><input type='password' name='passwordstaff'
							class='form-control' size="20" required /></td>

					</tr>


					<tr>
						<td></td>
						<br>
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