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

import controller.FuncGerController;

public class TelaFuncGer extends JFrame {

	private JPanel contentPane;
	private JTextField CPFFunc;
	private JButton BotPesquisar;
	private JButton BotCadastrarFunc;
	private JButton BotEditFunc;
	private JButton BotExclFunc;
	private JButton BotVoltarFunc;
	private JTextArea TextoInfFunc;
	

	
	public JTextArea getTextoInfFunc() {
		return TextoInfFunc;
	}
	public void setTextoInfFunc(String textoInfFunc) {
		TextoInfFunc.setText(textoInfFunc);
	}
	public JButton getBotCadastrarFunc() {
		return BotCadastrarFunc;
	}
	public void setBotCadastrarFunc(JButton botCadastrarFunc) {
		BotCadastrarFunc = botCadastrarFunc;
	}
	public JButton getBotEditFunc() {
		return BotEditFunc;
	}
	public void setBotEditFunc(JButton botEditFunc) {
		BotEditFunc = botEditFunc;
	}
	public JButton getBotExclFunc() {
		return BotExclFunc;
	}
	public void setBotExclFunc(JButton botExclFunc) {
		BotExclFunc = botExclFunc;
	}
	public JButton getBotVoltarFunc() {
		return BotVoltarFunc;
	}
	public void setBotVoltarFunc(JButton botVoltarFunc) {
		BotVoltarFunc = botVoltarFunc;
	}
	public String getCPFFunc() {
		return CPFFunc.getText();
	}
	public void setCPFFunc(JTextField cPFFunc) {
		CPFFunc = cPFFunc;
	}
	public JButton getBotPesquisar() {
		return BotPesquisar;
	}
	public void setBotPesquisar(JButton botPesquisar) {
		BotPesquisar = botPesquisar;
	}
	public TelaFuncGer() {
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
		
		JLabel MsgCPFFunc = new JLabel("Digite o CPF do Funcinário");
		MsgCPFFunc.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		MsgCPFFunc.setBounds(59, 118, 295, 38);
		contentPane.add(MsgCPFFunc);
		
		CPFFunc = new JTextField();
		CPFFunc.setBounds(59, 162, 295, 29);
		contentPane.add(CPFFunc);
		CPFFunc.setColumns(10);
		
		JLabel MsgFunc = new JLabel("Funcionário");
		MsgFunc.setFont(new Font("Arial Black", Font.PLAIN, 28));
		MsgFunc.setBounds(99, 33, 225, 58);
		contentPane.add(MsgFunc);
		
		BotPesquisar = new JButton("");
		BotPesquisar.setIcon(new ImageIcon(".\\src\\imagens\\lupa.png"));
		BotPesquisar.setBounds(364, 163, 29, 28);
		contentPane.add(BotPesquisar);
		
		BotCadastrarFunc = new JButton("Cadastrar");
		BotCadastrarFunc.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotCadastrarFunc.setBounds(174, 314, 150, 48);
		contentPane.add(BotCadastrarFunc);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(568, 292, 14, -72);
		contentPane.add(separator);
		
		TextoInfFunc = new JTextArea();
		TextoInfFunc.setEditable(false);
		TextoInfFunc.setBounds(500, 0, 334, 494);
		contentPane.add(TextoInfFunc);
		
		JLabel ImgFunc1 = new JLabel("");
		ImgFunc1.setIcon(new ImageIcon(".\\src\\imagens\\funcionarios.png"));
		ImgFunc1.setBounds(59, 33, 38, 58);
		contentPane.add(ImgFunc1);
		
		BotEditFunc = new JButton("Editar");
		BotEditFunc.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotEditFunc.setBounds(106, 385, 125, 48);
		contentPane.add(BotEditFunc);
		
		BotExclFunc = new JButton("Excluir");
		BotExclFunc.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotExclFunc.setBounds(268, 385, 125, 48);
		contentPane.add(BotExclFunc);
		/*
		JCheckBox HabilitarEditFunc = new JCheckBox("Modo de Edição de Funcionário");
		HabilitarEditFunc.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		HabilitarEditFunc.setBackground(new Color(143, 191, 231));
		HabilitarEditFunc.setBounds(59, 197, 295, 23);
		contentPane.add(HabilitarEditFunc);*/
		
		BotVoltarFunc = new JButton("Voltar");
		BotVoltarFunc.setBounds(10, 460, 89, 23);
		contentPane.add(BotVoltarFunc);
		

	}
	public void registerListener(FuncGerController controller) {
		BotPesquisar.addActionListener(controller);
		BotCadastrarFunc.addActionListener(controller);
		BotEditFunc.addActionListener(controller);
		BotExclFunc.addActionListener(controller);
		BotVoltarFunc.addActionListener(controller);
		
		
	}
	public void atualizaTela(String msg) {
		JOptionPane.showMessageDialog(null,msg);
	}
}

