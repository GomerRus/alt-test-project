package ru.alt.linux.service;

import ru.alt.linux.dto.BranchBinaryPackagesDto;

public interface PackageService {
    BranchBinaryPackagesDto getPackages(String branch, String arch);
}
