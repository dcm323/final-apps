package com.example.taller.servicios;

import com.example.taller.entidades.Mercancia;
import com.example.taller.entidades.Zona;
import com.example.taller.repositorios.MercanciaRepoitorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MercanciaServicio implements ServicioBase<Mercancia> {
    @Autowired
    private MercanciaRepoitorio mercanciaRepoitorio;
    @Override
    public List<Mercancia> buscarTodos() throws Exception {
        try {
           List <Mercancia>mercancias=mercanciaRepoitorio.findAll();
            return mercancias;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Mercancia buscarPorId(Integer id) throws Exception {
        try {
            Optional<Mercancia> mercanciaOptional= mercanciaRepoitorio.findById(id);
            if (mercanciaOptional.isPresent()){
                return mercanciaOptional.get();
            }else{
                throw new Exception("Mercancia no encotrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Mercancia registrar(Mercancia datosARegistrar) throws Exception {
        try {
            return mercanciaRepoitorio.save(datosARegistrar);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Mercancia actualizar(Integer id, Mercancia datosNuevos) throws Exception {
        try {
            Optional<Mercancia>mercanciaOptional= mercanciaRepoitorio.findById(id);
            if(mercanciaOptional.isPresent()){
                return mercanciaRepoitorio.save(datosNuevos);
            }else{
                throw new Exception("Mercancia no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error);
        }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try {
            Optional<Mercancia>mercanciaOptional = mercanciaRepoitorio.findById(id);
            if (mercanciaOptional.isPresent()){
                mercanciaRepoitorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Mercancia no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
