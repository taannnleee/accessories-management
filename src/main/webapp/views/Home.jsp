<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home Page</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ------>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/footer.css" rel="stylesheet" type="text/css"/>

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" />
    <!-- Google Fonts Roboto -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" />
    <!-- MDB -->
    <link rel="stylesheet" href="css/mdb.min.css" />
    <!-- Custom styles -->
    <link rel="stylesheet" href="css/style.css" />

    <!-- Roboto Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700&display=swap">
    Font Awesome
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    Bootstrap core CSS
    <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/bootstrap.min.css">
    Material Design Bootstrap
    <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb-pro.min.css">
    Material Design Bootstrap Ecommerce
    <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb.ecommerce.min.css">
    <!-- Your custom styles (optional) -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <style>
        /* Carousel styling */
        #introCarousel,
        .carousel-inner,
        .carousel-item,
        .carousel-item.active {
            height: 100vh;
        }

        .carousel-item:nth-child(1) {
            background-image: url('https://file.hstatic.net/1000230642/file/banner__1__9831c8de62ca4121b4f3caa18164f352_master.jpg');
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-position: center center;
        }

        .carousel-item:nth-child(2) {
            background-image: url('https://file.hstatic.net/1000230642/file/web-top-banner_68b9a0c957374772bdf25d1d0f312b11_master.jpg');
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-position: center center;
        }

        .carousel-item:nth-child(3) {
            background-image: url('https://file.hstatic.net/1000230642/file/banner_central_opt_2_76f1c057c7dc43ee9c8a36c6bee9ac4d_master.jpg');
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-position: center center;
        }

        /* Height for devices larger than 576px */
        @media (min-width: 992px) {
            #introCarousel {
                margin-top: -58.59px;
            }
        }

        .navbar .nav-link {
            color: #fff !important;
        }
    </style>

</head>
<body class="skin-light" onload="loadAmountCart()">
<jsp:include page="header.jsp"></jsp:include>



<!-- Carousel wrapper -->
<div id="introCarousel" class="carousel slide carousel-fade shadow-2-strong" data-mdb-ride="carousel" style="margin-top:35px;">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-mdb-target="#introCarousel" data-mdb-slide-to="0" class="active"></li>
        <li data-mdb-target="#introCarousel" data-mdb-slide-to="1"></li>
        <li data-mdb-target="#introCarousel" data-mdb-slide-to="2"></li>
    </ol>

    <div class="carousel-inner">
        <div class="carousel-item active">

        </div>

        <div class="carousel-item">

        </div>

        <div class="carousel-item">

        </div>
    </div>

    <a class="carousel-control-prev" href="#introCarousel" role="button" data-mdb-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#introCarousel" role="button" data-mdb-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<div class="card-group" style="margin-top:50px;">
    <div class="card" style="border-style: none;">
        <img style="height:55px; width:64px; margin: auto;" src="https://giayxshop.vn/wp-content/uploads/2019/11/iconfinder_truck_1291768-1.png">
        <div class="card-body">
            <h5 class="card-title" style="text-align:center">GIAO HÀNG TOÀN QUỐC</h5>
            <p class="card-text" style="text-align:center">VẬN CHUYỂN KHẮP VIỆT NAM</p>
        </div>
    </div>
    <div class="card" style="border-style: none;">
        <img class="card-img-top" style="height:55px; width:64px; margin: auto;" src="https://giayxshop.vn/wp-content/uploads/2019/11/iconfinder_payment_1954199-3.png" alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title" style="text-align:center">THANH TOÁN KHI NHẬN HÀNG</h5>
            <p class="card-text" style="text-align:center">NHẬN HÀNG TẠI NHÀ RỒI THANH TOÁN</p>
        </div>
    </div>
    <div class="card" style="border-style: none;">
        <img class="card-img-top" style="height:55px; width:64px; margin: auto;" src="https://giayxshop.vn/wp-content/uploads/2019/11/iconfinder_service_repair_phone_mobile_wrench_screw_driver_4014703-1.png" alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title" style="text-align:center">BẢO HÀNH DÀI HẠN</h5>
            <p class="card-text" style="text-align:center">BẢO HÀNG LÊN ĐẾN 60 NGÀY</p>
        </div>
    </div>
    <div class="card" style="border-style: none;">
        <img class="card-img-top" style="height:55px; width:64px; margin: auto;" src="https://giayxshop.vn/wp-content/uploads/2019/11/iconfinder_refresh_3017918-1.png" alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title" style="text-align:center">ĐỔI HÀNG DỄ DÀNG</h5>
            <p class="card-text" style="text-align:center">ĐỔI HÀNG THOẢI MÁI TRONG 30 NGÀY</p>
        </div>
    </div>
</div>


<div class="container">

<%--    Cái này của Hậu tao đóng lại test thử nha--%>


<%--    <div class="row" style="margin-top:25px">--%>
<%--        <h1 style="text-align:center; width:100%" id="moiNhat">SẢN PHẨM MỚI NHẤT</h1>--%>
<%--        <div class="col-sm-12">--%>
<%--            <div id="contentMoiNhat" class="row">--%>
<%--                <c:forEach items="${list8Last}" var="o">--%>
<%--                    <div class=" col-12 col-md-6 col-lg-3">--%>
<%--                        <div class="card">--%>
<%--                            <div class="view zoom z-depth-2 rounded">--%>
<%--                                <img class="img-fluid w-100" src="${o.image}" alt="Card image cap">--%>

<%--                            </div>--%>
<%--                            <div class="card-body">--%>
<%--                                <h4 class="card-title show_txt"><a href="detail?pid=${o.id}" title="View Product">${o.name}</a></h4>--%>
<%--                                <p class="card-text show_txt">${o.title}</p>--%>
<%--                                <div class="row">--%>
<%--                                    <div class="col">--%>
<%--                                        <p class="btn btn-success btn-block">${o.price} $</p>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </c:forEach>--%>
<%--            </div>--%>

<%--        </div>--%>

<%--    </div>--%>
    <div class="row" style="margin-top:25px">
        <h1 style="text-align:center; width:100%" id="moiNhat">SẢN PHẨM MỚI NHẤT</h1>
        <c:forEach var="product" items="${products}">
            <div class="card rounded-3 mb-4">
                <div class="card-body p-4">
                    <div class="row align-items-center">
                        <div class="col-md-2 col-lg-2 col-xl-2">
                            <img src="${pageContext.request.contextPath}/static/${product.productImage}"
                                 alt="Example Image"/>
                        </div>
                        <div class="col-md-3 col-lg-3 col-xl-3">
                            <div class="row align-items-center">
                                <div class="col-12">
                                    <a>Name</a>
                                </div>
                                <div class="col-12">
                                    <h5 style="position: relative; margin-top: 10px" class="mb-0">
                                        <p><c:out value="${product.productName}"/></p>
                                    </h5>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-2 col-lg-2 col-xl-2">
                            <div class="row align-items-center">
                                <div class="col-12">
                                    <a>Quantity</a>
                                </div>
                                <div class="col-12">
                                    <h5 style="position: relative; margin-top: 10px" class="mb-0">
                                        <input type="hidden" name="quantity" value="${product.productQuantity}">
                                        <p><c:out value="${product.productQuantity}"/></p>
                                    </h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 col-lg-3 col-xl-3">
                            <div class="row align-items-center">
                                <div class="col-12">
                                    <a>Price</a>
                                </div>
                                <div class="col-12">
                                    <h5 style="position: relative; margin-top: 10px" class="mb-0">
                                        <p><c:out value="${product.productPrice}"/></p>
                                    </h5>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-2 col-lg-2 col-xl-2">

                            <form action="add_to_cart" method="post">
                                <input type="hidden" name="product_id" value="${product.productID}">
                                <input type="hidden" name="action" value="addToCart">
                                <button type="submit" class="btn btn-success mb-2 w-100">
                                    <i class="fas fa-cart-plus"></i> Add to Cart
                                </button>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </c:forEach>
    </div>


    <div class="row" style="margin-top:25px">
        <h1 style="text-align:center; width:100%" id="nike">GIÀY NIKE MỚI NHẤT</h1>
        <div class="col-sm-12">
            <div id="contentNike" class="row">
                <c:forEach items="${list4NikeLast}" var="o">
                    <div class="productNike col-12 col-md-6 col-lg-3">
                        <div class="card">
                            <div class="view zoom z-depth-2 rounded">
                                <img class="img-fluid w-100" src="${o.image}" alt="Card image cap">
                            </div>
                            <div class="card-body">
                                <h4 class="card-title show_txt"><a href="detail?pid=${o.id}" title="View Product">${o.name}</a></h4>
                                <p class="card-text show_txt">${o.title}</p>
                                <div class="row">
                                    <div class="col">
                                        <p class="btn btn-success btn-block">${o.price} $</p>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <button onclick="loadMoreNike()" class="btn btn-primary">Load more</button>
        </div>
    </div>


    <div class="row" style="margin-top:25px">
        <h1 style="text-align:center; width:100%" id="adidas">GIÀY ADIDAS MỚI NHẤT</h1>
        <div class="col-sm-12">
            <div id="contentAdidas" class="row">
                <c:forEach items="${list4AdidasLast}" var="o">
                    <div class="productAdidas col-12 col-md-6 col-lg-3">
                        <div class="card">
                            <div class="view zoom z-depth-2 rounded">
                                <img class="img-fluid w-100" src="${o.image}" alt="Card image cap">
                            </div>
                            <div class="card-body">
                                <h4 class="card-title show_txt"><a href="detail?pid=${o.id}" title="View Product">${o.name}</a></h4>
                                <p class="card-text show_txt">${o.title}</p>
                                <div class="row">
                                    <div class="col">
                                        <p class="btn btn-success btn-block">${o.price} $</p>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <button onclick="loadMoreAdidas()" class="btn btn-primary">Load more</button>
        </div>
    </div>


    <div class="row" style="margin-top:50px">
        <div class="col-sm-12">
            <div id="content" class="row">
                <div class=" col-12 col-md-12 col-lg-6">
                    <div class="card-body">
                        <h4 class="card-title show_txt" style="text-align:center; font-size:18pt; color:#b57b00;">Về chúng tôi</h4>
                        <h2 class="card-title show_txt" style="text-align:center; font-size:24pt;">Shoes Family</h2>
                        <p style="text-align:center;">Uy tín lâu năm chuyên cung cấp giày thể thao sneaker nam, nữ hàng Replica 1:1 -
                            Like Auth với chất lượng đảm bảo và giá tốt nhất tại Hà Nội, tpHCM.</p>
                        <p>Bạn đang cần tìm một đôi giày thể thao sneaker đẹp và hợp thời trang và đang hot Trends
                            đến từ các thương hiệu lớn nhưng lại không đủ hầu bao để sắm được hàng chính hãng?
                            Hãy đến với ShoesFamily – nơi bạn thỏa lòng mong ước mà chỉ phải chi ra 1 phần nhỏ so với dòng chính hãng ngoài store
                            mà vẫn sắm cho mình được một đôi chất lượng từ rep 1:1 đến siêu cấp like auth.</p>
                    </div>
                </div>
                <div class=" col-12 col-md-12 col-lg-6">
                    <img class="card-img-top" src="https://shopgiayreplica.com/wp-content/uploads/2020/11/shop-giay-replica-1-1.jpg" alt="Card image cap">
                </div>
            </div>
        </div>
    </div>





</div>

<jsp:include page="footer.jsp"></jsp:include>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>



<!-- MDB -->
<script type="text/javascript" src="js/mdb.min.js"></script>
<!-- Custom scripts -->
<script type="text/javascript" src="js/script.js"></script>

<!-- SCRIPTS -->
<!-- JQuery -->
<script src="https://mdbootstrap.com/previews/ecommerce-demo/js/jquery-3.4.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/bootstrap.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.min.js"></script>
<!-- MDB Ecommerce JavaScript -->
<script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.ecommerce.min.js"></script>
</body>
</html>

