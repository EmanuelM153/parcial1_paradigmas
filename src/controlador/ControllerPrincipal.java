package controlador;

import modelo.*;
import vista.JFramePrincipal;
import vista.Login;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerPrincipal implements ActionListener {
	private final Cuenta cuenta;
	private final JFramePrincipal miFrame;
	private final Login login;

	protected ControllerPrincipal(Cuenta cuenta, JFramePrincipal miFrame, Login login) {
		this.login = login;
		this.cuenta = cuenta;

		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException |
		         InstantiationException ex) {
			Logger.getLogger(JFramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
		}

		this.miFrame = miFrame;
		miFrame.setVisible(true);

		// agregar action listeners
		miFrame.getJBEnviar().addActionListener(this);
		miFrame.getJBSalir().addActionListener(this);

		// poner el saldo
		miFrame.setJLSaldo("$ " + cuenta.getSaldo());

		// mostrar transacciones
		mostrarTransacciones();
	}

	private void mostrarTransacciones() {
		DefaultTableModel tabla = (DefaultTableModel) miFrame.getJTblTransacciones().getModel();

		TransaccionDAO transaccionDAO = new TransaccionDAO();
		ArrayList<Transaccion> transacciones = transaccionDAO.buscarObjetos(new Transaccion(cuenta.getId(), cuenta.getId()));

		int i = 0;
		tabla.setRowCount(transacciones.size());
		for (Transaccion transaccion : transacciones) {
			grabarFilaCliente(transaccion, i, tabla);
			i++;
		}
	}

	private void grabarFilaCliente(Transaccion transaccion, int fila, DefaultTableModel tabla) {
		CuentaDao cuentaDao = new CuentaDao();

		ArrayList<Cuenta> cuentaEmisor = cuentaDao.buscarObjetos(new Cuenta(transaccion.getIdEmisor(), (double) 0));
		ArrayList<Cuenta> cuentaDestinatario = cuentaDao.buscarObjetos(new Cuenta(transaccion.getIdDestinatario(), (double) 0));

		tabla.setValueAt(cuentaEmisor.get(0).getCliente(), fila, 0);
		tabla.setValueAt(cuentaDestinatario.get(0).getCliente(), fila, 1);
		tabla.setValueAt(transaccion.getValor(), fila, 2);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == miFrame.getJBEnviar()) {
			Transaccion transaccion = null;
			double valorTransaccion;
			int idDestinatario;
			try {
				valorTransaccion = Double.parseDouble(miFrame.getJTFValor());
				idDestinatario = Integer.parseInt(miFrame.getTFDestinatario());
			} catch (NumberFormatException e) {
				return;
			}

			// revisar si la cuenta existe
			CuentaDao cuentaDao = new CuentaDao();
			ArrayList<Cuenta> cuentas = cuentaDao.buscarObjetos(new Cuenta(idDestinatario));

			if (cuentas.isEmpty() || cuentas.get(0).getCliente() == cuenta.getCliente()) {
				miFrame.setJTFValor("");
				miFrame.setJTFDestinatario("");
				JOptionPane.showMessageDialog(null, "Destinatario no existe");
				return;
			}

			if (cuenta.getSaldo() >= valorTransaccion && valorTransaccion >= 1000) {
				Cuenta cuentaDestinatario = cuentas.get(0);

				// agregar transaccion
				TransaccionDAO transaccionDAO = new TransaccionDAO();
				transaccion = new Transaccion(cuenta.getId(), cuentaDestinatario.getId(), valorTransaccion);
				int filas = transaccionDAO.grabarColumna(transaccion);

				if (filas > 0) {
					double restante = cuenta.getSaldo() - valorTransaccion;

					// quitar valor de la cuenta de emisor
					cuentaDao.editarColumna(new Cuenta(cuenta.getId(), restante));

					// agregar valor de la cuenta a destinatario
					cuentaDao.editarColumna(new Cuenta(cuentaDestinatario.getId(), cuentaDestinatario.getSaldo() + valorTransaccion));

					miFrame.setJLSaldo("$ " + restante);

					// agregar la transaccion a la tabla
					DefaultTableModel tabla = (DefaultTableModel) miFrame.getJTblTransacciones().getModel();
					int filasTabla = tabla.getRowCount() + 1;
					tabla.setRowCount(filasTabla);
					grabarFilaCliente(transaccion, filasTabla - 1, tabla);
				} else {
					JOptionPane.showMessageDialog(null, "Transaccion no realizada");
				}
			}

			miFrame.setJTFValor("");
			miFrame.setJTFDestinatario("");
		}

		if (actionEvent.getSource() == miFrame.getJBSalir()) {
			login.setVisible(true);
			miFrame.dispose();
		}
	}
}
