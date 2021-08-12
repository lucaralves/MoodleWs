package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "cursos")
public class ListaCursosDTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "curso")
    private ArrayList<CursoDTO> listaCursos;

    public ListaCursosDTO() {
    }

    public ListaCursosDTO(ArrayList<CursoDTO> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public ArrayList<CursoDTO> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(ArrayList<CursoDTO> listaCursos) {
        this.listaCursos = listaCursos;
    }
}
