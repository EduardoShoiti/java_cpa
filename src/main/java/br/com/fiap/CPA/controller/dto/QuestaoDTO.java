package br.com.fiap.CPA.controller.dto;

import br.com.fiap.CPA.model.Usuario;
import lombok.Data;

import java.util.Date;

@Data
public class QuestaoDTO {
    private Long id;
    private String questaoTexto;
    private Date dataQuestao;
    private Usuario usuario;

    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestaoTexto() {
        return questaoTexto;
    }

    public void setQuestaoTexto(String questaoTexto) {
        this.questaoTexto = questaoTexto;
    }

    public Date getDataQuestao() {
        return dataQuestao;
    }

    public void setDataQuestao(Date dataQuestao) {
        this.dataQuestao = dataQuestao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
