<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Providers - HandMeDowns</title>
    <link rel="stylesheet" href="/css/pure-min.css">
    <link rel="stylesheet" href="/css/styles.css">
</head>

<body>
    <header class="header">
        <h1>🏪 Manage Providers</h1>
        <div class="header-actions">
            <a href="/admins/admin" class="pure-button home-btn">Back to Dashboard</a>
            <a href="/logout" class="pure-button logout-btn">Logout</a>
        </div>
    </header>

    <section class="system-logs">
        <h2>📋 Provider Analytics</h2>
        <div class="log-container">
            <p><strong>Total Providers:</strong> ${(providerList![])?size}</p>
        </div>
    </section>

    <section class="admin-panel">
        <h2>Provider List</h2>

        <div class="log-container">
            <table class="simple-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Store Name</th>
                        <th>Owner</th>
                        <th>Email</th>
                        <th>Location</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <#list providerList as provider>
                        <tr>
                            <td>${provider.storeID!0}</td>
                            <td>${provider.storeName!''}</td>
                            <td>${provider.contactFirstName!''} ${provider.contactLastName!''}</td>
                            <td>${provider.email!''}</td>
                            <td>${provider.city!''}, ${provider.state!''}</td>
                            <td class="action-buttons">
                                <a href="/providers/edit/${provider.storeID}" class="pure-button">Edit</a>
                                <a href="/providers/delete/${provider.storeID}" 
                                   class="pure-button pure-button-error"
                                   onclick="return confirm('Are you sure you want to delete this provider?')">
                                    Delete
                                </a>
                            </td>
                        </tr>
                    </#list>
                </tbody>
            </table>
        </div>

        <div style="margin-top: 20px;">
            <a href="/providers/register" class="pure-button pure-button-primary">Add New Provider</a>
        </div>
    </section>
</body>
</html>