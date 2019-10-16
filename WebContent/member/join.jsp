<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="main.css">
<meta charset="EUC-KR">
<link href="https://fonts.googleapis.com/css?family=Righteous&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Gothic+A1|Righteous&display=swap" rel="stylesheet">
<style type="text/css">
.logo{

font-family:righteous,serif;
}
.kor{
font-family:"Gothic A1",serif;
text-decoration:none;
}
table{
margin-left:auto;
margin-right:auto;
margin-top:auto;

margin-botton:auto;

}
a{
text-decoration:none;
}
tr td button.sign{

	border:1px solid black;
	background:#333333;
	border-radius: 5px;
	color:white;
	padding:3px 8px;

}
tr td input.check{

	border:1px solid black;
	background:#333333;
	border-radius: 5px;
	color:white;
	padding:3px 8px;

}
tr td button.cancle{

	border:1px solid red;
	background:red;
	border-radius: 5px;
	color:white;
	padding:3px 8px;

}
input{
border:none;
text-align:center;
}
</style>
<script type="text/javascript">
function check(){
	
	var pw1 = document.getElementById("pw").value;
	var pw2 = document.getElementById("pw2").value;
	
	if(f.id.value==""){
		alert("아이디를 입력해주세요");
		f.id.focus();
		return false;
	}else if(f.pw.value==""){
		alert("비밀번호를 입력해주세요");
		f.pw.focus();
		return false;
	}else if(pw2==""){
		alert("확인 비밀번호를 입력해주세요")
		f.pw2.focus();
		return false;
	}else if(pw2 != pw1){
		alert("동일한 비밀번호를 입력해 주세요")
		f.pw2.focus();
		return false;
	}else if(f.nick.value==""){
		alert("닉네임을 입력해주세요")
		f.nick.focus();
		return false;
	}else if(f.name.value==""){
		alert("이름을 입력해주세요");
		f.name.focus();
		return false;
	}else if(f.email.value==""){
		alert("이메일을 입력해주세요");
		f.email.focus();
		return false;
	}else if(f.hint.value==""){
		alert("비밀번호를 찾을시 이용되는 힌트를 입력해주세요");
		f.hint.focus();
		return false;
	}else{
		return true;
	}
	
	
}


function idCheck(input){
	
	var url ="member/idCheck.jsp?id="+input.id.value;
	window.open(url,"chkForm","width=500, height=300, resizable = no,scrollbar =no");
}

function pwCheck(){
	
	if(f.pw.value == f.pw2.value){
		document.getElementById("pw2_text").innerHTML = "";
	}else{
		document.getElementById("pw2_text").innerHTML = "<p><font color='black'>비밀번호가 일치하지 않습니다</font><p>"
		
	}
}
</script>
<title>회원가입</title>
</head>
<body>
<br><br><br><br><br><br><br>
<form name ="f" action="join.do" method="post" onSubmit="return check()">
<table>
 <tr>
 <th colspan=2 style="padding-left:130px;">
 <a href="mainPage.do">
 	<font class="logo" color="red" size="32pt">You</font>
			<font class="logo" color="black" size="32pt">Sub</font>
 </a>
 </th>
 </tr>
 <tr> 
 <td><font class=logo>Member ID</font></td>
 <td>:<input type=text name="id" placeholder="아이디를 입력해주세요." size=30></td>
 <td><input type="button" value="ID중복검사" onClick="idCheck(this.form)" class="check">
 <input type=hidden name="idChecked" value="idUncheck"></td>
 </tr>
 <tr>
 <td><font class=logo>PASSWORD</font></td>
 <td colspan=2>:<input type="password" name="pw" placeholder="비밀번호를 입력해주세요." size=30 id="pw" ></td>
 </tr>
 <tr>
 <td><font class=logo>PW CHECK</font></td>
 <td>:<input type="password" name="pw2" placeholder="비밀번호를 한번더 입력해주세요." size=30 id="pw2" onchange="pwCheck()"></td>
 
 </tr>
 
 <tr>
 	<td><font class="logo">NickName</font></td>
 	<td>:<input type="text" name="nick" placeholder="별명을 입력해주세요." size=30></td>
 </tr>
 <tr>
 	<td><font class="logo">Name</font></td>
 	<td>:<input type="text" name="name" placeholder="이름을 입력해주세요." size=30></td>
 </tr>

 <tr>
 <td><font class="logo">E-Mail</font></td>
 <td>:<input type="email" name="email" placeholder="이메일을 입력해주세요." size=30 ></td>
 </tr>
 <tr> 
	<td class="logo">PW Hint</td>
	<td>:<input type="text" name="pwhint" placeholder="본인만 아는 힌트를 입력해주세요." size=30></td>
</tr>
 <tr>
 <td id="pw2_text" colspan="3" align="center" style="background-color:rgba(255,0,0,0.7);"></td>
 </tr>

 <tr>

 <td align="center">
 </td>
 <td align="center">
 <button type="submit" class="sign">회원가입</button>
 <button type="button" class="cancle"><a href="loginPage.do" style="text-decoration: none; color:black">취 소</a></button>
 </td>
 </tr>
 <p id="ptag"></p>

</table>
</form>
</body>
</html>