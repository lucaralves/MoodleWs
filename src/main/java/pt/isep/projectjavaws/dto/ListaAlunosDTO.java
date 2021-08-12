package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "alunos")
public class ListaAlunosDTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "aluno")
    private ArrayList<AlunoDTO> listaAlunos;

    public ListaAlunosDTO() {
    }

    public ListaAlunosDTO(ArrayList<AlunoDTO> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public ArrayList<AlunoDTO> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(ArrayList<AlunoDTO> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }
}
