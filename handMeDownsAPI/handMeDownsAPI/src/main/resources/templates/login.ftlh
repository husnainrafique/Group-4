<#include "header.ftlh">
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/css/styles.css" />
    <title>Login</title>
</head>

<body>
<h2>Login</h2>

<#if error??>
<p style="color: red;">${error}</p>
</#if>


<form action="/login" method="post">
    Email: <input type="email" name="email"><br/>
    Password: <input type="password" name="password"><br/>
    <button type="submit">Login</button>
</form>
</body>
</html>

