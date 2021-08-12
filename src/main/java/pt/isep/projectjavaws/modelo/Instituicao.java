package pt.isep.projectjavaws.modelo;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Instituicao implements Serializable {
    //Atributos de uma instituição.
    public static Map<Long,Aluno> listaAlunos = new HashMap<>();
    public static Map<String, Curso> listaCursos = new HashMap<>();
    public static Map<String,Turma> listaTurmas = new HashMap<>();
    public static Map<Integer,UnidadeCurricular> listaUCs = new HashMap<>();
    public static String nome = "ISEP";
    public static long codigo = 123;
    public static String morada = "IPO";
    public static long nif = 123456789;


    public static Map<Integer, UnidadeCurricular> getListaUCs() {
        return listaUCs;
    }

    public static void setListaUCs(Map<Integer, UnidadeCurricular> listaUCs) {
        Instituicao.listaUCs = listaUCs;
    }

    public static Map<String, Turma> getListaTurmas() {
        return listaTurmas;
    }

    public static void setListaTurmas(Map<String, Turma> listaTurmas) {
        Instituicao.listaTurmas = listaTurmas;
    }

    public static Map<String, Curso> getListaCursos() {
        return listaCursos;
    }

    public static void setListaCursos(Map<String, Curso> listaCursos) {
        Instituicao.listaCursos = listaCursos;
    }

    public static Map<Long, Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public static void setListaAlunos(Map<Long, Aluno> listaAlunos) {
        Instituicao.listaAlunos = listaAlunos;
    }

    public static String getNome() {
        return nome;
    }

    public static long getCodigo() {
        return codigo;
    }

    public static String getMorada() {
        return morada;
    }

    public static long getNif() {
        return nif;
    }

    public static Aluno getAlunoByNumAluno(Long numAluno) {
        Aluno aluno = listaAlunos.get(numAluno);

        return aluno;
    }

    //xxxx
    //retorna true se as credenciais coincidem e retorna false se as credenciais não coincidem.
    public static Aluno login(long numeroAlunoIntroduzido, long senha) {
        Iterator<Aluno> iterator = Instituicao.getListaAlunos().values().iterator();

        while (iterator.hasNext()) {
            Aluno aluno = iterator.next();

            if (aluno.getNumeroAluno() == numeroAlunoIntroduzido &&
                    aluno.getSenha() == senha)
                return aluno;
        }
        return null;
    }
}
