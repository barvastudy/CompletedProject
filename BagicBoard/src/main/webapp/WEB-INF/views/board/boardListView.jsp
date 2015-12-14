<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<div class="row mt">
		<div class="col-md-12">
			<div class="task-content">
			
				<form action="<c:url value="/board/boardList.do"/>" method="get" id="boardListForm">
					<ul id="sortable" class="list-unstyled">
						<li class="list-primary">
							<div class="task-title">
								<span class="col-xs-2">번호</span> 
								<span class="col-xs-6">제목</span>
								<span class="col-xs-2">작성자</span> 
								<span class="col-sx-2"> 
									<select class="col-xs-1" id="pageCount" name="pageCount">
											<option value="20">20</option>
											<option value="30">30</option>
											<option value="40">40</option>
									</select>
								</span>
							</div>
						</li>

						<c:forEach var="board" items="${boardList}" varStatus="status">
							<li>
								<div>
									<span class="col-xs-3"><a
										href="<c:url value="/board/board.do?seq=${board.seq}"/>">${board.seq}</a></span>
									<span class="col-xs-6"><a
										href="<c:url value="/board/board.do?seq=${board.seq}"/>">${board.title}</a></span>
									<span class="col-xs-3"><a
										href="<c:url value="/board/board.do?seq=${board.seq}"/>">${board.user}</a></span>
								</div>
							</li>
						</c:forEach>
					</ul>
					<div>
						<input type="button" value="입력" class="col-xs-1" id="insertBtn" OnClick='location.href="<c:url value="/board/insertBoard.do"/>"'>
						<span class="col-xs-5"></span> <select class="col-xs-1"
							id="searchCondition" name="searchCondition">
							<option value="1">번호</option>
							<option value="2">제목</option>
							<option value="3">내용</option>
							<option value="4">작성자</option>
						</select> <span class="col-xs-2" id="searchContentSpan"><input
							type="text" name="searchKeyword" id="searchKeyword" value="${searchKeyword}" /></span> <input
							type="submit" value="검색" class="col-xs-1">
					</div>
			</div>
			</form>
		</div>
		<div align="center">

		<br>
		<fmt:parseNumber var="pageUnit" value="${(page-1)/10}" integerOnly="true"/>
		<fmt:parseNumber var="maxPage" value="${(totalCount%pageCount)==0?totalCount/pageCount:totalCount/pageCount+1}"  integerOnly="true"/>
		<c:set var="startPage" value="${pageUnit*10+1}" />
		<c:set var="endPage" value="${maxPage<(pageUnit+1)*10?maxPage:(pageUnit+1)*10}"/>
		<c:if test="${startPage>20}">
			<c:choose>
				<c:when test="${searchCondition eq null ||searchCondition !=0}">
					<a href="<c:url value="/board/boardList.do?page=1&searchCount=${pageCount}&searchCondition=${searchCondition}&searchKeyword=${searchKeyword}"/>">처음</a>&nbsp
					<a href="<c:url value="/board/boardList.do?page=${startPage-1 }&searchCount=${pageCount}&searchCondition=${searchCondition}&searchKeyword=${searchKeyword}"/>">이전</a>&nbsp
				</c:when>
				<c:otherwise>
					<a href="<c:url value="/board/boardList.do?page=1&pageCount=${pageCount}"/>">처음</a>&nbsp	
					<a href="<c:url value="/board/boardList.do?page=${startPage-1 }&pageCount=${pageCount}"/>">이전</a>&nbsp					
				</c:otherwise>
			</c:choose>
		</c:if>
		<c:forEach begin="${startPage}" end="${endPage}" varStatus="status" >
			<c:choose>
				<c:when test="${searchCondition eq null || searchCondition !=0}">
					<c:choose>
						<c:when test="${status.current eq page}">
						${status.current}&nbsp
						</c:when>
						<c:otherwise>
							<a href="<c:url value="/board/boardList.do?page=${status.current}&searchCount=${pageCount}&searchCondition=${searchCondition}&searchKeyword=${searchKeyword}"/>">${status.current}</a>&nbsp
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${status.current eq page}">
						${status.current}&nbsp
						</c:when>
						<c:otherwise>
							<a href="<c:url value="/board/boardList.do?page=${status.current}&pageCount=${pageCount}"/>">${status.current}</a>&nbsp
						</c:otherwise>	
					</c:choose>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${maxPage-endPage>10}">
			<c:choose>
				<c:when test="${searchCondition eq null ||searchCondition !=0}">
					<a href="<c:url value="/board/boardList.do?page=${endPage+1 }&searchCount=${pageCount}&searchCondition=${searchCondition}&searchKeyword=${searchKeyword}"/>">다음</a>&nbsp
					<a href="<c:url value="/board/boardList.do?page=${maxPage}&searchCount=${pageCount}&searchCondition=${searchCondition}&searchKeyword=${searchKeyword}"/>">끝</a>&nbsp
				</c:when>
				<c:otherwise>
					<a href="<c:url value="/board/boardList.do?page=${endPage+1 }&pageCount=${pageCount}"/>">다음</a>&nbsp	
					<a href="<c:url value="/board/boardList.do?page=${maxPage}&pageCount=${pageCount}"/>">끝</a>&nbsp							
				</c:otherwise>
			</c:choose>
		</c:if>
		</div>
	</div>

<script>
$(document).ready(function(){
	<c:if test="${searchCondition eq null ||searchCondition !=0}">
	$("#searchCondition option:eq(${searchCondition-1})").attr("selected", "selected");
	</c:if>
	<c:if test="${pageCount eq null ||pageCount !=20}">
	$("#pageCount option:eq(${pageCount/10-2})").attr("selected", "selected");
	</c:if>
	$("#pageCount").change(function(){
		console.log($( "#boardListForm" ).serialize());
		$( "#boardListForm" ).submit();
	});
	
});

</script>
</body>
</html>