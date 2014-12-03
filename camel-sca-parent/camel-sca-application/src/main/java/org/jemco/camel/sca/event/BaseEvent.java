package org.jemco.camel.sca.event;

public abstract class BaseEvent implements Event {

	private String type;

	public BaseEvent(String type) {
		super();
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	
}
