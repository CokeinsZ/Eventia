package com.eventia.serverback.controllers;

import com.eventia.serverback.models.Ubicacion;
import com.eventia.serverback.services.UbicacionService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/ubicaciones")
public class UbicacionController {
    private final UbicacionService ubicacionService;

    public UbicacionController(UbicacionService ubicacionService) {
        this.ubicacionService = ubicacionService;
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
    public ArrayList<Ubicacion> filtrarCiudad(@RequestParam Ubicacion ubicacion) {
        return ubicacionService.filtrarCiudad(ubicacion.getUbc_ciudad());
    }

    @PostMapping("/")
    public String addUbicacion(@RequestBody Ubicacion ubicacion) {
        return ubicacionService.addUbicacion(ubicacion);
    }

    @PutMapping("/{id}")
    public String updateUbicacion(@PathVariable int id, @RequestBody Ubicacion ubicacion) {
        return ubicacionService.updateUbicacion(id, ubicacion);
    }

    @DeleteMapping("/{id}")
    public String deleteUbicacion(@PathVariable int id) {
        return ubicacionService.deleteUbicacion(id);
    }
}
