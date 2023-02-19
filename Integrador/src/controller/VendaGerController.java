package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import dao.ExceptionDAO;
import model.Produto;
import model.Venda;
import view.TelaMenuGerente;
import view.TelaVendaGer;

public class VendaGerController implements ActionListener {

	private TelaVendaGer view;
	private Venda model;

	

	public VendaGerController(TelaVendaGer view, Venda model) {
		super();
		this.view = view;
		this.model = model;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		ArrayList<String> codigos = new ArrayList<String>();
		String msg = null;
		
		if(e.getSource() == view.getBotProduto()) {
			String cod = view.getCodigoProd();
			codigos.add(cod);
			Produto prod =new Produto();
			try {
				prod.excluirProdutoModel(cod);
			} catch (ExceptionDAO e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
			view.setProdVenda(cod);
		}else{
			if(e.getSource() == view.getBotSalvarVenda()) {
				try {
					msg = model.RegistrarVendaGerModel(view);
					view.atualizaTela(msg);
				} catch (ExceptionDAO e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}else {
				if(e.getSource() ==  view.getBotCancelarVenda()) {
					view.atualizaTela("Operação cancelada!");
				}
				else {
					if(e.getSource() == view.getBotVoltarVenda() ) {
						view.dispose();
						TelaMenuGerente telaMenuG = new TelaMenuGerente();
						MenuGerenteController cont = new MenuGerenteController(telaMenuG);
						telaMenuG.registerListener(cont);
						telaMenuG.setVisible(true);
					}
				}
			}
		}
				
		
	}

}
