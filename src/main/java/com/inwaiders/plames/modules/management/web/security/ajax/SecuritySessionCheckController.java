package com.inwaiders.plames.modules.management.web.security.ajax;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/web/controller/security/ajax")
public class SecuritySessionCheckController {

	@Autowired
	private ObjectMapper mapper;
	
	@GetMapping("/check")
	public JsonNode checkSecurity(HttpServletRequest request) {
	
		ObjectNode node = mapper.createObjectNode();

		if(request.getUserPrincipal() == null) {
			
			node.put("auth", false);
		}
		else {
			
			node.put("auth", true);
		}
		
		return node;
	}
}
