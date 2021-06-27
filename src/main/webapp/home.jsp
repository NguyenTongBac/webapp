<%--
  Created by IntelliJ IDEA.
  User: tongb
  Date: 6/13/2021
  Time: 9:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/view/css/homeStyle.css">
    <script src="https://kit.fontawesome.com/c8e4d183c2.js" crossorigin="anonymous"></script>
    <style>
        .navbar-nav {
            float: right;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-inverse" style="position: relative!important;">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">NoteWeb</a>
        </div>
        <ul class="nav navbar-nav">
            <ul class="nav navbar-nav navbar-right">
                <form class="navbar-form navbar-left" action="/search" method="post">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search" name="searchTileNote">
                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit">
                                <i class="glyphicon glyphicon-search"></i>
                            </button>
                        </div>
                    </div>
                </form>
                <li><a href="add.jsp">Create new note</a> </li>
                <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in" style=""></span> Login</a></li>
            </ul>
        </ul>
    </div>
</nav>
<button type="button" class="btn btn-primary button button5" data-toggle="modal" data-target="#exampleModal1" data-whatever="@fat">Create new note</button>
<div class="modal fade" id="exampleModal1" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Create box</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="create" method="post">
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">Title:</label>
                        <input type="text" class="form-control" id="recipient-name" name="tileNote">
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Note:</label>
                        <input class="form-control" id="message-text" name="note">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Create</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<c:forEach items="${listS}" var="x">
    <div class="container">
        <div class="table-title">
            <h3>Note ${x.id}</h3>
        </div>
        <table class="table-fill">
            <thead>
            <tr>
                <th class="text-left">Title</th>
                <td class="text-left table-hover">${x.tileNote}</td>
            </tr>
            <tr>
                <th class="text-left">Note</th>
                <td class="text-left table-hover">${x.note}</td>
            </tr>
            </thead>
        </table>


        <div style="margin: auto; max-width: 600px">

                <%--        delete--%>
            <button type="button" class="btn btn-primary button button1" data-toggle="modal"
                    data-target="#exampleModalCenter">
                Delete
            </button>

            <!-- Modal -->
            <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
                 aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalCenterTitle">Modal title</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Do you want to delete ?
                        </div>
                        <form action="delete" method="post">
                            <div>
                                <input name="id" value="${x.id}" style="display: none">
                            </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                            <button type="submit" class="btn btn-primary">Yes</button>
                        </div>
                        </form>
                    </div>
                </div>
            </div>

                <%--            edit--%>
            <button type="button" class="btn btn-primary button button3" data-toggle="modal" data-target="#exampleModal"
                    data-whatever="@getbootstrap">Edit
            </button>
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Edit</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="update" method="post">
                                <div class="form-group" style="display: none">
                                    <p class="col-form-label">Id:</p>
                                    <input type="text" class="form-control" value="${x.id}" name="id">
                                </div>
                                <div class="form-group">
                                    <p class="col-form-label">Title:</p>
                                    <input type="text" class="form-control" value="${x.tileNote}" name="tileNote">
                                </div>
                                <div class="form-group">
                                    <label for="message-text" class="col-form-label">Note:</label>
                                    <input class="form-control" value="${x.note}" name="note">
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary">Save change</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</c:forEach>
</body>
</html>

