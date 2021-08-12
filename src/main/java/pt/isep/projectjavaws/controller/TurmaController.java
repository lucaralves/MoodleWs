package pt.isep.projectjavaws.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pt.isep.projectjavaws.dto.ListaTurmasDTO;
import pt.isep.projectjavaws.service.TurmaService;

@RestController
@RequestMapping("/api")
public class TurmaController {

    @RequestMapping(value = "/listaturmas",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getTurmas() {
        try {
            ListaTurmasDTO listaTurmasDTO = TurmaService.getListaTurmas();

            return new ResponseEntity<>(listaTurmasDTO, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
