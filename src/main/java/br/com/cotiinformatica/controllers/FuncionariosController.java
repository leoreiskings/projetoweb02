package br.com.cotiinformatica.controllers;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.cotiinformatica.dtos.PostFuncionarioDTO;
import br.com.cotiinformatica.dtos.PutEmpresaDTO;
import br.com.cotiinformatica.dtos.PutFuncionarioDTO;
import br.com.cotiinformatica.entities.Empresa;
import br.com.cotiinformatica.entities.Funcionario;
import br.com.cotiinformatica.repositories.EmpresaRepository;
import br.com.cotiinformatica.repositories.FuncionarioRepository;
import io.swagger.annotations.ApiOperation;

@Controller
public class FuncionariosController {

	@ApiOperation("Serviço para cadastro - insert - de funcionários") /* Adicionando comentários nos métodos dos controladores que sejam exibidos na documentação da API */
	@RequestMapping(value = "/api/funcionarios", method = RequestMethod.POST)
	public ResponseEntity<String> post(@RequestBody PostFuncionarioDTO dto) { // POST /api/funcionarios -> é um metodo que servirá para Cadastrar funcionarios "INSERT"

		try {

			Funcionario funcionario = new Funcionario();
			funcionario.setEmpresa(new Empresa());

			// recuperando os dados enviados pelo DTOFuncionario
			funcionario.setNome(dto.getNome());
			funcionario.setCpf(dto.getCpf());
			funcionario.setMatricula(dto.getMatricula());

			// fazendo o parse de String para Date com o Formato de data
			funcionario.setDataAdmissao(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getDataAdmissao()));

			// recuperando o idEmpresa do funcionario para inserir na tabela de Funcionario
			funcionario.getEmpresa().setIdEmpresa(dto.getIdEmpresa());

			FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
			funcionarioRepository.create(funcionario); // chamando o metodo da camada de Persistencia do backend para
														// gravação no banco.

			return ResponseEntity.status(HttpStatus.CREATED).body("Funcionario cadastrado com sucesso!");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro" + e.getMessage());
		}
	}

	@ApiOperation("Serviço para atualização - update - de funcionarios")
	@RequestMapping(value = "/api/funcionarios", method = RequestMethod.PUT)
	public ResponseEntity<String> put(@RequestBody PutFuncionarioDTO dto) { // PUT /api/funcionarios -> é um metodo que servirá para Editar funcionarios "UPDATE"
																	

		try {

			Funcionario funcionario = new Funcionario();
			funcionario.setEmpresa(new Empresa());

			funcionario.setIdFuncionario(dto.getIdFuncionario()); // resgatando o idfuncionario vindo da chamada da API
																	// para saber qual linha atualizar no BD
			funcionario.setNome(dto.getNome());
			funcionario.setCpf(dto.getCpf());
			funcionario.setMatricula(dto.getMatricula());
			funcionario.setDataAdmissao(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getDataAdmissao()));

			// recuperando o idEmpresa do funcionario para inserir na tabela de Funcionario
			funcionario.getEmpresa().setIdEmpresa(dto.getIdEmpresa());

			FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
			funcionarioRepository.update(funcionario); // chamando o metodo da camada de Persistencia do backend para gravação no banco.

			return ResponseEntity.status(HttpStatus.OK).body("Funcionario atualizado com sucesso!");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro" + e.getMessage());
		}
	}

	@ApiOperation("Serviço para exclusão - delete - de funcionarios") 
	@RequestMapping(value = "/api/funcionarios/{idFuncionario}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("idFuncionario") Integer idFuncionario) { // DELETE /api/funcionarios é um metodo que servirá para Excluir funcionarios

		try {

			FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
			funcionarioRepository.delete(idFuncionario);
			return ResponseEntity.status(HttpStatus.OK)
					.body("Funcionario excluido com sucesso!");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro: " + e.getMessage());
		}
	}

	
	
	
	
	
	
	
	
	
	
	@ApiOperation("Serviço para consultar - select - todos os funcionários") 
	@RequestMapping(value = "/api/funcionarios", method = RequestMethod.GET)
	public ResponseEntity<List<Funcionario>> getAll() { // GET /api/funcionarios -> é um metodo que servirá para Consultar
													// funcionarios "SELECT"
		try {

			FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
			List<Funcionario> funcionarios = funcionarioRepository.findAll();

			return ResponseEntity.status(HttpStatus.OK).body(funcionarios);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@ApiOperation("Serviço para consulta de funcionario por ID")/*Adicionando comentários nos métodos dos controladores que sejam exibidos na documentação da API */		
	@RequestMapping(value = "/api/funcionarios/{idFuncionario}", method = RequestMethod.GET)	
	public ResponseEntity<Funcionario> getById(@PathVariable("idFuncionario") Integer idFuncionario) { // GET /api/empresas -> é um metodo que servirá para Consulta de uma empresa pelo Id
		
		try {
			
			FuncionarioRepository funcionarioRepository = new FuncionarioRepository();			
			Funcionario funcionario = funcionarioRepository.findById(idFuncionario);
			
			return ResponseEntity.status(HttpStatus.OK).body(funcionario);
			
		} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}		
	}
	
	
	
	
	
	
}
