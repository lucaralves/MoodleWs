package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import pt.isep.projectjavaws.modelo.TipoAvaliacao;

import java.time.LocalDate;

@JsonPropertyOrder({"tipoAvaliacao", "data"})
@JacksonXmlRootElement(localName = "avaliacoes1")
public class AvaliacaoPartial1DTO {

    @JacksonXmlProperty(localName = "tipoAvaliacao")
    TipoAvaliacao tipoAvaliacao;
    @JacksonXmlProperty(localName = "data")
    LocalDate data;
    @JacksonXmlProperty(localName = "keyAvaliacao")
    Integer keyAvaliacao;

    public AvaliacaoPartial1DTO() {
    }

    public AvaliacaoPartial1DTO(AvaliacaoDTO avaliacaoDTO) {
        this.data = avaliacaoDTO.getDataAvaliacao();
        this.tipoAvaliacao = avaliacaoDTO.getTipo();
        this.keyAvaliacao = avaliacaoDTO.getKeyAvaliacao();
    }

    public AvaliacaoPartial1DTO(TipoAvaliacao tipoAvaliacao, LocalDate data, Integer keyAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
        this.data = data;
        this.keyAvaliacao = keyAvaliacao;
    }

    public Integer getKeyAvaliacao() {
        return keyAvaliacao;
    }

    public void setKeyAvaliacao(Integer keyAvaliacao) {
        this.keyAvaliacao = keyAvaliacao;
    }

    public TipoAvaliacao getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
