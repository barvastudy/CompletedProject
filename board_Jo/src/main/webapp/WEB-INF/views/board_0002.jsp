
<%@page import="com.mysql.fabric.xmlrpc.base.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
<head>
<!DOCTYPE html> --%>

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
<script type="text/javascript" src="js/board_0002.js"></script>
<title>Spring Board</title>
</head>
<body>
	<form name="frm">
		<input type="hidden" id="TEST" name="TEST" value='${boardMainVO}'>
		<input type="hidden" id="deleteWhere" name="deleteWhere" value=''>
		<!-- Fixed navbar -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">SPRING PROJECT #01</a>
				</div>
				<div id="navbar" class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Board</a></li>
						<li><a href="#about">About</a></li>
						<li><a href="#contact">Contact</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Dropdown <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li role="separator" class="divider"></li>
								<li class="dropdown-header">Nav header</li>
								<li><a href="#">Separated link</a></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</nav>
		<!--// Fixed navbar -->

		<!-- Board Section -->
		<h2 class="sub-header">Board</h2>
		<div class="table-responsive">
			<table class="table table-striped original" id="boardTable">
				<colgroup>
					<col width="5%">
					<col width="10%">
					<col width="40%">
					<col width="40%">
					<col width="*">
				</colgroup>
				<thead>
					<tr>
						<th><input type="checkbox" id="checkListAll" name="checkListAll" /></th>
						<th>NO</th>
						<th>TITLE</th>
						<th>CONTENT</th>
					</tr>
				</thead>
				<tbody>
					<tr class="boardTbl original">
						<td><input type="checkbox" class="selectAll" name="checkList"/></td>
						<td><div id="NO"></div></td>
						<td><a href="#"> <span id="TITLE"> </span></a></td>
						<td><a href="#"> <span id="CONTENT"></span> 
						<input type="hidden" id="SEQ">
						</a></td>

						<%-- <td>${boardMainVO.title}</td>
   				<td>${boardMainVO.content}</td> --%>
					</tr>
				</tbody>
			</table>
		</div>

		<div align="right">
			<button class=”btn” id="SAVE">등록</button>
			<button class=”btn” id="MODIFY">수정</button>
			<button class=”btn” id="DELETE">삭제</button>
		</div>
		<!--// Board Section -->
		<%-- <p>${boardMainVO.content}</p>
<p>${boardMainVO.title}</p> --%>
		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
		<!-- <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script> -->
	</form>
</body>
</html>