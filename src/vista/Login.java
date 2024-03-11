package vista;

import javax.swing.*;
import java.util.Arrays;
import java.util.Objects;

public class Login extends javax.swing.JFrame
{
    public Login()
    {
        initComponents();
    }

    private void initComponents()
    {
        JLLogo = new javax.swing.JLabel();
        JTFUsuario = new javax.swing.JTextField();
        JLUsuario = new javax.swing.JLabel();
        JLContrasena = new javax.swing.JLabel();
        JPFContrasena = new javax.swing.JPasswordField();
        JBEntrar = new javax.swing.JButton();
        JBRegistrarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JLLogo.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/vista/imagenes/logo.png"))));
        JLLogo.setToolTipText("");

        JTFUsuario.setFont(new java.awt.Font("DejaVu Sans", 0, 15));
        JTFUsuario.setToolTipText("Usuario");

        JLUsuario.setFont(new java.awt.Font("DejaVu Sans", 1, 16));
        JLUsuario.setText("Usuario");

        JLContrasena.setFont(new java.awt.Font("DejaVu Sans", 1, 16));
        JLContrasena.setText("Contraseña");

        JPFContrasena.setFont(new java.awt.Font("DejaVu Sans", 0, 15));
        JPFContrasena.setToolTipText("Contraseña");

        JBEntrar.setBackground(new java.awt.Color(168, 173, 0));
        JBEntrar.setFont(new java.awt.Font("DejaVu Sans", 1, 15));
        JBEntrar.setForeground(new java.awt.Color(255, 255, 255));
        JBEntrar.setText("Entrar");

        JBRegistrarse.setBackground(new java.awt.Color(168, 173, 0));
        JBRegistrarse.setFont(new java.awt.Font("DejaVu Sans", 1, 15));
        JBRegistrarse.setForeground(new java.awt.Color(255, 255, 255));
        JBRegistrarse.setText("Registrarse");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(JLLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JLUsuario)
                    .addComponent(JTFUsuario)
                    .addComponent(JLContrasena)
                    .addComponent(JPFContrasena)
                    .addComponent(JBEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBRegistrarse, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(JLUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(JTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JLContrasena)
                        .addGap(18, 18, 18)
                        .addComponent(JPFContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(JBRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(JLLogo)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }

    private javax.swing.JButton JBEntrar;
    private javax.swing.JButton JBRegistrarse;
    private javax.swing.JLabel JLContrasena;
    private javax.swing.JLabel JLLogo;
    private javax.swing.JLabel JLUsuario;
    private javax.swing.JPasswordField JPFContrasena;
    private javax.swing.JTextField JTFUsuario;

    public JButton getJBEntrar() {
        return JBEntrar;
    }

    public JButton getJBRegistrarse() {
        return JBRegistrarse;
    }

    public String getJTFUsuario() {
        return JTFUsuario.getText();
    }

    public String getJTFContrasena() {
        return new String(JPFContrasena.getPassword());
    }

    public void setJTFUsuario(String usuario) {
        JTFUsuario.setText(usuario);
    }

    public void setJTFContrasena(String contrasena) {
        JPFContrasena.setText(contrasena);
    }
}
