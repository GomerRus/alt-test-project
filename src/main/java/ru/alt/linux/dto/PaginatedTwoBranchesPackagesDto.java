package ru.alt.linux.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;


@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaginatedTwoBranchesPackagesDto {
    Page<PackageDto> branch1;
    Page<PackageDto> branch2;
}
