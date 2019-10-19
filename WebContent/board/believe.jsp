<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<%@page import="com.yousub.DTO.*"%>
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
	background: black;
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

	<div>
		<table border='0' width='1200' cellspacing='0' cellpadding='2'
			align=center style="font-size: 13pt;text-align:center; ">
			<tr>
				<th colspan=5><h1>믿고보는 게시판</h1></th>
			</tr>
			<tr bgcolor="black" height=30>
				<td width=100><font color="white" class=font>&nbsp;&nbsp;게시판</font></td>
				<td><font color="white" class=font> 제목</font></td>
				<td width=150><font color="white" class=font>닉네임</font></td>
				<td  width=150><font color="white" class=font>작성일</font></td>
				<td  width=150><font color="white" class=font>조회수</font></td>

			</tr>
			<tr>
				<td colspan=5 height="3" bgcolor="red"></td>
			</tr>
			<%
				ArrayList<BelieveDTO> list = (ArrayList<BelieveDTO>) request.getAttribute("believe");

				int where = 1;//현재페이지

				int totalgroup = 0; // 총그룹이 넣어질변수
				int maxpages = 10; // 페이징에 보여질 갯수
				int startpage = 1; // 시작페이지 
				int endpage = startpage + maxpages - 1; //마지막페이지
				int wheregroup = 1;

				if (request.getParameter("go") != null) {
					where = Integer.parseInt(request.getParameter("go"));

					wheregroup = (where - 1) / maxpages + 1;

					startpage = (wheregroup - 1) * maxpages + 1;

					endpage = startpage + maxpages - 1;
				} else if (request.getParameter("gogroup") != null) {
					wheregroup = Integer.parseInt(request.getParameter("gogroup"));

					startpage = (wheregroup - 1) * maxpages + 1;
					endpage = startpage + maxpages - 1;

					where = startpage;
				}

				int nextgroup = wheregroup + 1;
				int priorgroup = wheregroup - 1;

				int nextpage = where + 1;
				int priorpage = where - 1;

				int startrow = 0;
				int endrow = 0;

				int maxrows = 15;

				int totalrows = 0;

				int totalpages = 0;

				if (list.size() > 0) {
					totalrows = list.size();

					totalpages = (totalrows - 1) / maxrows + 1;

					startrow = (where - 1) * maxrows;
					endrow = startrow + maxrows - 1;

					if (endrow >= totalrows) {
						endrow = totalrows - 1;
					}

					totalgroup = (totalpages - 1) / maxpages + 1;

					if (endpage > totalpages) {
						endpage = totalpages;
					}

				}

				for (int i = startrow; i < endrow; i++) {

					if (i % 2 == 0) {
			%>
			<tr bgcolor="white" height=30>
				<td><font color="black" class="font"><%=list.get(i).getbNo()%></font></td>
				<td><font color="black" class="font"> <a
						href="believeView.do?bNo=<%=list.get(i).getbNo()%>&boardNo=<%=list.get(i).getBoardNo()%>"><%=list.get(i).getbTitle()%></a></font></td>
				<td><font color="black" class="font"><%=list.get(i).getNick()%></font></td>
				<td><font color="black" class="font"><%=list.get(i).getbDate()%></font></td>
				<td><font color="black" class="font"><%=list.get(i).getbHit()%></font></td>
			</tr>
			<%
				} else {
			%>
			<tr bgcolor="lightgrey" height=30>
				<td><font color="black" class="font"><%=list.get(i).getbNo()%></font></td>
				<td><font color="black" class="font"> <a
						href="believeView.do?bNo=<%=list.get(i).getbNo()%>&BoardNo=<%=list.get(i).getBoardNo()%>"><%=list.get(i).getbTitle()%></a></font></td>
				<td><font color="black" class="font"><%=list.get(i).getNick()%></font></td>
				<td><font color="black" class="font"><%=list.get(i).getbDate()%></font></td>
				<td ><font color="black" class="font"><%=list.get(i).getbHit()%></font></td>
			</tr>
			<%
				}

				}
			%>



			<tr>
				<td colspan=5 height="3" bgcolor="red"></td>
			</tr>
			<tr>
				<td colspan=5 height="4" bgcolor="white"></td>
			</tr>
			<% if(session.getAttribute("id")!=null){
			%><tr>
				<td colspan="4"></td>
				<td><input type="button" value="글 작성하기"
					onClick="location.href='believeWritePage.do'" class="btnBlack">
				</td>
			</tr><%
			}%>
			<tr align=center>
				<td colspan=5><input type=text style="border:1px solid lightgrey ">&nbsp;&nbsp;<input type="button" onclick="location.href='believeSearch.do'" value="검색" class="btn btn_danger"></td>
			</tr>
		</table>

		<table align="center">
			<tr>
				<td>
					<%
						if (wheregroup > 1) {
					%><a href="believePage.do?go=1">처음</a> <a
					href="believePage.do?gogroup=<%=priorgroup%>">이전&nbsp;</a>
					<%
						} else {
					%>처음&nbsp;이전&nbsp;<%
						}

						for (int jj = startpage; jj <= endpage; jj++) {
							if (jj == where) {
					%><strong><%=jj%></strong>
					<%
						} else {
					%><a href="believePage.do?go=<%=jj%>">&nbsp;<%=jj%>&nbsp;
				</a>
					<%
						}
						}

						if (wheregroup < totalgroup) {
					%>&nbsp;<a href="believePage.do?gogroup=<%=nextgroup%>">다음</a> <a
					href="believePage.do?gogroup=<%=totalgroup%>">마지막</a>
					<%
						} else {
					%>&nbsp;다음&nbsp;마지막<%
						}
					%>


				</td>
			</tr>
		</table>
	</div>
</body>
</html>