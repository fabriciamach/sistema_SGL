package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
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

import controller.CadFuncController;

public class CadastroFunc extends JFrame {


	private JPanel contentPane;
	private JTextField Nome;
	private JTextField CPF;
	private JTextField Telefone;
	private JTextField DataNasc;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField DataContr;
	private JTextField Salario;
	private JTextField Cargo;
	private JTextField Senha;
	private JTextField User;
	private JEditorPane Endereco;
	private JRadioButton Masculino ;
	private JRadioButton Feminino;
	private  JButton BotSalvarCadastroFunc;
	private String sexo;
	private JLabel MsgSenha;

	
	
	
	public JRadioButton getMasculino() {
		return Masculino;
	}



	public void setMasculino(JRadioButton masculino) {
		Masculino = masculino;
	}



	public JRadioButton getFeminino() {
		return Feminino;
	}



	public void setFeminino(JRadioButton feminino) {
		Feminino = feminino;
	}



	public JButton getBotSalvarCadastroFunc() {
		return BotSalvarCadastroFunc;
	}



	public void setBotSalvarCadastroFunc(JButton botSalvarCadastroFunc) {
		BotSalvarCadastroFunc = botSalvarCadastroFunc;
	}



	public String getNome() {
		return Nome.getText();
	}

	

	public String getCPF() {
		return CPF.getText();
	}

	
	public String getTelefone() {
		return Telefone.getText();
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

	

	public String getSexo() {
		return sexo;
	}

	

	public String getEndereco() {
		return Endereco.getText();
	}
	public Date getDataContr() {
		String d =  DataContr.getText();
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		Date DataCont = null;
		try {
			DataCont = fmt.parse(d);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return DataCont;
	}
	


	public double getSalario() {
		double salario = Double.parseDouble(Salario.getText());
		return salario;
	}

	

	public String getCargo() {
		return Cargo.getText();
	}



	public String getSenha() {
		return Senha.getText();
	}


	public String getUser() {
		return User.getText();
	}

	


	public void setNome(JTextField nome) {
		Nome = nome;
	}



	public void setCPF(JTextField cPF) {
		CPF = cPF;
	}



	public void setTelefone(JTextField telefone) {
		Telefone = telefone;
	}



	public void setDataNasc(JTextField dataNasc) {
		DataNasc = dataNasc;
	}



	public void setDataContr(JTextField dataContr) {
		DataContr = dataContr;
	}



	public void setSalario(JTextField salario) {
		Salario = salario;
	}



	public void setCargo(JTextField cargo) {
		Cargo = cargo;
	}



	public void setSenha(JTextField senha) {
		Senha = senha;
	}



	public void setUser(JTextField user) {
		User = user;
	}



	public void setEndereco(JEditorPane endereco) {
		Endereco = endereco;
	}



	public void setSexo(String sexo) {
		this.sexo = sexo;
	}




	public CadastroFunc() {
		
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
		
		JLabel MsgFuncionario = new JLabel("Cadastro Funcionário ");
		MsgFuncionario.setFont(new Font("Arial Black", Font.PLAIN, 20));
		MsgFuncionario.setBounds(69, 0, 382, 49);
		contentPane.add(MsgFuncionario);
		
		JLabel MsgNome = new JLabel("Nome:");
		MsgNome.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgNome.setBounds(28, 42, 66, 18);
		contentPane.add(MsgNome);
		
		Nome = new JTextField();
		Nome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Nome.setBounds(80, 38, 294, 28);
		contentPane.add(Nome);
		Nome.setColumns(10);
		
		JLabel MsgCPF = new JLabel("CPF:");
		MsgCPF.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgCPF.setBounds(28, 75, 66, 18);
		contentPane.add(MsgCPF);
		
		CPF = new JTextField();
		CPF.setFont(new Font("Tahoma", Font.PLAIN, 11));
		CPF.setBounds(69, 71, 305, 28);
		contentPane.add(CPF);
		CPF.setColumns(10);
		
		JLabel MsgTelefone = new JLabel("Telefone:");
		MsgTelefone.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgTelefone.setBounds(28, 106, 84, 18);
		contentPane.add(MsgTelefone);
		
		Telefone = new JTextField();
		Telefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Telefone.setBounds(99, 102, 275, 28);
		contentPane.add(Telefone);
		Telefone.setColumns(10);
		
		JLabel MsgDataNasc = new JLabel("Data de Nascimento:");
		MsgDataNasc.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgDataNasc.setBounds(28, 139, 162, 14);
		contentPane.add(MsgDataNasc);
		
		DataNasc = new JTextField();
		DataNasc.setBounds(181, 133, 193, 28);
		contentPane.add(DataNasc);
		DataNasc.setColumns(10);
		
		JLabel MsgSexo = new JLabel("Sexo:");
		MsgSexo.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgSexo.setBounds(28, 330, 84, 18);
		contentPane.add(MsgSexo);
		
		Masculino = new JRadioButton("Masculino");
		buttonGroup.add(Masculino);
		Masculino.setSelected(true);
		Masculino.setBackground(new Color(143, 191, 231));
		Masculino.setBounds(190, 329, 109, 23);
		contentPane.add(Masculino);
		
		Feminino = new JRadioButton("Feminino");
		buttonGroup.add(Feminino);
		Feminino.setBackground(new Color(143, 191, 231));
		Feminino.setBounds(106, 329, 109, 23);
		contentPane.add(Feminino);
		
		BotSalvarCadastroFunc = new JButton("Salvar");
		BotSalvarCadastroFunc.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotSalvarCadastroFunc.setBounds(129, 422, 144, 43);
		contentPane.add(BotSalvarCadastroFunc);
		
		JLabel ImgFunc2 = new JLabel("");
		ImgFunc2.setIcon(new ImageIcon(".\\src\\imagens\\funcionarios2.png"));
		ImgFunc2.setBounds(28, 0, 66, 43);
		contentPane.add(ImgFunc2);
		
		JLabel MsgEndereco = new JLabel("Endereço:");
		MsgEndereco.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgEndereco.setBounds(28, 359, 84, 14);
		contentPane.add(MsgEndereco);
		
		Endereco = new JEditorPane();
		Endereco.setBounds(106, 359, 268, 52);
		contentPane.add(Endereco);
		
		JLabel MsgDataContr = new JLabel("Data de Contratação:");
		MsgDataContr.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgDataContr.setBounds(28, 268, 156, 18);
		contentPane.add(MsgDataContr);
		
		DataContr = new JTextField();
		DataContr.setColumns(10);
		DataContr.setBounds(190, 264, 184, 28);
		contentPane.add(DataContr);
		
		JLabel MsgSalario = new JLabel("Salário:");
		MsgSalario.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgSalario.setBounds(28, 301, 66, 18);
		contentPane.add(MsgSalario);
		
		Salario = new JTextField();
		Salario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Salario.setColumns(10);
		Salario.setBounds(90, 297, 284, 28);
		contentPane.add(Salario);
		
		JLabel MsgCargo = new JLabel("Cargo:");
		MsgCargo.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgCargo.setBounds(28, 233, 66, 18);
		contentPane.add(MsgCargo);
		
		Cargo = new JTextField();
		Cargo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Cargo.setColumns(10);
		Cargo.setBounds(80, 229, 294, 28);
		contentPane.add(Cargo);
		
		MsgSenha = new JLabel("Senha:");
		MsgSenha.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgSenha.setBounds(28, 201, 55, 14);
		contentPane.add(MsgSenha);
		
		Senha = new JTextField();
		Senha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Senha.setColumns(10);
		Senha.setBounds(80, 195, 294, 28);
		contentPane.add(Senha);
		
		JLabel MsgUser = new JLabel("User:");
		MsgUser.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgUser.setBounds(28, 172, 162, 14);
		contentPane.add(MsgUser);
		
		User = new JTextField();
		User.setFont(new Font("Tahoma", Font.PLAIN, 11));
		User.setColumns(10);
		User.setBounds(72, 164, 302, 28);
		contentPane.add(User);
		

		
	
	}
	
	public void registerListener(CadFuncController controller) {
		BotSalvarCadastroFunc.addActionListener(controller);
		
	}
		
	public void atualizaTela(String msg) {
		JOptionPane.showMessageDialog(null,msg);
	}
		
	
}