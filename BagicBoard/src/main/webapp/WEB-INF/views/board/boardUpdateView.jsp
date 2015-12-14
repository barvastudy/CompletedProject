<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="col-lg-12">
		<div class="form-panel">
			<form:form class="form-horizontal style-form" method="post"  commandName="board" >
				<form:input type="hidden"  path="user" /><br>
				제목:<form:input type="text"	class="form-control" path="title"/> <br>
				내용:<form:textarea  class="form-control"  path="content" ></form:textarea><br>
				<input type="submit"value="수정" />
			</form:form>
		</div>
		<input type="button" value="목록" class="col-xs-1" OnClick='location.href="<c:url value="/board/boardList.do"/>"'>
		<c:if test="user.seq eq board.seq">
			<input type="button" value="취소" class="col-xs-1" OnClick='location.href="<c:url value="/board/board.do?seq=${board.seq}"/>"'>
		</c:if>
	</div>

</body>
</html>