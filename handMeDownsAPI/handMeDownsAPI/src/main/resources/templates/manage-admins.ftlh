<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Admins - HandMeDowns</title>
    <link rel="stylesheet" href="/css/pure-min.css">
    <link rel="stylesheet" href="/css/styles.css">

</head>

<body>
    <header class="header">
        <h1>👥 Manage Administrators</h1>
        <div class="header-actions">
            <a href="/admins/admin" class="pure-button home-btn">Back to Dashboard</a>
            <a href="/logout" class="pure-button logout-btn">Logout</a>
        </div>
    </header>

    <section class="admin-panel">
        <h2>Administrator List</h2>

        <div class="log-container">
            <table class="simple-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Role</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <#list admins as admin>
                        <tr>
                            <td>${admin.adminID!0}</td>
                            <td>${admin.role!''}</td>
                            <td class="action-buttons">
                                <a href="/admins/edit/${admin.adminID}" class="pure-button">Edit</a>
                                <a href="/admins/delete/${admin.adminID}" class="pure-button pure-button-error"
                                    onclick="return confirm('Are you sure you want to delete this admin?')">Delete</a>
                            </td>
                        </tr>
                    </#list>
                </tbody>


            </table>
        </div>

        <div style="margin-top: 20px;">
            <a href="/admins/new" class="pure-button pure-button-primary">Add New Admin</a>
        </div>
    </section>
</body>

</html>