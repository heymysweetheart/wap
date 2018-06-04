<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 6/3/18
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Quiz Page</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
  </head>
  <body>
    <h1>The Number Quiz</h1>
    <h1>Quiz number ${sessionScope.get("index") + 1}</h1>
    <form action="/quiz" method="post">
      <p>Your current score is: ${sessionScope.get("result")}.</p>
      <p>Guess the next number in the sequence.</p>
      <p>${sessionScope.get("question")}</p>
      <br>
      <label>Your answer:</label>
      <input type="text" name="answer">
      <br>
      <input type="submit" value="Submit" />
    </form>
  </body>
</html>
