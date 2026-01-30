package ru.alt.linux.mapper;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.alt.linux.dto.BranchBinaryPackagesDto;
import ru.alt.linux.dto.PackageDto;
import ru.alt.linux.model.PackageEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-31T01:59:37+0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.8 (Amazon.com Inc.)"
)
@Component
public class BranchBinaryPackagesMapperImpl implements BranchBinaryPackagesMapper {

    @Autowired
    private PackageMapper packageMapper;

    @Override
    public BranchBinaryPackagesDto toResponseDto(List<PackageEntity> packageEntities, Map<String, String> requestArgs) {
        if ( packageEntities == null && requestArgs == null ) {
            return null;
        }

        BranchBinaryPackagesDto.BranchBinaryPackagesDtoBuilder branchBinaryPackagesDto = BranchBinaryPackagesDto.builder();

        branchBinaryPackagesDto.packages( packageEntityListToPackageDtoList( packageEntities ) );
        Map<String, String> map = requestArgs;
        if ( map != null ) {
            branchBinaryPackagesDto.requestArgs( new LinkedHashMap<String, String>( map ) );
        }
        branchBinaryPackagesDto.length( packageEntities.size() );

        return branchBinaryPackagesDto.build();
    }

    protected List<PackageDto> packageEntityListToPackageDtoList(List<PackageEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PackageDto> list1 = new ArrayList<PackageDto>( list.size() );
        for ( PackageEntity packageEntity : list ) {
            list1.add( packageMapper.toDto( packageEntity ) );
        }

        return list1;
    }
}
