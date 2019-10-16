<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
<link rel="stylesheet" href="main.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<title>YouSub LOG IN 페이지</title>
<link href="https://fonts.googleapis.com/css?family=Righteous&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Gothic+A1|Righteous&display=swap" rel="stylesheet">
<style type="text/css">
.logo{
text-align:center;
font-family:righteous,serif;
}
.kor{
font-family:"Gothic A1",serif;
}
table{
margin-left:auto;
margin-right:auto;
margin-top:auto;
margin-botton:auto;
text-align: center;
}
logocl{
padding-top:100px
}
a{
text-decoration:none;
}
</style>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript">

function check(){
	
	if(f.id.value==""){
		alert("아이디를 입력해주세요");
		f.id.focus();
		return false;
	}else if(f.pw.value==""){
		alert("비밀번호를 입력해주세요");
		f.pw.focus();
		return false;
	}else{
		return true;
	}
}


</script>
</head>
<body>
<br><br><br><br><br><br><br><br><br><br><br>
<form action="logIn.do" method=post name="f" onSubmit="return check()">
	<table >
		<tr class=logocl  >
			<th colspan=2 style="padding-left: 19%">			
				<a href="mainPage.do">
					<font class="logo" color="red" size="15px" >You</font>
					<font class="logo" color="black" size="15px">Sub</font>
				</a> 
			</th>
		</tr>
		<tr>
		<td><font class=logo >ID</font></td>
		<td><input type="text" name="id" id="id"></td>
		</tr>
		<tr>
		<td><font class=logo>PASSWORD</font></td>
		<td><input type="password" name="pw"></td>
		</tr>
		
		<tr>
			<td colspan=2 align="center" ><input type=submit value="LOG IN" class="btn btn-black" style="padding: 10px; padding-left:104px; padding-right: 104px; background-color:black; color:white;">
			</td>
		</tr>
		<tr>
		<td colspan="2" bgcolor="white" height="3px"></td>
		</tr>
		<tr>
			<td colspan=2><a href="joinPage.do" style="color:black; padding: 10px; padding-left:95px; padding-right: 95px; background-color:red; color:white;" class="btn" >회원가입</a></td>
		</tr>
		<tr>
			<td colspan=2></td>
		</tr>
	</table>
	
	
</form>
<table align="center"><tr><td>
	<a id="kakao-login-btn"></a>
<a href="http://developers.kakao.com/logout"></a>
<script type="text/javascript">
//<![CDATA[
//사용할 앱의 JavaScript 키를 설정해 주세요.
	Kakao.init('ec21d68c0494757474bc8fa4b1ff2ef8');
//카카오 로그인 버튼을 생성합니다.
	Kakao.Auth.createLoginButton({
		container: '#kakao-login-btn',
		success: function(authObj) {
		 alert(JSON.stringify(authObj));
		 },
		 fail: function(err) {
  		alert(JSON.stringify(err));
		 }
	});
//]]>

</script>
</td>
</tr>
</table>
</body>
</html>