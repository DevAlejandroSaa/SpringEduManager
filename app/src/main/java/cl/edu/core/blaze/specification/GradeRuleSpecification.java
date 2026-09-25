package cl.edu.core.blaze.specification;

import com.blazebit.persistence.CriteriaBuilder;

import cl.edu.dto.filter.GradeRuleFilterRequest;
import cl.edu.entity.GradeRule;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GradeRuleSpecification {

    public static void apply(CriteriaBuilder<GradeRule> criteriaBuilder, GradeRuleFilterRequest filter) {
        if (filter.grade() != null) {
            criteriaBuilder.where("grade").eq(filter.grade());
        }
        
        if (filter.approved() != null) {
            criteriaBuilder.where("approved").eq(filter.approved());
        }
    }

}
