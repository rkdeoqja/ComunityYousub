<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div>
	<div class=re_best style="height: 300px">
		<font class=logoft size=5pt margin-left=1em>
		best
		</font>
		<font class=kor size=5pt>
		댓글
		</font>
		<div>
		<iframe width="755px" height=250px scrolling=yes frameborder=0 srcdoc='
		<table align="center" style="margin-top: 10px">
		<c:forEach items="${ReplyBest}" var="replyBest" begin="0" end="9">
			<tr>
				<td><img src="./img/best.png" width="40px" height="20px"></td>
				<td><font size="4pt">${replyBest.nick }</font></td>
				<td>&emsp;</td>
				<td width="450px">${replyBest.reContent }</td>
				<td>&emsp;</td>
				<td><strong>${replyBest.reHit }</strong></td>
				<td>&nbsp;&nbsp;</td>
			</tr>
			</c:forEach>
		</table>
		'>
		</iframe>
		</div>
		</div>
		<div class="re_new" style="height: 300px">
		<font class=kor size=5pt>
		새로운 댓글
		</font>
		<div>
		<iframe width=760px height=250px scrolling="yes" frameborder=0 srcdoc='
		<table align="center" style="margin-top: 10px">
		<c:forEach items="${reNew }" var="replyNew" begin="0" end="9">
			<tr>
				<td><img src="./img/new.png" width="40px" height="20px"></td>
				<td width=70px><font size="4pt">${replyNew.nick }</font></td>
				<td>&emsp;</td>
				<td width="450px">${replyNew.reContent }</td>
				<td>&emsp;</td>
				<td><strong>${replyNew.reDate }</strong></td>
				<td>&nbsp;&nbsp;</td>
			</tr>
		</c:forEach>
		</table>
		'>
		</iframe>
		</div>
		</div>
</div>

</body>
</html>