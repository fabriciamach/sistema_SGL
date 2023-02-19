package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CadProdController;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class CadastroProduto extends JFrame {

	private JPanel contentPane;
	private JTextField CodProd;
	private JTextField Modelo;
	private JTextField Fabricante;
	private JTextField Preco;
	private JTextField Cor;
    private JTextField tGenero ;
	private JTextField tTam;
	private JButton BotSalvarCadastroProd;
	private JButton ButVoltar;

	
	
	
	public JButton getButVoltar() {
		return ButVoltar;
	}


	public void setButVoltar(JButton butVoltar) {
		ButVoltar = butVoltar;
	}


	public String gettGenero() {
		return tGenero.getText();
	}


	public void settGenero(String tGenero) {
		this.tGenero.setText(tGenero);;
	}


	public String getCodProd() {
		return CodProd.getText();
	}


	public void setCodProd(JTextField codProd) {
		CodProd = codProd;
	}


	public String getModelo() {
		return Modelo.getText();
	}


	public void setModelo(JTextField modelo) {
		Modelo = modelo;
	}


	public String getFabricante() {
		return Fabricante.getText();
	}


	public void setFabricante(JTextField fabricante) {
		Fabricante = fabricante;
	}


	public Double getPreco() {
		Double valor =  Double.parseDouble(Preco.getText());
		return valor;
	}


	public void setPreco(JTextField preco) {
		Preco = preco;
	}


	public String getCor() {
		return Cor.getText();
	}


	public void setCor(JTextField cor) {
		Cor = cor;
	}


	public int gettTam() {
		int tam = Integer.parseInt(tTam.getText());
		return tam;
	}


	public void settTam(JTextField tTam) {
		this.tTam = tTam;
	}


	public JButton getBotSalvarCadastroProd() {
		return BotSalvarCadastroProd;
	}


	public void setBotSalvarCadastroProd(JButton botSalvarCadastroProd) {
		BotSalvarCadastroProd = botSalvarCadastroProd;
	}


	


	public CadastroProduto() {
		setVisible(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\src\\imagens\\Icon.png"));
		setTitle("SGL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 515);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 191, 231));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel MsgCadastroProd = new JLabel("Cadastro Produto ");
		MsgCadastroProd.setFont(new Font("Arial Black", Font.PLAIN, 20));
		MsgCadastroProd.setBounds(67, 11, 382, 49);
		contentPane.add(MsgCadastroProd);
		
		JLabel ImgProd = new JLabel("");
		ImgProd.setIcon(new ImageIcon(".\\src\\imagens\\novo-produto.png"));
		ImgProd.setBounds(28, 11, 40, 43);
		contentPane.add(ImgProd);
		
		JLabel MsgCodProd = new JLabel("Código:");
		MsgCodProd.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgCodProd.setBounds(28, 89, 66, 18);
		contentPane.add(MsgCodProd);
		
		CodProd = new JTextField();
		CodProd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		CodProd.setBounds(91, 89, 284, 28);
		contentPane.add(CodProd);
		CodProd.setColumns(10);
		
		JLabel MsgModelo = new JLabel("Modelo:");
		MsgModelo.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgModelo.setBounds(28, 133, 66, 18);
		contentPane.add(MsgModelo);
		
		Modelo = new JTextField();
		Modelo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Modelo.setBounds(91, 133, 284, 28);
		contentPane.add(Modelo);
		Modelo.setColumns(10);
		
		JLabel MsgFabricante = new JLabel("Fabricante:");
		MsgFabricante.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgFabricante.setBounds(28, 179, 84, 18);
		contentPane.add(MsgFabricante);
		
		Fabricante = new JTextField();
		Fabricante.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Fabricante.setBounds(114, 179, 261, 28);
		contentPane.add(Fabricante);
		Fabricante.setColumns(10);
		
		JLabel MsgPreco = new JLabel("Preço:");
		MsgPreco.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgPreco.setBounds(28, 269, 46, 18);
		contentPane.add(MsgPreco);
		
		Preco = new JTextField();
		Preco.setBounds(77, 265, 113, 28);
		contentPane.add(Preco);
		Preco.setColumns(10);
		
		JLabel MsgCor = new JLabel("Cor:");
		MsgCor.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgCor.setBounds(28, 224, 46, 14);
		contentPane.add(MsgCor);
		
		Cor = new JTextField();
		Cor.setBounds(67, 218, 308, 28);
		contentPane.add(Cor);
		Cor.setColumns(10);
		
		JLabel MsgGenero = new JLabel("Gênero:");
		MsgGenero.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgGenero.setBounds(207, 271, 84, 14);
		contentPane.add(MsgGenero);
		

		tGenero = new JTextField();
		tGenero.setBounds(265, 269, 110, 18);
		contentPane.add(tGenero);
		tGenero.setColumns(10);
		

		
		BotSalvarCadastroProd = new JButton("Salvar");
		BotSalvarCadastroProd.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotSalvarCadastroProd.setBounds(135, 352, 144, 43);
		contentPane.add(BotSalvarCadastroProd);
		
		JLabel Tamanho = new JLabel("Tamanho:");
		Tamanho.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		Tamanho.setBounds(17, 303, 77, 28);
		contentPane.add(Tamanho);
		
		tTam = new JTextField();
		tTam.setBounds(94, 303, 40, 24);
		contentPane.add(tTam);
		tTam.setColumns(10);
		
		ButVoltar = new JButton("Voltar");
		ButVoltar.setBounds(17, 436, 77, 18);
		contentPane.add(ButVoltar);
		
		
	}
	
	
	public void registerListener(CadProdController controller) {
		BotSalvarCadastroProd.addActionListener(controller);
		ButVoltar.addActionListener(controller);
	}
	public void atualizaTela(String msg) {
		JOptionPane.showMessageDialog(null,msg);
	}
}
