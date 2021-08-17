<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Users"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Dish-detail</title>

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

                        <!-- Page Heading -->
                        <h1 class="h3 mb-4 text-gray-800">${noteInsertCatePage}</h1>
                            <div class="container">

                            <!-- Outer Row -->
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4" style="font-weight: bold">UPDATE DETAIL DISH</h1>
                                </div>

                                <form class="user" action="DishServlet?action=update" method="POST" enctype="multipart/form-data">

                                    <div class="form-group">
                                        <input type="text" name="id" value="${d.id}" hidden="true" class="form-control" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Enter ID Caterogy...">
                                    </div>

                                    <div class="form-group row">
                                        <span style="font-weight: bold;width: 15%; margin:auto">name:</span><input type="text" name="fullname" required="true" pattern=".{0,30}" value="${d.name}"class="form-control" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Enter Name Caterogy..." style="width:85%">
                                    </div>
                                    <div class="form-group row">
                                        <span style="font-weight: bold;width: 15%; margin:auto">Price:</span><input type="text" value="${d.price}" name="price"  pattern=".{0,30}"class="form-control" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Enter Price..." style="width:85%" required="true">
                                    </div>
                                    <div class="form-group row">
                                        <span style="font-weight: bold;width: 15%; margin:auto">Unit:</span><input type="text" name="unit" value="${d.unit}"  pattern=".{0,30}"class="form-control" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Enter..." style="width:85%" required="true">
                                    </div>
                                    <div class="form-group row">
                                        <span style="font-weight: bold;width: 15%; margin:auto">Note:</span><input type="text" name="note" value="${d.note}"  pattern=".{0,30}"class="form-control" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Enter..." style="width:85%" required="true">
                                    </div>
                                    <div class="form-group row">
                                        <span style="font-weight: bold;width: 15%; margin:auto">Delivered:</span><input type="text" name="note" value="${d.delivered}"  pattern=".{0,30}"class="form-control" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Enter..." style="width:85%" required="true">
                                    </div>
                                    
               
                                    <!-- select Dishcategory -->
                                   
                                    <div class="form-group row">
                                        <span style="font-weight: bold;width: 15%; margin:auto">Category:</span>
                                        <select id="category" required="true" class="form-control" name="category" style="width:85%">
                                            <c:forEach items="${listDC}" var="item1">       
                                                <option id="${item1.id}" value="${item1.id}" >${item1.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>               
                                    
                                     <!-- select Restaurant -->
                                   
                                   <div class="form-group row">
                                        <span style="font-weight: bold;width: 15%; margin:auto">Restaurant</span>

                                        <select id="prdCate" required="true" class="form-control" name="restaurant" style="width:85%">
                                            <c:forEach items="${listRes}" var="item2">       
                                                <option id="${item2.id}" value="${item2.id}" >${item2.fullName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group row">
                                        <span style="font-weight: bold;width: 15%; margin:auto">Status:</span>
                                            <select id="isActive" required="true" class="form-control" name="isActive" style="width:85%">
                                                <c:choose>
                                                    <c:when test="${d.isActive==false}">
                                                        <option value="true" >Active</option>
                                                        <option value="false" selected="true" >Not active</option>
                                                    </c:when>  

                                                    <c:otherwise>
                                                        <option value="true" selected="true" >Active</option>
                                                        <option value="false" >Not active</option>
                                                    </c:otherwise>
                                            </c:choose>


                                        </select>
                                    </div>
                                    <!-- anh -->
                                    <div class="form-group">
                                        <img src="${d.imgUrl}" id="thumbnil" width="300dx" height="200px"/>
                                    </div>
                                    <div class="form-group">
                                        <input type="file" onchange="showMyImage(this)" class="form-control form-control-file" name="image"/>
                                    </div>
                                    <script language="javascript">

                                        function showMyImage(fileInput) {
                                            var files = fileInput.files;
                                            for (var i = 0; i < files.length; i++) {
                                                var file = files[i];
                                                var imageType = /image.*/;
                                                if (!file.type.match(imageType)) {
                                                    continue;
                                                }
                                                var img = document.getElementById("thumbnil");
                                                img.file = file;
                                                var reader = new FileReader();
                                                reader.onload = (function (aImg) {
                                                    return function (e) {
                                                        aImg.src = e.target.result;
                                                    };
                                                })(img);
                                                reader.readAsDataURL(file);
                                            }
                                        }
                                    </script>

                                    <input type="submit" value="Update" class="btn btn-primary btn-user btn-block">

                                </form>

                                <hr>

                            </div>

                        </div>
                    </div>
                <!-- End of Main Content -->

                <!-- Footer -->
                <footer class="sticky-footer bg-white">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span></span>
                        </div>
                    </div>
                </footer>
                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

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

    </body>

</html>

                
