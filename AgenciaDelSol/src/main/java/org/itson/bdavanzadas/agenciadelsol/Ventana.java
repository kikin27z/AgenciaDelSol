package org.itson.bdavanzadas.agenciadelsol;

import com.itson.bdavanzadas.negocio.IPersonasBO;
import javax.swing.JPanel;
import org.itson.bdavanzadas.daos.IPersonasDAO;
import org.itson.bdavanzadas.daos.PersonasDAO;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class Ventana extends javax.swing.JFrame {

    private JPanel panelActual;
    private IPersonasBO personasBO;
    
    /**
     * Creates new form Ventana
     */
    public Ventana(IPersonasBO personasBO) {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 580));
        setPreferredSize(new java.awt.Dimension(1000, 580));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
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
    
    
    
    public void cambiarVistaInicio() {
        limpiarFrame();
        VistaInicio vistaInicio = new VistaInicio(this, personasBO);
        ponerEnJFrame(vistaInicio);
        panelActual = vistaInicio;
    }
    
    public void cambiarVistaModuloReporte() {
        limpiarFrame();
        VistaModuloReporte vistaReporte = new VistaModuloReporte(this);
        ponerEnJFrame(vistaReporte);
        panelActual = vistaReporte;
    }
    
    public void cambiarVistaModuloConsultas() {
        limpiarFrame();
        VistaModuloConsultas vistaModuloConsultas = new VistaModuloConsultas(this);
        ponerEnJFrame(vistaModuloConsultas);
        panelActual = vistaModuloConsultas;
    }
    
    public void cambiarVistaTramitesEnCurso(){
        limpiarFrame();
        VistaTramitesEnCurso vistaTramitesEnCurso = new VistaTramitesEnCurso(this);
        ponerEnJFrame(vistaTramitesEnCurso);
        panelActual = vistaTramitesEnCurso;
    }
    
    public void cambiarVistaPersonaATramitar(){
        limpiarFrame();
        VistaPersonaATramitar vistaPersonaATramitar = new VistaPersonaATramitar(this, personasBO);
        ponerEnJFrame(vistaPersonaATramitar);
        panelActual = vistaPersonaATramitar;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
