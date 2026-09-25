package cl.edu.core.blaze.specification;

import com.blazebit.persistence.CriteriaBuilder;

import cl.edu.core.blaze.helper.BlazeSpecificationHelper;
import cl.edu.dto.filter.PracticeStatusFilterRequest;
import cl.edu.entity.PracticeStatus;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PracticeStatusSpecification {

    public static void apply(CriteriaBuilder<PracticeStatus> criteriaBuilder,PracticeStatusFilterRequest filter) {
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "code", filter.code());
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "name", filter.name());
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "description", filter.description());
    }

}
