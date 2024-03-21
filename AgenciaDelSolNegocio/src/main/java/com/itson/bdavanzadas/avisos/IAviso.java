package com.itson.bdavanzadas.avisos;

import javax.swing.JFrame;

/**
 * Esta interfaz define métodos para mostrar avisos al usuario mediante ventanas emergentes.
 * Los métodos definidos en esta interfaz permiten mostrar diferentes tipos de avisos, como mensajes simples,
 * confirmaciones y ventanas de información.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public interface IAviso {
    /**
     * Método para mostrar un aviso al usuario mediante una ventana emergente.
     *
     * @param ventana
     * @param mensaje El mensaje a mostrar en el aviso.
     */
    public void mostrarAviso(JFrame ventana, String mensaje);

    /**
     * Método para mostrar una ventana emergente de confirmación al usuario.
     *
     * @param ventana
     * @param mensaje El mensaje a mostrar en la ventana de confirmación.
     * @param titulo El título de la ventana de confirmación.
     * @return true si el usuario selecciona "OK", false si selecciona
     * "Cancelar".
     */
    public boolean mostrarConfirmacion(JFrame ventana, String mensaje, String titulo);

    /**
     * Método para mostrar una ventana emergente de información al usuario.
     *
     * @param ventana
     * @param mensaje El mensaje a mostrar en la ventana de información.
     * @param titulo El título de la ventana de información.
     */
    public void mostrarInformacion(JFrame ventana,String mensaje, String titulo);
}
