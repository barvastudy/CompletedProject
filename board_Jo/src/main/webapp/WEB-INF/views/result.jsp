<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>Hello ${msg}</p>
	<p>Hello ${userVO.user_id}</p>
	<p>Hello ${userVO.user_pw}</p>
	
	<p>Title : ${boardVO.title} Content : ${boardVO.content}</p>
	
</body>
</html>