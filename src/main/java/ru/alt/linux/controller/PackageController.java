package ru.alt.linux.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.alt.linux.dto.BranchBinaryPackagesDto;
import ru.alt.linux.service.PackageService;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/export")
public class PackageController {
    private PackageService packageService;

    @GetMapping("/branch_binary_packages/{branch}")
    public BranchBinaryPackagesDto getPackages(@PathVariable String branch,
                                               @RequestParam(required = false, defaultValue = "x86_64") String arch) {
        log.info("Пришел GET запрос на /branch_binary_packages/{}/", branch );
        return packageService.getPackages(branch, arch);
    }
}
