package cl.edu.core.blaze.specification;

import com.blazebit.persistence.CriteriaBuilder;

import cl.edu.dto.filter.CourseOfferingFilterRequest;
import cl.edu.entity.CourseOffering;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CourseOfferingSpecification {

    public static void apply(CriteriaBuilder<CourseOffering> criteriaBuilder, CourseOfferingFilterRequest filter) {
        if (filter.courseId() != null) {
            criteriaBuilder.where("course.id").eq(filter.courseId());
        }
        if (filter.teacherUserId() != null) {
            criteriaBuilder.where("teacherUser.id").eq(filter.teacherUserId());
        }
        if (filter.startDate() != null) {
            criteriaBuilder.where("startDate").eq(filter.startDate());
        }
        if (filter.endDate() != null) {
            criteriaBuilder.where("endDate").eq(filter.endDate());
        }
    }

}
