package org.itson.bdavanzadas.complementos;


import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class Encriptacion {

    public static SecureRandom sr = new SecureRandom();

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