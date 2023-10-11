package br.com.kingsdevs.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostFuncionarioDTO {
	
	private String nome;
	private String cpf;
	private String matricula;
	private String dataAdmissao;	
	private Integer idEmpresa;	
	
}
