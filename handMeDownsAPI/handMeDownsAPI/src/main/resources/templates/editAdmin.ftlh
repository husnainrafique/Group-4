<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Admin - HandMeDowns</title>
    <link rel="stylesheet" href="/css/pure.css">
    <link rel="stylesheet" href="/css/styles.css">
</head>

<body>
    <header class="header">
        <h1>✏️ Edit Administrator</h1>
        <p><a href="/admins/manage" class="pure-button">Back to Management</a></p>
    </header>

    <section class="admin-panel">
        <form class="pure-form pure-form-stacked" action="/admins/update/${admin.adminID}" method="post">
            <fieldset>
                <legend>Admin Information</legend>

                <input type="hidden" name="id" value="${admin.adminID}">

                <div class="pure-control-group">
                    <label for="role">Role</label>
                    <input type="text" id="role" name="role" value="${admin.role!''}" required class="pure-input-1">
                </div>

                <div class="pure-controls">
                    <button type="submit" class="pure-button pure-button-primary">Update Admin</button>
                    <a href="/admins/manage" class="pure-button">Cancel</a>
                </div>
            </fieldset>
        </form>
    </section>
</body>

</html>