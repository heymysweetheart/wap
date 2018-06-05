<%@ page import="mum.cs472.Quiz" %><%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 6/3/18
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Quiz Result</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
  </head>
  <body>
    <p1>Quiz Result</p1>
    <p>Your final score is: <span>${requestScope.get("result")}</span></p>

    <p1>Click bellow to restart the test</p1>
    <p><a href="/newquiz">Get quizs</a></p>
  </body>
</html>
