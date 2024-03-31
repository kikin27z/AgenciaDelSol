package com.itson.bdavanzadas.negocio;

import com.itson.bdavanzadas.dtos.ConsultarPersonaDTO;
import com.itson.bdavanzadas.dtos.FiltrosReporteGeneradoDTO;
import com.itson.bdavanzadas.dtos.ReporteDTO;
import com.itson.bdavanzadas.dtos.TramiteDTO;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
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
import org.itson.bdavanzadas.complementos.FiltrosReporte;
import org.itson.bdavanzadas.entidades.Persona;
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

                Calendar fechaEmisionCalendar = tramitesEncontrado.getFechaEmision();
                Date fechaEmisionDate = fechaEmisionCalendar.getTime(); // Convertir Calendar a Date

                TramiteDTO tramite = new TramiteDTO(
                        fechaEmisionDate,
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

    /**
     * Obtiene una lista de trámites que coinciden con los filtros especificados
     * en el objeto FiltrosReporteGeneradoDTO.
     *
     * @param filtro El objeto FiltrosReporteGeneradoDTO que contiene los
     * filtros para la búsqueda de trámites.
     * @return Una lista de ReporteDTO que representa los trámites encontrados
     * que coinciden con los filtros especificados. Si no se encuentran trámites
     * que coincidan con los filtros, se devuelve una lista vacía.
     */
    public List<ReporteDTO> obtenerTramites(FiltrosReporteGeneradoDTO filtro) {

        List<ReporteDTO> listaTramites = new ArrayList<>();

        FiltrosReporte filtrosReporte = new FiltrosReporte();
        filtrosReporte.setPersona(filtro.getPersona());
        filtrosReporte.setTipoTramite(filtro.getTipoTramite());
        filtrosReporte.setFechaInicio(filtro.getFechaInicio());
        filtrosReporte.setFechaFin(filtro.getFechaFin());

        try {
            // Obtener los trámites de acuerdo a los filtros proporcionados
            List<Tramite> tramitesEncontrados = tramitesDAO.consultarTramites();

            // Convertir los trámites encontrados a TramiteDTO
            for (Tramite tramite : tramitesEncontrados) {

                String persona = tramite.getPersona().getNombres() + " " + tramite.getPersona().getApellidoPaterno();

                String tipoTramite = tramite.getTipo();

                Date fechaEmision = tramite.getFechaEmision().getTime();

                Float costo = tramite.getCosto();

                ReporteDTO reporteDTO = new ReporteDTO(fechaEmision, costo, persona, tipoTramite);

                listaTramites.add(reporteDTO);
            }

            return listaTramites;
        } catch (PersistenciaException ex) {
            // Manejar la excepción en caso de error
            Logger.getLogger(TramitesBO.class.getName()).log(Level.SEVERE, "No fue posible obtener los trámites con los filtros especificados");
            return Collections.emptyList();
        }
    }

    /**
     * Convierte un objeto de la clase Persona en un objeto de la clase
     * ConsultarPersonaDTO.
     *
     * @param persona La instancia de Persona a convertir.
     * @return Una nueva instancia de ConsultarPersonaDTO creada a partir de los
     * datos de la persona.
     */
    private static ConsultarPersonaDTO fromPersona(Persona persona) {
        return new ConsultarPersonaDTO(
                persona.getNombres(),
                persona.getApellidoPaterno(),
                persona.getApellidoMaterno()
        );
    }

    /**
     * Consulta los tramites de una persona en especifico.
     *
     * @param personaDTO persona a la cual consultaremos
     * @return lista de tramites de la persona.
     */
    @Override
    public List<TramiteDTO> consultarTramitesPersona(ConsultarPersonaDTO personaDTO) {
        Persona persona = new Persona();
        persona.setRfc(personaDTO.getRfc());
        try {
            List<Tramite> tramitesEncontrados = tramitesDAO.consultatTramitesPersona(persona);
            List<TramiteDTO> tramitesDTO = new LinkedList<>();
            for (Tramite tramiteEncontrado : tramitesEncontrados) {
                TramiteDTO tramite = new TramiteDTO(
                        //Nota Gael: Hola Jesús, al hacer un cambio en el TramiteDTO fue necesario añadir el getTime()
                        tramiteEncontrado.getFechaEmision().getTime(),
                        tramiteEncontrado.getCosto(),
                        tramiteEncontrado.getTipo()
                );
                tramitesDTO.add(tramite);
            }
            return tramitesDTO;
        } catch (PersistenciaException ex) {
            Logger.getLogger(TramitesBO.class.getName()).log(Level.SEVERE, null, "No fue posible consultar la lista de tramites");
            return null;
        }
    }

    /* 
     * Genera un reporte en formato PDF a partir de una lista de ReporteDTO.
     * Permite al usuario seleccionar la ubicación y el nombre del archivo PDF.
     *
     * @param listaTramites La lista de ReporteDTO que se utilizará para generar
     * el reporte.
     */
    @Override
    public void generarReporte(List<ReporteDTO> listaTramites) {

        try {

            // Crear un JRBeanCollectionDataSource con la lista de ReporteDTO
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaTramites);

            // Parámetros para el reporte mapeado
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("ParametroTipo", dataSource);

            // Configuración del JFileChooser para la seleccion de ubicación y nombre para el archivo
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar Reporte");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));

            // Se muestra el diálogo para guardar el archivo
            int userSelection = fileChooser.showSaveDialog(null);

            // Cuando el usuario selecciona guardar
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                java.io.File fileToSave = fileChooser.getSelectedFile();
                String filePath = fileToSave.getAbsolutePath();

                // Asegurar que la extensión del archivo sea .pdf
                if (!filePath.endsWith(".pdf")) {
                    filePath += ".pdf";
                }

                // Exportar el reporte a un archivo PDF
                try (InputStream input = getClass().getResourceAsStream("/AgenciaReporte_A4.jrxml")) {
                    JasperDesign jasperDesign = JRXmlLoader.load(input);
                    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

                    JasperExportManager.exportReportToPdfFile(jasperPrint, filePath);

                    // Mensaje de exito
                    JOptionPane.showMessageDialog(null, "Archivo guardado", "Info", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    // Manejar la excepción cuando ocurre algún error al generar el reporte
                    JOptionPane.showMessageDialog(null, "Error al generar el reporte PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(TramitesBO.class.getName()).log(Level.SEVERE, null, "No fue posible generar el reporte");
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

    /**
     * Convierte una lista de trámites en una lista de reportes. Cada elemento
     * de la lista de trámites se transforma en un objeto ReporteDTO, utilizando
     * los datos de fecha de emisión, costo, tipo de trámite y persona asociada
     * obtenidos de los trámites de la lista.
     *
     * @param listaTramites La lista de trámites que se va a convertir en
     * reportes.
     * @return Una lista de ReporteDTO que representa los reportes generados a
     * partir de los trámites.
     */
    @Override
    public List<ReporteDTO> convertirTramitesAReportes(List<TramiteDTO> listaTramites) {
        List<ReporteDTO> listaReportes = new ArrayList<>();

        for (TramiteDTO tramite : listaTramites) {
            // Obtener los datos necesarios del tramite
            Date fechaEmision = tramite.getFechaEmision();
            float costo = tramite.getCosto();
            String tipoTramite = tramite.getTipoTramite();
            String persona = tramite.getPersona().getNombres() + " " + tramite.getPersona().getApellidoPaterno() + " " + tramite.getPersona().getApellidoMaterno();

            // Crear un nuevo objeto ReporteDTO y agregarlo a la lista
            ReporteDTO reporte = new ReporteDTO(fechaEmision, costo, persona, tipoTramite);
            listaReportes.add(reporte);
        }

        return listaReportes;
    }

}
