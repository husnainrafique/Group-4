<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Admin - HandMeDowns</title>
    <link rel="stylesheet" href="/css/pure.css">
    <link rel="stylesheet" href="/css/styles.css">
</head>

<body>
    <header class="header">
        <h1>➕ Add New Administrator</h1>
        <p><a href="/admins/manage" class="pure-button">Back to Management</a></p>
    </header>

    <section class="admin-panel">
        <form class="pure-form pure-form-stacked" action="/admins/new" method="post">
            <fieldset>
                <legend>Admin Information</legend>

                <div class="pure-control-group">
                    <label for="role">Role</label>
                    <input type="text" id="role" name="role" required class="pure-input-1">
                </div>

                <div class="pure-controls">
                    <button type="submit" class="pure-button pure-button-primary">Save Admin</button>
                    <a href="/admins/manage" class="pure-button">Cancel</a>
                </div>
            </fieldset>
        </form>
    </section>
</body>

</html>