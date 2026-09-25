package cl.edu.core.blaze.helper;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.PagedList;

import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BlazeHelper {

    private final CriteriaBuilderFactory criteriaBuilderFactory;

    @PersistenceContext
    private EntityManager entityManager;

    public <T, F, R> PageResponse<R> findAllPaged(
            Class<T> entityClass, PageRequest<F> pageRequest,
            BiConsumer<CriteriaBuilder<T>, F> specification, Function<T, R> mapper) {

        CriteriaBuilder<T> criteriaBuilder = this.criteriaBuilderFactory.create(this.entityManager, entityClass);
        specification.accept(criteriaBuilder, pageRequest.data());
        PagedList<T> result = criteriaBuilder.page(pageRequest.page(), pageRequest.size()).getResultList();
        List<R> content = result.stream().map(mapper).toList();

        return new PageResponse<>(
                content,
                pageRequest.page(),
                pageRequest.size(),
                result.getTotalSize(),
                result.getTotalPages(),
                result.getPage() == 0,
                result.getPage() + 1 >= result.getTotalPages());
    }

}
