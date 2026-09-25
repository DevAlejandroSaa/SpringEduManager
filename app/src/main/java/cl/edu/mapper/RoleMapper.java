package cl.edu.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import cl.edu.core.mapStruct.MapStructConfig;
import cl.edu.dto.filter.RoleFilterRequest;
import cl.edu.dto.request.RoleRequest;
import cl.edu.dto.response.RoleResponse;
import cl.edu.entity.Role;

@Mapper(config = MapStructConfig.class)
public interface RoleMapper {

    RoleResponse toResponse(Role entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "accesses", ignore = true)
    Role toEntity(RoleRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "accesses", ignore = true)
    void updateEntityFromRequest(RoleFilterRequest request, @MappingTarget Role entity);
}
