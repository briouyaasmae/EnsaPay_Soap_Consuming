package com.concretepage.services;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public interface IClientConsume {
	 ObjectNode payFacture(String phone,String phone2, double montant,String banqueName);
	 ObjectNode checkSolde(String data,String banqueName);
	ObjectNode AddClient(String id, String nom, String prenom, String phone,String banqueName, double solde);
	ObjectNode getClientByPhone(String data,String banqueName);


}
