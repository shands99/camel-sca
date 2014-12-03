package org.jemco.camel.sca.soap.model;

import javax.xml.namespace.QName;

import org.jemco.camel.sca.model.Binding;

public interface SoapBinding extends Binding {

	Binding getParent();
	
	QName getServiceName();
	
	String getServiceClass();
	
	QName getPortName();
	
	String getNamespace();
	
	String getWsdlUrl();
	
	String getAddress();
	
}
