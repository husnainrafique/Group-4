<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Book - HandMeDowns</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/styles.css" />
</head>
<body>

<header class="text-center py-4">
    <h1>Edit Book: ${book.book_name}</h1>
    <a href="/books/provider/${book.provider.storeID}" class="btn btn-light btn-sm">⬅ Back to Books</a>
</header>

<section class="container my-5">
    <form action="/books/edit/${book.bookID}" method="post">
        <div class="form-group">
            <label for="book_name">Book Name</label>
            <input type="text" class="form-control" id="book_name" name="book_name" value="${book.book_name}" required>
        </div>

        <div class="form-group">
            <label for="ISBN">ISBN</label>
            <input type="text" class="form-control" id="ISBN" name="ISBN" value="${book.ISBN}" required>
        </div>

        <div class="form-group">
            <label for="publisher">Publisher</label>
            <input type="text" class="form-control" id="publisher" name="publisher" value="${book.publisher}" required>
        </div>

        <div class="form-group">
            <label for="summary">Summary</label>
            <textarea class="form-control" id="summary" name="summary" rows="3" required>${book.summary}</textarea>
        </div>

        <div class="form-group">
            <label for="price">Price ($)</label>
            <input type="number" class="form-control" id="price" name="price" step="0.01" value="${book.price}">
        </div>

        <div class="form-group">
            <label for="bookImageUrl">Book Image URL</label>
            <input type="text" class="form-control" id="bookImageUrl" name="bookImageUrl" value="${book.bookImageUrl}">
        </div>

        <input type="hidden" name="provider.storeID" value="${book.provider.storeID}">

        <div class="d-flex justify-content-between mt-4">
            <button type="submit" class="btn btn-warning">Update Book</button>

            <a href="/books/delete/${book.bookID?c}" class="btn btn-danger">Delete Book</a>
            </a>
        </div>
    </form>
</section>

</body>
</html>
