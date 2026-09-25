package cl.edu.dto.pagination;

public record PageRequest<T>(
        T data,
        int page,
        int size) {
}
