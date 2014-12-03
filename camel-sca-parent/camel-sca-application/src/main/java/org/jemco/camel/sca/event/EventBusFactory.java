package org.jemco.camel.sca.event;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class EventBusFactory {

	private static EventBusFactory _instance;
	
	private static final String RESOURCE_PATH="/META-INF/application.properties";
	
	private static final String FACTORY_CLASS_PROPERTY = "event.bus.factory";
	
	public static synchronized EventBusFactory newFactory() {
		
		if (_instance == null) {
			
			try {
				
				InputStream resource = EventBusFactory.class.getResourceAsStream(RESOURCE_PATH);
				Properties properties = new Properties();
				properties.load(resource);
				
				Class<EventBusFactory> factoryClass = (Class<EventBusFactory>) Class.forName(properties.getProperty(FACTORY_CLASS_PROPERTY));
				_instance = factoryClass.newInstance(); 
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		return _instance;
		
	} 
		
	public abstract EventBus getEventBus();
	
}
