package org.jemco.camel.sca.event;

public final class SimpleEventBusFactory extends EventBusFactory {
	
	private EventBus bus = new SimpleEventBus();
	
	@Override
	public EventBus getEventBus() {
		
		return bus;
		
	}
	
	static final class SimpleEventBus implements EventBus {

		public void raiseEvent(Event event) {
			// TODO Auto-generated method stub
			
		}

		public void registerHandler(HandlerPredicate predicate,
				EventHandler handler) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
