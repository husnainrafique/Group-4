<#include "header.ftlh">
<head>
<link rel="stylesheet" href="/css/styles.css" />
</head>
<h2>📥 All Book Requests</h2>

<table border="1" cellpadding="10">
    <tr>
        <th>Book Title</th>
        <th>ISBN</th>
        <th>Category</th>
        <th>Request Type</th>
        <th>Requested At</th>
    </tr>
    <#list requests as request>
        <tr>
            <td>${request.bookTitle}</td>
            <td>${request.isbn}</td>
            <td>${request.category}</td>
            <td>${request.type}</td>
            <td>
                <#if request.requestedAt??>
                    ${request.requestedAt}
                </#if>
            </td>
        </tr>
    </#list>
</table>

</body>
</html>

