
<%@page import="com.mysql.fabric.xmlrpc.base.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String seq = request.getParameter("SEQ");
%>

<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<!-- <link href="justified-nav.css" rel="stylesheet"> -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="js/board_0002_01.js"></script>
<title>Modify Page</title>
</head>
<body>
	<form name="frm">
		<input type="hidden" name="seq" id="SEQ" value="<%=seq%>">
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<label class="navbar-brand">Modify Page</label>
				</div>
			</div>
		</nav>

		<h2 class="sub-header">Modify Page</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<colgroup>
					<col width="20%">
					<col width="70%">
					<col width="*%">
				</colgroup>
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan='2'>
							<input type="text" id="TITLE" name="title" value="${boardMainVO.title}" style="width:80%;">
						</td>
					</tr>
					<tr>
						<th>Content</th>
						<td colspan="2">
							<textarea rows="8" cols="55%" id="CONTENT" name="content">${boardMainVO.content}</textarea>
						</td>
					</tr>
				</tbody>
			</table>
		</div>

		<div align="right">
			<button class=”btn” id="SAVE">저장</button>
			<button class=”btn” id="CANCEL">취소</button>
		</div>
	</form>
</body>
</html>