package com.eventia.serverback.services;

import com.eventia.serverback.models.Ubicacion;
import com.eventia.serverback.repositories.UbicacionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UbicacionService {
    private final UbicacionRepository ubicacionRepository;

    public UbicacionService(UbicacionRepository ubicacionRepository) {
        this.ubicacionRepository = ubicacionRepository;
    }

    public ArrayList<Ubicacion> getUbicaciones() {
        return ubicacionRepository.getUbicaciones();
    }

    public Ubicacion getUbicacionById(int id) {
        return ubicacionRepository.getUbicacionById(id);
    }

    public String addUbicacion(Ubicacion ubicacion) {
        return ubicacionRepository.addUbicacion(ubicacion);
    }

    public String updateUbicacion(int id, Ubicacion ubicacion) {
        return ubicacionRepository.updateUbicacion(id, ubicacion);
    }

    public String deleteUbicacion(int id) {
        return ubicacionRepository.deleteUbicacion(id);
    }
}
