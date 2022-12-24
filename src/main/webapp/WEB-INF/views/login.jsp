<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
<h1>로그인</h1>

<form action="login" method="POST">
	<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
	email : <input type="text" name="username"> <br>
	password : <input type="password" name="password"> <br>
	<button type="submit">로그인</button>
</form><br>

<a href="/signup">회원가입</a>
</body>
</html>