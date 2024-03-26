package org.itson.bdavanzadas.agenciadelsol;

import com.itson.bdavanzadas.avisos.Aviso;
import com.itson.bdavanzadas.dtos.ConsultaPlacaDTO;
import com.itson.bdavanzadas.dtos.ConsultarPersonaDTO;
import com.itson.bdavanzadas.dtos.VehiculoNuevoDTO;
import com.itson.bdavanzadas.excepcionesdtos.ValidacionDTOException;
import com.itson.bdavanzadas.negocio.IPlacasBO;
import com.itson.bdavanzadas.negocio.PlacasBO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa la vista para tramitar una licencia para una persona en
 * la aplicación.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class VistaVehiculoTramitar extends javax.swing.JPanel {

    private Ventana ventana;
    private ConsultarPersonaDTO personaDTO;
    private ConsultaPlacaDTO placaDTO;
    private boolean numeroPlacaValidado;
    private IPlacasBO placasBO;

    /**
     * Constructor de la clase VistaPersonaATramitar.
     *
     * @param ventana La ventana de Persona a tramitar recibe datos para
     * consultar personas.
     */
    public VistaVehiculoTramitar(Ventana ventana, ConsultarPersonaDTO personaDTO) {
        this.ventana = ventana;
        this.personaDTO = personaDTO;
        this.placasBO = new PlacasBO();
        ventana.setPlacaNueva(false);
        numeroPlacaValidado = false;
        initComponents();

        limpiarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConfirmar = new javax.swing.JButton();
        btnTramitesDisponibles = new javax.swing.JButton();
        btnTramitesEnCurso = new javax.swing.JButton();
        btnModuloConsultas = new javax.swing.JButton();
        btnModuloReportes = new javax.swing.JButton();
        btnRegistrarVehiculo = new javax.swing.JButton();
        lblConfirmacion = new javax.swing.JLabel();
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
        lblNumeroPlacaTitulo = new javax.swing.JLabel();
        lblColorInfo = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        lblMarcaInfo = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblTipoInfo = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblLinea = new javax.swing.JLabel();
        lblLineaInfo = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblModeloInfo = new javax.swing.JLabel();
        iconPlaca = new javax.swing.JLabel();
        lblTramitarPlaca1 = new javax.swing.JLabel();
        lblCurpPersona1 = new javax.swing.JLabel();
        txtNumeroPlaca = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblNumeroSerie = new javax.swing.JLabel();
        lblColorInfo1 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(247, 242, 244));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnConfirmar.setFont(new java.awt.Font("Amazon Ember", 0, 20)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(253, 253, 253));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setContentAreaFilled(false);
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 488, 142, 45));

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

        btnRegistrarVehiculo.setBorder(null);
        btnRegistrarVehiculo.setBorderPainted(false);
        btnRegistrarVehiculo.setContentAreaFilled(false);
        btnRegistrarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVehiculoActionPerformed(evt);
            }
        });
        add(btnRegistrarVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(733, 171, 150, 145));

        lblConfirmacion.setFont(new java.awt.Font("Amazon Ember", 1, 24)); // NOI18N
        lblConfirmacion.setForeground(new java.awt.Color(196, 4, 67));
        lblConfirmacion.setText("¿Son correctos los datos?");
        add(lblConfirmacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 300, 43));

        lblTitulo.setFont(new java.awt.Font("Amazon Ember", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(196, 4, 67));
        lblTitulo.setText("Vehículo a tramitar:");
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

        lblNumeroPlacaTitulo.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblNumeroPlacaTitulo.setForeground(new java.awt.Color(215, 70, 118));
        lblNumeroPlacaTitulo.setText("Número de placa del vehículo:");
        add(lblNumeroPlacaTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 185, 290, 24));

        lblColorInfo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblColorInfo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblColorInfo.setText("Color:");
        add(lblColorInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 375, 65, -1));

        lblColor.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblColor.setText("-----");
        add(lblColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 375, 230, 20));

        lblMarcaInfo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMarcaInfo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMarcaInfo.setText("Marca:");
        add(lblMarcaInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 375, 50, 20));

        lblMarca.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMarca.setText("-----");
        add(lblMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 375, 290, 20));

        lblTipoInfo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTipoInfo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTipoInfo.setText("Tipo:");
        add(lblTipoInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 340, 50, 20));

        lblTipo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTipo.setText("-----");
        add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 290, 20));

        lblLinea.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblLinea.setText("-----");
        add(lblLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 260, 20));

        lblLineaInfo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblLineaInfo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLineaInfo.setText("Linea:");
        add(lblLineaInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 410, 50, 20));

        lblModelo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblModelo.setText("-----");
        add(lblModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 340, 170, -1));

        lblModeloInfo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblModeloInfo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblModeloInfo.setText("Modelo:");
        add(lblModeloInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 65, -1));

        iconPlaca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconAuto.png"))); // NOI18N
        add(iconPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 188, 95, 95));

        lblTramitarPlaca1.setFont(new java.awt.Font("Amazon Ember Light", 0, 18)); // NOI18N
        lblTramitarPlaca1.setForeground(new java.awt.Color(247, 242, 244));
        lblTramitarPlaca1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTramitarPlaca1.setText("Nuevo Vehículo");
        add(lblTramitarPlaca1, new org.netbeans.lib.awtextra.AbsoluteConstraints(736, 290, 144, -1));

        lblCurpPersona1.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        lblCurpPersona1.setForeground(new java.awt.Color(215, 70, 118));
        lblCurpPersona1.setText("¿Registrar nuevo vehículo?");
        add(lblCurpPersona1, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 137, 247, 30));

        txtNumeroPlaca.setBackground(new java.awt.Color(247, 242, 244));
        txtNumeroPlaca.setFont(new java.awt.Font("Amazon Ember Light", 0, 20)); // NOI18N
        txtNumeroPlaca.setForeground(new java.awt.Color(143, 143, 143));
        txtNumeroPlaca.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(txtNumeroPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 218, 440, 34));

        btnBuscar.setBackground(new java.awt.Color(215, 70, 118));
        btnBuscar.setFont(new java.awt.Font("Amazon Ember", 0, 20)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(253, 253, 253));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(215, 70, 118), 2));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 142, 45));

        lblNumeroSerie.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNumeroSerie.setText("-----");
        add(lblNumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 405, 230, 20));

        lblColorInfo1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblColorInfo1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblColorInfo1.setText("Número serie:");
        add(lblColorInfo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 405, 120, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVistaVehiculoTramitar.png"))); // NOI18N
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
     * Maneja el evento de acción del botón de confirmar.
     *
     * Este método se ejecuta cuando se hace clic en el botón de confirmar en la
     * interfaz gráfica.
     *
     * @param evt El evento de acción asociado al botón de confirmar.
     */
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if (numeroPlacaValidado) {
            ventana.cambiarVistaTramitarPlaca(placaDTO);
        } else {
            new Aviso().mostrarAviso(ventana, "Primero busca vehículo válido para avazar");
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed
    
    /**
    * Este método se ejecuta cuando se hace clic en el botón de registrar vehículo en la
    * interfaz gráfica.
    *
    * @param evt El evento de acción asociado al botón de registrar vehículo.
    */
    private void btnRegistrarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVehiculoActionPerformed
        boolean respuesta = new Aviso().mostrarConfirmacion(ventana, "¿Seguro de querer registrar un vehículo nuevo?", "Registro vehículo nuevo");
        if(respuesta){
            ventana.cambiarVistaAgregarVehiculo(personaDTO);
        }
    }//GEN-LAST:event_btnRegistrarVehiculoActionPerformed

    /**
    * Método que se ejecuta al hacer clic en el botón "Buscar".
    *
    * Este método busca la información del vehículo según el número de placa
    * ingresado en el campo de texto y la muestra en la interfaz gráfica.
    *
    * @param evt El evento de acción que desencadena este método (en este caso,
    * hacer clic en el botón "Buscar").
    */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        placaDTO = new ConsultaPlacaDTO(txtNumeroPlaca.getText());
        placaDTO.setPersona(personaDTO);
        try {
            placaDTO.validarNumeroPlaca();
            placaDTO = placasBO.consultarPlacaPorNumero(placaDTO);
            cargarDatosPlaca();
            numeroPlacaValidado = true;

        } catch (ValidacionDTOException ve) {
            numeroPlacaValidado = false;
            limpiarDatos();
            new Aviso().mostrarAviso(ventana, ve.getMessage());
            Logger.getLogger(VistaVehiculoTramitar.class.getName()).log(Level.SEVERE, "Número placa inválido");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnModuloConsultas;
    private javax.swing.JButton btnModuloReportes;
    private javax.swing.JButton btnRegistrarVehiculo;
    private javax.swing.JButton btnTramitesDisponibles;
    private javax.swing.JButton btnTramitesEnCurso;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel iconPlaca;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblColorInfo;
    private javax.swing.JLabel lblColorInfo1;
    private javax.swing.JLabel lblConfirmacion;
    private javax.swing.JLabel lblCurpPersona1;
    private javax.swing.JLabel lblLinea;
    private javax.swing.JLabel lblLineaInfo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogo1;
    private javax.swing.JLabel lblLogo2;
    private javax.swing.JLabel lblLogo3;
    private javax.swing.JLabel lblLogo4;
    private javax.swing.JLabel lblLogoInfo;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblMarcaInfo;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblModeloInfo;
    private javax.swing.JLabel lblModuloConsultas;
    private javax.swing.JLabel lblNumeroPlacaTitulo;
    private javax.swing.JLabel lblNumeroSerie;
    private javax.swing.JLabel lblReportes;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTipoInfo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTramitarPlaca1;
    private javax.swing.JLabel lblTramitesDisponibles;
    private javax.swing.JLabel lblTramitesPendientes;
    private javax.swing.JTextField txtNumeroPlaca;
    // End of variables declaration//GEN-END:variables

    
    /**
    * Método que limpia los datos de la interfaz gráfica.
    *
    * Este método se utiliza para limpiar los campos de la interfaz gráfica
    * después de realizar una búsqueda o cuando se necesita restablecer los datos.
    */
    private void limpiarDatos(){
        lblMarca.setText("-----");
        lblModelo.setText("-----");
        lblColor.setText("-----");
        lblLinea.setText("-----");
        lblTipo.setText("-----");
        lblNumeroSerie.setText("-----");
        txtNumeroPlaca.setText("");
    }

    /**
    * Método que carga los datos del vehículo consultado en la interfaz gráfica.
    *
    * Este método se utiliza para mostrar la información del vehículo consultado
    * en los respectivos campos de la interfaz gráfica.
    */
    private void cargarDatosPlaca() {
        VehiculoNuevoDTO vehiculoDTO = placaDTO.getVehiculo();
        lblTipo.setText(placaDTO.getTipoVehiculo());
        lblColor.setText(vehiculoDTO.getColor());
        lblMarca.setText(vehiculoDTO.getMarca());
        lblModelo.setText(vehiculoDTO.getModelo());
        lblLinea.setText(vehiculoDTO.getLinea());
        lblNumeroSerie.setText(vehiculoDTO.getNumeroSerie());
    }
}