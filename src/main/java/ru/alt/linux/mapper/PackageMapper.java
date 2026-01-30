package ru.alt.linux.mapper;

import org.mapstruct.Mapper;
import ru.alt.linux.dto.PackageDto;
import ru.alt.linux.model.PackageEntity;

@Mapper
public interface PackageMapper {
    PackageDto toDto(PackageEntity entity);

}
