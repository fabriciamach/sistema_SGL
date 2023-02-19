package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dao.ExceptionDAO;
import model.Produto;
import view.CadastroProduto;
import view.TelaMenuGerente;

public class CadProdController implements ActionListener {

	private Produto model;
	private CadastroProduto view;
	
	
	
	public CadProdController(Produto model, CadastroProduto view) {
		super();
		this.model = model;
		this.view = view;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == view.getBotSalvarCadastroProd() ) {
			
			if(!view.getCodProd().isEmpty() && !view.getModelo().isEmpty() && !view.getFabricante().isEmpty() && view.getPreco()!= null && !view.getCor().isEmpty() && 
					view.gettTam()>0  && !view.gettGenero().isEmpty()) {
				try {
					String msg = model.cadastrarProdutoModel(view);
					view.atualizaTela(msg);
				} catch (ExceptionDAO e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}else {
			if(e.getSource() == view.getButVoltar()) {
				view.dispose();
				TelaMenuGerente tela = new TelaMenuGerente();
				MenuGerenteController cont = new MenuGerenteController(tela);
				tela.registerListener(cont);
				tela.setVisible(true);
			}
		}
	}


}
