package ru.alt.linux.service;

import org.springframework.data.domain.Pageable;
import ru.alt.linux.dto.BranchBinaryPackagesDto;
import ru.alt.linux.dto.ComparisonResultDto;
import ru.alt.linux.dto.PaginatedTwoBranchesPackagesDto;
import ru.alt.linux.dto.TwoBranchesPackagesDto;

public interface PackageService {
    BranchBinaryPackagesDto getPackages(String branch, String arch);

    TwoBranchesPackagesDto getListPackages(String branch1, String branch2);

    ComparisonResultDto comparePackages(String branch1, String branch2);

    PaginatedTwoBranchesPackagesDto getPaginatedListPackages(String branch1, String branch2, Pageable pageable);
}
