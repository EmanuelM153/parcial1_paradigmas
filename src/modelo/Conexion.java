import java.sql.DriverManager;
import java.sql.*;

/**
 * Conexion provee la interfaz con la base de datos
 * a través de la API JDBC. De manera que, cuenta con métodos
 * que reciben una cadena de texto que representa una consulta de SQL.
 */

public class Conexion {
	private String url = "jdbc:mysql://localhost:3306/NIQUE";
	private String user = "root";
	private String pwd = "";

	private static Conexion instancia = new Conexion();

	private Conexion() {}

	public static synchronized Conexion obtenerInstancia() {
		return instancia;
	}

	public void inicializar(String url, String user, String pwd) {
		this.url = url;
		this.user = user;
		this.pwd = pwd;
	}

	/**
	 * Ejecuta y retorna en la base de datos una consulta.
	 * <p>
	 * Primero establece una conexión a través de una url, un usuario y una
	 * contraseña, codificados de forma rígida, y luego ejecuta la consulta.
	 * <p>
	 * En caso de una excepción en la base de datos, muestra su mensaje en un panel JOptionPane
	 *
	 * @param consulta La consulta SQL en formato de texto.
	 * @return Un objeto de tipo ResultSet con la respuesta a la consulta.
	 */
	public ResultSet Consulta(String consulta) {
		try {
			Connection cn = DriverManager.getConnection(url, user, pwd);
			PreparedStatement da = cn.prepareStatement(consulta);
			ResultSet tbl = da.executeQuery();
			return tbl;
		}
		catch (SQLException e) {
			//javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}

	/**
	 * Ejecuta una declaración DML
	 * <p>
	 * Primero establece una conexión a través de una url, un usuario y una contraseña,
	 * codificados de forma rígida, y luego ejecuta la declaración DML.
	 * <p>
	 * En caso de una excepción en la base de datos, muestra su mensaje en un panel JOptionPane
	 *
	 * @param consulta La declaración DML del lenguaje SQL en formato de texto.
	 * @return Un entero con el número de filas afectadas
	 */
	public int Actualizar(String consulta) {
		try {
			Connection cn = DriverManager.getConnection(url, user, pwd);
			PreparedStatement da = cn.prepareStatement(consulta);
			return da.executeUpdate();
		}
		catch (SQLException e) {
			//javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
			return -1;
		}
	}
}
