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

import controller.AlterarDadosGerController;


public class AlterarDadosGer extends JFrame {

	private JPanel contentPane;
	private JTextField Nome;
	private JTextField CPF;
	private JTextField Telefone;
	private JTextField DataNasc;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField DataContr;
	private JTextField Salario;
	private JTextField User;
	private JTextField Senha;
	private JButton BotSalvarGer;
	private String sexo;
	private JEditorPane Endereco;
	private JButton BotVoltar;

	
	
	
	public JButton getBotVoltar() {
		return BotVoltar;
	}
	public void setBotVoltar(JButton botVoltar) {
		BotVoltar = botVoltar;
	}
	public JButton getBotSalvarGer() {
		return BotSalvarGer;
	}
	public void setBotSalvarGer(JButton botSalvarGer) {
		BotSalvarGer = botSalvarGer;
	}
	public String getNome() {
		return Nome.getText();
	}
	public void setNome(String nome) {
		Nome.setText(nome);
	}
	public String getCPF() {
		return CPF.getText();
	}
	public void setCPF(String cPF) {
		CPF.setText(cPF);
	}
	public String getTelefone() {
		return Telefone.getText();
	}
	public void setTelefone(String telefone) {
		Telefone.setText(telefone);;
	}
	public Date getDataNasc() {
		String d =  DataNasc.getText();
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
	public void setDataNasc(Date dataNasc) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    String dataFormatada = dateFormat.format(dataNasc);
	    
		this.DataNasc.setText(dataFormatada);
	}
	public Date getDataContr() {
		String d =  DataContr.getText();
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		Date DataContr = null;
		try {
			DataContr= fmt.parse(d);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return DataContr;
	}
	public void setDataContr(Date dataContr) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    String dataFormatada = dateFormat.format(dataContr);
	    
		this.DataContr.setText(dataFormatada);
	}
	public Double getSalario() {
		double salario = Double.parseDouble(Salario.getText());
		return salario;
	}
	public void setSalario(Double salario) {
		String sal = Double.toString(salario);
		Salario.setText(sal);
	}
	public String getUser() {
		return User.getText();
	}
	
	public void setUser(String user) {
		User.setText(user);;
	}
	public String getSenha() {
		return Senha.getText();
	}
	public void setSenha(String senha) {
		Senha.setText(senha);
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEndereco() {
		return Endereco.getText();
	}
	public void setEndereco(String endereco) {
		Endereco.setText(endereco);;
	}
	public AlterarDadosGer() {
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\src\\imagens\\Icon.png"));
		setTitle("SGL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 576);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 191, 231));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel MsgGerente = new JLabel("Alteração de Dados Gerente ");
		MsgGerente.setFont(new Font("Arial Black", Font.PLAIN, 20));
		MsgGerente.setBounds(100, 7, 382, 49);
		contentPane.add(MsgGerente);
		
		JLabel MsgnNome = new JLabel("Nome:");
		MsgnNome.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgnNome.setBounds(28, 70, 66, 18);
		contentPane.add(MsgnNome);
		
		Nome = new JTextField();
		Nome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Nome.setBounds(80, 66, 372, 28);
		contentPane.add(Nome);
		Nome.setColumns(10);
		
		JLabel MsgCPF = new JLabel("CPF:");
		MsgCPF.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgCPF.setBounds(28, 108, 66, 18);
		contentPane.add(MsgCPF);
		
		CPF = new JTextField();
		CPF.setFont(new Font("Tahoma", Font.PLAIN, 11));
		CPF.setBounds(80, 104, 239, 28);
		contentPane.add(CPF);
		CPF.setColumns(10);
		
		JLabel MsgTelefone = new JLabel("Telefone:");
		MsgTelefone.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgTelefone.setBounds(28, 142, 84, 18);
		contentPane.add(MsgTelefone);
		
		Telefone = new JTextField();
		Telefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Telefone.setBounds(107, 138, 212, 28);
		contentPane.add(Telefone);
		Telefone.setColumns(10);
		
		JLabel MsgDataNasc = new JLabel("Data de Nascimento:");
		MsgDataNasc.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgDataNasc.setBounds(28, 184, 162, 14);
		contentPane.add(MsgDataNasc);
		
		DataNasc = new JTextField();
		DataNasc.setBounds(183, 179, 114, 28);
		contentPane.add(DataNasc);
		DataNasc.setColumns(10);
		
		JLabel MsgSexo = new JLabel("Sexo:");
		MsgSexo.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgSexo.setBounds(326, 224, 42, 18);
		contentPane.add(MsgSexo);
		
		JRadioButton Masculino = new JRadioButton("Masculino");
		Masculino.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(Masculino);
		Masculino.setSelected(true);
		Masculino.setBackground(new Color(143, 191, 231));
		Masculino.setBounds(378, 254, 109, 23);
		contentPane.add(Masculino);
		
	
		JRadioButton Feminino = new JRadioButton("Feminino");
		Feminino.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(Feminino);
		Feminino.setBackground(new Color(143, 191, 231));
		Feminino.setBounds(378, 222, 109, 23);
		contentPane.add(Feminino);
		
		BotSalvarGer = new JButton("Salvar");
		BotSalvarGer.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotSalvarGer.setBounds(175, 468, 144, 43);
		contentPane.add(BotSalvarGer);
		
		JLabel ImgGer2 = new JLabel("");
		ImgGer2.setIcon(new ImageIcon(".\\src\\imagens\\gerente.png"));
		ImgGer2.setBounds(28, -3, 42, 49);
		contentPane.add(ImgGer2);
		
		JLabel MsgEndereco = new JLabel("Endereço:");
		MsgEndereco.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgEndereco.setBounds(28, 387, 84, 14);
		contentPane.add(MsgEndereco);
		
		Endereco = new JEditorPane();
		Endereco.setBounds(100, 387, 362, 56);
		contentPane.add(Endereco);
		
		JLabel MsgDataContr = new JLabel("Data de Contratação:");
		MsgDataContr.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgDataContr.setBounds(28, 343, 156, 18);
		contentPane.add(MsgDataContr);
		
		DataContr = new JTextField();
		DataContr.setColumns(10);
		DataContr.setBounds(190, 340, 184, 28);
		contentPane.add(DataContr);
		
		JLabel MsgSalario = new JLabel("Salário:");
		MsgSalario.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgSalario.setBounds(28, 303, 66, 18);
		contentPane.add(MsgSalario);
		
		Salario = new JTextField();
		Salario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Salario.setColumns(10);
		Salario.setBounds(80, 299, 150, 28);
		contentPane.add(Salario);
		
		User = new JTextField();
		User.setColumns(10);
		User.setBounds(80, 221, 200, 28);
		contentPane.add(User);
		
		Senha = new JTextField();
		Senha.setColumns(10);
		Senha.setBounds(81, 253, 199, 28);
		contentPane.add(Senha);
		
		JLabel MsgUser = new JLabel("User:");
		MsgUser.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgUser.setBounds(28, 226, 42, 14);
		contentPane.add(MsgUser);
		
		JLabel MsgSenha = new JLabel("Senha:");
		MsgSenha.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgSenha.setBounds(28, 263, 51, 14);
		contentPane.add(MsgSenha);
		
		BotVoltar = new JButton("Voltar");
		BotVoltar.setBounds(9, 508, 103, 21);
		contentPane.add(BotVoltar);
		
		
	}
	public void registerListener(AlterarDadosGerController controller) {
		BotSalvarGer.addActionListener(controller);
		BotVoltar.addActionListener(controller);
		
	}
	public void atualizaTela(String msg) {
		JOptionPane.showMessageDialog(null,msg);
	}
}