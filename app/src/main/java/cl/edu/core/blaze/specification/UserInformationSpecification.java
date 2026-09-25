package cl.edu.core.blaze.specification;

import com.blazebit.persistence.CriteriaBuilder;

import cl.edu.core.blaze.helper.BlazeSpecificationHelper;
import cl.edu.dto.filter.UserInformationFilterRequest;
import cl.edu.entity.UserInformation;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserInformationSpecification {

    public static void apply(CriteriaBuilder<UserInformation> criteriaBuilder,UserInformationFilterRequest filter) {
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "firstName", filter.firstName());
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "lastName", filter.lastName());
        BlazeSpecificationHelper.applyLike(criteriaBuilder, "email", filter.email());
    }

}
