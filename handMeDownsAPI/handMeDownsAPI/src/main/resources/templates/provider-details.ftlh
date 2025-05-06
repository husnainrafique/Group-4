<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Provider Details - HandMeDowns</title>

  <!-- Bootstrap 4 -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" crossorigin="anonymous" />

  <!-- Font Awesome -->
  <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous" async></script>

  <!-- Custom Styles -->
  <link rel="stylesheet" href="/css/styles.css" />
</head>

<body class="provider-body">
<header class="provider-header text-center py-4">
  <h1>🏬 Provider Details</h1>
  <a href="/providers/all" class="btn btn-light btn-sm mt-2">⬅ Back to Providers</a>
  <a href="/providers/stats/${provider.storeID}" class="btn btn-info btn-sm mt-2">📊 View Stats</a>
</header>

<section class="container mt-5">
  <h2 class="text-center mb-4">${title}</h2>

  <!-- Provider Card -->
  <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3">
    <div class="col mb-4 d-flex align-items-stretch">
      <div class="provider-card shadow-sm" style="width: 100%; min-height: 100%;">
        <img src="${provider.imageUrl}" class="card-img-top provider-image" alt="Provider Image" loading="lazy" />
        <div class="provider-card-body d-flex flex-column justify-content-between">
          <div>
            <h5 class="provider-card-title">${provider.storeName?c}</h5>
            <p class="provider-card-text"><strong>Owner:</strong> ${provider.contactFirstName} ${provider.contactLastName}</p>
            <p class="provider-card-text"><strong>Email:</strong> ${provider.email}</p>
            <p class="provider-card-text"><strong>Location:</strong> ${provider.city}, ${provider.state}</p>
            <p class="provider-card-text"><strong>Registered:</strong> ${provider.createdAt}</p>
            <p class="provider-card-text"><strong>Last Updated:</strong> ${provider.updatedAt}</p>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Inventory Section -->
  <h3 class="text-center mb-4 mt-5">📚 Inventory</h3>
  <div class="provider-inventory-wrapper">
    <#if provider.inventory?has_content>
    <#list provider.inventory as book>
    <div class="provider-inventory-item">
      <div class="card shadow-sm w-100">
        <#if book.bookImageUrl?has_content>
        <img src="${book.bookImageUrl}" class="card-img-top" alt="${book.book_name} Image" loading="lazy">
        <#else>
        <img src="https://via.placeholder.com/150" class="card-img-top" alt="Placeholder Image" loading="lazy">
      </#if>
      <div class="card-body d-flex flex-column">
        <div>
          <h5 class="card-title">${book.book_name}</h5>
          <p class="card-text"><strong>ISBN:</strong> ${book.ISBN}</p>
          <p class="card-text"><strong>Publisher:</strong> ${book.publisher}</p>
          <p class="card-text"><strong>Price:</strong> $${book.price}</p>
          <p class="card-text"><strong>Summary:</strong> ${book.summary}</p>
        </div>
        <a href="/books/view/${book.bookID}" class="btn btn-outline-primary btn-sm mt-auto mt-3">🔍 View Book</a>
      </div>
    </div>
  </div>
</#list>
<#else>
<p>No books found for this provider.</p>
</#if>
</div>

<!-- Reviews Section -->
<h3 class="text-center mb-4 mt-5">⭐ Reviews</h3>
<div class="provider-reviews-wrapper">
  <#if provider.reviews?has_content>
  <#list provider.reviews as review>
  <div class="provider-review">
    <h5 class="mb-1">"${review.content}"</h5>
    <p class="mb-1">Rating: ${review.rating}/5</p>
    <p class="mb-1"><strong>Status:</strong> ${review.status}</p>
    <p class="mb-1"><strong>Reply from ${provider.storeName}:</strong> ${review.reply!''}</p>
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
