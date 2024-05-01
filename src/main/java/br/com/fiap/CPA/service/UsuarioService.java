package br.com.fiap.CPA.service;

import br.com.fiap.CPA.controller.dto.UsuarioDTO;
import br.com.fiap.CPA.model.Usuario;
import br.com.fiap.CPA.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

//    Cadastrar Usuario
    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

//    Atualizar Usuario
    public Usuario atualizarUsuario(Long id, UsuarioDTO novoUsuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuarioAtualizado = usuarioExistente.get();

            usuarioAtualizado.setUsername(novoUsuario.getUsername());
            usuarioAtualizado.setEmail(novoUsuario.getEmail());
            usuarioAtualizado.setSenha(novoUsuario.getSenha());
            usuarioAtualizado.setFazendas(novoUsuario.getFazendas());
            usuarioAtualizado.setQuestoes(novoUsuario.getQuestoes());
            return usuarioRepository.save(usuarioAtualizado);
        } else {
            throw new RuntimeException("Usuário não encontrado com o ID: " + id);
        }
    }

//    Listar Usuarios
    public List<Usuario> listarUsuarios() { return usuarioRepository.findAll(); }

    public List<Usuario> listarUsuariosPorUsernameOuEmail(String username, String email) {
        return usuarioRepository.findByUsernameContainingOrEmailContaining(username, email);
    }

//    Deletar Usuario
    public void removerUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuário não encontrado com o ID: " + id);
        }
    }


}
