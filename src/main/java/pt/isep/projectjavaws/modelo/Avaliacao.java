package pt.isep.projectjavaws.modelo;

import pt.isep.projectjavaws.dto.AvaliacaoDTO;
import pt.isep.projectjavaws.dto.AvaliacaoPartial2DTO;
import pt.isep.projectjavaws.dto.Converter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Locale;

public class Avaliacao implements Serializable {
    //Atributos de uma avaliação.
    private TipoAvaliacao tipo;
    private LocalDate dataAvaliacao;
    private int nota;
    private String observacao;
    private UnidadeCurricular unidadeCurricular;
    private Long refAluno;
    private Integer keyAvaliacao;


    public Avaliacao(AvaliacaoPartial2DTO avaliacaoPartial2DTO, int keyAvaliacao, int keyUc) {
        this.unidadeCurricular = Instituicao.listaUCs.get(keyUc);
        this.keyAvaliacao = keyAvaliacao;
        this.dataAvaliacao = LocalDate.parse(avaliacaoPartial2DTO.getDataAvaliacao());
        this.observacao = avaliacaoPartial2DTO.getObservacao();
        this.refAluno = avaliacaoPartial2DTO.getRefAluno();
        this.tipo = Converter.tipoAvaliacaoToString(avaliacaoPartial2DTO.getTipo());
    }

    public Avaliacao(Integer keyAvaliacao, Long refAluno, String observacao, LocalDate dataAvaliacao) {
        this.keyAvaliacao = keyAvaliacao;
        this.refAluno = refAluno;
        this.observacao = observacao;
        this.dataAvaliacao = dataAvaliacao;
    }

    public Avaliacao(LocalDate dataAvaliacao, String observacao,
                     UnidadeCurricular unidadeCurricular,
                     Long refAluno, Integer keyAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
        this.observacao = observacao;
        this.unidadeCurricular = unidadeCurricular;
        this.refAluno = refAluno;
        this.keyAvaliacao = keyAvaliacao;
    }

    public Avaliacao(AvaliacaoDTO avaliacaoDTO) {
        this.dataAvaliacao = avaliacaoDTO.getDataAvaliacao();
        this.keyAvaliacao = avaliacaoDTO.getKeyAvaliacao();
        this.refAluno = avaliacaoDTO.getRefAluno();
        this.nota = avaliacaoDTO.getNota();
        this.observacao = avaliacaoDTO.getObservacao();
        this.tipo = avaliacaoDTO.getTipo();
        this.unidadeCurricular = Converter.convertUcDTO(avaliacaoDTO.getUnidadeCurricular());
    }

    public Long getRefAluno() {
        return refAluno;
    }

    public void setRefAluno(Long refAluno) {
        this.refAluno = refAluno;
    }

    public Integer getKeyAvaliacao() {
        return keyAvaliacao;
    }

    public void setKeyAvaliacao(Integer keyAvaliacao) {
        this.keyAvaliacao = keyAvaliacao;
    }

    public TipoAvaliacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoAvaliacao tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDate dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public UnidadeCurricular getUnidadeCurricular() {
        return unidadeCurricular;
    }

    public void setUnidadeCurricular(UnidadeCurricular unidadeCurricular) {
        this.unidadeCurricular = unidadeCurricular;
    }

    public static Avaliacao getAvaliacaoByKey(Integer keyAvaliacao, Aluno aluno) {
        Avaliacao avaliacao = aluno.getAvaliacoes().get(keyAvaliacao);

        return avaliacao;
    }

    public void alteraAvaliacao(AvaliacaoDTO avaliacaoDTO) {

        this.setTipo(avaliacaoDTO.getTipo());
        this.setNota(avaliacaoDTO.getNota());
        this.setDataAvaliacao(avaliacaoDTO.getDataAvaliacao());
        this.setKeyAvaliacao(avaliacaoDTO.getKeyAvaliacao());
        this.setObservacao(avaliacaoDTO.getObservacao());
        this.setRefAluno(avaliacaoDTO.getRefAluno());
        this.setUnidadeCurricular(Converter.convertUcDTO(avaliacaoDTO.getUnidadeCurricular()));
    }

    public void editAvaliacao(AvaliacaoPartial2DTO avaliacaoPartial2DTO) {

        this.setTipo(Converter.tipoAvaliacaoToString(avaliacaoPartial2DTO.getTipo()));
        this.setDataAvaliacao(LocalDate.parse(avaliacaoPartial2DTO.getDataAvaliacao()));
        this.setObservacao(avaliacaoPartial2DTO.getObservacao());

    }
}
