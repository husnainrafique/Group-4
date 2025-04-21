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
            <h3>📚 Manage Reviews</h3>

            <form action="placeholder" method="placeholder" class="admin-form">
                <label for="report-details">Report details:</label>
                <input type="text" id="book-title" name="book_title" required>

                <label for="report-author">Author:</label>
                <input type="text" id="book-author" name="book_author" required>

                <label for="report-reason">Reason:</label>
                <input type="text" id="book-author" name="book_author" required>


                <label for="report-status">Status:</label>
                <select id="report-status" name="book_status">
                    <option value="trade">OPEN</option>
                    <option value="donate">CLOSED</option>
                </select>

                <button type="submit" class="add-book-btn">Add New Book</button>
            </form>

            <form action="placeholder" method="placeholder" class="admin-form">
                <label for="remove-report">ReportID:</label>
                <input type="text" id="remove-book" name="book_id" required>

                <button type="submit" class="remove-review-btn">Remove review</button>
            </form>
        </div>

       
  

</body>

</html>
