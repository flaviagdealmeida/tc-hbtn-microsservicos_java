package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 
@RequestMapping(value="/messages")
public class MessageResource {

	  @GetMapping("/simpleMessageWelcome")
	    public String simpleMessageWelcome() {
	        return "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT";

	    }
	  
	  @GetMapping("/login")
	    public String login(String user, String password) {
		  String resposta = "LOGIN EFETUADO COM SUCESSO !!!" ;
		  String usuario = "Flavia";
	       String senha = "77889955";

		  if (user.isEmpty()|| password.isEmpty())
	        	resposta = "USUÁRIO E SENHA NÃO INFORMADOS";
	        
	        if (user.length()>15 || password.length()>15)
	        	resposta = "USUÁRIO E SENHA INVÁLIDOS";
	        
	        return resposta;
	    }
}
