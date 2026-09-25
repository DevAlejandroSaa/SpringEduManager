package cl.edu.service;

import java.util.UUID;

import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.AccessTokenFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.AccessTokenRequest;
import cl.edu.dto.response.AccessTokenResponse;

public interface AccessTokenService {

    /**
     * Crea un token de acceso.
     *
     * @param accessTokenRequest datos del token
     * @return token creado
     */
    public AccessTokenResponse create(AccessTokenRequest accessTokenRequest);

    /**
     * Filtra tokens de acceso de forma paginada.
     *
     * @param pageRequest datos del filtro y paginación
     * @return tokens filtrados
     */
    public PageResponse<AccessTokenResponse> filter(PageRequest<AccessTokenFilterRequest> pageRequest);

    /**
     * Obtiene un token de acceso por su identificador.
     *
     * @param id identificador del token
     * @return token encontrado
     */
    public AccessTokenResponse getById(UUID id);

    /**
     * Actualiza completamente un token de acceso.
     *
     * @param id                 identificador del token
     * @param accessTokenRequest datos del token
     * @return token actualizado
     */
    public AccessTokenResponse update(UUID id, AccessTokenRequest accessTokenRequest);

    /**
     * Actualiza parcialmente un token de acceso.
     *
     * @param id                       identificador del token
     * @param accessTokenFilterRequest datos a actualizar
     * @return token actualizado
     */
    public AccessTokenResponse patch(UUID id, AccessTokenFilterRequest accessTokenFilterRequest);

    /**
     * Elimina un token de acceso.
     *
     * @param id identificador del token
     * @return resultado de la eliminación
     */
    public DeleteDto delete(UUID id);

}
