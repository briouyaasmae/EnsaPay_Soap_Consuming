package com.concretepage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.concretepage.wsdl.*;

public class GestionClient extends WebServiceGatewaySupport  {

	private static final Logger log = LoggerFactory.getLogger(GestionClient.class);
	public GetClientResponse getClient(String phone,String banqueName) {
		GetClientRequest request = new GetClientRequest();
		request.setPhone(phone);
		request.setBanqueName(banqueName);
		log.info("Requesting client with number phone " + phone);
		GetClientResponse response = (GetClientResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback("http://localhost:8080/ws/getClient"));
		return response;
	}
	public CheckSoldeResponse checkSolde(String phone,String banqueName) {
		CheckSoldeRequest request = new CheckSoldeRequest();
		request.setPhone(phone);
		request.setBanqueName(banqueName);
		CheckSoldeResponse response = (CheckSoldeResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback("http://localhost:8080/ws/checkSolde"));
		return response;
	}
	public AddClientResponse addClient(Client client) {
		AddClientRequest request = new AddClientRequest();
		request.setClient(client);
		AddClientResponse response = (AddClientResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback("http://localhost:8080/ws/addClient"));
		return response;
	}
	public PayFactureResponse payFacture(String phone,String phone2,Double Montant,String banqueName) {
		PayFactureRequest request = new PayFactureRequest();
		request.setPhone(phone);
		request.setPhone2(phone2);
		request.setMontant(Montant);
		request.setBanqueName(banqueName);
		PayFactureResponse response = (PayFactureResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback("http://localhost:8080/ws/payFacture"));
		return response;
	}
}
