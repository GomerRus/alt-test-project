package ru.alt.linux.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alt.linux.dto.BranchBinaryPackagesDto;
import ru.alt.linux.exception.PackageNotFoundException;
import ru.alt.linux.mapper.BranchBinaryPackagesMapper;
import ru.alt.linux.model.PackageEntity;
import ru.alt.linux.repository.PackageRepository;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PackageServiceImpl implements PackageService {
    private PackageRepository packageRepository;
    private BranchBinaryPackagesMapper branchMapper;

    @Override
    public BranchBinaryPackagesDto getPackages(String branch, String arch) {
        List<PackageEntity> packages = packageRepository.findByBranchAndArch(branch, arch);
        if (packages.isEmpty()) {
            throw new PackageNotFoundException(String.format("No packages found branch - %s and arch - %s", branch, arch));
        }
        Map<String, String> requestArgs = Map.of("branch", branch, "arch", arch);
        return branchMapper.toResponseDto(packages, requestArgs);
    }
}



















