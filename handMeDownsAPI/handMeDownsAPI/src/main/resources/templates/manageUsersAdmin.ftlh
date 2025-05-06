<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Users - HandMeDowns</title>
    <link rel="stylesheet" href="/css/pure-min.css">
    <link rel="stylesheet" href="/css/styles.css">
</head>

<body>
    <header class="header">
        <h1>👥 Manage Users</h1>
        <div class="header-actions">
            <a href="/home" class="pure-button home-btn">Back to Dashboard</a>
            <a href="/logout" class="pure-button logout-btn">Logout</a>
        </div>
    </header>

    <section class="system-logs">
        <h2>📋 User Analytics</h2>
        <div class="log-container">
            <p><strong>Total Users:</strong> ${(userList![])?size}</p>
            <p><strong>New Users (Last 7 Days):</strong> ${newUsersCount!0}</p>
        </div>
    </section>

    <section class="admin-panel">
        <h2>User List</h2>

        <div class="log-container">
            <table class="simple-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Account Created</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <#list userList as user>
                        <tr>
                            <td>${user.id!0}</td>
                            <td>${user.name!''}</td>
                            <td>${user.email!''}</td>
                            <td>${user.createdAt!''}</td>
                            <td class="action-buttons">
                                <a href="/users/edit/${user.id}" class="pure-button">Edit</a>
                                <a href="/users/delete/${user.id}" 
                                   class="pure-button pure-button-error"
                                   onclick="return confirm('Are you sure you want to delete this user?')">
                                    Delete
                                </a>
                            </td>
                        </tr>
                    </#list>
                </tbody>
            </table>
        </div>

        <div style="margin-top: 20px;">
            <a href="/signup" class="pure-button pure-button-primary">Add New User</a>
        </div>
    </section>
</body>
</html>