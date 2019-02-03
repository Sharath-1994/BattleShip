<%@page import="java.util.List"%>
<%@page import="javax.servlet.jsp.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">Battle results are :</h1>


<h2>
	<%
		List<String> player = (List<String>) request.getAttribute("listOfAttackMessages");

		for (String s : player) {
	%>
	<%
		out.println(s);
	%>
	<br>
	<%
		}
	%>
</h2>

</body>
</html>