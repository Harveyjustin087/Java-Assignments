<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Hello World</title>
    </head>
    <body style="position:absolute;border: 2px solid black">
        <h1>Account Service</h1>
        <br/>
        <form action="<%=request.getContextPath()%>/account" method="post">
            <p>Select your choice: </p>
            <div>
                <input type="radio" name="select" value="deposit">Deposit<br/>
                <input type="radio" name="select" value="withdraw">Withdraw<br/>
            </div>
            <p>Enter Amount: </p> <input type="number" min="0.01" step="0.01" name="amount" value="0"><br/>
            <button type="submit" value="Submit">Submit</button>
            <button type="reset" value="Reset">Reset</button>
        </form>
        <p>The Balance is: </p><p>$ ${Final}</p>
        <p>${Message}</p>
    </body>
</html>