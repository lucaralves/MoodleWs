package pt.isep.projectjavaws.service;

import pt.isep.projectjavaws.dto.InstituicaoDTO;
import pt.isep.projectjavaws.modelo.Instituicao;

public class InstituicaoService {

    public static InstituicaoDTO getInstituicao() {
        InstituicaoDTO instituicaoDTO = new InstituicaoDTO(Instituicao.getNome(),
                Instituicao.getCodigo(), Instituicao.morada, Instituicao.getNif());

        return instituicaoDTO;
    }

}
