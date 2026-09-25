package cl.edu.service;

import java.util.UUID;

import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.AcademicProgramStatusFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.AcademicProgramStatusRequest;
import cl.edu.dto.response.AcademicProgramStatusResponse;

public interface AcademicProgramStatusService {

    /**
     * Crea un estado de programa académico.
     *
     * @param request datos del estado
     * @return estado creado
     */
    public AcademicProgramStatusResponse create(AcademicProgramStatusRequest request);

    /**
     * Filtra estados de programa académico de forma paginada.
     *
     * @param pageRequest datos del filtro y paginación
     * @return estados filtrados
     */
    public PageResponse<AcademicProgramStatusResponse> filter(PageRequest<AcademicProgramStatusFilterRequest> pageRequest);

    /**
     * Obtiene un estado de programa académico por su identificador.
     *
     * @param id identificador del estado
     * @return estado encontrado
     */
    public AcademicProgramStatusResponse getById(UUID id);

    /**
     * Actualiza completamente un estado de programa académico.
     *
     * @param id identificador del estado
     * @param request datos del estado
     * @return estado actualizado
     */
    public AcademicProgramStatusResponse update(UUID id, AcademicProgramStatusRequest request);

    /**
     * Actualiza parcialmente un estado de programa académico.
     *
     * @param id identificador del estado
     * @param request datos a actualizar
     * @return estado actualizado
     */
    public AcademicProgramStatusResponse patch(UUID id, AcademicProgramStatusFilterRequest request);

    /**
     * Elimina un estado de programa académico.
     *
     * @param id identificador del estado
     * @return resultado de la eliminación
     */
    public DeleteDto delete(UUID id);

}
