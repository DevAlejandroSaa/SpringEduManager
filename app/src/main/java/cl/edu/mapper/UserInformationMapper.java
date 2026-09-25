package cl.edu.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import cl.edu.core.mapStruct.MapStructConfig;
import cl.edu.dto.filter.UserInformationFilterRequest;
import cl.edu.dto.request.UserInformationRequest;
import cl.edu.dto.response.UserInformationResponse;
import cl.edu.entity.UserInformation;

@Mapper(config = MapStructConfig.class)
public interface UserInformationMapper {

    UserInformationResponse toResponse(UserInformation userInformation);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "accessTokens", ignore = true)
    @Mapping(target = "refreshTokens", ignore = true)
    @Mapping(target = "courseOfferings", ignore = true)
    @Mapping(target = "userCourses", ignore = true)
    @Mapping(target = "userPractices", ignore = true)
    UserInformation toEntity(UserInformationRequest userInformationRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "accessTokens", ignore = true)
    @Mapping(target = "refreshTokens", ignore = true)
    @Mapping(target = "courseOfferings", ignore = true)
    @Mapping(target = "userCourses", ignore = true)
    @Mapping(target = "userPractices", ignore = true)
    void updateEntityFromRequest(UserInformationRequest userInformationRequest,
            @MappingTarget UserInformation userInformation);

    UserInformationRequest toRequest(UserInformationFilterRequest userInformationFilterRequest);

}
