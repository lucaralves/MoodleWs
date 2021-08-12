package pt.isep.projectjavaws.modelo;

import java.io.Serializable;

public class Turma implements Serializable {
    //Atributos de uma turma.
    private int ano;
    private String ref;
    private Regime regime;
    private String keyTurma;

    public Turma(String keyTurma,int ano, String ref, Regime regime) {
        this.keyTurma = keyTurma;
        this.ano = ano;
        this.ref = ref;
        this.regime = regime;
    }

    public Turma(String keyTurma,int ano, String ref) {
        this.keyTurma = keyTurma;
        this.ano = ano;
        this.ref = ref;
    }

    public String getKeyTurma() {
        return keyTurma;
    }

    public void setKeyTurma(String keyTurma) {
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
}
