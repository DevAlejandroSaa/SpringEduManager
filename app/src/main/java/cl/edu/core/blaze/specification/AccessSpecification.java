package cl.edu.core.blaze.specification;

import com.blazebit.persistence.CriteriaBuilder;

import cl.edu.core.blaze.helper.BlazeSpecificationHelper;
import cl.edu.dto.filter.AccessFilterRequest;
import cl.edu.entity.Access;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccessSpecification {
    public static void apply(CriteriaBuilder<Access> criteriaBuilder, AccessFilterRequest filter) {
        if (filter.roleId() != null) {
            criteriaBuilder.where("role.id").eq(filter.roleId());
        }

        if (filter.userInformationId() != null) {
            criteriaBuilder.where("userInformation.id").eq(filter.userInformationId());
        }

        BlazeSpecificationHelper.applyLike(criteriaBuilder, "username", filter.username());
        
        if (filter.statusId() != null) {
            criteriaBuilder.where("status.id").eq(filter.statusId());
        }
    }
}
