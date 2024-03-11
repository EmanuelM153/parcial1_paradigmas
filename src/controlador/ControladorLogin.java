package controlador;

import modelo.Cliente;
import modelo.ClienteDao;
import modelo.Cuenta;
import modelo.CuentaDao;
import vista.JFramePrincipal;
import vista.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladorLogin implements ActionListener {
    private Login login;
    private ClienteDao clienteDao = new ClienteDao();

    protected ControladorLogin(Login login) {
        this.login = login;
        this.login.setVisible(true);
        this.login.getJBEntrar().addActionListener(this);
        this.login.getJBRegistrarse().addActionListener(this);

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException |
                 InstantiationException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login.getJBEntrar()) {
            ControladorCliente cc = new ControladorCliente();

            int idUsuario;
            try {
                idUsuario = Integer.parseInt(login.getJTFUsuario());
            } catch (NumberFormatException exception) {
                login.setJTFContrasena("");
                login.setJTFUsuario("");
                return;
            }

            if (cc.validarCliente(idUsuario, login.getJTFContrasena()) == 1) {
                CuentaDao cuentaDao = new CuentaDao();

                ArrayList<Cuenta> cuenta = cuentaDao.buscarObjetos(new Cuenta(idUsuario));

                this.login.setVisible(false);

                new ControllerPrincipal(cuenta.get(0), new JFramePrincipal(), login);

                System.out.println("Encontró algo");
            } else {
                System.out.println("No se encontró nada");
                javax.swing.JOptionPane.showMessageDialog(null, "Usuario incorrecto");
            }
            login.setJTFContrasena("");
            login.setJTFUsuario("");
        }

        if (e.getSource() == login.getJBRegistrarse()) {
            ControladorCliente cc = new ControladorCliente();

            int idUsuario;
            try {
                idUsuario = Integer.parseInt(login.getJTFUsuario());
            } catch (NumberFormatException exception) {
                login.setJTFContrasena("");
                login.setJTFUsuario("");
                return;
            }

            ArrayList<Cliente> resultado = clienteDao.buscarObjetos(new Cliente(idUsuario));

            boolean existente = !resultado.isEmpty();

            if (existente) {
                this.login.setVisible(false);
                javax.swing.JOptionPane.showMessageDialog(null, "Id existente");
                this.login.setVisible(true);
            } else {
                if (cc.crearUsuario(idUsuario, login.getJTFContrasena()) == 1) {
                    CuentaDao cuentaDao = new CuentaDao();

                    ArrayList<Cuenta> cuenta = cuentaDao.buscarObjetos(new Cuenta(idUsuario));

                    this.login.setVisible(false);

                    new ControllerPrincipal(cuenta.get(0), new JFramePrincipal(), login);

                    System.out.println("Encontró algo");
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "Error al crear el usuario");
                }
            }

            login.setJTFContrasena("");
            login.setJTFUsuario("");
        }

    }

}
