package com.ed_trade.ed_tradeserver_rest.main.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "listings")
public class Listing {
    @Id
    private Integer id;
    private Integer commodity_id;
    private Integer supply;
    private Integer supply_bracket;
    private Integer buy_price;
    private Integer sell_price;
    private Integer demand;
    private Integer demand_bracket;
    private Integer collected_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(Integer commodity_id) {
        this.commodity_id = commodity_id;
    }

    public Integer getSupply() {
        return supply;
    }

    public void setSupply(Integer supply) {
        this.supply = supply;
    }

    public Integer getSupply_bracket() {
        return supply_bracket;
    }

    public void setSupply_bracket(Integer supply_bracket) {
        this.supply_bracket = supply_bracket;
    }

    public Integer getBuy_price() {
        return buy_price;
    }

    public void setBuy_price(Integer buy_price) {
        this.buy_price = buy_price;
    }

    public Integer getSell_price() {
        return sell_price;
    }

    public void setSell_price(Integer sell_price) {
        this.sell_price = sell_price;
    }

    public Integer getDemand() {
        return demand;
    }

    public void setDemand(Integer demand) {
        this.demand = demand;
    }

    public Integer getDemand_bracket() {
        return demand_bracket;
    }

    public void setDemand_bracket(Integer demand_bracket) {
        this.demand_bracket = demand_bracket;
    }

    public Integer getCollected_at() {
        return collected_at;
    }

    public void setCollected_at(Integer collected_at) {
        this.collected_at = collected_at;
    }
}
