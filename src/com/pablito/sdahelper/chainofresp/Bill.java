package com.pablito.sdahelper.chainofresp;

public class Bill {
    private int amount;

    public Bill(final int amount) {
        this.amount = amount;
    }

    public static Bill build1DollarBill() {
        return new Bill(1);
    }

    public static Bill build10DollarBill() {
        return new Bill(10);
    }

    public static Bill build20DollarBill() {
        return new Bill(20);
    }

    public static Bill build50DollarBill() {
        return new Bill(50);
    }

    @Override
    public String toString() {
        return amount + "bill";
    }
}
