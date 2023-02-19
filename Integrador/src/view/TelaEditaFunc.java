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
import controller.EditaFuncController;

public class TelaEditaFunc  extends JFrame{

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
	private  JButton BotSalvarEditFunc;
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



	public JButton getBotSalvarEditFunc() {
		return BotSalvarEditFunc;
	}



	public void setBotSalvarEditFunc(JButton botSalvarEditFunc) {
		BotSalvarEditFunc = botSalvarEditFunc;
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

	


	public void setNome(String nome) {
		Nome.setText(nome);
	}



	public void setCPF(String cPF) {
		CPF.setText(cPF);;
	}



	public void setTelefone(String telefone) {
		Telefone.setText(telefone);
	}



	public void setDataNasc(Date dataNasc) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    String dataFormatada = dateFormat.format(dataNasc);
	    
		this.DataNasc.setText(dataFormatada);
	}



	public void setDataContr(Date dataContr) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    String dataFormatada = dateFormat.format(dataContr);
	    
		this.DataContr.setText(dataFormatada);
	}



	public void setSalario(Double salario) {
		String sal = Double.toString(salario);
		Salario.setText(sal);
	}



	public void setCargo(String cargo) {
		Cargo.setText(cargo);;
	}



	public void setSenha(String senha) {
		Senha.setText(senha);
	}



	public void setUser(String user) {
		User.setText(user);;
	}



	public void setEndereco(String endereco) {
		Endereco.setText(endereco);
	}



	public void setSexo(String sexo) {
		this.sexo = sexo;
	}




	public TelaEditaFunc() {
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\src\\imagens\\Icon.png"));
		setTitle("SGL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 191, 231));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel MsgFuncionario = new JLabel("Editar Funcionario ");
		MsgFuncionario.setFont(new Font("Arial Black", Font.PLAIN, 20));
		MsgFuncionario.setBounds(126, 0, 215, 49);
		contentPane.add(MsgFuncionario);
		
		JLabel MsgNome = new JLabel("Nome:");
		MsgNome.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgNome.setBounds(28, 63, 66, 18);
		contentPane.add(MsgNome);
		
		Nome = new JTextField();
		Nome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Nome.setBounds(80, 59, 294, 28);
		contentPane.add(Nome);
		Nome.setColumns(10);
		
		JLabel MsgCPF = new JLabel("CPF:");
		MsgCPF.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgCPF.setBounds(28, 100, 66, 18);
		contentPane.add(MsgCPF);
		
		CPF = new JTextField();
		CPF.setFont(new Font("Tahoma", Font.PLAIN, 11));
		CPF.setBounds(80, 96, 294, 28);
		contentPane.add(CPF);
		CPF.setColumns(10);
		
		JLabel MsgTelefone = new JLabel("Telefone:");
		MsgTelefone.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgTelefone.setBounds(28, 134, 84, 18);
		contentPane.add(MsgTelefone);
		
		Telefone = new JTextField();
		Telefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Telefone.setBounds(99, 130, 275, 28);
		contentPane.add(Telefone);
		Telefone.setColumns(10);
		
		JLabel MsgDataNasc = new JLabel("Data de Nascimento:");
		MsgDataNasc.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgDataNasc.setBounds(28, 173, 162, 14);
		contentPane.add(MsgDataNasc);
		
		DataNasc = new JTextField();
		DataNasc.setBounds(190, 168, 120, 28);
		contentPane.add(DataNasc);
		DataNasc.setColumns(10);
		
		JLabel MsgSexo = new JLabel("Sexo:");
		MsgSexo.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgSexo.setBounds(28, 388, 84, 18);
		contentPane.add(MsgSexo);
		
		Masculino = new JRadioButton("Masculino");
		Masculino.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(Masculino);
		Masculino.setSelected(true);
		Masculino.setBackground(new Color(143, 191, 231));
		Masculino.setBounds(190, 387, 109, 23);
		contentPane.add(Masculino);
		
		Feminino = new JRadioButton("Feminino");
		Feminino.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(Feminino);
		Feminino.setBackground(new Color(143, 191, 231));
		Feminino.setBounds(81, 387, 109, 23);
		contentPane.add(Feminino);
		
		BotSalvarEditFunc = new JButton("Salvar");
		BotSalvarEditFunc.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		BotSalvarEditFunc.setBounds(190, 490, 144, 43);
		contentPane.add(BotSalvarEditFunc);
		
		JLabel ImgFunc2 = new JLabel("");
		ImgFunc2.setIcon(new ImageIcon(".\\src\\imagens\\funcionarios2.png"));
		ImgFunc2.setBounds(28, 0, 66, 43);
		contentPane.add(ImgFunc2);
		
		JLabel MsgEndereco = new JLabel("Endereço:");
		MsgEndereco.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgEndereco.setBounds(28, 416, 84, 14);
		contentPane.add(MsgEndereco);
		
		Endereco = new JEditorPane();
		Endereco.setBounds(113, 416, 356, 52);
		contentPane.add(Endereco);
		
		JLabel MsgDataContr = new JLabel("Data de Contratação:");
		MsgDataContr.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgDataContr.setBounds(28, 322, 156, 18);
		contentPane.add(MsgDataContr);
		
		DataContr = new JTextField();
		DataContr.setColumns(10);
		DataContr.setBounds(190, 319, 120, 28);
		contentPane.add(DataContr);
		
		JLabel MsgSalario = new JLabel("Salário:");
		MsgSalario.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgSalario.setBounds(28, 360, 66, 18);
		contentPane.add(MsgSalario);
		
		Salario = new JTextField();
		Salario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Salario.setColumns(10);
		Salario.setBounds(94, 356, 109, 28);
		contentPane.add(Salario);
		
		JLabel MsgCargo = new JLabel("Cargo:");
		MsgCargo.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgCargo.setBounds(28, 283, 66, 18);
		contentPane.add(MsgCargo);
		
		Cargo = new JTextField();
		Cargo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Cargo.setColumns(10);
		Cargo.setBounds(80, 279, 294, 28);
		contentPane.add(Cargo);
		
		MsgSenha = new JLabel("Senha:");
		MsgSenha.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgSenha.setBounds(28, 255, 55, 14);
		contentPane.add(MsgSenha);
		
		Senha = new JTextField();
		Senha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Senha.setColumns(10);
		Senha.setBounds(80, 245, 294, 28);
		contentPane.add(Senha);
		
		JLabel MsgUser = new JLabel("User:");
		MsgUser.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		MsgUser.setBounds(28, 210, 162, 14);
		contentPane.add(MsgUser);
		
		User = new JTextField();
		User.setFont(new Font("Tahoma", Font.PLAIN, 11));
		User.setColumns(10);
		User.setBounds(82, 204, 294, 31);
		contentPane.add(User);
		
		
		
	}
	
	public void registerListener(EditaFuncController controller) {
		BotSalvarEditFunc.addActionListener(controller);
		
	}
	public void atualizaTela(String msg) {
		JOptionPane.showMessageDialog(null,msg);
	}
}
