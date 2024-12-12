package com.eventia.serverback.services;

import com.eventia.serverback.models.LoginResponse;
import com.eventia.serverback.models.Usuario;
import com.eventia.serverback.repositories.UsuarioRepository;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario getUsuario(int id) {
        return this.usuarioRepository.getUsuario(id);
    }

    public Usuario getUsuario(String correo) {
        return this.usuarioRepository.getUsuario(correo);
    }

    public String registerUsuario(Usuario usuario) {
        return this.usuarioRepository.registerUsuario(usuario);
    }

    public LoginResponse loginUsuario(Usuario usuario) {
        return this.usuarioRepository.loginUsuario(usuario);
    }

    public Claims validateToken(String token) {
        return this.usuarioRepository.validateToken(token);
    }

    public String updatePersonalInfo(int id, Usuario usuario) {
        return this.usuarioRepository.updatePersonalInfo(id, usuario);
    }

    public String updatePassword(int id, Usuario usuario) {
        return this.usuarioRepository.updatePassword(id, usuario);
    }

    public String updateRol(int id, Usuario usuario) {
        return this.usuarioRepository.updateRol(id, usuario);
    }

    public String deleteUsuario(int id, String estado) {
        return this.usuarioRepository.deleteUsuario(id, estado);
    }

    public float getSaldo(int id) {
        return this.usuarioRepository.getSaldo(id);
    }

    public float updateSaldo(int usuarioId, float nuevoSaldo) {
        return this.usuarioRepository.updateSaldo(usuarioId, nuevoSaldo);
    }

    public float retirarSaldo(int usuarioId, float monto) {
        float saldoActual = getSaldo(usuarioId);
        if (saldoActual >= monto) {
            return updateSaldo(usuarioId, saldoActual - monto);
        } else {
            return -1;
        }
    }
}
