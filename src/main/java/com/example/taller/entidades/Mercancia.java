package com.example.taller.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "mercancias")
public class Mercancia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "codigoIUP")
    private String codigoIUP;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fechaEntrega")
    private String fechaEntrega;
    @Column(name = "motivoDevolucion")
    private String motivoDevolucion;
    @Column(name = "volumen")
    private Integer volumen;
    @Column(name = "enBodega")
    private Boolean enBodega;
    @ManyToOne
    @JoinColumn(name = "id_zona")
    @JsonBackReference
    private Zona zona ;


    public Mercancia(Integer id, String codigoIUP, String nombre, String descripcion, String fechaEntrega, String motivoDevolucion, Integer volumen, Boolean enBodega, Zona zona) {
        this.id = id;
        this.codigoIUP = codigoIUP;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaEntrega = fechaEntrega;
        this.motivoDevolucion = motivoDevolucion;
        this.volumen = volumen;
        this.enBodega = enBodega;
        this.zona = zona;
    }

    public Mercancia() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoIUP() {
        return codigoIUP;
    }

    public void setCodigoIUP(String codigoIUP) {
        this.codigoIUP = codigoIUP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getMotivoDevolucion() {
        return motivoDevolucion;
    }

    public void setMotivoDevolucion(String motivoDevolucion) {
        this.motivoDevolucion = motivoDevolucion;
    }

    public Integer getVolumen() {
        return volumen;
    }

    public void setVolumen(Integer volumen) {
        this.volumen = volumen;
    }

    public Boolean getEnBodega() {
        return enBodega;
    }

    public void setEnBodega(Boolean enBodega) {
        this.enBodega = enBodega;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
}
