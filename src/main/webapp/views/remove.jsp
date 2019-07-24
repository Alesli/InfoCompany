<%--
  Created by IntelliJ IDEA.
  User: Alesia
  Date: 20.07.2019
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete employee</title>
</head>
<body>
<div>
    <div>
        <h2>Delete employee</h2>
    </div>

    <div>
        <form method="post">
            <label>Number employee:
                <input type="number" name="employeeId"><br/>
            </label>

            <button style="margin-top: 10px" type="submit">Delete</button>
        </form>
    </div>
    <%--<%--%>
    <%--if (request.getAttribute("employeeId") == null) {--%>
    <%--out.println("<p>Employee remove!</p>");--%>
    <%--} else {out.println("<p>Employee don`t remove!</p>");}--%>
    <%--%>--%>
</div>
<div>
    <button onclick="location.href='/list'">Return to the list of employees</button>
</div>
</body>
</html>
