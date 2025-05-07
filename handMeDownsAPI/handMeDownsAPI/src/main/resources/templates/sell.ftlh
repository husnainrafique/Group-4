<#include "header.ftlh">
<head>
    <link rel="stylesheet" href="/css/styles.css" />
    </head>
<h2>🛒 Available Books for Purchase</h2>

<div class="card-container">
    <#list books as book>
        <div class="card">
            <img src="${book.imageUrl!''}" alt="${book.title!''}" />
            <div class="card-body">
                <div class="card-title">${book.title!''}</div>
                <div class="card-text">by ${book.author!''}</div>
                <div class="card-text">ISBN: ${book.isbn!''}</div>
                <div class="card-text">
                    Price:
                    <#if book.price?? && book.price?is_number && book.price != 0>
                      $${book.price}
                    <#else>
                      Free
                    </#if>
                  </div>
                  
                <button class="view-btn" data-book='{
                    "title": "${book.title?js_string}",
                    "author": "${book.author?js_string}",
                    "isbn": "${book.isbn?js_string}",
                    "price": "${(book.price!"0.00")?js_string}",
                    "category": "${(book.category!"")?js_string}",
                    "imageUrl": "${(book.imageUrl!"")?js_string}"
                }'>Buy</button>
            </div>
        </div>
    </#list>
</div>

<!-- Modal -->
<div id="bookModal" class="modal" style="display:none;">
    <div class="modal-content">
        <span class="close">&times;</span>
        <img id="modalImage" src="" alt="Book Image" />
        <h3 id="modalTitle"></h3>
        <p><strong>Author:</strong> <span id="modalAuthor"></span></p>
        <p><strong>ISBN:</strong> <span id="modalIsbn"></span></p>
        <p><strong>Price:</strong> <span id="modalPrice"></span></p>
        <p><strong>Category:</strong> <span id="modalCategory"></span></p>
        <button id="submitRequestBtn">Submit Request</button>
    </div>
</div>

<!-- JavaScript -->
<script>
    const modal = document.getElementById("bookModal");
    const closeBtn = document.querySelector(".close");
    let selectedBook = null;

    document.querySelectorAll(".view-btn").forEach(btn => {
        btn.addEventListener("click", function () {
            try {
                const book = JSON.parse(this.dataset.book);
                selectedBook = book;

                document.getElementById("modalImage").src = book.imageUrl || '';
                document.getElementById("modalTitle").innerText = book.title || "Untitled";
                document.getElementById("modalAuthor").innerText = book.author || "Unknown";
                document.getElementById("modalIsbn").innerText = book.isbn || "N/A";

                const validPrice = (book.price && book.price !== "null") ? `$${book.price}` : 'Free';
                document.getElementById("modalPrice").innerText = validPrice;

                document.getElementById("modalCategory").innerText = book.category || "Uncategorized";

                modal.style.display = "flex";
            } catch (err) {
                console.error("❌ Failed to open modal:", err);
                alert("Something went wrong loading the book data.");
            }
        });
    });

    closeBtn.onclick = () => modal.style.display = "none";
    window.onclick = e => { if (e.target === modal) modal.style.display = "none"; }

    document.getElementById("submitRequestBtn").onclick = () => {
        if (!selectedBook) return;

        fetch("/requests", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
                bookTitle: selectedBook.title || "",
                isbn: selectedBook.isbn || "",
                category: selectedBook.category || "",
                type: selectedBook.category === "donate" ? "claim"
                    : selectedBook.category === "trade" ? "trade"
                    : "buy"
            })
        }).then(res => {
            if (res.ok) {
                alert("✅ Request submitted successfully!");
                modal.style.display = "none";
            } else {
                alert("❌ Something went wrong.");
            }
        }).catch(err => {
            console.error("❌ Request failed:", err);
            alert("Network error.");
        });
    };
</script>

</body>
</html>

