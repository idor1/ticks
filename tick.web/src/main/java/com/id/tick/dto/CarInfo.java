package com.id.tick.dto;

/**
 * Created on 30.07.2015.
 */
public class CarInfo {
    private String tos_name;
    private String tos_id;
    private String class_id;
    private String car_id;
    private String car_type;
    private String car_sub_type;
    private String schema_id;
    private int free_count;
    private int busy_count;

    public String getTos_name() {
        return tos_name;
    }

    public void setTos_name(String tos_name) {
        this.tos_name = tos_name;
    }

    public String getTos_id() {
        return tos_id;
    }

    public void setTos_id(String tos_id) {
        this.tos_id = tos_id;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public String getCar_sub_type() {
        return car_sub_type;
    }

    public void setCar_sub_type(String car_sub_type) {
        this.car_sub_type = car_sub_type;
    }

    public String getSchema_id() {
        return schema_id;
    }

    public void setSchema_id(String schema_id) {
        this.schema_id = schema_id;
    }

    public int getFree_count() {
        return free_count;
    }

    public void setFree_count(int free_count) {
        this.free_count = free_count;
    }

    public int getBusy_count() {
        return busy_count;
    }

    public void setBusy_count(int busy_count) {
        this.busy_count = busy_count;
    }
}
