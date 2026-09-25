package cl.edu.service;

import java.util.UUID;

import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.CourseClassFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.CourseClassRequest;
import cl.edu.dto.response.CourseClassResponse;

public interface CourseClassService {

    /**
     * Crea una clase de curso.
     *
     * @param courseClassRequest datos de la clase
     * @return clase creada
     */
    public CourseClassResponse create(CourseClassRequest courseClassRequest);

    /**
     * Filtra clases de curso de forma paginada.
     *
     * @param pageRequest datos del filtro y paginación
     * @return clases filtradas
     */
    public PageResponse<CourseClassResponse> filter(PageRequest<CourseClassFilterRequest> pageRequest);

    /**
     * Obtiene una clase de curso por su identificador.
     *
     * @param id identificador de la clase
     * @return clase encontrada
     */
    public CourseClassResponse getById(UUID id);

    /**
     * Actualiza completamente una clase de curso.
     *
     * @param id                 identificador de la clase
     * @param courseClassRequest datos de la clase
     * @return clase actualizada
     */
    public CourseClassResponse update(UUID id, CourseClassRequest courseClassRequest);

    /**
     * Actualiza parcialmente una clase de curso.
     *
     * @param id                       identificador de la clase
     * @param courseClassFilterRequest datos a actualizar
     * @return clase actualizada
     */
    public CourseClassResponse patch(UUID id, CourseClassFilterRequest courseClassFilterRequest);

    /**
     * Elimina una clase de curso.
     *
     * @param id identificador de la clase
     * @return resultado de la eliminación
     */
    public DeleteDto delete(UUID id);

}
