package model;


import java.util.Date;

public class FactoryPessoa {
	
	public Pessoa getPessoa(String nomeCompleto, String cpf, String telefone, Date dataNasc, String sexo, String endereco) {
		Pessoa retorno= new Pessoa(nomeCompleto,cpf,telefone,dataNasc, sexo, endereco);
		return retorno ;
	}
	public Funcionario getFuncionario(String nomeCompleto, String cpf, String telefone, Date dataNasc, String sexo, String endereco,
			double salario, Date dataContratacao, String cargo, String senha, String nome_user, String FK_Cpf_Func,
			String FK_User_Supervisor) {
		Funcionario retorno=new Funcionario(nomeCompleto,cpf,telefone,dataNasc,sexo, endereco,
			salario,dataContratacao,cargo,senha, nome_user, FK_Cpf_Func,
			FK_User_Supervisor);
		return retorno ;
	}

}
