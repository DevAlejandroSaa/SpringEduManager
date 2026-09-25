package cl.edu.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import cl.edu.core.mapStruct.MapStructConfig;
import cl.edu.dto.filter.RefreshTokenFilterRequest;
import cl.edu.dto.request.RefreshTokenRequest;
import cl.edu.dto.response.RefreshTokenResponse;
import cl.edu.entity.RefreshToken;

@Mapper(config = MapStructConfig.class)
public interface RefreshTokenMapper {

    @Mapping(target = "userInformationId", source = "userInformation.id")
    RefreshTokenResponse toResponse(RefreshToken refreshToken);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userInformation", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    RefreshToken toEntity(RefreshTokenRequest refreshTokenRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userInformation", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromRequest(RefreshTokenRequest refreshTokenRequest, @MappingTarget RefreshToken refreshToken);

    RefreshTokenRequest toRequest(RefreshTokenFilterRequest refreshTokenFilterRequest);

}
