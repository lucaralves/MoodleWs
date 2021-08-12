package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import pt.isep.projectjavaws.modelo.Aluno;

import java.util.HashMap;
import java.util.Map;

@JsonPropertyOrder({"nome", "codigo", "morada", "nif"})
@JacksonXmlRootElement(localName = "instituicao")
public class InstituicaoDTO {
    //Atributos de uma instituição.
    private Map<Long, Aluno> listaAlunos = new HashMap<>();
    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "codigo")
    private long codigo;
    @JacksonXmlProperty(localName = "morada")
    private String morada;
    @JacksonXmlProperty(localName = "nif")
    private long nif;

    public InstituicaoDTO() {
    }

    public InstituicaoDTO(String nome, long codigo, String morada,
                          long nif) {
        this.nome = nome;
        this.codigo = codigo;
        this.morada = morada;
        this.nif = nif;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public long getNif() {
        return nif;
    }

    public void setNif(long nif) {
        this.nif = nif;
    }

    public Map<Long, Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(Map<Long, Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }
}
