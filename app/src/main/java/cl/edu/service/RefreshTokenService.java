package cl.edu.service;

import java.util.UUID;

import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.RefreshTokenFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.RefreshTokenRequest;
import cl.edu.dto.response.RefreshTokenResponse;

public interface RefreshTokenService {

    /**
     * Crea un token de actualización.
     *
     * @param refreshTokenRequest datos del token
     * @return token creado
     */
    public RefreshTokenResponse create(RefreshTokenRequest refreshTokenRequest);

    /**
     * Filtra tokens de actualización de forma paginada.
     *
     * @param pageRequest datos del filtro y paginación
     * @return tokens filtrados
     */
    public PageResponse<RefreshTokenResponse> filter(PageRequest<RefreshTokenFilterRequest> pageRequest);

    /**
     * Obtiene un token de actualización por su identificador.
     *
     * @param id identificador del token
     * @return token encontrado
     */
    public RefreshTokenResponse getById(UUID id);

    /**
     * Actualiza completamente un token de actualización.
     *
     * @param id                  identificador del token
     * @param refreshTokenRequest datos del token
     * @return token actualizado
     */
    public RefreshTokenResponse update(UUID id, RefreshTokenRequest refreshTokenRequest);

    /**
     * Actualiza parcialmente un token de actualización.
     *
     * @param id                        identificador del token
     * @param refreshTokenFilterRequest datos a actualizar
     * @return token actualizado
     */
    public RefreshTokenResponse patch(UUID id, RefreshTokenFilterRequest refreshTokenFilterRequest);

    /**
     * Elimina un token de actualización.
     *
     * @param id identificador del token
     * @return resultado de la eliminación
     */
    public DeleteDto delete(UUID id);

}
