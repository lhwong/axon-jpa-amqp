package com.example.campaign.controller;


import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.example.campaign.command.AddCampaignCommand;
import com.example.campaign.service.CampaignService;


@RestController
public class CampaignController {
	private static final Logger LOG = Logger.getLogger(CampaignController.class.getName());
	
	private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    
	@PostMapping("/add")
    public CompletableFuture<String> addCampaign(@RequestParam("name") String name,
    		@RequestParam("couponImageFile") MultipartFile couponImageFile,
    		@RequestParam("description") String description) {
		LOG.log(Level.INFO, "add"); 
        AddCampaignCommand command = new AddCampaignCommand(name, description);
        //LOG.info("Executing command: {}", command);
        return campaignService.addProductToCatalog(command);
    }
	

	@Autowired 
	private RestTemplate restTemplate; 
	
	@Bean 
	public RestTemplate getRestTemplate() { 
		return new RestTemplate(); 
	}  
	
	@RequestMapping(value = "/", method = RequestMethod.GET )
    public String home(OAuth2Authentication auth) {
		
		LOG.log(Level.INFO, "you called home " + auth.getName()); 
        
		return "Hello World!";
	}
	
	@RequestMapping(value = "/callhome", method = RequestMethod.GET) public String callHome() { 
	  LOG.log(Level.INFO, "calling home"); 
	  return restTemplate.getForObject("http://localhost:9002", String.class); 
	}
}
