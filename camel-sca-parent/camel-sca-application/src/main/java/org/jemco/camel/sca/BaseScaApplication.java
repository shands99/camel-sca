package org.jemco.camel.sca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.jemco.camel.sca.components.ComponentLoader;
import org.jemco.camel.sca.components.ComponentManager;
import org.jemco.camel.sca.components.ComponentStartedEvent;
import org.jemco.camel.sca.components.DefaultComponentManager;
import org.jemco.camel.sca.context.Context;
import org.jemco.camel.sca.event.EventBus;
import org.jemco.camel.sca.event.EventBusFactory;
import org.jemco.camel.sca.model.Binding;
import org.jemco.camel.sca.model.Component;
import org.jemco.camel.sca.model.Composite;
import org.jemco.camel.sca.model.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseScaApplication {
	
	private Logger log = LoggerFactory.getLogger(BaseScaApplication.class);
	
	private Context scaContext;
	
	private final ComponentManager componentManager;
	
	private final EventBus eventBus;
		
	public BaseScaApplication() 
	{
		this.componentManager = new DefaultComponentManager();
		
		EventBusFactory eventBusFactory = EventBusFactory.newFactory();
		eventBus = eventBusFactory.getEventBus();
		
	}
	
	protected void init(List<Composite> composites) {
		
		// create context - can be overridden in specific implementations.
		scaContext = loadScaContext();
		scaContext.setCamelContext(loadCamelContext());		
		
		componentManager.load();
		startComponents(composites);
		
	}
	
	abstract protected CamelContext loadCamelContext();
	
	abstract protected Context loadScaContext();
	
	protected void startComponents(List<Composite> composites) {
		
		try {
			
			for (Composite composite : composites) 
			{
				for (Component component : composite.getComponents()) {
										
					// activate bindings
					for (Reference ref : component.getReferences()) {
						
						Binding modelBind = ref.getBindings().get(0);
						ApplicationComponent appComponent = componentManager.getComponent(modelBind.getName());
						
						if (appComponent == null) {
							
						}
						
						
					}
					
				}
			}
			
		} catch (Exception e) {
			
		}
		
	}
	
	public Context getScaContext() {
		return scaContext;
	}

	
	
}
