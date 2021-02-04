package com.concretepage;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import com.concretepage.services.ClientService;
import com.concretepage.services.IClientConsume;
import com.concretepage.wsdl.*;

@SpringBootApplication
@Component
@Controller
public class SoapWsClientApplication {



	public static void main(String[] args) {
		SpringApplication.run(SoapWsClientApplication.class, args);
	}
	/*@Bean
	
	CommandLineRunner lookup(GestionClient Client) {
		return args -> {
			System.out.println("--- Get ClientByPhone ---");
			service.getClientByPhone("11122");

		
			System.out.println("--- Add Client ---");
	       service.AddClient("125558","haoucha", "karima", "123456789", 10000.02);
			
			System.out.println("--- Pay Facture ---");
			service.payFacture("1112225", "01588995",100);

			System.out.println("--- Check Solde ---");
			service.checkSolde("1112225");
            

		};*/
	
} 

