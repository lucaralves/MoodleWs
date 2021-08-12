package pt.isep.projectjavaws.service;

import pt.isep.projectjavaws.dados.Dados;
import pt.isep.projectjavaws.dto.Converter;
import pt.isep.projectjavaws.dto.ListaTurmasDTO;
import pt.isep.projectjavaws.dto.TurmaDTO;
import pt.isep.projectjavaws.modelo.Instituicao;
import pt.isep.projectjavaws.modelo.Turma;

import java.util.ArrayList;
import java.util.Iterator;

public class TurmaService {

    public static ListaTurmasDTO getListaTurmas() {
        Dados.lerEstado();

        Iterator<Turma> iterator = Instituicao.getListaTurmas().values().iterator();
        ArrayList<Turma> listaTurmas = new ArrayList<>();
        while (iterator.hasNext()) {
            listaTurmas.add(iterator.next());
        }

        ArrayList<TurmaDTO> listaTurmasDTO = Converter.convertListaTurmas(listaTurmas);

        ListaTurmasDTO listaTurmasDTO1 = new ListaTurmasDTO(listaTurmasDTO);

        return listaTurmasDTO1;
    }
}
