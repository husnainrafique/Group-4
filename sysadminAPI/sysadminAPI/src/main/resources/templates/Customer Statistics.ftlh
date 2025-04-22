<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Statistics</title>
    <link rel="stylesheet" href="css/pure-min.css" />
    <link rel="stylesheet" href="css/styles.css">
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js">
    </script>
</head>
<body>
<header class="header">
    <h1>Customer Statistics</h1>
    <p> <a href="providerInventory.html" class="inventory-btn">Inventory</a> | <a href="Customer%20Statistics.html" class="statistics-btn">Customer Statistics</a> | <a href="provider-reviews.html" class="statistics-btn">Reviews</a> </p>
    <a href="home.html" class="back-btn">⬅ Back to Home</a>
</header>

<section class="statistics">
    <h2>Customer Interaction</h2>
    <div class="steps">
        <div class="step">
            <h3>Provider Visited</h3>
            <h2>73</h2>
        </div>
        <div class="step">
            <h3>Books Bought</h3>
            <h2>53</h2>
        </div>
        <div class="step">
            <h3>Reviews</h3>
            <h2>17</h2>
        </div>
    </div>

    <canvas id="myChart" style="width:100%;max-width:700px"></canvas>



</section>

<script>
    var xValues = ["Visited", "Books Purchased", "Reviews"];
    var yValues = [73, 53, 17, 24, 15];
    var barColors = ["red", "green","blue"];

    new Chart("myChart", {
      type: "bar",
      data: {
        labels: xValues,
        datasets: [{
          backgroundColor: barColors,
          data: yValues
        }]
      },
      options: {
        legend: {display: false},
        title: {
          display: true,
          text: ""
        }
      }
    });
</script>

<section class="join-movement">
    <h2> Leave us a review!</h2>
    <p>Please help us improve and grow by leaving a review!</p>
    <p><a href="provider-reviews.html">Click Here</a></p>
</section>

</body>


</html>