package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.Funcionario;


public class FuncionarioDAO {

	
	public void cadastrarFuncionario (Funcionario funcionario)throws ExceptionDAO{
		
		String sql = "insert into pessoa (nomecompleto,sexo,cpf,telefone,datanasc,endereco) values(?,?,?,?,?,?) ";
		String sql2= "insert into funcionario_usuario(salario,datacontratacao,cargo,senha,nome_user,fk_cpf_func,fk_user_supervisor)"
				+ "values(?,?,?,?,?,?,?)";
		
		PreparedStatement pStatement = null;
		Connection connection = null;
		PreparedStatement pStatement2 = null;
		
		try {
			connection = new ConnectionFactory().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1,funcionario.getNomeCompleto());
			pStatement.setString(2, funcionario.getSexo());
			pStatement.setString(3, funcionario.getCpf());
			pStatement.setString(4,funcionario.getTelefone());
			pStatement.setDate(5, new Date(funcionario.getDataNasc().getTime()));
			pStatement.setString(6,funcionario.getEndereco());
			pStatement.execute();
			
			
			pStatement2 = connection.prepareStatement(sql2);
			pStatement2.setDouble(1,funcionario.getSalario());
			pStatement2.setDate(2, new Date(funcionario.getDataContratacao().getTime()));
			pStatement2.setString(3,funcionario.getCargo());
			pStatement2.setString(4,funcionario.getSenha());
			pStatement2.setString(5,funcionario.getNome_user());
			pStatement2.setString(6,funcionario.getFK_Cpf_Func());
			pStatement2.setString(7,funcionario.getFK_User_Supervisor());
			pStatement2.execute();
			
			
			
		}catch(SQLException e) {
			throw new ExceptionDAO("Erro ao cadastrar  Funcionario!"+e);
		}finally {
			try {
				if(pStatement != null) {
					pStatement.close();
				}
				if(pStatement2 != null) {
					pStatement2.close();
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
	public String buscaUserSup()throws ExceptionDAO {
		String sql = "select nome_user from funcionario_usuario where cargo = 'Gerente'";
		PreparedStatement pStatement = null;
		Connection connection = null;
		
		String userSup=null;
		
		try {
			connection = new ConnectionFactory().getConnection();
			pStatement =connection.prepareStatement(sql);
			pStatement.execute();
			
			ResultSet rs = pStatement.getResultSet();
			if(rs!=null) {
				while(rs.next()) {
					userSup = rs.getString("nome_user");
					System.out.println(userSup);
				}
				
				
			}
			
		}catch(Exception e) {
			throw new ExceptionDAO("Erro ao consutar nome de usuario do supervisor! " + e);
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
		
		
		return userSup;
	}
	public void excluirFuncionario(String cpf) throws ExceptionDAO{
		String sql2= "delete from pessoa where cpf = ?";
		String sql = "delete from funcionario_usuario where fk_cpf_func = ?";

		PreparedStatement pStatement = null;
		Connection connection = null;
		PreparedStatement pStatement2 = null;
		
		try {
			connection = new ConnectionFactory().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1,cpf);
			pStatement.executeUpdate();
			
			pStatement2 = connection.prepareStatement(sql2);
			pStatement2.setString(1,cpf);
			pStatement2.executeUpdate();
			
		
		}catch(SQLException e) {
			throw new ExceptionDAO("Erro ao excluir cliente!"+e);
		}finally {
			try {
				if(pStatement != null) {
					pStatement.close();
				}
				if(pStatement2 != null) {
					pStatement2.close();
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
	public String procuraCpfGerente() throws ExceptionDAO {
		String sql = "select * from funcionario_usuario where cargo = 'Gerente'";
		PreparedStatement pStatement = null;
		Connection connection = null;
		
		String cpf=null;
		
		try {
			connection = new ConnectionFactory().getConnection();
			pStatement =connection.prepareStatement(sql);
			pStatement.execute();
			
			ResultSet rs = pStatement.getResultSet();
			if(rs!=null) {
				while(rs.next()) {
					cpf= rs.getString("fk_cpf_func");
					
				}
				
				
			}
			
		}catch(Exception e) {
			throw new ExceptionDAO("Erro ao consutar nome de usuario do supervisor! " + e);
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
		
		
		return cpf;
	}
	public void editarFuncionario(Funcionario funcionario) throws ExceptionDAO {
		String sql = "update pessoa set (nomecompleto, sexo, cpf, telefone,datanasc,endereco) = (?,?,?,?,?,?) where cpf = ? ";
		
		String sql2 = "update funcionario_usuario set (salario, datacontratacao, cargo, senha,nome_user,fk_cpf_func,fk_user_supervisor) = (?,?,?,?,?,?,?) where fk_cpf_func = ? ";
		
		PreparedStatement pStatement = null;
		PreparedStatement pStatement2 = null;
		Connection connection = null;
		
		try {
			connection = new ConnectionFactory().getConnection();
			pStatement =connection.prepareStatement(sql);
			pStatement.setString(1,funcionario.getNomeCompleto());
			pStatement.setString(2,funcionario.getSexo());
			pStatement.setString(3,funcionario.getCpf());
			pStatement.setString(4,funcionario.getTelefone());
			pStatement.setDate(5,new Date(funcionario.getDataNasc().getTime()));
			pStatement.setString(6,funcionario.getEndereco());
			pStatement.setString(7,funcionario.getCpf());
			pStatement.executeUpdate();
			
			pStatement2 =connection.prepareStatement(sql2);
			pStatement2.setDouble(1,funcionario.getSalario());
			pStatement2.setDate(2,new Date(funcionario.getDataContratacao().getTime()));
			pStatement2.setString(3,funcionario.getCargo());
			pStatement2.setString(4,funcionario.getSenha());
			pStatement2.setString(5,funcionario.getNome_user());
			pStatement2.setString(6,funcionario.getFK_Cpf_Func());
			pStatement2.setString(7,funcionario.getFK_User_Supervisor());
			pStatement2.setString(8,funcionario.getFK_Cpf_Func());
			pStatement2.executeUpdate();
			
		}catch(Exception e) {
			throw new ExceptionDAO("Erro ao atualizar funcionario! " + e);
		}finally {
			try {
				if(pStatement != null) {
					pStatement.close();
				}
				if(pStatement2 != null) {
					pStatement2.close();
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
	public Funcionario dadosFuncEdicao(String cpf) throws ExceptionDAO{
		String sql = "select * from pessoa where cpf= '"+cpf+"'";
		String sql2 = "select * from funcionario_usuario where fk_cpf_func = '"+cpf+"'";
		
		PreparedStatement pStatement = null;
		PreparedStatement pStatement2 = null;
		Connection connection = null;
		
		Funcionario funcionario = new Funcionario();

		
		try {
			connection = new ConnectionFactory().getConnection();
			pStatement =connection.prepareStatement(sql);
			pStatement.execute();
			
			ResultSet rs = pStatement.getResultSet();
			if(rs!=null) {
				
				while(rs.next()) {
					//Funcionario funcionario = new Funcionario();
					funcionario.setNomeCompleto(rs.getString("nomecompleto"));
					funcionario.setSexo(rs.getString("sexo"));
					funcionario.setCpf(rs.getString("cpf"));
					funcionario.setTelefone(rs.getString("telefone"));
					funcionario.setDataNasc(rs.getDate("datanasc"));
					funcionario.setEndereco(rs.getString("endereco"));
					
				}
			}
				
			pStatement2 =connection.prepareStatement(sql2);
			pStatement2.execute();
				
			ResultSet rs2 = pStatement2.getResultSet();
			if(rs2!=null) {
					
					while(rs2.next()) {
						funcionario.setSenha(rs2.getString("senha"));
						funcionario.setCargo(rs2.getString("cargo"));;
						funcionario.setDataContratacao(rs2.getDate("datacontratacao"));
						funcionario.setSalario(rs2.getDouble("salario"));
						funcionario.setNome_user(rs2.getString("nome_user"));
						funcionario.setFK_Cpf_User_Supervisor(rs2.getString("fk_user_supervisor"));
					}
						
			}
					
			return funcionario;
			
			
			
			
		}catch(Exception e) {
			throw new ExceptionDAO("Erro ao consutar funcionario! " + e);
		}finally {
			try {
				if(pStatement != null) {
					pStatement.close();
				}
				if(pStatement2 != null) {
					pStatement2.close();
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
	public Funcionario verificaLogin(String User)throws ExceptionDAO {
		String sql = "select nome_user,senha, cargo from funcionario_usuario where nome_user = '"+User+"'";
		PreparedStatement pStatement = null;
		Connection connection = null;
		
		Funcionario func = new Funcionario();
		
		try {
			connection = new ConnectionFactory().getConnection();
			pStatement =connection.prepareStatement(sql);
			pStatement.execute();
			
			ResultSet rs = pStatement.getResultSet();
			if(rs!=null) {
				while(rs.next()) {
					func.setNome_user(rs.getString("nome_user"));
					func.setSenha(rs.getString("senha"));
					func.setCargo(rs.getString("cargo"));
				}
				
				
			}
			
		}catch(Exception e) {
			throw new ExceptionDAO("Erro ao consutar nome de usuario do supervisor! " + e);
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
		return func;
		
		
		
	}
	
}
