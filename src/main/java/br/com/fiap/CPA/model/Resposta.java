package br.com.fiap.CPA.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "respostas")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String respostaTexto;
    private Date dataResposta;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Questao questao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRespostaTexto() {
        return respostaTexto;
    }

    public void setRespostaTexto(String respostaTexto) {
        this.respostaTexto = respostaTexto;
    }

    public Date getDataResposta() {
        return dataResposta;
    }

    public void setDataResposta(Date dataResposta) {
        this.dataResposta = dataResposta;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }
}
