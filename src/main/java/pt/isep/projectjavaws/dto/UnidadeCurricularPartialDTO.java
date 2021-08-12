package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"nome", "keyUnidadeCurricular"})
@JacksonXmlRootElement(localName = "unidadecurricularpartial")
public class UnidadeCurricularPartialDTO {

    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "keyUnidadeCurricular")
    private Integer keyUnidadeCurricular;

    public UnidadeCurricularPartialDTO() {
    }

    public UnidadeCurricularPartialDTO(UnidadeCurricularDTO unidadeCurricularDTO) {
        this.nome = unidadeCurricularDTO.getNome();
        this.keyUnidadeCurricular = unidadeCurricularDTO.getKeyUC();
    }

    public UnidadeCurricularPartialDTO(String nome, Integer keyUnidadeCurricular) {
        this.nome = nome;
        this.keyUnidadeCurricular = keyUnidadeCurricular;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getKeyUnidadeCurricular() {
        return keyUnidadeCurricular;
    }

    public void setKeyUnidadeCurricular(Integer keyUnidadeCurricular) {
        this.keyUnidadeCurricular = keyUnidadeCurricular;
    }
}
