<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<c:url value="/admin/add" var="var"/>
<form action="${var}" method="POST">

    <label for="productName">Name</label>
    <input type="text" name="Name" id="productName">

    <label for="description">Description</label>
    <input type="text" name="Description" id="description">

    <label for="Cost">Cost</label>
    <input type="text" name="Cost" id="Cost">

    <input type="submit" value="Create product">
</form>
</body>
</html>