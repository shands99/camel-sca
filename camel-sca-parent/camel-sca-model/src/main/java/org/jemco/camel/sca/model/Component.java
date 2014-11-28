package org.jemco.camel.sca.model;

import java.util.List;

public interface Component {

	String getName();
	
	Implementation getImplementation();
	
	List<Service> getServices();
	
	List<Reference> getReferences();
	
}
