package modelo;

public class Transaccion {
	private int id;
	private int idEmisor;
	private int idDestinatario;
	private int valor;

	public Transaccion() {}

	public Transaccion(int idEmisor, int idDestinatario, int valor) {
		this.idEmisor = idEmisor;
		this.idDestinatario = idDestinatario;
		this.valor = valor;
	}

	public Transaccion(int id, int idEmisor, int idDestinatario, int valor) {
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

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
