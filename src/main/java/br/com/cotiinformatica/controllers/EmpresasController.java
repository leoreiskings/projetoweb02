package br.com.cotiinformatica.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.cotiinformatica.dtos.PostEmpresaDTO;
import br.com.cotiinformatica.dtos.PutEmpresaDTO;
import br.com.cotiinformatica.entities.Empresa;
import br.com.cotiinformatica.repositories.EmpresaRepository;
import io.swagger.annotations.ApiOperation;

@Controller
public class EmpresasController {
	
	/* Adicionando comentários nos métodos dos controladores que sejam exibidos na documentação da API */
	@ApiOperation("Serviço para cadastro de empresas") 
	@RequestMapping(value = "/api/empresas", method = RequestMethod.POST)
	public ResponseEntity<String> post(@RequestBody PostEmpresaDTO dto) { // POST /api/empresas -> é um metodo que servirá para Cadastrar empresas "INSERT"

		try {

			Empresa empresa = new Empresa();
			
			// recuperando os dados enviados pelo DTO
			empresa.setNomeFantasia(dto.getNomeFantasia());
			empresa.setRazaoSocial(dto.getRazaoSocial());
			empresa.setCnpj(dto.getCnpj());

			EmpresaRepository empresaRepository = new EmpresaRepository();
			empresaRepository.create(empresa); // chamando o metodo da camada de Persistencia do backend para gravação no banco.												

			return ResponseEntity.status(HttpStatus.CREATED).body("Empresa cadastrada com sucesso!");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro" + e.getMessage());
		}
	}

	@ApiOperation("Serviço para atualização de empresas")
	@RequestMapping(value = "/api/empresas", method = RequestMethod.PUT)
	public ResponseEntity<String> put(@RequestBody PutEmpresaDTO dto) { // PUT /api/empresas -> é um metodo que servirá para Editar empresas "UPDATE"
	
		try {

			Empresa empresa = new Empresa();

			// recuperando os dados enviados pelo DTO
			empresa.setIdEmpresa(dto.getIdEmpresa());
			empresa.setNomeFantasia(dto.getNomeFantasia());
			empresa.setRazaoSocial(dto.getRazaoSocial());
			empresa.setCnpj(dto.getCnpj());

			EmpresaRepository empresaRepository = new EmpresaRepository();
			empresaRepository.update(empresa); // chamando o metodo da camada de Persistencia do backend para gravação no banco.											

			return ResponseEntity.status(HttpStatus.OK).body("Empresa atualizada com sucesso!");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro" + e.getMessage());
		}
	}

	@ApiOperation("Serviço para exclusão de empresas")
	@RequestMapping(value = "/api/empresas/{idEmpresa}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("idEmpresa") Integer idEmpresa) { // DELETE /api/empresas -> é um metodo que servirá para Excluir empresas
		try {
		
			EmpresaRepository empresaRepository = new EmpresaRepository();
			
			empresaRepository.delete(idEmpresa);
			
			return ResponseEntity.status(HttpStatus.OK).body("Empresa excluida com sucesso.");
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro: " + e.getMessage());
		}
	}

	@ApiOperation("Serviço para consultar todas as empresas") /*Adicionando comentários nos métodos dos controladores que sejam exibidos na documentação da API */
	@RequestMapping(value = "/api/empresas", method = RequestMethod.GET)
	public ResponseEntity<List<Empresa>> getAll() { // GET /api/empresas -> é um metodo que servirá para Consultar empresas "SELECT"
		
		try {
			
			EmpresaRepository empresaRepository = new EmpresaRepository();			
			List<Empresa> empresas = empresaRepository.findAll();
			
			return ResponseEntity.status(HttpStatus.OK).body(empresas);
			
		} catch (Exception e) {
			return ResponseEntity.status
					(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}		
	}
	
	@ApiOperation("Serviço para consulta de empresa por ID")/*Adicionando comentários nos métodos dos controladores que sejam exibidos na documentação da API */		
	@RequestMapping(value = "/api/empresas/{idEmpresa}", method = RequestMethod.GET)	
	public ResponseEntity<Empresa> getById(@PathVariable("idEmpresa") Integer idEmpresa) { // GET /api/empresas -> é um metodo que servirá para Consulta de uma empresa pelo Id
		
		try {
			
			EmpresaRepository empresaRepository = new EmpresaRepository();			
			Empresa empresa = empresaRepository.findById(idEmpresa);
			
			return ResponseEntity.status(HttpStatus.OK).body(empresa);
			
		} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}		
	}
}
