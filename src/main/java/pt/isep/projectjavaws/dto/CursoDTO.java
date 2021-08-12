package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import pt.isep.projectjavaws.modelo.Curso;


@JsonPropertyOrder({"nome", "codigo"})
@JacksonXmlRootElement(localName = "turma")
public class CursoDTO {

    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "codigo")
    private String codigo;

    public CursoDTO() {
    }

    public CursoDTO(Curso curso) {
        this.nome = curso.getNome();
        this.codigo = curso.getCodigo();
    }

    public CursoDTO(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
