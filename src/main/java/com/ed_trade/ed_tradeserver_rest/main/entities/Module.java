package com.ed_trade.ed_tradeserver_rest.main.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Module {

    @Id
    private Integer id;
    private Integer group_id;
    private Float price;
    private String name;
    private Integer ed_id;
    private String ed_symbol;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEd_id() {
        return ed_id;
    }

    public void setEd_id(Integer ed_id) {
        this.ed_id = ed_id;
    }

    public String getEd_symbol() {
        return ed_symbol;
    }

    public void setEd_symbol(String ed_symbol) {
        this.ed_symbol = ed_symbol;
    }
}
