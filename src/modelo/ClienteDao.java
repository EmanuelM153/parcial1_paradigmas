package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDao implements ComunicacionDB<Cliente>{

    @Override
    public int grabarColumna(Cliente objeto) {
            Conexion conexion = Conexion.obtenerInstancia();
            String manipulacion = "INSERT INTO cliente VALUES(NULL, '"
                    + objeto.getContrasena() + "', '" + objeto.getNombre() + "')";
            return conexion.actualizar(manipulacion);
    }

    @Override
    public int editarColumna(Cliente objeto) {
        Conexion conexion = Conexion.obtenerInstancia();
        String manipulacion = "update cliente set contrasena = '" + objeto.getContrasena()
                + "', nombre = '" + objeto.getNombre() + "' where id = '" + objeto.getId() + "'";
        return conexion.actualizar(manipulacion);
    }

    @Override
    public ArrayList<Cliente> buscarObjetos(Cliente busqueda) {
        ArrayList<Cliente> resultados = new ArrayList<>();

        Conexion conexion = Conexion.obtenerInstancia();
        String consulta = "Select * from cliente where id = '" + busqueda.getId() + "' OR contrasena = '"
                + busqueda.getContrasena() + "' OR nombre = '" + busqueda.getNombre() + "'";
        ResultSet coincidencias = conexion.consultar(consulta);

        if (coincidencias != null) {
            try {
                while (coincidencias.next())
                    resultados.add(new Cliente(coincidencias.getInt("id"), coincidencias.getString("contrasena"), coincidencias.getString("nombre")));
            } catch (SQLException e) {

            }
        }

        return resultados;
    }

    @Override
    public ArrayList<Cliente> obtenerColumnas() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        Conexion conexion = Conexion.obtenerInstancia();
        String consulta = "Select * from cliente";
        ResultSet resultados = conexion.consultar(consulta);

        if (resultados != null) {
            try {
                while (resultados.next())
                    clientes.add(new Cliente(resultados.getInt("id"), resultados.getString("contrasena"), resultados.getString("nombre")));
            } catch (SQLException e) {

            }
        }

        return clientes;
    }
}
