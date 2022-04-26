<%--
  Created by IntelliJ IDEA.
  User: Justin
  Date: 2022-02-09
  Time: 3:06 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="mainForm">
    <div align="center">
        <h1>Login Form</h1>
        <form action="<%=request.getContextPath()%>/EmployeeController" method="post">
            <table style="with: 100%">
                <tr>
                    <td>UserName</td>
                    <td><input type="text" name="userName" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" /></td>
                    <td><input type="hidden" name="pageName" value="login"></td>
                </tr>
                <p><i>${message}</i></p>
            </table>
            <input type="submit" value="Submit" />
        </form>
        <a href="signup.jsp">Back To Sign Up</a>
    </div>
</div>
</body>
</html>
