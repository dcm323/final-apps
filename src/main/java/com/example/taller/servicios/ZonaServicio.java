package com.example.taller.servicios;

import com.example.taller.entidades.Zona;
import com.example.taller.repositorios.ZonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ZonaServicio implements ServicioBase<Zona> {
    @Autowired
    private ZonaRepositorio zonaRepositorio;
    @Override
    public List<Zona> buscarTodos() throws Exception {
        try {
            List<Zona>zonas=zonaRepositorio.findAll();
            return zonas;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Zona buscarPorId(Integer id) throws Exception {
        try {
            Optional<Zona>zonaOptional= zonaRepositorio.findById(id);
            if (zonaOptional.isPresent()){
                return zonaOptional.get();
            }else{
                throw new Exception("Zona no encotrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Zona registrar(Zona datosARegistrar) throws Exception {
        try {
           return zonaRepositorio.save(datosARegistrar);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Zona actualizar(Integer id, Zona datosNuevos) throws Exception {
        try {
            Optional<Zona>zonaOptional= zonaRepositorio.findById(id);
            if(zonaOptional.isPresent()){
                return zonaRepositorio.save(datosNuevos);
            }else{
                throw new Exception("Zona no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error);
        }

    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try {
            Optional<Zona>zonaOptional = zonaRepositorio.findById(id);
            if (zonaOptional.isPresent()){
               zonaRepositorio.deleteById(id);
               return true;
            }else{
                throw new Exception("Zona no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
