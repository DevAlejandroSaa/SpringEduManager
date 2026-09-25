package cl.edu.core.blaze.specification;

import com.blazebit.persistence.CriteriaBuilder;

import cl.edu.dto.filter.UserCourseFilterRequest;
import cl.edu.entity.UserCourse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserCourseSpecification {

    public static void apply(CriteriaBuilder<UserCourse> criteriaBuilder, UserCourseFilterRequest filter) {
        if (filter.studentUserId() != null) {
            criteriaBuilder.where("studentUser.id").eq(filter.studentUserId());
        }
        if (filter.courseOfferingId() != null) {
            criteriaBuilder.where("courseOffering.id").eq(filter.courseOfferingId());
        }
    }
    
}
