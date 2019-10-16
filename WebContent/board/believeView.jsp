<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="main.css">
<link
	href="https://fonts.googleapis.com/css?family=Righteous&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Gothic+A1|Righteous&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="main.css">
<link rel="stylesheet" href="./css/bootstrap.css">
<style type="text/css">
div {
	margin: auto;
}

.font {
	padding-left: 10px;
}

a.write {
	text-decoration: none;
	background: #333333;
	border-radius: 5px;
	color: white;
	padding: 3px 8px;
}

tr td input.btnRed {
	text-decoration: none;
	background: red;
	border-radius: 5px;
	color: white;
	padding: 3px 8px;
}

tr td input.btnBlack {
	text-decoration: none;
	background: #333333;
	border-radius: 5px;
	color: white;
	padding: 3px 8px;
}
</style>
</head>
<body>
	<div>
		<jsp:include page="../main_top.jsp"></jsp:include>
	</div>
	<div>
		<jsp:include page="../main_menu.jsp"></jsp:include>
	</div>
	
	<form action="believeDelete.do" method="post">
		<input type="hidden" name="id" value="${bView.id }">
		<input type="hidden" name="bNo" value="${bView.bNo }">
		<input type="hidden" name="nick" value="${bView.nick }">
		<table border='0' width='1000' cellspacing='0' cellpadding='2'
			align=center>
			<tr>
				<th colspan="6" align="left"><h1>믿고보는 게시판</h1></th>
			</tr>
			<tr>
				<td colspan="6" height="2" bgcolor="red"></td>
			</tr>
			<tr>
				
				<td colspan="6" class="one" align="center" style="background-color: black; color:white;"><h2>${bView.bTitle }</h2></td>
			</tr>
			<tr>
				<td colspan="6" height="2" bgcolor="red"></td>
			</tr>
			<tr height=7>
			<td style="width: 160px" align="center"><h4>게시자</h4></td>
			<td style="width: 160px"><h3>${bView.id }</h3></td>
			<td style="width: 160px" align="center"><h4>별명</h4></td>
			<td style="width: 160px"><h3>${bView.nick }</h3></td>
			<td style="width: 160px" align="center"><h4>게시일</h4></td>
			<td style="width: 160px"><h3>${bView.bDate }</h3></td>
			</tr>
			<tr>
				<td colspan="6" class="two" align="center"><iframe width="960"
						height="540" src="${bView.bUrl}" frameborder="0"
						allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
						allowfullscreen></iframe></td>
			</tr>
			<tr >
				<td colspan="6" align="center" bgcolor="black"><font
					color="white">내용</font></td>
			</tr>
			<tr>
				<td colspan="6"  height="300px">${bView.bContent }</td>
			</tr>
			<tr>
				<td colspan="6" height="0.5" bgcolor="red"></td>
			</tr>
			<tr>
				<td colspan="6" height="1" bgcolor="white"></td>
			</tr>
			<tr>
				<td colspan="6" align="right">
				<input type="button" value="목록보기" onClick="location.href='believePage.do'" class="btnBlack">
				<input class="btnRed" type="submit" value="삭제" /></td>
			</tr>
			</form>
	</table>
	


			<c:if test="${id ne null }"><!-- 세션 아이디가 없다면  댓글창 띄우지 않음 -->
			<table border='0' width='900' cellspacing='0' cellpadding='2'
			align=center>
				<tr>
					<td><h1>댓글</h1></td>
				</tr>
				<form action="replyAdd.do" method="post">
					<tr>
						<td colspan="4">
							<h3>${nick }<input type="hidden" name="nick" value="${nick }"><input
									type="hidden" name="id" value="${id }">
							</h3> <input type="hidden" name="boardNo" value="${bView.boardNo }">
							<input type="hidden" name="bNo" value="${bView.bNo }"> 
							</td>
							</tr><tr>
						<td colspan="4">
							<input type="text" style="border: 1px solid black; width: 900px; height: 50px; text-align: left; padding-left: 10px;"
							name="reContent" >
						</td>
						<td colspan=1 align="center" style="padding-top:;"><input
							type="submit" value="댓글작성" class="btnRed"
							onclick="window.location.reload()"></td>
					</tr>
					<tr>
					</tr>
				</form>
		</table>
	</c:if>
	
	
	
	<c:forEach items="${reDTO }" var="reply"><!-- 댓글 목록 띄우기 -->
		<table width=1000px align="center">
			<tr height=40px>
				<td width=100px><strong><h4>${reply.nick }</h4></strong><input type="hidden" name="id"
					value="${reply.id }" id="id"></td>
				<td>&emsp;</td>
				<td width="600">${reply.reContent }</td>
				<td align="center">
					<a href="reHitUp.do?reNo=${reply.reNo }&bNo=${bView.bNo}&boardNo=${bView.boardNo}"><strong>추천</strong> ${reply.reHit }</a>&nbsp; 
					<a href="reHateUp.do?reNo=${reply.reNo }&bNo=${bView.bNo}&boardNo=${bView.boardNo}"><strong>싫어요</strong> ${reply.reHate }</a> 
				
					<c:if test="${reply.id eq id }"> <!-- 리플아이디와 세션아이디가 같은곳에만 삭제 버튼 생성 -->
						<input type="button" value="삭제" 
						onClick="location.href='reDelete.do?reNo=${reply.reNo }&bNo=${bView.bNo}&boardNo=${bView.boardNo}'" 
						class="btnRed" >
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="3" height="0.5px" bgcolor="lightgray"></td>
				<td></td>
			</tr>
		</table>
	</c:forEach>


</body>
</html>