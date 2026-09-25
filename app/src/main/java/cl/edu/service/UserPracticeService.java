package cl.edu.service;

import java.util.UUID;

import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.UserPracticeFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.UserPracticeRequest;
import cl.edu.dto.response.UserPracticeResponse;

public interface UserPracticeService {

    /**
     * Crea una práctica de estudiante.
     *
     * @param request datos de la práctica
     * @return práctica creada
     */
    public UserPracticeResponse create(UserPracticeRequest request);

    /**
     * Filtra prácticas de estudiantes de forma paginada.
     *
     * @param pageRequest datos del filtro y paginación
     * @return prácticas filtradas
     */
    public PageResponse<UserPracticeResponse> filter(PageRequest<UserPracticeFilterRequest> pageRequest);

    /**
     * Obtiene una práctica de estudiante por su identificador.
     *
     * @param id identificador de la práctica
     * @return práctica encontrada
     */
    public UserPracticeResponse getById(UUID id);

    /**
     * Actualiza completamente una práctica de estudiante.
     *
     * @param id identificador de la práctica
     * @param request datos de la práctica
     * @return práctica actualizada
     */
    public UserPracticeResponse update(UUID id, UserPracticeRequest request);

    /**
     * Actualiza parcialmente una práctica de estudiante.
     *
     * @param id identificador de la práctica
     * @param request datos a actualizar
     * @return práctica actualizada
     */
    public UserPracticeResponse patch(UUID id, UserPracticeFilterRequest request);

    /**
     * Elimina una práctica de estudiante.
     *
     * @param id identificador de la práctica
     * @return resultado de la eliminación
     */
    public DeleteDto delete(UUID id);

}
