<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="entity.Users"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Category</title>

        <!-- Custom fonts for this template-->
        <link href="dataWeb/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="dataWeb/css/sb-admin-2.min.css" rel="stylesheet">
        
        <!-- Custom styles for this page -->
        <link href="dataWeb/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    </head>

    <body id="page-top">
        <%
            Users loginedInfo
                    = (Users) session.getAttribute("acc");
            if (loginedInfo == null) {%>
        <jsp:forward page="index.jsp" />

        <% } %>



        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class="fas fa-laugh-wink"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">Admin Management</div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Nav Item - Dashboard -->
                <li class="nav-item">
                    <a class="nav-link" href="dashboard.jsp">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Dashboard</span></a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Nav Item - Product Management Collapse Menu -->
                <li class="nav-item active">
                    <a class="nav-link" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                        <i class="fas fa-fw fa-cog"></i>
                        <span>Management</span>
                    </a>
                    <div id="collapseTwo" class="collapse show" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">---------------------</h6>
                            <a class="collapse-item" href="DishCategoryServlet?action=showPage">DishCategory</a>
                            <a class="collapse-item" href="DishServlet?action=showPage">Dishes</a>
                            <a class="collapse-item" href="RestaurantServlet?action=showPage">Restaurant</a>
                            <a class="collapse-item" href="AddressServlet?action=showPage">Address</a> 
                            <a class="collapse-item" href="UserServlet?action=showPage">User</a>
                            <a class="collapse-item" href="CustomerServlet?action=showPage">Customer</a>
                            <a class="collapse-item" href="OfferServlet?action=showPage">Offer</a> 
                            <a class="collapse-item" href="OrderServlet?action=showPage">Order</a> 
                            <h6 class="collapse-header">---------------------</h6>
                        </div>
                    </div>
                </li>    
            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">
                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">
                                        <%
                                            loginedInfo
                                                    = (Users) session.getAttribute("acc");
                                            out.print(loginedInfo.getFullName());%>
                                    </span>
                                    <img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="UserServlet?action=detaillogin">
                                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Edit Profile
                                    </a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Logout
                                    </a>
                                </div>
                            </li>

                        </ul>

                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">
                        <h1 class="h3 mb-4 text-gray-800">${noteShowPage}</h1>
                       
                        
                        <div class="card shadow mb-4">
             
                            <div class="card-header py-3">
                              <h6 class="m-0 font-weight-bold text-primary">ADDRESS LIST</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                       <a href="AddressServlet?action=showInsert" class="btn btn-primary" style="witdh:200px;margin-bottom: 10px ;">Insert</a>
                               
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Street</th>
                                                <th>Ward</th>
                                                <th>District</th>
                                                <th>Citi</th>
                                                <th>Longtitude</th>
                                                <th>latitude</th>
                                                <th>Created At</th>
                                                
       
                                                <th style="width: auto">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${list}" var="item">
                                                <tr>
                                                    <td>${item.id}</td>
                                                    <td>${item.street}</td>
                                                    <td>${item.ward}</td>
                                                    <td>${item.district}</td>
                                                    <td>${item.cities}</td>
                                                    <td>${item.longtitude}</td>
                                                    <td>${item.latitude}</td>
                                                    <td><fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${item.createdAt}"/></td>
                                                    <td><a class="btn btn-danger" onclick="return checkDelete()" href="DishCategoryServlet?action=delete&&id=${item.id}">Delete</a>
                                                        <a class="btn btn-success" href="DishCategoryServlet?action=detail&&id=${item.id}">Update</a>

                                                    </td>
                                                </tr>

                                            </c:forEach>



                                        </tbody>
                                    </table>

                                    <script type = "text/javascript">
                                        function checkDelete() {
                                            
                                            var result = confirm("If click ok will delete Caterogy!!");

                                            if (result) {
                                                return true;
                                            } else {
                                                return false;
                                            }


                                            return true;
                                        }
                                    </script>
                                </div>
                            </div>
                        </div>
                    </div>
        <!-- End of Page Wrapper -->
        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="LogoutServlet?action=logout">Logout</a>
                    </div>
                </div>
            </div>
        </div>

         <!-- Bootstrap core JavaScript-->
        <script src="dataWeb/vendor/jquery/jquery.min.js"></script>
        <script src="dataWeb/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="dataWeb/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="dataWeb/js/sb-admin-2.min.js"></script>

        <!-- Page level plugins -->
        <script src="dataWeb/vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="dataWeb/vendor/datatables/dataTables.bootstrap4.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="dataWeb/js/demo/datatables-demo.js"></script>

    </body>

</html>

