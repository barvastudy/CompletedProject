<%--  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
function btnClick(){
	location.href="boardMainSelectAll";
}

</script>
<title>Insert title here</title>
</head>
<body>
<p>Bootstrap Board_Main</p><br><br>
	
<div>
	<!-- <input type="button" value="Click" id="boardMainSelect"><br> -->
	<a href="boardMainSelectAll">Click Board</a>
	<input type="button" onClick="btnClick()" id="btnBoard"> 
</div>
</body>
</html>