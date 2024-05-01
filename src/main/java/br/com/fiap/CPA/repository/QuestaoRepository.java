package br.com.fiap.CPA.repository;

import br.com.fiap.CPA.model.Fazenda;
import br.com.fiap.CPA.model.Questao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {

    List<Questao> findByQuestaoTextoContaining(String questaoTexto);

}
