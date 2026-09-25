package cl.edu.service;

import java.util.UUID;

import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.CourseEvaluationFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.CourseEvaluationRequest;
import cl.edu.dto.response.CourseEvaluationResponse;

public interface CourseEvaluationService {

    /**
     * Crea una evaluación de curso.
     *
     * @param request datos de la evaluación
     * @return evaluación creada
     */
    public CourseEvaluationResponse create(CourseEvaluationRequest request);

    /**
     * Filtra evaluaciones de curso de forma paginada.
     *
     * @param pageRequest datos del filtro y paginación
     * @return evaluaciones filtradas
     */
    public PageResponse<CourseEvaluationResponse> filter(PageRequest<CourseEvaluationFilterRequest> pageRequest);

    /**
     * Obtiene una evaluación de curso por su identificador.
     *
     * @param id identificador de la evaluación
     * @return evaluación encontrada
     */
    public CourseEvaluationResponse getById(UUID id);

    /**
     * Actualiza completamente una evaluación de curso.
     *
     * @param id identificador de la evaluación
     * @param request datos de la evaluación
     * @return evaluación actualizada
     */
    public CourseEvaluationResponse update(UUID id, CourseEvaluationRequest request);

    /**
     * Actualiza parcialmente una evaluación de curso.
     *
     * @param id identificador de la evaluación
     * @param request datos a actualizar
     * @return evaluación actualizada
     */
    public CourseEvaluationResponse patch(UUID id, CourseEvaluationFilterRequest request);

    /**
     * Elimina una evaluación de curso.
     *
     * @param id identificador de la evaluación
     * @return resultado de la eliminación
     */
    public DeleteDto delete(UUID id);

}
