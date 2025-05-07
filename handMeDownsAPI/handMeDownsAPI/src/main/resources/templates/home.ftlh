<#include "header.ftlh">

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="HandMeDowns" content="A website for buying/selling/trading books." />
    <p> 
        | <a href="admins/admin" class="trade-btn">Admin</a> 
        | <a href="providers/all" class="trade-btn">Providers</a></p>
    <title>HandMeDowns - Give Books a Second Life</title>
    <link rel="stylesheet" href="/css/pure-min.css" />
    <link rel="stylesheet" href="/css/styles.css" />
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>

<body>
<header class="header">
    <h1>HandMeDowns – Give Books a Second Life</h1>
    <h2>Welcome <#if name??>${name}</#if>!</h2>

    <p>
        <a href="/userBooks/trade"> <button class="trade-btn">Trade</button></a> 
        <a href="/userBooks/donate"> <button class="trade-btn">Donate</button></a> 
        <a href="/userBooks/sell"><button class="trade-btn">Buy</button></a>

    </p>
</header>

<section class="how-it-works">
    <h2>📌 How It Works?</h2>
    <div class="steps">
        <div class="step">
            <i class="fas fa-book-open"></i>
            <h3>List Your Books</h3>
            <p>Upload books you no longer need.</p>
        </div>
        <div class="step">
            <i class="fas fa-recycle"></i>
            <h3>Trade or Donate</h3>
            <p>Exchange books or donate them.</p>
        </div>
        <div class="step">
            <i class="fas fa-hand-holding-heart"></i>
            <h3>Sell & Give Back</h3>
            <p>Sell books & contribute to community initiatives.</p>
        </div>
    </div>
</section>

<section class="featured-listings">
    <h2>📚 Featured Listings</h2>
    <div class="books">
        <div class="book">
            <h3>Calculus 101</h3>
            <p>Available for Trade</p>
        </div>
        <div class="book">
            <h3>Introduction to Psychology</h3>
            <p>Donated, Grab Now!</p>
        </div>
        <div class="book">
            <h3>Data Science Essentials</h3>
            <p>For Sale ($10, 5% to charity!)</p>
        </div>
    </div>
    <a href="/userBooks"><button class="signup-btn">Browse More Books</button></a>
</section>

<section class="join-movement">
    <h2>📬 Join the Movement</h2>
    <p>Be part of a growing community that values learning and sustainability.</p>
    <a href="/signup"><button class="signup-btn">Sign Up & Start Trading</button></a>
</section>

</body>
</html>
