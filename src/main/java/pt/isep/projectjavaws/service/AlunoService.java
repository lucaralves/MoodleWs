package pt.isep.projectjavaws.service;

import pt.isep.projectjavaws.dto.*;
import pt.isep.projectjavaws.modelo.Aluno;
import pt.isep.projectjavaws.modelo.Instituicao;
import pt.isep.projectjavaws.modelo.UnidadeCurricular;

import java.util.ArrayList;
import java.util.Iterator;

public class AlunoService {

    public static AlunoPartialDTO getAlunoPartial(Long numAluno) {

        Aluno aluno = Instituicao.getAlunoByNumAluno(numAluno);
        AlunoPartialDTO alunoDTO = Converter.convertAluno4AlunoPartialDTO(aluno);

        return alunoDTO;
    }

    public static AlunoDTO getAluno(Long numAluno) {

        Aluno aluno = Instituicao.getAlunoByNumAluno(numAluno);
        AlunoDTO alunoDTO = Converter.convertAluno(aluno);

        return alunoDTO;
    }

    public static ListaAlunosDTO getListaAlunos() {

        Iterator<Aluno> iterator = Instituicao.getListaAlunos().values().iterator();
        ArrayList<Aluno> listaAlunos = new ArrayList<>();
        while (iterator.hasNext()) {
            listaAlunos.add(iterator.next());
        }

        ArrayList<AlunoDTO> listaAlunosDTO = Converter.convertListaAlunos(listaAlunos);

        ListaAlunosDTO listaAlunosDTO1 = new ListaAlunosDTO(listaAlunosDTO);

        return listaAlunosDTO1;
    }

    public static ListaUcsAlunoGeralDTO getListaUcAlunos() {

        Iterator<Aluno> iterator = Instituicao.getListaAlunos().values().iterator();
        ArrayList<UnidadeCurricular> listaUCs;
        ListaUcsAlunoGeralDTO listaUcsAlunoGeralDTO = new ListaUcsAlunoGeralDTO();
        while (iterator.hasNext()) {
            Aluno aluno = iterator.next();
            listaUCs = aluno.getUCsByInteger();
            ListaUCsAlunoDTO listaUCsAlunoDTO = new ListaUCsAlunoDTO(Converter.convertAluno(aluno), Converter.convertListaUCs(listaUCs));
            listaUcsAlunoGeralDTO.getListaUCsAlunosDTO().add(listaUCsAlunoDTO);
        }

        return listaUcsAlunoGeralDTO;
    }
}
