package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import pt.isep.projectjavaws.modelo.Regime;
import pt.isep.projectjavaws.modelo.UnidadeCurricular;

@JsonPropertyOrder({"nome", "ano", "regime", "creditos", "keyUC"})
@JacksonXmlRootElement(localName = "unidadeCurricular")
public class UnidadeCurricularDTO {

    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "ano")
    private int ano;
    @JacksonXmlProperty(localName = "regime")
    private Regime regime;
    @JacksonXmlProperty(localName = "creditos")
    private int creditos;
    @JacksonXmlProperty(localName = "keyUC")
    private Integer keyUC;

    public UnidadeCurricularDTO() {
    }

    public UnidadeCurricularDTO(UnidadeCurricular uc) {
        this.nome = uc.getNome();
        this.ano = uc.getAno();
        this.regime = uc.getRegime();
        this.creditos = uc.getCreditos();
        this.keyUC = uc.getKeyUC();
    }

    public UnidadeCurricularDTO(String nome, int ano, Regime regime,
                                int creditos, Integer keyUC) {
        this.nome = nome;
        this.ano = ano;
        this.regime = regime;
        this.creditos = creditos;
        this.keyUC = keyUC;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Regime getRegime() {
        return regime;
    }

    public void setRegime(Regime regime) {
        this.regime = regime;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Integer getKeyUC() {
        return keyUC;
    }

    public void setKeyUC(Integer keyUC) {
        this.keyUC = keyUC;
    }
}
