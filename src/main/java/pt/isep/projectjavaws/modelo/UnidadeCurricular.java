package pt.isep.projectjavaws.modelo;

import pt.isep.projectjavaws.dto.UnidadeCurricularDTO;

import java.io.Serializable;

public class UnidadeCurricular implements Serializable {
    //Atributos de uma unidade curricular.
    private String nome;
    private int ano;
    private Regime regime;
    private int creditos;
    private Integer keyUC;

    public UnidadeCurricular(String nome, int ano, Regime regime, int creditos) {
        this.nome = nome;
        this.ano = ano;
        this.regime = regime;
        this.creditos = creditos;
    }

    public UnidadeCurricular(String nome, int ano, int creditos, Integer keyUC) {
        this.nome = nome;
        this.ano = ano;
        this.creditos = creditos;
        this.keyUC = keyUC;
    }

    public UnidadeCurricular(UnidadeCurricularDTO unidadeCurricularDTO) {
        this.ano = unidadeCurricularDTO.getAno();
        this.creditos = unidadeCurricularDTO.getCreditos();
        this.nome = unidadeCurricularDTO.getNome();
        this.keyUC = unidadeCurricularDTO.getKeyUC();
        this.regime = unidadeCurricularDTO.getRegime();
    }

    public  Integer getKeyUC() {
        return keyUC;
    }

    public void setKeyUC(Integer keyUC) {
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

}
