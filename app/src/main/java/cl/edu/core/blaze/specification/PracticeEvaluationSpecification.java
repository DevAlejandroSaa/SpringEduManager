package cl.edu.core.blaze.specification;

import com.blazebit.persistence.CriteriaBuilder;

import cl.edu.core.blaze.helper.BlazeSpecificationHelper;
import cl.edu.dto.filter.PracticeEvaluationFilterRequest;
import cl.edu.entity.PracticeEvaluation;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PracticeEvaluationSpecification {

    public static void apply(CriteriaBuilder<PracticeEvaluation> criteriaBuilder,PracticeEvaluationFilterRequest filter) {
        if (filter.userPracticeId() != null) {
            criteriaBuilder.where("userPractice.id").eq(filter.userPracticeId());
        }

        if (filter.grade() != null) {
            criteriaBuilder.where("grade").eq(filter.grade());
        }

        BlazeSpecificationHelper.applyLike(criteriaBuilder, "description", filter.description());
    }

}
