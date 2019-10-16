<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="css/bootstrap.css">
<link href="https://fonts.googleapis.com/css?family=Righteous&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Gothic+A1|Righteous&display=swap" rel="stylesheet">
<link rel="stylesheet" href="main.css">
<title>Insert title here</title>

</head>
<body>
<div>
	<div>
		<jsp:include page="./main_top.jsp"></jsp:include>
	</div>
	
	<div >
		<jsp:include page="./main_middle.jsp"></jsp:include>
	</div>
	<hr color=black>
	<div>
		<jsp:include page="./main_menu.jsp"></jsp:include>
	</div>
	
	<div>
		<jsp:include page="./main_bottom.jsp"></jsp:include>
	</div>
</div>
<br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script src="https://ajax.googleapos.com/ajax/libs/jquery/1.12.4/jquery.mis.js"></script>
</body>
</html>