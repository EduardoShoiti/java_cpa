package br.com.fiap.CPA.controller;

import br.com.fiap.CPA.controller.dto.QuestaoDTO;
import br.com.fiap.CPA.controller.dto.UsuarioDTO;
import br.com.fiap.CPA.model.Questao;
import br.com.fiap.CPA.model.Usuario;
import br.com.fiap.CPA.service.QuestaoService;
import br.com.fiap.CPA.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questao")
public class QuestaoController {
    private final QuestaoService questaoService;
    private UsuarioService usuarioService;

    @Autowired
    public QuestaoController(QuestaoService questaoService) {
        this.questaoService = questaoService;
    }

    @PostMapping
    public ResponseEntity<Questao> cadastrarQuestao(@RequestBody Questao questao) {
        Questao novaQuestao = questaoService.cadastrarQuestao(questao);
        return ResponseEntity.ok(novaQuestao);
    }

//    @PostMapping
//    public ResponseEntity<?> cadastrarQuestao(@RequestBody QuestaoDTO questaoDTO) {
//        try {
//            Questao novaQuestao = questaoService.cadastrarQuestao(questaoDTO);
//            return ResponseEntity.ok(novaQuestao);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
//    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Questao> atualizarQuestao(@PathVariable Long id, @RequestBody QuestaoDTO novaQuestao) {
        Questao questaoAtualizada = questaoService.atualizarQuestao(id, novaQuestao);
        return ResponseEntity.ok(questaoAtualizada);
    }

    @GetMapping
    public ResponseEntity<List<Questao>> listarQuestao() {
        List<Questao> questoes = questaoService.listarQuestoes();
        return ResponseEntity.ok(questoes);
    }

    @GetMapping("/buscar")
    public List<Questao> buscarQuestoes(@RequestParam(required = false) String questaoTexto) {
        return questaoService.listarQuestoesPorQuestaoTexto(questaoTexto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerQuestao(@PathVariable Long id) {
        questaoService.removerQuestao(id);
        return ResponseEntity.ok().build();
    }


}
