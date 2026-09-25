package cl.edu.service;

import java.util.UUID;

import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.UserInformationFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.UserInformationRequest;
import cl.edu.dto.response.UserInformationResponse;

public interface UserInformationService {

    /**
     * Crea un usuario.
     *
     * @param userInformationRequest datos del usuario
     * @return usuario creado
     */
    public UserInformationResponse create(UserInformationRequest userInformationRequest);

    /**
     * Filtra usuarios de forma paginada.
     *
     * @param pageRequest datos del filtro y paginación
     * @return usuarios filtrados
     */
    public PageResponse<UserInformationResponse> filter(PageRequest<UserInformationFilterRequest> pageRequest);

    /**
     * Obtiene un usuario por su identificador.
     *
     * @param id identificador del usuario
     * @return usuario encontrado
     */
    public UserInformationResponse getById(UUID id);

    /**
     * Actualiza completamente un usuario.
     *
     * @param id                     identificador del usuario
     * @param userInformationRequest datos del usuario
     * @return usuario actualizado
     */
    public UserInformationResponse update(UUID id, UserInformationRequest userInformationRequest);

    /**
     * Actualiza parcialmente un usuario.
     *
     * @param id                           identificador del usuario
     * @param userInformationFilterRequest datos a actualizar
     * @return usuario actualizado
     */
    public UserInformationResponse patch(UUID id, UserInformationFilterRequest userInformationFilterRequest);

    /**
     * Elimina un usuario.
     *
     * @param id identificador del usuario
     * @return resultado de la eliminación
     */
    public DeleteDto delete(UUID id);

}
