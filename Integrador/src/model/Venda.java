package model;

import java.io.Serializable;
import java.util.Date;
import dao.ExceptionDAO;
import dao.VendaDAO;
import view.TelaVenda;
import view.TelaVendaGer;



public class Venda implements Serializable {

	private double Valor;
	private Date Data;
	private String Hora;
	private String Forma_pg;
	private static int  Num_venda = 0;
	private String FK_Cpf_Cliente;
	private String FK_UserFunc;
	private static final long serialVersionUID = 1L;
	
	
	
	
	public Venda(double valor, Date data2, String hora, String forma_pg, int num_venda,
			String fK_Cpf_Cliente, String fK_UserFunc) {
		super();
		setValor(valor);
		setData(data2);
		setHora(hora);
		setForma_pg(forma_pg);
		Num_venda = num_venda;
		setFK_Cpf_Cliente(fK_Cpf_Cliente);
		setFK_UserFunc (fK_UserFunc);
	}
	

	
	public Venda() {
		
	}
	public static int proximaVenda() throws ExceptionDAO {
		VendaDAO vendaDAO = new VendaDAO();
		Venda.Num_venda = vendaDAO.procuraNumVendas();
		
		
		return Venda.Num_venda+1;
	}





	public double getValor() {
		return Valor;
	}
	
	
	public void setValor(double valor) {
		if(valor>0)
			Valor = valor;
	}
	public Date getData() {
		return Data;
	}
	public void setData(Date tdata) {
		if(tdata!=null )
			Data = tdata;
	}
	public String getHora() {
		return Hora;
	}
	public void setHora(String hora) {
		if(hora != null && !hora.isEmpty())
			Hora = hora;
	}
	public String getForma_pg() {
		return Forma_pg;
	}
	public void setForma_pg(String forma_pg) {
		if(forma_pg != null && !forma_pg.isEmpty())
			Forma_pg = forma_pg;
	}
	public int getNum_venda() {
		return Num_venda ;
	}
	public void setNum_venda(int num_venda) {
			Num_venda = num_venda;
	}
	public String getFK_Cpf_Cliente() {
		return FK_Cpf_Cliente;
	}
	public void setFK_Cpf_Cliente(String fK_Cpf_Cliente) {
		if(fK_Cpf_Cliente!=null && !fK_Cpf_Cliente.isEmpty())
			FK_Cpf_Cliente = fK_Cpf_Cliente;
	}
	public String getFK_UserFunc() {
		return FK_UserFunc;
	}
	public void setFK_UserFunc(String fK_UserFunc) {
		if(fK_UserFunc !=null && !fK_UserFunc.isEmpty())
			FK_UserFunc = fK_UserFunc;
	}
	
	public String deserializaLogin() {
		Deserializador d = new Deserializador();
		Funcionario usuario = new Funcionario();
        usuario = null;
        try {
            usuario = (Funcionario) d.deserializar("./usuario01.obj");
            System.out.println("\n\n descerializado");
            
            
        } catch (Exception ex) {
            System.err.println("Falha ao deserializar! - " + ex.toString());
        }
		return usuario.getNome_user();
	}
	
	public String RegistrarVendaModel(TelaVenda view) throws ExceptionDAO {
		String msg = null;
		double preco = view.getValor();
		Date data = view.getData();
		String hora  = view.getHorario();
		int numvenda = view.getNumVenda();
		String CpfCliente = view.getCPFCliente();
		String formaPag = view.gettFormaPg();
		String fK_UserFunc = this.deserializaLogin();
		FactoryProdutosVendas fv = new FactoryProdutosVendas();
		Venda venda = (Venda)fv.getVenda(preco, data,hora, formaPag, numvenda-1,CpfCliente,  fK_UserFunc);
		if(venda!=null) {
			VendaDAO vendaDAO = new VendaDAO();
			vendaDAO.cadastrarVenda(venda);
			msg ="Venda cadastrada com sucesso!";
		}else {
			msg = "Os dados não foram prenchidos corretamente!";
		}
		return msg;
	}
	
	public String RegistrarVendaGerModel(TelaVendaGer view) throws ExceptionDAO {
		String msg;
		double preco = view.getValor();
		Date data = view.getData();
		String hora  = view.getHorario();
		int numvenda = view.getNumVenda();
		String CpfCliente = view.getCPFCliente();
		String formaPag = view.gettFormaPg();
		String fK_UserFunc = this.deserializaLogin();
		FactoryProdutosVendas fv = new FactoryProdutosVendas();
		Venda venda = (Venda)fv.getVenda(preco, data,hora, formaPag, numvenda-1,CpfCliente,  fK_UserFunc);
		if(venda!=null) {
			VendaDAO vendaDAO = new VendaDAO();
			vendaDAO.cadastrarVenda(venda);
			msg = "Venda cadastrada com sucesso!";
		}else {
			msg = "Os dados não foram prenchidos corretamente!";
		}
		return msg;
	}
	
	
	    
		
		
	
}