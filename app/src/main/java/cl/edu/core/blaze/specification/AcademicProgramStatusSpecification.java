package cl.edu.core.blaze.specification;

import com.blazebit.persistence.CriteriaBuilder;

import cl.edu.dto.AcademicProgramStatusDto;
import cl.edu.entity.AcademicProgramStatus;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AcademicProgramStatusSpecification {

    public void apply(CriteriaBuilder<AcademicProgramStatus> criteriaBuilder, AcademicProgramStatusDto filter) {
        if (filter == null) {
            return;
        }

        if (filter.id() != null) {
            criteriaBuilder.where("id").eq(filter.id());
        }

        criteriaBuilder = applyLike(criteriaBuilder, "code", filter.code());
        criteriaBuilder = applyLike(criteriaBuilder, "name", filter.name());
        criteriaBuilder = applyLike(criteriaBuilder, "description", filter.description());
    }

    private boolean isValid(String value) {
        return value != null && !value.isBlank();
    }

    private CriteriaBuilder<AcademicProgramStatus> applyLike(
            CriteriaBuilder<AcademicProgramStatus> criteriaBuilder, String attribute, String value) {
        return isValid(value)
                ? criteriaBuilder.where(attribute)
                        .like()
                        .value("%" + value.trim() + "%")
                        .noEscape()
                : criteriaBuilder;
    }

}
