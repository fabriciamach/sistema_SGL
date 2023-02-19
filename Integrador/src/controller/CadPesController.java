package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dao.ExceptionDAO;
import model.Pessoa;
import view.CadastroCliente;


public class CadPesController implements ActionListener{
	
	private Pessoa model;
	private CadastroCliente view;
	
	
	
	public CadPesController(Pessoa model, CadastroCliente view) {
		super();
		this.model = model;
		this.view = view;
	}
	


	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()== view.getBotSalvarCliente() ) {
			try {
				String msg = model.CadastrarPessoaModel(view);
				view.atualizaTela(msg);
			} catch (ExceptionDAO e1) {
				e1.printStackTrace();
			}
		}
	}
	
}