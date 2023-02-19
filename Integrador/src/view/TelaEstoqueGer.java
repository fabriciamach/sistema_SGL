package view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EstoqueGerController;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JCheckBox;
public class TelaEstoqueGer extends JFrame {

	private JPanel contentPane;
	private JTextField CodProduto;
	private JButton BotExclProd;
	private JButton BotEditProd;
	private JButton BotPesquisar;
	private JButton botaoVoltarEstoque;
	private JButton BotCadastrarProd;
	private JTextArea TextoInfProduto;
	
	
	
	
	public JTextArea getTextoInfProduto() {
		return TextoInfProduto;
	}
	public void setTextoInfProduto(String textoInfProduto) {
		TextoInfProduto.setText(textoInfProduto);
	}
	public String getCodProduto() {
		return CodProduto.getText();
	}
	public void setCodProduto(JTextField codProduto) {
		CodProduto = codProduto;
	}
	public JButton getBotExclProd() {
		return BotExclProd;
	}
	public void setBotExclProd(JButton botExclProd) {
		BotExclProd = botExclProd;
	}
	public JButton getBotEditProd() {
		return BotEditProd;
	}
	public void setBotEditProd(JButton botEditProd) {
		BotEditProd = botEditProd;
	}
	public JButton getBotPesquisar() {
		return BotPesquisar;
	}
	public void setBotPesquisar(JButton botPesquisar) {
		BotPesquisar = botPesquisar;
	}
	public JButton getBotaoVoltarEstoque() {
		return botaoVoltarEstoque;
	}
	public void setBotaoVoltarEstoque(JButton botaoVoltarEstoque) {
		this.botaoVoltarEstoque = botaoVoltarEstoque;
	}
	public JButton getBotCadastrarProd() {
		return BotCadastrarProd;
	}
	public void setBotCadastrarProd(JButton botCadastrarProd) {
		BotCadastrarProd = botCadastrarProd;
	}
	public TelaEstoqueGer() {
		
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
		
		BotPesquisar = new JButton("");
		BotPesquisar.setIcon(new ImageIcon(".\\src\\imagens\\lupa.png"));
		BotPesquisar.setBounds(364, 163, 29, 28);
		contentPane.add(BotPesquisar);
		
		BotCadastrarProd = new JButton("Cadastrar");
		BotCadastrarProd.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotCadastrarProd.setBounds(184, 292, 145, 48);
		contentPane.add(BotCadastrarProd);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(568, 292, 14, -72);
		contentPane.add(separator);
		
		TextoInfProduto = new JTextArea();
		TextoInfProduto.setEditable(false);
		TextoInfProduto.setBounds(500, 0, 334, 494);
		contentPane.add(TextoInfProduto);
		
		BotEditProd = new JButton("Editar");
		BotEditProd.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotEditProd.setBounds(112, 385, 125, 48);
		contentPane.add(BotEditProd);
		
		BotExclProd = new JButton("Excluir");
		BotExclProd.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotExclProd.setBounds(268, 385, 125, 48);
		contentPane.add(BotExclProd);
		
		
		
		botaoVoltarEstoque = new JButton("Voltar");
		botaoVoltarEstoque.setBounds(10, 460, 89, 23);
		contentPane.add(botaoVoltarEstoque);
	
	}
	public void registerListener(EstoqueGerController  controller) {
		BotPesquisar.addActionListener(controller);
		BotCadastrarProd.addActionListener( controller);
		BotEditProd.addActionListener(controller);
		BotExclProd.addActionListener(controller);
		botaoVoltarEstoque.addActionListener(controller);
	}
	public void atualizaTela(String msg) {
		JOptionPane.showMessageDialog(null,msg);
	}
}
