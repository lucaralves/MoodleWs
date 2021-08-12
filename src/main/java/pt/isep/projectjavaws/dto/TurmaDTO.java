package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import pt.isep.projectjavaws.modelo.Regime;
import pt.isep.projectjavaws.modelo.Turma;

@JsonPropertyOrder({"keyTurma", "ano", "ref", "regime"})
@JacksonXmlRootElement(localName = "turma")
public class TurmaDTO {

    @JacksonXmlProperty(localName = "ano")
    private int ano;
    @JacksonXmlProperty(localName = "ref")
    private String ref;
    @JacksonXmlProperty(localName = "regime")
    private Regime regime;
    @JacksonXmlProperty(localName = "keyTurma")
    private String keyTurma;

    public TurmaDTO() {
    }

    public TurmaDTO(Turma turma) {
        this.ano = turma.getAno();
        this.ref = turma.getRef();
        this.regime = turma.getRegime();
        this.keyTurma = turma.getKeyTurma();
    }

    public TurmaDTO(int ano, String ref, Regime regime, String keyTurma) {
        this.ano = ano;
        this.ref = ref;
        this.regime = regime;
        this.keyTurma = keyTurma;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Regime getRegime() {
        return regime;
    }

    public void setRegime(Regime regime) {
        this.regime = regime;
    }

    public String getKeyTurma() {
        return keyTurma;
    }

    public void setKeyTurma(String keyTurma) {
        this.keyTurma = keyTurma;
    }
}
