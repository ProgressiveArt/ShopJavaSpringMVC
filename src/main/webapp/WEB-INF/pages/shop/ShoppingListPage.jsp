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

</style>

<head>
    <meta charset="UTF-8"/>
    <title>Welcome!</title>
</head>
<body>
<main>
    <h1 id=topzag>Products List</h1>

    <div class="but"
         onclick="location.href='/auth'">Back to Main menu
    </div>

    <span class="but"
          onclick="location.href='/user/bucketPage'">Bucket</span>
    <table id=tab style="border-collapse:collapse;">
        <tr>
            <th>name</th>
            <th>description</th>
            <th>cost</th>
            <th colspan=2 style="width: 150px;">action</th>
        </tr>
        <c:forEach var="product" items="${productsList}">
            <tr>
                <td>${product.name}</td>
                <td class="tdarea"><textarea wrap="soft | hard" class="descrarea"
                                             disabled>${product.description}</textarea></td>
                <td>${product.cost}</td>
                <td class="pole" style="border-right: 0px;"><span class="but"
                                                                  onclick="location.href='/user/shopPage/add/${product.id}'">Add</span>
                </td>

            </tr>
        </c:forEach>
    </table>
</main>

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
