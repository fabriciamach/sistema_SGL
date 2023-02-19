package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.ExceptionDAO;
import model.Produto;
import view.TelaEstoqueFunc;
import view.TelaMenuFunc;

public class EstoqueFuncController implements ActionListener{

	private Produto model;
	private TelaEstoqueFunc view;
	
	


	public EstoqueFuncController(Produto model, TelaEstoqueFunc view) {
		super();
		this.model = model;
		this.view = view;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method 
		 String codProd;
		 String msg = null;
		 
		if(e.getSource() == view.getBotPesquisarProd() ) {
			if(!view.getCodProduto().isEmpty()) {
				codProd = view.getCodProduto();
				try {
					model = model.pesquisaProdutoBD(codProd);
					if(model.getCodigo()== null) {
						msg ="Produto não encontrado!";
						view.atualizaTela(msg);
					}else {
						view.setTextoInfProd(model.toString());
					}
					
				} catch (ExceptionDAO e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
									}
			}else {
				msg ="Digite um código para ser pesquisado!";
				view.atualizaTela(msg);
			}
			  
		}else {
			if(e.getSource() == view.getBotVoltarEstoqueFunc()) {
				view.dispose();
				TelaMenuFunc telaMenuF = new TelaMenuFunc();
				MenuFuncController cont = new MenuFuncController(telaMenuF);
				telaMenuF.registerListener(cont);
				telaMenuF.setVisible(true);
			}
		}
	}

 
}
