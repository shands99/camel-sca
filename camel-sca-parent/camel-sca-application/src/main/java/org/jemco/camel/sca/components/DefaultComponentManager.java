package org.jemco.camel.sca.components;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jemco.camel.sca.ApplicationComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultComponentManager implements ComponentManager {

	private Logger log = LoggerFactory.getLogger(DefaultComponentManager.class);
	
	private final ComponentLoader componentLoader;
	
	private Map<String, ApplicationComponent> componentTypeMap = new HashMap<String, ApplicationComponent>();
	
	public DefaultComponentManager() {
		super();
		this.componentLoader = new ComponentLoader();
	}
	
	public ApplicationComponent getComponent(String type) {
		return this.componentTypeMap.get(type);
	}

	public void load() {
		clear();
		List<ApplicationComponent> components = componentLoader.loadApplicationComponents(getClass().getClassLoader());
		for (ApplicationComponent component : components) {
			if (componentTypeMap.containsKey(component.getType())) {
				log.debug("Component type [" + component.getType() + "] already initialised.");
			}
		}
	}

	public void clear() {
		if (componentTypeMap != null) {
			componentTypeMap.clear();
		}
	}

	
}
