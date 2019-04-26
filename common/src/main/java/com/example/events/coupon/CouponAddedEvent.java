package com.example.events.coupon;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CouponAddedEvent {

	@TargetAggregateIdentifier
	private final String id;
	private final String campaignId;
	private final String phoneNumber;

	public CouponAddedEvent(String id, String campaignId, String phoneNumber) {
		this.id = id;
		this.campaignId = campaignId;
		this.phoneNumber = phoneNumber;

	}

	public String getId() {
		return id;
	}

	public String getCampaignId() {
		return campaignId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	
	

}
