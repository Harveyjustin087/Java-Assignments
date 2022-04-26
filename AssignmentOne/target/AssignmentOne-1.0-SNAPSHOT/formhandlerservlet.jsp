<%--
  Created by IntelliJ IDEA.
  User: Justin
  Date: 2022-01-17
  Time: 6:07 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Hello World</title>
    </head>
    <body>
        <form method="post" action="formhandlerservlet">
            <table>
                <tr>
                    <td>Please enter some text:</td>
                    <td>
                        <input type="text" name="enteredValue"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit"></td>
                </tr>
            </table>
        </form>
    </body>
</html>