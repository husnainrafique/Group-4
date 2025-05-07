<#include "header.ftlh">

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/css/styles.css" />
    <title>Sign Up</title>
</head>
<body>
<h2>Create an Account</h2>
<form method="post" action="/signup">
    <label>Name:</label><br/>
    <input type="text" name="name"/><br/><br/>

    <label>Email:</label><br/>
    <input type="email" name="email"/><br/><br/>

    <label>Password:</label><br/>
    <input type="password" name="password"/><br/><br/>

    <button type="submit">Register</button>
</form>
</body>
</html>
