package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import pt.isep.projectjavaws.modelo.*;

import java.time.LocalDate;
import java.util.ArrayList;

@JsonPropertyOrder({"nome", "cc", "numeroAluno", "sexo", "nascimento",
"curso", "turma", "regiao", "senha", "frequentar", "avaliacao"})
@JacksonXmlRootElement(localName = "aluno")
public class AlunoDTO {

    @JacksonXmlProperty(localName = "cc")
    private long cc;
    @JacksonXmlProperty(localName = "numAluno")
    private Long numeroAluno;
    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "senha")
    private long senha;
    @JacksonXmlProperty(localName = "curso")
    private CursoDTO curso;
    @JacksonXmlProperty(localName = "turma")
    private TurmaDTO turma;
    @JacksonXmlProperty(localName = "nascimento")
    private LocalDate nascimento;
    @JacksonXmlProperty(localName = "sexo")
    private char sexo;
    @JacksonXmlProperty(localName = "regiao")
    private Regiao regiao;
    @JacksonXmlProperty(localName = "avaliacao")
    private ArrayList<AvaliacaoDTO> avaliacoes;
    @JacksonXmlElementWrapper(useWrapping = true)
    @JacksonXmlProperty(localName = "ucs")
    private ArrayList<Integer> frequentar;

    public AlunoDTO() {
    }

    public AlunoDTO(Aluno aluno) {
        this.cc = aluno.getCc();
        this.curso = Converter.convertCurso(aluno.getCurso());
        this.numeroAluno = aluno.getNumeroAluno();
        this.frequentar = aluno.getFrequentar();
        this.nascimento = aluno.getNascimento();
        this.nome = aluno.getNome();
        this.regiao = aluno.getRegiao();
        this.senha = aluno.getSenha();
        this.sexo = aluno.getSexo();
        this.turma = Converter.convertTurma(aluno.getTurma());
        this.avaliacoes = Converter.convertListaAvaliacoes(aluno.getArrayListAvaliacoes());
    }

    public AlunoDTO(long cc, Long numeroAluno, String nome, long senha, CursoDTO curso,
                    Turma turmaDTO, LocalDate nascimento, char sexo, Regiao regiao,
                    ArrayList<AvaliacaoDTO> avaliacoes, ArrayList<Integer> frequentar) {
        this.cc = cc;
        this.numeroAluno = numeroAluno;
        this.nome = nome;
        this.senha = senha;
        this.curso = curso;
        this.turma = turma;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.regiao = regiao;
        this.avaliacoes = avaliacoes;
        this.frequentar = frequentar;
    }

    public long getCc() {
        return cc;
    }

    public void setCc(long cc) {
        this.cc = cc;
    }

    public Long getNumeroAluno() {
        return numeroAluno;
    }

    public void setNumeroAluno(Long numeroAluno) {
        this.numeroAluno = numeroAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getSenha() {
        return senha;
    }

    public void setSenha(long senha) {
        this.senha = senha;
    }

    public CursoDTO getCurso() {
        return curso;
    }

    public void setCurso(CursoDTO curso) {
        this.curso = curso;
    }

    public TurmaDTO getTurma() {
        return turma;
    }

    public void setTurma(TurmaDTO turma) {
        this.turma = turma;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public ArrayList<AvaliacaoDTO> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(ArrayList<AvaliacaoDTO> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public ArrayList<Integer> getFrequentar() {
        return frequentar;
    }

    public void setFrequentar(ArrayList<Integer> frequentar) {
        this.frequentar = frequentar;
    }
}
