<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Property</title>
</head>
<body>
    <h1>Delete a Listing</h1>
    <!-- We add a JS confirmation. If they click 'Cancel', the form stops and doesn't delete! -->
    <form action="property" method="POST" onsubmit="return confirm('Are you absolutely sure you want to delete this listing?');">
    <form action="property" method="POST">
        <!-- This hidden field tells the Servlet we want to DELETE, not ADD -->
        <input type="hidden" name="action" value="delete">

        <label>Enter the ID of the Property to Delete:</label><br>
        <input type="text" name="id" required><br><br>

        <button type="submit" style="color: red;">Delete Property</button>
    </form>
    <br>
    <a href="index.jsp">Back to Home</a>
</body>
</html>