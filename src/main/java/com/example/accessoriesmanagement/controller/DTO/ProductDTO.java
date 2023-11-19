package com.example.accessoriesmanagement.controller.DTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ProductDTO {

    private Long productID;


    private String productName;


    private String productDescription;


    private double productPrice;


    private String productImage;  // Đây có thể là URL hoặc đường dẫn tới hình ảnh

    private int productQuantity;

}
