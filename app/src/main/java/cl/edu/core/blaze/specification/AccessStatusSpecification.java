package cl.edu.core.blaze.specification;

import com.blazebit.persistence.CriteriaBuilder;

import cl.edu.core.blaze.helper.BlazeSpecificationHelper;
import cl.edu.dto.filter.AccessStatusFilterRequest;
import cl.edu.entity.AccessStatus;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccessStatusSpecification {
    public static void apply(CriteriaBuilder<AccessStatus> criteriaBuilder, AccessStatusFilterRequest filter) {
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "code", filter.code());
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "name", filter.name());
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "description", filter.description());
    }
}
