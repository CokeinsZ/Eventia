package com.eventia.serverback.controllers;

import com.eventia.serverback.models.Asiento;
import com.eventia.serverback.models.Ubicacion;
import com.eventia.serverback.services.AsientoService;
import com.eventia.serverback.services.UbicacionService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/ubicaciones")
public class UbicacionController {
    private final UbicacionService ubicacionService;
    private final AsientoService asientoService;

    public UbicacionController(UbicacionService ubicacionService, AsientoService asientoService) {
        this.ubicacionService = ubicacionService;
        this.asientoService = asientoService;
    }

    @GetMapping("/")
    public ArrayList<Ubicacion> getUbicaciones() {
        return ubicacionService.getUbicaciones();
    }

    @GetMapping("/{id}")
    public Ubicacion getUbicacionById(@PathVariable int id) {
        return ubicacionService.getUbicacionById(id);
    }

    @GetMapping("/filtrar")
    public ArrayList<Ubicacion> filtrarCiudad(@RequestBody Ubicacion ubicacion) {
        return ubicacionService.filtrarCiudad(ubicacion.getUbc_ciudad());
    }

    @PostMapping("/")
    public String addUbicacion(@RequestParam int numFilas, @RequestParam int numAsientosFila, @RequestBody Ubicacion ubicacion) {
        int ubcId = ubicacionService.addUbicacion(ubicacion);
        if (ubicacion.getUbc_capacidad() > 0 && ubcId != -1) {
            asientoService.addAsientosDefault(ubcId, numFilas, numAsientosFila);
            return "Ubicacion y asientos añadidos correctamente";

        } else if (ubcId != -1) {
            return "Ubicacion añadida correctamente";
        }

        return "Error al añadir la ubicacion";
    }

    @PutMapping("/{id}")
    public String updateUbicacion(@PathVariable int id, @RequestBody Ubicacion ubicacion) {
        return ubicacionService.updateUbicacion(id, ubicacion);
    }

    @DeleteMapping("/{id}")
    public String deleteUbicacion(@PathVariable int id) {
        return ubicacionService.deleteUbicacion(id);
    }

    // Endpoints para Asientos

    @GetMapping("/asientos/{id}")
    public ArrayList<Asiento> getAsientosByUbc(@PathVariable int id) {
        return asientoService.getAsientosByUbc(id);
    }

    @PostMapping("/asientos")
    public String addAsiento(@RequestBody Asiento asiento) {
        return asientoService.addAsiento(asiento);
    }

    @PutMapping("/asientos")
    public String editAsiento(@RequestBody Asiento asiento, @RequestParam String idNuevo) {
        return asientoService.editAsiento(asiento, idNuevo);
    }

    @DeleteMapping("/asientos")
    public String deleteAsiento(@RequestBody Asiento asiento) {
        return asientoService.deleteAsiento(asiento);
    }
}
