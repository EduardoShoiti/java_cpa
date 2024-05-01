package br.com.fiap.CPA.controller;

import br.com.fiap.CPA.controller.dto.UsuarioDTO;
import br.com.fiap.CPA.model.Resposta;
import br.com.fiap.CPA.model.Usuario;
import br.com.fiap.CPA.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO novoUsuario) {
        Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, novoUsuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuario() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/buscar")
    public List<Usuario> buscarUsuarios(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String email) {
        return usuarioService.listarUsuariosPorUsernameOuEmail(username, email);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerUsuario(@PathVariable Long id) {
        usuarioService.removerUsuario(id);
        return ResponseEntity.ok().build();
    }


}
