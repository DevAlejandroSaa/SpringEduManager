package cl.edu.service;

import java.util.UUID;

import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.CourseOfferingFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.CourseOfferingRequest;
import cl.edu.dto.response.CourseOfferingResponse;

public interface CourseOfferingService {

    /**
     * Crea una oferta de curso.
     *
     * @param courseOfferingRequest datos de la oferta
     * @return oferta creada
     */
    public CourseOfferingResponse create(CourseOfferingRequest courseOfferingRequest);

    /**
     * Filtra ofertas de curso de forma paginada.
     *
     * @param pageRequest datos del filtro y paginación
     * @return ofertas filtradas
     */
    public PageResponse<CourseOfferingResponse> filter(PageRequest<CourseOfferingFilterRequest> pageRequest);

    /**
     * Obtiene una oferta de curso por su identificador.
     *
     * @param id identificador de la oferta
     * @return oferta encontrada
     */
    public CourseOfferingResponse getById(UUID id);

    /**
     * Actualiza completamente una oferta de curso.
     *
     * @param id                    identificador de la oferta
     * @param courseOfferingRequest datos de la oferta
     * @return oferta actualizada
     */
    public CourseOfferingResponse update(UUID id, CourseOfferingRequest courseOfferingRequest);

    /**
     * Actualiza parcialmente una oferta de curso.
     *
     * @param id                          identificador de la oferta
     * @param courseOfferingFilterRequest datos a actualizar
     * @return oferta actualizada
     */
    public CourseOfferingResponse patch(UUID id, CourseOfferingFilterRequest courseOfferingFilterRequest);

    /**
     * Elimina una oferta de curso.
     *
     * @param id identificador de la oferta
     * @return resultado de la eliminación
     */
    public DeleteDto delete(UUID id);

}
