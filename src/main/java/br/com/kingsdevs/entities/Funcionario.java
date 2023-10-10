package br.com.kingsdevs.entities;

import java.util.Date;

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
public class Funcionario {

	private Integer idFuncionario;
	private String nome;
	private String cpf;
	private String matricula;
	private Date dataAdmissao;
	
	//Associação TER-1
	private Empresa empresa;
	
	
	
}
