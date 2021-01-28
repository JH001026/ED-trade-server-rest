package com.ed_trade.ed_tradeserver_rest.beans;

public class Listing {
    private int id;
    private int commodity_id;
    private int supply;
    private int supply_bracket;
    private int buy_price;
    private int sell_price;
    private int demand;
    private int demand_bracket;
    private int collected_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(int commodity_id) {
        this.commodity_id = commodity_id;
    }

    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    public int getSupply_bracket() {
        return supply_bracket;
    }

    public void setSupply_bracket(int supply_bracket) {
        this.supply_bracket = supply_bracket;
    }

    public int getBuy_price() {
        return buy_price;
    }

    public void setBuy_price(int buy_price) {
        this.buy_price = buy_price;
    }

    public int getSell_price() {
        return sell_price;
    }

    public void setSell_price(int sell_price) {
        this.sell_price = sell_price;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public int getDemand_bracket() {
        return demand_bracket;
    }

    public void setDemand_bracket(int demand_bracket) {
        this.demand_bracket = demand_bracket;
    }

    public int getCollected_at() {
        return collected_at;
    }

    public void setCollected_at(int collected_at) {
        this.collected_at = collected_at;
    }
}
