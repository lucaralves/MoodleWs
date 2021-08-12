package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "avaliacoes")
public class ListaAvaliacaoDTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "avaliacoes")
    ArrayList<AvaliacaoDTO> avaliacoes = new ArrayList<>();

    public ListaAvaliacaoDTO() {
    }

    public ListaAvaliacaoDTO(ArrayList<AvaliacaoDTO> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }


    public ArrayList<AvaliacaoDTO> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(ArrayList<AvaliacaoDTO> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
