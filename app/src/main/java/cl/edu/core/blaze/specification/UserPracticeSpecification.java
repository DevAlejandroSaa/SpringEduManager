package cl.edu.core.blaze.specification;

import com.blazebit.persistence.CriteriaBuilder;

import cl.edu.core.blaze.helper.BlazeSpecificationHelper;
import cl.edu.dto.filter.UserPracticeFilterRequest;
import cl.edu.entity.UserPractice;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserPracticeSpecification {

    public static void apply(CriteriaBuilder<UserPractice> criteriaBuilder, UserPracticeFilterRequest filter) {
        if (filter.studentUserId() != null) {
            criteriaBuilder.where("studentUser.id").eq(filter.studentUserId());
        }

        if (filter.practiceId() != null) {
            criteriaBuilder.where("practice.id").eq(filter.practiceId());
        }

        if (filter.startDate() != null) {
            criteriaBuilder.where("startDate").eq(filter.startDate());
        }

        if (filter.endDate() != null) {
            criteriaBuilder.where("endDate").eq(filter.endDate());
        }

        BlazeSpecificationHelper.applyLike(criteriaBuilder, "practiceLocation", filter.practiceLocation());
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "responsibleName", filter.responsibleName());
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "responsibleEmail", filter.responsibleEmail());
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "responsiblePhone", filter.responsiblePhone());
    }
    
}
