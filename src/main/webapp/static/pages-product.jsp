<%-- 
    Document   : pages-blank.jsp
    Created on : Mar 26, 2022, 3:44:02 PM
    Author     : XuanQuy
--%>

<%@page import="java.util.List"%>
<%@page import="DTO.CategoryDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Responsive Admin &amp; Dashboard Template based on Bootstrap 5">
        <meta name="author" content="AdminKit">
        <meta name="keywords" content="adminkit, bootstrap, bootstrap 5, admin, dashboard, template, responsive, css, sass, html, theme, front-end, ui kit, web">

        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/icons/react.png" />


        <link rel="canonical" href="https://demo-basic.adminkit.io/pages-category.jsp" />

        <title>Product Page</title>

        <link href="${pageContext.request.contextPath}/static/css/app.css" rel="stylesheet" type="text/css" />


        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">


        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

        <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">-->
        <!--        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>-->

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/category.css"/>

    </head>


    <body>
        <%
            String name = (String) session.getAttribute("name");
        %>
        <div class="wrapper">
            <nav id="sidebar" class="sidebar js-sidebar">
                <div class="sidebar-content js-simplebar">
                    <a class="sidebar-brand" href="static/dashboard.jsp">
                        <span class="align-middle">AdminKit</span>
                    </a>

                    <ul  class="sidebar-nav">
                        <li class="sidebar-header">
                            Pages
                        </li>

                        <li class="sidebar-item">
                            <a style="text-decoration: none;
                               font-size: 14px" class="sidebar-link" href="${pageContext.request.contextPath}/static/dashboard.jsp">
                                <i class="align-middle" data-feather="sliders"></i> <span class="align-middle">Dashboard</span>
                            </a>
                        </li>

                        <li class="sidebar-item">
                            <a style="text-decoration: none;
                               font-size: 14px" class="sidebar-link" href="${pageContext.request.contextPath}/static/pages-profile.jsp">
                                <i class="align-middle" data-feather="user"></i> <span class="align-middle">Profile</span>
                            </a>
                        </li>

                        <li class="sidebar-item">
                            <a style="text-decoration: none;
                               font-size: 14px"  class="sidebar-link" href="${pageContext.request.contextPath}/AdminUserController">
                                <i class="align-middle" data-feather="users"></i> <span class="align-middle">Users</span>
                            </a>
                        </li>

                        <li class="sidebar-item active">
                            <a style="text-decoration: none;
                               font-size: 14px"  class="sidebar-link"  href="${pageContext.request.contextPath}/AdminProductController">
                                <i class="align-middle" data-feather="user-plus"></i> <span class="align-middle">Products</span>
                            </a>
                        </li>

                        <li class="sidebar-item">
                            <a style="text-decoration: none;
                               font-size: 14px"  class="sidebar-link" href="${pageContext.request.contextPath}/AdminCategoryController">
                                <i class="align-middle" data-feather="book"></i> <span class="align-middle">Category</span>
                            </a>
                        </li>

                        <li class="sidebar-header">
                            Tools & Components
                        </li>

                        <li class="sidebar-item">
                            <a  style="text-decoration: none;
                                font-size: 14px" class="sidebar-link" href="${pageContext.request.contextPath}/static/ui-buttons.html">
                                <i class="align-middle" data-feather="square"></i> <span class="align-middle">Button</span>
                            </a>
                        </li>

                        <li class="sidebar-item">
                            <a style="text-decoration: none;
                               font-size: 14px" class="sidebar-link" href="ui-forms.html">
                                <i class="align-middle" data-feather="check-square"></i> <span class="align-middle">Forms</span>
                            </a>
                        </li>

                        <li class="sidebar-item">
                            <a style="text-decoration: none;
                               font-size: 14px" class="sidebar-link" href="ui-cards.html">
                                <i class="align-middle" data-feather="grid"></i> <span class="align-middle">Cards</span>
                            </a>
                        </li>

                        <li class="sidebar-item">
                            <a style="text-decoration: none;
                               font-size: 14px" class="sidebar-link" href="ui-typography.html">
                                <i class="align-middle" data-feather="align-left"></i> <span class="align-middle">Typography</span>
                            </a>
                        </li>

                        <li class="sidebar-item">
                            <a style="text-decoration: none;
                               font-size: 14px" class="sidebar-link" href="icons-feather.html">
                                <i class="align-middle" data-feather="coffee"></i> <span class="align-middle">Icons</span>
                            </a>
                        </li>

                        <li class="sidebar-header">
                            Plugins & Addons
                        </li>

                        <li class="sidebar-item">
                            <a style="text-decoration: none;
                               font-size: 14px" class="sidebar-link" href="charts-chartjs.html">
                                <i class="align-middle" data-feather="bar-chart-2"></i> <span class="align-middle">Charts</span>
                            </a>
                        </li>

                        <li class="sidebar-item">
                            <a style="text-decoration: none;
                               font-size: 14px" class="sidebar-link" href="maps-google.html">
                                <i class="align-middle" data-feather="map"></i> <span class="align-middle">Maps</span>
                            </a>
                        </li>
                    </ul>

                    <div class="sidebar-cta">
                        <div class="sidebar-cta-content">
                            <strong class="d-inline-block mb-2">Upgrade to Pro</strong>
                            <div class="mb-3 text-sm">
                                Are you looking for more components? Check out our premium version.
                            </div>
                            <div class="d-grid">
                                <a href="upgrade-to-pro.html" class="btn btn-primary">Upgrade to Pro</a>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>

            <div  class="main">
                <nav class="navbar navbar-expand navbar-light navbar-bg">
                    <a class="sidebar-toggle js-sidebar-toggle">
                        <i class="hamburger align-self-center"></i>
                    </a>

                    <div class="navbar-collapse collapse">
                        <ul class="navbar-nav navbar-align">
                            <li class="nav-item dropdown">
                                <a class="nav-icon dropdown-toggle" href="#" id="alertsDropdown" data-bs-toggle="dropdown">
                                    <div class="position-relative">
                                        <i class="align-middle" data-feather="bell"></i>
                                        <span class="indicator">4</span>
                                    </div>
                                </a>
                                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-end py-0" aria-labelledby="alertsDropdown">
                                    <div class="dropdown-menu-header">
                                        4 New Notifications
                                    </div>
                                    <div class="list-group">
                                        <a href="#" class="list-group-item">
                                            <div class="row g-0 align-items-center">
                                                <div class="col-2">
                                                    <i class="text-danger" data-feather="alert-circle"></i>
                                                </div>
                                                <div class="col-10">
                                                    <div class="text-dark">Update completed</div>
                                                    <div class="text-muted small mt-1">Restart server 12 to complete the update.</div>
                                                    <div class="text-muted small mt-1">30m ago</div>
                                                </div>
                                            </div>
                                        </a>
                                        <a href="#" class="list-group-item">
                                            <div class="row g-0 align-items-center">
                                                <div class="col-2">
                                                    <i class="text-warning" data-feather="bell"></i>
                                                </div>
                                                <div class="col-10">
                                                    <div class="text-dark">Lorem ipsum</div>
                                                    <div class="text-muted small mt-1">Aliquam ex eros, imperdiet vulputate hendrerit et.</div>
                                                    <div class="text-muted small mt-1">2h ago</div>
                                                </div>
                                            </div>
                                        </a>
                                        <a href="#" class="list-group-item">
                                            <div class="row g-0 align-items-center">
                                                <div class="col-2">
                                                    <i class="text-primary" data-feather="home"></i>
                                                </div>
                                                <div class="col-10">
                                                    <div class="text-dark">Login from 192.186.1.8</div>
                                                    <div class="text-muted small mt-1">5h ago</div>
                                                </div>
                                            </div>
                                        </a>
                                        <a href="#" class="list-group-item">
                                            <div class="row g-0 align-items-center">
                                                <div class="col-2">
                                                    <i class="text-success" data-feather="user-plus"></i>
                                                </div>
                                                <div class="col-10">
                                                    <div class="text-dark">New connection</div>
                                                    <div class="text-muted small mt-1">Christina accepted your request.</div>
                                                    <div class="text-muted small mt-1">14h ago</div>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                    <div class="dropdown-menu-footer">
                                        <a href="#" class="text-muted">Show all notifications</a>
                                    </div>
                                </div>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-icon dropdown-toggle" href="#" id="messagesDropdown" data-bs-toggle="dropdown">
                                    <div class="position-relative">
                                        <i class="align-middle" data-feather="message-square"></i>
                                    </div>
                                </a>
                                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-end py-0" aria-labelledby="messagesDropdown">
                                    <div class="dropdown-menu-header">
                                        <div class="position-relative">
                                            4 New Messages
                                        </div>
                                    </div>
                                    <div class="list-group">
                                        <a href="#" class="list-group-item">
                                            <div class="row g-0 align-items-center">
                                                <div class="col-2">
                                                    <img src="img/avatars/avatar-5.jpg" class="avatar img-fluid rounded-circle" alt="Vanessa Tucker">
                                                </div>
                                                <div class="col-10 ps-2">
                                                    <div class="text-dark">Vanessa Tucker</div>
                                                    <div class="text-muted small mt-1">Nam pretium turpis et arcu. Duis arcu tortor.</div>
                                                    <div class="text-muted small mt-1">15m ago</div>
                                                </div>
                                            </div>
                                        </a>
                                        <a href="#" class="list-group-item">
                                            <div class="row g-0 align-items-center">
                                                <div class="col-2">
                                                    <img src="img/avatars/avatar-2.jpg" class="avatar img-fluid rounded-circle" alt="William Harris">
                                                </div>
                                                <div class="col-10 ps-2">
                                                    <div class="text-dark">William Harris</div>
                                                    <div class="text-muted small mt-1">Curabitur ligula sapien euismod vitae.</div>
                                                    <div class="text-muted small mt-1">2h ago</div>
                                                </div>
                                            </div>
                                        </a>
                                        <a href="#" class="list-group-item">
                                            <div class="row g-0 align-items-center">
                                                <div class="col-2">
                                                    <img src="img/avatars/avatar-4.jpg" class="avatar img-fluid rounded-circle" alt="Christina Mason">
                                                </div>
                                                <div class="col-10 ps-2">
                                                    <div class="text-dark">Christina Mason</div>
                                                    <div class="text-muted small mt-1">Pellentesque auctor neque nec urna.</div>
                                                    <div class="text-muted small mt-1">4h ago</div>
                                                </div>
                                            </div>
                                        </a>
                                        <a href="#" class="list-group-item">
                                            <div class="row g-0 align-items-center">
                                                <div class="col-2">
                                                    <img src="img/avatars/avatar-3.jpg" class="avatar img-fluid rounded-circle" alt="Sharon Lessman">
                                                </div>
                                                <div class="col-10 ps-2">
                                                    <div class="text-dark">Sharon Lessman</div>
                                                    <div class="text-muted small mt-1">Aenean tellus metus, bibendum sed, posuere ac, mattis non.</div>
                                                    <div class="text-muted small mt-1">5h ago</div>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                    <div class="dropdown-menu-footer">
                                        <a href="#" class="text-muted">Show all messages</a>
                                    </div>
                                </div>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-icon dropdown-toggle d-inline-block d-sm-none" href="#" data-bs-toggle="dropdown">
                                    <i class="align-middle" data-feather="settings"></i>
                                </a>

                                <a class="nav-link dropdown-toggle d-none d-sm-inline-block" href="#" data-bs-toggle="dropdown">
                                    <img src="${pageContext.request.contextPath}/static/img/avatars/avt.jpg" class="avatar img-fluid rounded me-1" alt="Charles Hall" /> <span  class="text-dark"><%=name%></span>
                                </a>
                                <div style="width: 200px" class="dropdown-menu dropdown-menu-end">
                                    <a style="font-size: 14px" class="dropdown-item" href="pages-profile.jsp"><i class="align-middle me-1" data-feather="user"></i> Profile</a>
                                    <a style="font-size: 14px" class="dropdown-item" href="#"><i class="align-middle me-1" data-feather="pie-chart"></i> Analytics</a>
                                    <div class="dropdown-divider"></div>
                                    <a style="font-size: 14px" class="dropdown-item" href="dashboard.jsp"><i class="align-middle me-1" data-feather="settings"></i> Settings & Privacy</a>
                                    <a style="font-size: 14px" class="dropdown-item" href="#"><i class="align-middle me-1" data-feather="help-circle"></i> Help Center</a>
                                    <div class="dropdown-divider"></div>
                                    <form class="preview-item-content" method="get" action="${pageContext.request.contextPath}/LogoutController" >
                                        <button class="dropdown-item">Logout</button>
                                    </form>
                                </div>
                            </li>
                        </ul>
                    </div>
                </nav>

                <main style="padding: 0; width: 100%"  class="content">
                    <div class="container-fluid p-0">

                        <div class="container" style="max-width: 1400px">
                            <div class="table-wrapper">
                                <div class="table-title">
                                    <div class="row">
                                        <div  class="col-sm-6">
                                            <h2 style="color: white">Manage <b style="color: white">Product</b></h2>
                                        </div>
                                        <div class="col-sm-6">
                                            <a href="#addEmployeeModal" id="btnCreate" class="btn btn-success" onclick="ResetValue()" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>
                                            <a href="#deleteEmployeeModalll"  class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
                                        </div>
                                    </div>
                                </div>
                                <table class="table table-striped table-hover" id="catTable">
                                    <thead>
                                        <tr>
                                            <th>
                                                <span class="custom-checkbox">
                                                    <input type="checkbox" id="selectAll">
                                                    <label for="selectAll"></label>
                                                </span>
                                            </th>
                                            <th  >Name</th>
                                            <th class="col" >Image</th>
                                            <th  >Price</th>
                                            <th  >Description</th>
                                            <th  > Action</th>
                                            <!--<th>Actions</th>-->
                                        </tr>
                                    </thead>
                                    <%
                                        System.out.println("list: " + request.getAttribute("list"));
                                    %>
                                    <tbody>

                                        <c:forEach  items="${list}" var="cat" >
                                            <tr data-id="${cat.getId()}">
                                                <td>
                                                    <span class="custom-checkbox">
                                                        <input type="checkbox" id="checkbox1" name="options[]" value="1">
                                                        <label for="checkbox1"></label>
                                                    </span>
                                                </td>
                                                <td>${cat.getName()}</td>
                                                <td>${cat.getImage()}</td>
                                                <td>${cat.getPrice()}</td>
                                                <td>${cat.getDescription()}</td>

                                                <!--<td>(171) 555-2222</td>-->
                                                <td>
                                                    <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" onclick="EditProduct(${cat.getId()}, {
                                                                'name': '${cat.getName()}',
                                                                'image': '${cat.getImage()}',
                                                                'price': '${cat.getPrice()}',
                                                                'description': ` ${cat.getDescription()}`,

                                                            })" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                                    <a href="#deleteEmployeeModalll" class="delete" onclick="DeleteProduct(${cat.getId()})"  data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                                    <!--<a onclick="onDlt(${cat.getId()})" > click </a>-->
                                                </td>
                                            </tr>
                                        </c:forEach>

                                    </tbody>
                                </table>
                                <div class="clearfix">
                                    <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                                    <ul class="pagination">
                                        <li class="page-item disabled"><a href="#">Previous</a></li>
                                        <li class="page-item"><a href="#" class="page-link">1</a></li>
                                        <li class="page-item"><a href="#" class="page-link">2</a></li>
                                        <li class="page-item active"><a href="#" class="page-link">3</a></li>
                                        <li class="page-item"><a href="#" class="page-link">4</a></li>
                                        <li class="page-item"><a href="#" class="page-link">5</a></li>
                                        <li class="page-item"><a onclick="abc()" href="#" class="page-link">Next</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <!-- Edit Modal HTML -->
                        <div id="addEmployeeModal" class="modal fade">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <form method="post" action="${pageContext.request.contextPath}/AdminCategoryController"   id="productForm">
                                        <div class="modal-header">						
                                            <h4 class="modal-title">View Product</h4>
                                            <button type="button" class="close" data-dismiss="modal"  aria-hidden="true">&times;</button>
                                        </div>
                                        <div class="modal-body">					
                                            <div class="form-group">

                                                <input type="hidden" class="form-control" id="txtId" name="id" >
                                                <label>Name</label>
                                                <input type="text" id="txtName" name="name"  class="form-control" >
                                            </div>
                                            <span style="color: red;font-size: 12px;font-style: italic" class="error" id="error-name"></span>
                                            <div class="form-group">
                                                <label>Image</label>
                                                <input type="text" id="txtImage"  name="image" class="form-control" >
                                            </div>
                                            <span style="color: red;font-size: 12px;font-style: italic" class="error" id="error-image"></span>
                                            <div class="form-group">
                                                <label>Price</label>
                                                <input type="text" id="txtPrice"  name="price" class="form-control" >
                                            </div>
                                            <span style="color: red;font-size: 12px;font-style: italic" class="error" id="error-price"></span>
                                            <div class="form-group">
                                                <label>Description</label>
                                                <textarea class="form-control" name="desc" id="txtDesc" ></textarea>
                                            </div>
                                            <span style="color: red;font-size: 12px;font-style: italic" class="error" id="error-desc"></span>

                                        </div>
                                        <div class="modal-footer">
                                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                            <button type="submit" class="btn btn-success"   > Save  </button>
                                        </div>
                                    </form>


                                </div>
                            </div>
                        </div>

                        <!-- Delete Modal HTML -->
                        <div id="deleteEmployeeModal" class="modal fade">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <form>
                                        <div class="modal-header">						
                                            <h4 class="modal-title">Delete Product</h4>
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        </div>
                                        <div class="modal-body">					
                                            <p>Are you sure you want to delete these Records?</p>
                                            <p class="text-warning"><small>This action cannot be undone.</small></p>
                                        </div>
                                        <div class="modal-footer">
                                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                            <input type="submit" class="btn btn-danger" value="Delete">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>
                </main>


                <footer class="footer">
                    <div class="container-fluid">
                        <div class="row text-muted">
                            <div class="col-6 text-start">
                                <p class="mb-0">
                                    <a class="text-muted" href="https://adminkit.io/" target="_blank"><strong>AdminKit</strong></a> &copy;
                                </p>
                            </div>
                            <div class="col-6 text-end">
                                <ul class="list-inline">
                                    <li class="list-inline-item">
                                        <a class="text-muted" href="https://adminkit.io/" target="_blank">Support</a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a class="text-muted" href="https://adminkit.io/" target="_blank">Help Center</a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a class="text-muted" href="https://adminkit.io/" target="_blank">Privacy</a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a class="text-muted" onclick="abc()"  target="_blank">Terms</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>

        </div>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-toast-plugin/1.3.2/jquery.toast.css" integrity="sha512-8D+M+7Y6jVsEa7RD6Kv/Z7EImSpNpQllgaEIQAtqHcI0H6F4iZknRj0Nx1DCdB+TwBaS+702BGWYC0Ze2hpExQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <!--<script src="./js/category.js"></script>-->


        <script type="text/javascript" src="${pageContext.request.contextPath}/static/vendor/js/helpers.js"></script>

        <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/config.js"></script>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

        <script type="text/javascript" src="${pageContext.request.contextPath}/static/vendor/css/toast.css"></script>

        <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.toast.min.js"></script>

        <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/product.js"></script>



    </body>

</html>