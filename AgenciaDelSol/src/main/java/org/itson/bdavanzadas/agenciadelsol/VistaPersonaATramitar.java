package org.itson.bdavanzadas.agenciadelsol;

import com.itson.bdavanzadas.avisos.Aviso;
import com.itson.bdavanzadas.dtos.ConsultarPersonaDTO;
import com.itson.bdavanzadas.negocio.IPersonasBO;
import com.itson.bdavanzadas.negocio.PersonasBO;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.itson.bdavanzadas.daos.IPersonasDAO;
import org.itson.bdavanzadas.daos.PersonasDAO;
import org.itson.bdavanzadas.entidades.Persona;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class VistaPersonaATramitar extends javax.swing.JPanel {

    private Ventana ventana;
    private IPersonasBO personasBO;
    /**
     * Constructor de la clase VistaPersonaATramitar.
     *
     * @param ventana La ventana de Persona a tramitar recibe datos para
     * consultar personas.
     */
    public VistaPersonaATramitar(Ventana ventana, IPersonasBO personasBO) {
        this.ventana = ventana;
        this.personasBO = personasBO;
        initComponents();
        
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTramitesDisponibles = new javax.swing.JButton();
        btnTramitesEnCurso = new javax.swing.JButton();
        btnModuloConsultas = new javax.swing.JButton();
        btnModuloReportes = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblLogoInfo = new javax.swing.JLabel();
        lblTramitesDisponibles = new javax.swing.JLabel();
        lblTramitesPendientes = new javax.swing.JLabel();
        lblModuloConsultas = new javax.swing.JLabel();
        lblReportes = new javax.swing.JLabel();
        lblLogo1 = new javax.swing.JLabel();
        lblLogo2 = new javax.swing.JLabel();
        lblLogo3 = new javax.swing.JLabel();
        lblLogo4 = new javax.swing.JLabel();
        lblCurpPersona = new javax.swing.JLabel();
        txtRfcPersona = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(247, 242, 244));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTramitesDisponibles.setBorder(null);
        btnTramitesDisponibles.setBorderPainted(false);
        btnTramitesDisponibles.setContentAreaFilled(false);
        btnTramitesDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTramitesDisponiblesActionPerformed(evt);
            }
        });
        add(btnTramitesDisponibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 102, 128, 40));

        btnTramitesEnCurso.setBorder(null);
        btnTramitesEnCurso.setBorderPainted(false);
        btnTramitesEnCurso.setContentAreaFilled(false);
        btnTramitesEnCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTramitesEnCursoActionPerformed(evt);
            }
        });
        add(btnTramitesEnCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 157, 128, 40));

        btnModuloConsultas.setBorder(null);
        btnModuloConsultas.setBorderPainted(false);
        btnModuloConsultas.setContentAreaFilled(false);
        btnModuloConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModuloConsultasActionPerformed(evt);
            }
        });
        add(btnModuloConsultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 212, 128, 40));

        btnModuloReportes.setBorder(null);
        btnModuloReportes.setBorderPainted(false);
        btnModuloReportes.setContentAreaFilled(false);
        btnModuloReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModuloReportesActionPerformed(evt);
            }
        });
        add(btnModuloReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 267, 128, 40));

        btnBuscar.setFont(new java.awt.Font("Amazon Ember", 0, 20)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(253, 253, 253));
        btnBuscar.setText("Buscar");
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 142, 45));

        lblTitulo.setFont(new java.awt.Font("Amazon Ember", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(196, 4, 67));
        lblTitulo.setText("Persona a tramitar");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 120, 340, 43));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoSol.png"))); // NOI18N
        add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 10, 60, 60));

        lblLogoInfo.setFont(new java.awt.Font("Amazon Ember", 0, 36)); // NOI18N
        lblLogoInfo.setForeground(new java.awt.Color(255, 255, 255));
        lblLogoInfo.setText("Agencia del Sol");
        add(lblLogoInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 16, 260, 43));

        lblTramitesDisponibles.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        lblTramitesDisponibles.setForeground(new java.awt.Color(196, 4, 67));
        lblTramitesDisponibles.setText("<html>Trámites<br>disponibles</html>");
        add(lblTramitesDisponibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 105, 87, 34));

        lblTramitesPendientes.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        lblTramitesPendientes.setForeground(new java.awt.Color(196, 4, 67));
        lblTramitesPendientes.setText("<html>Trámites<br>en curso</html>");
        add(lblTramitesPendientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 160, 87, 34));

        lblModuloConsultas.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        lblModuloConsultas.setForeground(new java.awt.Color(196, 4, 67));
        lblModuloConsultas.setText("<html>Modulo<br>consultas</html>");
        add(lblModuloConsultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 215, 87, 34));

        lblReportes.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        lblReportes.setForeground(new java.awt.Color(196, 4, 67));
        lblReportes.setText("<html>Modulo<br>reportes</html>");
        add(lblReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 270, 87, 34));

        lblLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tramiteDisponibles.png"))); // NOI18N
        add(lblLogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 102, 40, 40));

        lblLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tramitesEnCurso.png"))); // NOI18N
        add(lblLogo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 157, 40, 40));

        lblLogo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgConsultas.png"))); // NOI18N
        add(lblLogo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 212, 40, 40));

        lblLogo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgReporte.png"))); // NOI18N
        add(lblLogo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 267, 40, 40));

        lblCurpPersona.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblCurpPersona.setForeground(new java.awt.Color(215, 70, 118));
        lblCurpPersona.setText("RFC de la persona:");
        add(lblCurpPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 185, 215, 24));

        txtRfcPersona.setBackground(new java.awt.Color(247, 242, 244));
        txtRfcPersona.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtRfcPersona.setForeground(new java.awt.Color(143, 143, 143));
        txtRfcPersona.setBorder(null);
        txtRfcPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRfcPersonaActionPerformed(evt);
            }
        });
        add(txtRfcPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 218, 440, 34));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVistaPersonaATramitar.png"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que se ejecuta al hacer clic en el botón "Trámites en curso".
     *
     * @param evt El evento de acción que desencadena este método (en este caso,
     * hacer clic en el botón "Trámites en curso").
     */
    private void btnTramitesDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTramitesDisponiblesActionPerformed
    }//GEN-LAST:event_btnTramitesDisponiblesActionPerformed

    /**
     * Método que se ejecuta al hacer clic en el botón "Trámites disponibles".
     *
     * @param evt El evento de acción que desencadena este método (en este caso,
     * hacer clic en el botón "Trámites disponibles").
     */
    private void btnTramitesEnCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTramitesEnCursoActionPerformed
        ventana.cambiarVistaTramitesEnCurso();
    }//GEN-LAST:event_btnTramitesEnCursoActionPerformed

    /**
     * Método que se ejecuta al hacer clic en el botón "Módulo consultas".
     *
     * @param evt El evento de acción que desencadena este método (en este caso,
     * hacer clic en el botón "Módulo consultas").
     */
    private void btnModuloConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModuloConsultasActionPerformed
        ventana.cambiarVistaModuloConsultas();
    }//GEN-LAST:event_btnModuloConsultasActionPerformed

    /**
     * Método que se ejecuta al hacer clic en el botón "Módulo reportes".
     *
     * @param evt El evento de acción que desencadena este método (en este caso,
     * hacer clic en el botón "Módulo reportes").
     */
    private void btnModuloReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModuloReportesActionPerformed
        ventana.cambiarVistaModuloReporte();
    }//GEN-LAST:event_btnModuloReportesActionPerformed

    /**
     * Método que se ejecuta al hacer clic en el botón "Buscar".
     *
     * @param evt El evento de acción que desencadena este método (en este caso,
     * hace clic y despliega la lista en una tabla).
     */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ConsultarPersonaDTO personaDTO = new ConsultarPersonaDTO(txtRfcPersona.getText());
        Persona persona = personasBO.consultarPersonaPorCurp(personaDTO);
//        
//        Calendar fechaNacimiento = persona.getFechaNacimiento();
//        Calendar fechaActual = Calendar.getInstance();
//
//        int años = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
//        if (años >= 18) {
//            if (persona.getDiscapacidad().equals("NORMAL")) {
//                costoTitulo.setText("Costo normal");
//                costo1.setText("600");
//                costo2.setText("900");
//                costo3.setText("1100");
//            } else {
//                costoTitulo.setText("Costo Discapacitados");
//                costo1.setText("200");
//                costo2.setText("500");
//                costo3.setText("700");
//            }
//        } else {
//            new Aviso().mostrarAviso(ventana, "No se puede tramitar a un menor de edad");
//        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtRfcPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRfcPersonaActionPerformed
        
    }//GEN-LAST:event_txtRfcPersonaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnModuloConsultas;
    private javax.swing.JButton btnModuloReportes;
    private javax.swing.JButton btnTramitesDisponibles;
    private javax.swing.JButton btnTramitesEnCurso;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel lblCurpPersona;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogo1;
    private javax.swing.JLabel lblLogo2;
    private javax.swing.JLabel lblLogo3;
    private javax.swing.JLabel lblLogo4;
    private javax.swing.JLabel lblLogoInfo;
    private javax.swing.JLabel lblModuloConsultas;
    private javax.swing.JLabel lblReportes;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTramitesDisponibles;
    private javax.swing.JLabel lblTramitesPendientes;
    private javax.swing.JTextField txtRfcPersona;
    // End of variables declaration//GEN-END:variables

}
