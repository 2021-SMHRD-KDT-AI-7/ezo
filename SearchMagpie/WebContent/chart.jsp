<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="Model.chartDTO"%>
<%@ page import="Model.chartDAO"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<%
	ArrayList<chartDTO> chartList = new ArrayList<>();
chartDAO dao = new chartDAO();
chartList = dao.allViewCountTopTen();
%>
<style>

.container{
	background-color:	#778899	;
	margin: auto;
	border-radius: 30px;
}

.neon {
	color: #fff;
	text-shadow: 0 0 7px #fff, 0 0 10px #fff, 0 0 21px #fff, 0 0 42px #0fa,
		0 0 82px #0fa, 0 0 92px #0fa, 0 0 102px #0fa, 0 0 151px #0fa;
	animation: flicker 1.5s infinite alternate;
	color: #fff;
}
a{
	color:white;

}
p{
	margin:0px;
	padding-left:15px;
}
h3{
	margin:0px;
	padding-left:20px;
}
body{
	width:auto;
	height:auto;
	margin:auto;
	padding:auto;
	content:auto;

}
@
keyframes flicker { 0%, 18%, 22%, 25%, 53%, 57%, 100% {
	text-shadow: 0 0 4px #fff, 0 0 11px #fff, 0 0 19px #fff, 0 0 40px #0fa,
		0 0 80px #0fa, 0 0 90px #0fa, 0 0 100px #0fa, 0 0 150px #0fa;
}
20
%
,
24
%
,
55
%
{
text-shadow
:
none;
}
}
@keyframes flicker {
    
  0%, 18%, 22%, 25%, 53%, 57%, 100% {

      text-shadow:
      0 0 4px #fff,
      0 0 11px #fff,
      0 0 19px #fff,
      0 0 40px #0fa,
      0 0 80px #0fa,
      0 0 90px #0fa,
      0 0 100px #0fa,
      0 0 150px #0fa;
  
  }
  
  20%, 24%, 55%, 70% {        
      text-shadow: none;
  }    
}
.neon_list0{
font-weight:bold;
  color: #FFFF00;
  text-shadow: 0 0 7px #FFFF00, 0 0 10px #FFFF00, 0 0 21px #FFFF00, 0 0 42px #0fa,
    0 0 82px #0fa, 0 0 92px #0fa, 0 0 102px #0fa, 0 0 151px #0fa;
	
	  animation: flicker 1.5s infinite alternate;
  color: #FFFF00;
  	@keyframes flicker {
    
  0%, 18%, 22%, 25%, 53%, 57%, 100% {

      text-shadow:
      0 0 4px #FFFF00,
      0 0 11px #FFFF00,
      0 0 19px #FFFF00,
      0 0 40px #0fa,
      0 0 80px #0fa,
      0 0 90px #0fa,
      0 0 100px #0fa,
      0 0 150px #0fa;
  
  }
  
  20%, 24%, 55%, 75% {        
      text-shadow: none;
  }    
}
}


.neon_list1{
font-weight:bold;
  color: 	#FF7F50;
  text-shadow: 0 0 7px 	#FF7F50, 0 0 10px #FF7F50, 0 0 21px #FF7F50, 0 0 42px #0fa,
    0 0 82px #0fa, 0 0 92px #0fa, 0 0 102px #0fa, 0 0 151px #0fa;
	
	  animation: flicker 1.5s infinite alternate;
  color: #FF7F50;
  	@keyframes flicker {
    
  0%, 18%, 22%, 25%, 53%, 57%, 100% {

      text-shadow:
      0 0 4px #FF7F50,
      0 0 11px #FF7F50,
      0 0 19px #FF7F50,
      0 0 40px #0fa,
      0 0 80px #0fa,
      0 0 90px #0fa,
      0 0 100px #0fa,
      0 0 150px #0fa;
  
  }
  
  20%, 24%, 55%, 75% {        
      text-shadow: none;
  }    
}
}

.neon_list2{
font-weight:bold;
  color: 		#FF8C00;
  text-shadow: 0 0 7px 	#FF8C00, 0 0 10px #FF8C00, 0 0 21px #FF8C00, 0 0 42px #0fa,
    0 0 82px #0fa, 0 0 92px #0fa, 0 0 102px #0fa, 0 0 151px #0fa;
	
	  animation: flicker 1.5s infinite alternate;
  color: #FF8C00;
  	@keyframes flicker {
    
  0%, 18%, 22%, 25%, 53%, 57%, 100% {

      text-shadow:
      0 0 4px #FF8C00,
      0 0 11px #FF8C00,
      0 0 19px #FF8C00,
      0 0 40px #0fa,
      0 0 80px #0fa,
      0 0 90px #0fa,
      0 0 100px #0fa,
      0 0 150px #0fa;
  
  }
  
  20%, 24%, 55%, 75% {        
      text-shadow: none;
  }    
}
}




</style>
</head>
<body>
	<div class="container">
		<h3 class="neon">핫 차트 10위</h3>
		<%
			for (int i = 0; i < chartList.size(); i++) {
		%>
		<p>
			<a target='_blank' class="neon_list<%=i%>" href="<%=chartList.get(i).getP_url()%>"><%=i + 1%>.<%=chartList.get(i).getP_title()%></a>
		</p>
		<%
			}
		%>
	</div>
</body>
</html>