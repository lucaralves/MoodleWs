package pt.isep.projectjavaws.dados;

import pt.isep.projectjavaws.modelo.*;

import javax.swing.text.StyleConstants;
import javax.xml.transform.Result;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;


public class Dados {

    public static void importaCursos() {

        try {
            BufferedReader lerCsv = new BufferedReader(new FileReader("cursos.csv"));
            String linha;
            while ((linha = lerCsv.readLine()) != null) {
                String[] conteudo = linha.split(";");
                String codigo = conteudo[0];
                String nome = conteudo[1];
                Curso curso = new Curso(nome, codigo);
                Instituicao.getListaCursos().put(codigo, curso);
            }
            lerCsv.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void importaTurmas() {

        try {
            BufferedReader lerCsv = new BufferedReader(new FileReader("turmas.csv"));
            String linha;
            while ((linha = lerCsv.readLine()) != null) {
                String[] conteudo = linha.split(";");
                String keyTurma = conteudo[0];
                int ano = Integer.parseInt(conteudo[1]);
                String referencia = conteudo[2];
                String regime = conteudo[3];

                Turma turma = new Turma(keyTurma,ano, referencia);

                switch (regime) {
                    case "S1" : {
                        turma.setRegime(Regime.PRIMEIRO_SEMESTRE);
                        break;
                    }
                    case "S2": turma.setRegime(Regime.SEGUNDO_SEMESTRE);
                }

                Instituicao.getListaTurmas().put(keyTurma, turma);
            }
            lerCsv.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void importaUnidadeCurricular() {

        try {
            BufferedReader lerCsv = new BufferedReader(new FileReader("UCs.csv"));
            String linha;
            while ((linha = lerCsv.readLine()) != null) {
                String[] conteudo = linha.split(";");
                Integer keyUC = Integer.parseInt(conteudo[0]);
                String nome = conteudo[1];
                String regime = conteudo[2];
                int creditos = Integer.parseInt(conteudo[3]);
                int ano = Integer.parseInt(conteudo[4]);

                UnidadeCurricular unidadeCurricular = new UnidadeCurricular(nome, ano, creditos, keyUC);

                switch (regime) {
                    case "1": {
                        unidadeCurricular.setRegime(Regime.PRIMEIRO_SEMESTRE);
                        break;
                    }
                    case "2": unidadeCurricular.setRegime(Regime.SEGUNDO_SEMESTRE);
                }

                Instituicao.getListaUCs().put(keyUC, unidadeCurricular);
            }
            lerCsv.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void importaAlunos() {

        try {
            BufferedReader lerCsv = new BufferedReader(new FileReader("alunos.csv"));
            String linha;
            while ((linha = lerCsv.readLine()) != null) {
                String[] conteudo = linha.split(";");
                String nome = conteudo[0];
                long bi = Long.parseLong(conteudo[1]);
                Long numAluno = Long.parseLong(conteudo[2]);
                char sexo = conteudo[3].charAt(0);
                LocalDate nascimento = LocalDate.parse(conteudo[4]);
                String curso = conteudo[5];
                String turma = conteudo[6];
                String regiao = conteudo[7];
                long senha = Long.parseLong(conteudo[8]);

                Aluno aluno = new Aluno(bi, numAluno, nome, senha, nascimento, sexo);

                switch (regiao) {
                    case "NORTE": {
                        aluno.setRegiao(Regiao.NORTE);
                        break;
                    }
                    case "SUL": {
                        aluno.setRegiao(Regiao.SUL);
                        break;
                    }
                    case "CENTRO": {
                        aluno.setRegiao(Regiao.CENTRO);
                        break;
                    }
                    case "ILHAS": {
                        aluno.setRegiao(Regiao.ILHAS);
                        break;
                    }
                    case "ESTRANGEIRO": aluno.setRegiao(Regiao.ESTRANGEIRO);
                }

                //Atribui o valor do curso do aluno em questão na linha em estudo.

                Iterator<Curso> iterator = Instituicao.getListaCursos().values().iterator();
                while (iterator.hasNext()) {
                    Curso cursoAux = iterator.next();
                    if (cursoAux.getNome().equals(curso)) {
                        aluno.setCurso(cursoAux);
                        break;
                    }
                }

                //Atribui o valor da turma do aluno em questão na linha em estudo.
                Iterator<Turma> iterator1 = Instituicao.getListaTurmas().values().iterator();
                while (iterator1.hasNext()) {
                    Turma turmaAux = iterator1.next();
                    if (turmaAux.getKeyTurma().equals(turma)) {
                        aluno.setTurma(turmaAux);
                        break;
                    }
                }
                Instituicao.getListaAlunos().put(numAluno, aluno);
            }
            lerCsv.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void importaAlunosUCs() {

        try {
            BufferedReader lerCsv = new BufferedReader(new FileReader("uc-aluno.csv"));
            String linha;
            while ((linha = lerCsv.readLine()) != null) {
                String[] conteudo = linha.split(";");
                Long numAluno = Long.parseLong(conteudo[0]);
                Integer keyUC = Integer.parseInt(conteudo[1]);

                Iterator<Aluno> iterator = Instituicao.getListaAlunos().values().iterator();
                while (iterator.hasNext()) {
                    Aluno aluno = iterator.next();
                    if (aluno.getNumeroAluno() == numAluno) {
                        aluno.adicionaUC(keyUC);
                        break;
                    }
                }
            }
            lerCsv.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void importaAvaliacoes() {
        try {
            BufferedReader lerCsv = new BufferedReader(new FileReader("avaliacoes.txt"));
            String linha;
            while ((linha = lerCsv.readLine()) != null) {
                String[] conteudo = linha.split(";");
                Integer keyAvaliacao = Integer.parseInt(conteudo[0]);
                String tipoAvaliacao = conteudo[1];
                LocalDate date = LocalDate.parse(conteudo[2]);
                String observacao = conteudo[3];
                Integer uc = Integer.parseInt(conteudo[4]);
                Long numAluno = Long.parseLong(conteudo[5]);

                UnidadeCurricular unidadeCurricular = Instituicao.getListaUCs().get(uc);

                Avaliacao avaliacao = new Avaliacao(date, observacao, unidadeCurricular,
                        numAluno, keyAvaliacao);

                switch (tipoAvaliacao) {
                    case "FREQUENCIA": {
                        avaliacao.setTipo(TipoAvaliacao.FREQUENCIA);
                        break;
                    }
                    case "EXAME": {
                        avaliacao.setTipo(TipoAvaliacao.EXAME);
                        break;
                    }
                    case "PROJETO": {
                        avaliacao.setTipo(TipoAvaliacao.PROJETO);
                        break;
                    }
                    case "TRABALHO": {
                        avaliacao.setTipo(TipoAvaliacao.TRABALHO);
                        break;
                    }
                }

                Aluno aluno = Instituicao.getAlunoByNumAluno(numAluno);
                aluno.getAvaliacoes().put(keyAvaliacao, avaliacao);
            }
            lerCsv.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void importaAvaliacoesNotas() {

        try {
            BufferedReader lerCsv = new BufferedReader(new FileReader("avaliacao-nota.txt"));
            String linha;
            while ((linha = lerCsv.readLine()) != null) {
                String[] conteudo = linha.split(";");
                Integer keyAvaliacao = Integer.parseInt(conteudo[0]);
                Long numAluno = Long.parseLong(conteudo[1]);
                int nota = Integer.parseInt(conteudo[2]);

                Aluno aluno = Instituicao.getAlunoByNumAluno(numAluno);
                Avaliacao avaliacao = Avaliacao.getAvaliacaoByKey(keyAvaliacao, aluno);
                avaliacao.setNota(nota);
            }
            lerCsv.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void importa() {
        importaCursos();
        importaTurmas();
        importaUnidadeCurricular();
        importaAlunos();
        importaAlunosUCs();
        importaAvaliacoes();
        importaAvaliacoesNotas();
    }

    //Escreve o estado num ficheiro bin e na base dados MariaDb.
    public static void escreverEstado() {

        Data data = new Data();
        String jdbcUrl = "jdbc:mysql://localhost:3306/projectjavaws";
        String username = "root";
        String password = "21?luc_san!";

        try {
            FileOutputStream file = new FileOutputStream("persistencia.bin");

            // Creates an ObjectOutputStream
            ObjectOutputStream output = new ObjectOutputStream(file);

            // writes objects to output stream
            output.writeObject(data);

            output.flush();
            output.close();
        }

        catch (Exception e) {
            e.getStackTrace();
            System.out.println("Não escreveu em file.txt");
        }

        Map<Long, Aluno> listaAlunos = data.getListaAlunos();
        //Iterador sobre os alunos.
        Iterator<Aluno> iterator = listaAlunos.values().iterator();
        while (iterator.hasNext()) {
            Map<Integer, Avaliacao> listaAvaliacoes = iterator.next().getAvaliacoes();
            //Iterador sobre as avaliações de um aluno.
            Iterator<Avaliacao> iterator1 = listaAvaliacoes.values().iterator();
            while (iterator1.hasNext()) {
                int cont = 0;
                Avaliacao avaliacao = iterator1.next();
                try {
                    Class.forName("org.mariadb.jdbc.Driver").newInstance();
                    Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
                    Statement stat1 = connection.createStatement();
                    ResultSet rs = stat1.executeQuery("select * from avaliacoes");
                    while (rs.next()) {
                        if (rs.getInt(2) == avaliacao.getRefAluno() && rs.getInt(1) == avaliacao.getKeyAvaliacao()) {
                            cont++;
                            break;
                        }
                    }
                    if (cont == 0) {
                        String sql = "insert into avaliacoes values(" + avaliacao.getKeyAvaliacao() +
                                ", " + avaliacao.getRefAluno() + ", " + "'" +
                                avaliacao.getUnidadeCurricular().getKeyUC() + "' , " +  "'" + avaliacao.getObservacao() +
                                "' , " + "'" + avaliacao.getDataAvaliacao().toString() + "' , " + "'" + avaliacao.getTipo().toString() + "')";
                        Statement stat = connection.createStatement();
                        stat.executeQuery(sql);
                    }
                    connection.close();
                } catch (Exception e) {
                    System.out.print(e.toString());
                }
            }
        }
    }

    //Lê o estado através do ficheiro bin.
    public static void lerEstado() {
        Data data = null;
        try {
            // Reads data using the ObjectInputStream
            FileInputStream fileStream = new FileInputStream("persistencia.bin");
            ObjectInputStream objStream = new ObjectInputStream(fileStream);

            data = (Data) objStream.readObject();

            objStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Não carregou o file.txt");
        }

        if (data == null) {
            data = new Data();
        }

        Instituicao.setListaAlunos(data.getListaAlunos());
        Instituicao.setListaCursos(data.getListaCursos());
        Instituicao.setListaTurmas(data.getListaTurmas());
        Instituicao.setListaUCs(data.getListaUCs());

    }

    //Lê o estado através da base de dados MariaDb.
    public static void lerEstadoMariaDb() {

        String jdbcUrl = "jdbc:mysql://localhost:3306/projectjavaws";
        String username = "root";
        String password = "21?luc_san!";

        try {
            Class.forName("org.mariadb.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            Statement stat = connection.createStatement();

            //Importa cursos.
            ResultSet rs = stat.executeQuery("select * from cursos");
            while (rs.next()) {
                Curso curso = new Curso(rs.getNString(2), rs.getNString(1));
                Instituicao.getListaCursos().put(rs.getString(1), curso);
            }

            //Importa turmas.
            ResultSet rs1 = stat.executeQuery("select * from turmas");
            while (rs1.next()) {
                Turma turma = new Turma(rs1.getNString(1), rs1.getInt(2), rs1.getString(3));
                Instituicao.getListaTurmas().put(turma.getKeyTurma(), turma);
            }

            //Importa alunos.
            ResultSet rs2 = stat.executeQuery("select * from alunos");
            while (rs2.next()) {
                Aluno aluno = new Aluno(rs2.getLong(2), rs2.getLong(3), rs2.getString(1), rs2.getLong(9), LocalDate.parse(rs2.getString(5)), rs2.getString(4).charAt(0));
                Instituicao.getListaAlunos().put(aluno.getNumeroAluno(), aluno);
                if (rs2.getNString(6).equals("Biorrecursos"))
                    aluno.setCurso(Instituicao.getListaCursos().get("L089"));
                else
                    aluno.setCurso(Instituicao.getListaCursos().get("9455"));

                Iterator<Turma> iterator1 = Instituicao.getListaTurmas().values().iterator();
                while (iterator1.hasNext()) {
                    Turma turmaAux = iterator1.next();
                    if (turmaAux.getKeyTurma().equals(rs2.getNString(7))) {
                        aluno.setTurma(turmaAux);
                        break;
                    }
                }

                switch (rs2.getNString(8)) {
                    case "NORTE": {
                        aluno.setRegiao(Regiao.NORTE);
                        break;
                    }
                    case "SUL": {
                        aluno.setRegiao(Regiao.SUL);
                        break;
                    }
                    case "CENTRO": {
                        aluno.setRegiao(Regiao.CENTRO);
                        break;
                    }
                    case "ILHAS": {
                        aluno.setRegiao(Regiao.ILHAS);
                        break;
                    }
                    case "ESTRANGEIRO": aluno.setRegiao(Regiao.ESTRANGEIRO);
                }
            }

            //Importa Unidades curriculares.
            ResultSet rs3 = stat.executeQuery("select * from ucs");
            while (rs3.next()) {
                UnidadeCurricular unidadeCurricular = new UnidadeCurricular(rs3.getNString(2), rs3.getInt(5), rs3.getInt(4), rs3.getInt(1));
                Instituicao.getListaUCs().put(unidadeCurricular.getKeyUC(), unidadeCurricular);
                switch (rs3.getInt(1)) {
                    case 1: {
                        unidadeCurricular.setRegime(Regime.PRIMEIRO_SEMESTRE);
                        break;
                    }
                    case 2: unidadeCurricular.setRegime(Regime.SEGUNDO_SEMESTRE);
                }
            }

            //Importa Uc-Aluno.
            ResultSet rs4 = stat.executeQuery("select * from ucaluno");
            while (rs4.next()) {
                Iterator<Aluno> iterator = Instituicao.getListaAlunos().values().iterator();
                while (iterator.hasNext()) {
                    Aluno aluno = iterator.next();
                    if (aluno.getNumeroAluno() == rs4.getLong(1)) {
                        aluno.adicionaUC(rs4.getInt(2));
                        break;
                    }
                }
            }

            //Importa Avaliações.
            UnidadeCurricular unidadeCurricular;
            ResultSet rs5 = stat.executeQuery("select * from avaliacoes");
            while (rs5.next()) {
                Avaliacao avaliacao = new Avaliacao(rs5.getInt(1), rs5.getLong(2), rs5.getNString(4), LocalDate.parse(rs5.getNString(5)));

                switch (rs5.getString(6)) {
                    case "FREQUENCIA": {
                        avaliacao.setTipo(TipoAvaliacao.FREQUENCIA);
                        break;
                    }
                    case "PROJETO": {
                        avaliacao.setTipo(TipoAvaliacao.PROJETO);
                        break;
                    }
                    case "EXAME": {
                        avaliacao.setTipo(TipoAvaliacao.EXAME);
                        break;
                    }
                    case "TRABALHO": {
                        avaliacao.setTipo(TipoAvaliacao.TRABALHO);
                        break;
                    }
                }

                unidadeCurricular = Instituicao.getListaUCs().get(rs5.getInt(3));
                avaliacao.setUnidadeCurricular(unidadeCurricular);

                Aluno aluno = Instituicao.getAlunoByNumAluno(avaliacao.getRefAluno());
                aluno.getAvaliacoes().put(avaliacao.getKeyAvaliacao(), avaliacao);
            }


            connection.close();
        } catch (Exception e) {
            System.out.print(e.toString());
        }

    }
}
