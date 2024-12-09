package com.eventia.serverback.services;

import com.eventia.serverback.models.Asiento;
import com.eventia.serverback.repositories.AsientoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AsientoService {
    private final AsientoRepository asientoRepository;

    public AsientoService(AsientoRepository asientoRepository) {
        this.asientoRepository = asientoRepository;
    }

    public ArrayList<Asiento> getAsientosByUbc(int ubc_id) {
        return asientoRepository.getAsientosByUbc(ubc_id);
    }

    public String addAsiento(Asiento asiento) {
        return asientoRepository.addAsiento(asiento);
    }

    public String editAsiento(Asiento asiento, String idNuevo) {
        return asientoRepository.editAsiento(asiento, idNuevo);
    }

    public String addAsientosDefault(int ubc_id, int numFilas, int numAsientosFila) {
        return asientoRepository.addAsientosDefault(ubc_id, numFilas, numAsientosFila);
    }

    public String deleteAsiento(Asiento asiento) {
        return asientoRepository.deleteAsiento(asiento);
    }


}
