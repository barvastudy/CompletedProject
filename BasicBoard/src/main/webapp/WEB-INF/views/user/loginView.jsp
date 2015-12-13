<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
LoginPage
<br>
<form action="<c:url value="/user/userLogin.do"/>" method="post">
userId:<input type="text" name="userId" />
<br>
userPw:<input type="text" name="userPw" />
<br>
<button type="submit">login</button>
</form>
</body>
</html>