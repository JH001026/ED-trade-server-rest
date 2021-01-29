package com.ed_trade.ed_tradeserver_rest.main.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "factions")
public class Faction {
    @Id
    private int id;
    private String name;
    private int updated_at;
    private int government_id;
    private String government;
    private int allegiance_id;
    private String allegiance;
    private int is_player_faction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(int updated_at) {
        this.updated_at = updated_at;
    }

    public int getGovernment_id() {
        return government_id;
    }

    public void setGovernment_id(int government_id) {
        this.government_id = government_id;
    }

    public String getGovernment() {
        return government;
    }

    public void setGovernment(String government) {
        this.government = government;
    }

    public int getAllegiance_id() {
        return allegiance_id;
    }

    public void setAllegiance_id(int allegiance_id) {
        this.allegiance_id = allegiance_id;
    }

    public String getAllegiance() {
        return allegiance;
    }

    public void setAllegiance(String allegiance) {
        this.allegiance = allegiance;
    }


    public int getIs_player_faction() {
        return is_player_faction;
    }

    public void setIs_player_faction(int is_player_faction) {
        this.is_player_faction = is_player_faction;
    }
}
