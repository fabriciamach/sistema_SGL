package model;

import java.util.Date;

public class FactoryProdutosVendas {

	public Produto getProduto(String codigo, String modelo, int tamanho, String genero, String fabricante, String cor,
			double preco, int fK_Num_venda) {
		Produto retorno= new Produto(codigo, modelo, tamanho, genero, fabricante, cor, preco, fK_Num_venda);
		return retorno ;
	}
	public  Venda getVenda(double valor, Date data, String hora, String forma_pg,int num_venda,
			String fK_Cpf_Cliente, String fK_UserFunc) {
		Venda retorno = new Venda(valor,data,hora, forma_pg, num_venda+1,fK_Cpf_Cliente,  fK_UserFunc);
		return retorno ;
	}
	public Produto getProduto(String cod, String model, int tam, String sexo, String fab, String cor, Double valor) {
		// TODO Auto-generated method stub
		Produto retorno = new Produto(cod, model, tam, sexo, fab, cor,valor);
		return retorno;
	}
}
