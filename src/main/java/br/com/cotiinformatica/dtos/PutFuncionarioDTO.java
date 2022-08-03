package br.com.cotiinformatica.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter 
public class PutFuncionarioDTO {

	 private Integer idFuncionario; // PK que serve para consultar o registro e depois podermos editar seus campos
	 private String  nome;
	 private String  cpf;
	 private String  matricula;
	 private String  dataAdmissao;
	 private Integer idEmpresa;	// FK que liga o funcionario a Empresa a que ele pertence, podendo tb ser editada
	
	
}
