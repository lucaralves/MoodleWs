package pt.isep.projectjavaws.service;

import pt.isep.projectjavaws.dados.Dados;
import pt.isep.projectjavaws.dto.*;
import pt.isep.projectjavaws.modelo.Aluno;
import pt.isep.projectjavaws.modelo.Avaliacao;
import pt.isep.projectjavaws.modelo.Instituicao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class AvaliacaoService {

    public static AvaliacaoPartial2DTO getAvaliacaoPartial2DTO(Long numAluno, Integer keyAvaliacao) {

        Aluno aluno = Instituicao.getAlunoByNumAluno(numAluno);
        Avaliacao avaliacao = aluno.getAvaliacaoByKey(keyAvaliacao);
        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO(avaliacao);
        AvaliacaoPartial2DTO avaliacaoPartial2DTO = new AvaliacaoPartial2DTO(avaliacaoDTO);

        return avaliacaoPartial2DTO;
    }

    public static ListaAvaliacaoGeralDTO getAvaliacoesAlunos() {
        Dados.lerEstadoMariaDb();

        Iterator<Aluno> iterator = Instituicao.getListaAlunos().values().iterator();
        Map<Integer, Avaliacao> listaAvaliacoes;
        ListaAvaliacaoGeralDTO listaAvaliacaoGeralDTO = new ListaAvaliacaoGeralDTO();
        while (iterator.hasNext()) {
            Aluno aluno = iterator.next();
            listaAvaliacoes = aluno.getAvaliacoes();

            Iterator<Avaliacao> iterator1 = listaAvaliacoes.values().iterator();
            ArrayList<Avaliacao> listaAvaliacoes1 = new ArrayList<>();
            ArrayList<AvaliacaoDTO> listaAvaliacoesDTO;
            while (iterator1.hasNext()) {
                listaAvaliacoes1.add(iterator1.next());
            }
            listaAvaliacoesDTO = Converter.convertListaAvaliacoes(listaAvaliacoes1);
            ListaAvaliacaoDTO listaAvaliacoesDTO1 = new ListaAvaliacaoDTO(listaAvaliacoesDTO);

            listaAvaliacaoGeralDTO.getAvaliacoesalunos().add(listaAvaliacoesDTO1);
        }

        return listaAvaliacaoGeralDTO;
    }

    public static ListaAvaliacaoDTO getAvaliacoesAluno(Long numAluno) {

        Aluno aluno = Instituicao.getAlunoByNumAluno(numAluno);
        ArrayList<Avaliacao> listaAvaliacoes;
        ArrayList<AvaliacaoDTO> listaAvaliacoesDTO;
        listaAvaliacoes = aluno.getArrayListAvaliacoes();
        listaAvaliacoesDTO = Converter.convertListaAvaliacoes(listaAvaliacoes);
        ListaAvaliacaoDTO listaAvaliacaoDTO = new ListaAvaliacaoDTO(listaAvaliacoesDTO);
        return listaAvaliacaoDTO;
    }

    public static ListaAvaliacaoDTO getAvaliacoesAlunoUc(Long numAluno, Integer keyUc) {
        ArrayList<Avaliacao> listaAvaliacoes;
        ArrayList<AvaliacaoDTO> listaAvaliacoesDTO = new ArrayList<>();

        Aluno aluno = Instituicao.getAlunoByNumAluno(numAluno);
        listaAvaliacoes = aluno.getArrayListAvaliacoes();

        for (int i = 0; i < listaAvaliacoes.size(); i++) {
            if (keyUc.equals(listaAvaliacoes.get(i).getUnidadeCurricular().getKeyUC()))
                listaAvaliacoesDTO.add(Converter.convertAvaliacao(listaAvaliacoes.get(i)));
        }

        ListaAvaliacaoDTO listaAvaliacaoDTO = new ListaAvaliacaoDTO(listaAvaliacoesDTO);
        return listaAvaliacaoDTO;
    }

    public static ListaAvaliacaoPartialDTO getListaAvaliacaoPartialDTO(Long numAluno) {
        Aluno aluno = Instituicao.getAlunoByNumAluno(numAluno);
        ArrayList<Avaliacao> listaAvaliacoes;
        ArrayList<AvaliacaoDTO> listaAvaliacoesDTO;
        ArrayList<AvaliacaoPartialDTO> listaAvaliacoesPartialDTO;
        listaAvaliacoes = aluno.getArrayListAvaliacoes();
        listaAvaliacoesDTO = Converter.convertListaAvaliacoes(listaAvaliacoes);
        listaAvaliacoesPartialDTO = Converter.convertListaAvaliacoesDTO4ListaAvaliacoesPartialDTO(listaAvaliacoesDTO);
        ListaAvaliacaoPartialDTO listaAvaliacaoPartialDTO = new ListaAvaliacaoPartialDTO(listaAvaliacoesPartialDTO);
        return listaAvaliacaoPartialDTO;
    }

    public static ListaAvaliacaoPartial1DTO getListaAvaliacaoPartial1DTO(Long numAluno, Integer keyUc) {
        Aluno aluno = Instituicao.getAlunoByNumAluno(numAluno);
        ArrayList<Avaliacao> listaAvaliacoes;
        ArrayList<AvaliacaoDTO> listaAvaliacoesDTO = new ArrayList<>();
        ArrayList<AvaliacaoPartial1DTO> listaAvaliacoesPartial1DTO;
        listaAvaliacoes = aluno.getArrayListAvaliacoes();

        for (int i = 0; i < listaAvaliacoes.size(); i++) {
            if (listaAvaliacoes.get(i).getUnidadeCurricular().getKeyUC().equals(keyUc))
                listaAvaliacoesDTO.add(Converter.convertAvaliacao(listaAvaliacoes.get(i)));
        }

        listaAvaliacoesPartial1DTO = Converter.convertListaAvaliacoesDTO4ListaAvaliacoesPartial1DTO(listaAvaliacoesDTO);
        ListaAvaliacaoPartial1DTO listaAvaliacaoPartial1DTO = new ListaAvaliacaoPartial1DTO(listaAvaliacoesPartial1DTO);
        return listaAvaliacaoPartial1DTO;
    }

    public static void editAvaliacao(AvaliacaoPartial2DTO avaliacaoPartial2DTO, Long numAluno, Integer keyAvaliacao) {

        Aluno aluno = Instituicao.getListaAlunos().get(numAluno);
        Avaliacao avaliacao = aluno.getAvaliacaoByKey(keyAvaliacao);
        avaliacao.editAvaliacao(avaliacaoPartial2DTO);

        Dados.escreverEstado();
    }

    public static void eliminaAvaliacao(Long numAluno, Integer keyAvaliacao) {

        Aluno aluno = Instituicao.listaAlunos.get(numAluno);

        //Este método apenas está a servir de verificação da key da avaliação a eliminar.
        //Deste modo, o retorno do método não está a ser aproveitado.
        aluno.getAvaliacaoByKey(keyAvaliacao);
        aluno.getAvaliacoes().remove(keyAvaliacao);

        Dados.escreverEstado();
    }

    public static void adicionaAvaliacao(AvaliacaoPartial2DTO avaliacaoPartial2DTO, Long numAluno, Integer keyUc) {

        Aluno aluno = Instituicao.getListaAlunos().get(numAluno);
        aluno.addAvaliacao(avaliacaoPartial2DTO, keyUc);

        Dados.escreverEstado();
    }

    public static void alteraAvaliacao(AvaliacaoDTO avaliacaoDTO, Long numAluno, Integer keyAvaliacao) {

        Aluno aluno = Instituicao.getListaAlunos().get(numAluno);
        aluno.verificaUcDTO(avaliacaoDTO);
        Avaliacao avaliacao = aluno.getAvaliacaoByKey(keyAvaliacao);
        avaliacao.alteraAvaliacao(avaliacaoDTO);

        Dados.escreverEstado();
    }
}
