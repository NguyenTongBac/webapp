<%--
  Created by IntelliJ IDEA.
  User: tongb
  Date: 6/26/2021
  Time: 1:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/view/css/Style.css">
    <script src="view/js/loginJQuery.js"></script>
    <script src="https://kit.fontawesome.com/4cc9ecdf2a.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="login-page">
    <div class="form">
        <form class="login-form" action="create" method="post">
            <input type="text" placeholder="Title note" name="tileNote"/>
            <input type="text" placeholder="Note" name="note"/>
            <button type="submit">Save change</button>

        </form>
        <form action="login" method="get">
        <button type="submit" data-target="#close">Close</button>
        </form>
    </div>
</div>
</body>
</html>
