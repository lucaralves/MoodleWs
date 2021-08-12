package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "UCs")
public class ListaUCsDTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "UC")
    private ArrayList<UnidadeCurricularDTO> listaUCs;

    public ListaUCsDTO() {
    }

    public ListaUCsDTO(ArrayList<UnidadeCurricularDTO> listaUCs) {
        this.listaUCs = listaUCs;
    }

    public ArrayList<UnidadeCurricularDTO> getListaUCs() {
        return listaUCs;
    }

    public void setListaUCs(ArrayList<UnidadeCurricularDTO> listaUCs) {
        this.listaUCs = listaUCs;
    }
}
