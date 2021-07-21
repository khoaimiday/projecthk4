package com.fpt.main.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.fpt.main.entity.User;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{
	
	private EntityManager entityManager;
	
	@Autowired
	public MyDataRestConfig(EntityManager _entityManager) {
		entityManager = _entityManager;
	}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		
		HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
	
		config.getExposureConfiguration()
				.forDomainType(User.class) //for 1 specified class
				.withItemExposure((medata, httpMethods) -> httpMethods.disable(theUnsupportedActions)) //for 1 item
				.withCollectionExposure((medata, httpMethods) -> httpMethods.disable(theUnsupportedActions)); //for collection

		
		// call an internal helper method
		exposeId(config);
	}

	private void exposeId(RepositoryRestConfiguration config) {
		
		// expose entity ids	
		// get a list of all entity classes from the entity manager
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
		
		// create an array of the entities type
		List<Class> entityClasses = new ArrayList<>();
		
		//get the entity types for the entities 
		for (EntityType tempEntityType : entities) {
			entityClasses.add(tempEntityType.getJavaType());
		}
		
		// expose the entity ids for the array of entity/domain types
		Class[] domainTypes = entityClasses.toArray(new Class[entityClasses.size()]);
		config.exposeIdsFor(domainTypes);
		
	}
}
