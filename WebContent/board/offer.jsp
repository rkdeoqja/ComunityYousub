<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.ArrayList" %>
    <%@page import = "com.yousub.DTO.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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
		<table border='0' width='1100' cellspacing='0' cellpadding='2'
			align=center>
			<tr>
				<th><h1>추천튜브</h1></th>
			</tr>
			<tr bgcolor="black" height=30>
				<td width=150px align="center"><font color="white" class=font>&nbsp;&nbsp;추천채널</font></td>
				<td style=" text-align: center" width=550px ><font color="white" class=font>추천내용</font></td>
				<td width=100 align="center"><font color="white" class=font>&nbsp;&nbsp;닉네임</font></td>
				<td width=100 align="center"><font color="white" class=font>&nbsp;&nbsp;작성일</font></td>
				<td width=100 align="center"><font color="white" class=font>&nbsp;&nbsp;조회수</font></td>
				<td width=100 align="center"><font color="white" class=font>&nbsp;&nbsp;영상유무</font></td>

			</tr>
			<tr>
				<td colspan=6 height="2" bgcolor="red"></td>
			</tr>
			
			<% ArrayList<OfferDTO> offerList = (ArrayList<OfferDTO>) request.getAttribute("offerList"); 
				
				int where = 1;
				
				int totalgroup =0;
				int maxpages=10;
				int startpage = 1;
				int endpage = startpage + maxpages - 1;
				int wheregroup = 1;
				if(request.getParameter("ogo") !=null){
					where = Integer.parseInt(request.getParameter("ogo"));
					
					wheregroup = (where -1) / maxpages +1;
					
					startpage = (wheregroup - 1) * maxpages +1;
					
					endpage = startpage + maxpages - 1;
					
				}else if(request.getParameter("ogogroup") != null){
					wheregroup = Integer.parseInt(request.getParameter("ogogroup"));
					
					startpage = (wheregroup -1)*maxpages+1;
					endpage = startpage+ maxpages -1;
					
					where = startpage;
				}
			
				int nextgroup = wheregroup +1;
				int priorgroup = wheregroup -1;
				
				int nextpage = where +1;
				int priorpage = where -1;
				
				int startrow = 0;
				int endrow = 0;
				
				int maxrows = 15;
				int totalrows = 0;
				int totalpages = 0;
				
				if(offerList.size() > 0){
					totalrows = offerList.size();
					totalpages = (totalrows-1) / maxrows +1;
					startrow = (where -1)*maxrows;
					endrow = startrow +maxrows-1;
					
					if(endrow >= totalrows){
						endrow = totalrows -1;
					}
					
					totalgroup = (totalpages-1)/maxpages+1;
					
					if(endpage > totalpages){
						endpage = totalpages;
					}
				}
				
				for(int i = startrow;i<endrow;i++){
					if(i%2 == 0){
			%>
						<tr bgcolor="white" height=30 align="center">
							<td width=150px><font color="black" class=font>&nbsp;&nbsp;<%=offerList.get(i).getOfferId() %></font></td>
							<td style=" text-align: center" width=550px ><a href="offerView.do?oNo=<%=offerList.get(i).getoNo() %>"><font color="black" class=font><%=offerList.get(i).getoContent() %></font></a></td>
							<td width=100><font color="black" class=font>&nbsp;&nbsp;<%=offerList.get(i).getNick() %></font></td>
							<td width=100><font color="black" class=font>&nbsp;&nbsp;<%=offerList.get(i).getoDate() %></font></td>
							<td width=100><font color="black" class=font>&nbsp;&nbsp;<%=offerList.get(i).getoHit() %></font></td>
							<%if(offerList.get(i).getoUrl().equals("not")){ 
							%>
								<td width=100 align="center">무</td>
							<%
							}else{
							%>
								<td width=100 align="center">유</td>
							<%
							}
							%>
						</tr>
			<%			
					}else{
			%>
						<tr bgcolor="lightgrey" height=30 align="center">
							<td width=150px><font color="black" class=font>&nbsp;&nbsp;<%=offerList.get(i).getOfferId() %></font></td>
							<td style=" text-align: center" width=550px ><a href="offerView.do?oNo=<%=offerList.get(i).getoNo() %>"><font color="black" class=font><%=offerList.get(i).getoContent() %></font></a></td>
							<td width=100><font color="black" class=font>&nbsp;&nbsp;<%=offerList.get(i).getNick() %></font></td>
							<td width=100><font color="black" class=font>&nbsp;&nbsp;<%=offerList.get(i).getoDate() %></font></td>
							<td width=100><font color="black" class=font>&nbsp;&nbsp;<%=offerList.get(i).getoHit() %></font></td>
							<%if(offerList.get(i).getoUrl().equals("not")){ 
							%>
								<td width=100 align="center">무</td>
							<%
							}else{
							%>
								<td width=100 align="center">유</td>
							<%
							}
							%>
						</tr>
			<%			
					}
				}
			
			%>
			<tr>
				<td colspan=6 height="2" bgcolor="red"></td>
			</tr>
			<tr>
				<td colspan=6 height="4" bgcolor="white"></td>
			</tr>
			<% if(session.getAttribute("id") !=null){
			%>
				<tr>
					<td colspan=5></td>
					<td><input type="button" value="채널 추천하기" onClick="location.href='offerWritePage.do'" class="btn btn_black"></td>
				</tr>
			<%
			}
			%>
			<tr align=center>
				<td colspan=6><input type=text style="border:1px solid lightgrey ">&nbsp;&nbsp;<input type="button" onclick="location.href='offerSearch.do'" value="검색" class="btn btn_danger"></td>
			</tr>
	</table>
	<table align="center">
		<tr>
			<td>
				<%
					if(wheregroup>1){
						%>
						<a href="offerPage.do?ogo=1">처음</a>
						<a href="offerPage.do?ogogroup=<%=priorgroup %>">이전&nbsp;</a>
						<%
					}else{
						%>
						처음&nbsp;이전&nbsp;
						<%
					}
				
				for(int jj = startpage; jj<=endpage; jj++){
					if(jj ==where){
					%>
					<strong><%=jj %></strong>
					<%
					}else{
					%>
					<a href="offerPage.do?go=<%=jj %>">&nbsp;<%=jj %>&nbsp;</a>
					<%	
					}
				}
				
				if(wheregroup< totalgroup){
					%>
					&nbsp;<a href="offerPage.do?ogogroup=<%=nextgroup %>">다음</a>
					<a href="offerPage.do?=ogogroup=<%=totalgroup %>">마지막</a>
					<%
					
				}else{
					%>
					&nbsp;다음&nbsp;마지막
					<%
				}
				%>
			</td>
		</tr>
	</table>
	</div>
</body>
</html>