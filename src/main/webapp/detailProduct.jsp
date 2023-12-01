<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">


    <style>
        body {
            margin: 0 auto;
            font-family: sans-serif;
        }

        .container {
            width: 90%;
            margin: auto;
        }

        .productImg {
            float: left;
            width: 50%;
        }

        .productImg img {
            height: 500px;
            width: 500px;
        }

        .productDetails {
            background-color: #f8f8f8;
            float: left;
            width: 50%;
            border-radius: 6px;
        }

        div.proLabel {
            padding: 20px;
            font-weight: bold;
            background-color: #f8f8f8;
            font-size: 1.5rem;
        }

        .wrapper {
            padding: 20px;
            overflow: hidden;
        }

        .left,
        .right {
            width: 50%;
            float: left;
        }

        @media (max-width: 600px) {

            .productImg,
            .productDetails {
                width: 100%;
            }
        }

        .qnty {
            padding: 2rem;
            font-size: 1.5rem;
        }

        .spanBtn {
            background-color: #e6e6e6;
            padding: 20px;
            margin: -5px;
            cursor: pointer;
        }

        .spanBtn:hover {
            background-color: #d3d3d3;
            padding: 20px;
            margin: -5px;
            cursor: pointer;
        }

        .spanBtnNo {
            background-color: #fff;
            padding: 20px;
            margin: -5px;
        }

        a {
            text-decoration: none;
        }

        div.body {
            background-color: #f8f8f8;
            padding: 10px;
        }

        .pos {
            width: 24%;
            float: left;
        }

        .posBody {
            padding: 10px;
            margin: 1px;
            text-align: center;
            cursor: pointer;
        }

        .posBody:hover {
            background-color: #d3d3d3;
            padding: 10px;
            margin: 1px;
            text-align: center;
            transition-duration: 2s;
        }

        @media (max-width: 600px) {

            .pos {
                width: 50%;
            }
        }
    </style>
</head>

<body>
<div class="main">
    <div class="proLabel">
            <span>
                Product Details
            </span>
    </div>
    <!-- This Div for products details with image -->
    <div class="container">
        <div class="wrapper">
            <div class="productImg">
                <img src="${pageContext.request.contextPath}/static/${productDetail.productImage}"
                     alt="Example Image"/>
            </div>
            <div class="productDetails">
                <div style="padding: 20px;">
                    <!-- Product Title -->
                    <div class="proLabel">
                        <span><p><c:out value="${productDetail.productName}"/></p></span>
                    </div>
                    <div class="wrapper">
                        <div class="left">
                            <ion-icon style="color: orange" name="star"></ion-icon>
                            <ion-icon style="color: orange" name="star"></ion-icon>
                            <ion-icon style="color: orange" name="star"></ion-icon>
                            <ion-icon style="color: orange" name="star"></ion-icon>
                            <ion-icon style="color: orange" name="star-outline"></ion-icon>
                            <span style="color: #1a9cb7; font-size: .8rem;">100 Rating</span><br/>
                            <span style="color: #1a9cb7; font-size: .8rem;"><a href="#">Visit Official
                                        Website</a></span>
                        </div>
                        <div class="rgiht">
                            <ion-icon style="font-size: 20px;" name="share-social-outline"></ion-icon>
                            <ion-icon style="font-size: 20px;" name="heart-outline"></ion-icon>
                        </div>
                    </div>
                    <hr style="opacity: .2;"/>
                    <div style="padding: 1.5rem;">
                        <span style="color: red; font-size: 1.5rem;">-10%</span>
                        <span style="color: black; font-size: 2rem;"><p><c:out
                                value="${productDetail.productPrice}"/></p></span>
                    </div>
                    <hr style="opacity: .2;"/>
                    <div style="padding: 10px;">
                        <span>Color:</span>
                        <span style="color: red;">Red</span>
                        <span style="color: blue;">Blue</span>
                        <span style="color: yellow;">yellow</span>
                    </div>
                    <hr style="opacity: .2;"/>


                    <form action="add_to_cart" method="post">
                        <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                            <a th:for="quantity" style="display: flex; margin-left: 25px">Quantity</a>
                            <div style="display: flex; align-items: center;">
                                <button type="button" class="btn btn-link px-2"
                                        onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                    <i class="fas fa-minus"></i>
                                </button>
                                <input id="form1" min="1" name="quantity" th:value="1" type="number"
                                       class="form-control form-control-sm"/>
                                <button type="button" class="btn btn-link px-2"
                                        onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                                    <i class="fas fa-plus"></i>
                                </button>
                            </div>
                        </div>


                        <input type="hidden" name="product_id" value="${productDetail.productID}">
                        <button style="background-color: orange; padding: 1rem; text-align: center; color: white; margin: 1px; cursor: pointer; border-radius: 5px; width: 500px; display: inline-block;">
                            Add to cart
                        </button>
                    </form>


                    <button style="background-color: #2abbe8; padding: 1rem; text-align: center; color: white; margin: 1px; cursor: pointer; border-radius: 5px;width: 500px; display: inline-block;">
                        Buy Now
                    </button>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="body">
            <div style="background-color: #fff; padding: 1rem; margin: 1rem;">
                <span style=" font-weight: bold;">Delivery</span><br/>
                <div style="padding: 1rem;">
                    <span>Pokhara Valley: </span><span style="color: red;">Free</span><br/>
                    <span>Outside Valley: </span><span style="color: red;">Rs. 180</span><br/><br/>
                    <span>Your Product will be in your door within 3 - 7 Days.</span><br/>
                    <span>Note: Cash on Delivery is avaible</span>
                </div>
            </div>


            <div style="background-color: #fff; padding: 1rem; margin: 1rem;">
                <span style=" font-weight: bold;">iPhone 14 Specification</span><br/>
                <div style="padding: 1rem;">
                    <p>The iPhone 14 retains the same design as its predecessor. That means a big notch on the front
                        and camera lenses aligned diagonally on the back. The entire body is made of aerospace-grade
                        aluminum and is water and dust resistant to IP68 standards.</p>
                    <p>Announced: 2022, September 07</p>
                    <p>Dimensions: 146.7 x 71.5 x 7.8 mm (5.78 x 2.81 x 0.31 in)</p>
                    <p>Weight: 172 g (6.07 oz)</p>
                    <p>Type: Super Retina XDR OLED, HDR10, Dolby Vision, 800 nits (HBM), 1200 nits (peak)</p>
                    <p>Size: 6.1 inches, 90.2 cm2 (~86.0% screen-to-body ratio)</p>
                    <p>Resolution: 1170 x 2532 pixels, 19.5:9 ratio (~460 ppi density)</p>
                    <p>OS: iOS 16, upgradable to iOS 16.4.1</p>
                    <p>Chipset: Apple A15 Bionic (5 nm)</p>
                </div>
            </div>


            <div style="background-color: #fff; padding: 1rem; margin: 1rem;">
                <span style=" font-weight: bold;">Related Products</span><br/>
                <div style="padding: 1rem;">
                    <div class="wrapper">
                        <div class="pos">
                            <div class="posBody">
                                <img style="width: 100px; height: 100px;" src="images/iphone 14.jpg" alt="">
                                <p>iPhone 13 | 128 GB</p>
                                <p style="color: red;">Rs. 1,10,000</p>
                            </div>
                        </div>
                        <div class="pos">
                            <div class="posBody">
                                <img style="width: 100px; height: 100px;" src="images/sumsung a.jpg" alt="">
                                <p>Samsung A | 128 GB</p>
                                <p style="color: red;">Rs. 1,00,000</p>
                            </div>
                        </div>
                        <div class="pos">
                            <div class="posBody">
                                <img style="width: 100px; height: 100px;" src="images/iphone 14.jpg" alt="">
                                <p>iPhone 13 | 128 GB</p>
                                <p style="color: red;">Rs. 1,10,000</p>
                            </div>
                        </div>
                        <div class="pos">
                            <div class="posBody">
                                <img style="width: 100px; height: 100px;" src="images/sumsung a.jpg" alt="">
                                <p>Samsung A | 128 GB</p>
                                <p style="color: red;">Rs. 1,00,000</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    </div>
</div>


<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
        <div class="item active">
            <img src="https://i.ibb.co/0JKpmgd/blue.png" alt="Los Angeles">
        </div>

        <div class="item">
            <img src="https://i.ibb.co/0JKpmgd/blue.png" alt="Chicago">
        </div>

        <div class="item">
            <img src="https://i.ibb.co/0JKpmgd/blue.png" alt="New York">
        </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<!-- ionicon -->
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>

</html>