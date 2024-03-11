package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CuentaDao implements ComunicacionDB<Cuenta> {

    @Override
    public int grabarColumna(Cuenta objeto) {
        Conexion conexion = Conexion.obtenerInstancia();
            String manipulacion = "INSERT INTO cuenta VALUES(NULL, '" +
                    objeto.getSaldo() + "', '" + objeto.getCliente() + "')";
            return conexion.actualizar(manipulacion);
    }

    @Override
    public int editarColumna(Cuenta objeto) {
        Conexion conexion = Conexion.obtenerInstancia();
        String manipulacion = "update cuenta set saldo = '" + objeto.getSaldo()
                + "' where id = '" + objeto.getId() + "'";
        return conexion.actualizar(manipulacion);
    }

    @Override
    public ArrayList<Cuenta> buscarObjetos(Cuenta busqueda) {
        ArrayList<Cuenta> resultados = new ArrayList<>();

        Conexion conexion = Conexion.obtenerInstancia();
        String consulta = "Select * from cuenta where id = '" + busqueda.getId() + "' OR saldo = '"
                + busqueda.getSaldo() + "' OR cliente = '" + busqueda.getCliente() + "'";
        ResultSet coincidencias = conexion.consultar(consulta);

        if (coincidencias != null) {
            try {
                while (coincidencias.next())
                    resultados.add(new Cuenta(coincidencias.getInt("id"), coincidencias.getDouble("saldo"), coincidencias.getInt("cliente")));
            } catch (SQLException e) {

            }
        }
        return resultados;
    }

    @Override
    public ArrayList<Cuenta> obtenerColumnas() {
        ArrayList<Cuenta> cuentas = new ArrayList<>();

        Conexion conexion = Conexion.obtenerInstancia();
        String consulta = "Select * from cuenta";
        ResultSet resultados = conexion.consultar(consulta);

        if (resultados != null) {
            try {
                while (resultados.next())
                    cuentas.add(new Cuenta(resultados.getInt("id"), resultados.getDouble("saldo"), resultados.getInt("cliente")));
            } catch (SQLException e) {

            }
        }
        return cuentas;
    }

}
