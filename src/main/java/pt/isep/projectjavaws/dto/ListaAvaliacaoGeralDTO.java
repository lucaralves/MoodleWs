package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "avaliacoesGeral")
public class ListaAvaliacaoGeralDTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "listaAvaliacao")
    ArrayList<ListaAvaliacaoDTO> avaliacoesalunos = new ArrayList<>();

    public ListaAvaliacaoGeralDTO() {
    }

    public ListaAvaliacaoGeralDTO(ArrayList<ListaAvaliacaoDTO> avaliacoesalunos) {
        this.avaliacoesalunos = avaliacoesalunos;
    }

    public ArrayList<ListaAvaliacaoDTO> getAvaliacoesalunos() {
        return avaliacoesalunos;
    }

    public void setAvaliacoesalunos(ArrayList<ListaAvaliacaoDTO> avaliacoesalunos) {
        this.avaliacoesalunos = avaliacoesalunos;
    }
}
