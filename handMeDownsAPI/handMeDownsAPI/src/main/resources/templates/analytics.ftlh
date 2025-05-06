<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="HandMeDowns Admin" content="Admin panel for managing analytics data." />
    <title>HandMeDowns - Analytics Dashboard</title>
    <link rel="stylesheet" href="/css/pure.css" />
    <link rel="stylesheet" href="/css/styles.css" />
    <style>

    </style>
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>

<body>
    <header class="header">
        <h1>📊 Analytics Dashboard - HandMeDowns</h1>
        <p>
            <a href="/home" class="home-btn">Home</a> |
            <a href="/admins/admin" class="home-btn">Return</a> |
            Logout
        </p>
    </header>

    <section class="system-logs">
        <h2>📋 System Analytics</h2>
        <div class="log-container">
            <p><strong>Total Log Entries:</strong> ${(analytics![])?size}</p>
        </div>

        <h2>📋 Log Entries</h2>
        <div class="log-container">
            <table class="simple-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Admin Action</th>
                        <th>Login Time</th>
                        <th>Logout Time</th>
                        <th>Duration logged in</th>
                        <th>Report ID</th>
                        <th>Admin ID</th>
                    </tr>
                </thead>
                <tbody>
                    <#list analytics! as log>
                        <tr>
                            <td>${log.id!'-'}</td>
                            <td>${(log.adminDeleteTimestamp?string('yyyy-MM-dd HH:mm:ss'))!'-'}</td>
                            <td>${(log.loggedInTimestamp?string('yyyy-MM-dd HH:mm:ss'))!'-'}</td>
                            <td>${(log.loggedOutTimestamp?string('yyyy-MM-dd HH:mm:ss'))!'-'}</td>
                            <td>${(log.totalTimeLoggedIn/1000)!'-'}s</td>
                            <td>${(log.report.reportID)!'-'}</td>
                            <td>${(log.sysAdmin.id)!'-'}</td>
                        </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </section>
</body>

</html>