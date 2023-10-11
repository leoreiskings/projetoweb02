package br.com.kingsdevs.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PutFuncionarioDTO {
	
	private Integer idFuncionario;
	private String nome;
	private String cpf;
	private String matricula;
	private String dataAdmissao;	
	private Integer idEmpresa;
	
	
}
