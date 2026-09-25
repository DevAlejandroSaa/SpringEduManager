package cl.edu.core.blaze.specification;

import com.blazebit.persistence.CriteriaBuilder;

import cl.edu.core.blaze.helper.BlazeSpecificationHelper;
import cl.edu.dto.filter.CourseFilterRequest;
import cl.edu.entity.Course;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CourseSpecification {

    public static void apply(CriteriaBuilder<Course> criteriaBuilder, CourseFilterRequest filter) {
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
