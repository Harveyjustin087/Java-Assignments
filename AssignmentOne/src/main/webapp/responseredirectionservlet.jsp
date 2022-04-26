<%--
  Created by IntelliJ IDEA.
  User: Justin
  Date: 2022-01-17
  Time: 6:16 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Response Direction Servlet</title>
    </head>
    <body>
    <form method="post" action="responseredirectionservlet">
        <p>Please indicate your favorite search engine.</p>
        <table>
            <tr>
                <td><input type="radio" name="searchEngine"
                           value="http://www.google.com">Google
                </td>
            </tr>
            <tr>
                <td><input type="radio" name="searchEngine"
                           value="http://www.bing.com">Bing
                </td>
            </tr>
            <tr>
                <td><input type="radio" name="searchEngine"
                           value="http://www.yahoo.com">Yahoo!
                </td>
            </tr>
            <tr>
                <td><input type="radio" name="searchEngine"
                           value="https://duckduckgo.com/?va=b&t=hc">DuckDuckGo
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form>
    </body>
</html>