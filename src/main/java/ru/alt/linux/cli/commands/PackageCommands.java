package ru.alt.linux.cli.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.alt.linux.service.PackageService;

@ShellComponent
@RequiredArgsConstructor
public class PackageCommands {
    private PackageService service;
    private OutputFormat output;

    @ShellMethod(key = "get-packages",
            value = "Получить список пакетов для ветки и архитектуры")
    public String getPackages(
            @ShellOption(value = "branch") String branch,
            @ShellOption(value = "arch", defaultValue = "x86_64") String arch) {

        return output.formatBranchBinaryPackages(service.getPackages(branch, arch));
    }

    @ShellMethod(key = "get-list-packages",
            value = "Получить пакеты из двух веток")
    public String getListPackages(@ShellOption(value = "branch1") String branch1,
                                  @ShellOption(value = "branch2") String branch2) {
        return output.formatTwoBranchesPackages(service.getListPackages(branch1, branch2));
    }

    @ShellMethod(key = "compare-Branches",
            value = "Сравнить пакеты между двумя ветками")
    public String compareBranches(
            @ShellOption(value = "branch1") String branch1,
            @ShellOption(value = "branch2") String branch2) {

        return output.formatComparisonResult(service.comparePackages(branch1, branch2));

    }

    @ShellMethod(key = "get-paginated-packages",
            value = "Постраничный вывод пакетов из двух веток")
    public String getPaginatedBranches(
            @ShellOption(value = "branch1") String branch1,
            @ShellOption(value = "branch2") String branch2,
            @ShellOption(value = "page", defaultValue = "0") int page,
            @ShellOption(value = "size", defaultValue = "10") int size) {
        var pageable = PageRequest.of(page, size);

        return output.formatPaginatedTwoBranchesPackages(service.getPaginatedListPackages(branch1, branch2, pageable));

    }
}
