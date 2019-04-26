package com.example.campaign.service;

import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.campaign.command.AddCampaignCommand;

@Service
public class CampaignService{

    private static final Logger LOG = LoggerFactory.getLogger(CampaignService.class);

    private final CommandGateway commandGateway;

    public CampaignService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> addProductToCatalog(AddCampaignCommand command) {
        LOG.debug("Processing AddProductToCatalogCommand command: {}", command);
        return this.commandGateway.send(command);
    }
}
