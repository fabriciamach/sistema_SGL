package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dao.ExceptionDAO;
import model.Funcionario;
import view.TelaLogin;
import view.TelaMenuFunc;
import view.TelaMenuGerente;


public class LoginController implements ActionListener {


	private TelaLogin view;
	private Funcionario model;
	
	

	public LoginController(TelaLogin view, Funcionario model) {
		super();
		this.view = view;
		this.model = model;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== view.getBotEntrar() && !view.getLogin().isEmpty() && !view.getSenha().isEmpty()) {
			Funcionario usuario = new Funcionario();
			usuario.setNome_user(view.getLogin());
			usuario.setSenha(view.getSenha());
		
			try {
				String resp = usuario.verificaLoginModel(usuario);
				
				if (resp == "Gerente") {
					model.serealizaLogin(usuario);
					view.setVisible(false);
					TelaMenuGerente tela = new TelaMenuGerente();
					MenuGerenteController cont = new MenuGerenteController(tela);
					tela.registerListener(cont);
					tela.setVisible(true);
				}else{
					if(resp == "Funcionário") {
						view.setVisible(false);
						model.serealizaLogin(usuario);
						TelaMenuFunc telaF =  new TelaMenuFunc();
						MenuFuncController contF = new MenuFuncController(telaF);
						telaF.registerListener(contF);
						telaF.setVisible(true);
					}else {
						if( resp == "nulo") {
							view.atualizaTela("Usário e/ou senha iválidos");
						}
					}
				}
			} catch (ExceptionDAO e1) {
				view.atualizaTela("Usário e/ou senha iválidos");
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else {
			view.atualizaTela("Usário e/ou senha iválidos");
			
		
	}

	
	}
	
}
