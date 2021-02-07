package com.concretepage;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.concretepage.services.IClientConsume;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping(value="/client")
public class ClientControler {
	@Autowired
	private IClientConsume service;
	@CrossOrigin(originPatterns = "",allowCredentials="true",allowedHeaders = "",methods = {})
	@GetMapping(value = "/getClient/{banqueName}/{phone}", produces="application/json")
	@ResponseBody
    public Object getClient(@PathVariable("phone") String phone, @PathVariable("banqueName") String banqueName) {
		ObjectNode jsonClient=service.getClientByPhone(phone,banqueName);
		return jsonClient;

	}
	@CrossOrigin(originPatterns = "",allowCredentials="true",allowedHeaders = "",methods = {})
	@PostMapping(path = "/addClient")
	@ResponseBody
    public Object addClient(@RequestBody Map<String, String> map){
		ObjectNode jsonClient=service.AddClient(map.get("id"), map.get("lastName"), map.get("firstName"), map.get("phone"),map.get("banqueName"),Double.parseDouble( map.get("solde")));
		return jsonClient;

	}
	@CrossOrigin(originPatterns = "",allowCredentials="true",allowedHeaders = "",methods = {})
	@PostMapping(path = "/payFacture")
	@ResponseBody
    public Object payFacture(@RequestBody Map<String, String> map){
		ObjectNode jsonClient=service.payFacture(map.get("clientPhone"), map.get("agencePhone"),Double.parseDouble(map.get("montant")),map.get("banqueName"));
		return jsonClient;

	}
	@CrossOrigin(originPatterns = "",allowCredentials="true",allowedHeaders = "",methods = {})
	@GetMapping(path = "/checkSolde/{banqueName}/{phone}")
	@ResponseBody
    public Object checkSolde(@PathVariable("phone") String phone, @PathVariable("banqueName") String banqueName){
		ObjectNode jsonClient=service.checkSolde(phone,banqueName);
		return jsonClient;

	}
}
