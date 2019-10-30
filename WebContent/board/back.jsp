<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="com.yousub.DTO.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="main.css">
<link
	href="https://fonts.googleapis.com/css?family=Righteous&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Gothic+A1|Righteous&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="main.css">
<link rel="stylesheet" href="./css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>
	<div>
		<jsp:include page="../main_top.jsp"></jsp:include>
	</div>
	<div>
		<jsp:include page="../main_menu.jsp"></jsp:include>
	</div>
	<div>
		<table border='0' width='1000' cellspacing='0' cellpadding='2'
			align=center style="font-size: 13pt;text-align:center; ">
			<tr>
				<th align="left"><h1>백스토리</h1></th>
			</tr>
			<tr bgcolor="black" height=30 style="color: white">
				<td>글번호</td>
				<td>유튜버 이름</td>
				<td>불만사항</td>
				<td>게시일</td>
				<td>조회수</td>
			</tr>
			<tr>
				<td colspan=5 bgcolor="red" height="2"></td>
			</tr>
			
			<% ArrayList<BackDTO> list = (ArrayList<BackDTO>) request.getAttribute("back"); 
			

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
			<td><font color="black" class="font"><%=list.get(i).getbYoutuber()%></font></td>
			<td><font color="black" class="font"> <a
					href="backView.do?bNo=<%=list.get(i).getbNo()%>&boardNo=<%=list.get(i).getBoardNo()%>"><%=list.get(i).getbContent()%></a></font></td>
			<td><font color="black" class="font"><%=list.get(i).getbDate()%></font></td>
			<td><font color="black" class="font"><%=list.get(i).getbHit()%></font></td>
		</tr>
		<%
			} else {
		%>
			<tr bgcolor="white" height=30>
			<td><font color="black" class="font"><%=list.get(i).getbNo()%></font></td>
			<td><font color="black" class="font"><%=list.get(i).getbYoutuber()%></font></td>
			<td><font color="black" class="font"> <a
					href="backView.do?bNo=<%=list.get(i).getbNo()%>&boardNo=<%=list.get(i).getBoardNo()%>"><%=list.get(i).getbContent()%></a></font></td>
			<td><font color="black" class="font"><%=list.get(i).getbDate()%></font></td>
			<td><font color="black" class="font"><%=list.get(i).getbHit()%></font></td>
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
				%><a href="backPage.do?go=1">처음</a> <a
				href="backPage.do?gogroup=<%=priorgroup%>">이전&nbsp;</a>
				<%
					} else {
				%>처음&nbsp;이전&nbsp;<%
					}

					for (int jj = startpage; jj <= endpage; jj++) {
						if (jj == where) {
				%><strong><%=jj%></strong>
				<%
					} else {
				%><a href="backPage.do?go=<%=jj%>">&nbsp;<%=jj%>&nbsp;
			</a>
				<%
					}
					}

					if (wheregroup < totalgroup) {
				%>&nbsp;<a href="backPage.do?gogroup=<%=nextgroup%>">다음</a> <a
				href="backPage.do?gogroup=<%=totalgroup%>">마지막</a>
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