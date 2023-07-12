<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <html>
        <%@include file="./Common/header.jspf" %>
    <body>
        <%@include file="./Common/navigation.jspf"%>
       
        <div class="container">
            <h1>Welcome to ${name}</h1>
            <hr>
            <h3>Your toDo list is the following</h3>
            <table class="table">
                <thead>
                    <tr>
                        <th>task-ID</th>
                        <th>User-Name</th>
                        <th>Description</th>
                        <th>task-Date</th>
                        <th>Done</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach items="${toDoList}" var="toDo">
                        <tr>
                            <td>
                                ${toDo.id}
                            </td>
                            <td>
                                ${toDo.userName}
                            </td>
                            <td>${toDo.description}</td>
                            <td>${toDo.targetDate}</td>
                            <td>${toDo.done} </td>
                            <td> <a  class="btn btn-warning" href="delete-toDo?id=${toDo.id}">Delete</a></td> 
                            <td> <a  class="btn btn-success" href="update-toDo?id=${toDo.id}">Update</a></td> 
                        
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="add-todo" class="btn btn-success">Add Todo</a>
        </div>
        <%@include file="./Common/footer.jspf" %> 

    </body>

    </html>