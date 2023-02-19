package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.ExceptionDAO;
import model.Produto;
import view.TelaEditaProduto;

public class EditaProdController implements ActionListener {

	
	private Produto model;
	private TelaEditaProduto view;
	
	
	
	public EditaProdController(Produto model, TelaEditaProduto view) {
		super();
		this.model = model;
		this.view = view;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== view.getBotSalvarEdProd()) {
			try {
				String msg = model.editarProdutoModel(view);
				view.atualizaTela(msg);
			} catch (ExceptionDAO e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	
}
