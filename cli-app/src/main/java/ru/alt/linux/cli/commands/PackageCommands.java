package ru.alt.linux.cli.commands;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.alt.linux.core.service.PackageService;

@ShellComponent
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PackageCommands {
    PackageService service;
    OutputFormat output;

    /**
     * Пример: compare-branches --branch1 p11 --branch2 p10
     * Параметры: --branch1 (обязательно) — базовая ветка.
     * --branch2 (обязательно) — ветка для сравнения.
     * Вывод: таблицы с пакетами, которые:
     * - есть только в branch1;
     * - есть только в branch2;
     * - отличаются по версии.
     */

    @ShellMethod(key = "compare-branches",
            value = "Сравнить пакеты между двумя ветками")
    public String compareBranches(
            @ShellOption(value = "branch1") String branch1,
            @ShellOption(value = "branch2") String branch2) {

        return output.formatComparisonResult(service.comparePackages(branch1, branch2));
    }
}