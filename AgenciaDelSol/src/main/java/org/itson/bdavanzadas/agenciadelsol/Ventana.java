package org.itson.bdavanzadas.agenciadelsol;

import com.itson.bdavanzadas.dtos.VehiculoNuevoDTO;
import com.itson.bdavanzadas.dtos.ConsultarPersonaDTO;
import com.itson.bdavanzadas.dtos.LicenciasDTO;
import com.itson.bdavanzadas.dtos.PlacaNuevaDTO;
import javax.swing.JPanel;

/**
 * Clase que representa la ventana principal de la aplicación.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class Ventana extends javax.swing.JFrame {

    private JPanel panelActual;
    private boolean tramiteLicencia;
    private boolean placaNueva;

    /**
     * Creates new form Ventana
     */
    public Ventana() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 580));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método para limpiar el contenido de la ventana. Si hay un panel
     * actualmente mostrado, lo elimina de la ventana.
     */
    public void limpiarFrame() {
        if (panelActual != null) {
            this.remove(panelActual);
            panelActual = null;
        }
    }

    /**
     * Método para agregar un panel a la ventana. Este método agrega el panel
     * especificado a la ventana, lo posiciona y ajusta su tamaño
     * automáticamente.
     *
     * @param panel El panel que se va a agregar a la ventana.
     */
    public void ponerEnJFrame(JPanel panel) {
        this.add(panel);
        panel.setBounds(0, 0, 1000, 580);
        this.setLocationRelativeTo(null);
        this.pack();  // Ajustar el tamaño automáticamente
    }

    /**
     * Cambia la vista actual del frame a la vista de inicio.
     */
    public void cambiarVistaInicio() {
        limpiarFrame();
        VistaInicio vistaInicio = new VistaInicio(this);
        ponerEnJFrame(vistaInicio);
        panelActual = vistaInicio;
    }

    /**
     * Cambia la vista actual del frame a la vista del módulo de reporte.
     */
    public void cambiarVistaModuloReporte() {
        limpiarFrame();
        VistaModuloReporte vistaReporte = new VistaModuloReporte(this);
        ponerEnJFrame(vistaReporte);
        panelActual = vistaReporte;
    }

    /**
     * Cambia la vista actual del frame a la vista del módulo de consultas.
     */
    public void cambiarVistaModuloConsultas() {
        limpiarFrame();
        VistaModuloConsultas vistaModuloConsultas = new VistaModuloConsultas(this);
        ponerEnJFrame(vistaModuloConsultas);
        panelActual = vistaModuloConsultas;
    }

    /**
     * Cambia la vista actual del frame a la vista de los trámites en curso.
     */
    public void cambiarVistaTramitesEnCurso() {
        limpiarFrame();
        VistaTramitesEnCurso vistaTramitesEnCurso = new VistaTramitesEnCurso(this);
        ponerEnJFrame(vistaTramitesEnCurso);
        panelActual = vistaTramitesEnCurso;
    }

    /**
     * Cambia la vista actual del frame a la vista de persona a tramitar.
     */
    public void cambiarVistaPersonaATramitar() {
        limpiarFrame();
        VistaPersonaATramitar vistaPersonaATramitar = new VistaPersonaATramitar(this);
        ponerEnJFrame(vistaPersonaATramitar);
        panelActual = vistaPersonaATramitar;
    }

    /**
     * Cambia la vista actual del frame a la vista de tramitar licencia con la
     * información de una persona.
     *
     * @param personaDTO Objeto ConsultarPersonaDTO que contiene la información
     * de la persona para tramitar la licencia.
     */
    public void cambiarVistaTramitarLicencia(ConsultarPersonaDTO personaDTO) {
        limpiarFrame();
        VistaTramitarLicencia vistaTramitarLicencia = new VistaTramitarLicencia(this, personaDTO);
        ponerEnJFrame(vistaTramitarLicencia);
        panelActual = vistaTramitarLicencia;
    }
    
     /**
     * Cambia la vista actual del frame a la vista de confirmación de tramite de licencia.
     *
     * @param licenciaDTO Objeto LicenciasDTO que contiene la información de la licencia tramitada.
     */
    public void cambiarVistaConfirmacionTramiteLicencia(LicenciasDTO licenciaDTO){
        limpiarFrame();
        VistaConfirmacionTramiteLicencia vistaConfirmarLicencia = new VistaConfirmacionTramiteLicencia(this, licenciaDTO);
        ponerEnJFrame(vistaConfirmarLicencia);
        panelActual = vistaConfirmarLicencia;
    }
    
    /**
     * Cambia la vista actual del frame a la vista de tramitar vehículo para una persona.
     * 
     * @param personaDTO Objeto ConsultarPersonaDTO que contiene la información
     * de la persona para la cual se tramita el vehículo.
     */
    public void cambiarVistaVehiculoTramitar(ConsultarPersonaDTO personaDTO){
        limpiarFrame();
        VistaVehiculoTramitar vistaConfirmarLicencia = new VistaVehiculoTramitar(this, personaDTO);
        ponerEnJFrame(vistaConfirmarLicencia);
        panelActual = vistaConfirmarLicencia;
    }
    
    /**
     * Cambia la vista actual del frame a la vista de agregar vehículo.
     * 
     * @param personaDTO Objeto ConsultarPersonaDTO que contiene la información
     * de la persona del vehículo a agregar.
     */
    public void cambiarVistaAgregarVehiculo(ConsultarPersonaDTO personaDTO){
        limpiarFrame();
        VistaAgregarVehiculo vistaAgregarVehiculo = new VistaAgregarVehiculo(this, personaDTO);
        ponerEnJFrame(vistaAgregarVehiculo);
        panelActual = vistaAgregarVehiculo;
    }
    
    /**
     * Cambia la vista actual del frame a la vista de información del trámite.
     * 
     * @param placaNuevaDTO Objeto dto que contiene toda la informacion del
     * trámite de la placa
     */
    public void cambiarVistaTramitarPlaca(PlacaNuevaDTO placaNuevaDTO){
        limpiarFrame();
        VistaTramitarPlaca vistaTramitarPlaca = new VistaTramitarPlaca(this, placaNuevaDTO);
        ponerEnJFrame(vistaTramitarPlaca);
        panelActual = vistaTramitarPlaca;
    }

     /**
     * Verifica si se está realizando un trámite de licencia.
     *
     * @return true si se está realizando un trámite de licencia, false de lo contrario.
     */
    public boolean isTramiteLicencia() {
        return tramiteLicencia;
    }

     /**
     * Establece si se está realizando un trámite de licencia.
     *
     * @param tramiteLicencia true si se está realizando un trámite de licencia, false de lo contrario.
     */
    public void setTramiteLicencia(boolean tramiteLicencia) {
        this.tramiteLicencia = tramiteLicencia;
    }

    public boolean isPlacaNueva() {
        return placaNueva;
    }

    public void setPlacaNueva(boolean placaNueva) {
        this.placaNueva = placaNueva;
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
