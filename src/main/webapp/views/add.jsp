<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.TimeZone" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: Alesia
  Date: 18.07.2019
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page import="servlets.CreateEmployee" %>--%>
<html>
<head>
    <title>Add new employee</title>
</head>
<body>
<div>
    <%
        if (request.getAttribute("employee") != null) {
            out.println("<p>Employee__ <strong>'" + request.getAttribute("employee") + "'</strong> __added!</p>");
        }
    %>
    <div>
        <div>
            <h2>Add employee</h2>
        </div>
        ${errors}
        <form method="post">
            <label>Name:
                <input style="margin: 0 0 8px 75px" type="text" name="name">
            </label><br/>
            <label>Last name:
                <input style="margin: 0 0 8px 47px" type="text" name="lastName">
            </label><br/>
            <label>Date of birth:
                <span style="margin-left: 32px">
                    <select name="dd">
                       <% for (int i = 1; i <= 31; i++) {
                           out.println("<option>" + i + "</option>");
                       }%>
                    </select>

                    <select name="mm">
                        <option value="1">January</option>
                        <option value="2">February</option>
                        <option value="3">March</option>
                        <option value="4">April</option>
                        <option value="5">May</option>
                        <option value="6">June</option>
                        <option value="7">July</option>
                        <option value="8">August</option>
                        <option value="9">September</option>
                        <option value="10">October</option>
                        <option value="11">November</option>
                        <option value="12">December</option>
                    </select>
                    <select name="yyyy">
            <% Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
                calendar.setTime(new Date());
                int nowYear = calendar.get(Calendar.YEAR);
                for (int i = (nowYear - 16); i > (nowYear - 70); i--) {
                    out.println("<option>" + i + "</option>");
                }%>
                    </select>

                </span>

            </label><br/>
            <label>E-mail:
                <input style="margin: 8px 0 8px 70px" type="text" name="email">
            </label><br/>
            <button style="margin-top: 5px" type="submit">Save</button>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='/list'">Return to the list of employees</button>
</div>
</body>
</html>
