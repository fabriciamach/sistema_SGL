package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import dao.ExceptionDAO;
import dao.ProdutoDAO;
import model.Produto;
import model.Venda;
import view.TelaMenuFunc;
import view.TelaVenda;

public class VendaController implements ActionListener {

	private Venda model;
	private TelaVenda view;
	
	
	

	public VendaController(Venda model, TelaVenda view) {
		super();
		this.model = model;
		this.view = view;
	}




	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		String msg = null;
		
		if(e.getSource() == view.getBotProduto()) {
			String cod = view.getCodigoProd() ;
			Produto prod =new Produto();
			try {
				prod.excluirProdutoModel(cod);
			} catch (ExceptionDAO e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
			view.setProdVenda(cod);
		
		
			
		}else {
			if(e.getSource() == view.getBotSalvarVenda()) {
				
				try {
					 msg = model.RegistrarVendaModel(view);  
					view.atualizaTela(msg);
					
				} catch (ExceptionDAO e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}else {
				if(e.getSource() ==  view.getBotCancelarVenda()) {
					view.atualizaTela("Operação cancelada!");
				}else {
					if(e.getSource() == view.getBotVoltarVenda()) {
						view.dispose();
						TelaMenuFunc telaMenuF = new TelaMenuFunc();
						MenuFuncController cont = new MenuFuncController(telaMenuF);
						telaMenuF.registerListener(cont);
						telaMenuF.setVisible(true);
					}
				}
			}
			
		}
		
	}
	
	

}
