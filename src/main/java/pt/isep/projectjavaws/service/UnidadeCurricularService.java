package pt.isep.projectjavaws.service;

import pt.isep.projectjavaws.dados.Dados;
import pt.isep.projectjavaws.dto.*;
import pt.isep.projectjavaws.modelo.Aluno;
import pt.isep.projectjavaws.modelo.Avaliacao;
import pt.isep.projectjavaws.modelo.Instituicao;
import pt.isep.projectjavaws.modelo.UnidadeCurricular;

import java.util.ArrayList;
import java.util.Iterator;

public class UnidadeCurricularService {

    public static ListaUCsDTO getListaUCs() {
        Dados.lerEstado();

        Iterator<UnidadeCurricular> iterator = Instituicao.getListaUCs().values().iterator();
        ArrayList<UnidadeCurricular> listaUCs = new ArrayList<>();
        while (iterator.hasNext()) {
            listaUCs.add(iterator.next());
        }

        ArrayList<UnidadeCurricularDTO> listaUCsDTO = Converter.convertListaUCs(listaUCs);

        ListaUCsDTO listaUCsDTO1 = new ListaUCsDTO(listaUCsDTO);

        return listaUCsDTO1;
    }

    public static ListaUcPartialDTO getListaUcPartialDTO(Long numAluno) {
        Aluno aluno = Instituicao.getAlunoByNumAluno(numAluno);
        ArrayList<UnidadeCurricular> listaUcs;
        ArrayList<UnidadeCurricularDTO> listaUcsDTO;
        ArrayList<UnidadeCurricularPartialDTO> listaUcsPartialDTO;
        listaUcs = aluno.getUCsByInteger();
        listaUcsDTO = Converter.convertListaUCs(listaUcs);
        listaUcsPartialDTO = Converter.convertListaUcsDTO4ListaUcsPartialDTO(listaUcsDTO);
        ListaUcPartialDTO listaUcPartialDTO = new ListaUcPartialDTO(listaUcsPartialDTO);
        return listaUcPartialDTO;
    }
}
