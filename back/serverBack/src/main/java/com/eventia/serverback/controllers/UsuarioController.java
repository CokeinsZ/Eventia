package com.eventia.serverback.controllers;

import com.eventia.serverback.models.LoginResponse;
import com.eventia.serverback.models.Usuario;
import com.eventia.serverback.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public Usuario getUsuarios(@PathVariable int id) {
        return this.usuarioService.getUsuario(id);
    }

    @GetMapping("/{correo}/correo")
    public Usuario getUsuarios(@PathVariable String correo) {
        return this.usuarioService.getUsuario(correo);
    }

    @PostMapping("/register")
    public String registerUsuario(@RequestBody Usuario usuario) {
        return this.usuarioService.registerUsuario(usuario);
    }

    @PostMapping("/login")
    public LoginResponse loginUsuario(@RequestBody Usuario usuario) {
        return this.usuarioService.loginUsuario(usuario);
    }

    @PutMapping("/{id}/info")
    public String updatePersonalInfo(@PathVariable int id, @RequestBody Usuario usuario) {
        return this.usuarioService.updatePersonalInfo(id, usuario);
    }

    @PatchMapping("/{id}/password")
    public String updatePassword(@PathVariable int id, @RequestBody Usuario usuario) {
        return this.usuarioService.updatePassword(id, usuario);
    }

    @PatchMapping("/{id}/rol")
    public String updateRol(@PathVariable int id, @RequestBody Usuario usuario) {
        return this.usuarioService.updateRol(id, usuario);
    }

    @PatchMapping("/{id}/delete")
    public String deleteUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        return this.usuarioService.deleteUsuario(id, usuario.getUsr_estado());
    }

    @GetMapping("/saldo")
    public float getSaldo(@RequestParam int id) {
        return this.usuarioService.getSaldo(id);
    }


}
