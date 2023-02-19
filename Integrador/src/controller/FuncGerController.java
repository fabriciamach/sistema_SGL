package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dao.ExceptionDAO;
import dao.FuncionarioDAO;
import model.Funcionario;
import view.CadastroFunc;
import view.TelaEditaFunc;
import view.TelaFuncGer;
import view.TelaMenuGerente;

public class FuncGerController implements ActionListener{

	private Funcionario model;
	private TelaFuncGer view;




	public FuncGerController(Funcionario model, TelaFuncGer view) {
		super();
		this.model = model;
		this.view = view;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		String cpfFunc = view.getCPFFunc();
		if(e.getSource()== view.getBotPesquisar()) {
		
			try {
				model= model.pesquisarFuncionarioBD(cpfFunc);
				
				if(model.getCpf()!=null) {
					view.setTextoInfFunc(model.toString());
				}else {
					view.atualizaTela("Funcionário não encontrado!");
				}
			} catch (ExceptionDAO e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}else {
			if(e.getSource() == view.getBotCadastrarFunc()) {
				view.dispose();
				CadastroFunc telaCadFunc = new CadastroFunc();
				CadFuncController controllerF= new CadFuncController(model, telaCadFunc);
				telaCadFunc.registerListener(controllerF);
				telaCadFunc.setVisible(true);
			}else {
				if(e.getSource()  == view.getBotEditFunc()) {
					view.setVisible(false);
					TelaEditaFunc telaEF = new TelaEditaFunc();
					EditaFuncController controllerEF = new EditaFuncController(model,telaEF);
					
					FuncionarioDAO func = new FuncionarioDAO();
					try {
						model = func.dadosFuncEdicao(cpfFunc);
					} catch (ExceptionDAO e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					telaEF.setNome(model.getNomeCompleto());
					telaEF.setCPF(model.getCpf());
					telaEF.setTelefone(model.getTelefone());
					telaEF.setDataNasc(model.getDataNasc());
					telaEF.setEndereco(model.getEndereco());
					
					telaEF.setSalario(model.getSalario());
					telaEF.setDataContr(model.getDataContratacao());
					telaEF.setCargo(model.getCargo());
					telaEF.setSenha(model.getSenha());
					telaEF.setUser(model.getNome_user());
					
					telaEF.registerListener(controllerEF);
					telaEF.setVisible(true);
					
					
				}else {
					if(e.getSource() == view.getBotExclFunc()) {
						
						try {
							model.excluirFuncionarioBD(cpfFunc);
							view.atualizaTela("Funcionario excluido com sucesso!");
							view.setTextoInfFunc(" ");
						} catch (ExceptionDAO e1) {
							view.atualizaTela("Erro ao excluir funcionário");
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						if(e.getSource()== view.getBotVoltarFunc()) {
							view.dispose();
							TelaMenuGerente telaMenuG = new TelaMenuGerente();
							MenuGerenteController cont = new MenuGerenteController(telaMenuG );
							telaMenuG .registerListener(cont);
							telaMenuG.setVisible(true);
						}
					}
				}
			}
		}
		
	}

}
