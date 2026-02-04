package ru.alt.linux.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TwoBranchesPackagesDto {
    List<PackageDto> branch1;
    List<PackageDto> branch2;
}
