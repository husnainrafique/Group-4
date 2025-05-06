<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Update Provider - HandMeDowns</title>

  <!-- Bootstrap -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" crossorigin="anonymous" />
  <link rel="stylesheet" href="/css/styles.css" />
</head>

<body class="provider-body">

<header class="provider-update-header text-center py-4">
  <h1>✏️ Update Your Provider Profile</h1>
  <a href="/providers/profile/${provider.storeID}" class="btn btn-light btn-sm">⬅ Back to Profile</a>
</header>

<section class="provider-update-wrapper">
  <h2 class="text-center mb-4">Edit Your Store Information</h2>

  <form action="/providers/edit/${provider.storeID}" method="post" class="provider-form needs-validation" novalidate>
    <div class="form-row">
      <!-- Store Name -->
      <div class="form-group col-md-6">
        <label for="storeName">Store Name</label>
        <input type="text" id="storeName" name="storeName" class="form-control" value="${provider.storeName}" required />
      </div>

      <!-- Email -->
      <div class="form-group col-md-6">
        <label for="email">Email</label>
        <input type="email" id="email" name="email" class="form-control" value="${provider.email}" required />
      </div>
    </div>

    <div class="form-row">
      <!-- Contact First Name -->
      <div class="form-group col-md-6">
        <label for="contactFirstName">First Name</label>
        <input type="text" id="contactFirstName" name="contactFirstName" class="form-control" value="${provider.contactFirstName}" />
      </div>

      <!-- Contact Last Name -->
      <div class="form-group col-md-6">
        <label for="contactLastName">Last Name</label>
        <input type="text" id="contactLastName" name="contactLastName" class="form-control" value="${provider.contactLastName}" />
      </div>
    </div>

    <div class="form-row">
      <!-- City -->
      <div class="form-group col-md-6">
        <label for="city">City</label>
        <input type="text" id="city" name="city" class="form-control" value="${provider.city}" />
      </div>

      <!-- State -->
      <div class="form-group col-md-6">
        <label for="state">State</label>
        <select id="state" name="state" class="form-control">
          <option value="">-- Select --</option>
          <#list states as state>
          <option value="${state}" <#if state == provider.state>selected</#if>>${state}</option>
      </#list>
      </select>
    </div>
    </div>

    <!-- Image URL -->
    <div class="form-group">
      <label for="imageUrl">Store Image URL (optional)</label>
      <input type="text" id="imageUrl" name="imageUrl" class="form-control" value="${provider.imageUrl}" />
    </div>

    <div class="text-center mt-4">
      <button type="submit" class="btn provider-btn provider-btn-update">Update</button>
    </div>
  </form>

  <!-- Delete Provider Form -->
  <div class="provider-delete-form text-center mt-4">
    <form action="/providers/delete/${provider.storeID}" method="get" onsubmit="return confirm('Are you sure you want to delete this provider?');">
      <input type="hidden" name="_method" value="DELETE" />
      <button type="submit" class="btn provider-btn provider-btn-delete">Delete Provider</button>
    </form>
  </div>
</section>

</body>
</html>
