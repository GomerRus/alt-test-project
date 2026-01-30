package ru.alt.linux.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.alt.linux.dto.BranchBinaryPackagesDto;
import ru.alt.linux.model.PackageEntity;

import java.util.List;
import java.util.Map;

@Mapper(uses = PackageMapper.class)
public interface BranchBinaryPackagesMapper {
    BranchBinaryPackagesDto toResponseDto(
            @MappingTarget BranchBinaryPackagesDto dto,
            List<PackageEntity> packageEntities,
            Map<String, String> requestArgs);
}
