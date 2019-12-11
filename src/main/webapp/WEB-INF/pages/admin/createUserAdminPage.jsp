<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<c:url value="/admin/addUser" var="var"/>
<form action="${var}" method="POST">

    <label for="login">Login</label>
    <input type="text" name="Login" id="login">

    <label for="password">Password</label>
    <input type="text" name="Password" id="password">

    <label for="Role">Role (Use: ADMIN\USER</label>
    <input type="text" name="Role" id="Role">

    <input type="submit" value="Create user">
</form>
</body>
</html>