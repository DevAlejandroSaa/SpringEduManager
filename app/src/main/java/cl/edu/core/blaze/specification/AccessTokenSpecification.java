package cl.edu.core.blaze.specification;

import com.blazebit.persistence.CriteriaBuilder;

import cl.edu.core.blaze.helper.BlazeSpecificationHelper;
import cl.edu.dto.filter.AccessTokenFilterRequest;
import cl.edu.entity.AccessToken;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccessTokenSpecification {
    public static void apply(CriteriaBuilder<AccessToken> criteriaBuilder, AccessTokenFilterRequest filter) {
        if (filter.userInformationId() != null) {
            criteriaBuilder.where("userInformation.id").eq(filter.userInformationId());
        }
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "token", filter.token());
        if (filter.active() != null) {
            criteriaBuilder.where("active").eq(filter.active());
        }
        if (filter.expiresAt() != null) {
            criteriaBuilder.where("expiresAt").eq(filter.expiresAt());
        }
    }
}
