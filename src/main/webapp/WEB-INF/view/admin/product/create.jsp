<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>

        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        <script>
            $(document).ready(() => {
                const productFile = $("#productFile");
                productFile.change(function (e) {
                    const imgURL = URL.createObjectURL(e.target.files[0]);
                    $("#productPreview").attr("src", imgURL);
                    $("#productPreview").css({ "display": "block" });
                });
            });
        </script>

    </head>
    <body class="sb-nav-fixed">
        <jsp:include page="../layout/header.jsp"/>

        <div id="layoutSidenav">
            <jsp:include page="../layout/sidebar.jsp"/>

            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Create Product</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item "><a href="/admin">Dashdoard</a></li>
                            <li class="breadcrumb-item active">Product</li>
                        </ol>
                        <div class=" mt-5">
                            <!-- Content here -->
                             <div class="col-md-6 col-12 mx-auto">
                                <h1 class="text-center">Create Product</h1>
                                <form:form method="post" action="/admin/product/create" modelAttribute="createProduct" class="row" enctype="multipart/form-data">
                                    <div class="mb-3 col-12 col-md-6">
                                        <label for="name" class="form-label">Name</label>
                                        <form:input type="text" class="form-control" path="name"/>
                                    </div>
                                
                                    <div class="mb-3 col-12 col-md-6">
                                        <label for="price" class="form-label">Price</label>
                                        <form:input type="text" class="form-control" path="price"/>
                                    </div>
                                
                                    <div class="mb-3 col-12">
                                        <label for="detailDesc" class="form-label">Detail Description:</label>
                                        <form:input type="text" class="form-control" path="detailDesc"/>
                                    </div>
                                
                                    <div class="mb-3 col-12 col-md-6">
                                        <label for="shortDesc" class="form-label">Short Description:</label>
                                        <form:input type="text" class="form-control" path="shortDesc"/>
                                    </div>
                                
                                    <div class="mb-3 col-12 col-md-6">
                                        <label for="quantity" class="form-label">Quantity:</label>
                                        <form:input type="number" class="form-control" path="quantity"/>
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                        <label class="form-label">Factory:</label>
                                        <form:select class="form-select" path="factory">
                                            <form:option value="Apple (MACBOOK)">Apple (MACBOOK)</form:option>
                                            <form:option value="Asus">Asus</form:option>
                                            <form:option value="Lenovo">Lenovo</form:option>
                                            <form:option value="Dell">Dell</form:option>
                                            <form:option value="LG">LG</form:option>
                                            <form:option value="Acer">Acer</form:option>

                                        </form:select>
                                    </div>
                                    <div class="mb-3 col-12 col-md-6">
                                        <label class="form-label">Target:</label>
                                        <form:select class="form-select" path="target">
                                            <form:option value="GAMING">Gaming</form:option>
                                            <form:option value="SINH-VIEN-VAN-PHONG">Sinh viên - Văn phòng</form:option>
                                            <form:option value="THIET-KE-DO-HOA">Thiết kế đồ họa</form:option>
                                            <form:option value="MONG-NHE">Mỏng nhẹ</form:option>
                                            <form:option value="DOANH-NHAN">Doanh nhân</form:option>

                                        </form:select>
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                        <label for="productFile" class="form-label">Image:</label>
                                        <input type="file" class="form-control" id="productFile" name="productFile"
                                        accept=".png, .jpg, .jpeg"/>
                                    </div>
                                
                                    <div class="mb-3 col-12">
                                        <img style="max-height: 250px; display: none;" alt="product preview" 
                                        id="productPreview"/>
                                    </div>
                                    <div class="md-5 col-12">
                                        <button type="submit" class="btn btn-primary">Create</button>

                                    </div>
                                </form:form>
                                
                             </div>
                    
                        </div>
                    </div>
                </main>
                <jsp:include page = "../layout/footer.jsp"/>

            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="/js/scripts.js"></script>
  
    </body>
</html>




















