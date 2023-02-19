package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Venda;

public class VendaDAO {

	public void cadastrarVenda(Venda venda) throws ExceptionDAO{
		
		String sql= "insert into venda (valor,data,forma_pg,hora,num_venda,fk_cpfcliente,fk_userfunc) values (?,?,?,?,?,?,?)";

		PreparedStatement pStatement = null;
		Connection connection = null;
		
		
		try {
			connection = new ConnectionFactory().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setDouble(1,venda.getValor());
			pStatement.setDate(2, new Date(venda.getData().getTime()));
			pStatement.setString(3,venda.getForma_pg());
			pStatement.setString(4,venda.getHora());
			pStatement.setInt(5,venda.getNum_venda() );
			pStatement.setString(6,venda.getFK_Cpf_Cliente());
			pStatement.setString(7,venda.getFK_UserFunc());
			
			pStatement.execute();
			
			
		}catch(SQLException e) {
			throw new ExceptionDAO("Erro ao registrar venda!"+e);
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
	public int procuraNumVendas() throws ExceptionDAO {
		String sql= "select count(*)as numeroVendas from venda";

		PreparedStatement pStatement = null;
		Connection connection = null;
		int numero = 0;
		
		
		try {
			connection = new ConnectionFactory().getConnection();
			pStatement = connection.prepareStatement(sql);
			
			pStatement.execute();
			
			
			
			ResultSet rs = pStatement.getResultSet();
			if(rs!=null) {
				while(rs.next()) {
					numero= rs.getInt("numeroVendas");
					System.out.println(numero);
				}
				
			
			}
			
			
			
		}catch(SQLException e) {
			throw new ExceptionDAO("Erro ao registrar venda!"+e);
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
		return numero;
	}
	
}
