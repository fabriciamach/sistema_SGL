package principal;


import controller.LoginController;
import model.Funcionario;
import view.TelaLogin;



public class Aplicativo {

	public static void main(String[] args) {
		
		
		TelaLogin login = new TelaLogin();
		Funcionario usuario = new Funcionario();
		LoginController contr = new LoginController(login,usuario);
		login.registerListener(contr);
		login.setVisible(true);

		
		
		
	}

}
