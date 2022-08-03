package br.com.cotiinformatica.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PutEmpresaDTO {

	private Integer idEmpresa;
	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	
}
