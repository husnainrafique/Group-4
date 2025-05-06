<!-- header.ftlh -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HandMeDowns</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <header class="header">
<div class="header-bar">
    <nav>
        <#if loggedInUser??>
            <span>Welcome, ${loggedInUser.name!}!</span>
            | <a href="/home">Home</a>
            | <a href="/requests">Requests</a>
            | <a href="/userBooks">Books</a>
            | <a href="/userBooks/add">Add Book</a>
            | <a href="/userBooks/sell">Buy</a>
            | <a href="/userBooks/donate">Donate</a>
            | <a href="/userBooks/trade">Trade</a>
            | <a href="/logout">Logout</a>
        <#else>
            <a href="/home">Home</a>
            | <a href="/requests">Requests</a>
            | <a href="/userBooks">Books</a>
            | <a href="/userBooks/add">Add Book</a>
            | <a href="/userBooks/sell">Buy</a>
            | <a href="/userBooks/donate">Donate</a>
            | <a href="/userBooks/trade">Trade</a>
            | <a href="/login">Login</a>
            | <a href="/signup">Sign Up</a>
        </#if>
    </nav>
</div>
