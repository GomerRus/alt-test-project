package ru.alt.linux.core.service;

import ru.alt.linux.core.dto.ComparisonResultDto;

public interface PackageService {

    ComparisonResultDto comparePackages(String branch1, String branch2);
}
