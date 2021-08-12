package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "unidadescurriculares")
public class ListaUcPartialDTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    private ArrayList<UnidadeCurricularPartialDTO> ucs;

    public ListaUcPartialDTO(ArrayList<UnidadeCurricularPartialDTO> ucs) {
        this.ucs = ucs;
    }

    public ArrayList<UnidadeCurricularPartialDTO> getUcs() {
        return ucs;
    }

    public void setUcs(ArrayList<UnidadeCurricularPartialDTO> ucs) {
        this.ucs = ucs;
    }
}
