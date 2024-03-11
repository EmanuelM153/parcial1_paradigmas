package controlador;

import modelo.*;

public class Main {
	public static void main(String[] args) {
		if (args.length > 0) {
			if (args.length != 3) {
				System.out.println("Número de argumentos inválido");
				System.exit(-1);
			}

			Conexion conexion = Conexion.obtenerInstancia();
			conexion.inicializar(args[0], args[1], args[2]);
		}

		CuentaDao cuentaDao = new CuentaDao();
		Cuenta cuenta = cuentaDao.buscarObjetos(new Cuenta(3)).get(0);

		new ControllerPrincipal(new Cliente(3), cuenta);
	}
}