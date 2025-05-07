<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="HandMeDowns Admin" content="Admin panel for managing books and users." />
    <title>HandMeDowns - Admin Panel</title>
    <link rel="stylesheet" href="/css/styles.css" />
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>

<body>
    <header class="header">
        <h1>📊 Admin Dashboard - HandMeDowns</h1>
        <p><a href="/home" class="home-btn">Home</a> | Logout</p>
    </header>

    <section class="admin-panel">
        <h2>⚙️ Admin Controls</h2>


        <!-- <div class="admin-section">
            <h3>📚 Manage Book Listings</h3>
            <button class="add-book-btn"onclick="window.location.href='manageBooks.html';">Add & Remove Books</button>

        </div> -->


        <!-- <div class="admin-section">
            <h3>👤 Manage Users</h3>
            <button class="add-user-btn" onclick="window.location.href='manageUsers.html';">Manage Users &
                Permissions</button>

        </div> -->

        <div class="admin-section">
            <h3>🛡️ Admin Management</h3>
            <button class="manage-admins-btn" onclick="window.location.href='manage';">Manage
                Administrators</button>
        </div>


        <div class="admin-section">
            <h3>📊 Reviews & Analytics</h3>
            <button class="view-reports-btn" onclick="window.location.href='manageReviews';">View & Manage
                Reviews</button>
            <button class="manage-admins-btn" onclick="window.location.href='/analytics';">Site Analytics
                <button class="manage-admins-btn" onclick="window.location.href='/reports/manageReports';">View & Manage Reports
        </div>
        <div class="admin-section">
            <h3>😀 Manage Users</h3>
            <button class="view-reports-btn" onclick="window.location.href='manageUsersAdmin';">View & Manage
                Users</button>
            <button class="manage-admins-btn" onclick="window.location.href='manageProviders';">View & Manage Providers
                
        </div>
    </section>



</body>

</html>