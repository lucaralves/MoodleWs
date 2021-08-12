package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "turmas")
public class ListaTurmasDTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "turma")
    private ArrayList<TurmaDTO> listaTurmas;

    public ListaTurmasDTO() {
    }

    public ListaTurmasDTO(ArrayList<TurmaDTO> listaTurmas) {
        this.listaTurmas = listaTurmas;
    }

    public ArrayList<TurmaDTO> getListaCursos() {
        return listaTurmas;
    }

    public void setListaCursos(ArrayList<TurmaDTO> listaCursos) {
        this.listaTurmas = listaCursos;
    }
}
