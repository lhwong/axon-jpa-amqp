package com.example.campaign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

//import brave.sampler.Sampler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableResourceServer
@EnableDiscoveryClient
@EnableSwagger2
/*@ComponentScan(basePackages = {"com.seveneleven.campaign"})
@EntityScan(basePackages = {"com.seveneleven.campaign",
        "org.axonframework.eventsourcing.eventstore.jpa",
        "org.axonframework.eventhandling.saga.repository.jpa",
        "org.axonframework.eventhandling.tokenstore.jpa"})*/
public class CampaignCommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampaignCommandApplication.class, args);
	}

	
	@Bean
	public Docket swaggerPersonApi10() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.seveneleven.campaign.controller"))
					.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Campaign API").description("Documentation Campaign API v1.0").build());
	}
	
	/*@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}*/

	
	
}
