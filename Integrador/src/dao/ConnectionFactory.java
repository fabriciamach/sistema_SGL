package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {

	private String driver = "org.postgresql.Driver";
	private String user = "postgres";
	private String senha = "1801";
	private String url = "jdbc:postgresql://localhost:5432/postgres";
	private Connection con = null;

	
	public Connection getConnection(){
		
		try {
			Class.forName(driver);
			con =DriverManager.getConnection(url, user, senha);
			return con;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e)
		{
			System.err.print(e.getMessage());
		}
		return con;
	
	}
	public void fecharConexao(){
		try{
			if(con != null)
				con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void fecharConexao(Connection con){
		try{
			if(con != null)
				con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void fecharConexao(Connection con,PreparedStatement stmt){
		fecharConexao(con);
		try{
			if(stmt != null)
				stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 
	public ConnectionFactory() {
		try
		{
			Class.forName(driver);
			//Connection con = null;
			this.con = (Connection) DriverManager.getConnection(url, user, senha);
			System.out.println("Conex�o realizada com sucesso.");
		}
		catch (ClassNotFoundException ex)
		{
			System.err.print(ex.getMessage());
		} 
		catch (SQLException e)
		{
			System.err.print(e.getMessage());
		}
	}
	
	public  Connection getConexao(){
		return this.con;
	}

	public void fecharConexao(){
		try{
			if(con != null)
				con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
