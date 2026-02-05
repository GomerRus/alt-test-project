package ru.alt.linux.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PackageDto {
    String name;
    int epoch;
    String version;
    String release;
    String arch;
    String disttag;
    long buildtime;
    String source;
}
