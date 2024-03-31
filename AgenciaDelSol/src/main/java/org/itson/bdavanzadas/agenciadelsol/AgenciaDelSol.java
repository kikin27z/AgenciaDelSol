package org.itson.bdavanzadas.agenciadelsol;


/**
 * Clase principal de la aplicación AgenciaDelSol.
 * 
 * Esta clase contiene el método principal `main` que inicia la aplicación.
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class AgenciaDelSol {
     /**
     * Método principal de la aplicación.
     * 
     * Este método crea una instancia de la clase Ventana y cambia la vista
     * actual a la vista de inicio. Luego hace visible la ventana.
     * 
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Ventana ventana = new Ventana();

        ventana.cambiarVistaInicio();
        ventana.setVisible(true);
    }
    
}
