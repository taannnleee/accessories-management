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
            background-image: url('https://ananas.vn/wp-content/uploads/Web1920-1.jpeg');
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-position: center center;
        }

        .carousel-item:nth-child(2) {
            background-image: url('https://scontent.fsgn8-4.fna.fbcdn.net/v/t39.30808-6/357067741_2238790339624823_8319242517451226013_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeEYMfzZVXg5ruxFRM-sryxl6rjV4rhOG57quNXiuE4bnqQJ4Xbkix19tygYrt1KN7w11vR5hU9V1DUG_2JfnYGI&_nc_ohc=lDh8vKh9WwQAX-RGWQQ&_nc_ht=scontent.fsgn8-4.fna&oh=00_AfCNRHwABlH45hsg-PxbfOHoICMDJEOIhkv0eHPquL1Fww&oe=65691868');
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-position: center center;
        }

        .carousel-item:nth-child(3) {
            background-image: url('https://ananas.vn/wp-content/uploads/Hi-im-Mule_1500x800-Mobile.jpg');
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
        <img style="height:55px; width:64px; margin: auto;" src="https://eadn-wc05-10929864.nxedge.io/wp-content/uploads/2023/08/ecommerce-concept-transportation-shipment-delivery-by-truck-3d-illustration.jpg">
        <div class="card-body">
            <h5 class="card-title" style="text-align:center">GIAO HÀNG TOÀN QUỐC</h5>
            <p class="card-text" style="text-align:center">VẬN CHUYỂN KHẮP VIỆT NAM</p>
        </div>
    </div>
    <div class="card" style="border-style: none;">
        <img class="card-img-top" style="height:55px; width:64px; margin: auto;" src="https://www.clio.com/wp-content/uploads/2022/11/Illustration_Blog_Lawyer-Payment-Methods.png" alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title" style="text-align:center">THANH TOÁN KHI NHẬN HÀNG</h5>
            <p class="card-text" style="text-align:center">NHẬN HÀNG TẠI NHÀ RỒI THANH TOÁN</p>
        </div>
    </div>
    <div class="card" style="border-style: none;">
        <img class="card-img-top" style="height:55px; width:64px; margin: auto;" src="https://giadinh.mediacdn.vn/k:2016/1580415-1476688882450/baohanhvabaodamkhacnhaunhuthenao.jpg" alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title" style="text-align:center">BẢO HÀNH DÀI HẠN</h5>
            <p class="card-text" style="text-align:center">BẢO HÀNG LÊN ĐẾN 60 NGÀY</p>
        </div>
    </div>
    <div class="card" style="border-style: none;">
        <img class="card-img-top" style="height:55px; width:64px; margin: auto;" src="https://media.istockphoto.com/id/1170465736/vector/shop-delivery-receive-parcel-pick-up-point-return-order-to-store-send-back-purchase.jpg?s=612x612&w=0&k=20&c=KRA3kIbYkMWILA3Rd7mT7gUDgWkj3pmYtJ4fibj2Xk8=" alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title" style="text-align:center">ĐỔI HÀNG DỄ DÀNG</h5>
            <p class="card-text" style="text-align:center">ĐỔI HÀNG THOẢI MÁI TRONG 30 NGÀY</p>
        </div>
    </div>
</div>


<div class="container">
    <div class="row" style="margin-top:25px">
        <h1 style="text-align:center; width:100%" id="moiNhat">SẢN PHẨM MỚI NHẤT</h1>
        <div class="col-sm-12">
                <div id="contentMoiNhat" class="row">
                    <c:forEach items="${allP}" var="product">
                        <div class=" col-12 col-md-6 col-lg-3">
                            <div class="card">
                                <div class="view zoom z-depth-2 rounded">
                                    <img class="img-fluid w-100" src="${product.productImage}" alt="Card image cap">

                                </div>
                                <div class="card-body">
                                    <h4 class="card-title show_txt"><a href="detail?pid=${product.productID}" title="View Product">${product.productName}</a></h4>
                                    <p class="card-text show_txt">${product.productDescription}</p>
                                    <div class="row">

                                        <div class="col-lg-6">
                                            <p class="btn btn-success">${product.productPrice}$</p>
                                        </div>
                                        <div class="col-lg-6">
                                            <form action="add_to_cart" method="post">
<%--=======--%>
<%--                                        <div class="col">--%>
<%--                                            <form action="detail_product" method="post">--%>
<%-->>>>>>> Cart--%>
                                                <input type="hidden" name="product_id" value="${product.productID}" >
                                                <button type="submit" class="btn btn-success">CART</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </c:forEach>
                </div>
        </div>

    </div>


    <div class="row" style="margin-top:25px">
        <h1 style="text-align:center; width:100%" id="nike">GIÀY ADIDAS MỚI NHẤT</h1>
        <div class="col-sm-12">
            <div id="contentNike" class="row">
                <c:forEach items="${allA}" var="product">
                    <div class="productNike col-12 col-md-6 col-lg-3">
                        <div class="card">
                            <div class="view zoom z-depth-2 rounded">
                                <img class="img-fluid w-100" src="${product.productImage}" alt="Card image cap">
                            </div>
                            <div class="card-body">
                                <h4 class="card-title show_txt"><a href="detail?pid=${product.productID}" title="View Product">${product.productName}</a></h4>
                                <p class="card-text show_txt">${product.productDescription}</p>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <p class="btn btn-success">${product.productPrice}$</p>
                                    </div>
                                    <div class="col-lg-6">
                                        <form action="add_to_cart" method="post">
                                            <input type="hidden" name="product_id" value="${product.productID}" >
                                            <button type="submit" class="btn btn-success">CART</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="text-center">
                <button onclick="loadMoreNike()" class="btn btn-primary ">Load more</button>
            </div>
        </div>
    </div>


    <div class="row" style="margin-top:25px">
        <h1 style="text-align:center; width:100%" id="adidas">GIÀY NIKE MỚI NHẤT</h1>
        <div class="col-sm-12">
            <div id="contentAdidas" class="row">
                <c:forEach items="${allN}" var="product">
                    <div class="productNike col-12 col-md-6 col-lg-3">
                        <div class="card">
                            <div class="view zoom z-depth-2 rounded">
                                <img class="img-fluid w-100" src="${product.productImage}" alt="Card image cap">
                            </div>
                            <div class="card-body">
                                <h4 class="card-title show_txt"><a href="detail?pid=${product.productID}" title="View Product">${product.productName}</a></h4>
                                <p class="card-text show_txt">${product.productDescription}</p>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <p class="btn btn-success">${product.productPrice}$</p>
                                    </div>
                                    <div class="col-lg-6">
                                        <form action="add_to_cart" method="post">
                                            <input type="hidden" name="product_id" value="${product.productID}" >
                                            <button type="submit" class="btn btn-success">CART</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="text-center">
                <button onclick="loadMoreNike()" class="btn btn-primary ">Load more</button>
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

<script>
    function loadMoreNike() {
        // Mở trang web của Nike trong cửa sổ mới
        window.open("https://www.nike.com/", "_blank");
    }
</script>

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
