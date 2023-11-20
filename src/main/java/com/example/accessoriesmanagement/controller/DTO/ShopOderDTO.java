package com.example.accessoriesmanagement.controller.DTO;

import javax.persistence.*;
import java.util.Date;

public class ShopOderDTO {

    private Long shopOrderId;

    private Date orderDate;

    private double totalPrice;

    private String orderStatus;

    private String addressShipping;
}
