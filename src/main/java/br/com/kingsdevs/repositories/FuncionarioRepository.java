package br.com.kingsdevs.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.kingsdevs.entities.Empresa;
import br.com.kingsdevs.entities.Funcionario;
import br.com.kingsdevs.factories.ConnectionFactory;

public class FuncionarioRepository {

	public void create(Funcionario funcionario) throws Exception {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("insert into funcionario(nome, cpf, matricula, dataAdmissao, idEmpresa) values(?, ?, ?, ?, ?)");

		statement.setString(1, funcionario.getNome());
		statement.setString(2, funcionario.getCpf());
		statement.setString(3, funcionario.getMatricula());
		statement.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(funcionario.getDataAdmissao()));
		statement.setInt(5, funcionario.getEmpresa().getIdEmpresa());

		statement.execute();
		connection.close();

	}

	public void update(Funcionario funcionario) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("update funcionario set nome=?, cpf=?, matricula=?,dataAdmissao=?, idEmprea=? "
				+ "where idFuncionario=?");
		
		statement.setString(1, funcionario.getNome());
		statement.setString(2, funcionario.getCpf());
		statement.setString(3, funcionario.getMatricula());
		statement.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(funcionario.getDataAdmissao()));
		statement.setInt(5, funcionario.getEmpresa().getIdEmpresa());
		statement.setInt(6, funcionario.getIdFuncionario());
		
		statement.execute();
		connection.close();
		}

	public void delete(Integer idFuncionario) throws Exception {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("delete from funcionario where idFuncionario = ?");
		
		statement.setInt(1, idFuncionario);
		
		statement.execute();
		connection.close();
	}

	public List<Funcionario> findAll() throws Exception {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("select f.idFuncionario, f.nome, f.cpf, f.matricula,	f.dataAdmissao, e.idEmpresa, e.nomeFantasia,	e.razaoSocial, e.cnpj from funcionario f inner join empresa e	on e.idEmpresa = f.idEmpresa order by f.nome");
		ResultSet resultSet = statement.executeQuery();
		
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		while (resultSet.next()) {
		
			Funcionario funcionario = new Funcionario();
			
			funcionario.setEmpresa(new Empresa());
			
			funcionario.setIdFuncionario(resultSet.getInt("idFuncionario"));
			funcionario.setNome(resultSet.getString("nome"));
			funcionario.setCpf(resultSet.getString("cpf"));
			funcionario.setMatricula(resultSet.getString("matricula"));
			funcionario.setDataAdmissao(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("dataAdmissao")));
			funcionario.getEmpresa().setIdEmpresa(resultSet.getInt("idEmpresa"));
			funcionario.getEmpresa().setNomeFantasia(resultSet.getString("nomeFantasia"));
			funcionario.getEmpresa().setRazaoSocial	(resultSet.getString("razaoSocial"));
			funcionario.getEmpresa().setCnpj	(resultSet.getString("cnpj"));
			
			funcionarios.add(funcionario);
		
		}
		
		connection.close();
		return funcionarios;
		
		}

	public Funcionario findById(Integer idFuncionario) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("select f.idFuncionario, f.nome, f.cpf,	f.matricula, f.dataAdmissao, e.idEmpresa,"
				+ "e.nomeFantasia, e.razaoSocial, e.cnpj from funcionario f "
				+ "inner join empresa e on e.idEmpresa = f.idEmpresa "
				+ "where f.idFuncionario = ?");
		
		statement.setInt(1, idFuncionario);
		
		ResultSet resultSet = statement.executeQuery();
		Funcionario funcionario = null;
		
		if (resultSet.next()) {
			
			funcionario = new Funcionario();
			funcionario.setEmpresa(new Empresa());
			funcionario.setIdFuncionario(resultSet.getInt("idFuncionario"));
			funcionario.setNome(resultSet.getString("nome"));
			funcionario.setCpf(resultSet.getString("cpf"));
			funcionario.setMatricula(resultSet.getString("matricula"));
			funcionario.setDataAdmissao(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("dataAdmissao")));
			funcionario.getEmpresa().setIdEmpresa(resultSet.getInt("idEmpresa"));
			funcionario.getEmpresa().setNomeFantasia(resultSet.getString("nomeFantasia"));
			funcionario.getEmpresa().setRazaoSocial	(resultSet.getString("razaoSocial"));
			funcionario.getEmpresa().setCnpj	(resultSet.getString("cnpj"));
			
		}		
			connection.close();
			return funcionario;			
		}
}
