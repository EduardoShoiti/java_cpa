package br.com.fiap.CPA.service;

import br.com.fiap.CPA.controller.dto.FazendaDTO;
import br.com.fiap.CPA.model.Fazenda;
import br.com.fiap.CPA.repository.FazendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FazendaService {

    @Autowired
    private FazendaRepository fazendaRepository;

    //    Cadastrar Fazenda
    public Fazenda cadastrarFazenda(Fazenda fazenda) {
        return fazendaRepository.save(fazenda);
    }

    //    Atualizar Fazenda
    public Fazenda atualizarFazenda(Long id, FazendaDTO novaFazenda) {
        Optional<Fazenda> fazendaExistente = fazendaRepository.findById(id);

        if (fazendaExistente.isPresent()) {
            Fazenda fazendaAtualizada = fazendaExistente.get();

            fazendaAtualizada.setNomeFazenda(novaFazenda.getNomeFazenda());
            fazendaAtualizada.setEndereco(novaFazenda.getEndereco());
            fazendaAtualizada.setUsuario(novaFazenda.getUsuario());
            return fazendaRepository.save(fazendaAtualizada);
        } else {
            throw new RuntimeException("Fazenda não encontrada com o ID: " + id);
        }
    }

    //    Listar Fazendas
    public List<Fazenda> listarFazendas() { return fazendaRepository.findAll(); }

    public List<Fazenda> listarFazendaPorNome(String nomeFazenda) {
        return fazendaRepository.findByNomeFazendaContaining(nomeFazenda);
    }

//    Deletar Fazenda
    public void removerFazenda(Long id) {
        if (fazendaRepository.existsById(id)) {
            fazendaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Fazenda não encontrada com o ID: " + id);
        }
    }

}
