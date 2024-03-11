package modelo;

public class Transaccion {
	private int id;
	private int idEmisor;
	private int idDestinatario;
	private double valor;

	public Transaccion() {}

	public Transaccion(int idEmisor, int idDestinatario) {
		this.idEmisor = idEmisor;
		this.idDestinatario = idDestinatario;
	}

	public Transaccion(int idEmisor, int idDestinatario, double valor) {
		this.idEmisor = idEmisor;
		this.idDestinatario = idDestinatario;
		this.valor = valor;
	}

	public Transaccion(int id, int idEmisor, int idDestinatario, double valor) {
		this.id = id;
		this.idEmisor = idEmisor;
		this.idDestinatario = idDestinatario;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEmisor() {
		return idEmisor;
	}

	public void setIdEmisor(int idEmisor) {
		this.idEmisor = idEmisor;
	}

	public int getIdDestinatario() {
		return idDestinatario;
	}

	public void setIdDestinatario(int idDestinatario) {
		this.idDestinatario = idDestinatario;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
