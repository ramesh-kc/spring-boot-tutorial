<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Todo's for ${name}</title>
</head>
<body>
<h1>Your Todos</h1>
<table>
    <caption>Your todo's are</caption>
    <thead>
    <tr>
        <th>Description</th>
        <th>Target Date</th>
        <th>Is it Done</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${todos}" var="todo">
        <tr>
            <td>${todo.description}</td>
            <td>${todo.targetDate}</td>
            <td>${todo.done}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="/add-todo">Add Todo</a></p>
</body>
</html>
