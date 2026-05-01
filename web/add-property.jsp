<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Property</title>
</head>
<body>
    <h1>Add a New Listing</h1>

    <!-- The action="/property" maps exactly to the @WebServlet("/property") we made -->
<!-- 1. We added id="addForm" so JS can find it -->
    <form id="addForm" action="property" method="POST">
        <input type="hidden" name="action" value="add">

        <label>Location:</label><br>
        <input type="text" name="location" required><br><br>

        <label>Price ($):</label><br>
        <!-- 2. Added id="priceInput" -->
        <input type="number" id="priceInput" name="price" step="0.01" required><br><br>

        <label>Bedrooms:</label><br>
        <!-- 3. Added id="bedInput" -->
        <input type="number" id="bedInput" name="bedrooms" required><br><br>

        <button type="submit">Submit Listing</button>
    </form>

    <!-- THE JAVASCRIPT UI ENHANCEMENT -->
    <script>
        document.getElementById("addForm").addEventListener("submit", function(event) {
            // Grab the values the user typed
            let price = parseFloat(document.getElementById("priceInput").value);
            let beds = parseInt(document.getElementById("bedInput").value);

            // Check for silly mistakes
            if (price <= 0) {
                alert("Error: Price must be greater than zero!");
                event.preventDefault(); // This STOPS the form from sending data to Java
            } else if (beds < 1) {
                alert("Error: A property must have at least 1 bedroom!");
                event.preventDefault(); // Stops the form
            }
        });
    </script>
    <br>
    <a href="index.jsp">Back to Home</a>
</body>
</html>