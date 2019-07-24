<%--Created by IntelliJ IDEA.
User: Alesia
Date: 14.07.2019
Time: 18:23
To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Employee" %>
<%@ page import="java.text.SimpleDateFormat" %>
<html>
<head>
    <title>Employees list</title>
</head>
<body>

<div>
    <div>
        <table border="1" cellpadding="5" cellspacing="0"
               style="margin-bottom: 10px;
               width: 600px;
               text-align: center">
            <thead>
            <caption><h2>Employees</h2></caption>
            </thead>

            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Last name</th>
                <th>Date of birth</th>
                <th>E-mail</th>
            </tr>
            <tbody>
            <%
                SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
                List<Employee> employeeList = (List<Employee>) request.getAttribute("employees");

                if (employeeList != null && !employeeList.isEmpty()) {
                    for (Employee employee : employeeList) {
                        out.println("<tr>");
                        out.println("<td>" + employee.getId() + "</td>");
                        out.println("<td>" + employee.getName() + "</td>");
                        out.println("<td>" + employee.getLastName() + "</td>");
                        out.println("<td>" + formatter.format(employee.getDateOfBirth()) + "</td>");
                        out.println("<td>" + employee.getEmail() + "</td>");
                        out.println("</tr>");
                    }
                } else out.println("<p>There are no employees yet!</p>");
            %>
            </tbody>
        </table>
    </div>
</div>

<div style="margin-top: 15px">
    <button onclick="location.href='/add'" style="background-color: darkgreen; color: #fff; border-color: darkgreen">Add employee</button>
    <button onclick="location.href='/remove'" style="background-color: darkred; color: #fff; border-color: darkred">Delete employee</button>
</div>
<div style="margin-top: 10px">
    <button onclick="location.href='/'">Return to home page</button>
</div>
</body>
</html>
