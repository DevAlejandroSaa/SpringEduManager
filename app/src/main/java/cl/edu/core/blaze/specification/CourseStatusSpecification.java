package cl.edu.core.blaze.specification;

import com.blazebit.persistence.CriteriaBuilder;

import cl.edu.core.blaze.helper.BlazeSpecificationHelper;
import cl.edu.dto.filter.CourseStatusFilterRequest;
import cl.edu.entity.CourseStatus;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CourseStatusSpecification {

    public static void apply(CriteriaBuilder<CourseStatus> criteriaBuilder, CourseStatusFilterRequest filter) {
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "code", filter.code());
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "name", filter.name());
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "description", filter.description());
    }
    
}
