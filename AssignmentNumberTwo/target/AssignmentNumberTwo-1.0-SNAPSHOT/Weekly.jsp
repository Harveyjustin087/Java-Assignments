<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:useBean id="myWeek" class="javaee.weekbean.MyWeek"/>
    <head>
        <title>JSP - My Week</title>
    </head>
    <body align="center">
        <jsp:setProperty name="myWeek" property="name" value="Justin"/>
        <h1><jsp:getProperty name="myWeek" property="description"/>
        </h1>
        <p>There are of course <jsp:getProperty name="myWeek" property="numberDays"/> days in the week</p>
        <p><jsp:getProperty name="myWeek" property="name"/>
            works on
            <c:forEach var="weekDay" items="${myWeek.workingDays}">
                ${weekDay}
            </c:forEach>  leaving only
            ${myWeek.numberDays - myWeek.numberWorkingDays}
            days to enjoy other things in life.</p>
        <p>That means
            <jsp:getProperty name="myWeek" property="name"/> is working
            ${myWeek.numberWorkingDays/myWeek.numberDays * 100}% of the time
        </p>
        <p><c:if test="${myWeek.numberWorkingDays > (myWeek.numberDays - myWeek.numberWorkingDays)}">
            This is far from ideal :(
            </c:if>
        </p>
        <br/>
    </body>
</html>