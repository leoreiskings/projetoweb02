package br.com.cotiinformatica.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostEmpresaDTO {
	
	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	
	/*
	 * Aqui na classe PostEmpresaDTO é feita uma especie de contrato onde o consumidor da API 
	 * devera enviar estes 3 campos : nomeFantasia;
	 * 								  razaoSocial;
									  cnpj;									  
	 * para poder efetuar a gravação dos dados	*/
	
	
}
