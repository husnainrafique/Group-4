<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="HandMeDowns Admin" content="Admin panel for managing books and users." />
    <title>HandMeDowns - Admin Panel</title>
    <link rel="stylesheet" href="css/pure.css" />
    <link rel="stylesheet" href="css/styles.css" />
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>

<body>
    <header class="header">
        <h1>📊 Admin Dashboard - HandMeDowns</h1>
        <p><a href="home.html" class="home-btn">Home</a> | <a href="admin.html" class="home-btn">Return</a> | Logout</p>
    </header>

    <section class="admin-panel">
        <h2>⚙️ Admin Controls</h2>

        
        <div class="admin-section">
            <h3>📊 Manage Reviews </h3>

            <form action="placeholder" method="placeholder" class="admin-form">
                <label for="review-type">Reviews Type:</label>
                <select id="review-type" name="review-type">
                    <option value="books">Book Listings</option>
                    <option value="users">User Activity</option>
                    <option value="transactions">Transactions</option>
                </select>
                <form action="placeholder" method="placeholder" class="admin-form">
                    <label for="user-name">Review ID:</label>
                    <input type="text" id="user-name" name="username" required>

                <button type="submit" class="view-reviews-btn">Delete Review</button>
            </form>

            <form action="placeholder" method="placeholder" class="admin-form">
        
                <form action="placeholder" method="placeholder" class="admin-form">
                    <label for="user-name">Review ID:</label>
                    <input type="text" id="user-name" name="username" required>
                    <form action="add_user.php" method="POST" class="admin-form">
                        <label for="user-name">Reply:</label>
                        <input type="text" id="user-name" name="username" required>

                <button type="submit" class="view-reviews-btn">Reply to Review</button>
            </form>
        </div>
    </section>


</body>

</html>
