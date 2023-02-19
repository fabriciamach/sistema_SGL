package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Produto;

public class ProdutoDAO {

	public void cadastrarProduto(Produto produto) throws ExceptionDAO{
		
		String sql = "insert into produto (codigoprod,modelo,genero,cor,preco,fabricante,tamanho) values (?,?,?,?,?,?,?)";
		
		PreparedStatement pStatement = null;
		Connection connection = null;
		
		try {
			connection = new ConnectionFactory().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1,produto.getCodigo());
			pStatement.setString(2, produto.getModelo());
			pStatement.setString(3,produto.getGenero());
			pStatement.setString(4,produto.getCor());
			pStatement.setDouble(5, produto.getPreco());
			pStatement.setString(6,produto.getFabricante());
			pStatement.setString(6,produto.getFabricante());
			pStatement.setInt(7,produto.getTamanho());
			pStatement.execute();
			
			
		}catch(SQLException e) {
			throw new ExceptionDAO("Erro ao cadastrar produto!"+e);
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
		public Produto pesquisaProduto(String codigo) throws ExceptionDAO{
			String sql = "select * from produto where codigoprod= '"+codigo+"'";
			PreparedStatement pStatement = null;
			Connection connection = null;
			
			Produto produto = new Produto();
			
			
			try {
				connection = new ConnectionFactory().getConnection();
				pStatement =connection.prepareStatement(sql);
				pStatement.execute();
				
				ResultSet rs = pStatement.getResultSet();
				if(rs!=null) {
					
					while(rs.next()) {
						produto.setCodigo(rs.getString("codigoprod"));
						produto.setModelo(rs.getString("modelo"));
						produto.setGenero(rs.getString("genero"));
						produto.setCor(rs.getString("cor"));
						produto.setPreco(rs.getDouble("preco"));
						produto.setFabricante(rs.getString("fabricante"));
						produto.setTamanho(rs.getInt("tamanho"));
						
						
						
						
						
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
			
			
			return produto;
		}
		public void editarProduto(Produto produto) throws ExceptionDAO {
			String sql = "update produto set (codigoprod,modelo,genero,cor,preco,fabricante,tamanho) = (?,?,?,?,?,?,?) where codigoprod = ? ";
			
			PreparedStatement pStatement = null;
			Connection connection = null;
			
			try {
				connection = new ConnectionFactory().getConnection();
				pStatement =connection.prepareStatement(sql);
				pStatement.setString(1,produto.getCodigo());
				pStatement.setString(2,produto.getModelo());
				pStatement.setString(3,produto.getGenero());
				pStatement.setString(4,produto.getCor());
				pStatement.setDouble(5,produto.getPreco());
				pStatement.setString(6,produto.getFabricante());
				pStatement.setInt(7,produto.getTamanho());
				pStatement.setString(8,produto.getCodigo());
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
		public void excluirProduto(String cod) throws ExceptionDAO{
			String sql= "delete from produto where codigoprod = ?";

			PreparedStatement pStatement = null;
			Connection connection = null;
			
			try {
				connection = new ConnectionFactory().getConnection();
				pStatement = connection.prepareStatement(sql);
				pStatement.setString(1,cod);
				pStatement.executeUpdate();
			
			}catch(SQLException e) {
				throw new ExceptionDAO("Erro ao excluir produto!"+e);
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
