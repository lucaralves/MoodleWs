package pt.isep.projectjavaws.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pt.isep.projectjavaws.dto.ListaCursosDTO;
import pt.isep.projectjavaws.service.CursoService;

@RestController
@RequestMapping("/api")
public class CursoController {

    @RequestMapping(value = "/listacursos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getCursos() {
        try {
            ListaCursosDTO listaCursosDTO = CursoService.getListaCursos();

            return new ResponseEntity<>(listaCursosDTO, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
