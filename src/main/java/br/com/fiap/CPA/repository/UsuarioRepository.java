package br.com.fiap.CPA.repository;

import br.com.fiap.CPA.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByUsernameContainingOrEmailContaining(String username, String email);

}
