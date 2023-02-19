package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Funcionario;
import view.TelaEditaFunc;

public class EditaFuncController implements ActionListener{

	private Funcionario model;
	private TelaEditaFunc view;
	
	public EditaFuncController(Funcionario model, TelaEditaFunc view) {
		super();
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == view.getBotSalvarEditFunc()) {
			String msg = model.editarFuncionarioModel(view);
			view.atualizaTela(msg);
		}
	}
	
	
}
