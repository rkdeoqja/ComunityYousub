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
	<table  border='0' width='1000' cellspacing='0' cellpadding='2' align=center style="font-size: 15pt">
		<tr align="left">
			<th colspan="4"><h1>아이템즈</h1><th>
		</tr>
		<tr>
			<td colspan=4 height="2" bgcolor="black" align="Center" style="color: white">채널에 아이템 추천하기</td>
		</tr>
		<tr>
		<td colspan=4 height="2" bgcolor="red"></td>
		</tr>
		<tr>
			<td colspan="1" align="center" style="width:250px">아이디</td>
			<td colspan="1" align="left" style="padding-left: 30px;width:250px" class="two"><h4>${id}</h4>
			<input type="hidden" name="id" value="${id }"></td>
			<td colspan="1" align="center" style="width:250px">별명</td>
			<td colspan="1" align="left" style="padding-left: 30px;width:250px" class="two"><h4>${nick}</h4>
			<input type="hidden" name="nick" value="${nick }"></td>
		</tr>
		<tr>
		<td colspan=4 height="3" bgcolor="red"></td>
		</tr>
		<tr>
			<td colspan="1" align="center" >요청 채널</td>
			<td colspan="3" class="two"><input type="Text" placeholder="해당 채널 이름을 입력하세요" name="chName" style="width:100%;height: 50px"></td>
		</tr>
		
		<tr>
			<td colspan="1" align="center" >요구 사항</td>
			<td colspan="3" class="two"><input type="text" style="width:100%; height:300px" name="iContent" placeholder="해당채널에 원하는 아이템을 추천해주세요 예)치킨 먹방 해주세요"></td>
		</tr>
		<tr>
		<td colspan=4 height="3" bgcolor="red"></td>
		</tr>
		<tr>
		<td colspan=4 height="3" bgcolor="white"></td>
		</tr>
		<tr>
			
			<td colspan="4" align="right"><input type="submit" value="아이템 추천하기" class="btn btn-danger"></td>
		</tr>
	</table>
</form>
</div>

</body>
</html>