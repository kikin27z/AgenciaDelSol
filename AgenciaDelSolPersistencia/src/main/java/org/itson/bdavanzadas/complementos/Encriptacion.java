package org.itson.bdavanzadas.complementos;


import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 * Clase que proporciona métodos estáticos para encriptar y desencriptar cadenas de texto utilizando AES.
 * La clave de encriptación y desencriptación está definida en la variable 'clave'.
 * Se utiliza un vector de inicialización (IV) de 16 bytes para aumentar la seguridad.
 * Se utiliza el modo de operación CBC (Cipher Block Chaining) y el padding PKCS5.
 * 
 * Para encriptar y desencriptar se utilizan métodos estáticos 'encriptar' y 'desencriptar' respectivamente.
 * Estos métodos reciben una cadena de texto y devuelven la cadena encriptada o desencriptada respectivamente.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class Encriptacion {

    /**
     * Objeto SecureRandom utilizado para generar un vector de inicialización aleatorio.
     */
    public static SecureRandom sr = new SecureRandom();

    /**
     * Método estático para encriptar una cadena de texto utilizando AES.
     * 
     * @param value La cadena de texto a encriptar.
     * @return La cadena encriptada en formato base64.
     */
    public static String encriptar( String value) {
        String clave = "TqmProfeGibran12";
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            SecretKeySpec sks = new SecretKeySpec(clave.getBytes("UTF-8"), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, sks, new IvParameterSpec(new byte[16]));

            byte[] encriptado = cipher.doFinal(value.getBytes());
            return DatatypeConverter.printBase64Binary(encriptado);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Método estático para desencriptar una cadena de texto en formato base64 utilizando AES.
     * 
     * @param encriptado La cadena encriptada en formato base64.
     * @return La cadena desencriptada.
     */
    public static String decriptar( String encriptado) {
        String clave = "TqmProfeGibran12";
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            SecretKeySpec sks = new SecretKeySpec(clave.getBytes("UTF-8"), "AES");
            cipher.init(Cipher.DECRYPT_MODE, sks, new IvParameterSpec(new byte[16]));

            byte[] dec = cipher.doFinal(DatatypeConverter.parseBase64Binary(encriptado));
            return new String(dec);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}