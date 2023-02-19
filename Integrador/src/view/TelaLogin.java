package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;


public class TelaLogin extends JFrame {

	private JPanel contener;
	private JTextField Login;
	private JPasswordField Senha;
	private JLabel Titulo;
	private JLabel Subtitulo;
	private JLabel Msg;
	private JLabel ImgLogin;
	private JButton BotEntrar;

	
	
	public String getLogin() {
		return Login.getText();
	}



	public void setLogin(JTextField login) {
		Login = login;
	}



	public String getSenha() {
		return Senha.getText();
	}



	public void setSenha(JPasswordField senha) {
		Senha = senha;
	}




	public JButton getBotEntrar() {
		return BotEntrar;
	}



	public void setBotEntrar(JButton botEntrar) {
		BotEntrar = botEntrar;
	}



	public TelaLogin() {
		setTitle("SGL ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\src\\imagens\\Icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 533);
		contener = new JPanel();
		contener.setBackground(new Color(143, 191, 231));
		contener.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contener);
		contener.setLayout(null);
		
		JLabel MsgLogin = new JLabel("Nome de Usuário:");
		MsgLogin.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		MsgLogin.setBounds(253, 203, 200, 39);
		contener.add(MsgLogin);
		
		Login = new JTextField();
		Login.setBounds(253, 253, 380, 31);
		contener.add(Login);
		Login.setColumns(10);
		
		JLabel MsgSenha = new JLabel("Senha:");
		MsgSenha.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		MsgSenha.setBounds(253, 321, 66, 23);
		contener.add(MsgSenha);
		
		 BotEntrar = new JButton("Entrar");
		BotEntrar.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		
	
		
		BotEntrar.setBounds(375, 412, 111, 39);
		contener.add(BotEntrar);
		
		Senha = new JPasswordField();
		Senha.setBounds(253, 355, 380, 31);
		contener.add(Senha);
		
		Titulo = new JLabel("SGL      \r\n\r\n");
		Titulo.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 66));
		Titulo.setBounds(316, 21, 260, 116);
		contener.add(Titulo);
		
		Subtitulo = new JLabel("Sistema Gerenciador de Loja\r\n");
		Subtitulo.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
		Subtitulo.setBounds(326, 117, 286, 39);
		contener.add(Subtitulo);
		
		Msg = new JLabel("Seja Bem vindo!");
		Msg.setFont(new Font("Arial Black", Font.PLAIN, 20));
		Msg.setBounds(338, 167, 233, 31);
		contener.add(Msg);
		
		ImgLogin = new JLabel("");
		ImgLogin.setIcon(new ImageIcon(".\\src\\imagens\\private.png"));
		ImgLogin.setBounds(191, 28, 128, 128);
		contener.add(ImgLogin);
		
		setResizable(false);
		

		}
	public void registerListener(LoginController controller) {
		BotEntrar.addActionListener(controller);
	}
	public void atualizaTela(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
}
