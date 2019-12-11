<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<c:url value="/admin/edit" var="var"/>
<form action="${var}" method="POST">
    <input type="hidden" name="id" value="${product.id}">

    <label for="productName">Name (Current: ${product.name})</label>
    <input type="text" name="Name" id="productName">

    <label for="description">Description (Current: ${product.description})</label>
    <input type="text" name="Description" id="description">

    <label for="Cost">Cost (Current: ${product.cost})</label>
    <input type="text" name="Cost" id="Cost">

    <input type="submit" value="Update product">
</form>
</body>
</html>