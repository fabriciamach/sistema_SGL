package view;

import java.awt.Color;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.EstoqueFuncController;

public class TelaEstoqueFunc extends JFrame {

	private JPanel contentPane;
	private JTextField CodProduto;
	private JButton BotPesquisarProd;
	private JButton BotVoltarEstoqueFunc;
	private JTextArea TextoInfProd ;
	
	
	
	public JTextArea getTextoInfProd() {
		return TextoInfProd;
	}

	public void setTextoInfProd(String textoInfProd) {
		TextoInfProd.setText(textoInfProd);;
	}

	public String getCodProduto() {
		return CodProduto.getText();
	}

	public void setCodProduto(String codProduto) {
		CodProduto.setText(codProduto); 
	}

	public JButton getBotPesquisarProd() {
		return BotPesquisarProd;
	}

	public void setBotPesquisarProd(JButton botPesquisarProd) {
		BotPesquisarProd = botPesquisarProd;
	}

	public JButton getBotVoltarEstoqueFunc() {
		return BotVoltarEstoqueFunc;
	}

	public void setBotVoltarEstoqueFunc(JButton botVoltarEstoqueFunc) {
		BotVoltarEstoqueFunc = botVoltarEstoqueFunc;
	}

	public TelaEstoqueFunc() {
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
		
		JLabel MsgCodProduto = new JLabel("Digite o código do Produto:");
		MsgCodProduto.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		MsgCodProduto.setBounds(59, 118, 295, 38);
		contentPane.add(MsgCodProduto);
		
		CodProduto = new JTextField();
		CodProduto.setBounds(59, 162, 295, 29);
		contentPane.add(CodProduto);
		CodProduto.setColumns(10);
		
		JLabel MsgEstoque = new JLabel("Estoque");
		MsgEstoque.setFont(new Font("Arial Black", Font.PLAIN, 28));
		MsgEstoque.setBounds(105, 33, 132, 58);
		contentPane.add(MsgEstoque);
		
		JLabel ImgEstoque1 = new JLabel("");
		ImgEstoque1.setIcon(new ImageIcon(".\\src\\imagens\\pacotes.png"));
		ImgEstoque1.setBounds(59, 21, 64, 70);
		contentPane.add(ImgEstoque1);
		
		BotPesquisarProd = new JButton("");
		BotPesquisarProd.setIcon(new ImageIcon(".\\src\\imagens\\lupa.png"));
		BotPesquisarProd.setBounds(364, 163, 29, 28);
		contentPane.add(BotPesquisarProd);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(568, 292, 14, -72);
		contentPane.add(separator);
		
		TextoInfProd = new JTextArea();
		TextoInfProd.setEditable(false);
		TextoInfProd.setBounds(500, 0, 334, 494);
		contentPane.add(TextoInfProd);
		
		BotVoltarEstoqueFunc = new JButton("Voltar");
		BotVoltarEstoqueFunc.setBounds(10, 460, 89, 23);
		contentPane.add(BotVoltarEstoqueFunc);
		
	
	}
	
	public void registerListener(EstoqueFuncController controller) {
		BotPesquisarProd.addActionListener(controller);
		BotVoltarEstoqueFunc.addActionListener(controller);
	}
	public void atualizaTela(String msg) {
		JOptionPane.showMessageDialog(null,msg);
	}
}