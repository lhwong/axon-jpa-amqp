package com.example.campaign.aggregate;

import org.axonframework.commandhandling.CommandHandler;

import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.example.campaign.command.AddCampaignCommand;
import com.example.events.campaign.CampaignAddedEvent;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class CampaignAggregate {

	private static final Logger LOG = LoggerFactory.getLogger(CampaignAggregate.class);
	
	@AggregateIdentifier
    private String id;
    private String name;
    
    public CampaignAggregate() {
    }
    
    @CommandHandler
    public CampaignAggregate(AddCampaignCommand cmd) {
        LOG.debug("Handling {} command: {}, {}", cmd.getClass().getSimpleName(), cmd.getId(), cmd.getName());
        Assert.hasLength(cmd.getId(), "ID should NOT be empty or null.");
        Assert.hasLength(cmd.getName(), "Name should NOT be empty or null.");
        apply(new CampaignAddedEvent(cmd.getId(), cmd.getName()));
        LOG.trace("Done handling {} command: {}, {}", cmd.getClass().getSimpleName(), cmd.getId(), cmd.getName());
    }

    @EventSourcingHandler
    public void on(CampaignAddedEvent evnt) {
        LOG.debug("Handling {} event: {}, {}", evnt.getClass().getSimpleName(), evnt.getId(), evnt.getName());
        this.id = evnt.getId();
        this.name = evnt.getName();
        LOG.trace("Done handling {} event: {}, {}", evnt.getClass().getSimpleName(), evnt.getId(), evnt.getName());
    }
    
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
