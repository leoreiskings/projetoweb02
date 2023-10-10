package br.com.kingsdevs.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.kingsdevs.entities.Empresa;
import br.com.kingsdevs.factories.ConnectionFactory;

public class EmpresaRepository {

	public void create(Empresa empresa) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("insert into empresa(nomeFantasia, razaoSocial,  cnpj) values(?, ?, ?)");

		statement.setString(1, empresa.getNomeFantasia());
		statement.setString(2, empresa.getRazaoSocial());
		statement.setString(3, empresa.getCnpj());

		statement.execute();
		connection.close();

	}

	public void update(Empresa empresa) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("update empresa set nomeFantasia = ?,	razaoSocial = ?, cnpj = ? where idEmpresa = ?");
		
		statement.setString(1, empresa.getNomeFantasia());
		statement.setString(2, empresa.getRazaoSocial());
		statement.setString(3, empresa.getCnpj());
		statement.setInt(4, empresa.getIdEmpresa());
		
		statement.execute();
		connection.close();
		
		}

	public void delete(Integer idEmpresa) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("delete from empresa where idEmpresa = ?");
		
		statement.setInt(1, idEmpresa);
		
		statement.execute();
		connection.close();
	}

	public List<Empresa> findAll() throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from empresa order by nomeFantasia");
		
		ResultSet resultSet = statement.executeQuery();
		
		List<Empresa> empresas = new ArrayList<Empresa>();
		
		while (resultSet.next()) {
			
			Empresa empresa = new Empresa();
			
			empresa.setIdEmpresa(resultSet.getInt("idEmpresa"));
			empresa.setNomeFantasia(resultSet.getString("nomeFantasia"));
			empresa.setRazaoSocial(resultSet.getString("razaoSocial"));
			empresa.setCnpj(resultSet.getString("cnpj"));
			empresas.add(empresa);
			
		}
		
		connection.close();
		return empresas;
		
	}

	public Empresa findById(Integer idEmpresa) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from empresa where idEmpresa = ?");
		
		statement.setInt(1, idEmpresa);
		ResultSet resultSet = statement.executeQuery();
		
		Empresa empresa = null;
		
		if (resultSet.next()) {
		
			empresa = new Empresa();
			
			empresa.setIdEmpresa(resultSet.getInt("idEmpresa"));
			empresa.setNomeFantasia(resultSet.getString("nomeFantasia"));
			empresa.setRazaoSocial(resultSet.getString("razaoSocial"));
			empresa.setCnpj(resultSet.getString("cnpj"));
		}
		
		connection.close();
		return empresa;
		
	}

}
