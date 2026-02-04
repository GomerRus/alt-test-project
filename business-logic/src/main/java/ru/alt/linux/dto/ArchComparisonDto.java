package ru.alt.linux.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArchComparisonDto {
    String arch;
    List<PackageDto> onlyInBranch1;
    List<PackageDto> onlyInBranch2;
    List<PackageDto> versionGreaterInBranch1;
}
