package pt.isep.projectjavaws.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "erro")
public class ErroDTO {

    @JacksonXmlProperty(localName = "mensagem")
    private String mensagemErro;

    public ErroDTO(Exception e) {
        mensagemErro = e.getMessage();

    }

    public ErroDTO() {
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public void setMensagemErro(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }
}
