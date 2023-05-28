package com.example.petshop.Model.response;

public class AddToOrder {
    private int qty;
    private int product_id;
    private int order_id;

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getQty() {
        return qty;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getOrder_id() {
        return order_id;
    }
}
