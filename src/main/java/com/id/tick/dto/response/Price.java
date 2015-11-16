package com.id.tick.dto.response;

/**
 * Created on 31.07.2015.
 */
public class Price {
    private int total;
    private int tax;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }
}
