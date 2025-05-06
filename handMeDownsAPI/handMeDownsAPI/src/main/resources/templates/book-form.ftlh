<#include "header.ftlh">
<head>
    <link rel="stylesheet" href="/css/styles.css" />
    </head>
<#if book?? && book.id??>
    <h2>Edit Book</h2>
<#else>
    <h2>Add Book</h2>
</#if>

<form action="/books/save" method="post">
    <input type="hidden" name="id" value="${book.id!}" />

    <label for="title">Title:</label>
    <input type="text" id="title" name="title" value="${book.title!}" required />

    <label for="author">Author:</label>
    <input type="text" id="author" name="author" value="${book.author!}" required />

    <label for="isbn">ISBN:</label>
    <input type="text" id="isbn" name="isbn" value="${book.isbn!}" required />

    <label for="category">Category:</label>
    <select name="category" required>
        <option value="sell" <#if book.category?? && book.category == "sell">selected</#if>>Sell</option>
        <option value="donate" <#if book.category?? && book.category == "donate">selected</#if>>Donate</option>
        <option value="trade" <#if book.category?? && book.category == "trade">selected</#if>>Trade</option>
    </select>
    <label for="imageUrl">Image URL:</label>
    <input type="text" id="imageUrl" name="imageUrl" placeholder="Paste image link here" value="${book.imageUrl!}" />


    <label for="price">Price (USD):</label>
    <input type="number" id="price" name="price" step="0.01" value="${book.price!}" />


    <button type="submit">Save</button>
</form>

</body>
</html>
