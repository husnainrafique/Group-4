<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Add New Book - HandMeDowns</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/styles.css" />
</head>
<body>

<header class="text-center py-4">
    <h1>Add a New Book to ${provider.storeName}</h1>
    <a href="/books/provider/${provider.storeID}" class="btn btn-light btn-sm">⬅ Back to Books</a>
</header>

<section class="container my-5">
    <h2 class="text-center mb-4">Add Book</h2>

    <form action="/books/add/${provider.storeID}" method="post">
        <div class="form-group">
            <label for="book_name">Book Name</label>
            <input type="text" class="form-control" id="book_name" name="book_name" required />
        </div>

        <div class="form-group">
            <label for="ISBN">ISBN</label>
            <input type="text" class="form-control" id="ISBN" name="ISBN" required />
        </div>

        <div class="form-group">
            <label for="publisher">Publisher</label>
            <input type="text" class="form-control" id="publisher" name="publisher" required />
        </div>

        <div class="form-group">
            <label for="summary">Summary</label>
            <textarea class="form-control" id="summary" name="summary" rows="3" required></textarea>
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <input type="number" class="form-control" id="price" name="price" step="0.01" />
        </div>

        <div class="form-group">
            <label for="bookImageUrl">Book Image URL</label>
            <input type="text" class="form-control" id="bookImageUrl" name="bookImageUrl" />
        </div>

        <button type="submit" class="btn btn-success">Add Book</button>
    </form>
</section>

</body>
</html>
