package br.com.fiap.CPA.service;

import br.com.fiap.CPA.controller.dto.QuestaoDTO;
import br.com.fiap.CPA.controller.dto.RespostaDTO;
import br.com.fiap.CPA.model.Questao;
import br.com.fiap.CPA.model.Resposta;
import br.com.fiap.CPA.repository.QuestaoRepository;
import br.com.fiap.CPA.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespostaService {
    @Autowired
    private RespostaRepository respostaRepository;

    //    Cadastrar Resposta
    public Resposta cadastrarResposta(Resposta resposta) {
        return respostaRepository.save(resposta);
    }

    //    Atualizar Resposta
    public Resposta atualizarResposta(Long id, RespostaDTO novaResposta) {
        Optional<Resposta> respostaExistente = respostaRepository.findById(id);

        if (respostaExistente.isPresent()) {
            Resposta respostaAtualizada = respostaExistente.get();

            respostaAtualizada.setRespostaTexto(novaResposta.getRespostaTexto());
            respostaAtualizada.setDataResposta(novaResposta.getDataResposta());
            respostaAtualizada.setQuestao(novaResposta.getQuestao());
            return respostaRepository.save(respostaAtualizada);
        } else {
            throw new RuntimeException("Resposta não encontrada com o ID: " + id);
        }
    }

    //    Listar Respostas
    public List<Resposta> listarRespostas() { return respostaRepository.findAll(); }

    public List<Resposta> listarRespostasPorRespostaTexto(String respostasTexto) {
        return respostaRepository.findByRespostaTextoContaining(respostasTexto);
    }

    //    Deletar Resposta
    public void removerResposta(Long id) {
        if (respostaRepository.existsById(id)) {
            respostaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Resposta não encontrada com o ID: " + id);
        }
    }

}
