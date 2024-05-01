package br.com.fiap.CPA.controller;

import br.com.fiap.CPA.controller.dto.FazendaDTO;
import br.com.fiap.CPA.controller.dto.UsuarioDTO;
import br.com.fiap.CPA.model.Fazenda;
import br.com.fiap.CPA.model.Usuario;
import br.com.fiap.CPA.service.FazendaService;
import br.com.fiap.CPA.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fazenda")
public class FazendaController {
    private final FazendaService fazendaService;

    @Autowired
    public FazendaController(FazendaService fazendaService) {
        this.fazendaService = fazendaService;
    }

    @PostMapping
    public ResponseEntity<Fazenda> cadastrarFazenda(@RequestBody Fazenda fazenda) {
        Fazenda novaFazenda = fazendaService.cadastrarFazenda(fazenda);
        return ResponseEntity.ok(novaFazenda);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Fazenda> atualizarFazenda(@PathVariable Long id, @RequestBody FazendaDTO novaFazenda) {
        Fazenda fazendaAtualizada = fazendaService.atualizarFazenda(id, novaFazenda);
        return ResponseEntity.ok(fazendaAtualizada);
    }

    @GetMapping
    public ResponseEntity<List<Fazenda>> listarFazenda() {
        List<Fazenda> fazendas = fazendaService.listarFazendas();
        return ResponseEntity.ok(fazendas);
    }

    @GetMapping("/buscar")
    public List<Fazenda> buscarFazendas(@RequestParam(required = false) String nomeFazenda) {
        return fazendaService.listarFazendaPorNome(nomeFazenda);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerFazenda(@PathVariable Long id) {
        fazendaService.removerFazenda(id);
        return ResponseEntity.ok().build();
    }

}
