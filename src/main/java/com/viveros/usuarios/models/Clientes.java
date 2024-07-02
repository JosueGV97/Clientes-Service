package com.viveros.usuarios.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "et_clientes")
@Entity
public class Clientes {

    @Column(name = "pk_cliente")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ET_SEQ1")
    @SequenceGenerator(sequenceName = "seq1_et", allocationSize = 1, name = "ET_SEQ1")
            private Long pkCliente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "celular")
    private String celular;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    public Long getPkCliente() {
        return pkCliente;
    }

    public void setPkCliente(Long pkCliente) {
        this.pkCliente = pkCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
