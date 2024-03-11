package controlador;

import modelo.Cliente;
import modelo.ClienteDao;
import modelo.Cuenta;
import modelo.CuentaDao;

public class ControladorCliente {
    private Cliente cliente;
    private ClienteDao clienteDao;

    public ControladorCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ControladorCliente() {
    }

    protected int validarCliente(int id, String contrasena) {
        clienteDao = new ClienteDao();

        if (clienteDao.iniciarSesion(id, contrasena) == null) {
            System.out.println("Fue nulo");
            return 0;
        } else {
            System.out.println("No Fue nulo");
            return 1;
        }
    }

    public int crearUsuario(int id, String contrasena) {
        clienteDao = new ClienteDao();
        Cliente cliente = new Cliente(id, contrasena, "");

        if (clienteDao.grabarColumna(cliente) != -1) {
            CuentaDao cuentaDao = new CuentaDao();
            cuentaDao.grabarColumna(new Cuenta(300000.0, id));

            System.out.println("Exitoso");
            return 1;
        } else {
            System.out.println(" no Fue exito la creacion");
            return 0;
        }
    }
}
