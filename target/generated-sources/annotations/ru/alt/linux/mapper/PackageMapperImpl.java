package ru.alt.linux.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.alt.linux.dto.PackageDto;
import ru.alt.linux.model.PackageEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-05T07:15:25+0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.8 (Amazon.com Inc.)"
)
@Component
public class PackageMapperImpl implements PackageMapper {

    @Override
    public PackageDto toDto(PackageEntity entity) {
        if ( entity == null ) {
            return null;
        }

        PackageDto.PackageDtoBuilder packageDto = PackageDto.builder();

        packageDto.name( entity.getName() );
        packageDto.epoch( entity.getEpoch() );
        packageDto.version( entity.getVersion() );
        packageDto.release( entity.getRelease() );
        packageDto.arch( entity.getArch() );
        packageDto.disttag( entity.getDisttag() );
        packageDto.buildtime( entity.getBuildtime() );
        packageDto.source( entity.getSource() );

        return packageDto.build();
    }
}
