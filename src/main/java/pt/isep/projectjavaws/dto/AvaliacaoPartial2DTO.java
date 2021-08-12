package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import pt.isep.projectjavaws.modelo.TipoAvaliacao;

import java.time.LocalDate;

@JsonPropertyOrder({"tipo", "dataAvaliacao", "observacao", "unidadeCurricular", "refAluno"})
@JacksonXmlRootElement(localName = "avaliacao")
public class AvaliacaoPartial2DTO {

    @JacksonXmlProperty(localName = "tipo")
    private String tipo;
    @JacksonXmlProperty(localName = "dataAvaliacao")
    private String dataAvaliacao;
    @JacksonXmlProperty(localName = "observacao")
    private String observacao;
    @JacksonXmlProperty(localName = "unidadeCurricular")
    private String unidadeCurricular;
    @JacksonXmlProperty(localName = "refAluno")
    private Long refAluno;

    public AvaliacaoPartial2DTO() {
    }

    public AvaliacaoPartial2DTO(AvaliacaoDTO avaliacaoDTO) {
        this.dataAvaliacao = avaliacaoDTO.getDataAvaliacao().toString();
        this.observacao = avaliacaoDTO.getObservacao();
        this.refAluno = avaliacaoDTO.getRefAluno();
        this.unidadeCurricular = avaliacaoDTO.getUnidadeCurricular().getNome();
        this.tipo = avaliacaoDTO.getTipo().toString();
    }

    public AvaliacaoPartial2DTO(TipoAvaliacao tipo, String dataAvaliacao,
                                String observacao, String unidadeCurricular, Long refAluno) {
        this.tipo = tipo.toString();
        this.dataAvaliacao = dataAvaliacao;
        this.observacao = observacao;
        this.unidadeCurricular = unidadeCurricular;
        this.refAluno = refAluno;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(String dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getUnidadeCurricular() {
        return unidadeCurricular;
    }

    public void setUnidadeCurricular(String unidadeCurricular) {
        this.unidadeCurricular = unidadeCurricular;
    }

    public Long getRefAluno() {
        return refAluno;
    }

    public void setRefAluno(Long refAluno) {
        this.refAluno = refAluno;
    }
}
