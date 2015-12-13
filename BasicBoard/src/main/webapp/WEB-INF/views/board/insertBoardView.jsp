<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet"
	type="text/css" />

<script src="<c:url value="/js/jquery-2.1.4.js"/>"
	type="text/javascript"></script>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>

</head>
<body>
	<div class="col-lg-12">
		<div class="form-panel">
			<form class="form-horizontal style-form" method="post" action="<c:url value="/board/insertBoard.do"/>" >
				<input type="hidden" id="user" name="user" value="${user.seq }"/>
				제목:<input type="text" id="title" name="title"
					class="form-control"/> 
				내용:<textarea  id="content" name="content" class="form-control" ></textarea>
				<input type="submit"value="입력" />
			</form>
		</div>
	</div>



<script>
$(document).ready(function(){

});

</script>
</body>
</html>