package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MenuFuncController;

public class TelaMenuFunc extends JFrame {

	private JPanel contentPane;
	private JButton BotEstoqueFunc;
	private JButton BotClientesFunc;
	private JButton BotVendaFunc;
	
	public JButton getBotEstoqueFunc() {
		return BotEstoqueFunc;
	}

	public void setBotEstoqueFunc(JButton botEstoqueFunc) {
		BotEstoqueFunc = botEstoqueFunc;
	}

	public JButton getBotClientesFunc() {
		return BotClientesFunc;
	}

	public void setBotClientesFunc(JButton botClientesFunc) {
		BotClientesFunc = botClientesFunc;
	}

	public JButton getBotVendaFunc() {
		return BotVendaFunc;
	}

	public void setBotVendaFunc(JButton botVendaFunc) {
		BotVendaFunc = botVendaFunc;
	}

	public TelaMenuFunc() {
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
		
		JLabel MsgOperacaoFunc = new JLabel("Operações Funcionário:");
		MsgOperacaoFunc.setFont(new Font("Arial Black", Font.PLAIN, 20));
		MsgOperacaoFunc.setBounds(124, 44, 303, 50);
		contentPane.add(MsgOperacaoFunc);
		
		
		BotEstoqueFunc = new JButton("Estoque");
		BotEstoqueFunc.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotEstoqueFunc.setBounds(326, 160, 166, 50);
		contentPane.add(BotEstoqueFunc);
		
		BotClientesFunc = new JButton("Clientes");
		BotClientesFunc.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotClientesFunc.setBounds(326, 243, 166, 50);
		contentPane.add(BotClientesFunc);
		
		BotVendaFunc = new JButton("Venda\r\n");
		BotVendaFunc.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotVendaFunc.setBounds(326, 330, 166, 50);
		contentPane.add(BotVendaFunc);
		
		JLabel ImgIcon = new JLabel("");
		ImgIcon.setIcon(new ImageIcon(".\\src\\imagens\\shoes.png"));
		ImgIcon.setBounds(57, 25, 64, 56);
		contentPane.add(ImgIcon);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(".\\src\\imagens\\Fundo.png"));
		fundo.setBounds(232, 100, 352, 352);
		contentPane.add(fundo);
		
		
	}

	public void registerListener(MenuFuncController controller) {
		BotEstoqueFunc.addActionListener(controller);
		BotClientesFunc.addActionListener(controller);
		BotVendaFunc.addActionListener(controller);
		
		
	}
}
