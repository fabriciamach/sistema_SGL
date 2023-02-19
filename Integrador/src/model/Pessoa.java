package model;

import java.util.Date;


import dao.ExceptionDAO;
import dao.PessoaDAO;
import view.CadastroCliente;
import view.TelaEditaCliente;

public class Pessoa extends Object implements MetodosPessoa {
	private String NomeCompleto;
	private String Cpf;
	private String Telefone;
	private Date DataNasc;
	private String Sexo;
	private String Endereco;
	
	
	public Pessoa(String nomeCompleto, String cpf, String telefone, Date dataNasc2, String sexo, String endereco)
	{
		this.setNomeCompleto(nomeCompleto);
		this.setCpf(cpf);
		this.setTelefone(telefone);
		this.setDataNasc(dataNasc2);
		this.setSexo(sexo);
		this.setEndereco(endereco);
		
		
	}
	public Pessoa() {
		
	}
	public String getNomeCompleto() {
		return NomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		if(nomeCompleto.length()>0 && !nomeCompleto.isEmpty())
		 NomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		if(cpf.length()>10 && !cpf.isEmpty())
			Cpf = cpf;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		if(telefone != null && !telefone.isEmpty())
			Telefone = telefone;
	}

	public Date getDataNasc() {
		return DataNasc;
	}

	public void setDataNasc(Date dataNasc2) {
		if(dataNasc2!=null)
			DataNasc = dataNasc2;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		if(sexo != null && !sexo.isEmpty())
			Sexo = sexo;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		if(endereco!=null && !endereco.isEmpty())
			Endereco = endereco;
	}

	@Override
	public String toString() {
		return "NomeCompleto: " + getNomeCompleto() + " \nCPF: " + getCpf() + "\nTelefone: "
				+ getTelefone() + "\nDataNasc: " + getDataNasc() + "\nSexo:" + getSexo() + ",\n Endereco: "
				+ getEndereco() ;
	}

	public String CadastrarPessoaModel(CadastroCliente view) throws ExceptionDAO {
		String msg = null;
		String nomeCompleto = view.getNome();
		String cpf = view.getCPF();
		String telefone = view.getTelefone();
		Date dataNasc = view.gettDataNasc();
		String end  = view.getEndereco();
		String sexo = null;
		
		if(view.getMasculino().isSelected()) {
			sexo = "M";
		}else {
			if(view.getFeminino().isSelected()) {
				sexo = "F";
			}
		}
		
			FactoryPessoa fp = new FactoryPessoa();
			Pessoa pessoa = (Pessoa)fp.getPessoa(nomeCompleto,cpf, telefone, dataNasc, sexo, end);
			pessoa.toString();
			if(pessoa!=null && !nomeCompleto.isEmpty() && !cpf.isEmpty() && !telefone.isEmpty() && dataNasc!=null 
					&& !sexo.isEmpty() && !end.isEmpty()) {
				CadastrarPessoaBD(pessoa);
				msg = "Cliente cadastrado com sucesso!";
			}else {
				msg =  "Os dados não foram prenchidos corretamente!";
			}
			
			return msg;
		
	}
	public void CadastrarPessoaBD(Pessoa pessoa) throws ExceptionDAO {
		new PessoaDAO().cadastrarPessoa(pessoa);
	}
	public void excluirPessoaBD(String cpf) throws ExceptionDAO{
		new PessoaDAO().excluirPessoa(Cpf);
	}
	public Pessoa procurarPessoaBD(String cpf)throws ExceptionDAO{
		PessoaDAO pes = new PessoaDAO();
		Pessoa cliente = pes.dadosPessoaEdicao(cpf);
		return cliente;
	}
	public String editarPessoaModel(TelaEditaCliente view) throws ExceptionDAO {
		String msg = null;
		String nomeCompleto = view.getNome();
		String cpf = view.getCPF();
		String telefone = view.getTelefone();
		Date dataNasc = view.gettDataNasc();
		String end  = view.getEndereco();
		String sexo = null;
		
		if(view.getMasculino().isSelected()) {
			sexo = "M";
		}else {
			if(view.getFeminino().isSelected()) {
				sexo = "F";
			}
		}
		
			FactoryPessoa fp = new FactoryPessoa();
			Pessoa pessoa = (Pessoa)fp.getPessoa(nomeCompleto,cpf, telefone, dataNasc, sexo, end);
			pessoa.toString();
			if(pessoa!=null && !nomeCompleto.isEmpty() && !cpf.isEmpty() && !telefone.isEmpty() && dataNasc!=null 
					&& !sexo.isEmpty() && !end.isEmpty()) {
				editarPessoaBD(pessoa);
				msg = "Pessoa atualizada com sucesso!";
			}else {
				msg = "Os dados não foram prenchidos corretamente!";
			}
			
		return msg;
	}
	public void editarPessoaBD(Pessoa pessoa) throws ExceptionDAO {
	    new PessoaDAO().editarPessoa(pessoa);
	}
	
	

}
