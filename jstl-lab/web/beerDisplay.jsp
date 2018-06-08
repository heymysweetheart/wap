<%-- 
    Document   : beerDisplay
    Created on : Jun 6, 2018, 11:54:45 AM
    Author     : 986381
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/mytag" prefix="mytag" %>
<!DOCTYPE html>
<html>
<head>
    <title>Beer Display</title>
</head>
<body>
    <%-- 
    <%
        List brands = (List)request.getAttribute("brands");
        Iterator iterator = brands.iterator();
        PrintWriter writer = response.getWriter();
        writer.print("<h1 align=\"center\">Beer selection result</h1>");
        while (iterator.hasNext()) {
            writer.print("<br>try: " + iterator.next());
        }
    %>
    --%>
   
             
    <c:forEach var = "brand" items="${brands}">
        Try: <c:out value = "${brand}"/><br>
    </c:forEach>
        
        <mytag:Head thecolor="red" words="Hello">
        </mytag:Head>

</body>
</html>
