package cl.edu.service;

import java.util.UUID;

import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.UserCourseFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.UserCourseRequest;
import cl.edu.dto.response.UserCourseResponse;

public interface UserCourseService {

    /**
     * Crea una inscripción de curso.
     *
     * @param userCourseRequest datos de la inscripción
     * @return inscripción creada
     */
    public UserCourseResponse create(UserCourseRequest userCourseRequest);

    /**
     * Filtra inscripciones de curso de forma paginada.
     *
     * @param pageRequest datos del filtro y paginación
     * @return inscripciones filtradas
     */
    public PageResponse<UserCourseResponse> filter(PageRequest<UserCourseFilterRequest> pageRequest);

    /**
     * Obtiene una inscripción de curso por su identificador.
     *
     * @param id identificador de la inscripción
     * @return inscripción encontrada
     */
    public UserCourseResponse getById(UUID id);

    /**
     * Actualiza completamente una inscripción de curso.
     *
     * @param id                identificador de la inscripción
     * @param userCourseRequest datos de la inscripción
     * @return inscripción actualizada
     */
    public UserCourseResponse update(UUID id, UserCourseRequest userCourseRequest);

    /**
     * Actualiza parcialmente una inscripción de curso.
     *
     * @param id                      identificador de la inscripción
     * @param userCourseFilterRequest datos a actualizar
     * @return inscripción actualizada
     */
    public UserCourseResponse patch(UUID id, UserCourseFilterRequest userCourseFilterRequest);

    /**
     * Elimina una inscripción de curso.
     *
     * @param id identificador de la inscripción
     * @return resultado de la eliminación
     */
    public DeleteDto delete(UUID id);

}
