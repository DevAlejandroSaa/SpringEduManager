package cl.edu.core.blaze.helper;

import com.blazebit.persistence.CriteriaBuilder;

import lombok.experimental.UtilityClass;

@UtilityClass
public class BlazeSpecificationHelper {

    public <T> CriteriaBuilder<T> applyLike(CriteriaBuilder<T> criteriaBuilder, String attribute, String value) {
        return isValid(value)
                ? criteriaBuilder
                        .where(attribute)
                        .like()
                        .value("%" + value.trim() + "%")
                        .noEscape()
                : criteriaBuilder;
    }

    private boolean isValid(String value) {
        return value != null && !value.isBlank();
    }
    
}
