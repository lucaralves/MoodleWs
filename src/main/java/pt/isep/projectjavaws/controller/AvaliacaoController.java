package pt.isep.projectjavaws.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.isep.projectjavaws.dados.Dados;
import pt.isep.projectjavaws.dto.*;
import pt.isep.projectjavaws.modelo.Instituicao;
import pt.isep.projectjavaws.service.AlunoService;
import pt.isep.projectjavaws.service.AvaliacaoService;
import pt.isep.projectjavaws.service.UnidadeCurricularService;

@RestController
@RequestMapping("/api")
public class AvaliacaoController {

    @RequestMapping(value = "/editavaliacao/{numAluno}/{senha}/{keyavaliacao}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)

    public ResponseEntity<Object> editAvaliacao(
            @RequestBody AvaliacaoPartial2DTO avaliacaoPartial2DTO, @PathVariable("numAluno") Long numAluno,
            @PathVariable("senha") Long senha, @PathVariable("keyavaliacao") Integer keyavaliacao) {
        //Dados.importa();
        Dados.lerEstadoMariaDb();
        if (Instituicao.login(numAluno, senha) != null) {
            try {
                AvaliacaoService.editAvaliacao(avaliacaoPartial2DTO, numAluno, keyavaliacao);
                return new ResponseEntity<>("Avaliação alterada", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
            }
        }
        else
            return new ResponseEntity<>("Senha e número de aluno não coincidem !!!", HttpStatus.OK);

    }

    @RequestMapping(value = "/deleteavaliacao/{numAluno}/{senha}/{keyavaliacao}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)

    public ResponseEntity<Object> deleteAvaliacao(
            @PathVariable("numAluno") Long numAluno,
            @PathVariable("senha") Long senha, @PathVariable("keyavaliacao") Integer keyavaliacao) {

        //Dados.importa();
        Dados.lerEstadoMariaDb();

        if (Instituicao.login(numAluno, senha) != null) {
            try {
                AvaliacaoService.eliminaAvaliacao(numAluno, keyavaliacao);
                return new ResponseEntity<>("Avaliação eliminada", HttpStatus.OK);

            } catch (Exception e) {
                return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
            }
        }
        else
            return new ResponseEntity<>("Senha e número de aluno não coincidem !!!", HttpStatus.OK);

    }

    @RequestMapping(value = "/addavaliacao/{numAluno}/{senha}/{keyUc}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)

    public ResponseEntity<Object> addAvaliacao(
            @RequestBody AvaliacaoPartial2DTO avaliacaoPartial2DTO, @PathVariable("numAluno") Long numAluno,
            @PathVariable("senha") Long senha, @PathVariable("keyUc") Integer keyUc) {

        //Dados.importa();
        Dados.lerEstadoMariaDb();

        if (Instituicao.login(numAluno, senha) != null) {
            try {
                AvaliacaoService.adicionaAvaliacao(avaliacaoPartial2DTO, numAluno, keyUc);
                return new ResponseEntity<>("Avaliação adicionada", HttpStatus.OK);

            } catch (Exception e) {
                return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
            }
        }
        else
            return new ResponseEntity<>("Senha e número de aluno não coincidem !!!", HttpStatus.OK);

    }

    @RequestMapping(value = "/getavaliacao/{numAluno}/{senha}/{keyAvaliacao}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getAlunoPartial(@PathVariable("numAluno") Long numAluno,
                                                  @PathVariable("senha") long senha,
                                                  @PathVariable("keyAvaliacao") Integer keyAvaliacao) {
        Dados.lerEstadoMariaDb();
        AvaliacaoPartial2DTO avaliacaoDTO;
        if (Instituicao.login(numAluno, senha) != null) {
            avaliacaoDTO = AvaliacaoService.getAvaliacaoPartial2DTO(numAluno, keyAvaliacao);
        }
        else
            return new ResponseEntity<>("Senha e número de aluno não coincidem !!!", HttpStatus.CONFLICT);

        return new ResponseEntity<>(avaliacaoDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/getlistaavaliacaopartial/{numAluno}/{senha}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getListaAvaliacaoPartial(@PathVariable("numAluno") Long numAluno,
                                         @PathVariable("senha") long senha) {
        try {
            Dados.lerEstadoMariaDb();
            ListaAvaliacaoPartialDTO listaAvaliacoes = AvaliacaoService.getListaAvaliacaoPartialDTO(numAluno);

            return new ResponseEntity<>(listaAvaliacoes, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/getlistaavaliacao1partial/{numAluno}/{senha}/{keyuc}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getListaAvaliacao1Partial(@PathVariable("numAluno") Long numAluno,
                                                       @PathVariable("senha") long senha,
                                                       @PathVariable("keyuc") Integer keyuc) {
        //Dados.importa();
        Dados.lerEstadoMariaDb();
        ListaAvaliacaoPartial1DTO listaAvaliacaoPartial1DTO;

        if (Instituicao.login(numAluno, senha) != null) {
            listaAvaliacaoPartial1DTO = AvaliacaoService.getListaAvaliacaoPartial1DTO(numAluno, keyuc);
            if (listaAvaliacaoPartial1DTO == null)
                return new ResponseEntity<>("Cadeira inexistente !!!", HttpStatus.OK);
            else {
                Dados.escreverEstado();
                return new ResponseEntity<>(listaAvaliacaoPartial1DTO, HttpStatus.OK);
            }
        }
        else
            return new ResponseEntity<>("Senha e número de aluno não coincidem !!!", HttpStatus.OK);
    }

    @RequestMapping(value = "/listaavaliacoesgeral",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getAvaliacoesGeral() {
        try {
            Dados.lerEstadoMariaDb();
            ListaAvaliacaoGeralDTO listaAvaliacaoGeralDTO = AvaliacaoService.getAvaliacoesAlunos();

            return new ResponseEntity<>(listaAvaliacaoGeralDTO, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/listaavaliacoes/{numAluno}/{senha}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getAvaliacoesAluno(@PathVariable("numAluno") Long numAluno,
                                                    @PathVariable("senha") long senha) {
        //Dados.importa();
        Dados.lerEstadoMariaDb();
        ListaAvaliacaoDTO listaAvaliacaoDTO;

        if (Instituicao.login(numAluno, senha) != null) {
            listaAvaliacaoDTO = AvaliacaoService.getAvaliacoesAluno(numAluno);
        }
        else
            return new ResponseEntity<>("Senha e número de aluno não coincidem !!!", HttpStatus.OK);

        Dados.escreverEstado();
        return new ResponseEntity<>(listaAvaliacaoDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/listaavaliacoescadeira/{numAluno}/{senha}/{keyuc}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getAvaliacoesAlunoUC(@PathVariable("numAluno") Long numAluno,
                                                    @PathVariable("senha") long senha,
                                                    @PathVariable("keyuc") Integer keyuc) {
        //Dados.importa();
        Dados.lerEstadoMariaDb();
        ListaAvaliacaoDTO listaAvaliacaoDTO;

        if (Instituicao.login(numAluno, senha) != null) {
            listaAvaliacaoDTO = AvaliacaoService.getAvaliacoesAlunoUc(numAluno, keyuc);
            if (listaAvaliacaoDTO == null)
                return new ResponseEntity<>("Cadeira inexistente !!!", HttpStatus.OK);
            else {
                Dados.escreverEstado();
                return new ResponseEntity<>(listaAvaliacaoDTO, HttpStatus.OK);
            }
        }
        else
            return new ResponseEntity<>("Senha e número de aluno não coincidem !!!", HttpStatus.OK);
    }

    /*@RequestMapping(value = "/updateavaliacao/{numAluno}/{senha}/{keyavaliacao}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)*/

    /*public ResponseEntity<Object> updateAvaliacao(
            @RequestBody AvaliacaoDTO avaliacaoDTO, @PathVariable("numAluno") Long numAluno,
            @PathVariable("senha") Long senha, @PathVariable("keyavaliacao") Integer keyavaliacao) {

        //Dados.importa();
        Dados.lerEstado();

        if (Instituicao.login(numAluno, senha) != null) {
            try {
                AvaliacaoService.alteraAvaliacao(avaliacaoDTO, numAluno, keyavaliacao);
                return new ResponseEntity<>("Avaliação alterada", HttpStatus.OK);

            } catch (Exception e) {
                return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
            }
        }
        else
            return new ResponseEntity<>("Senha e número de aluno não coincidem !!!", HttpStatus.OK);

    }*/

}
