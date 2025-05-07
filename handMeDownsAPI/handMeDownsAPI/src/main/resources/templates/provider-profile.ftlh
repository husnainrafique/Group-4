<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Provider Profile - HandMeDowns</title>

    <!-- Bootstrap 4 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" crossorigin="anonymous" />

    <!-- Font Awesome -->
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous" async></script>

    <!-- Custom Styles -->
    <link rel="stylesheet" href="/css/styles.css" />
</head>
<body class="provider-body">

<header class="provider-profile-header text-center py-4">
    <h1>🏬 Provider Profile</h1>
    <div class="provider-btn-group">
        <a href="/providers/all" class="btn btn-light btn-sm">⬅ Back to Providers</a>
        <a href="/providers/edit/${provider.storeID}" class="btn btn-outline-warning btn-sm">✏️ Edit Profile</a>
        <a href="/providers/logout" class="btn btn-outline-danger btn-sm">🚪 Logout</a>
    </div>
    <a href="/providers/stats/${provider.storeID}" class="btn btn-info btn-sm mt-2">📊 View Visit Stats</a>
</header>

<section class="container mt-5">
    <h2 class="text-center">${provider.storeName}</h2>

    <!-- Provider Card -->
    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3">
        <div class="col mb-4 d-flex align-items-stretch">
            <div class="card provider-card">
                <img src="${provider.imageUrl}" class="card-img-top provider-card-img" alt="Provider Image" loading="lazy" />
                <div class="card-body provider-card-body">
                    <h5 class="card-title">${provider.storeName}</h5>
                    <p class="card-text"><strong>Owner:</strong> ${provider.contactFirstName} ${provider.contactLastName}</p>
                    <p class="card-text"><strong>Email:</strong> ${provider.email}</p>
                    <p class="card-text"><strong>Location:</strong> ${provider.city}, ${provider.state}</p>
                    <p class="card-text"><strong>Registered:</strong> ${provider.createdAt}</p>
                    <p class="card-text"><strong>Last Updated:</strong> ${provider.updatedAt}</p>
                </div>
            </div>
        </div>
    </div>

    <!-- Inventory Section -->
    <a href="/books/add/${provider.storeID}" class="btn provider-inventory-btn mb-3">➕ Add New Book</a>
    <h3 class="mb-4 mt-5">📚 Inventory</h3>
    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3">
        <#if provider.inventory?has_content>
        <#list provider.inventory as book>
        <div class="col mb-4">
            <div class="card provider-inventory-card shadow-sm h-100">
                <#if book.bookImageUrl?has_content>
                <img src="${book.bookImageUrl}" class="card-img-top" alt="${book.book_name} Image" loading="lazy">
                <#else>
                <img src="https://via.placeholder.com/150" class="card-img-top" alt="Placeholder Image" loading="lazy">
            </#if>
            <div class="card-body">
                <h5 class="card-title">${book.book_name}</h5>
                <p class="card-text"><strong>ISBN:</strong> ${book.ISBN}</p>
                <p class="card-text"><strong>Publisher:</strong> ${book.publisher}</p>
                <p class="card-text"><strong>Price:</strong> $${book.price}</p>
                <p class="card-text"><strong>Summary:</strong> ${book.summary}</p>
                <a href="/books/edit/${book.bookID}" class="btn provider-inventory-btn btn-sm btn-outline-primary">✏️ Edit</a>
            </div>
        </div>
    </div>
</#list>
<#else>
<p>No books found for this provider.</p>
</#if>
</div>

<!-- Reviews Section -->
<h3 class="mb-4 mt-5">⭐ Reviews</h3>
<div class="list-group">
    <#if provider.reviews?has_content>
    <#list provider.reviews as review>
    <div class="list-group-item">
        <h5 class="mb-1">"${review.content}"</h5>
        <p class="mb-1">Rating: ${review.rating}/5</p>
        <p class="mb-1"><strong>Status:</strong> ${review.status}</p>
        <p class="mb-1"><strong>Reply from Provider:</strong> ${review.reply!''}</p>

        <#-- Form for replying to the review if no reply exists -->
        <#if userIsProvider?? && !review.reply?has_content>
        <form action="/provider-reviews/reply/${review.reviewID}" method="POST" class="provider-reply-form">
            <textarea name="reply" class="form-control provider-reply-textarea" rows="3" placeholder="Write your reply here..."></textarea>
            <button type="submit" class="btn provider-reply-btn mt-2">Submit Reply</button>
        </form>
    </#if>

    <small>— Reviewed by User ID ${review.authorID} on ${review.createdAt?string("yyyy-MM-dd HH:mm")}</small>
</div>
</#list>
<#else>
<p>No reviews found for this provider.</p>
</#if>
</div>
</section>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous" defer></script>
</body>
</html>
