package com.id.tick.dto.request;

/**
 * Created on 30.07.2015.
 */
public class BillOptions {
    private String owner_email;
    private String owner_phone;
    private String render_pdf;
    private String need_bar_code;
    private String need_electronic;
    private String joined_boarding_pass;
    private String need_payment_url;
    private String type;

    public String getOwner_email() {
        return owner_email;
    }

    public void setOwner_email(String owner_email) {
        this.owner_email = owner_email;
    }

    public String getOwner_phone() {
        return owner_phone;
    }

    public void setOwner_phone(String owner_phone) {
        this.owner_phone = owner_phone;
    }


    public String getRender_pdf() {
        return render_pdf;
    }

    public void setRender_pdf(String render_pdf) {
        this.render_pdf = render_pdf;
    }

    public String getNeed_bar_code() {
        return need_bar_code;
    }

    public void setNeed_bar_code(String need_bar_code) {
        this.need_bar_code = need_bar_code;
    }

    public String getNeed_electronic() {
        return need_electronic;
    }

    public void setNeed_electronic(String need_electronic) {
        this.need_electronic = need_electronic;
    }

    public String getJoined_boarding_pass() {
        return joined_boarding_pass;
    }

    public void setJoined_boarding_pass(String joined_boarding_pass) {
        this.joined_boarding_pass = joined_boarding_pass;
    }

    public String getNeed_payment_url() {
        return need_payment_url;
    }

    public void setNeed_payment_url(String need_payment_url) {
        this.need_payment_url = need_payment_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
