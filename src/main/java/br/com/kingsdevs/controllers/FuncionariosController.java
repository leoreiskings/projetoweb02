package br.com.kingsdevs.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.ApiOperation;

@Controller
public class FuncionariosController {

	@ApiOperation("Serviço para cadastro de funcionarios")
	@RequestMapping(value="/api/funcionarios", method = RequestMethod.POST)
	public ResponseEntity<String> post(){
		
		return null;		
	}
	
	@ApiOperation("Serviço para atualização de funcionarios")
	@RequestMapping(value = "/api/funcionarios", method = RequestMethod.PUT)
	public ResponseEntity<String> put() {
		
		return null;		
	}
	
	@ApiOperation("Serviço para exclusão de funcionarios")
	@RequestMapping(value = "/api/funcionarios",	method = RequestMethod.DELETE)
	public ResponseEntity<String> delete() {
		
		return null;	
	}
	
	@ApiOperation("Serviço para consulta de todos os funcionarios cadastrados")
	@RequestMapping(value = "/api/funcionarios", method = RequestMethod.GET)
	public ResponseEntity<String> getAll() {
		
		return null;		
	}
	
	
	
}
