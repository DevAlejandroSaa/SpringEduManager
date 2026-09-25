package cl.edu.core.blaze.specification;

import com.blazebit.persistence.CriteriaBuilder;

import cl.edu.core.blaze.helper.BlazeSpecificationHelper;
import cl.edu.dto.filter.AcademicProgramFilterRequest;
import cl.edu.entity.AcademicProgram;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AcademicProgramSpecification {

    public static void apply(CriteriaBuilder<AcademicProgram> criteriaBuilder, AcademicProgramFilterRequest filter) {
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "code", filter.code());
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "name", filter.name());
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "description", filter.description());
        if (filter.statusId() != null) {
            criteriaBuilder.where("status.id").eq(filter.statusId());
        }
    }
    
}
