package cl.edu.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import cl.edu.core.mapStruct.MapStructConfig;
import cl.edu.dto.filter.AccessFilterRequest;
import cl.edu.dto.request.AccessRequest;
import cl.edu.dto.response.AccessResponse;
import cl.edu.entity.Access;

@Mapper(config = MapStructConfig.class)
public interface AccessMapper {

    @Mapping(target = "roleId", source = "role.id")
    @Mapping(target = "userInformationId", source = "userInformation.id")
    @Mapping(target = "statusId", source = "status.id")
    AccessResponse toResponse(Access entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "userInformation", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Access toEntity(AccessRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "userInformation", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromRequest(AccessFilterRequest request, @MappingTarget Access entity);
            
}
