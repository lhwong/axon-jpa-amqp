package com.example.events.campaign;


import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.serialization.Revision;

@Revision("1.0")
public class CampaignAddedEvent {
	
	@TargetAggregateIdentifier
	private String id;
    private String name;

    public CampaignAddedEvent() {
    }

    public CampaignAddedEvent(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

}
