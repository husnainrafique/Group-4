<#include "header.ftlh">
<head>
    <link rel="stylesheet" href="/css/styles.css" />
    </head>
<h2>Book List</h2>
<a href="/books/add"> Add Book</a>

<table border="1" cellpadding="8" style="margin-top: 10px;">
    <tr>
        <th>ID</th>
        <th>Image</th>
        <th>Title</th>
        <th>Author</th>
        <th>ISBN</th>
        <th>Category</th>
        <th>Price</th>
        <th>Actions</th>
    </tr>
    <#list books as book>
    <tr>
        <td>${book.id}</td>
        <td><img src="${book.imageUrl!''}" alt="Book Image" width="60"/></td>
        <td>${book.title}</td>
        <td>${book.author}</td>
        <td>${book.isbn}</td>
        <td>${book.category!}</td>
        <td>$${book.price!"0.00"}</td>
        <td>
            <a href="/books/edit/${book.id}">Edit</a> |
            <a href="/books/delete/${book.id}">Delete</a>
        </td>
    </tr>
    </#list>
</table>
</body>
</html>

