package cl.edu.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import cl.edu.core.mapStruct.MapStructConfig;
import cl.edu.dto.filter.AccessTokenFilterRequest;
import cl.edu.dto.request.AccessTokenRequest;
import cl.edu.dto.response.AccessTokenResponse;
import cl.edu.entity.AccessToken;

@Mapper(config = MapStructConfig.class)
public interface AccessTokenMapper {

    @Mapping(target = "userInformationId", source = "userInformation.id")
    AccessTokenResponse toResponse(AccessToken accessToken);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userInformation", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    AccessToken toEntity(AccessTokenRequest accessTokenRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userInformation", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromRequest(AccessTokenRequest accessTokenRequest, @MappingTarget AccessToken accessToken);

    AccessTokenRequest toRequest(AccessTokenFilterRequest accessTokenFilterRequest);

}
