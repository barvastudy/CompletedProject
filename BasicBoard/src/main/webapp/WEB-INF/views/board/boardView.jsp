<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="col-lg-12">
		<div class="form-panel">
			
				번호:${board.seq }
				글쓴이:${board.user }
				제목:${board.title }
				내용:${board.content }
				
				<br>
				${board.user }
				<br>
				${user.seq }
				
		</div>
		<input type="button" value="목록" class="col-xs-1" OnClick='location.href="<c:url value="/board/boardList.do"/>"'>
		<c:if test="${ user.seq eq board.user}">
			<input type="button" value="수정" class="col-xs-1" OnClick='location.href="<c:url value="/board/updateBoard.do?seq=${board.seq}"/>"'>
			<input type="button" value="삭제" class="col-xs-1"  OnClick='location.href="<c:url value="/board/deleteBoard.do?seq=${board.seq}"/>"'>
		</c:if>
	</div>

</body>
</html>