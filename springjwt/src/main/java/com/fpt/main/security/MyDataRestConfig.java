package com.fpt.main.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.fpt.main.model.User;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		
		HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
	
		config.getExposureConfiguration()
				.forDomainType(User.class) //for 1 specified class
				.withItemExposure((medata, httpMethods) -> httpMethods.disable(theUnsupportedActions)) //for 1 item
				.withCollectionExposure((medata, httpMethods) -> httpMethods.disable(theUnsupportedActions)); //for collection

	}
}
