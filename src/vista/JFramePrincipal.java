package vista;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.Objects;

public class JFramePrincipal extends javax.swing.JFrame
{

    public JFramePrincipal()
    {
        initComponents();
    }

    private void initComponents()
    {
        jPanel1 = new javax.swing.JPanel();
        JLSaldo = new javax.swing.JLabel("");
        jScrollPane1 = new javax.swing.JScrollPane();
        JTblTransacciones = new javax.swing.JTable();
        JBEnviar = new javax.swing.JButton();
        JTFDestinatario = new javax.swing.JTextField();
        JLDestinatario = new javax.swing.JLabel();
        JLValor = new javax.swing.JLabel();
        JTFValor = new javax.swing.JTextField();
        JBSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JLSaldo.setFont(new java.awt.Font("DejaVu", Font.PLAIN, 36));
        JLSaldo.setHorizontalTextPosition(JLabel.CENTER);
        JLSaldo.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/vista/imagenes/cuadrado_arribal150a.png"))));

        JTblTransacciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String []
            {
                "idEmisor", "idDestinatario", "Valor"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        JTblTransacciones.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(JTblTransacciones);
        if (JTblTransacciones.getColumnModel().getColumnCount() > 0)
        {
            JTblTransacciones.getColumnModel().getColumn(0).setResizable(false);
            JTblTransacciones.getColumnModel().getColumn(1).setResizable(false);
            JTblTransacciones.getColumnModel().getColumn(2).setResizable(false);
        }
        JTableHeader header = JTblTransacciones.getTableHeader();
        header.setFont(new java.awt.Font("DejaVu", Font.BOLD, 15));
        JTblTransacciones.setFont(new java.awt.Font("DejaVu", Font.PLAIN, 14));

        JBEnviar.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/vista/imagenes/enviaral70.png"))));

        JTFDestinatario.setFont(new java.awt.Font("DejaVu", Font.PLAIN, 14));
        JTFValor.setFont(new java.awt.Font("DejaVu", Font.PLAIN, 14));

        JTFDestinatario.setToolTipText("Id del destinatario");

        JLDestinatario.setText("Destinatario");
        JLDestinatario.setFont(new java.awt.Font("DejaVu", Font.BOLD, 15));

        JLValor.setText("Valor");
        JLValor.setFont(new java.awt.Font("DejaVu", Font.BOLD, 15));

        JTFValor.setToolTipText("Valor $");

        JBSalir.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/vista/imagenes/salir.png"))));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLSaldo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JTFDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JBEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLDestinatario, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(JLValor, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(JBSalir))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(JLSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(JLDestinatario)
                        .addGap(18, 18, 18)
                        .addComponent(JTFDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(JLValor)
                        .addGap(18, 18, 18)
                        .addComponent(JTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(JBEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBSalir)
                        .addGap(30, 30, 30))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    public void setJLSaldo(String saldo) {
        this.JLSaldo.setText(saldo);
    }

    public JButton getJBEnviar() {
        return JBEnviar;
    }

    public JTable getJTblTransacciones() {
        return JTblTransacciones;
    }

    public String getTFDestinatario() {
        return JTFDestinatario.getText();
    }

    public String getJTFValor() {
        return JTFValor.getText();
    }

    public void setJTFValor(String valor) {
        JTFValor.setText(valor);
    }

    public void setJTFDestinatario(String destinatario) {
        JTFDestinatario.setText(destinatario);
    }

    public JButton getJBSalir() {
        return JBSalir;
    }

    private javax.swing.JButton JBEnviar;
    private javax.swing.JButton JBSalir;
    private javax.swing.JLabel JLDestinatario;
    private javax.swing.JLabel JLSaldo;
    private javax.swing.JLabel JLValor;
    private javax.swing.JTextField JTFDestinatario;
    private javax.swing.JTextField JTFValor;
    private javax.swing.JTable JTblTransacciones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
}
