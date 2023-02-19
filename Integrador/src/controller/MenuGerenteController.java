package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.ExceptionDAO;
import model.Funcionario;
import model.Pessoa;
import model.Produto;
import model.Venda;
import view.AlterarDadosGer;
import view.TelaClienteGer;
import view.TelaEstoqueGer;
import view.TelaFuncGer;
import view.TelaMenuGerente;
import view.TelaVendaGer;

public class MenuGerenteController implements ActionListener {

	public TelaMenuGerente view;
	

	public MenuGerenteController(TelaMenuGerente view) {
		super();
		this.view = view;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getBotEstoqueGer()) {
			view.setVisible(false);
			Produto produto = new Produto();
			TelaEstoqueGer telaEstGer = new TelaEstoqueGer();
			EstoqueGerController contr = new EstoqueGerController(produto, telaEstGer);
			telaEstGer.registerListener(contr);
		    telaEstGer.setVisible(true);
		   
			
		
		}else {
			if(e.getSource() == view.getBotClientesGer() ) {
				view.setVisible(false);
				Pessoa pessoa = new Pessoa();
				TelaClienteGer telaGerPesqCliente = new TelaClienteGer();
				ClienteGerController contr = new ClienteGerController(pessoa, telaGerPesqCliente);
				telaGerPesqCliente.registerListener(contr);
				telaGerPesqCliente.setVisible(true);
			}else {
				if(e.getSource() == view.getBotVendaGer()) {
					view.setVisible(false);
					Venda venda = new Venda();
					TelaVendaGer telaVendaG = new TelaVendaGer();
					VendaGerController controllerV = new VendaGerController(telaVendaG, venda);
					int num;
					try {
						num = Venda.proximaVenda();
						telaVendaG.setNumVenda(num);
					} catch (ExceptionDAO e1) {
						// TODO Auto-generated catch block
						num=0;
						e1.printStackTrace();
					}
				
					telaVendaG.registerListener(controllerV);
					telaVendaG.setVisible(true);
				}else {
					if(e.getSource() == view.getBotFuncGer()) {
						view.setVisible(false);
						Funcionario func = new Funcionario();
						TelaFuncGer telaFuncGer = new TelaFuncGer();
						FuncGerController controllerF = new FuncGerController(func, telaFuncGer);
						telaFuncGer.registerListener(controllerF);
						telaFuncGer.setVisible(true);
					}else {
						if(e.getSource() == view.getBotDadosGer()) {
							view.setVisible(false);
							Funcionario gerente = new Funcionario();
							AlterarDadosGer telaAltDadGer = new AlterarDadosGer();
							AlterarDadosGerController controG = new AlterarDadosGerController(gerente,telaAltDadGer);
							
							try {
								gerente = gerente.AlterarGerenteModel(gerente);
								telaAltDadGer.setNome(gerente.getNomeCompleto());
								telaAltDadGer.setCPF(gerente.getCpf());
								telaAltDadGer.setTelefone(gerente.getTelefone());
								telaAltDadGer.setDataNasc(gerente.getDataNasc());
								telaAltDadGer.setUser(gerente.getNome_user());
								telaAltDadGer.setSenha(gerente.getSenha());
								telaAltDadGer.setDataContr(gerente.getDataContratacao());
								telaAltDadGer.setSalario(gerente.getSalario());		
								telaAltDadGer.setSexo(gerente.getSexo());
								telaAltDadGer.setEndereco(gerente.getEndereco());
							} catch (ExceptionDAO e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							telaAltDadGer.registerListener(controG);
							telaAltDadGer.setVisible(true);
							
						}
					}
				}
			}
		}
		
	}

}
