package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dao.ExceptionDAO;
import model.Pessoa;
import view.CadastroCliente;
import view.TelaClienteGer;
import view.TelaEditaCliente;
import view.TelaMenuGerente;

public class ClienteGerController implements ActionListener {

	
	private Pessoa model;
	private TelaClienteGer view;
	


	public ClienteGerController(Pessoa model, TelaClienteGer view) {
		
		this.model = model;
		this.view = view;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
	
		String cpf = view.getCPFCliente();

		if(e.getSource() == view.getBotPesquisarCliente() ) {
			try {
				model = model.procurarPessoaBD(cpf);
				if(model.getCpf() !=null) {
					view.setTextoInfCliente(model.toString());
				}else {
					String msg = "Cliente não encontrado!";
					view.atualizaTela(msg);
				}
			} catch (ExceptionDAO e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}else {
			if(e.getSource()== view.getBotCadastrarCliente()) {
				view.dispose();
				CadastroCliente tela = new CadastroCliente();
				CadPesController cont = new CadPesController(model,tela);
				tela.registerListener(cont);
				tela.setVisible(true);
				
			}else {
				if(e.getSource() == view.getBotEditCliente()) {
					try {
						model = model.procurarPessoaBD(cpf);
					} catch (ExceptionDAO e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 view.setVisible(false);
					 TelaEditaCliente telaEC= new TelaEditaCliente();
					 EditaClienteController contro = new  EditaClienteController(model,telaEC);
					 telaEC.setNome(model.getNomeCompleto());
					 telaEC.setCPF(model.getCpf());
					 telaEC.setTelefone(model.getTelefone());
					 telaEC.settDataNasc(model.getDataNasc());
					 telaEC.setEndereco(model.getEndereco());
					 telaEC.registerListener(contro);
					 telaEC.setVisible(true);
					
				}else {
					if(e.getSource()==view.getBotVoltarCliente()) {
						view.setVisible(false);
						TelaMenuGerente telaMenuGer = new TelaMenuGerente();
						MenuGerenteController contr = new MenuGerenteController(telaMenuGer);
						telaMenuGer.registerListener(contr);
						telaMenuGer.setVisible(true);
					}else {
						if(e.getSource() == view.getBotExclCliente()) {
							try {
								model.excluirPessoaBD(cpf);
								view.atualizaTela("Cliente excluido com sucesso!");
								
							} catch (ExceptionDAO e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
					}
				}
			}
		}
	}

}
