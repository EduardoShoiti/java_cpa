package br.com.fiap.CPA.repository;

import br.com.fiap.CPA.model.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FazendaRepository extends JpaRepository<Fazenda, Long> {

    List<Fazenda> findByNomeFazendaContaining(String nomeFazenda);

}
