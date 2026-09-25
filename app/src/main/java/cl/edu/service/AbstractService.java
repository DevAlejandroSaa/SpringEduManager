package cl.edu.service;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.core.exception.custom.CustomNotFoundException;

public abstract class AbstractService {

    /**
     * Busca una entidad por su identificador y lanza una excepción si no existe.
     *
     * @param repository repositorio utilizado para buscar la entidad
     * @param id identificador de la entidad
     * @param message mensaje de la excepción si la entidad no existe
     * @param <T> tipo de la entidad
     * @return entidad encontrada
     * @throws CustomNotFoundException si la entidad no existe
     */
    protected <T> T findEntityById(JpaRepository<T, UUID> repository, UUID id, String message) {
        return repository.findById(id).orElseThrow(() -> new CustomNotFoundException(message));
    }
    
}
