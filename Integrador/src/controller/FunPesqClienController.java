package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import dao.ExceptionDAO;
import model.Pessoa;
import view.TelaClienteFunc;
import view.TelaMenuFunc;

public class FunPesqClienController implements ActionListener {

	private Pessoa model;
	private TelaClienteFunc view;



	public FunPesqClienController(Pessoa model, TelaClienteFunc view) {
		super();
		this.model = model;
		this.view = view;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == view.getBotPesquisarCliente()) {
			String cpf = view.getCPFCliente();
			
			//PessoaDAO pes = new PessoaDAO();
				try {
					model = model.procurarPessoaBD(cpf);
					if(model.getCpf()!=null) {
						view.setTextoInfCliente(model.toString());
					}else {
						view.atualizaTela("Cliente não encontrado!");
					}
				} catch (ExceptionDAO e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		}else {
			if(e.getSource() == view.getBotVoltarCliente()) {
				view.dispose();
				TelaMenuFunc telaMenuF = new TelaMenuFunc();
				MenuFuncController cont = new MenuFuncController(telaMenuF);
				telaMenuF.registerListener(cont);
				telaMenuF.setVisible(true);
			}
				
		}
		
		
		
	}
}
	
