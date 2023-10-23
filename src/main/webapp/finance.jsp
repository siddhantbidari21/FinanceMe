<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to Finance Banking</title>
</head>
<body>
    <h1>Welcome to Finance Banking</h1>
    
    <h2>Account List</h2>
    <table>
        <tr>
            <th>Account ID</th>
            <th>Customer Name</th>
            <th>Customer Address</th>
            <th>Contact Number</th>
        </tr>
        <c:forEach items="${accountList}" var="account">
            <tr>
                <td>${account.accountId}</td>
                <td>${account.customerName}</td>
                <td>${account.customerAddress}</td>
                <td>${account.contactNumber}</td>
            </tr>
        </c:forEach>
    </table>

    <h2>Add Account</h2>
    <form action="/account/createaccount" method="post">
        Account ID: <input type="text" name="id" required><br>
        Customer Name: <input type="text" name="name" required><br>
        Customer Address: <input type="text" name="address" required><br>
        Contact Number: <input type="text" name="contact" required><br>
        <input type="submit" value="Add Account">
    </form>

    <!-- Add sections for updating, viewing, and deleting accounts here -->

    <h2>Seed Data</h2>
    <a href="/account/seeddata">Seed Data</a>
</body>
</html>
