package com.example.accessoriesmanagement.entity;

import javax.persistence.*;

@Entity
public class ShopOrderLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_order_line_item_id")
    private Long shopOrderLineItemId;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "size")
    private String size;

    @ManyToOne
    @JoinColumn(name = "shop_order_id")
    private ShopOrder shopOrder;

    public ShopOrderLineItem() {

    }

    public Long getShopOrderLineItemId() {
        return shopOrderLineItemId;
    }



    public String getQuantity() {
        return quantity;
    }

    public String getSize() {
        return size;
    }

    public ShopOrder getShopOrder() {
        return shopOrder;
    }

    public void setShopOrderLineItemId(Long shopOrderLineItemId) {
        this.shopOrderLineItemId = shopOrderLineItemId;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setShopOrder(ShopOrder shopOrder) {
        this.shopOrder = shopOrder;
    }

    public ShopOrderLineItem(Long shopOrderLineItemId, String quantity, String size, ShopOrder shopOrder) {
        this.shopOrderLineItemId = shopOrderLineItemId;
        this.quantity = quantity;
        this.size = size;
        this.shopOrder = shopOrder;
    }

}
