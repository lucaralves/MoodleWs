package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "alunoscadeiras")
public class ListaUcsAlunoGeralDTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "alunocadeiras")
    ArrayList<ListaUCsAlunoDTO> listaUCsAlunosDTO = new ArrayList<>();

    public ListaUcsAlunoGeralDTO() {
    }

    public ListaUcsAlunoGeralDTO(ArrayList<ListaUCsAlunoDTO> listaUCsAlunoDTOs) {
        this.listaUCsAlunosDTO = listaUCsAlunoDTOs;
    }

    public ArrayList<ListaUCsAlunoDTO> getListaUCsAlunosDTO() {
        return listaUCsAlunosDTO;
    }

    public void setListaUCsAlunosDTO(ArrayList<ListaUCsAlunoDTO> listaUCsAlunoDTOs) {
        this.listaUCsAlunosDTO = listaUCsAlunoDTOs;
    }
}
