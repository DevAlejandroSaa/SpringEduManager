package cl.edu.service;

import java.util.UUID;

import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.PracticeStatusFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.PracticeStatusRequest;
import cl.edu.dto.response.PracticeStatusResponse;

public interface PracticeStatusService {

    /**
     * Crea un estado de práctica.
     *
     * @param request datos del estado
     * @return estado creado
     */
    public PracticeStatusResponse create(PracticeStatusRequest request);

    /**
     * Filtra estados de práctica de forma paginada.
     *
     * @param pageRequest datos del filtro y paginación
     * @return estados filtrados
     */
    public PageResponse<PracticeStatusResponse> filter(PageRequest<PracticeStatusFilterRequest> pageRequest);

    /**
     * Obtiene un estado de práctica por su identificador.
     *
     * @param id identificador del estado
     * @return estado encontrado
     */
    public PracticeStatusResponse getById(UUID id);

    /**
     * Actualiza completamente un estado de práctica.
     *
     * @param id identificador del estado
     * @param request datos del estado
     * @return estado actualizado
     */
    public PracticeStatusResponse update(UUID id, PracticeStatusRequest request);

    /**
     * Actualiza parcialmente un estado de práctica.
     *
     * @param id identificador del estado
     * @param request datos a actualizar
     * @return estado actualizado
     */
    public PracticeStatusResponse patch(UUID id, PracticeStatusFilterRequest request);

    /**
     * Elimina un estado de práctica.
     *
     * @param id identificador del estado
     * @return resultado de la eliminación
     */
    public DeleteDto delete(UUID id);

}
