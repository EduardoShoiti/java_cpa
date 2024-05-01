package br.com.fiap.CPA.service;

import br.com.fiap.CPA.controller.dto.QuestaoDTO;
import br.com.fiap.CPA.controller.dto.UsuarioDTO;
import br.com.fiap.CPA.model.Questao;
import br.com.fiap.CPA.model.Usuario;
import br.com.fiap.CPA.repository.QuestaoRepository;
import br.com.fiap.CPA.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestaoService {
    @Autowired
    private QuestaoRepository questaoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    //    Cadastrar Questao
    public Questao cadastrarQuestao(Questao questao) {
        return questaoRepository.save(questao);
    }

//    public Questao cadastrarQuestao(QuestaoDTO questaoDTO) {
//        Optional<Usuario> usuario = usuarioRepository.findById(questaoDTO.getUserId());
//        if (!usuario.isPresent()) {
//            throw new RuntimeException("Usuário não encontrado com o ID: " + questaoDTO.getId());
//        }
//
//        Questao questao = new Questao();
//        questao.setQuestaoTexto(questaoDTO.getQuestaoTexto());
//        questao.setDataQuestao(questaoDTO.getDataQuestao());
//        questao.setUsuario(usuario.get());  // Associar o usuário encontrado à questão
//        return questaoRepository.save(questao);
//    }

    //    Atualizar Questao
    public Questao atualizarQuestao(Long id, QuestaoDTO novaQuestao) {
        Optional<Questao> questaoExistente = questaoRepository.findById(id);

        if (questaoExistente.isPresent()) {
            Questao questaoAtualizada = questaoExistente.get();

            questaoAtualizada.setQuestaoTexto(novaQuestao.getQuestaoTexto());
            questaoAtualizada.setDataQuestao(novaQuestao.getDataQuestao());
            questaoAtualizada.setUsuario(novaQuestao.getUsuario());
            return questaoRepository.save(questaoAtualizada);
        } else {
            throw new RuntimeException("Questão não encontrada com o ID: " + id);
        }
    }

    //    Listar Questões
    public List<Questao> listarQuestoes() { return questaoRepository.findAll(); }

    public List<Questao> listarQuestoesPorQuestaoTexto(String questaoTexto) {
        return questaoRepository.findByQuestaoTextoContaining(questaoTexto);
    }

    //    Deletar Questao
    public void removerQuestao(Long id) {
        if (questaoRepository.existsById(id)) {
            questaoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Questão não encontrada com o ID: " + id);
        }
    }

}
