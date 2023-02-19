package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Funcionario;
import view.CadastroFunc;

public class CadFuncController implements ActionListener {

	private Funcionario model;
	private CadastroFunc view;
	
	

	public CadFuncController(Funcionario model, CadastroFunc view) {
		super();
		this.model = model;
		this.view = view;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
	
		if(e.getSource() == view.getBotSalvarCadastroFunc()) {
			String msg = model.cadastrarFuncionarioModel(view);
			view.atualizaTela(msg);
		}
	}
}
