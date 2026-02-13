package ru.alt.linux.core.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.alt.linux.core.api.ApiClient;
import ru.alt.linux.core.dto.ArchComparisonDto;
import ru.alt.linux.core.dto.ComparisonResultDto;
import ru.alt.linux.core.dto.PackageDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public class PackageServiceImpl implements PackageService {

        ApiClient apiClient;

        @Override
        public ComparisonResultDto comparePackages(String branch1, String branch2) {
            List<PackageDto> b1List = apiClient.fetchPackages(branch1);
            List<PackageDto> b2List = apiClient.fetchPackages(branch2);

            Map<String, List<PackageDto>> b1ByArch = b1List.stream()
                    .collect(Collectors.groupingBy(PackageDto::getArch));
            Map<String, List<PackageDto>> b2ByArch = b2List.stream()
                    .collect(Collectors.groupingBy(PackageDto::getArch));

            Set<String> allArchs = new HashSet<>();
            allArchs.addAll(b1ByArch.keySet());
            allArchs.addAll(b2ByArch.keySet());

            List<ArchComparisonDto> comparisons = new ArrayList<>();

            for (String arch : allArchs) {
                List<PackageDto> b1Packs = b1ByArch.getOrDefault(arch, Collections.emptyList());
                List<PackageDto> b2Packs = b2ByArch.getOrDefault(arch, Collections.emptyList());

                List<PackageDto> onlyInB1 = findPackagesOnlyFirstBranch(b1Packs, b2Packs);
                List<PackageDto> onlyInB2 = findPackagesOnlySecondBranch(b1Packs, b2Packs);
                List<PackageDto> greaterB1 = findNewerVersionsInFirstBranch(b1Packs, b2Packs);

                comparisons.add(ArchComparisonDto.builder()
                        .arch(arch)
                        .onlyInBranch1(onlyInB1)
                        .onlyInBranch2(onlyInB2)
                        .versionGreaterInBranch1(greaterB1)
                        .build());
            }

            return ComparisonResultDto.builder()
                    .archComparisons(comparisons)
                    .build();
        }

    private List<PackageDto> findPackagesOnlyFirstBranch(List<PackageDto> branch1, List<PackageDto> branch2) {
        Map<String, PackageDto> branch2Map = branch2.stream()
                .collect(Collectors.toMap(PackageDto::getName, p -> p));

        return branch1.stream()
                .filter(p -> !branch2Map.containsKey(p.getName()))
                .toList();
    }

    private List<PackageDto> findPackagesOnlySecondBranch(List<PackageDto> branch1, List<PackageDto> branch2) {
        Map<String, PackageDto> branch1Map = branch1.stream()
                .collect(Collectors.toMap(PackageDto::getName, p -> p));

        return branch2.stream()
                .filter(p -> !branch1Map.containsKey(p.getName()))
                .toList();
    }

    private List<PackageDto> findNewerVersionsInFirstBranch(List<PackageDto> branch1, List<PackageDto> branch2) {
        Map<String, PackageDto> branch2Map = branch2.stream()
                .collect(Collectors.toMap(PackageDto::getName, p -> p));
        return branch1.stream()
                .filter(p -> branch2Map.containsKey(p.getName()))
                .filter(p -> comparePackageVersions(p, branch2Map.get(p.getName())) > 0)
                .toList();
    }

    private int comparePackageVersions(PackageDto p1, PackageDto p2) {
        int epoch = Integer.compare(p1.getEpoch(), p2.getEpoch());
        if (epoch != 0) return epoch;

        int version = p1.getVersion().compareTo(p2.getVersion());
        if (version != 0) return version;

        return p1.getRelease().compareTo(p2.getRelease());
    }
}
