package cl.edu.service;

import java.util.UUID;

import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.CourseStatusFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.CourseStatusRequest;
import cl.edu.dto.response.CourseStatusResponse;

public interface CourseStatusService {

    /**
     * Crea un estado de curso.
     *
     * @param courseStatusRequest datos del estado
     * @return estado creado
     */
    public CourseStatusResponse create(CourseStatusRequest courseStatusRequest);

    /**
     * Filtra estados de curso de forma paginada.
     *
     * @param pageRequest datos del filtro y paginación
     * @return estados filtrados
     */
    public PageResponse<CourseStatusResponse> filter(PageRequest<CourseStatusFilterRequest> pageRequest);

    /**
     * Obtiene un estado de curso por su identificador.
     *
     * @param id identificador del estado
     * @return estado encontrado
     */
    public CourseStatusResponse getById(UUID id);

    /**
     * Actualiza completamente un estado de curso.
     *
     * @param id                  identificador del estado
     * @param courseStatusRequest datos del estado
     * @return estado actualizado
     */
    public CourseStatusResponse update(UUID id, CourseStatusRequest courseStatusRequest);

    /**
     * Actualiza parcialmente un estado de curso.
     *
     * @param id                        identificador del estado
     * @param courseStatusFilterRequest datos a actualizar
     * @return estado actualizado
     */
    public CourseStatusResponse patch(UUID id, CourseStatusFilterRequest courseStatusFilterRequest);

    /**
     * Elimina un estado de curso.
     *
     * @param id identificador del estado
     * @return resultado de la eliminación
     */
    public DeleteDto delete(UUID id);

}
