package org.jemco.camel.sca;

import java.util.List;

import org.apache.camel.CamelContext;
import org.jemco.camel.sca.context.Context;
import org.jemco.camel.sca.model.Composite;

public abstract class BaseScaApplication {
	
	private Context scaContext;
		
	private ComponentManager componentManager
	
	protected void init(List<Composite> composites) {
		
		// create context - can be overridden in specific implementations.
		scaContext = loadScaContext();
		scaContext.setCamelContext(loadCamelContext());
		
		for (Composite composite : composites) {
			
		}
		
	}
	
	abstract protected CamelContext loadCamelContext();
	
	abstract protected Context loadScaContext();
	
	protected void loadComponents(Composite composite) {
		
	}
	
}
