<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="main.css">
<title>Insert title here</title>
</head>
<body>
		<div>
			<div class="logo">
			<a href="mainPage.do">
				<font class="logoft" color="red" size="150" style="padding-left: 80px;">You</font>
				<font class="logoft" color="black" size="150">Sub</font>		
			</a>
			
			</div>
			<div class="logo_center">
			</div>
	<%
		if(session.getAttribute("id")!= null){
			String userId = session.getAttribute("id").toString();
	%>
			<div class=logo_right>
				<font class="logoft" size="5px">
					<a href="memberInfo.do" class=""><%=userId %></a>&nbsp;
					<a href="logout.do" style="padding-right: 80px;"><font color="red">Log Out</font></a>
				</font>
			</div>
	<%
		}else{
	%>
			<div class=logo_right>
				<font class="logoft" size="5px">
					<a href="loginPage.do">Log In</a>&nbsp;
					<a href="joinPage.do" style="padding-right: 80px;"><font color="Red">Sign</font></a>
				</font>
			</div>
	<%
		}
		
	
		
	%>
			
		</div>
	<br><br><br><br>
	
</body>
</html>