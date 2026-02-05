package ru.alt.linux.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchBinaryPackagesDto {
    Map<String, String> requestArgs;
    int length;
    List<PackageDto> packages;
}
