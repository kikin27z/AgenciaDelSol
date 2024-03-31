package org.itson.bdavanzadas.agenciadelsol;

import com.itson.bdavanzadas.avisos.Aviso;
import com.itson.bdavanzadas.dtos.ConsultarPersonaDTO;
import com.itson.bdavanzadas.dtos.PlacaNuevaDTO;
import com.itson.bdavanzadas.dtos.TramiteDTO;
import com.itson.bdavanzadas.negocio.IPlacasBO;
import com.itson.bdavanzadas.negocio.PlacasBO;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class VistaTramitesEnCurso extends javax.swing.JPanel {

    private  Ventana ventana;
    private IPlacasBO placasBO;
    
    /**
     * Constructor de la clase VistaInicio.
     * 
     * @param ventana La ventana principal de la aplicación.
     */
    public VistaTramitesEnCurso(Ventana ventana) {
        this.ventana = ventana;
        this.placasBO = new PlacasBO();
        initComponents();
        actualizarTabla();
    }
    
 
    private void actualizarTabla() {
        List<PlacaNuevaDTO> placasEncontradas = placasBO.consultarPlacasSiEmision();
        try {
            DefaultTableModel placasTabla = new DefaultTableModel();
            placasTabla.addColumn("Tipo");
            placasTabla.addColumn("Numero");
            placasTabla.addColumn("Fecha Emisión");
            placasTabla.addColumn("Costo");
            placasTabla.addColumn("Nombre");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for (PlacaNuevaDTO placa : placasEncontradas) {
                NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "MX"));
                String costoFormateado = formatoMoneda.format(placa.getCosto());
                Object[] fila = {
                    placa.getTipoVehiculo(),
                    placa.getNumero(),
                    dateFormat.format(placa.getFechaEmision().getTime()),
                    costoFormateado+" MXN",
                    placa.getPersona().getNombres()+" "+placa.getPersona().getApellidoPaterno()+" "+placa.getPersona().getApellidoMaterno()
                };

                placasTabla.addRow(fila);
            }

            tblTramites.setModel(placasTabla);
            tblTramites.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Solo se puede seleccionar una fila a la vez
            tblTramites.setDefaultEditor(Object.class, null); // Deshabilita la edición de celdas

        } catch (PersistenceException ex) {
            Logger.getLogger(VistaModuloReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTramitesDisponibles = new javax.swing.JButton();
        btnTramitesEnCurso = new javax.swing.JButton();
        btnModuloConsultas = new javax.swing.JButton();
        btnModuloReportes = new javax.swing.JButton();
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
        btnSeleccionar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTramites = new javax.swing.JTable();
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

        lblTitulo.setFont(new java.awt.Font("Amazon Ember", 0, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(196, 4, 67));
        lblTitulo.setText("Trámites en curso");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 107, -1, 43));

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

        btnSeleccionar.setFont(new java.awt.Font("Amazon Ember", 0, 20)); // NOI18N
        btnSeleccionar.setForeground(new java.awt.Color(253, 253, 253));
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setBorder(null);
        btnSeleccionar.setContentAreaFilled(false);
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(767, 493, 137, 45));

        btnVolver.setFont(new java.awt.Font("Amazon Ember", 0, 20)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(253, 253, 253));
        btnVolver.setText("Volver");
        btnVolver.setBorder(null);
        btnVolver.setContentAreaFilled(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(609, 493, 142, 45));

        tblTramites.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tipo", "Numero", "Fecha Emision", "Costo", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTramites);
        tblTramites.getTableHeader().setResizingAllowed(false);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 820, 310));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVentanaTramitesCurso.png"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Método que se ejecuta al hacer clic en el botón "Trámites en curso".
     * 
     * @param evt El evento de acción que desencadena este método (en este caso, hacer clic en el botón "Trámites en curso").
     */
    private void btnTramitesDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTramitesDisponiblesActionPerformed
        ventana.cambiarVistaInicio();
    }//GEN-LAST:event_btnTramitesDisponiblesActionPerformed

    /**
     * Método que se ejecuta al hacer clic en el botón "Trámites disponibles".
     * 
     * @param evt El evento de acción que desencadena este método (en este caso, hacer clic en el botón "Trámites disponibles").
     */
    private void btnTramitesEnCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTramitesEnCursoActionPerformed
        ventana.cambiarVistaTramitesEnCurso();
    }//GEN-LAST:event_btnTramitesEnCursoActionPerformed

    /**
     * Método que se ejecuta al hacer clic en el botón "Módulo consultas".
     * 
     * @param evt El evento de acción que desencadena este método (en este caso, hacer clic en el botón "Módulo consultas").
     */
    private void btnModuloConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModuloConsultasActionPerformed
        ventana.cambiarVistaModuloConsultas();
    }//GEN-LAST:event_btnModuloConsultasActionPerformed

    /**
     * Método que se ejecuta al hacer clic en el botón "Módulo reportes".
     * 
     * @param evt El evento de acción que desencadena este método (en este caso, hacer clic en el botón "Módulo reportes").
     */
    private void btnModuloReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModuloReportesActionPerformed
        ventana.cambiarVistaModuloReporte();
    }//GEN-LAST:event_btnModuloReportesActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        ventana.cambiarVistaInicio();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int filaSeleccionada = tblTramites.getSelectedRow();

        if (filaSeleccionada != -1) { // Verificar si se ha seleccionado alguna fila
            Object[] datosFila = new Object[tblTramites.getColumnCount()];

            for (int i = 0; i < tblTramites.getColumnCount(); i++) {
                datosFila[i] = tblTramites.getValueAt(filaSeleccionada, i);
            }
            
            PlacaNuevaDTO placa = new PlacaNuevaDTO();
            placa.setTipoVehiculo(datosFila[0].toString());
            placa.setNumero(datosFila[1].toString());
            
            String fechaEmisionString = datosFila[2].toString();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date fechaEmisionDate = dateFormat.parse(fechaEmisionString);
                Calendar fechaEmisionCalendar = Calendar.getInstance();
                fechaEmisionCalendar.setTime(fechaEmisionDate);
                placa.setFechaEmision(fechaEmisionCalendar);
            } catch (ParseException ex) {
                Logger.getLogger(VistaTramitesEnCurso.class.getName()).log(Level.SEVERE, null, "Erroe en el parseo");
            }
            
            String costoString = datosFila[3].toString().replace("$", "").replace(",", "").replace(" MXN", "");
            float costo = Float.parseFloat(costoString);
            placa.setCosto(costo);

            String nombreCompleto = datosFila[4].toString();
            String[] partesNombre = nombreCompleto.split(" ");
            String nombre = partesNombre[0];
            String apellidoPaterno = partesNombre[1];
            String apellidoMaterno = partesNombre[2];
            placa.setPersona(new ConsultarPersonaDTO(nombre, apellidoPaterno, apellidoMaterno));  
        
            ventana.cambiarVistaInfomacionTramites(placa);
        } else {
            // Si no se ha seleccionado ninguna fila, muestra un mensaje de advertencia o realiza alguna otra acción
            new Aviso().mostrarAviso(ventana, "Primero seleccione un tramite antes de generar el PDF");
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModuloConsultas;
    private javax.swing.JButton btnModuloReportes;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnTramitesDisponibles;
    private javax.swing.JButton btnTramitesEnCurso;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
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
    private javax.swing.JTable tblTramites;
    // End of variables declaration//GEN-END:variables

}
