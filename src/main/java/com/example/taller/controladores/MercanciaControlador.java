package com.example.taller.controladores;

import com.example.taller.entidades.Mercancia;
import com.example.taller.entidades.Zona;
import com.example.taller.servicios.MercanciaServicio;
import com.example.taller.servicios.ZonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/mercancia")
public class MercanciaControlador {
    @Autowired
    protected MercanciaServicio mercanciaServicio;
    @PostMapping
    public ResponseEntity<Mercancia> registrar(@RequestBody Mercancia datosAGuardar){
        try {
            Mercancia mercanciaRegistrada=mercanciaServicio.registrar(datosAGuardar);
            return ResponseEntity.status(HttpStatus.CREATED).body(mercanciaRegistrada);
        }catch (Exception error){
            String mensaje = "tenemos un error al resgitsrar"+error.getMessage();
           Mercancia mercanciaError = new Mercancia();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mercanciaError);
        }

    }

    @GetMapping
    public ResponseEntity<List<Mercancia>>buscarTodas(){
        try {
            List<Mercancia> mercancias = mercanciaServicio.buscarTodos();
            return ResponseEntity.status(HttpStatus.OK).body(mercancias);
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Mercancia>buscarPorId(@PathVariable Integer id){
        try {
            Mercancia mercanciaEncontrada=mercanciaServicio.buscarPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(mercanciaEncontrada);
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
