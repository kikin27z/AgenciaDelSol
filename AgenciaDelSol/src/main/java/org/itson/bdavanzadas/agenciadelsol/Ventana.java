package org.itson.bdavanzadas.agenciadelsol;

import com.itson.bdavanzadas.dtos.ConsultarPersonaDTO;
import com.itson.bdavanzadas.dtos.LicenciasDTO;
import com.itson.bdavanzadas.dtos.TramiteDTO;
import com.itson.bdavanzadas.negocio.IPersonasBO;
import javax.swing.JPanel;
import org.itson.bdavanzadas.daos.IPersonasDAO;
import org.itson.bdavanzadas.daos.PersonasDAO;

/**
 * Clase que representa la ventana principal de la aplicación.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class Ventana extends javax.swing.JFrame {

    private JPanel panelActual;
    private IPersonasBO personasBO;
    private boolean seHizoInsercion;

    /**
     * Creates new form Ventana
     */
    public Ventana() {
        seHizoInsercion = false;
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
     *
     * Este método elimina cualquier componente presente en el frame actual y
     * crea una nueva instancia de la vista de inicio. Luego, coloca esta nueva
     * vista en el frame y actualiza el panel actual al nuevo panel de inicio.
     */
    public void cambiarVistaInicio() {
        limpiarFrame();
        VistaInicio vistaInicio = new VistaInicio(this);
        ponerEnJFrame(vistaInicio);
        panelActual = vistaInicio;
    }

    /**
     * Cambia la vista actual del frame a la vista del módulo de reporte.
     *
     * Este método elimina cualquier componente presente en el frame actual y
     * crea una nueva instancia de la vista del módulo de reporte. Luego, coloca
     * esta nueva vista en el frame y actualiza el panel actual al nuevo panel
     * del módulo de reporte.
     */
    public void cambiarVistaModuloReporte() {
        limpiarFrame();
        VistaModuloReporte vistaReporte = new VistaModuloReporte(this);
        ponerEnJFrame(vistaReporte);
        panelActual = vistaReporte;
    }

    /**
     * Cambia la vista actual del frame a la vista del módulo de consultas.
     *
     * Este método elimina cualquier componente presente en el frame actual y
     * crea una nueva instancia de la vista del módulo de consultas. Luego,
     * coloca esta nueva vista en el frame y actualiza el panel actual al nuevo
     * panel del módulo de consultas.
     */
    public void cambiarVistaModuloConsultas() {
        limpiarFrame();
        VistaModuloConsultas vistaModuloConsultas = new VistaModuloConsultas(this);
        ponerEnJFrame(vistaModuloConsultas);
        panelActual = vistaModuloConsultas;
    }

    /**
     * Cambia la vista actual del frame a la vista de los trámites en curso.
     *
     * Este método elimina cualquier componente presente en el frame actual y
     * crea una nueva instancia de la vista de los trámites en curso. Luego,
     * coloca esta nueva vista en el frame y actualiza el panel actual al nuevo
     * panel de los trámites en curso.
     */
    public void cambiarVistaTramitesEnCurso() {
        limpiarFrame();
        VistaTramitesEnCurso vistaTramitesEnCurso = new VistaTramitesEnCurso(this);
        ponerEnJFrame(vistaTramitesEnCurso);
        panelActual = vistaTramitesEnCurso;
    }

    /**
     * Cambia la vista actual del frame a la vista de persona a tramitar.
     *
     * Este método elimina cualquier componente presente en el frame actual y
     * crea una nueva instancia de la vista de persona a tramitar. Luego, coloca
     * esta nueva vista en el frame y actualiza el panel actual al nuevo panel
     * de persona a tramitar.
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
     * Este método elimina cualquier componente presente en el frame actual y
     * crea una nueva instancia de la vista de tramitar licencia, pasando como
     * parámetro la información de la persona proporcionada en un objeto
     * ConsultarPersonaDTO. Luego, coloca esta nueva vista en el frame y
     * actualiza el panel actual al nuevo panel de tramitar licencia.
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

    public void cambiarVistaConfirmacionTramiteLicencia(LicenciasDTO licenciaDTO) {
        limpiarFrame();
        VistaConfirmacionTramiteLicencia vistaConfirmarLicencia = new VistaConfirmacionTramiteLicencia(this, licenciaDTO);
        ponerEnJFrame(vistaConfirmarLicencia);
        panelActual = vistaConfirmarLicencia;
    }

    public void cambiarVistaPrevisionReporte(TramiteDTO tramiteDTO) {
        limpiarFrame();
        VistaPrevisionReporte vistaPrevisionReporte = new VistaPrevisionReporte(this, tramiteDTO);
        ponerEnJFrame(vistaPrevisionReporte);
        panelActual = vistaPrevisionReporte;
    }

    /**
     * Verifica si se ha realizado una inserción masiva de personas.
     *
     * Este método devuelve un valor booleano que indica si se ha realizado una
     * inserción masiva de personas en el sistema.
     *
     * @return true si se ha realizado una inserción masiva de personas, false
     * en caso contrario.
     */
    public boolean isSeHizoInsercion() {
        return seHizoInsercion;
    }

    /**
     * Establece si se ha realizado una inserción masiva de personas.
     *
     * Este método establece el estado de la inserción masiva de personas en el
     * sistema.
     *
     * @param seHizoInsercion true si se ha realizado una inserción masiva de
     * personas, false en caso contrario.
     */
    public void setSeHizoInsercion(boolean seHizoInsercion) {
        this.seHizoInsercion = seHizoInsercion;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
