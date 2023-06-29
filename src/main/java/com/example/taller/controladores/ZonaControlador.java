package com.example.taller.controladores;

import com.example.taller.entidades.Zona;
import com.example.taller.servicios.ZonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/zona")
public class ZonaControlador {
    @Autowired
    protected ZonaServicio zonaServicio;
    @PostMapping
    public ResponseEntity<Zona> registrar(@RequestBody Zona datosAGuardar){
        try {
            Zona zonaRegistrada=zonaServicio.registrar(datosAGuardar);
            return ResponseEntity.status(HttpStatus.CREATED).body(zonaRegistrada);
        }catch (Exception error){
            String mensaje = "tenemos un error al resgitsrar"+error.getMessage();
            Zona zonaError = new Zona();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(zonaError);
        }

    }

    @GetMapping
    public ResponseEntity<List<Zona>>buscarTodas(){
        try {
            List<Zona> zonas = zonaServicio.buscarTodos();
            return ResponseEntity.status(HttpStatus.OK).body(zonas);
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Zona>buscarPorId(@PathVariable Integer id){
        try {
            Zona zonaEncontrada=zonaServicio.buscarPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(zonaEncontrada);
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
