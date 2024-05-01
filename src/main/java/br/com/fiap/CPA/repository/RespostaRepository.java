package br.com.fiap.CPA.repository;

import br.com.fiap.CPA.model.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {

    List<Resposta> findByRespostaTextoContaining(String respostaTexto);

}
