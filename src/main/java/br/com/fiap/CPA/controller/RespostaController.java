package br.com.fiap.CPA.controller;

import br.com.fiap.CPA.controller.dto.QuestaoDTO;
import br.com.fiap.CPA.controller.dto.RespostaDTO;
import br.com.fiap.CPA.model.Questao;
import br.com.fiap.CPA.model.Resposta;
import br.com.fiap.CPA.service.QuestaoService;
import br.com.fiap.CPA.service.RespostaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resposta")
public class RespostaController {
    private final RespostaService respostaService;

    @Autowired
    public RespostaController(RespostaService respostaService) {
        this.respostaService = respostaService;
    }

    @PostMapping
    public ResponseEntity<Resposta> cadastrarResposta(@RequestBody Resposta resposta) {
        Resposta novaResposta = respostaService.cadastrarResposta(resposta);
        return ResponseEntity.ok(novaResposta);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Resposta> atualizarResposta(@PathVariable Long id, @RequestBody RespostaDTO novaResposta) {
        Resposta respostaAtualizada = respostaService.atualizarResposta(id, novaResposta);
        return ResponseEntity.ok(respostaAtualizada);
    }

    @GetMapping
    public ResponseEntity<List<Resposta>> listarResposta() {
        List<Resposta> respostas = respostaService.listarRespostas();
        return ResponseEntity.ok(respostas);
    }

    @GetMapping("/buscar")
    public List<Resposta> buscarRespostas(@RequestParam(required = false) String respostaTexto) {
        return respostaService.listarRespostasPorRespostaTexto(respostaTexto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerResposta(@PathVariable Long id) {
        respostaService.removerResposta(id);
        return ResponseEntity.ok().build();
    }

}
