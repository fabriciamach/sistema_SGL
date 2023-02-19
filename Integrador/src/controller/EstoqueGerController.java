package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import dao.ExceptionDAO;
import model.Produto;
import view.CadastroProduto;
import view.TelaEditaProduto;
import view.TelaEstoqueGer;
import view.TelaMenuGerente;

public class EstoqueGerController implements ActionListener {

	public Produto model;
	public TelaEstoqueGer view;
	
	


	public EstoqueGerController(Produto model, TelaEstoqueGer view) {
		super();
		this.model = model;
		this.view = view;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getBotPesquisar()) {
			String codProd = view.getCodProduto();
			try {
				model =model.pesquisaProdutoBD(codProd);
			
				if(model.getModelo() == null) {
					view.atualizaTela("Produto não encontrado!");
				}else {
					view.setTextoInfProduto(model.toString());
				}
			} catch (ExceptionDAO e1) {
				
				e1.printStackTrace();
			}
			
		}else {
			if(e.getSource() == view.getBotCadastrarProd() ) {
				view.setVisible(false);
				CadastroProduto telCadProduto = new CadastroProduto();
				CadProdController controllerP = new CadProdController(model,telCadProduto);
				telCadProduto.registerListener(controllerP);
				telCadProduto.setVisible(true);
			}else {
				if(e.getSource() == view.getBotEditProd()) {
					String codProd = view.getCodProduto();
					try {
						
						model = model.pesquisaProdutoModel(codProd);
					} catch (ExceptionDAO e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 view.setVisible(false);
					 TelaEditaProduto telaEP= new TelaEditaProduto();
					 EditaProdController contro = new  EditaProdController(model,telaEP);
					 telaEP.setCodProd(model.getCodigo());
					 telaEP.setCodProd(model.getCor());
					 telaEP.setModelo(model.getModelo());
					 telaEP.setFabricante(model.getFabricante());
					 telaEP.settGenero(model.getGenero());
					 telaEP.settTam(model.getTamanho());
					 telaEP.setPreco(model.getPreco());
					 telaEP.registerListener(contro);
					 telaEP.setVisible(true);
				}else {
					if(e.getSource() == view.getBotExclProd()) {
						String codProd = view.getCodProduto();
						try {
							model.excluirProdutoModel(codProd);
							view.atualizaTela("Produto excluido!");
							view.setTextoInfProduto("   ");
							
						} catch (ExceptionDAO e1) {
							view.atualizaTela("Erro ao excluir produto!");
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						if(e.getSource() == view.getBotaoVoltarEstoque() ) {
							view.setVisible(false);
							TelaMenuGerente telaMenuGer = new TelaMenuGerente();
							MenuGerenteController contr = new MenuGerenteController(telaMenuGer);
							telaMenuGer.registerListener(contr);
							telaMenuGer.setVisible(true);
						}
					}
				}
			}
		}
		
	}

}
