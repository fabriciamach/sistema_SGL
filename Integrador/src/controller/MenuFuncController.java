package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.ExceptionDAO;
import model.Pessoa;
import model.Produto;
import model.Venda;
import view.TelaClienteFunc;
import view.TelaEstoqueFunc;
import view.TelaMenuFunc;
import view.TelaVenda;

public class MenuFuncController  implements ActionListener{

	private TelaMenuFunc view;


	

	public MenuFuncController(TelaMenuFunc view) {
		super();
		this.view = view;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() ==  view.getBotEstoqueFunc()) {
			view.dispose();
			Produto produto = new Produto();
			TelaEstoqueFunc telaEstFun = new TelaEstoqueFunc();
			EstoqueFuncController cont = new EstoqueFuncController(produto,telaEstFun);
			telaEstFun.registerListener(cont);
			telaEstFun.setVisible(true);
			
		}else {
			if(e.getSource() == view.getBotClientesFunc()) {
				view.dispose();
				Pessoa pessoa = new Pessoa();
				TelaClienteFunc telaFuncPesqClien = new TelaClienteFunc();
				FunPesqClienController controller = new FunPesqClienController(pessoa, telaFuncPesqClien);
				telaFuncPesqClien.registerListener(controller);
				telaFuncPesqClien.setVisible(true);
			}else {
				if(e.getSource() == view.getBotVendaFunc()) {
					view.dispose();
					Venda venda  = new Venda();
					TelaVenda telaVenda = new TelaVenda();
					VendaController contr = new VendaController(venda, telaVenda);
					int num;
					try {
						num = Venda.proximaVenda();
						telaVenda.setNumVenda(num);
					} catch (ExceptionDAO e1) {
						// TODO Auto-generated catch block
						num=0;
						e1.printStackTrace();
					}
					telaVenda.registerListener(contr);
					telaVenda.setVisible(true);
				}
			}
		}
	}

	
}
