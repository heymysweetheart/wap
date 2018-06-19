<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 6/18/18
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Online Dictionary</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
    <link href="css/dict.css" type="text/css" rel="stylesheet" />
    <script src="js/dict.js" type="text/javascript"></script>
  </head>
  <body>
    <h1>Online Dictionary</h1>

    <div class="dict-container">
        <p2>Term: </p2>
        <input id="word-input" type="text" placeholder="Online Dictionary">
        <button id="lookup" type="button" value="Lookup">Lookup</button>
    </div>
    <div id="dict-main">
        <h2 id="dict-word"><span></span></h2>
        <ul id="result-list"></ul>
    </div>
    <hr>

    <div id="w3c">
        <a href="https://webster.cs.washington.edu/validate-html.php">
            <img src="https://webster.cs.washington.edu/w3c-html.png" alt="Valid HTML" /></a>
        <a href="https://webster.cs.washington.edu/validate-css.php">
            <img src="https://webster.cs.washington.edu/w3c-css.png" alt="Valid CSS" /></a>
        <a href="https://webster.cs.washington.edu/jslint/?referer">
            <img src="https://webster.cs.washington.edu/w3c-js.png" alt="Valid JS" /></a>
    </div>
  </body>
</html>
