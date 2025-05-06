<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>All Providers - HandMeDowns</title>

  <!-- Bootstrap 4 -->
  <link
          rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          crossorigin="anonymous"
  />


  <!-- Custom Styles -->
  <link rel="stylesheet" href="/css/styles.css" />
</head>

<body class="provider-body">
<header class="header text-center py-4">
  <h1>📚 Our Providers</h1>
  <nav class="d-flex justify-content-center flex-wrap mt-3">
    <a href="/home" class="btn btn-light btn-sm mx-2 my-1">⬅ Home</a>
    <a href="/providers/register" class="btn btn-outline-success btn-sm mx-2 my-1">📝 Register</a>
    <a href="/providers/login" class="btn btn-outline-dark btn-sm mx-2 my-1">🔐 Login</a>
  </nav>
</header>

<section class="container my-5">
  <div class="provider-card-wrapper">
    <#list providerList as provider>
    <div class="provider-card-item">
      <div class="provider-card">
        <img src="${provider.imageUrl}" class="card-img-top provider-image" alt="Provider Image" />
        <div class="provider-card-body">
          <h5 class="provider-card-title">${provider.storeName?c}</h5>
          <p class="provider-card-text"><strong>Owner:</strong> ${provider.contactFirstName} ${provider.contactLastName}</p>
          <p class="provider-card-text"><strong>Email:</strong> ${provider.email}</p>
          <p class="provider-card-text"><strong>Location:</strong> ${provider.city}, ${provider.state}</p>
          <p class="provider-card-text"><strong>Registered:</strong> ${provider.createdAt}</p>
          <p class="provider-card-text"><strong>Last Updated:</strong> ${provider.updatedAt}</p>
          <a href="/providers/${provider.storeID}" class="btn btn-outline-primary btn-sm provider-card-btn">
            🔍 View Details
          </a>
        </div>
      </div>
    </div>
  </#list>
  </div>
</section>
</body>
</html>
