package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.ExceptionDAO;
import model.Pessoa;
import view.TelaClienteGer;
import view.TelaEditaCliente;

public class EditaClienteController implements ActionListener {

	private Pessoa model;
	private TelaEditaCliente view;
	
	
	public EditaClienteController(Pessoa model, TelaEditaCliente view) {
		super();
		this.model = model;
		this.view = view;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if( e.getSource() == view.getBotSalvarAltClie()) {
			try {
				String msg = model.editarPessoaModel(view);
				view.atualizaTela(msg);
			} catch (ExceptionDAO e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else {
			if(e.getSource()==view.getBotVoltar()) {
				view.setVisible(false);
				TelaClienteGer tela = new TelaClienteGer();
				ClienteGerController cont = new ClienteGerController(model,tela);
				tela.registerListener(cont);
				tela.setVisible(true);
			}
		}
		
	}
	
	
}
