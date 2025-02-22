<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <!-- <link rel="stylesheet" href="/css/demo.css"> -->

</head>
<body>

    <div class="container mt-5">
        <!-- Content here -->
         <div class="col-12 mx-auto">
            <div class="d-flex justify-content-between">
                <h3 class="text-center">Table User</h3>
                <a href="/admin/user/create" class="btn btn-primary">Create a user</a>
            </div>
            <hr/>
            <table class="table table-hover table-bordered">
                <thead>
                  <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Email</th>
                    <th scope="col">Full Name</th>
                    <th scope="col">Action</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.email}</td>
                        <td>${user.fullName}</td>
                        <td>
                            <a href="/admin/user/${user.id}" class="btn btn-success">View</a>
                            <a href="/admin/user/update/${user.id}" class="btn btn-warning mx-2">Update</a>



                            <!-- Button trigger modal -->
                            <button  type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal-${user.id}">
                              Delete
                            </button>

                            <!-- Modal -->
                            <div class="modal fade" id="exampleModal-${user.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                              <div class="modal-dialog">
                                <div class="modal-content">
                                  <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="exampleModalLabel">Delete user ${user.id}</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                  </div>
                                  <div class="modal-body">
                                    Are you sure delete this user ?
                                  </div>
                                  <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                    <a href="/admin/user/delete/${user.id}"  class="btn btn-primary">Save changes</a>
                                  </div>
                                </div>
                              </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            
                 
      
                </tbody>
              </table>


            
         </div>

    </div>


</body>
</html>