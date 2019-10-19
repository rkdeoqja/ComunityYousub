<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="main.css">
<link href="https://fonts.googleapis.com/css?family=Righteous&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Gothic+A1|Righteous&display=swap" rel="stylesheet">
<link rel="stylesheet" href="main.css">
<style type="text/css">
table{
margin-left:auto;
margin-right:auto;
margin-top:auto;
margin-botton:auto;
}
td{
text-align: center;
}
input{
	background:#EEEEEE;
}
tr td input.modify{

	text-decoration:none;
	background:#333333;
	border-radius: 5px;
	color:white;
	padding:3px 8px;

}
tr td a.memberDelete{

	text-decoration:none;
	
	background:red;
	border-radius: 5px;
	color:white;
	padding:3px 8px;

}
</style>
<script type="text/javascript">

function check(){
	if(f.pw.value==""){
		alert("변경할 비밀번호를 입력해 주세요");
		f.pw.focus();
		return false;
	}else{
		return true;
	}
	}
</script>
<title>회원 정보 페이지</title>
</head>
<body>
	<div>
		<jsp:include page="../main_top.jsp"></jsp:include>
	</div>
	<div>
		<jsp:include page="../main_menu.jsp"></jsp:include>
	</div>
	<form action="infoChange.do" method="post" name="f">
	<table width="800px" style="font-size: 15pt;">
	<tr height="90px" >
		<td bgcolor="black" colspan="2" align="center"><h1 style="color: white">회원정보</h1></td>
	</tr>
	<tr>
		<td colspan=5 height="4" bgcolor="red"></td>
	</tr>
	<c:forEach items="${userInfo}" var="dto">
		<tr height="90px" >
			<td class="list" bgcolor="black"><font color="white">회원 아이디</font></td>
			<td>${dto.id }</td>
		</tr>
		<tr height="90px" >
			<td class="list" bgcolor="black"><font color="white">비밀번호</font></td>
			<td bgcolor="#EEEEEE"><input type="password" name="pw"></td>
		</tr>
		<tr height="90px" >
			<td class="list" bgcolor="black"><font color="white">닉네임</font></td>
			<td>${dto.nick }</td>
		</tr>
		<tr height="90px" >
			<td class="list" bgcolor="black"><font color="white">이름</font></td>
			<td bgcolor="#EEEEEE">${dto.name }</td>
		</tr>
		<tr height="90px" >
			<td class="list" bgcolor="black"><font color="white">이메일</font></td>
			<td>${dto.email }</td>
		</tr>
		<tr height="90px" >
			<td class="list" bgcolor="black"><font color="white">비밀번호 힌트</font></td>
			<td bgcolor="#EEEEEE">${dto.pwhint }</td>
		</tr>
		<tr height="90px" >
			<td class="list" bgcolor="black"><font color="white">가입날짜</font></td>
			<td>${dto.joda }</td>
		</tr>
			<tr>
		<td colspan=5 height="4" bgcolor="red"></td>
	</tr>
	</c:forEach>
		<tr height="90px" >
			<td><input type="submit" value="회원정보 수정" class="modify" onSubmit="return check()"></td>
			<td><a href="memberDelete.do" class="memberDelete">회원 탈퇴</a></td>
		</tr>
		
	</table>
	</form>
</body>
</html>