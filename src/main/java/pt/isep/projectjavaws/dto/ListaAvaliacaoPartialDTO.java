package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "avaliacoesgeral")
public class ListaAvaliacaoPartialDTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    private ArrayList<AvaliacaoPartialDTO> avaliacoes;

    public ListaAvaliacaoPartialDTO() {
    }

    public ListaAvaliacaoPartialDTO(ArrayList<AvaliacaoPartialDTO> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public ArrayList<AvaliacaoPartialDTO> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(ArrayList<AvaliacaoPartialDTO> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
