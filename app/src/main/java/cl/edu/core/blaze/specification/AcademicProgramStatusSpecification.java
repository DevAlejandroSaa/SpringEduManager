package cl.edu.core.blaze.specification;

import com.blazebit.persistence.CriteriaBuilder;

import cl.edu.core.blaze.helper.BlazeSpecificationHelper;
import cl.edu.dto.filter.AcademicProgramStatusFilterRequest;
import cl.edu.entity.AcademicProgramStatus;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AcademicProgramStatusSpecification {

    public void apply(CriteriaBuilder<AcademicProgramStatus> criteriaBuilder, AcademicProgramStatusFilterRequest filter) {
        criteriaBuilder = BlazeSpecificationHelper.applyLike(criteriaBuilder, "code", filter.code());
        criteriaBuilder = BlazeSpecificationHelper.applyLike(criteriaBuilder, "name", filter.name());
        criteriaBuilder = BlazeSpecificationHelper.applyLike(criteriaBuilder, "description", filter.description());
    }

}
