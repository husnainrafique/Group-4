<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Provider Books - HandMeDowns</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/styles.css" />
</head>
<body>

<header class="text-center py-4">
    <h1>📚 ${provider.storeName}'s Books</h1>
    <a href="/providers/profile/${provider.storeID}" class="btn btn-light btn-sm">⬅ Back to Profile</a>
    <a href="/books/add/${provider.storeID}" class="btn btn-primary btn-sm">Add New Book</a>
</header>

<section class="container my-5">
    <h2 class="text-center mb-4">Books List</h2>

    <div class="book-card-wrapper">
        <#list books as book>
        <div class="book-card-item">
            <div class="book-card">
                <img src="${book.bookImageUrl}" class="card-img-top" alt="Book Image" />
                <div class="book-card-body">
                    <h5 class="book-card-title">${book.book_name}</h5>
                    <p class="book-card-text">Author: ${book.publisher}</p>
                    <p class="book-card-text">${book.summary}</p>
                    <p class="book-card-text">Price: $${book.price}</p>
                    <div class="book-card-btns">
                        <a href="/books/edit/${book.bookID}" class="btn btn-warning btn-sm book-card-btn">Edit</a>
                        <a href="/books/delete/${book.bookID}" class="btn btn-danger btn-sm book-card-btn">Delete</a>
                    </div>
                </div>
            </div>
        </div>
    </#list>
    </div>
</section>

</body>
</html>
