package com.example.campaign.command;

public class AddCampaignCommand {

    private final String id;
    private final String name;

    public AddCampaignCommand(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "AddCampaignCommand{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

