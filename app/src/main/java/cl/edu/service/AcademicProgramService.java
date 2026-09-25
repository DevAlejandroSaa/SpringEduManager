package cl.edu.service;

import java.util.UUID;

import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.AcademicProgramFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.AcademicProgramRequest;
import cl.edu.dto.response.AcademicProgramResponse;

public interface AcademicProgramService {

    /**
     * Crea un programa académico.
     *
     * @param academicProgramRequest datos del programa
     * @return programa creado
     */
    public AcademicProgramResponse create(AcademicProgramRequest academicProgramRequest);

    /**
     * Filtra programas académicos de forma paginada.
     *
     * @param pageRequest datos del filtro y paginación
     * @return programas filtrados
     */
    public PageResponse<AcademicProgramResponse> filter(PageRequest<AcademicProgramFilterRequest> pageRequest);

    /**
     * Obtiene un programa académico por su identificador.
     *
     * @param id identificador del programa
     * @return programa encontrado
     */
    public AcademicProgramResponse getById(UUID id);

    /**
     * Actualiza completamente un programa académico.
     *
     * @param id                     identificador del programa
     * @param academicProgramRequest datos del programa
     * @return programa actualizado
     */
    public AcademicProgramResponse update(UUID id, AcademicProgramRequest academicProgramRequest);

    /**
     * Actualiza parcialmente un programa académico.
     *
     * @param id                           identificador del programa
     * @param academicProgramFilterRequest datos a actualizar
     * @return programa actualizado
     */
    public AcademicProgramResponse patch(UUID id, AcademicProgramFilterRequest academicProgramFilterRequest);

    /**
     * Elimina un programa académico.
     *
     * @param id identificador del programa
     * @return resultado de la eliminación
     */
    public DeleteDto delete(UUID id);

}
