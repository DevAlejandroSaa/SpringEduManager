package cl.edu.service;

import java.util.UUID;

import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.PracticeFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.PracticeRequest;
import cl.edu.dto.response.PracticeResponse;

public interface PracticeService {

    /**
     * Crea una práctica.
     *
     * @param request datos de la práctica
     * @return práctica creada
     */
    public PracticeResponse create(PracticeRequest request);

    /**
     * Filtra prácticas de forma paginada.
     *
     * @param pageRequest datos del filtro y paginación
     * @return prácticas filtradas
     */
    public PageResponse<PracticeResponse> filter(PageRequest<PracticeFilterRequest> pageRequest);

    /**
     * Obtiene una práctica por su identificador.
     *
     * @param id identificador de la práctica
     * @return práctica encontrada
     */
    public PracticeResponse getById(UUID id);

    /**
     * Actualiza completamente una práctica.
     *
     * @param id identificador de la práctica
     * @param request datos de la práctica
     * @return práctica actualizada
     */
    public PracticeResponse update(UUID id, PracticeRequest request);

    /**
     * Actualiza parcialmente una práctica.
     *
     * @param id identificador de la práctica
     * @param request datos a actualizar
     * @return práctica actualizada
     */
    public PracticeResponse patch(UUID id, PracticeFilterRequest request);

    /**
     * Elimina una práctica.
     *
     * @param id identificador de la práctica
     * @return resultado de la eliminación
     */
    public DeleteDto delete(UUID id);

}
