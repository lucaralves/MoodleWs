package pt.isep.projectjavaws.service;

import pt.isep.projectjavaws.dados.Dados;
import pt.isep.projectjavaws.dto.Converter;
import pt.isep.projectjavaws.dto.CursoDTO;
import pt.isep.projectjavaws.dto.ListaCursosDTO;
import pt.isep.projectjavaws.modelo.Curso;
import pt.isep.projectjavaws.modelo.Instituicao;

import java.util.ArrayList;
import java.util.Iterator;

public class CursoService {

    public static ListaCursosDTO getListaCursos() {
        Dados.lerEstado();

        Iterator<Curso> iterator = Instituicao.getListaCursos().values().iterator();
        ArrayList<Curso> listaCursos = new ArrayList<>();
        while (iterator.hasNext()) {
            listaCursos.add(iterator.next());
        }

        ArrayList<CursoDTO> listaCursosDTO = Converter.convertListaCursos(listaCursos);

        ListaCursosDTO listaCursosDTO1 = new ListaCursosDTO(listaCursosDTO);

        return listaCursosDTO1;
    }
}
