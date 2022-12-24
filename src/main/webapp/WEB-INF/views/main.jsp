<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
<h1>회원 전용 페이지</h1>
ID : <span sec:sauthentication="name"></span> <br>
권한 : <span sec:sauthentication="authorities"></span> <br>

<form id="logout" action="logout" method="post">
	<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
	<input type="submit" value="로그아웃" />
</form>
</body>
</html>