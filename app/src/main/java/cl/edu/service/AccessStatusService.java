package cl.edu.service;

import java.util.UUID;

import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.AccessStatusFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.AccessStatusRequest;
import cl.edu.dto.response.AccessStatusResponse;

public interface AccessStatusService {

    /**
     * Crea un estado de acceso.
     *
     * @param accessStatusRequest datos del estado
     * @return estado creado
     */
    public AccessStatusResponse create(AccessStatusRequest accessStatusRequest);

    /**
     * Filtra estados de acceso de forma paginada.
     *
     * @param pageRequest datos del filtro y paginación
     * @return estados filtrados
     */
    public PageResponse<AccessStatusResponse> filter(PageRequest<AccessStatusFilterRequest> pageRequest);

    /**
     * Obtiene un estado de acceso por su identificador.
     *
     * @param id identificador del estado
     * @return estado encontrado
     */
    public AccessStatusResponse getById(UUID id);

    /**
     * Actualiza completamente un estado de acceso.
     *
     * @param id                  identificador del estado
     * @param accessStatusRequest datos del estado
     * @return estado actualizado
     */
    public AccessStatusResponse update(UUID id, AccessStatusRequest accessStatusRequest);

    /**
     * Actualiza parcialmente un estado de acceso.
     *
     * @param id                        identificador del estado
     * @param accessStatusFilterRequest datos a actualizar
     * @return estado actualizado
     */
    public AccessStatusResponse patch(UUID id, AccessStatusFilterRequest accessStatusFilterRequest);

    /**
     * Elimina un estado de acceso.
     *
     * @param id identificador del estado
     * @return resultado de la eliminación
     */
    public DeleteDto delete(UUID id);

}
