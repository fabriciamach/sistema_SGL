package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import controller.VendaController;
import model.Produto;

public class TelaVenda extends JFrame {

	private JPanel contentPane;
	private JTextField Valor;
	private JTextField Data;
	private JTextField Horario;
	private JTextField NumVenda;
	private JTextField CPFCliente;
	private JTextField tFormaPg;
	private JButton BotSalvarVenda;
	private JButton BotCancelarVenda;
	private JButton BotVoltarVenda ;
	private JTextPane ProdVenda;
	private JTextField CodigoProd;
	private JButton BotProduto;
	//private ArrayList<String> produtos;
	
	
	
	public JButton getBotProduto() {
		return BotProduto;
	}

	public void setBotProduto(JButton botProduto) {
		BotProduto = botProduto;
	}
	
	public String getCodigoProd() {
		return CodigoProd.getText();
	}

	public void setCodigoProd(JTextField codigoProd) {
		CodigoProd = codigoProd;
	}
	
	public String getProdVenda() {
		return ProdVenda.getText();
	}
	
	
	
	public void setProdVenda(String prodVenda) {

		ProdVenda.setText(getProdVenda()+"\n"+ prodVenda);
	}

	public JButton getBotVoltarVenda() {
		return BotVoltarVenda;
	}

	public void setBotVoltarVenda(JButton botVoltarVenda) {
		BotVoltarVenda = botVoltarVenda;
	}

	public Double getValor() {
		double valor =  Double.parseDouble(Valor.getText());
		return valor;
	}

	public void setValor(JTextField valor) {
		Valor = valor;
	}

	public Date getData() {
		String d =  Data.getText();
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		Date Data = null;
		try {
			Data = fmt.parse(d);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return Data;
	}

	public void setData(JTextField data) {
		Data = data;
	}

	public String getHorario() {
		return Horario.getText();
	}

	public void setHorario(JTextField horario) {
		Horario = horario;
	}

	public int getNumVenda() {
		int num = Integer.parseInt(NumVenda.getText());
		return num;
	}

	public void setNumVenda(int numVenda) {
		String num = Integer.toString(numVenda);
		NumVenda.setText(num);;
	}
	


	public String getCPFCliente() {
		return CPFCliente.getText();
	}

	public void setCPFCliente(JTextField cPFCliente) {
		CPFCliente = cPFCliente;
	}

	public String gettFormaPg() {
		return tFormaPg.getText();
	}

	public void settFormaPg(JTextField tFormaPg) {
		this.tFormaPg = tFormaPg;
	}

	public JButton getBotSalvarVenda() {
		return BotSalvarVenda;
	}

	public void setBotSalvarVenda(JButton botSalvarVenda) {
		BotSalvarVenda = botSalvarVenda;
	}

	public JButton getBotCancelarVenda() {
		return BotCancelarVenda;
	}

	public void setBotCancelarVenda(JButton botCancelarVenda) {
		BotCancelarVenda = botCancelarVenda;
	}

	public TelaVenda() {
		
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
		
		JLabel MsgVenda = new JLabel("Registrar Nova Venda");
		MsgVenda.setFont(new Font("Arial Black", Font.PLAIN, 28));
		MsgVenda.setBounds(207, 10, 379, 58);
		contentPane.add(MsgVenda);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(568, 292, 14, -72);
		contentPane.add(separator);
		
		JLabel ImgVenda = new JLabel("");
		ImgVenda.setIcon(new ImageIcon(".\\src\\imagens\\mao.png"));
		ImgVenda.setBounds(59, 25, 48, 66);
		contentPane.add(ImgVenda);
		
		BotVoltarVenda = new JButton("Voltar");
		BotVoltarVenda.setBounds(10, 460, 89, 23);
		contentPane.add(BotVoltarVenda);
		
		JLabel MsgValor = new JLabel("Valor:");
		MsgValor.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		MsgValor.setBounds(31, 163, 54, 23);
		contentPane.add(MsgValor);
		
		Valor = new JTextField();
		Valor.setBounds(99, 166, 127, 23);
		contentPane.add(Valor);
		Valor.setColumns(10);
		
		JLabel MsgData = new JLabel("Data:");
		MsgData.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		MsgData.setBounds(327, 114, 54, 23);
		contentPane.add(MsgData);
		
		Data = new JTextField();
		Data.setColumns(10);
		Data.setBounds(391, 117, 96, 23);
		contentPane.add(Data);
		
		JLabel MsgHorario = new JLabel("Horário:");
		MsgHorario.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		MsgHorario.setBounds(332, 163, 80, 23);
		contentPane.add(MsgHorario);
		
		Horario = new JTextField();
		Horario.setColumns(10);
		Horario.setBounds(422, 166, 80, 23);
		contentPane.add(Horario);
		
		JLabel MsgPagamento = new JLabel("Forma de Pagamento:");
		MsgPagamento.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		MsgPagamento.setBounds(31, 211, 209, 23);
		contentPane.add(MsgPagamento);
		
		tFormaPg = new JTextField();
		tFormaPg.setBounds(250, 214, 231, 23);
		contentPane.add(tFormaPg);
		tFormaPg.setColumns(10);
		
		JLabel MsgNumVenda = new JLabel("Número da Venda:");
		MsgNumVenda.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		MsgNumVenda.setBounds(29, 114, 209, 23);
		contentPane.add(MsgNumVenda);
		
		NumVenda = new JTextField();
		NumVenda.setColumns(10);
		NumVenda.setBounds(207, 117, 68, 23);
		contentPane.add(NumVenda);
		
		JLabel MsgCPFCliente = new JLabel("CPF Cliente:");
		MsgCPFCliente.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		MsgCPFCliente.setBounds(31, 261, 124, 23);
		contentPane.add(MsgCPFCliente);
		
		CPFCliente = new JTextField();
		CPFCliente.setColumns(10);
		CPFCliente.setBounds(158, 264, 152, 23);
		contentPane.add(CPFCliente);
		
		BotSalvarVenda = new JButton("Salvar");
		BotSalvarVenda.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotSalvarVenda.setBounds(391, 381, 126, 46);
		contentPane.add(BotSalvarVenda);
		
		BotCancelarVenda = new JButton("Cancelar");
		BotCancelarVenda.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotCancelarVenda.setBounds(184, 381, 126, 46);
		contentPane.add(BotCancelarVenda);
		
		JLabel MsgCodProduto = new JLabel("Código do Produto:");
		MsgCodProduto.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		MsgCodProduto.setBounds(59, 314, 179, 23);
		contentPane.add(MsgCodProduto);
		
		CodigoProd = new JTextField();
		CodigoProd.setColumns(10);
		CodigoProd.setBounds(237, 317, 207, 23);
		contentPane.add(CodigoProd);
		
		JLabel MsgProdutos = new JLabel("Produtos:");
		MsgProdutos.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		MsgProdutos.setBounds(575, 117, 89, 23);
		contentPane.add(MsgProdutos);
		
		ProdVenda = new JTextPane();
		ProdVenda.setEditable(false);
		ProdVenda.setBounds(578, 163, 221, 312);
		contentPane.add(ProdVenda);
		
		BotProduto = new JButton("");
		BotProduto.setIcon(new ImageIcon(TelaVenda.class.getResource("/imagens/adiciona.png")));
		BotProduto.setBounds(448, 318, 22, 21);
		contentPane.add(BotProduto);

		
		
	}
	
	public void registerListener(VendaController controller) {
		BotSalvarVenda.addActionListener(controller);
		BotCancelarVenda.addActionListener(controller);
		BotVoltarVenda.addActionListener(controller);
		BotProduto.addActionListener(controller);
	}
	public void atualizaTela(String msg) {
		JOptionPane.showMessageDialog(null,msg);
	}
	

	
	
}