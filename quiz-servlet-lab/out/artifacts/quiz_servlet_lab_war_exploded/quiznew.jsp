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
    <title>Number Quiz (JSP Edition) by Yuliang Jin.</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
  </head>
  <body>
    <h1>The Number Quiz</h1>
    <h1>Quiz number ${sessionScope.get("index") + 1}</h1>
    <form action="/newquiz" method="post">
      <p>Your current score is: ${sessionScope.get("result")}.</p>
        <p>Attempt ${sessionScope.get("currentAttempt")} / 3</p>
      <p>Guess the next number in the sequence.</p>
      <p>[${sessionScope.get("question")}, <span>?</span>]</p>
      <br>
      <label>Your answer:</label>
      <input type="text" name="answer" value="${sessionScope.get("correctAnswer")}">
      <br>
      <%--two submit buttons--%>
      <input type="submit" value="next" formaction="/newquiz"/>
      <input type="submit" value="Restart!" formaction="/newquiz" formmethod="get"/>
    </form>

      <p>${sessionScope.get("errorMsg")}</p>
      <br>
      <input type="submit" value="next" />
  </body>
</html>
