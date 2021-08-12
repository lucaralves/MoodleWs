package pt.isep.projectjavaws.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pt.isep.projectjavaws.dados.Dados;
import pt.isep.projectjavaws.dto.*;
import pt.isep.projectjavaws.modelo.Instituicao;
import pt.isep.projectjavaws.service.AlunoService;

@RestController
@RequestMapping("/api")
public class AlunoController {

    @RequestMapping(value = "/login/{numAluno}/{senha}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getAlunoPartial(@PathVariable("numAluno") Long numAluno,
                                           @PathVariable("senha") long senha) {
        Dados.lerEstadoMariaDb();
        AlunoPartialDTO alunoDTO;
        if (Instituicao.login(numAluno, senha) != null) {
            alunoDTO = AlunoService.getAlunoPartial(numAluno);
        }
        else
            return new ResponseEntity<>("Senha e número de aluno não coincidem !!!", HttpStatus.CONFLICT);

        Dados.escreverEstado();

        return new ResponseEntity<>(alunoDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/listaaluno/{numAluno}/{senha}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getAluno(@PathVariable("numAluno") Long numAluno,
                                                    @PathVariable("senha") long senha) {
        Dados.lerEstadoMariaDb();
        AlunoDTO alunoDTO;
        if (Instituicao.login(numAluno, senha) != null) {
            alunoDTO = AlunoService.getAluno(numAluno);
        }
        else
            return new ResponseEntity<>("Senha e número de aluno não coincidem !!!", HttpStatus.CONFLICT);

        return new ResponseEntity<>(alunoDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/listaalunos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getAlunos() {
        try {
            Dados.lerEstado();

            ListaAlunosDTO listaAlunosDTO = AlunoService.getListaAlunos();

            return new ResponseEntity<>(listaAlunosDTO, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/listaalunosucs",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getAlunosUCs() {
        try {
            Dados.lerEstadoMariaDb();

            ListaUcsAlunoGeralDTO listaUcsAlunoGeralDTO = AlunoService.getListaUcAlunos();

            return new ResponseEntity<>(listaUcsAlunoGeralDTO, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
