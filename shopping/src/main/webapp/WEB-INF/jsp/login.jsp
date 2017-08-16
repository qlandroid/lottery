<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商店管理系统登陆</title>
<script type="text/javascript" src="../js/jquery_v3.2.1.js"></script>
<script type="text/javascript" src="../js/login.js"></script>
<link type="text/css" href="../css/login.css" rel="stylesheet">
</head>
<body>
	<div>
		<div class="login_content">

			<form action="${pageContext.request.contextPath}/user/login"
				method="post" id="login_fm">
				<input type="text" name="account" placeholder="account"><br>
				<p>
					<c:if test="${user.message != null}">
		${user.message }
		</c:if>

				</p>
				<input type="text" name="pw" placeholder="password"><br>
				<input type="submit" value="登陆">
			</form>
		</div>
	</div>

</body>
</html>