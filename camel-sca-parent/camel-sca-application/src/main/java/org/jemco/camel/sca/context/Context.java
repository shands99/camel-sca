package org.jemco.camel.sca.context;

import org.apache.camel.CamelContext;
import org.jemco.camel.sca.ApplicationComponent;

public interface Context {

	void clear();
	
	CamelContext getCamelContext();
	
	void setCamelContext(CamelContext context);
	
	void addApplicationComponent(ApplicationComponent ap);
		
	
}
