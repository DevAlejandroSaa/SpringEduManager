package cl.edu.service;

import java.util.UUID;

import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.RoleFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.RoleRequest;
import cl.edu.dto.response.RoleResponse;

public interface RoleService {

    /**
     * Crea un nuevo rol.
     *
     * @param roleRequest datos del rol a crear
     * @return información del rol creado
     */
    public RoleResponse create(RoleRequest roleRequest);

    /**
     * Filtra los roles de forma paginada.
     *
     * @param pageRequest datos del filtro y parámetros de paginación
     * @return resultado paginado de los roles encontrados
     */
    public PageResponse<RoleResponse> filter(PageRequest<RoleFilterRequest> pageRequest);

    /**
     * Obtiene un rol por su identificador.
     *
     * @param id identificador del rol
     * @return información del rol encontrado
     */
    public RoleResponse getById(UUID id);

    /**
     * Actualiza completamente un rol existente.
     *
     * @param id          identificador del rol
     * @param roleRequest datos actualizados del rol
     * @return información del rol actualizado
     */
    public RoleResponse update(UUID id, RoleRequest roleRequest);

    /**
     * Actualiza parcialmente un rol existente.
     *
     * @param id                identificador del rol
     * @param roleFilterRequest datos del rol a actualizar
     * @return información del rol actualizado
     */
    public RoleResponse patch(UUID id, RoleFilterRequest roleFilterRequest);

    /**
     * Elimina un rol por su identificador.
     *
     * @param id identificador del rol
     * @return mensaje correspondiente al resultado de la eliminación
     */
    public DeleteDto delete(UUID id);

}
