package org.jemco.camel.sca.event;

public interface HandlerPredicate {

	boolean accept(Event event);
	
}
