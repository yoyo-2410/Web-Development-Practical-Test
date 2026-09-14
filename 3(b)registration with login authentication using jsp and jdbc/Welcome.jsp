<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%
    String user = (String) session.getAttribute("username");

    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<html>

<head>
    <title>Welcome</title>
</head>

<body>

    <h2>Welcome, <%= user %>!</h2>

    <a href="register.jsp">Home</a>

</body>

</html>
