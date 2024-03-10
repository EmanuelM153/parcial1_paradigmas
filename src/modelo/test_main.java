package modelo;

import java.util.ArrayList;

public class test_main {
	public static void main(String[] args) {
		if (args.length > 0) {
			if (args.length != 3) {
				System.out.println("Número de argumentos inválido");
				System.exit(-1);
			}

			Conexion conexion = Conexion.obtenerInstancia();
			conexion.inicializar(args[0], args[1], args[2]);
		}

		TransaccionDAO transaccionDAO = new TransaccionDAO();

//		Transaccion prueba = new Transaccion(2, 3, 1000);
//		System.out.println(transaccionDAO.grabarColumna(prueba));
//		prueba = new Transaccion(4, 3, 5000);
//		System.out.println(transaccionDAO.grabarColumna(prueba));
//
//		ArrayList<Transaccion> busqueda = transaccionDAO.buscarObjetos(new Transaccion(0, 0, 3, 0));
//		for (Transaccion encontrada : busqueda) {
//			System.out.println(encontrada.getId() + " " + encontrada.getIdEmisor() + " " +
//				encontrada.getIdDestinatario() + " " + encontrada.getValor());
//		}
//
//		ArrayList<Transaccion> busqueda = transaccionDAO.obtenerColumnas();
//		for (Transaccion encontrada : busqueda) {
//			System.out.println(encontrada.getId() + " " + encontrada.getIdEmisor() + " " +
//				encontrada.getIdDestinatario() + " " + encontrada.getValor());
//		}
	}
}
