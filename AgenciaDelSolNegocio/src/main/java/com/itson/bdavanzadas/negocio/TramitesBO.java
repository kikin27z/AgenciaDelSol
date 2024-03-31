package com.itson.bdavanzadas.negocio;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import com.itson.bdavanzadas.avisos.Aviso;
import com.itson.bdavanzadas.dtos.ConsultarPersonaDTO;
import com.itson.bdavanzadas.dtos.TramiteDTO;
import com.itson.bdavanzadas.excepcionesdtos.ValidacionDTOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.itson.bdavanzadas.conexion.Conexion;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.daos.ITramitesDAO;
import org.itson.bdavanzadas.daos.TramitesDAO;
import org.itson.bdavanzadas.entidades.Discapacidad;
import org.itson.bdavanzadas.entidades.Licencia;
import org.itson.bdavanzadas.entidades.Persona;
import org.itson.bdavanzadas.entidades.Placa;
import org.itson.bdavanzadas.entidades.TipoTramite;
import org.itson.bdavanzadas.entidades.Tramite;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 * Clase que implementa la interfaz ITramitesBO y proporciona los métodos para
 * realizar operaciones relacionadas con los trámites.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class TramitesBO implements ITramitesBO {

    private ITramitesDAO tramitesDAO;
    static final Logger logger = Logger.getLogger(TramitesDAO.class.getName());
    private IConexion conexion;

    /**
     * Constructor de la clase TramitesBO. inicializa la conexión a la base de
     * datos y el objeto de acceso a datos (DAO) correspondiente.
     */
    public TramitesBO() {
        this.conexion = new Conexion();
        this.tramitesDAO = new TramitesDAO(conexion);
        
    }

    /**
     * Consulta los trámites que coinciden con los criterios especificados en el
     * objeto TramiteDTO.
     *
     * @return Una lista de objetos TramiteDTO que representan los trámites
     * encontrados.
     */
    @Override
    public List<TramiteDTO> consultarTramites() {

        try {
            List<Tramite> tramitesEncontrados = tramitesDAO.consultarTramites();
            List<TramiteDTO> tramitesDTOEncontrados = new LinkedList<>();

            for (Tramite tramitesEncontrado : tramitesEncontrados) {
                TramiteDTO tramite = new TramiteDTO(
                        tramitesEncontrado.getFechaEmision(),
                        tramitesEncontrado.getCosto(),
                        tramitesEncontrado.getTipo(),
                        fromPersona(tramitesEncontrado.getPersona()));

                tramitesDTOEncontrados.add(tramite);
            }
            return tramitesDTOEncontrados;
        } catch (PersistenciaException ex) {
            Logger.getLogger(TramitesBO.class.getName()).log(Level.SEVERE, "No fue posible consultar la lista de tramites");
            return null;
        }
    }

    public void generarReporte(TramiteDTO tramite) {
        try {
            // Crear un JRBeanCollectionDataSource con el objeto TramiteReporteDTO
            JRBeanCollectionDataSource itemJRBean = new JRBeanCollectionDataSource(Collections.singletonList(tramite));

            // Parámetros para el reporte
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("ParametroTipo", itemJRBean);

            // Configuración del JFileChooser para seleccionar la ubicación y nombre del archivo
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar Reporte");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));

            // Mostrar el diálogo para guardar el archivo
            int userSelection = fileChooser.showSaveDialog(null);

            // Si el usuario selecciona guardar
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                java.io.File fileToSave = fileChooser.getSelectedFile();
                String filePath = fileToSave.getAbsolutePath();

                // Asegurar que la extensión del archivo sea .pdf
                if (!filePath.endsWith(".pdf")) {
                    filePath += ".pdf";
                }

                // Exportar el reporte a un archivo PDF
                try (InputStream input = getClass().getResourceAsStream("AgenicaReporte_A4.jrxml")) {
                    JasperDesign jasperDesign = JRXmlLoader.load(input);
                    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

                    // Exportar el reporte a un archivo PDF
                    JasperExportManager.exportReportToPdfFile(jasperPrint, filePath);

                    // Mensaje de éxito
                    JOptionPane.showMessageDialog(null, "Archivo guardado", "Info", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    // Manejar la excepción si ocurre algún error al generar el reporte
                    JOptionPane.showMessageDialog(null, "Error al generar el reporte PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (userSelection == JFileChooser.CANCEL_OPTION) {
                // Si el usuario cancela la operación
                JOptionPane.showMessageDialog(null, "Usuario canceló la operación", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            // Manejar cualquier excepción que pueda ocurrir
            JOptionPane.showMessageDialog(null, "Error al generar el reporte PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para convertir Persona a ConsultarPersonaDTO
    private static ConsultarPersonaDTO fromPersona(Persona persona) {
        return new ConsultarPersonaDTO(
                persona.getNombres(),
                persona.getApellidoPaterno(),
                persona.getApellidoMaterno()
        );
    }

}
