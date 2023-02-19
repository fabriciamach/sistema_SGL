package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Pessoa;

public class PessoaDAO {

	public void cadastrarPessoa(Pessoa pessoa) throws ExceptionDAO{
		
		String sql = "insert into pessoa (nomecompleto,sexo,cpf,telefone,datanasc,endereco) values(?,?,?,?,?,?) ";
		
		PreparedStatement pStatement = null;
		Connection connection = null;
		
		try {
			connection = new ConnectionFactory().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1,pessoa.getNomeCompleto());
			pStatement.setString(2, pessoa.getSexo());
			pStatement.setString(3, pessoa.getCpf());
			pStatement.setString(4,pessoa.getTelefone());
			pStatement.setDate(5, new Date(pessoa.getDataNasc().getTime()));
			pStatement.setString(6,pessoa.getEndereco());
			pStatement.executeUpdate();
			
		}catch(SQLException e) {
			throw new ExceptionDAO("Erro ao cadastrar  pessoa!"+e);
		}finally {
			try {
				if(pStatement != null) {
					pStatement.close();
				}
				}catch(SQLException e) {
					throw new ExceptionDAO("Erro ao fechar o Statement"+e);
				}try {
					if(connection != null) {
						connection.close();
					}
				}catch(SQLException e){
					throw new ExceptionDAO("Erro ao fechar conexao: "+e);
				}
		}
	}
	public void excluirPessoa(String cpf) throws ExceptionDAO{
		String sql= "delete from pessoa where cpf = ?";

		PreparedStatement pStatement = null;
		Connection connection = null;
		
		try {
			connection = new ConnectionFactory().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1,cpf);
			pStatement.executeUpdate();
		
		}catch(SQLException e) {
			throw new ExceptionDAO("Erro ao excluir pessoa!"+e);
		}finally {
			try {
				if(pStatement != null) {
					pStatement.close();
				}
				}catch(SQLException e) {
					throw new ExceptionDAO("Erro ao fechar o Statement"+e);
				}try {
					if(connection != null) {
						connection.close();
					}
				}catch(SQLException e){
					throw new ExceptionDAO("Erro ao fechar conexao: "+e);
				}
		}
	}
	
	public Pessoa dadosPessoaEdicao(String cpf) throws ExceptionDAO{
		String sql = "select * from pessoa where cpf= '"+cpf+"'";
		PreparedStatement pStatement = null;
		Connection connection = null;
		
		Pessoa pessoa = new Pessoa();
		
		
		try {
			connection = new ConnectionFactory().getConnection();
			pStatement =connection.prepareStatement(sql);
			pStatement.execute();
			
			ResultSet rs = pStatement.getResultSet();
			if(rs!=null) {
				
				while(rs.next()) {
					pessoa.setNomeCompleto(rs.getString("nomecompleto"));
					pessoa.setSexo(rs.getString("sexo"));
					pessoa.setCpf(rs.getString("cpf"));
					pessoa.setTelefone(rs.getString("telefone"));
					pessoa.setDataNasc(rs.getDate("datanasc"));
					pessoa.setEndereco(rs.getString("endereco"));
					
				}
					
			}
			
		}catch(Exception e) {
			throw new ExceptionDAO("Erro ao consutar pessoas! " + e);
		}finally {
			try {
				if(pStatement != null) {
					pStatement.close();
				}
				}catch(SQLException e) {
					throw new ExceptionDAO("Erro ao fechar o Statement"+e);
				}try {
					if(connection != null) {
						connection.close();
					}
				}catch(SQLException e){
					throw new ExceptionDAO("Erro ao fechar conexao: "+e);
				}
		}
		
		
		return pessoa;
	}
	public void editarPessoa(Pessoa pessoa) throws ExceptionDAO {
		String sql = "update pessoa set (nomecompleto, sexo, cpf, telefone,datanasc,endereco) = (?,?,?,?,?,?) where cpf = ? ";
		
		PreparedStatement pStatement = null;
		Connection connection = null;
		
		try {
			connection = new ConnectionFactory().getConnection();
			pStatement =connection.prepareStatement(sql);
			pStatement.setString(1,pessoa.getNomeCompleto());
			pStatement.setString(2,pessoa.getSexo());
			pStatement.setString(3,pessoa.getCpf());
			pStatement.setString(4,pessoa.getTelefone());
			pStatement.setDate(5,new Date(pessoa.getDataNasc().getTime()));
			pStatement.setString(6,pessoa.getEndereco());
			pStatement.setString(7,pessoa.getCpf());
			pStatement.executeUpdate();
			
			
		}catch(Exception e) {
			throw new ExceptionDAO("Erro ao atualizar pessoa! " + e);
		}finally {
			try {
				if(pStatement != null) {
					pStatement.close();
				}
				}catch(SQLException e) {
					throw new ExceptionDAO("Erro ao fechar o Statement"+e);
				}try {
					if(connection != null) {
						connection.close();
					}
				}catch(SQLException e){
					throw new ExceptionDAO("Erro ao fechar conexao: "+e);
				}
		}
		
		
	}

}
