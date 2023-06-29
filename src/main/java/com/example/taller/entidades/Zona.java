package com.example.taller.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Entity
@Table(name = "zonas" )
public class Zona {

@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name = "id")
    private Integer id;
@Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
@Column(name = "volumen", nullable = false)
    private Integer volumen;
@OneToMany(mappedBy = "zona")
@JsonManagedReference
private List<Mercancia> mercancias;

    public Zona(Integer id, String nombre, Integer volumen, List<Mercancia> mercancias) {
        this.id = id;
        this.nombre = nombre;
        this.volumen = volumen;
        this.mercancias = mercancias;
    }

    public Zona() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getVolumen() {
        return volumen;
    }

    public void setVolumen(Integer volumen) {
        this.volumen = volumen;
    }

    public List<Mercancia> getMercancias() {
        return mercancias;
    }

    public void setMercancias(List<Mercancia> mercancias) {
        this.mercancias = mercancias;
    }
}
