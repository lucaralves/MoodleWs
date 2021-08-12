package pt.isep.projectjavaws.dados;

import pt.isep.projectjavaws.modelo.*;

import java.io.Serializable;
import java.util.Map;

public class Data implements Serializable {

    private Map<Long, Aluno> listaAlunos;
    private Map<String, Curso> listaCursos;
    private Map<String, Turma> listaTurmas;
    private Map<Integer, UnidadeCurricular> listaUCs;

    public Data() {
        this.listaAlunos = Instituicao.listaAlunos;
        this.listaCursos = Instituicao.listaCursos;
        this.listaTurmas = Instituicao.listaTurmas;
        this.listaUCs = Instituicao.listaUCs;
    }

    public Map<Long, Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(Map<Long, Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public Map<String, Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(Map<String, Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public Map<String, Turma> getListaTurmas() {
        return listaTurmas;
    }

    public void setListaTurmas(Map<String, Turma> listaTurmas) {
        this.listaTurmas = listaTurmas;
    }

    public Map<Integer, UnidadeCurricular> getListaUCs() {
        return listaUCs;
    }

    public void setListaUCs(Map<Integer, UnidadeCurricular> listaUCs) {
        this.listaUCs = listaUCs;
    }
}
