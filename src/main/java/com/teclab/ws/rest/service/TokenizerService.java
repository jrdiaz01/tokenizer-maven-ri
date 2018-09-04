package com.teclab.ws.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.teclab.ws.entity.TokenizerRequest;
import com.teclab.ws.entity.TokenizerResponse;

/**
 * Root resource (exposed at "tokenizer" path)
 */
@Path("tokenizer")
public class TokenizerService {
	
	@POST
	@Path("code")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response tokenizer(TokenizerRequest request) {
		TokenizerResponse response = new TokenizerResponse();
		
		String pan = request.getData();
		String bin = pan.substring(0,6);
		String token =  pan.substring(6, pan.length()-4);
		String fourLast = pan.substring(pan.length()-4, pan.length());
		
		Integer largo = token.length();
		StringBuilder sb = new StringBuilder();
		
		for (int i=0;i<token.length();i++) {
			 sb.append('X');
		}
		
		response.setCode(0);
		response.setToken(bin+sb.toString()+fourLast);
		return Response.ok().entity(response).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response randomToken() {
		TokenizerResponse response = new TokenizerResponse();
		
		response.setCode(0);
		response.setToken("123456123456789123456");
		return Response.ok().entity(response).build();
	}
	

}
