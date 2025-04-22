<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title>HandMeDowns - Admin Panel</title>
    <link rel="stylesheet" href="/css/pure.css" />
    <link rel="stylesheet" href="/css/styles.css" />
</head>

<body>
    <header class="header">
        <h1>📊 Admin Dashboard - HandMeDowns</h1>
        <p>
            <a href="admin" class="home-btn">Home</a> |
            <a href="/admins/admin" class="home-btn">Back to Dashboard</a> |
            <a href="/logout">Logout</a>
        </p>
    </header>

    <section class="admin-panel">
        <h2>⚙️ Report Management</h2>

        <!-- Create Report Form -->
        <div class="admin-section">
            <h3>📝 Create New Report</h3>
            <form action="/reports/manageReports/create" method="post" class="admin-form">
                <input type="hidden" name="sysAdmin.adminID" value="1"> <!-- Default admin ID -->

                <label for="contentDetails">Report Details:</label>
                <input type="text" id="contentDetails" name="contentDetails" required>

                <label for="author">Author:</label>
                <input type="text" id="author" name="author" required>

                <label for="reason">Reason:</label>
                <input type="text" id="reason" name="reason" required>

                <label for="status">Status:</label>
                <select id="status" name="status" required>
                    <option value="OPEN">OPEN</option>
                    <option value="CLOSED">CLOSED</option>
                </select>

                <button type="submit">Create Report</button>
            </form>
        </div>

        <!-- Report List with Actions -->
        <div class="admin-section">
            <h3>📋 All Reports</h3>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Content</th>
                        <th>Author</th>
                        <th>Status</th>
                        <th>Created</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <#list reportList as report>
                        <tr>
                            <td>${report.reportID}</td>
                            <td>${report.contentDetails}</td>
                            <td>${report.author}</td>
                            <td>${report.status}</td>
                            <td>${report.createdAt?date?string('yyyy-MM-dd')}</td>
                            <td>

                                <a href="/reports/delete/${report.reportID}"
                                    onclick="return confirm('Delete this report?')" class="delete-btn">Close</a>
                            </td>
                        </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </section>
</body>

</html>