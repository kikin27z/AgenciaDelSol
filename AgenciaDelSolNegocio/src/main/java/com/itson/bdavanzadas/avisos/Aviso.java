package com.itson.bdavanzadas.avisos;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Esta clase implementa la interfaz IAviso y proporciona métodos para mostrar diferentes tipos de avisos
 * al usuario mediante ventanas emergentes.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class Aviso implements IAviso{

    /**
     * Método para mostrar un aviso al usuario mediante una ventana emergente.
     *
     * @param ventana
     * @param mensaje El mensaje a mostrar en el aviso.
     */
    @Override
    public void mostrarAviso(JFrame ventana, String mensaje) {
        JOptionPane.showMessageDialog(ventana, mensaje, "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Método para mostrar una ventana emergente de confirmación al usuario.
     *
     * @param ventana
     * @param mensaje El mensaje a mostrar en la ventana de confirmación.
     * @param titulo El título de la ventana de confirmación.
     * @return true si el usuario selecciona "OK", false si selecciona
     * "Cancelar".
     */
    @Override
    public boolean mostrarConfirmacion(JFrame ventana, String mensaje, String titulo) {
        int respuesta = JOptionPane.showConfirmDialog(ventana, mensaje, titulo, JOptionPane.OK_CANCEL_OPTION);
        return respuesta == JOptionPane.OK_OPTION;
    }

    /**
     * Método para mostrar una ventana emergente de información al usuario.
     *
     * @param ventana
     * @param mensaje El mensaje a mostrar en la ventana de información.
     * @param titulo El título de la ventana de información.
     */
    @Override
    public void mostrarInformacion(JFrame ventana, String mensaje, String titulo) {
        JOptionPane.showMessageDialog(ventana, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

}
