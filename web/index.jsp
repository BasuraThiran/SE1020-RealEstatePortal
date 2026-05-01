<%@ page import="com.realestate.utils.FileHandler" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Real Estate Portal - Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        table { border-collapse: collapse; width: 80%; margin-top: 20px; }
        th, td { border: 1px solid black; padding: 10px; text-align: left; }
        th { background-color: #f2f2f2; }
        /* A little styling for our new search bar */
        #searchInput { padding: 8px; width: 250px; margin-left: 20px; }
    </style>
</head>
<body>
    <h1>Real Estate Portal                      Available Properties</h1>

    <!-- Your Buttons -->
    <a href="add-property.jsp"><button class="btn btn-success">Add New Property</button></a>
    <a href="delete-property.jsp"><button class="btn btn-danger">Delete a Property</button></a>

    <!-- THE NEW SEARCH BAR -->
    <input type="text" id="searchInput" placeholder="Search by Location (e.g., Colombo)...">

    <!-- Added id="propertyTable" to the table -->
    <table class="table table-striped table-hover mt-4" id="propertyTable">
        <tr>
            <th>ID</th>
            <th>Type</th>
            <th>Location</th>
            <th>Price ($)</th>
            <th>Bedrooms</th>
        </tr>
        <%
            List<String> properties = FileHandler.getAllProperties();
            for(String prop : properties) {
                String[] details = prop.split(",");
                if(details.length == 5) {
        %>
                <tr>
                    <td><%= details[0] %></td>
                    <td><%= details[1] %></td>
                    <!-- We will search based on this 3rd column (Location) -->
                    <td><%= details[2] %></td>
                    <td><%= details[3] %></td>
                    <td><%= details[4] %></td>
                </tr>
        <%
                }
            }
        %>
    </table>

    <!-- THE JAVASCRIPT UI ENHANCEMENT -->
    <script>
        // Listen for every time the user types a key in the search box
        document.getElementById("searchInput").addEventListener("keyup", function() {
            // Get the text the user typed and make it lowercase
            let filter = this.value.toLowerCase();

            // Get the table and all its rows
            let table = document.getElementById("propertyTable");
            let tr = table.getElementsByTagName("tr");

            // Loop through all table rows (start at i=1 to skip the header row!)
            for (let i = 1; i < tr.length; i++) {
                // Get the 3rd column (index 2), which is the Location
                let locationColumn = tr[i].getElementsByTagName("td")[2];

                if (locationColumn) {
                    let locationText = locationColumn.textContent || locationColumn.innerText;

                    // If the typed text matches the location, show the row, else hide it
                    if (locationText.toLowerCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }
        });
    </script>
</body>
</html>