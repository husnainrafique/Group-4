<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>${book.book_name} - Book Details</title>

    <!-- Bootstrap 4 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" crossorigin="anonymous" />
    <link rel="stylesheet" href="/css/styles.css" />
</head>

<body class="book-body">
<header class="header text-center py-4">
    <h1>📖 Book Details</h1>
    <div class="d-flex justify-content-center flex-wrap gap-2 mt-2">
        <a href="/providers/${provider.storeID}" class="btn btn-light btn-sm mx-1">⬅ Back to Provider</a>
        <a href="/providers/all" class="btn btn-outline-secondary btn-sm mx-1">🏪 All Providers</a>
    </div>

</header>

<section class="container my-5">
    <div class="row">
        <div class="col-md-5">
            <#if book.bookImageUrl?has_content>
            <img src="${book.bookImageUrl}" class="img-fluid rounded shadow-sm" alt="${book.book_name} Image"/>
            <#else>
            <img src="https://via.placeholder.com/300x400" class="img-fluid rounded shadow-sm" alt="Placeholder Image"/>
        </#if>
    </div>

    <div class="col-md-7">
        <h2>${book.book_name}</h2>
        <p><strong>ISBN:</strong> ${book.ISBN}</p>
        <p><strong>Publisher:</strong> ${book.publisher}</p>
        <p><strong>Price:</strong> $${book.price}</p>
        <p><strong>Summary:</strong> ${book.summary}</p>

        <hr/>
        <h5>📍 Provided By</h5>
        <p>
            <strong>${provider.storeName}</strong><br/>
            ${provider.city}, ${provider.state}<br/>
            Contact: ${provider.email}
        </p>
    </div>
    </div>
</section>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>
