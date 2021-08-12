package pt.isep.projectjavaws.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pt.isep.projectjavaws.dados.Dados;
import pt.isep.projectjavaws.dto.ListaUCsDTO;
import pt.isep.projectjavaws.dto.ListaUcPartialDTO;
import pt.isep.projectjavaws.service.UnidadeCurricularService;

@RestController
@RequestMapping("/api")
public class UnidadeCurricularController {

    @RequestMapping(value = "/listaucs",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getUCs() {
        try {
            ListaUCsDTO listaUCsDTO = UnidadeCurricularService.getListaUCs();

            return new ResponseEntity<>(listaUCsDTO, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/getlistaucpartial/{numAluno}/{senha}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getUCs(@PathVariable("numAluno") Long numAluno,
                                         @PathVariable("senha") long senha) {
        try {
            Dados.lerEstado();
            ListaUcPartialDTO listaUCs = UnidadeCurricularService.getListaUcPartialDTO(numAluno);

            return new ResponseEntity<>(listaUCs, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
