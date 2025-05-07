<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>📊 Provider Statistics</title>

    <!-- Bootstrap 4 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" crossorigin="anonymous" />

    <!-- Font Awesome -->
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous" async></script>

    <!-- Custom Scoped Styles -->
    <link rel="stylesheet" href="/css/statistics.css" />

    <!-- Chart.js -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>

<body class="provider-stats-body">
<header class="provider-stats-header text-center py-4">
    <h1>📊 Provider Statistics</h1>
    <a href="/providers/${storeID}" class="btn btn-light btn-sm mt-2 provider-back-btn">⬅ Back to Provider</a>
</header>

<section class="container provider-stats-container mt-5">
    <!-- Stats Overview Table -->
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow-sm">
                <div class="card-body">
                    <h5 class="card-title text-center mb-4">📈 Stats Overview</h5>
                    <table class="table table-bordered text-center mb-0">
                        <tbody>
                        <tr>
                            <th scope="row">Total Visits</th>
                            <td>${provider.totalVisits}</td>
                        </tr>
                        <tr>
                            <th scope="row">Books Viewed</th>
                            <td>${provider.booksViewed}</td>
                        </tr>
                        <tr>
                            <th scope="row">Reviews Left</th>
                            <td>${provider.reviewsLeft}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <!-- Larger Chart -->
    <div class="chart-container mt-4">
        <canvas id="statsChart"></canvas>
    </div>
</section>

<script>
    const ctx = document.getElementById('statsChart').getContext('2d');
    new Chart(ctx, {
      type: 'bar',
      data: {
        labels: ['Visits', 'Books Viewed', 'Reviews'],
        datasets: [{
          label: 'Count',
          data: [${provider.totalVisits}, ${provider.booksViewed}, ${provider.reviewsLeft}],
          backgroundColor: ['#007bff', '#28a745', '#ffc107']
        }]
      },
      options: {
        responsive: true,
        maintainAspectRatio: false,
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });
</script>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous" defer></script>
</body>
</html>