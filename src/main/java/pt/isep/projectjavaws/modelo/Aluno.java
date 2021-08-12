package pt.isep.projectjavaws.modelo;

import pt.isep.projectjavaws.dto.AvaliacaoDTO;
import pt.isep.projectjavaws.dto.AvaliacaoPartial2DTO;
import pt.isep.projectjavaws.exceptions.KeyAvaliacaoDuplicadaException;
import pt.isep.projectjavaws.exceptions.KeyAvaliacaoInexistenteException;
import pt.isep.projectjavaws.exceptions.UcInexistenteException;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Aluno implements Serializable {
    //Atributos de um aluno.
    private long cc;
    private Long numeroAluno;
    private String nome;
    private long senha;
    private Curso curso;
    private Turma turma;
    private LocalDate nascimento;
    private char sexo;
    private Regiao regiao;
    private Map<Integer, Avaliacao> avaliacoes = new HashMap<>();
    private ArrayList<Integer> frequentar = new ArrayList<>();

    public Aluno(long cc, Long numeroAluno, String nome, long senha, Curso curso, Turma turma,
                 LocalDate nascimento, char sexo, Regiao regiao) {
        this.cc = cc;
        this.numeroAluno = numeroAluno;
        this.nome = nome;
        this.senha = senha;
        this.curso = curso;
        this.turma = turma;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.regiao = regiao;
    }

    public Aluno(long cc, Long numeroAluno, String nome, long senha, LocalDate nascimento, char sexo) {
        this.cc = cc;
        this.numeroAluno = numeroAluno;
        this.nome = nome;
        this.senha = senha;
        this.nascimento = nascimento;
        this.sexo = sexo;
    }

    public ArrayList<Integer> getFrequentar() {
        return frequentar;
    }

    public void setFrequentar(ArrayList<Integer> frequentar) {
        this.frequentar = frequentar;
    }

    public long getSenha() {
        return senha;
    }

    public void setSenha(long senha) {
        this.senha = senha;
    }

    public long getCc() {
        return cc;
    }

    public void setCc(long cc) {
        this.cc = cc;
    }

    public long getNumeroAluno() {
        return numeroAluno;
    }

    public void setNumeroAluno(Long numeroAluno) {
        this.numeroAluno = numeroAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public Map<Integer, Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(Map<Integer, Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public void adicionaUC(Integer uc) {
        frequentar.add(uc);
    }

    public ArrayList<UnidadeCurricular> getUCsByInteger() {

        ArrayList<UnidadeCurricular> listaUCs = new ArrayList<>();
        for (int i = 0; i < frequentar.size(); i++) {
            UnidadeCurricular uc = Instituicao.getListaUCs().get(frequentar.get(i));
            listaUCs.add(uc);
        }
        return listaUCs;
    }

    public ArrayList<Avaliacao> getArrayListAvaliacoes() {
        Iterator<Avaliacao> iterator = avaliacoes.values().iterator();
        ArrayList<Avaliacao> listaAvaliacoes = new ArrayList<>();
        while (iterator.hasNext()) {
            listaAvaliacoes.add(iterator.next());
        }
        return listaAvaliacoes;
    }

    public Avaliacao getAvaliacaoByKey(Integer keyAvaliacao) {

        if (getAvaliacoes().get(keyAvaliacao) != null)
            return getAvaliacoes().get(keyAvaliacao);
        else
            throw new KeyAvaliacaoInexistenteException("Key de avaliação inexistente");
    }

    public boolean verificaUc(Avaliacao avaliacao) {
        for (int i = 0; i < frequentar.size(); i++)
            //if (avaliacao.getUnidadeCurricular().equals(Instituicao.getUcByInteger(frequentar.get(i))))
            if (avaliacao.getUnidadeCurricular().getKeyUC().equals(frequentar.get(i)))
                return true;

        throw new UcInexistenteException("A UC inserida não integra o seu plano curricular");
    }

    public boolean verificaUcDTO(AvaliacaoDTO avaliacaoDTO) {
        for (int i = 0; i < frequentar.size(); i++)
            //if (avaliacao.getUnidadeCurricular().equals(Instituicao.getUcByInteger(frequentar.get(i))))
            if (avaliacaoDTO.getUnidadeCurricular().getKeyUC().equals(frequentar.get(i)))
                return true;

        throw new UcInexistenteException("A UC inserida não integra o seu plano curricular");
    }

    public boolean addAvaliacao(AvaliacaoPartial2DTO avaliacaoPartial2DTO, Integer keyUc) {
        int keyAvTemp = 0;
        int keyAvDef = 0;
        int cont = 0;

        ArrayList<Avaliacao> avaliacoesArray = getArrayListAvaliacoes();
        for (int i = 0; i < avaliacoesArray.size(); i++) {
            if (keyAvTemp != avaliacoesArray.get(i).getKeyAvaliacao()) {
                cont++;

                if (cont == avaliacoesArray.size())
                    keyAvDef = keyAvTemp;
            }
            else {
                i = -1;
                cont = 0;
                keyAvTemp++;
            }
        }

        Avaliacao avaliacao = new Avaliacao(avaliacaoPartial2DTO, keyAvDef, keyUc);

        if (avaliacoes.putIfAbsent(keyAvDef, avaliacao) == null)
            return true;
        else
            throw new KeyAvaliacaoDuplicadaException("Key da avaliação já existente");
    }

    public native int hashCode();
}
