package cl.edu.core.blaze.specification;

import com.blazebit.persistence.CriteriaBuilder;

import cl.edu.core.blaze.helper.BlazeSpecificationHelper;
import cl.edu.dto.filter.RoleFilterRequest;
import cl.edu.entity.Role;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RoleSpecification {

    public static void apply(CriteriaBuilder<Role> criteriaBuilder, RoleFilterRequest filter) {
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "code", filter.code());
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "name", filter.name());
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "description", filter.description());
        
        if (filter.active() != null) {
            criteriaBuilder.where("active").eq(filter.active());
        }
    }

}
