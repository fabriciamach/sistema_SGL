package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ClienteGerController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaClienteGer extends JFrame {

	private JPanel contentPane;
	private JTextField CPFCliente;
	private JButton BotPesquisarCliente;
	private JButton BotCadastrarCliente;
	private JButton BotEditCliente ;
	private JButton BotVoltarCliente;
	private JButton BotExclCliente;
	private JTextArea TextoInfCliente;

	
	public JButton getBotCadastrarCliente() {
		return BotCadastrarCliente;
	}
	public void setBotCadastrarCliente(JButton botCadastrarCliente) {
		BotCadastrarCliente = botCadastrarCliente;
	}
	public JButton getBotEditCliente() {
		return BotEditCliente;
	}
	public void setBotEditCliente(JButton botEditCliente) {
		BotEditCliente = botEditCliente;
	}
	public JButton getBotExclCliente() {
		return BotExclCliente;
	}
	public void setBotExclCliente(JButton botExclCliente) {
		BotExclCliente = botExclCliente;
	}
	public void setTextoInfCliente(JTextArea textoInfCliente) {
		TextoInfCliente = textoInfCliente;
	}
	public JButton getBotVoltarCliente() {
		return BotVoltarCliente;
	}
	public void setBotVoltarCliente(JButton botVoltarCliente) {
		BotVoltarCliente = botVoltarCliente;
	}
	public String getCPFCliente() {
		return CPFCliente.getText();
	}
	public void setCPFCliente(JTextField cPFCliente) {
		CPFCliente = cPFCliente;
	}
	public JButton getBotPesquisarCliente() {
		return BotPesquisarCliente;
	}
	public void setBotPesquisarCliente(JButton botPesquisarCliente) {
		BotPesquisarCliente = botPesquisarCliente;
	}
	public String getTextoInfCliente() {
		return TextoInfCliente.getText();
	}
	public void setTextoInfCliente(String dadosCliente) {
		TextoInfCliente.setText(dadosCliente); 
	}
	public TelaClienteGer() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\src\\imagens\\Icon.png"));
		setTitle("SGL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 533);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 191, 231));
		contentPane.setForeground(new Color(143, 191, 231));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel MsgCPFCliente = new JLabel("Digite o CPF do Cliente:");
		MsgCPFCliente.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		MsgCPFCliente.setBounds(59, 118, 295, 38);
		contentPane.add(MsgCPFCliente);
		
		CPFCliente = new JTextField();
		CPFCliente.setBounds(59, 162, 295, 29);
		contentPane.add(CPFCliente);
		CPFCliente.setColumns(10);
		
		JLabel MsgCliente = new JLabel("Clientes");
		MsgCliente.setFont(new Font("Arial Black", Font.PLAIN, 28));
		MsgCliente.setBounds(99, 33, 132, 58);
		contentPane.add(MsgCliente);
		
		BotPesquisarCliente = new JButton("");
		BotPesquisarCliente.setIcon(new ImageIcon(".\\src\\imagens\\lupa.png"));
		BotPesquisarCliente.setBounds(364, 163, 29, 28);
		contentPane.add(BotPesquisarCliente);
		BotCadastrarCliente = new JButton("Cadastrar");
		/*
		BotCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BotCadastrarCliente(e);
			}
		});*/
		BotCadastrarCliente.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotCadastrarCliente.setBounds(174, 314, 150, 48);
		contentPane.add(BotCadastrarCliente);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(568, 292, 14, -72);
		contentPane.add(separator);
		
		TextoInfCliente = new JTextArea();
		TextoInfCliente.setEditable(false);
		TextoInfCliente.setBounds(500, 0, 334, 494);
		contentPane.add(TextoInfCliente);
		
		JLabel ImgCliente1 = new JLabel("");
		ImgCliente1.setIcon(new ImageIcon(".\\src\\imagens\\cliente.png"));
		ImgCliente1.setBounds(59, 33, 38, 58);
		contentPane.add(ImgCliente1);
		
		BotEditCliente = new JButton("Editar");
		BotEditCliente.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotEditCliente.setBounds(106, 385, 125, 48);
		contentPane.add(BotEditCliente);
		
		BotExclCliente = new JButton("Excluir");
		BotExclCliente.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotExclCliente.setBounds(268, 385, 125, 48);
		contentPane.add(BotExclCliente);
		
	
		
		BotVoltarCliente = new JButton("Voltar");
		BotVoltarCliente.setBounds(10, 460, 89, 23);
		contentPane.add(BotVoltarCliente);

		
	}
	public void registerListener(ClienteGerController controller) {
		BotPesquisarCliente.addActionListener(controller);
		BotCadastrarCliente.addActionListener(controller);
		BotEditCliente.addActionListener(controller);
		BotExclCliente.addActionListener(controller);
		BotVoltarCliente.addActionListener(controller);
	}
	public void atualizaTela(String msg) {
		JOptionPane.showMessageDialog(null,msg);
	    setTextoInfCliente(" ");
	}
}

