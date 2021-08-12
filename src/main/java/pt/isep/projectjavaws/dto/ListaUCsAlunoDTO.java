package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JsonPropertyOrder({"aluno", "unidadesCurricularesDTO"})
@JacksonXmlRootElement(localName = "alunocadeiras")
public class ListaUCsAlunoDTO {

    @JacksonXmlProperty(localName = "aluno")
    AlunoDTO aluno;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "uc")
    ArrayList<UnidadeCurricularDTO> unidadesCurricularesDTO;

    public ListaUCsAlunoDTO() {
    }

    public ListaUCsAlunoDTO(AlunoDTO aluno, ArrayList<UnidadeCurricularDTO> unidadesCurricularesDTO) {
        this.aluno = aluno;
        this.unidadesCurricularesDTO = unidadesCurricularesDTO;
    }

    public AlunoDTO getNumAluno() {
        return aluno;
    }

    public void setNumAluno(AlunoDTO aluno) {
        this.aluno = aluno;
    }

    public ArrayList<UnidadeCurricularDTO> getUnidadesCurricularesDTO() {
        return unidadesCurricularesDTO;
    }

    public void setUnidadesCurricularesDTO(ArrayList<UnidadeCurricularDTO> unidadesCurricularesDTO) {
        this.unidadesCurricularesDTO = unidadesCurricularesDTO;
    }
}
