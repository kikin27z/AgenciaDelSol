    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package com.itson.bdavanzadas.dtos;

    import java.util.Calendar;

    /**
     * En este DTO encapsulamos los datos necesarios para poder realizar una
     * consulta de persona.
     * 
     * @author José Karim Franco Valencia - 245138
     * @author Jesus Rene Gonzalez Castro - 247336
     * @author Gael Rafael Castro Molina - 247887
     */
    public class ConsultarPersonaDTO {

        private String curp;
        private String rfc;
        private String nombres;
        private Calendar fechaNacimiento;
        private int telefono;

        public ConsultarPersonaDTO() {
        }

        public String getCurp() {
            return curp;
        }

        public void setCurp(String curp) {
            this.curp = curp;
        }

        public String getRfc() {
            return rfc;
        }

        public void setRfc(String rfc) {
            this.rfc = rfc;
        }

        public String getNombres() {
            return nombres;
        }

        public void setNombres(String nombres) {
            this.nombres = nombres;
        }

        public Calendar getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(Calendar fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public int getTelefono() {
            return telefono;
        }

        public void setTelefono(int telefono) {
            this.telefono = telefono;
        }

    }
