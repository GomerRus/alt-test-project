package ru.alt.linux.commands;

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

    /**
     * Пример: get-packages --branch p11 --arch x86_64
     * Параметры:
     * --branch (обязательный) — название ветки (например, main, testing).
     * --arch (опционально) — архитектура (по умолчанию: x86_64).
     * Допустимые архитектуры: х86_64/arch64/noarch/i586.
     */

    @ShellMethod(key = "get-packages",
            value = "Получить список пакетов для ветки и архитектуры")
    public String getPackages(
            @ShellOption(value = "--branch", help = "Ветки(sisyphus/p11/p10/testing) ") String branch,
            @ShellOption(value = "--arch", help = "Архитектуры(х86_64/arch64/noarch/i586)",
                    defaultValue = "x86_64") String arch) {

        return output.formatBranchBinaryPackages(service.getPackages(branch, arch));
    }

    /**
     * Пример: get-list-packages --branch1 p11 --branch2 p10
     * Параметры: --branch1 (обязательно) — первая ветка (например, p11).
     * --branch2 (обязательно) — вторая ветка (например, p10).
     * Вывод: список пакетов в обеих веткок.
     */

    @ShellMethod(key = "get-list-packages",
            value = "Получить пакеты из двух веток")
    public String getListPackages(@ShellOption(value = "branch1") String branch1,
                                  @ShellOption(value = "branch2") String branch2) {
        return output.formatTwoBranchesPackages(service.getListPackages(branch1, branch2));
    }

    /**
     * Пример: compare-Branches --branch1 p11 --branch2 p10
     * Параметры: --branch1 (обязательно) — базовая ветка.
     * --branch2 (обязательно) — ветка для сравнения.
     * Вывод: таблицы с пакетами, которые:
     * - есть только в branch1;
     * - есть только в branch2;
     * - отличаются по версии.
     */

    @ShellMethod(key = "compare-Branches",
            value = "Сравнить пакеты между двумя ветками")
    public String compareBranches(
            @ShellOption(value = "branch1") String branch1,
            @ShellOption(value = "branch2") String branch2) {

        return output.formatComparisonResult(service.comparePackages(branch1, branch2));

    }

    /**
     * Пример: get-paginated-packages --branch1 p11 --branch2 p10 --page 0 --size 10
     * Параметры: --branch1 (обязательно) — первая ветка.
     * --branch2 (обязательно) — вторая ветка.
     * --page (опционально) — номер страницы (по умолчанию: 0).
     * --size (опционально) — количество записей на странице (по умолчанию: 10, максимум: 100).
     * Вывод: таблица с пагинацией, включая номера страниц и общее количество записей.
     */

    @ShellMethod(key = "get-paginated-branches",
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
