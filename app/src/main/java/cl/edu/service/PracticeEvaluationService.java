package cl.edu.service;

import java.util.UUID;

import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.PracticeEvaluationFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.PracticeEvaluationRequest;
import cl.edu.dto.response.PracticeEvaluationResponse;

public interface PracticeEvaluationService {

    /**
     * Crea una evaluación de práctica.
     *
     * @param practiceEvaluationRequest datos de la evaluación
     * @return evaluación creada
     */
    public PracticeEvaluationResponse create(PracticeEvaluationRequest practiceEvaluationRequest);

    /**
     * Filtra evaluaciones de práctica de forma paginada.
     *
     * @param pageRequest datos del filtro y paginación
     * @return evaluaciones filtradas
     */
    public PageResponse<PracticeEvaluationResponse> filter(PageRequest<PracticeEvaluationFilterRequest> pageRequest);

    /**
     * Obtiene una evaluación de práctica por su identificador.
     *
     * @param id identificador de la evaluación
     * @return evaluación encontrada
     */
    public PracticeEvaluationResponse getById(UUID id);

    /**
     * Actualiza completamente una evaluación de práctica.
     *
     * @param id                        identificador de la evaluación
     * @param practiceEvaluationRequest datos de la evaluación
     * @return evaluación actualizada
     */
    public PracticeEvaluationResponse update(UUID id, PracticeEvaluationRequest practiceEvaluationRequest);

    /**
     * Actualiza parcialmente una evaluación de práctica.
     *
     * @param id                              identificador de la evaluación
     * @param practiceEvaluationFilterRequest datos a actualizar
     * @return evaluación actualizada
     */
    public PracticeEvaluationResponse patch(UUID id, PracticeEvaluationFilterRequest practiceEvaluationFilterRequest);

    /**
     * Elimina una evaluación de práctica.
     *
     * @param id identificador de la evaluación
     * @return resultado de la eliminación
     */
    public DeleteDto delete(UUID id);

}
