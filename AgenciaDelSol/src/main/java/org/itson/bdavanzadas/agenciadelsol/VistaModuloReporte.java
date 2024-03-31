package org.itson.bdavanzadas.agenciadelsol;

import com.itson.bdavanzadas.dtos.ConsultarPersonaDTO;
import com.itson.bdavanzadas.dtos.ReporteDTO;
import com.itson.bdavanzadas.dtos.TramiteDTO;
import com.itson.bdavanzadas.excepcionesdtos.ValidacionDTOException;
import com.itson.bdavanzadas.negocio.ITramitesBO;
import com.itson.bdavanzadas.negocio.TramitesBO;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import org.itson.bdavanzadas.entidades.Persona;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class VistaModuloReporte extends javax.swing.JPanel {

    private Ventana ventana;
    DefaultTableModel modeloTabla = new DefaultTableModel();
    private TramiteDTO tramiteDTO;
    private ITramitesBO tramitesBO;
    private boolean isChecked = false;
    private List<TramiteDTO> tramites;
    private List<TramiteDTO> tramitesFiltrados;
    

    /**
     * Constructor de la clase VistaModuloReporte.
     *
     * @param ventana La ventana principal de la aplicación.
     */
    public VistaModuloReporte(Ventana ventana) {
        this.ventana = ventana;
        this.tramitesBO = new TramitesBO();
        this.tramiteDTO = new TramiteDTO();
        try {
            this.tramites = tramitesBO.consultarTramites();
        } catch (ValidacionDTOException ex) {
            Logger.getLogger(VistaModuloReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        actualizarTabla(tramites);
        txtNombrePersona.setEditable(false);
        dpPeriodoInicio.setEnabled(false);
        dpPeriodoFin.setEnabled(false);
    }

    /**
     * Metodo para limpiar la tabla de Reportes.
     */
    private void limpiarTabla() {
        modeloTabla = (DefaultTableModel) tblPersonasCoincidentes.getModel();
        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }
    }

    private void actualizarTabla(List<TramiteDTO> tramites) {

        try {
            DefaultTableModel personasCoincidentes = new DefaultTableModel();
            personasCoincidentes.addColumn("Tipo reporte");
            personasCoincidentes.addColumn("Fecha de emision");
            personasCoincidentes.addColumn("Costo");
            personasCoincidentes.addColumn("Nombre");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for (TramiteDTO tramite : tramites) {
                Object[] fila = {
                    tramite.getTipoTramite(),
                    dateFormat.format(tramite.getFechaEmision().getTime()),
                    "$" + tramite.getCosto() + " MXN",
                    tramite.getPersona().getNombres() + " " + tramite.getPersona().getApellidoPaterno()
                };

                personasCoincidentes.addRow(fila);
            }

            tblPersonasCoincidentes.setModel(personasCoincidentes);

        } catch (PersistenceException ex) {
            Logger.getLogger(VistaModuloReporte.class.getName()).log(Level.SEVERE, null, ex);
        }

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
        lblPersonasCoincidentes = new javax.swing.JLabel();
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
        lblBuscar = new javax.swing.JLabel();
        lblTipoReporte = new javax.swing.JLabel();
        lblPeriodo = new javax.swing.JLabel();
        lblNombrePersona = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JButton();
        txtNombrePersona = new javax.swing.JTextField();
        lblCheck2 = new javax.swing.JLabel();
        lblCheck3 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        dpPeriodoInicio = new com.github.lgooddatepicker.components.DatePicker();
        dpPeriodoFin = new com.github.lgooddatepicker.components.DatePicker();
        cmbTipoReporte = new javax.swing.JComboBox<>();
        btnGenerarReporte = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonasCoincidentes = new javax.swing.JTable();
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

        lblPersonasCoincidentes.setFont(new java.awt.Font("Amazon Ember", 0, 24)); // NOI18N
        lblPersonasCoincidentes.setForeground(new java.awt.Color(196, 4, 67));
        lblPersonasCoincidentes.setText("Personas coincidentes");
        add(lblPersonasCoincidentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 300, 250, 29));

        lblTitulo.setFont(new java.awt.Font("Amazon Ember", 0, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(196, 4, 67));
        lblTitulo.setText("Módulo de reportes");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 107, 330, 43));

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

        lblBuscar.setFont(new java.awt.Font("Amazon Ember", 0, 24)); // NOI18N
        lblBuscar.setForeground(new java.awt.Color(196, 4, 67));
        lblBuscar.setText("Buscar por:");
        add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 164, 122, 29));

        lblTipoReporte.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblTipoReporte.setForeground(new java.awt.Color(215, 70, 118));
        lblTipoReporte.setText("Tipo reporte:");
        add(lblTipoReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 211, 120, 24));

        lblPeriodo.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblPeriodo.setForeground(new java.awt.Color(215, 70, 118));
        lblPeriodo.setText("Periodo:");
        add(lblPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 211, 80, 24));

        lblNombrePersona.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblNombrePersona.setForeground(new java.awt.Color(215, 70, 118));
        lblNombrePersona.setText("Nombre persona:");
        add(lblNombrePersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 211, 160, 22));

        btnFiltrar.setFont(new java.awt.Font("Amazon Ember", 0, 20)); // NOI18N
        btnFiltrar.setForeground(new java.awt.Color(253, 253, 253));
        btnFiltrar.setText("Filtrar");
        btnFiltrar.setBorder(null);
        btnFiltrar.setContentAreaFilled(false);
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });
        add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 164, 142, 45));

        txtNombrePersona.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtNombrePersona.setBackground(new java.awt.Color(247, 242, 244));
        txtNombrePersona.setBorder(null);
        txtNombrePersona.setForeground(new java.awt.Color(143, 143, 143));
        add(txtNombrePersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 245, 200, 30));

        lblCheck2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCheck2MouseClicked(evt);
            }
        });
        add(lblCheck2, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 217, 19, 19));

        lblCheck3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCheck3MouseClicked(evt);
            }
        });
        add(lblCheck3, new org.netbeans.lib.awtextra.AbsoluteConstraints(724, 217, 19, 19));

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
        add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 484, 142, 45));
        add(dpPeriodoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 239, 190, 40));
        add(dpPeriodoFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 239, 190, 40));

        cmbTipoReporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No especificado", "Placa", "Licencia" }));
        add(cmbTipoReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 239, 150, 40));

        btnGenerarReporte.setFont(new java.awt.Font("Amazon Ember", 0, 19)); // NOI18N
        btnGenerarReporte.setForeground(new java.awt.Color(253, 253, 253));
        btnGenerarReporte.setText("Generar reporte");
        btnGenerarReporte.setContentAreaFilled(false);
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });
        add(btnGenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(769, 484, 188, 45));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 500, -1, -1));

        tblPersonasCoincidentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPersonasCoincidentes);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 330, 720, 130));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVistaModuloReporte.png"))); // NOI18N
        fondo.setFont(new java.awt.Font("Amazon Ember", 0, 20)); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que se ejecuta al hacer clic en el botón "Trámites en curso".
     *
     * @param evt El evento de acción que desencadena este método (en este caso,
     * hacer clic en el botón "Trámites en curso").
     */
    private void btnTramitesDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTramitesDisponiblesActionPerformed
        ventana.cambiarVistaInicio();
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

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed

        tramitesFiltrados = new ArrayList<>();

        // Filtrar por tipo
        if (cmbTipoReporte.getSelectedItem() != null) {
            String tipoReporte = cmbTipoReporte.getSelectedItem().toString().trim();
            for (TramiteDTO tramite : tramites) {
                String tipo = tramite.getTipoTramite();

                if (tipoReporte.equals("No especificado")) {
                    tramitesFiltrados.add(tramite);
                } else if (tipoReporte.equals("Placa") && tipo.equals("Expedición de placas")) {
                    tramitesFiltrados.add(tramite);
                } else if (tipoReporte.equals("Licencia") && tipo.equals("Expedición de Licencia")) {
                    tramitesFiltrados.add(tramite);
                }
            }
        } else {
            // Si no se selecciona ningún tipo de trámite, mantener todos los trámites
            tramitesFiltrados.addAll(tramites);
        }

        //Filtrar por persona
        if (txtNombrePersona.getText() != null && !txtNombrePersona.getText().isEmpty()) {
            String nombrePersona = txtNombrePersona.getText().toLowerCase();

            List<TramiteDTO> tramitesPorPersona = new ArrayList<>();

            for (TramiteDTO tramite : tramitesFiltrados) {
                ConsultarPersonaDTO personaTramite = tramite.getPersona();
                String nombreCompleto = personaTramite.getNombres().toLowerCase() + " " + personaTramite.getApellidoPaterno().toLowerCase();

                if (nombreCompleto.contains(nombrePersona)) {
                    tramitesPorPersona.add(tramite);
                }
            }
            tramitesFiltrados = tramitesPorPersona;
        }
        // Filtrar por fechas si se han seleccionado
        if (dpPeriodoInicio.getDate() != null && dpPeriodoFin.getDate() != null) {
            Date periodoInicio = Date.from(dpPeriodoInicio.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
            Date periodoFin = Date.from(dpPeriodoFin.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());

            List<TramiteDTO> tramitesPorFecha = new ArrayList<>();

            for (TramiteDTO tramite : tramitesFiltrados) {
                Date fechaEmision = tramite.getFechaEmision(); // Obtenemos directamente la fecha como Date

                if (fechaEmision.equals(periodoInicio) || fechaEmision.equals(periodoFin)
                        || (fechaEmision.after(periodoInicio) && fechaEmision.before(periodoFin))) {
                    tramitesPorFecha.add(tramite);
                }
            }

            tramitesFiltrados = tramitesPorFecha;
        }

        limpiarTabla();
        actualizarTabla(tramitesFiltrados);
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
//        int filaSeleccionada = tblPersonasCoincidentes.getSelectedRow();
//
//        if (filaSeleccionada != -1) { // Verificar si se ha seleccionado alguna fila
//            Object[] datosFila = new Object[tblPersonasCoincidentes.getColumnCount()];
//
//            for (int i = 0; i < tblPersonasCoincidentes.getColumnCount(); i++) {
//                datosFila[i] = tblPersonasCoincidentes.getValueAt(filaSeleccionada, i);
//            }
//
//            tramiteDTO.setTipoTramite(datosFila[0].toString());
//
//            // Convertir fecha de String a Calendar
//            String fechaString = datosFila[1].toString();
//            try {
//                SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                Date fechaDate = formatoEntrada.parse(fechaString);
//
//                // Crear objeto Calendar y asignar la fecha
//                Calendar fechaCalendar = Calendar.getInstance();
//                fechaCalendar.setTime(fechaDate);
//
//                // Pasar directamente el objeto Calendar
//                tramiteDTO.setFechaEmision(fechaCalendar);
//            } catch (ParseException e) {
//                System.out.println("Error al parsear la fecha: " + e.getMessage());
//            }
//
//            // Limpiar la cadena de caracteres no numéricos y convertir a float
//            String costoString = datosFila[2].toString().replaceAll("[^\\d.]", "");
//            if (!costoString.isEmpty()) {
//                tramiteDTO.setCosto(Float.valueOf(costoString));
//            } else {
//                System.out.println("El valor del costo no es válido.");
//            }
//            // Crear ConsultarPersonaDTO y asignarlo a tramiteDTO
//            ConsultarPersonaDTO persona = new ConsultarPersonaDTO(datosFila[3].toString());
//            tramiteDTO.setPersona(persona);
//
//            ventana.cambiarVistaPrevisionReporte(tramiteDTO);
//
//        } else {
//            // Si no se ha seleccionado ninguna fila, muestra un mensaje de advertencia o realiza alguna otra acción
//            new Aviso().mostrarAviso(ventana, "Primero seleccione un tramite antes de generar el PDF");
//        }
    }//GEN-LAST:event_btnGenerarReporteActionPerformed

    private void lblCheck2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCheck2MouseClicked
        // Si isChecked es false, establece la imagen de la palomita y cambia isChecked a true
        if (!isChecked) {
            lblCheck2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgPalomita.png")));
            isChecked = true;
            txtNombrePersona.setEditable(true); // Habilita la edición cuando isChecked es true
        } else {
            // Si isChecked es true, establece una imagen vacía (o cualquier otra imagen deseada) y cambia isChecked a false
            lblCheck2.setIcon(null); // Esto eliminará la imagen actual
            isChecked = false;
            txtNombrePersona.setEditable(false); // Deshabilita la edición cuando isChecked es false
            txtNombrePersona.setText("");
        }
    }//GEN-LAST:event_lblCheck2MouseClicked

    private void lblCheck3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCheck3MouseClicked
        // Si isChecked es false, establece la imagen de la palomita y cambia isChecked a true
        if (!isChecked) {
            lblCheck3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgPalomita.png")));
            isChecked = true;
            dpPeriodoInicio.setEnabled(true); // Habilita la edición cuando isChecked es true
            dpPeriodoFin.setEnabled(true); // Habilita la edición cuando isChecked es true
        } else {
            // Si isChecked es true, establece una imagen vacía (o cualquier otra imagen deseada) y cambia isChecked a false
            lblCheck3.setIcon(null); // Esto eliminará la imagen actual
            isChecked = false;
            dpPeriodoInicio.setEnabled(false); // Habilita la edición cuando isChecked es true
            dpPeriodoFin.setEnabled(false); // Habilita la edición cuando isChecked es true
            dpPeriodoInicio.setText("");
            dpPeriodoFin.setText("");
        }
    }//GEN-LAST:event_lblCheck3MouseClicked

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        ventana.cambiarVistaInicio();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Verificar si hay tramites filtrados
        if (tramitesFiltrados != null && !tramitesFiltrados.isEmpty()) {
            // Convertir tramitesFiltrados a ReporteDTO
            List<ReporteDTO> reportes = tramitesBO.convertirTramitesAReportes(tramitesFiltrados);

            tramitesBO.generarReporte(reportes);
            JOptionPane.showMessageDialog(ventana, "Reporte generado exitosamente");
        } else {
            JOptionPane.showMessageDialog(ventana, "No hay tramites para generar el reporte");
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JButton btnModuloConsultas;
    private javax.swing.JButton btnModuloReportes;
    private javax.swing.JButton btnTramitesDisponibles;
    private javax.swing.JButton btnTramitesEnCurso;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbTipoReporte;
    private com.github.lgooddatepicker.components.DatePicker dpPeriodoFin;
    private com.github.lgooddatepicker.components.DatePicker dpPeriodoInicio;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCheck2;
    private javax.swing.JLabel lblCheck3;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogo1;
    private javax.swing.JLabel lblLogo2;
    private javax.swing.JLabel lblLogo3;
    private javax.swing.JLabel lblLogo4;
    private javax.swing.JLabel lblLogoInfo;
    private javax.swing.JLabel lblModuloConsultas;
    private javax.swing.JLabel lblNombrePersona;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lblPersonasCoincidentes;
    private javax.swing.JLabel lblReportes;
    private javax.swing.JLabel lblTipoReporte;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTramitesDisponibles;
    private javax.swing.JLabel lblTramitesPendientes;
    private javax.swing.JTable tblPersonasCoincidentes;
    private javax.swing.JTextField txtNombrePersona;
    // End of variables declaration//GEN-END:variables

}
