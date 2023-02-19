package model;

import dao.ExceptionDAO;
import view.CadastroCliente;
import view.TelaEditaCliente;

public interface MetodosPessoa {

	public String CadastrarPessoaModel(CadastroCliente view) throws ExceptionDAO;
	public void CadastrarPessoaBD(Pessoa pessoa) throws ExceptionDAO ;
	public void excluirPessoaBD(String cpf) throws ExceptionDAO;
	public Pessoa procurarPessoaBD(String cpf)throws ExceptionDAO;
	public String editarPessoaModel(TelaEditaCliente view) throws ExceptionDAO ;
	public void editarPessoaBD(Pessoa pessoa) throws ExceptionDAO ;
}
