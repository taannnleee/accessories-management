<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="style/detailProduct.css" type="text/css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
<div class = "container">
    <div class = "row">
        <div class = "col-md-5">
            <div id="carouselExample" class="carousel slide">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="images/pro001-1.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="images/pro001-2.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="images/pro001-3.jpg" class="d-block w-100" alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
        <div class = "col-md-7">
            <p class = " newarrival text-center">NEW</p>
            <h2>Converse Run hike star</h2>
            <p>Product code: PRO001</p><hr>
            <p class = "price"> 1.500.000 VND</p>
            <p><b>Availability:</b> In stock</p>
            <p><b>Condition:</b> New</p>
            <p><b>Brand:</b> Converve</p>
            <select class="size-select" aria-label="Default select example">
                <option selected>SIZE</option>
                <option value="1">38</option>
                <option value="2">38.5</option>
                <option value="3">39</option>
            </select>
            <label>Quantity:</label>
            <label>
                <input type="text" value="1">
            </label><hr>
            <button type="button" class="btn btn-default cart " >
                Add to cart
            </button>
            <button type="button" class="btn btn-default buy">
                Buy now
            </button>
        </div>
        <div class ="accordion" id="accordionPanelsStayOpenExample">
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="true" aria-controls="panelsStayOpen-collapseOne">
                        INFORMATION
                    </button>
                </h2>
                <div id="panelsStayOpen-collapseOne" class="accordion-collapse collapse show">
                    <div class="accordion-body">
                        <strong>Màu sắc: Black/White/Gum</strong>
                        Sản phẩm được thiết kế "remix" từ Chuck và Runner khi 2 yếu tố thời trang.
                        Chất liệu canvas và đế Run Star zig-zag được thiết kế với dạng răng cưa to bản, giúp tăng độ bám tạo được điểm nhấn về phong cách và ấn tượng về thời trang.
                        Lớp lót dày tạo cảm giác êm ái khi vận động, vải dày dặn, cứng form hơn.
                        Dây giày dày hơn, cùng màu với phần đế, tem gót đen 1st-tring - đặc trưng.
                        Là biểu tượng của văn hóa thể thao và các loại hình nghệ thuật đường phố kiểu Mỹ, truyền cảm hứng và sức sáng tạo mạnh mẽ đến giới trẻ trên toàn thế giới.
                        Với đôi giày này bạn có thể chọn quần jeans với áo pull đơn giản. Bạn mix theo kiểu tone xuyệt tone để mang tới sự hài hòa trong phong cách.
                    </div>
                </div>
            </div>
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseTwo" aria-expanded="false" aria-controls="panelsStayOpen-collapseTwo">
                        ...
                    </button>
                </h2>
                <div id="panelsStayOpen-collapseTwo" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <strong>...</strong>
                    </div>
                </div>
            </div>
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseThree" aria-expanded="false" aria-controls="panelsStayOpen-collapseThree">
                        ...
                    </button>
                </h2>
                <div id="panelsStayOpen-collapseThree" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <strong>...</strong>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>