<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Reviews - HandMeDowns</title>
    <link rel="stylesheet" href="/css/pure-min.css">
    <link rel="stylesheet" href="/css/styles.css">
    <style>
        .rating {
            color: gold;
            font-weight: bold;
        }
        .review-content {
            max-width: 400px;
            word-wrap: break-word;
        }
        .reply-content {
            background-color: #f5f5f5;
            padding: 8px;
            border-left: 3px solid #ccc;
            margin-top: 5px;
        }
    </style>
</head>

<body>
    <header class="header">
        <h1>📝 Manage Reviews</h1>
        <div class="header-actions">
            <a href="/home" class="pure-button home-btn">Back to Dashboard</a>
            <a href="/logout" class="pure-button logout-btn">Logout</a>
        </div>
    </header>

    <section class="system-logs">
        <h2>📋 Review Analytics</h2>
        <div class="log-container">
            <p><strong>Total Providers:</strong> ${providerCount!0}</p>
        </div>
    </section>

    <section class="admin-panel">
        <h2>Provider Reviews</h2>

        <div class="log-container">
            <table class="simple-table">
                <thead>
                    <tr>
                        <th>Provider</th>
                        <th>Rating</th>
                        <th>Review</th>
                        <th>Author</th>
                        <th>Status</th>
                        <th>Date</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <#list providerList as provider>
                        <#list provider.reviews as review>
                        <tr>
                            <td>${provider.storeName!''}</td>
                            <td class="rating">${review.rating!0} ★</td>
                            <td class="review-content">
                                ${review.content!''}
                                <#if review.reply??>
                                    <div class="reply-content">
                                        <strong>Reply:</strong> ${review.reply}
                                    </div>
                                </#if>
                            </td>
                            <td>User ${review.authorID!0}</td>
                            <td>${review.status!''}</td>
                            <td>${review.createdAt!''}</td>
                            <td class="action-buttons">
                                <a href="/provider-reviews/delete/${review.reviewID}" 
                                   class="pure-button pure-button-error"
                                   onclick="return confirm('Are you sure you want to delete this review?')">
                                    Delete
                                </a>
                            </td>
                        </tr>
                        </#list>
                    </#list>
                </tbody>
            </table>
        </div>
    </section>
</body>
</html>