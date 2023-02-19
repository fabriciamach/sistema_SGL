package model;


import java.io.Serializable;
import java.util.Date;


import dao.ExceptionDAO;
import dao.FuncionarioDAO;

import view.CadastroFunc;
import view.TelaEditaFunc;

public class Funcionario extends Pessoa  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double Salario;
	private Date DataContratacao;
	private String Cargo;
	private String Senha;
	private String Nome_user;
	private String FK_Cpf_Func;
	private String FK_User_Supervisor;
	
	
	public Funcionario() {
		
	}
	public Funcionario(String nomeCompleto, String cpf, String telefone, Date dataNasc, String sexo, String endereco,
			double salario, Date dataContratacao2, String cargo, String senha, String nome_user, String FK_Cpf_Func,
			String FK_User_Supervisor) {
		super(nomeCompleto, cpf, telefone, dataNasc, sexo, endereco);
		setSalario(salario);
		setDataContratacao(dataContratacao2);
		setCargo(cargo);
		setSenha (senha);
		setNome_user(nome_user);
		setFK_Cpf_Func (FK_Cpf_Func);
		setFK_Cpf_User_Supervisor (FK_User_Supervisor);
	}
	
	
	

	@Override
	public String toString() {
		return super.toString()+ "Salario: " + getSalario() + "\nDataContratacao: " + getDataContratacao() + "\nCargo: " + getCargo()
				+ "\n Nome_user: " + getNome_user() + "\nSupervisor: " + getFK_User_Supervisor() ;
	}
	public double getSalario() {
		return Salario;
	}

	public void setSalario(double salario) {
		if(salario>0 )
			Salario = salario;
	}

	public Date getDataContratacao() {
		return DataContratacao;
	}

	public void setDataContratacao(Date dataContratacao2) {
		if(dataContratacao2!=null )
			DataContratacao = dataContratacao2;
	}

	public String getCargo() {
		return Cargo;
	}

	public void setCargo(String cargo) {
		if(cargo!=null && !cargo.isEmpty())
			Cargo = cargo;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		if(senha!=null && !senha.isEmpty())
			Senha = senha;
	}

	public String getNome_user() {
		return Nome_user;
	}

	public void setNome_user(String nome_user) {
		if(nome_user!=null && !nome_user.isEmpty())
			Nome_user = nome_user;
	}

	public String getFK_Cpf_Func() {
		return FK_Cpf_Func;
	}

	public void setFK_Cpf_Func(String fK_Cpf_Func) {
		if(fK_Cpf_Func.length()>10 && !fK_Cpf_Func.isEmpty())
			FK_Cpf_Func = fK_Cpf_Func;
	}

	public String getFK_User_Supervisor() {
		return FK_User_Supervisor;
	}

	public void setFK_Cpf_User_Supervisor(String FK_User_Supervisor) {
		if(FK_User_Supervisor!=null)
			this.FK_User_Supervisor = FK_User_Supervisor;
	}
	
	
		
		
	
	public Funcionario AlterarGerenteModel (Funcionario func) throws ExceptionDAO {
		FuncionarioDAO ger = new FuncionarioDAO();
		String cpf = ger.procuraCpfGerente();
	    Funcionario geren = new Funcionario();
		geren = ger.dadosFuncEdicao(cpf);
		return geren;
		
	}
	public void cadastrarFuncBD(Funcionario funcionario) throws ExceptionDAO {
		new FuncionarioDAO().cadastrarFuncionario(funcionario);
	}
	
	
	public String cadastrarFuncionarioModel(CadastroFunc view) {
		// TODO Auto-generated method stub
		String msg = null;
		String nomeCompleto = view.getNome();
		String cpf = view.getCPF();
		String telefone = view.getTelefone();
		Date DataNasc = view.getDataNasc();
		String end  = view.getEndereco();
		Date DataCont = view.getDataContr();
		double salario = view.getSalario();
	    String cargo = view.getCargo();
		String nomeUser = view.getUser();
		String senha = view.getSenha();
		String sexo = null;
		
		if(view.getMasculino().isSelected()) {
			sexo = "M";
		}else {
			if(view.getFeminino().isSelected()) {
				sexo = "F";
			}
		}
		
		String userSup =null;
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		if(cargo == "Gerente") {
			userSup = "-";
		}else {
			try {
				userSup = funcionarioDAO.buscaUserSup();
				FactoryPessoa fp = new FactoryPessoa();
				Funcionario funcionario = (Funcionario)fp.getFuncionario(nomeCompleto,cpf,telefone,DataNasc,sexo, end,
						salario,DataCont,cargo,senha, nomeUser,cpf,userSup);
				if(funcionario != null ) {
					cadastrarFuncBD(funcionario);
					msg ="Funcionario cadastrado com sucesso!";
				}else {
					msg = "Os dados não foram prenchidos corretamente!";
					
				}
			} catch (ExceptionDAO e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				msg = "Não foi encontrado um Gerente cadastrado! \n"
						+ "Cadastre um Gerente primeiro";
			}
		}
		return msg;
		
	}
	public void excluirFuncionarioBD(String cpf) throws ExceptionDAO {
		new FuncionarioDAO().excluirFuncionario(cpf);
	}
	public Funcionario pesquisarFuncionarioBD(String cpf) throws ExceptionDAO {
		FuncionarioDAO func = new FuncionarioDAO();
		Funcionario funcio = new Funcionario();
		funcio = func.dadosFuncEdicao(cpf);
		return funcio;
	
		
	}
	public String editarFuncionarioModel(TelaEditaFunc view) {
		String msg = null;
		// TODO Auto-generated method stub
		String nomeCompleto = view.getNome();
		String cpf = view.getCPF();
		String telefone = view.getTelefone();
		Date DataNasc = view.getDataNasc();
		String end  = view.getEndereco();
		Date DataCont = view.getDataContr();
		double salario = view.getSalario();
	    String cargo = view.getCargo();
		String nomeUser = view.getUser();
		String senha = view.getSenha();
		String sexo = null;
		
		if(view.getMasculino().isSelected()) {
			sexo = "M";
		}else {
			if(view.getFeminino().isSelected()) {
				sexo = "F";
			}
		}
		
		String userSup =null;
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		if(cargo == "Gerente") {
			userSup = "-";
		}else {
			try {
				userSup = funcionarioDAO.buscaUserSup();
				FactoryPessoa fp = new FactoryPessoa();
				Funcionario funcionario = (Funcionario)fp.getFuncionario(nomeCompleto,cpf,telefone,DataNasc,sexo, end,
						salario,DataCont,cargo,senha, nomeUser,cpf,userSup);
				if(funcionario != null ) {
					editarFuncBD(funcionario);
					msg="Funcionario atualizado com sucesso!";
				}else {
					msg = "Os dados não foram prenchidos corretamente!";;
				}
			} catch (ExceptionDAO e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				msg = "Não foi encontrado um Gerente cadastrado! \n"
						+ "Cadastre um Gerente primeiro";
				
			}
		}
		return msg;
	}
	public void editarFuncBD(Funcionario funcionario) throws ExceptionDAO {
		new FuncionarioDAO().editarFuncionario(funcionario);
	}
	public String verificaLoginModel(Funcionario user) throws ExceptionDAO {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario compara = new Funcionario();
		String resp= null;
		compara = funcionarioDAO.verificaLogin(user.getNome_user());
		
		String compS =  compara.getSenha();
		String compC= compara.getCargo();
	
		String userS = user.getSenha();
		
		
		if( compS.equals(userS)) {
			if(compC.equals("Gerente")) {
				resp = "Gerente";
			}else {
				resp = "Funcionário";
			}
		}else {
			resp = "nulo";
		}
		return resp;
		
	}
	public void serealizaLogin(Funcionario usuario){
		Serializador s = new Serializador();
		  try { 
			  s.serializar("./usuario01.obj", usuario);
			  System.out.println("serealizado");
		  } catch (Exception ex){
			  ex.printStackTrace();
			  System.err.println("Falha ao serializar! - " + ex.toString());
		  }
	}

}