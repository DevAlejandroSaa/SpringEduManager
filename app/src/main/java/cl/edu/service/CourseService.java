package cl.edu.service;

import java.util.UUID;

import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.CourseFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.CourseRequest;
import cl.edu.dto.response.CourseResponse;

public interface CourseService {

    /**
     * Crea un curso.
     *
     * @param request datos del curso
     * @return curso creado
     */
    public CourseResponse create(CourseRequest request);

    /**
     * Filtra cursos de forma paginada.
     *
     * @param pageRequest datos del filtro y paginación
     * @return cursos filtrados
     */
    public PageResponse<CourseResponse> filter(PageRequest<CourseFilterRequest> pageRequest);

    /**
     * Obtiene un curso por su identificador.
     *
     * @param id identificador del curso
     * @return curso encontrado
     */
    public CourseResponse getById(UUID id);

    /**
     * Actualiza completamente un curso.
     *
     * @param id identificador del curso
     * @param request datos del curso
     * @return curso actualizado
     */
    public CourseResponse update(UUID id, CourseRequest request);

    /**
     * Actualiza parcialmente un curso.
     *
     * @param id identificador del curso
     * @param request datos a actualizar
     * @return curso actualizado
    */
    public CourseResponse patch(UUID id, CourseFilterRequest request);

    /**
     * Elimina un curso.
     *
     * @param id identificador del curso
     * @return resultado de la eliminación
     */
    public DeleteDto delete(UUID id);

}
