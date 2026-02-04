package ru.alt.linux.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.data.domain.Page;
import ru.alt.linux.dto.PackageDto;
import ru.alt.linux.model.PackageEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PackageMapper {
    PackageDto toDto(PackageEntity entity);

    default Page<PackageDto> toDtoPage(Page<PackageEntity> page) {
        return page.map(this::toDto);
    }
}
