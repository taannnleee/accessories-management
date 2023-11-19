package com.example.accessoriesmanagement.controller.DTO;

public class ProductDTO {

    private Long productID;


    private String productName;


    private String productDescription;


    private double productPrice;


    private String productImage;  // Đây có thể là URL hoặc đường dẫn tới hình ảnh

    private int productQuantity;

    public ProductDTO(String productName, String productDescription, double productPrice, String productImage, int productQuantity) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productQuantity = productQuantity;
    }
    public ProductDTO() {
    }

    public Long getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
