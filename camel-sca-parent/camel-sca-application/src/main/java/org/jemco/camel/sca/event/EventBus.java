package org.jemco.camel.sca.event;

public interface EventBus {

	void raiseEvent(Event event);
	
	void registerHandler(HandlerPredicate predicate, EventHandler handler);
	
}
