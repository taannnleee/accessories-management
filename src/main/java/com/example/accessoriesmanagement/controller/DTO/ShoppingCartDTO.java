package com.example.accessoriesmanagement.controller.DTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ShoppingCartDTO {

    private Long shopOrderId;

    private String transactionIdCustomer;

    private double totalPrice;
}
