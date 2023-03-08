<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

    <div class = "container">
    <text>Welcome, ${name}</text> <br>
    <text>Your todos is </text>
    <table class="table">
        <thead>
        <tr>
            <th>Description</th>
            <th>Target date</th>
            <th>isDone</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${list_todos}" var="todo">
                <tr>
                    <td>${todo.descrpition}</td>
                    <td>${todo.date}</td>
                    <td>${todo.done}</td>
                    <td><a href="delete_todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
                    <td><a href="update_todo?id=${todo.id}" class="btn btn-success">Update</a></td>

                </tr>
            </c:forEach>
        </tbody>
    </table>

        <a href="add-todo" class="btn">Add todo</a>
    </div>
</body>
<%@ include file="common/footer.jspf"%>
