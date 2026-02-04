package ru.alt.linux.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.alt.linux.dto.BranchBinaryPackagesDto;
import ru.alt.linux.model.PackageEntity;

import java.util.List;
import java.util.Map;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = PackageMapper.class)
public interface BranchBinaryPackagesMapper {

    @Mapping(target = "requestArgs", source = "requestArgs")
    @Mapping(target = "packages", source = "packageEntities")
    @Mapping(target = "length", expression = "java(packageEntities.size())")
    BranchBinaryPackagesDto toResponseDto(
            List<PackageEntity> packageEntities,
            Map<String, String> requestArgs);
}
