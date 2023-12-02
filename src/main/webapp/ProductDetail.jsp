<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Detail Product</title>
    <!-- Roboto Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700&display=swap">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/bootstrap.min.css">
    <!-- Material Design Bootstrap -->
    <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb-pro.min.css">
    <!-- Material Design Bootstrap Ecommerce -->
    <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb.ecommerce.min.css">
    <!-- Your custom styles (optional) -->

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>

    <style>
        .gallery-wrap .img-big-wrap img {
            height: 450px;
            width: auto;
            display: inline-block;
            cursor: zoom-in;
        }


        .gallery-wrap .img-small-wrap .item-gallery {
            width: 60px;
            height: 60px;
            border: 1px solid #ddd;
            margin: 7px 2px;
            display: inline-block;
            overflow: hidden;
        }

        .gallery-wrap .img-small-wrap {
            text-align: center;
        }
        .gallery-wrap .img-small-wrap img {
            max-width: 100%;
            max-height: 100%;
            object-fit: cover;
            border-radius: 4px;
            cursor: zoom-in;
        }
        .img-big-wrap img{
            width: 100% !important;
            height: auto !important;
        }
    </style>
</head>
<body class="skin-light">
<jsp:include page="views/header.jsp"></jsp:include>

<div class="jumbotron color-grey-light mt-70">
    <div class="d-flex align-items-center h-100">
        <div class="container text-center py-5">
            <h3 class="mb-0"></h3>
        </div>
    </div>
</div>

<!--Main Navigation-->

<!--Main layout-->
<main>
    <div class="container">

        <!--Section: Block Content-->
        <section class="mb-5">

            <div class="row">
                <div class="col-md-6 mb-4 mb-md-0">

                    <div id="mdb-lightbox-ui"></div>

                    <div class="mdb-lightbox">

                        <div class="row product-gallery mx-1">

                            <div class="col-12 mb-0">
                                <a href="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/15a.jpg"
                                   data-size="710x823">
                                    <img src="${detail.productImage}"
                                         class="img-fluid z-depth-1" style="margin-top: -90px;">
                                </a>
                            </div>
                        </div>

                    </div>

                </div>
                <div class="col-md-6">

                    <h5><strong>${detail.productName}</strong> </h5>

                    <p><span class="mr-1"><strong>$${String.format("%.02f",detail.productPrice) }</strong></span></p>


                    <hr>

                    <form action="addCart?pid=${detail.productID }" method="post">
                        <div class="table-responsive mb-2">
                            <table class="table table-sm table-borderless">
                                <tbody>
                                <tr>
                                    <td class="pl-0 pb-0 w-25">Quantity</td>
                                    <td class="pb-0">Select size</td>
                                </tr>
                                <tr>
                                    <td class="pl-0">
                                        <div class="mt-1">
                                            <div class="def-number-input number-input safari_only mb-0" style="display: flex; align-items: center;">
                                                <button type="button" onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
                                                        class="minus"></button>
                                                <input class="quantity" min="0" name="quantity" value="1" type="number">
                                                <button type="button" onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
                                                        class="plus"></button>
                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="mt-1">
                                            <div class="form-check form-check-inline pl-0">
                                                <input type="radio" class="form-check-input" id="small" value="small" name="size" checked>
                                                <label class="form-check-label small text-uppercase card-link-secondary"
                                                       for="small">Small</label>
                                            </div>
                                            <div class="form-check form-check-inline pl-0">
                                                <input type="radio" class="form-check-input" id="medium" value="medium" name="size">
                                                <label class="form-check-label small text-uppercase card-link-secondary"
                                                       for="medium">Medium</label>
                                            </div>
                                            <div class="form-check form-check-inline pl-0">
                                                <input type="radio" class="form-check-input" id="large" value="large" name="size">
                                                <label class="form-check-label small text-uppercase card-link-secondary"
                                                       for="large">Large</label>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="mt-1">
                            <button type="submit" class="btn btn-primary btn-md mr-1 mb-2">Buy now</button>
                            <button type="submit" class="btn btn-light btn-md mr-1 mb-2"><i class="fas fa-shopping-cart pr-2"></i>Add to
                                cart</button>


                        </div>
                    </form>

                </div>
            </div>

        </section>
        <!--Section: Block Content-->

        <!-- Classic tabs -->

        <div class="classic-tabs">

            <ul class="nav tabs-primary nav-justified" id="advancedTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active show" id="description-tab" data-toggle="tab" href="#description" role="tab"
                       aria-controls="description" aria-selected="true">Description</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="info-tab" data-toggle="tab" href="#info" role="tab" aria-controls="info"
                       aria-selected="false">Information</a>
                </li>
            </ul>
            <div class="tab-content" id="advancedTabContent">
                <div class="tab-pane fade show active" id="description" role="tabpanel" aria-labelledby="description-tab">
                    <p class="pt-1">${detail.productDescription}</p>
                </div>
                <div class="tab-pane fade" id="info" role="tabpanel" aria-labelledby="info-tab">
                    <h5>Additional Information</h5>
                    <table class="table table-striped table-bordered mt-3">
                        <thead>
                        <tr>
                            <th scope="row" class="w-150 dark-grey-text h6">Category</th>
                            <td><em>${detail.product_category.categoryName}</em></td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row" class="w-150 dark-grey-text h6">Quantity in store</th>
                            <td><em>${detail.productQuantity}</em></td>
                        </tr>
                        </tbody>
                    </table>
                </div>

            </div>

        </div>

        <hr>

        <!--Section: Block Content-->
        <section class="text-center">

            <h4 class="text-center my-5"><strong>Related products</strong></h4>

            <!-- Grid row -->
            <div class="row">

                <c:forEach items="${listRelatedProduct}" var="o">
                    <!-- Grid column -->
                    <div class="col-md-6 col-lg-3 mb-5">

                        <!-- Card -->
                        <div class="">

                            <div class="view zoom overlay z-depth-2 rounded">
                                <img class="img-fluid w-100"
                                     src="${o.productImage }" alt="Sample">
                                <a href="detail?pid=${o.productID}">
                                    <div class="mask">
                                        <img class="img-fluid w-100"
                                             src="${o.productImage }">
                                        <div class="mask rgba-black-slight"></div>
                                    </div>
                                </a>
                            </div>

                            <div class="pt-4">

                                <p><span class="text-dark mr-1"><strong>${String.format("%.02f",o.productPrice) }$</strong></span></p>

                            </div>

                        </div>
                    </div>
                </c:forEach>

            </div>

        </section>
    </div>
</main>
<!--Main layout-->


<jsp:include page="views/footer.jsp"></jsp:include>

<script>
    window.addEventListener("load",function loadAmountCart(){
        $.ajax({
            url: "/WebsiteBanGiay/loadAllAmountCart",
            type: "get", //send it through get method
            data: {

            },
            success: function (responseData) {
                document.getElementById("amountCart").innerHTML = responseData;
            }
        });
    },false);
</script>
<!-- SCRIPTS -->
<!-- JQuery -->
<script src="../../../js/jquery-3.4.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/bootstrap.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.min.js"></script>
<!-- MDB Ecommerce JavaScript -->
<script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.ecommerce.min.js"></script>
<script>
    $(document).ready(function () {
        // MDB Lightbox Init
        $(function () {
            $("#mdb-lightbox-ui").load("../../../mdb-addons/mdb-lightbox-ui.html");
        });
    });
</script>
</body>
</html>
