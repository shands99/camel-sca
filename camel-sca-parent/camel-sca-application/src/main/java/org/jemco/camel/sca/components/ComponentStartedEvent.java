package org.jemco.camel.sca.components;

import org.jemco.camel.sca.ApplicationComponent;
import org.jemco.camel.sca.event.BaseEvent;

public class ComponentStartedEvent extends BaseEvent {

	private static final String TYPE = "component-start";
	
	private ApplicationComponent applicationComponent;

	public ComponentStartedEvent(ApplicationComponent applicationComponent) {
		super(TYPE);
		this.applicationComponent = applicationComponent;
	}
	
}
