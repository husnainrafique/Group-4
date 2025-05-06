<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Register Provider - HandMeDowns</title>

    <!-- Bootstrap 4 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          crossorigin="anonymous"/>
    <link rel="stylesheet" href="/css/styles.css"/>
</head>

<body class="provider-body">
<header class="header text-center py-4">
    <h1>📚 Register as a Provider</h1>
    <a href="/providers/all" class="btn btn-light btn-sm">⬅ Back to Providers</a>
</header>

<section class="container my-5">
    <h2 class="text-center mb-4">Register Here</h2>
    <form action="/providers/register" method="post">
        <div class="form-row">
            <!-- Store Name -->
            <div class="form-group col-md-4">
                <label for="storeName">Store Name</label>
                <input type="text" class="form-control" id="storeName" name="storeName"
                       value="${provider.storeName?if_exists}"/>
                <#if provider.storeName?? && provider.storeName?has_content == false>
                <small class="text-danger">Store name is required</small>
            </#if>
        </div>

        <!-- Contact First Name -->
        <div class="form-group col-md-4">
            <label for="contactFirstName">First Name</label>
            <input type="text" class="form-control" id="contactFirstName" name="contactFirstName"
                   value="${provider.contactFirstName?if_exists}"/>
            <#if provider.contactFirstName?? && provider.contactFirstName?has_content == false>
            <small class="text-danger">First name is required</small>
        </#if>
        </div>

        <!-- Contact Last Name -->
        <div class="form-group col-md-4">
            <label for="contactLastName">Last Name</label>
            <input type="text" class="form-control" id="contactLastName" name="contactLastName"
                   value="${provider.contactLastName?if_exists}"/>
            <#if provider.contactLastName?? && provider.contactLastName?has_content == false>
            <small class="text-danger">Last name is required</small>
        </#if>
        </div>

        <!-- Email -->
        <div class="form-group col-md-4">
            <label for="email">E-Mail</label>
            <input type="email" class="form-control" id="email" name="email"
                   value="${provider.email?if_exists}"/>
            <#if provider.email?? && provider.email?has_content == false>
            <small class="text-danger">Email is required</small>
        </#if>
        </div>

        <!-- Password -->
        <div class="form-group col-md-4">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password"/>
            <#if provider.password?? && provider.password?has_content == false>
            <small class="text-danger">Password is required</small>
        </#if>
        </div>

        <!-- City -->
        <div class="form-group col-md-4">
            <label for="city">City</label>
            <input type="text" class="form-control" id="city" name="city" value="${provider.city?if_exists}"/>
        </div>

        <!-- State with suggestions -->
        <div class="form-group col-md-6">
            <label for="state">State</label>
            <input type="text" id="state" name="state" class="form-control" list="state-options"
                   value="${provider.state?if_exists}"/>
            <datalist id="state-options">
                <#list states as state>
                <option value="${state}">
                </#list>
            </datalist>
        </div>
        </div>

        <!-- Image URL -->
        <div class="form-group">
            <label for="imageUrl">Store Image URL (optional)</label>
            <input type="text" id="imageUrl" name="imageUrl" class="form-control"
                   value="${provider.imageUrl?if_exists}"/>
        </div>

        <!-- Buttons -->
        <div class="mt-4 d-flex justify-content-between">
            <button type="submit" class="btn btn-primary">Register</button>
            <button type="reset" class="btn btn-secondary">Clear Form</button>
            <a href="/providers/all" class="btn btn-light">Cancel</a>

        </div>
    </form>
</section>
</body>
</html>
