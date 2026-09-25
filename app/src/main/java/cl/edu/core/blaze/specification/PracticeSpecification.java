package cl.edu.core.blaze.specification;

import com.blazebit.persistence.CriteriaBuilder;

import cl.edu.core.blaze.helper.BlazeSpecificationHelper;
import cl.edu.dto.filter.PracticeFilterRequest;
import cl.edu.entity.Practice;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PracticeSpecification {

    public static void apply(CriteriaBuilder<Practice> criteriaBuilder, PracticeFilterRequest filter) {
        if (filter.academicProgramId() != null) {
            criteriaBuilder.where("academicProgram.id").eq(filter.academicProgramId());
        }

        BlazeSpecificationHelper.applyLike(criteriaBuilder, "code", filter.code());
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "name", filter.name());
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "description", filter.description());

        if (filter.statusId() != null) {
            criteriaBuilder.where("status.id").eq(filter.statusId());
        }
    }

}
