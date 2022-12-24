<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>
<form th:action="@{/user}" method="post">
	email : <input type="text" name = "email"> <br>
	password : <input type="password" name="password"> <br>
	<input type="radio" name="auth" value="ROLE_ADMIN, ROLE_USER"> admin
	<input type="radio" name="auth" value="ROLE_USER"> user
	<button type="submint">가입</button>
</form><br>
<a href="/login">로그인</a>
</body>
</html>