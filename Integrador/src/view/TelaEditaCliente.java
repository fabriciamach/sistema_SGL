package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import controller.EditaClienteController;

public class TelaEditaCliente extends JFrame {

	
	private JPanel contentPane;
	private JTextField Nome;
	private JTextField CPF;
	private JTextField Telefone;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JRadioButton Masculino;
	private final JRadioButton Feminino;
	private final JEditorPane Endereco;
	private final JButton BotSalvarAltClie;
	private JTextField tDataNasc;
	private String sexo;
	private JButton BotVoltar;

	

	

	public JButton getBotVoltar() {
		return BotVoltar;
	}

	public void setBotVoltar(JButton botVoltar) {
		BotVoltar = botVoltar;
	}

	public JRadioButton getMasculino() {
		return Masculino;
	}

	public JRadioButton getFeminino() {
		return Feminino;
	}

	public JButton getBotSalvarAltClie() {
		return BotSalvarAltClie;
	}

	public String getNome() {
		return Nome.getText();
	}

	public void setNome(String nome) {
		Nome.setText(nome);;
	}

	public String getCPF() {
		return CPF.getText();
	}

	public void setCPF(String Cpf) {
		CPF.setText(Cpf);;
	}

	public String getTelefone() {
		return Telefone.getText();
	}

	public void setTelefone(String telefone) {
		Telefone.setText(telefone);;
	}

	public Date gettDataNasc() {
		String d =  tDataNasc.getText();
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		Date DataNasc = null;
		try {
			DataNasc = fmt.parse(d);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return DataNasc;
	}

	public void settDataNasc(Date tDataNasc) {
	    
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    String dataFormatada = dateFormat.format(tDataNasc);
	    
		this.tDataNasc.setText(dataFormatada);
	}

	public String getSexo(){
		if (Masculino.isSelected())
			sexo = "M";
		else
			sexo = "F";
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return Endereco.getText();
	}
	public void setEndereco(String end) {
		Endereco.setText(end);
	}

	public TelaEditaCliente() {
		
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
		
		JLabel MsgCliente = new JLabel("Editar Cliente");
		MsgCliente.setFont(new Font("Arial Black", Font.PLAIN, 20));
		MsgCliente.setBounds(97, 11, 224, 49);
		contentPane.add(MsgCliente);
		
		JLabel MsgNome = new JLabel("Nome:");
		MsgNome.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgNome.setBounds(28, 89, 66, 18);
		contentPane.add(MsgNome);
		
		Nome = new JTextField();
		Nome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Nome.setBounds(81, 85, 294, 28);
		contentPane.add(Nome);
		Nome.setColumns(10);
		
		JLabel MsgCPF = new JLabel("CPF:");
		MsgCPF.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgCPF.setBounds(28, 133, 66, 18);
		contentPane.add(MsgCPF);
		
		CPF = new JTextField();
		CPF.setFont(new Font("Tahoma", Font.PLAIN, 11));
		CPF.setBounds(81, 129, 294, 28);
		contentPane.add(CPF);
		CPF.setColumns(10);
		
		JLabel MsgTelefone = new JLabel("Telefone:");
		MsgTelefone.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgTelefone.setBounds(28, 179, 84, 18);
		contentPane.add(MsgTelefone);
		
		Telefone = new JTextField();
		Telefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Telefone.setBounds(97, 175, 278, 28);
		contentPane.add(Telefone);
		Telefone.setColumns(10);
		
		JLabel MsgDataNasc = new JLabel("Data de Nascimento:");
		MsgDataNasc.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgDataNasc.setBounds(28, 224, 162, 14);
		contentPane.add(MsgDataNasc);
		
		
		tDataNasc = new JTextField();
		tDataNasc.setBounds(184, 213, 104, 28);
		contentPane.add(tDataNasc);
		tDataNasc.setColumns(10);
		
		JLabel MsgSexo = new JLabel("Sexo:");
		MsgSexo.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgSexo.setBounds(28, 260, 84, 18);
		contentPane.add(MsgSexo);
		
		Masculino = new JRadioButton("Masculino");
		buttonGroup.add(Masculino);
		Masculino.setSelected(true);
		Masculino.setBackground(new Color(143, 191, 231));
		Masculino.setBounds(190, 259, 109, 23);
		contentPane.add(Masculino);
		
		Feminino = new JRadioButton("Feminino");
		buttonGroup.add(Feminino);
		Feminino.setBackground(new Color(143, 191, 231));
		Feminino.setBounds(111, 259, 109, 23);
		contentPane.add(Feminino);
		
		BotSalvarAltClie = new JButton("Salvar");
		BotSalvarAltClie.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotSalvarAltClie.setBounds(162, 393, 144, 43);
		//BotSalvarCliente.addActionListener(controller);
		contentPane.add(BotSalvarAltClie);
		
		JLabel ImgCliente2 = new JLabel("");
		ImgCliente2.setIcon(new ImageIcon(".\\src\\imagens\\aperto-de-mao.png"));
		ImgCliente2.setBounds(28, 11, 78, 49);
		contentPane.add(ImgCliente2);
		
		JLabel MsgEndereco = new JLabel("Endereço:");
		MsgEndereco.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgEndereco.setBounds(28, 289, 84, 14);
		contentPane.add(MsgEndereco);
		
		Endereco = new JEditorPane();
		Endereco.setBounds(113, 289, 268, 80);
		contentPane.add(Endereco);
		
		BotVoltar = new JButton("Voltar");
		BotVoltar.setBounds(10, 447, 102, 21);
		contentPane.add(BotVoltar);
		
	
		
		
	} 

	public void registerListener(EditaClienteController controller) {
		BotSalvarAltClie.addActionListener(controller);
		BotVoltar.addActionListener(controller);
	}

	public void atualizaTela(String msg) {
		JOptionPane.showMessageDialog(null,msg);
	}
	
	
	
	

}
