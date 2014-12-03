package org.jemco.camel.sca.components;

import org.jemco.camel.sca.ApplicationComponent;

public interface ComponentManager {

	void load();
	
	void clear();
	
	ApplicationComponent getComponent(String type);
	
}
