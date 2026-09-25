package cl.edu.core.blaze.specification;

import com.blazebit.persistence.CriteriaBuilder;

import cl.edu.core.blaze.helper.BlazeSpecificationHelper;
import cl.edu.dto.filter.CourseClassFilterRequest;
import cl.edu.entity.CourseClass;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CourseClassSpecification {

    public static void apply(CriteriaBuilder<CourseClass> criteriaBuilder, CourseClassFilterRequest filter) {
        if (filter.courseOfferingId() != null) {
            criteriaBuilder.where("courseOffering.id").eq(filter.courseOfferingId());
        }

        BlazeSpecificationHelper.applyLike(criteriaBuilder, "classDate", filter.classDate());

        if (filter.startTime() != null) {
            criteriaBuilder.where("startTime").eq(filter.startTime());
        }

        if (filter.endTime() != null) {
            criteriaBuilder.where("endTime").eq(filter.endTime());
        }

        BlazeSpecificationHelper.applyLike(criteriaBuilder, "virtualUrl", filter.virtualUrl());
    }

}
