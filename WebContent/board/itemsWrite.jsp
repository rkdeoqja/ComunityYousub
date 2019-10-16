<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link href="https://fonts.googleapis.com/css?family=Righteous&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Gothic+A1|Righteous&display=swap" rel="stylesheet">
<link rel="stylesheet" href="main.css">
<link rel="stylesheet" href="./css/bootstrap.css">
<title>Insert title here</title>
<style type="text/css">
.button{
	
	text-decoration:none;
	
	background:#333333;
	border-radius: 5px;
	color:white;
	padding:3px 8px;
}

div{margin:auto;}
</style>
</head>
<body>
<div>

	<jsp:include page="../main_top.jsp"></jsp:include>
</div>
	
	<div>
		<jsp:include page="../main_menu.jsp"></jsp:include>
	</div>

<div>
<form action="itemsWrite.do" method="post">
	<table  border='0' width='1200' cellspacing='0' cellpadding='2' align=center>
		<tr align="left">
			<th><h1>아이템즈</h1><th>
		</tr>
		<tr>
			<td colspan=4 height="2" bgcolor="black" align="Center" style="color: white">채널에 아이템 추천하기</td>
		</tr>
		<tr>
		<td colspan=4 height="2" bgcolor="red"></td>
		</tr>
		<tr>
			<td colspan="1" align="center" style="width:240px">아이디</td>
			<td colspan="1" align="left" style="padding-left: 30px;" class="two"><h4>${id}</h4>
			<input type="hidden" name="id" value="${id }"></td>
			<td colspan="1" align="center" >별명</td>
			<td colspan="1" align="left" style="padding-left: 30px;" class="two"><h4>${nick}</h4>
			<input type="hidden" name="nick" value="${nick }"></td>
		</tr>
		<tr>
		<td colspan=4 height="0.5" bgcolor="red"></td>
		</tr>
		<tr>
			<td colspan="4" align="center" style="background-color:black; color:white">요청 채널</td>
			</tr>
			<tr>
			<td colspan="4" class="two"><input type="Text" size="180" placeholder="해당 채널 이름을 입력하세요" name="chName" style="height: 50px"></td>
		</tr>
		
		<tr>
			<td colspan="4" align="center" style="background-color:black; color:white;" >요구 사항</td>
		</tr>
		<tr>
		<td colspan=4 height="0.5" bgcolor="red"></td>
		</tr>
		<tr>
			<td colspan="4" class="two"><textArea rows="20" cols="180" name="iContent" placeholder="해당채널에 원하는 아이템을 추천해주세요"></textArea></td>
		</tr>
		<tr>
		<td colspan=4 height="0.5" bgcolor="red"></td>
		</tr>
		<tr>
			
			<td colspan="4" align="right"><input type="submit" value="작성" class="btn btn-black"></td>
		</tr>
	</table>
</form>
</div>

</body>
</html>