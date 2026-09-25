package cl.edu.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import cl.edu.core.mapStruct.MapStructConfig;
import cl.edu.dto.filter.AccessStatusFilterRequest;
import cl.edu.dto.request.AccessStatusRequest;
import cl.edu.dto.response.AccessStatusResponse;
import cl.edu.entity.AccessStatus;

@Mapper(config = MapStructConfig.class)
public interface AccessStatusMapper {

    AccessStatusResponse toResponse(AccessStatus accessStatus);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "accesses", ignore = true)
    AccessStatus toEntity(AccessStatusRequest accessStatusRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "accesses", ignore = true)
    void updateEntityFromRequest(AccessStatusRequest accessStatusRequest, @MappingTarget AccessStatus accessStatus);

    AccessStatusRequest toRequest(AccessStatusFilterRequest accessStatusFilterRequest);

}
