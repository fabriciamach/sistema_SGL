package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dao.ExceptionDAO;
import model.Funcionario;
import view.AlterarDadosGer;
import view.TelaMenuGerente;

public class AlterarDadosGerController implements ActionListener{

	private Funcionario model;
	private AlterarDadosGer view;


	public AlterarDadosGerController(Funcionario model, AlterarDadosGer view) {
		super();
		this.model = model;
		this.view = view;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if( e.getSource() == view.getBotSalvarGer()) {
			try {
				model.AlterarGerenteModel(model);
				view.atualizaTela("Dados alterados! \n");
			} catch (ExceptionDAO e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				view.atualizaTela("Erro ao alterar os dados! \n");
			}
		}else {
			if(e.getSource() == view.getBotVoltar()) {
				view.setVisible(false);
				TelaMenuGerente tela = new TelaMenuGerente();
				MenuGerenteController cont = new MenuGerenteController(tela);
				tela.registerListener(cont);
				tela.setVisible(true);
			}
		}
		
	}

}
