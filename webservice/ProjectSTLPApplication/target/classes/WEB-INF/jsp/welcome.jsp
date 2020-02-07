<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>หน้าแรก</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
<link href="/css/sticky-footer-navbar.css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<c:choose>
    <c:when test="${usernamesession == null}">
        <jsp:include page="login.jsp"></jsp:include>
        <br />
    </c:when>    
    <c:otherwise>
        <c:choose>
		<c:when test="${typeuser=='0'}">
			<jsp:include page="welcomeadmin.jsp"></jsp:include>
			<br />
		</c:when>
		<c:otherwise>
        	<jsp:include page="indexpresidentadmin.jsp"></jsp:include>
			<br /> 
		</c:otherwise>
	</c:choose> 
        <br />
    </c:otherwise>
</c:choose>

</body>
</html>