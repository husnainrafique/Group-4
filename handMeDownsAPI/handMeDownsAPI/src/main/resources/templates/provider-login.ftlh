<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Provider Login - HandMeDowns</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="/css/styles.css" />
</head>
<body class="bg-light">

<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <div class="card provider-login-wrapper shadow-sm">
        <div class="card-body provider-login-form">
          <h3 class="text-center mb-4 provider-login-header">🔐 Provider Login</h3>
          <form method="POST" action="/providers/login">
            <div class="form-group">
              <label for="email">Email address</label>
              <input type="email" name="email" class="form-control" id="email" required />
            </div>
            <div class="form-group">
              <label for="password">Password</label>
              <input type="password" name="password" class="form-control" id="password" required />
            </div>
            <button type="submit" class="btn provider-btn provider-btn-login btn-block">Login</button>
          </form>
          <div class="provider-login-actions text-center mt-3">
            <p>Don't have an account?</p>
            <a href="/providers/register" class="btn provider-btn provider-btn-register">Register</a>
          </div>
          <div class="text-center mt-3">
            <a href="/providers/all" class="btn provider-btn provider-btn-back btn-light btn-sm">⬅ Back to Providers</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>
