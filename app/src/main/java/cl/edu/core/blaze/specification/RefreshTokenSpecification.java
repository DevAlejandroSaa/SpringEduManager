package cl.edu.core.blaze.specification;

import com.blazebit.persistence.CriteriaBuilder;

import cl.edu.core.blaze.helper.BlazeSpecificationHelper;
import cl.edu.dto.filter.RefreshTokenFilterRequest;
import cl.edu.entity.RefreshToken;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RefreshTokenSpecification {

    public static void apply(CriteriaBuilder<RefreshToken> criteriaBuilder, RefreshTokenFilterRequest filter) {
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
