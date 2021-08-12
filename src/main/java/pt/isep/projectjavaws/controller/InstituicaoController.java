package pt.isep.projectjavaws.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pt.isep.projectjavaws.dto.InstituicaoDTO;
import pt.isep.projectjavaws.service.InstituicaoService;

@RestController
@RequestMapping("/api")
public class InstituicaoController {

    @RequestMapping(value = "/instituicao",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getInstituicao() {
        try {
            InstituicaoDTO instituicao = InstituicaoService.getInstituicao();

            return new ResponseEntity<>(instituicao, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
