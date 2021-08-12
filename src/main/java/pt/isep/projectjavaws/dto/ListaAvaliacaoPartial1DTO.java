package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "avaliacoesuc")
public class ListaAvaliacaoPartial1DTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    private ArrayList<AvaliacaoPartial1DTO> avaliacoes;

    public ListaAvaliacaoPartial1DTO() {
    }

    public ListaAvaliacaoPartial1DTO(ArrayList<AvaliacaoPartial1DTO> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public ArrayList<AvaliacaoPartial1DTO> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(ArrayList<AvaliacaoPartial1DTO> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
