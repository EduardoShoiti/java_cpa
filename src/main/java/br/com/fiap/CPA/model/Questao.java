package br.com.fiap.CPA.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "questoes")
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String questaoTexto;
    private Date dataQuestao;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario usuario;

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
}
