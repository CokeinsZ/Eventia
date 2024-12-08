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

    public String getAsientoEstado(Asiento asiento) {
        return asientoRepository.getAsientoEstado(asiento);
    }

    public String addAsiento(Asiento asiento) {
        return asientoRepository.addAsiento(asiento);
    }

    public String updateAsiento(Asiento asiento) {
        return asientoRepository.updateAsiento(asiento);
    }

    public String deleteAsiento(Asiento asiento) {
        return asientoRepository.deleteAsiento(asiento);
    }


}
