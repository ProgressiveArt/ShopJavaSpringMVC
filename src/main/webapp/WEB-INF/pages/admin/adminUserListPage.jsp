

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<style>
    body {
        background: linear-gradient(to bottom, #a4b0be, #2f3542);
    }

    .but, th, #topzag, .spanclick {
        color: #fff;
    }

    .pole, #topzag {
        text-align: center;
    }

    .but:hover, .botclick:hover {
        background-color: #2f3542;
    }

    #tab, td {
        border: 1px solid black;
    }

    .descrarea {
        resize: none;
        background-color: #a4b0be;
        overflow: hidden;
        border: none;
        color: black;
        width: 100%;
    }

    #tab {
        width: 100%;
    }

    .but {
        background-color: #747d8c;
        padding: 1px 15px 2px 15px;
        transition: 0.2s;
    }

    .pole {
        width: 70px;
    }

    #prodid {
        width: 20px;
    }

    main {
        margin-left: 15%;
        width: 70%;
    }

    .tdarea {
        width: 360px;
    }

    a {
        color: white;
        text-decoration: none;
    }

    th {
        font-size: 1.3em;
        padding: 5px 15px 5px 15px;
        background-color: #747d8c;
    }

    #topzag {
        padding: 20px;
        background-color: #57606f;
        font-size: 2.5em;
    }

    td {
        background-color: #a4b0be;
        padding: 7px 5px 7px 5px;
    }

    body, bottom, .botclick {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    bottom {
        width: 15%;
        position: fixed;
        height: 50%;
        background-color: #57606f;
        top: 5%;
        left: 1%;
    }

    .botclick {
        width: 100%;
        height: 10%;
        background-color: #747d8c;
        margin: 10px 0px 0px 0px;
        transition: 0.2s;
    }

    .spanclick {
        padding-top: 4%;
        font-size: 1.5em;
    }
</style>

<head>
    <meta charset="UTF-8"/>
    <title>Welcome!</title>
</head>
<body>
<main>
    <h1 id=topzag>Users</h1>
    <table id=tab style="border-collapse:collapse;">
        <tr>
            <th>id</th>
            <th>login</th>
            <th>password</th>
            <th>role</th>
            <th colspan=2 style="width: 150px;">action</th>
        </tr>
        <c:forEach var="user" items="${usersList}">
            <tr>
                <td style="width: 20px;padding: none; text-align: center;">${user.id}</td>
                <td>${user.login}</td>
                <td class="tdarea"><textarea wrap="soft | hard" class="descrarea"
                                             disabled>${user.password}</textarea></td>
                <td>${user.role}</td>
                <td class="pole" style="border-right: 0px;"><span class="but"
                                                                  onclick="location.href='/admin/editUserPage/userID=${user.id}'">edit</span>
                </td>
                <td class="pole" style="border-left: 0px;"><span class="but"
                                                                 onclick="location.href='/admin/deleteUser/${user.id}'">delete</span>
                </td>
            </tr>

        </c:forEach>
    </table>
</main>
<c:url value="/adminPage" var="back"/>
<c:url value="/admin/addUserPage" var="addUser"/>
<bottom>
    <div class="botclick" onclick="location.href='${addUser}'"><span class="spanclick">Add new user</span></div>
    <div class="botclick" onclick="location.href='${back}'"><span class="spanclick">Back to Admin Menu</span></div>

</bottom>
</body>
<script>
    function pod() {
        let blocks = document.getElementsByClassName('descrarea');
        for (let i = 0; i < blocks.length; i++) {
            let x = blocks[i].value;
            let m = x.length;
            let y = Math.round((m + 23) / 45);
            blocks[i].setAttribute('rows', y);
        }
    }

    pod();
</script>
</html>

