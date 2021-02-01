package com.concretepage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

@Configuration
public class WSConfigClient extends WsConfigurerAdapter {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the  specified in
		// pom.xml
		marshaller.setPackagesToScan("com.concretepage.wsdl");
		return marshaller;
	}

	@Bean
	public GestionClient gestionClient(Jaxb2Marshaller marshaller) {
		GestionClient client = new GestionClient();
		client.setDefaultUri("http://localhost:8080/ws/clients.wsdl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

	
} 