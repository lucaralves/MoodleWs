package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import pt.isep.projectjavaws.modelo.Avaliacao;
import pt.isep.projectjavaws.modelo.TipoAvaliacao;

import java.time.LocalDate;

@JsonPropertyOrder({"tipo", "dataAvaliacao", "nota", "observacao", "unidadeCurricular",
        "refAluno", "keyAvaliacao"})
@JacksonXmlRootElement(localName = "avaliacao")
public class AvaliacaoDTO {

    @JacksonXmlProperty(localName = "tipo")
    private TipoAvaliacao tipo;
    @JacksonXmlProperty(localName = "dataAvaliacao")
    private LocalDate dataAvaliacao;
    @JacksonXmlProperty(localName = "nota")
    private int nota;
    @JacksonXmlProperty(localName = "observacao")
    private String observacao;
    @JacksonXmlProperty(localName = "unidadeCurricular")
    private UnidadeCurricularDTO unidadeCurricular;
    @JacksonXmlProperty(localName = "refAluno")
    private Long refAluno;
    @JacksonXmlProperty(localName = "keyAvaliacao")
    private Integer keyAvaliacao;

    public AvaliacaoDTO() {
    }

    public AvaliacaoDTO(Avaliacao avaliacao) {
        this.dataAvaliacao = avaliacao.getDataAvaliacao();
        this.keyAvaliacao = avaliacao.getKeyAvaliacao();
        this.nota = avaliacao.getNota();
        this.observacao = avaliacao.getObservacao();
        this.refAluno = avaliacao.getRefAluno();
        this.tipo = avaliacao.getTipo();
        this.unidadeCurricular = Converter.convertUC(avaliacao.getUnidadeCurricular());
    }

    public AvaliacaoDTO(TipoAvaliacao tipo, LocalDate dataAvaliacao, int nota,
                        String observacao, UnidadeCurricularDTO unidadeCurricular,
                        Long refAluno, Integer keyAvaliacao) {
        this.tipo = tipo;
        this.dataAvaliacao = dataAvaliacao;
        this.nota = nota;
        this.observacao = observacao;
        this.unidadeCurricular = unidadeCurricular;
        this.refAluno = refAluno;
        this.keyAvaliacao = keyAvaliacao;
    }

    public TipoAvaliacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoAvaliacao tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDate dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public UnidadeCurricularDTO getUnidadeCurricular() {
        return unidadeCurricular;
    }

    public void setUnidadeCurricular(UnidadeCurricularDTO unidadeCurricular) {
        this.unidadeCurricular = unidadeCurricular;
    }

    public Long getRefAluno() {
        return refAluno;
    }

    public void setRefAluno(Long refAluno) {
        this.refAluno = refAluno;
    }

    public Integer getKeyAvaliacao() {
        return keyAvaliacao;
    }

    public void setKeyAvaliacao(Integer keyAvaliacao) {
        this.keyAvaliacao = keyAvaliacao;
    }
}
