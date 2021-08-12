package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import pt.isep.projectjavaws.modelo.TipoAvaliacao;

@JsonPropertyOrder({"tipoAvaliacao", "unidadeCurricular", "keyAvaliacao"})
@JacksonXmlRootElement(localName = "unidadecurricularpartial")
public class AvaliacaoPartialDTO {

    @JacksonXmlProperty(localName = "tipoAvaliacao")
    TipoAvaliacao tipoAvaliacao;
    @JacksonXmlProperty(localName = "unidadeCurricular")
    String unidadeCurricular;
    @JacksonXmlProperty(localName = "keyAvaliacao")
    Integer keyAvaliacao;

    public AvaliacaoPartialDTO(AvaliacaoDTO avaliacaoDTO) {
        this.tipoAvaliacao = avaliacaoDTO.getTipo();
        this.unidadeCurricular = avaliacaoDTO.getUnidadeCurricular().getNome();
        this.keyAvaliacao = avaliacaoDTO.getKeyAvaliacao();
    }

    public AvaliacaoPartialDTO(TipoAvaliacao tipoAvaliacao, String unidadeCurricular, Integer keyAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
        this.unidadeCurricular = unidadeCurricular;
        this.keyAvaliacao = keyAvaliacao;
    }

    public TipoAvaliacao getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
    }

    public String getUnidadeCurricular() {
        return unidadeCurricular;
    }

    public void setUnidadeCurricular(String unidadeCurricular) {
        this.unidadeCurricular = unidadeCurricular;
    }

    public Integer getKeyAvaliacao() {
        return keyAvaliacao;
    }

    public void setKeyAvaliacao(Integer keyAvaliacao) {
        this.keyAvaliacao = keyAvaliacao;
    }
}
