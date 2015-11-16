package com.id.tick.dto.response;

/**
 * Created on 31.07.2015.
 */
public class Invoice {
    private String id;
    private String sale_point_name;
    private String asps_code;
    private String asps_code_2;
    private String asps_code_3;
    private byte state;
    private byte is_electronic;
    private Price price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSale_point_name() {
        return sale_point_name;
    }

    public void setSale_point_name(String sale_point_name) {
        this.sale_point_name = sale_point_name;
    }

    public String getAsps_code() {
        return asps_code;
    }

    public void setAsps_code(String asps_code) {
        this.asps_code = asps_code;
    }

    public String getAsps_code_2() {
        return asps_code_2;
    }

    public void setAsps_code_2(String asps_code_2) {
        this.asps_code_2 = asps_code_2;
    }

    public String getAsps_code_3() {
        return asps_code_3;
    }

    public void setAsps_code_3(String asps_code_3) {
        this.asps_code_3 = asps_code_3;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public byte getIs_electronic() {
        return is_electronic;
    }

    public void setIs_electronic(byte is_electronic) {
        this.is_electronic = is_electronic;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
