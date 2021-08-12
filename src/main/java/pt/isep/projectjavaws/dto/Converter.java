package pt.isep.projectjavaws.dto;

import pt.isep.projectjavaws.modelo.*;

import java.util.ArrayList;

public class Converter {

    public static ArrayList<CursoDTO> convertListaCursos(ArrayList<Curso> listaCursos) {
        Curso cursoAux;
        ArrayList<CursoDTO> listaCursosDTO = new ArrayList<>();

        for (int i = 0; i < listaCursos.size(); i++) {
            cursoAux = listaCursos.get(i);
            CursoDTO cursoDTO = new CursoDTO(cursoAux);
            listaCursosDTO.add(cursoDTO);
        }

        return listaCursosDTO;
    }

    public static ArrayList<TurmaDTO> convertListaTurmas(ArrayList<Turma> listaTurmas) {
        Turma turmaAux;
        ArrayList<TurmaDTO> listaTurmasDTO = new ArrayList<>();

        for (int i = 0; i < listaTurmas.size(); i++) {
            turmaAux = listaTurmas.get(i);
            TurmaDTO turmaDTO = new TurmaDTO(turmaAux);
            listaTurmasDTO.add(turmaDTO);
        }

        return listaTurmasDTO;
    }

    public static ArrayList<UnidadeCurricularDTO> convertListaUCs(ArrayList<UnidadeCurricular> listaUCs) {
        UnidadeCurricular ucAux;
        ArrayList<UnidadeCurricularDTO> listaUCsDTO = new ArrayList<>();

        for (int i = 0; i < listaUCs.size(); i++) {
            ucAux = listaUCs.get(i);
            UnidadeCurricularDTO ucDTO = new UnidadeCurricularDTO(ucAux);
            listaUCsDTO.add(ucDTO);
        }

        return listaUCsDTO;
    }

    public static ArrayList<UnidadeCurricularPartialDTO> convertListaUcsDTO4ListaUcsPartialDTO(ArrayList<UnidadeCurricularDTO> ucsDTO) {
        ArrayList<UnidadeCurricularPartialDTO> ucsPartialDTO = new ArrayList<>();

        for (int i = 0; i < ucsDTO.size(); i++) {
            UnidadeCurricularPartialDTO ucPartialDTO = Converter.convertUcDTO4UcPartialDTO(ucsDTO.get(i));
            ucsPartialDTO.add(ucPartialDTO);
        }

        return ucsPartialDTO;
    }

    public static ArrayList<AlunoDTO> convertListaAlunos(ArrayList<Aluno> listaAlunos) {
        Aluno alunoAux;
        ArrayList<AlunoDTO> listaAlunosDTO = new ArrayList<>();

        for (int i = 0; i < listaAlunos.size(); i++) {
            alunoAux = listaAlunos.get(i);
            AlunoDTO alunoDTO = new AlunoDTO(alunoAux);
            listaAlunosDTO.add(alunoDTO);
        }

        return listaAlunosDTO;
    }

    public static ArrayList<AvaliacaoDTO> convertListaAvaliacoes(ArrayList<Avaliacao> listaAvaliacoes) {
        Avaliacao avaliacaoAux;
        ArrayList<AvaliacaoDTO> listaAvaliacoesDTO = new ArrayList<>();

        for (int i = 0; i < listaAvaliacoes.size(); i++) {
            avaliacaoAux = listaAvaliacoes.get(i);
            AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO(avaliacaoAux);
            listaAvaliacoesDTO.add(avaliacaoDTO);
        }

        return listaAvaliacoesDTO;
    }

    public static ArrayList<AvaliacaoPartialDTO> convertListaAvaliacoesDTO4ListaAvaliacoesPartialDTO(ArrayList<AvaliacaoDTO> avaliacoesDTO) {
        ArrayList<AvaliacaoPartialDTO> avaliacoesPartialDTO = new ArrayList<>();

        for (int i = 0; i < avaliacoesDTO.size(); i++) {
            AvaliacaoPartialDTO avaliacaoPartialDTO = Converter.convertAvaliacaoDTO4AvaliacaoPartialDTO(avaliacoesDTO.get(i));
            avaliacoesPartialDTO.add(avaliacaoPartialDTO);
        }

        return avaliacoesPartialDTO;
    }

    public static ArrayList<AvaliacaoPartial1DTO> convertListaAvaliacoesDTO4ListaAvaliacoesPartial1DTO(ArrayList<AvaliacaoDTO> avaliacoesDTO) {
        ArrayList<AvaliacaoPartial1DTO> avaliacoesPartialDTO = new ArrayList<>();

        for (int i = 0; i < avaliacoesDTO.size(); i++) {
            AvaliacaoPartial1DTO avaliacaoPartial1DTO = Converter.convertAvaliacaoDTO4AvaliacaoPartial1DTO(avaliacoesDTO.get(i));
            avaliacoesPartialDTO.add(avaliacaoPartial1DTO);
        }

        return avaliacoesPartialDTO;
    }

    public static CursoDTO convertCurso(Curso curso) {
        CursoDTO cursoDTO = new CursoDTO(curso);

        return cursoDTO;
    }

    public static TurmaDTO convertTurma(Turma turma) {
        TurmaDTO turmaDTO = new TurmaDTO(turma);

        return turmaDTO;
    }

    public static UnidadeCurricularDTO convertUC(UnidadeCurricular uc) {
        UnidadeCurricularDTO unidadeCurricularDTO = new UnidadeCurricularDTO(uc);

        return unidadeCurricularDTO;
    }

    public static AlunoDTO convertAluno(Aluno aluno) {
        AlunoDTO alunoDTO = new AlunoDTO(aluno);

        return alunoDTO;
    }

    public static AlunoPartialDTO convertAluno4AlunoPartialDTO(Aluno aluno) {
        AlunoPartialDTO alunoDTO = new AlunoPartialDTO(aluno);

        return alunoDTO;
    }

    public static AvaliacaoDTO convertAvaliacao(Avaliacao avaliacao) {
        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO(avaliacao);

        return avaliacaoDTO;
    }

    public static Avaliacao convertAvaliacaoDTO(AvaliacaoDTO avaliacaoDTO) {
        Avaliacao avaliacao = new Avaliacao(avaliacaoDTO);

        return avaliacao;
    }

    public static AvaliacaoPartialDTO convertAvaliacaoDTO4AvaliacaoPartialDTO(AvaliacaoDTO avaliacaoDTO) {
        AvaliacaoPartialDTO avaliacaoPartialDTO = new AvaliacaoPartialDTO(avaliacaoDTO);

        return avaliacaoPartialDTO;
    }

    public static AvaliacaoPartial1DTO convertAvaliacaoDTO4AvaliacaoPartial1DTO(AvaliacaoDTO avaliacaoDTO) {
        AvaliacaoPartial1DTO avaliacaoPartial1DTO = new AvaliacaoPartial1DTO(avaliacaoDTO);

        return avaliacaoPartial1DTO;
    }

    public static UnidadeCurricular convertUcDTO(UnidadeCurricularDTO unidadeCurricularDTO) {
        UnidadeCurricular unidadeCurricular = new UnidadeCurricular(unidadeCurricularDTO);

        return unidadeCurricular;
    }

    public static UnidadeCurricularPartialDTO convertUcDTO4UcPartialDTO(UnidadeCurricularDTO ucDTO) {
        UnidadeCurricularPartialDTO ucPartialDTO = new UnidadeCurricularPartialDTO(ucDTO);

        return ucPartialDTO;
    }

    public static TipoAvaliacao tipoAvaliacaoToString(String tipoAvaliacao) {

        if (tipoAvaliacao.equals("EXAME"))
            return TipoAvaliacao.EXAME;
        if (tipoAvaliacao.equals("FREQUENCIA"))
            return TipoAvaliacao.FREQUENCIA;
        if (tipoAvaliacao.equals("PROJETO"))
            return TipoAvaliacao.PROJETO;
        if (tipoAvaliacao.equals("TRABALHO"))
            return TipoAvaliacao.TRABALHO;
        else
            return null;
    }
}
