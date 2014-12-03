package org.jemco.camel.sca.components;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import org.jemco.camel.sca.ApplicationComponent;

public class ComponentLoader {
	
	public List<ApplicationComponent> loadApplicationComponents(ClassLoader classLoader) {
		return loadServices(ApplicationComponent.class, classLoader);
	}
	
	private <T> List<T> loadServices(Class<T> clazz, ClassLoader classLoader) {
		
		List<T> services = new ArrayList<T>();
		ServiceLoader<T> loader = ServiceLoader.load(clazz, classLoader);
		while (loader.iterator().hasNext()) {
			T service = loader.iterator().next();
			services.add(service);
		}
		
		return services;
		
	}
	
}
