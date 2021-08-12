package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import pt.isep.projectjavaws.modelo.Aluno;

@JsonPropertyOrder({"numAluno", "senha"})
@JacksonXmlRootElement(localName = "alunopartial")
public class AlunoPartialDTO {

    @JacksonXmlProperty(localName = "numAluno")
    private Long numAluno;
    @JacksonXmlProperty(localName = "senha")
    private long senha;

    public AlunoPartialDTO(Aluno aluno) {
        this.numAluno = aluno.getNumeroAluno();
        this.senha = aluno.getSenha();
    }

    public AlunoPartialDTO(Long numeroAluno, long senha) {
        this.numAluno = numeroAluno;
        this.senha = senha;
    }

    public Long getNumeroAluno() {
        return numAluno;
    }

    public void setNumeroAluno(Long numeroAluno) {
        this.numAluno = numeroAluno;
    }

    public long getSenha() {
        return senha;
    }

    public void setSenha(long senha) {
        this.senha = senha;
    }
}
