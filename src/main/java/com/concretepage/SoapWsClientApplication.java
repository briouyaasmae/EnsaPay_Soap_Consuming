package com.concretepage;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.concretepage.wsdl.*;

@SpringBootApplication
public class SoapWsClientApplication {

	private Client cl1=new Client();
	public static void main(String[] args) {
		SpringApplication.run(SoapWsClientApplication.class, args);
	}
	@Bean
	CommandLineRunner lookup(GestionClient Client) {
		return args -> {
			System.out.println("--- Get ClientByPhone ---");
			GetClientResponse clientResponse = Client.getClient("1112225");
			Client clientInfo = clientResponse.getClient();
			System.out.println(clientInfo.getNom() + ", "+ clientInfo.getPrenom()
			     + ", " + clientInfo.getSolde());
			
		
			System.out.println("--- Add Client ---");
	        cl1.setIdentifiant("M025");
	        cl1.setNom("hakik");
	        cl1.setPrenom("Ayoub");
	        cl1.setPhone("052355");
	        cl1.setSolde(10000.0);
			AddClientResponse addClientResponse = Client.addClient(cl1);
			String message = addClientResponse.getMessage();
			System.out.println(message);
			
			System.out.println("--- Pay Facture ---");
			PayFactureResponse factureResponse =Client.payFacture("1112225","01588995", 300.0);
			ServiceStatus service = factureResponse.getServiceStatus();
			String Message =service.getMessage();
			System.out.println(Message);

			System.out.println("--- Check Solde ---");
			CheckSoldeResponse soldeResponse =  Client.checkSolde("1112225");
			Double solde=soldeResponse.getSolde();
			System.out.println("your solde is "+ solde);
            

		};
} 
}
