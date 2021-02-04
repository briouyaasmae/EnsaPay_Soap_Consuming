package com.concretepage.services;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.concretepage.wsdl.AddClientResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.concretepage.wsdl.*;
import com.concretepage.GestionClient;
@Service
public class ClientService implements IClientConsume {
	 @Autowired
	 private GestionClient Client =new GestionClient();
		@Autowired
		private ObjectMapper objectMapper;
	
	@Override
	public ObjectNode getClientByPhone(String data,String banqueName) {
		GetClientResponse clientResponse = Client.getClient(data,banqueName);
		Client clientInfo = clientResponse.getClient();
		ObjectNode jsonObject = objectMapper.createObjectNode();
		jsonObject.put("id",clientInfo.getIdentifiant());
		jsonObject.put("lastName",clientInfo.getNom());
		jsonObject.put("firstName",clientInfo.getPrenom());
		jsonObject.put("phone",clientInfo.getPhone());
		jsonObject.put("solde",clientInfo.getSolde());
		jsonObject.put("banqueName",clientInfo.getBanqueName());
		//String content= "{id:"+clientInfo.getIdentifiant()+",nom:"+clientInfo.getNom()+",prenom:"+clientInfo.getPrenom()+",phone:"+clientInfo.getPhone()+",sode:"+clientInfo.getSolde()+"}";
		return jsonObject;
	}

	@Override
	public ObjectNode AddClient(String id,String nom,String prenom,String phone,String banqueName,double solde) {
	    Client cl1=new Client();
		cl1.setIdentifiant(id);
        cl1.setNom(nom);
        cl1.setPrenom(prenom);
        cl1.setPhone(phone);
        cl1.setSolde(solde);
        cl1.setBanqueName(banqueName);
		AddClientResponse addClientResponse = Client.addClient(cl1);
		String message = addClientResponse.getMessage();
		ObjectNode jsonObject = objectMapper.createObjectNode();
        jsonObject.put("phone", cl1.getPhone());
        jsonObject.put("banqueName", cl1.getBanqueName());
        jsonObject.put("message",message);

		return jsonObject;
	}

	@Override
	public ObjectNode payFacture(String clientPhone , String agencePhone, double montant,String banqueName) {
		PayFactureResponse factureResponse =Client.payFacture(clientPhone,agencePhone, montant,banqueName);
		ServiceStatus service = factureResponse.getServiceStatus();
		String Message =service.getMessage();
		ObjectNode jsonObject = objectMapper.createObjectNode();
        jsonObject.put("agencePhone", agencePhone);
        jsonObject.put("clientPhone",clientPhone);
        jsonObject.put("message",Message);
        jsonObject.put("banqueName", banqueName);
		return jsonObject;
	}

	@Override
	public ObjectNode checkSolde(String data,String banqueName) {
		CheckSoldeResponse soldeResponse =  Client.checkSolde(data,banqueName);
		Double solde=soldeResponse.getSolde();
		ObjectNode jsonObject = objectMapper.createObjectNode();
        jsonObject.put("phone", data);
        jsonObject.put("solde",solde);		
		return jsonObject;



	}
}
