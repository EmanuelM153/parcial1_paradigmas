package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransaccionDAO implements ComunicacionDB <Transaccion> {
	@Override
	public int grabarColumna(Transaccion objeto) {
		Conexion conexion = Conexion.obtenerInstancia();
		String manipulacion = "INSERT INTO transaccion VALUES(NULL, '"
			+ objeto.getIdEmisor() + "', '" + objeto.getIdDestinatario()
			+ "', '" + objeto.getValor() + "')";
		return conexion.actualizar(manipulacion);
	}

	@Override
	public int editarColumna(Transaccion objeto) {
		return 0;
	}

	@Override
	public ArrayList<Transaccion> buscarObjetos(Transaccion busqueda) {
		ArrayList<Transaccion> resultados = new ArrayList<>();

		Conexion conexion = Conexion.obtenerInstancia();
		String consulta = "Select * from transaccion where id = '" + busqueda.getId() + "' OR idEmisor = '"
			+ busqueda.getIdEmisor() + "' OR idDestinatario = '" + busqueda.getIdDestinatario() +
			"' OR valor = '" + busqueda.getValor() + "'";
		ResultSet coincidencias = conexion.consultar(consulta);

		Transaccion coincidencia;
		try {
			while (coincidencias.next()) {
				coincidencia = new Transaccion();
				coincidencia.setId(coincidencias.getInt("id"));
				coincidencia.setIdDestinatario(coincidencias.getInt("idDestinatario"));
				coincidencia.setIdEmisor(coincidencias.getInt("idEmisor"));
				coincidencia.setValor(coincidencias.getInt("valor"));
				resultados.add(coincidencia);
			}
		} catch (SQLException e){

		}

		return resultados;
	}

	@Override
	public ArrayList<Transaccion> obtenerColumnas() {
		ArrayList<Transaccion> transacciones = new ArrayList<>();

		Conexion conexion = Conexion.obtenerInstancia();
		String consulta = "Select * from transaccion";
		ResultSet resultados = conexion.consultar(consulta);

		Transaccion transaccion;
		try {
			while (resultados.next()) {
				transaccion = new Transaccion();
				transaccion.setId(resultados.getInt("id"));
				transaccion.setIdDestinatario(resultados.getInt("idDestinatario"));
				transaccion.setIdEmisor(resultados.getInt("idEmisor"));
				transaccion.setValor(resultados.getInt("valor"));
				transacciones.add(transaccion);
			}
		} catch (SQLException e) {

		}

		return transacciones;
	}
}
