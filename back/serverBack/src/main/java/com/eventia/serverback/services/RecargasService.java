package com.eventia.serverback.services;

import com.eventia.serverback.repositories.RecargasRepository;
import org.springframework.stereotype.Service;

@Service
public class RecargasService {
    private final RecargasRepository recargasRepository;

    public RecargasService(RecargasRepository recargasRepository) {
        this.recargasRepository = recargasRepository;
    }

    public String recargarSaldo(int id, float monto) {
        if (recargasRepository.recargarSaldo(id, monto))
            return recargasRepository.insertarRecarga(id, monto);

        return "Error al recargar saldo";
    }
}
