package ru.alt.linux.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.alt.linux.dto.BranchBinaryPackagesDto;
import ru.alt.linux.dto.ComparisonResultDto;
import ru.alt.linux.dto.PaginatedTwoBranchesPackagesDto;
import ru.alt.linux.dto.TwoBranchesPackagesDto;
import ru.alt.linux.service.PackageService;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/export/branch_binary_packages")
public class PackageController {
    private PackageService packageService;

    @GetMapping("/{branch}")
    public BranchBinaryPackagesDto getPackages(@PathVariable String branch,
                                               @RequestParam(required = false, defaultValue = "x86_64") String arch) {
        log.info("Пришел GET запрос на /branch_binary_packages/{}/", branch);
        return packageService.getPackages(branch, arch);
    }

    @GetMapping("/list/{branch1}/{branch2}")
    public TwoBranchesPackagesDto getListPackages(@PathVariable("branch1") String branch1,
                                                  @PathVariable("branch2") String branch2) {
        log.info("Пришел GET запрос на /list/{}/{}", branch1, branch2);

        return packageService.getListPackages(branch1, branch2);
    }

    @GetMapping("/compare/{branch1}/{branch2}")
    public ComparisonResultDto comparePackages(@PathVariable("branch1") String branch1,
                                               @PathVariable("branch2") String branch2) {
        log.info("Пришел GET запрос на /compare/{}/{}", branch1, branch2);

        return packageService.comparePackages(branch1, branch2);
    }

    @GetMapping("/list-paginated/{branch1}/{branch2}")
    public PaginatedTwoBranchesPackagesDto getPaginatedListPackages(@PathVariable("branch1") String branch1,
                                                                    @PathVariable("branch2") String branch2,
                                                                    @PageableDefault(size = 10) Pageable pageable) {
        return packageService.getPaginatedListPackages(branch1, branch2, pageable);
    }

}
