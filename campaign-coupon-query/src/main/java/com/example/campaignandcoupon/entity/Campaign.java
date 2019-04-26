package com.example.campaignandcoupon.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Campaign {

    @Id
    String id;
    String name;

    public Campaign() {
    }

    public Campaign(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
