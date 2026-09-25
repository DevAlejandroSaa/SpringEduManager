package cl.edu.service;

import java.util.UUID;

import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.AccessFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.AccessRequest;
import cl.edu.dto.response.AccessResponse;

public interface AccessService {

    /**
     * Crea un acceso.
     *
     * @param accessRequest datos del acceso
     * @return acceso creado
     */
    public AccessResponse create(AccessRequest accessRequest);

    /**
     * Filtra accesos de forma paginada.
     *
     * @param pageRequest datos del filtro y paginación
     * @return accesos filtrados
     */
    public PageResponse<AccessResponse> filter(PageRequest<AccessFilterRequest> pageRequest);

    /**
     * Obtiene un acceso por su identificador.
     *
     * @param id identificador del acceso
     * @return acceso encontrado
     */
    public AccessResponse getById(UUID id);

    /**
     * Actualiza completamente un acceso.
     *
     * @param id            identificador del acceso
     * @param accessRequest datos del acceso
     * @return acceso actualizado
     */
    public AccessResponse update(UUID id, AccessRequest accessRequest);

    /**
     * Actualiza parcialmente un acceso.
     *
     * @param id                  identificador del acceso
     * @param accessFilterRequest datos a actualizar
     * @return acceso actualizado
     */
    public AccessResponse patch(UUID id, AccessFilterRequest accessFilterRequest);

    /**
     * Elimina un acceso.
     *
     * @param id identificador del acceso
     * @return resultado de la eliminación
     */
    public DeleteDto delete(UUID id);

}
