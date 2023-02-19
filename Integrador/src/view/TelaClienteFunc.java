package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

import controller.CadPesController;
import controller.FunPesqClienController;
import model.Pessoa;

public class TelaClienteFunc extends JFrame {

	private JPanel contentPane;
	private JTextField CPFCliente;
	private JButton BotPesquisarCliente;
	private JButton BotVoltarCliente;
	private JTextArea TextoInfCliente;
	
	
	public JTextArea getTextoInfCliente() {
		return TextoInfCliente;
	}
	public void setTextoInfCliente(String textoInfCliente) {
		TextoInfCliente.setText(textoInfCliente);;
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
	public JButton getBotVoltarCliente() {
		return BotVoltarCliente;
	}
	public void setBotVoltarCliente(JButton botVoltarCliente) {
		BotVoltarCliente = botVoltarCliente;
	}
	public TelaClienteFunc() {
		
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
		
		BotVoltarCliente = new JButton("Voltar");
		BotVoltarCliente.setBounds(10, 460, 89, 23);
		contentPane.add(BotVoltarCliente);
		
	
		
	}
	public void registerListener(FunPesqClienController controller) {
		BotPesquisarCliente.addActionListener(controller);
		BotVoltarCliente.addActionListener(controller);
	}

	public void atualizaTela(String msg) {
		JOptionPane.showMessageDialog(null,msg);
	}
	
}
