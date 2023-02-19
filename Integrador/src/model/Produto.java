package model;



import dao.ExceptionDAO;

import dao.ProdutoDAO;
import view.CadastroProduto;

import view.TelaEditaProduto;


public class Produto {

	private String Codigo;
	private String Modelo;
	private int Tamanho;
	private String Genero;
	private String Fabricante;
	private String Cor;
	private double Preco;
	private int FK_Num_venda;
	
	

	
	public Produto(String codigo, String modelo, int tamanho, String genero, String fabricante, String cor, double preco, int fK_Num_venda) {
		super();
		setCodigo(codigo);
		setModelo(modelo);
		setTamanho(tamanho);
		setGenero(genero);
		setFabricante(fabricante);
		setCor(cor);
		setPreco(preco);
		setFK_Num_venda(fK_Num_venda);
	}
	public Produto(String codigo, String modelo, int tamanho, String genero, String fabricante, String cor, double preco ){
		super();
		setCodigo(codigo);
		setModelo(modelo);
		setTamanho(tamanho);
		setGenero(genero);
		setFabricante(fabricante);
		setCor(cor);
		setPreco(preco);
	}
	
	
	public Produto() {
		
	}

	

	

	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		if(codigo!= null && !codigo.isEmpty())
			Codigo = codigo;
	}
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		if(modelo!=null  && !modelo.isEmpty())
			Modelo = modelo;
	}
	public int getTamanho() {
		return Tamanho;
	}
	public void setTamanho(int tamanho) {
		if(tamanho > 0)
			Tamanho = tamanho;
	}
	public String getGenero() {
		return Genero;
	}
	public void setGenero(String genero) {
		if(genero != null && !genero.isEmpty())
			Genero = genero;
	}
	public String getFabricante() {
		return Fabricante;
	}
	public void setFabricante(String fabricante) {
		if(fabricante != null && !fabricante.isEmpty() )
			Fabricante = fabricante;
	}
	public String getCor() {
		return Cor;
	}
	public void setCor(String cor) {
		if(cor!=null && !cor.isEmpty())
			Cor = cor;
	}
	public double getPreco() {
		return Preco;
	}
	public void setPreco(double preco) {
		if(preco >0)
			Preco = preco;
	}
	public int getFK_Num_venda() {
		return FK_Num_venda;
	}
	public void setFK_Num_venda(int fK_Num_venda) {
		if(fK_Num_venda!=0 )
			FK_Num_venda = fK_Num_venda;
	}
	@Override
	public String toString() {
		return " Codigo: " + getCodigo() + "\n Modelo" + getModelo() + "\n Tamanho: " + getTamanho()
				+ "\n Genero:" + getGenero() + "\n Fabricante: " + getFabricante() + "\n Cor: " + getCor()
				+ "\n Preco: R$ " + getPreco();
	}
	
	public String cadastrarProdutoModel(CadastroProduto view) throws ExceptionDAO {
		String msg;
		String cod = view.getCodProd();
		String model =  view.getModelo();
		String fab =  view.getFabricante();
		Double valor =  view.getPreco();
		String cor = view.getCor();
		int tam = view.gettTam();
		String sexo = view.gettGenero();
		
		FactoryProdutosVendas fb = new FactoryProdutosVendas();
		Produto produto =(Produto)fb.getProduto(cod, model, tam, sexo, fab, cor, valor);
		if(produto!=null ) {
			cadastrarProdutoBD(produto);
			msg ="Produto cadastrado com sucesso!";
		}else {
			msg = "Os dados não foram prenchidos corretamente!";
			
		}
		return msg;
	}
	
	public void cadastrarProdutoBD(Produto produto) throws ExceptionDAO {
		new ProdutoDAO().cadastrarProduto(produto);
	}
	public Produto pesquisaProdutoBD(String codigo) throws ExceptionDAO {
		return new ProdutoDAO().pesquisaProduto(codigo);
	}
	
	public String editarProdutoModel(TelaEditaProduto view) throws ExceptionDAO {
		String msg = null;
		String cod =view.getCodProd();
		String model =  view.getModelo();
		String fab =  view.getFabricante();
		Double valor =  view.getPreco();
		String cor = view.getCor();
		String sexo = view.gettGenero();
		int tam = view.gettTam();
		
		
			FactoryProdutosVendas fb = new FactoryProdutosVendas();
			Produto produto =(Produto)fb.getProduto(cod, model, tam, sexo, fab, cor, valor);
			
			if(produto != null) {
				editarProdutoBD(produto);
				msg = "Produto atualizado com sucesso!";
			}else {
				msg = "Os dados não foram prenchidos corretamente!";
			}
			
		return msg;
	}
	public void editarProdutoBD(Produto produto) throws ExceptionDAO {
	    new ProdutoDAO().editarProduto(produto);
	}
	public Produto pesquisaProdutoModel(String cod) throws ExceptionDAO {
		return new ProdutoDAO().pesquisaProduto(cod);
	}
	public void excluirProdutoModel(String cod) throws ExceptionDAO {
		new ProdutoDAO().excluirProduto(cod);
	}
	
	
}
