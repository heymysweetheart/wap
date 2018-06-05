<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 6/5/18
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.PrintWriter" %>
<html>
<head>
    <title>Beer Display</title>
</head>
<body>
    <h1 align="center">Beer selection result</h1>
    <%
        List brands = (List)request.getAttribute("brands");
        Iterator iterator = brands.iterator();
        PrintWriter writer = response.getWriter();
        writer.print("<h1 align=\"center\">Beer selection result</h1>");
        while (iterator.hasNext()) {
            writer.print("<br>try: " + iterator.next());
        }
    %>
</body>
</html>
