<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link href="https://fonts.googleapis.com/css?family=Righteous&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Gothic+A1|Righteous&display=swap" rel="stylesheet">
<link rel="stylesheet" href="main.css">
<link rel="stylesheet" href="./css/bootstrap.css">
<title>Insert title here</title>
<script type="text/javascript">
	function check(){
		
		if(f.offerId.value ==""){
			alert("추천유튜버를 작성하여 주세요");
			f.offerId.focus();
			return false;
		}else if(f.oContent.value==""){
			alert("추천내용을 작성하여 주세요");
			f.oContent.focus();
			return false;
		}else{
			return true;
		}
		
		
	}
</script>
</head>
<body>
	<div>
		<jsp:include page="../main_top.jsp"></jsp:include>
	</div>
	<div>
		<jsp:include page="../main_menu.jsp"></jsp:include>
	</div>
	<form action="offerWrite.do" method="post" name=f onSubmit="return check()">
	<table border='0' width='1000' cellspacing='0' cellpadding='2' align=center style="font-size: 15pt">
		<tr>
			<th><h1>추천튜브</h1><input type="hidden" name="boardNo" value="3"></th>
		</tr>
		<tr bgcolor="black" style="color: white; font-size: 20pt" >
			<td colspan=4>추천채널 글쓰기</td>
		</tr>
		<tr>
			<Td colspan="4" height="2" bgcolor="red"></Td>
		</tr>
		<tr style="font-size: 15pt">
			<td width="250px" style="padding-left: 20px">아이디</td>
			<td width="250px">${id }<input type="hidden" name="id" value="${id}"></td>
			<td width="250px">닉네임</td>
			<td width="250px">${nick }<input type="hidden" name="nick" value="${nick}"></td>
		</tr>
		<tr>
			<td style="padding-left: 20px">추천하는 Youtuber</td>
			<td colspan="3"><input type="text" name="offerId" placeholder="유튜버 이름을 입력해주세요" style="width: 100%;"></td>
		</tr>
		<tr>
			<td style="padding-left: 20px">Youtuber 대표영상</td>
			<td colspan="3"><input type="text" name="oUrl" placeholder="Youtuber의 동영상 URL을 입력해주세요. 예) https://youtu.be/Q2W7-fB32RE" style="width:100%;"></td>
		</tr>
		<tr>
			<td style="padding-left: 20px">추천내용</td>
			<td colspan="3" height="300px"><input type="text" name="oContent" placeholder="해당 Youtuber의 프로필정보 추천이유를 작성해주세요." style="width: 100%;height: 100%"></td>
		</tr>
		<tr>
			<td colspan=4 bgcolor="red" height="3"></td>
		</tr>
		<tr>
			<td colspan=4 bgcolor="white" height=3></td>
		</tr>
		<tr>
			<td colspan=4 align="right"><input class="btn btn-danger" type="submit" value="유튜버 추천하기"></td>
		</tr>
	</table>
	</form>
	
</body>
</html>