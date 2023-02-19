package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MenuGerenteController;

import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMenuGerente extends JFrame {

	private JPanel contentPane;
	private JButton BotEstoqueGer;
	private JButton BotClientesGer;
	private JButton BotVendaGer;
	private JButton BotFuncGer;
	private JButton BotDadosGer;

	
	
	public JButton getBotEstoqueGer() {
		return BotEstoqueGer;
	}
	public void setBotEstoqueGer(JButton botEstoqueGer) {
		BotEstoqueGer = botEstoqueGer;
	}
	public JButton getBotClientesGer() {
		return BotClientesGer;
	}
	public void setBotClientesGer(JButton botClientesGer) {
		BotClientesGer = botClientesGer;
	}
	public JButton getBotVendaGer() {
		return BotVendaGer;
	}
	public void setBotVendaGer(JButton botVendaGer) {
		BotVendaGer = botVendaGer;
	}
	public JButton getBotFuncGer() {
		return BotFuncGer;
	}
	public void setBotFuncGer(JButton botFuncGer) {
		BotFuncGer = botFuncGer;
	}
	public JButton getBotDadosGer() {
		return BotDadosGer;
	}
	public void setBotDadosGer(JButton botDadosGer) {
		BotDadosGer = botDadosGer;
	}
	public TelaMenuGerente() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\src\\imagens\\Icon.png"));
		setTitle("SGL\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 533);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 191, 231));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel MsgOperacaoGer = new JLabel("Operações Gerente:");
		MsgOperacaoGer.setFont(new Font("Arial Black", Font.PLAIN, 20));
		MsgOperacaoGer.setBounds(124, 44, 229, 50);
		contentPane.add(MsgOperacaoGer);
		
		
		
		BotEstoqueGer = new JButton("Estoque");
		BotEstoqueGer.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotEstoqueGer.setBounds(326, 126, 166, 50);
		contentPane.add(BotEstoqueGer);
		
		BotClientesGer = new JButton("Clientes");
		BotClientesGer.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotClientesGer.setBounds(326, 187, 166, 50);
		contentPane.add(BotClientesGer);
		
		BotVendaGer = new JButton("Venda\r\n");
		BotVendaGer.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotVendaGer.setBounds(326, 248, 166, 50);
		contentPane.add(BotVendaGer);
		
		BotFuncGer = new JButton("Funcionários");
		BotFuncGer.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotFuncGer.setBounds(326, 309, 166, 50);
		contentPane.add(BotFuncGer);
		
		BotDadosGer = new JButton("Dados do Gerente");
		BotDadosGer.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		BotDadosGer.setBounds(326, 370, 166, 56);
		contentPane.add(BotDadosGer);
		
		JLabel ImgIcon = new JLabel("");
		ImgIcon.setIcon(new ImageIcon(".\\src\\imagens\\shoes.png"));
		ImgIcon.setBounds(57, 25, 64, 56);
		contentPane.add(ImgIcon);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(".\\src\\imagens\\Fundo.png"));
		fundo.setBounds(232, 100, 352, 352);
		contentPane.add(fundo);
		
	
		
	}
	public void registerListener(MenuGerenteController controller) {
		BotEstoqueGer.addActionListener(controller);
		BotEstoqueGer.addActionListener(controller);
		BotClientesGer.addActionListener(controller);
		BotVendaGer.addActionListener(controller);
		BotFuncGer.addActionListener(controller);
		BotDadosGer.addActionListener(controller);
		
		
		
	}

}
