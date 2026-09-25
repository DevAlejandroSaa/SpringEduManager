package cl.edu.core.blaze.specification;

import com.blazebit.persistence.CriteriaBuilder;

import cl.edu.dto.filter.CourseEvaluationFilterRequest;
import cl.edu.entity.CourseEvaluation;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CourseEvaluationSpecification {

    public static void apply(CriteriaBuilder<CourseEvaluation> criteriaBuilder, CourseEvaluationFilterRequest filter) {
        if (filter.userCourseId() != null) {
            criteriaBuilder.where("userCourse.id").eq(filter.userCourseId());
        }
        if (filter.grade() != null) {
            criteriaBuilder.where("grade").eq(filter.grade());
        }
    }
    
}
