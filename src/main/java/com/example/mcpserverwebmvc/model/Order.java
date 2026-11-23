package com.example.mcpserverwebmvc.model;

public class Order {
    private long orderId;
    private String product;
    private int quantity;
    private String customer;

    public Order(long orderId, String product, int quantity, String customer) {
        this.orderId = orderId;
        this.product = product;
        this.customer = customer;
        this.quantity = quantity;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
