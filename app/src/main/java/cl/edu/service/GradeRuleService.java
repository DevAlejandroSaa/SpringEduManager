package cl.edu.service;

import java.util.UUID;

import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.GradeRuleFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.GradeRuleRequest;
import cl.edu.dto.response.GradeRuleResponse;

public interface GradeRuleService {

    /**
     * Crea una regla de calificación.
     *
     * @param gradeRuleRequest datos de la regla
     * @return regla creada
     */
    public GradeRuleResponse create(GradeRuleRequest gradeRuleRequest);

    /**
     * Filtra reglas de calificación de forma paginada.
     *
     * @param pageRequest datos del filtro y paginación
     * @return reglas filtradas
     */
    public PageResponse<GradeRuleResponse> filter(PageRequest<GradeRuleFilterRequest> pageRequest);

    /**
     * Obtiene una regla de calificación por su identificador.
     *
     * @param id identificador de la regla
     * @return regla encontrada
     */
    public GradeRuleResponse getById(UUID id);

    /**
     * Actualiza completamente una regla de calificación.
     *
     * @param id               identificador de la regla
     * @param gradeRuleRequest datos de la regla
     * @return regla actualizada
     */
    public GradeRuleResponse update(UUID id, GradeRuleRequest gradeRuleRequest);

    /**
     * Actualiza parcialmente una regla de calificación.
     *
     * @param id                     identificador de la regla
     * @param gradeRuleFilterRequest datos a actualizar
     * @return regla actualizada
     */
    public GradeRuleResponse patch(UUID id, GradeRuleFilterRequest gradeRuleFilterRequest);

    /**
     * Elimina una regla de calificación.
     *
     * @param id identificador de la regla
     * @return resultado de la eliminación
     */
    public DeleteDto delete(UUID id);

}
