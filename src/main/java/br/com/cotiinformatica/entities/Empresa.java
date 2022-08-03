package br.com.cotiinformatica.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Empresa {

	/*
	 * private Integer idEmpresa; 
	 * private String nomeFantasia; 
	 * private String razaoSocial; private String cnpj;
	 */
	
	
	private Integer idEmpresa;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    
    //Associação 1-Empresa - Tem N-Funcionarios
    private List<Funcionario> funcionarios;
	
}
