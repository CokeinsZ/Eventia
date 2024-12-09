package com.eventia.serverback.services;

import com.eventia.serverback.models.Calificacion;
import com.eventia.serverback.repositories.CalificacionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CalificacionService {
    private final CalificacionRepository calificacionRepository;

    public CalificacionService(CalificacionRepository calificacionRepository) {
        this.calificacionRepository = calificacionRepository;
    }

    public Calificacion getCalificacion(int idEvento, int idUsuario) {
        return calificacionRepository.getCalificacion(idEvento, idUsuario);
    }

    public ArrayList<Calificacion> getCalificacionesEvento(int idEvento) {
        return calificacionRepository.getCalificacionesEvento(idEvento);
    }

    public ArrayList<Calificacion> getCalificacionesUsuario(int idUsuario) {
        return calificacionRepository.getCalificacionesUsuario(idUsuario);
    }

    public String addCalificacion(int idEvento, int idUsuario, Calificacion calificacion) {
        return calificacionRepository.addCalificacion(idEvento, idUsuario, calificacion);
    }

    public String updateCalificacion(int idEvento, int idUsuario, Calificacion calificacion) {
        return calificacionRepository.updateCalificacion(idEvento, idUsuario, calificacion);
    }

    public String deleteCalificacion(int idEvento, int idUsuario) {
        return calificacionRepository.deleteCalificacion(idEvento, idUsuario);
    }

    public double getPromedioCalificaciones(int idEvento) {
        return calificacionRepository.getPromedioCalificaciones(idEvento);
    }



}
