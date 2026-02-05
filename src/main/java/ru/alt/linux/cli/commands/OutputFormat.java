package ru.alt.linux.cli.commands;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import ru.alt.linux.dto.ArchComparisonDto;
import ru.alt.linux.dto.BranchBinaryPackagesDto;
import ru.alt.linux.dto.ComparisonResultDto;
import ru.alt.linux.dto.PackageDto;
import ru.alt.linux.dto.PaginatedTwoBranchesPackagesDto;
import ru.alt.linux.dto.TwoBranchesPackagesDto;

import java.util.List;
import java.util.Map;

@Component
public class OutputFormat {
    public String formatBranchBinaryPackages(BranchBinaryPackagesDto dto) {
        StringBuilder sb = new StringBuilder();

        sb.append("== Запрос ==\n");
        if (dto.getRequestArgs() != null && !dto.getRequestArgs().isEmpty()) {
            for (Map.Entry<String, String> entry : dto.getRequestArgs().entrySet()) {
                sb.append("- ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
        } else {
            sb.append("Аргументы запроса отсутствуют\n");
        }

        sb.append("\n== Статистика ==\n")
                .append("Всего пакетов: ").append(dto.getLength()).append("\n\n");

        sb.append("== Пакеты ==\n");
        if (dto.getPackages() != null) {
            for (int i = 0; i < dto.getPackages().size(); i++) {
                PackageDto pkg = dto.getPackages().get(i);
                sb.append(String.format("  [%d] %s\n", i + 1, formatPackageCompact(pkg)));
                sb.append(formatPackageDetails(pkg, "    "));
            }
        } else {
            sb.append("Пакеты не найдены\n");
        }

        return sb.toString();
    }

    public String formatTwoBranchesPackages(TwoBranchesPackagesDto dto) {
        StringBuilder sb = new StringBuilder();

        sb.append("=== ПОЛУЧЕНИЕ СПИСКОВ ПАКЕТОВ ДВУХ ВЕТВЕЙ ===\n\n");

        sb.append("== Ветвь 1 ==\n");
        if (dto.getBranch1() != null && !dto.getBranch1().isEmpty()) {
            sb.append(String.format("Количество пакетов: %d\n\n", dto.getBranch1().size()));
            for (int i = 0; i < dto.getBranch1().size(); i++) {
                PackageDto pkg = dto.getBranch1().get(i);
                sb.append(String.format("  [%d] %s\n", i + 1, formatPackageCompact(pkg)));
                sb.append(formatPackageDetails(pkg, "    "));
            }
        } else {
            sb.append("Пакеты не найдены\n");
        }

        sb.append("\n");

        sb.append("== Ветвь 2 ==\n");
        if (dto.getBranch2() != null && !dto.getBranch2().isEmpty()) {
            sb.append(String.format("Количество пакетов: %d\n\n", dto.getBranch2().size()));
            for (int i = 0; i < dto.getBranch2().size(); i++) {
                PackageDto pkg = dto.getBranch2().get(i);
                sb.append(String.format("  [%d] %s\n", i + 1, formatPackageCompact(pkg)));
                sb.append(formatPackageDetails(pkg, "    "));
            }
        } else {
            sb.append("Пакеты не найдены\n");
        }

        return sb.toString();
    }

    public String formatComparisonResult(ComparisonResultDto result) {
        StringBuilder sb = new StringBuilder();

        if (result.getArchComparisons() == null || result.getArchComparisons().isEmpty()) {
            return "Нет данных для сравнения.\n";
        }

        for (ArchComparisonDto archDto : result.getArchComparisons()) {
            sb.append(String.format("=== Архитектура: %s ===\n", archDto.getArch()));

            List<PackageDto> only1 = archDto.getOnlyInBranch1();
            sb.append("Уникальные в ветке 1: ").append(only1 != null ? only1.size() : 0).append("\n");
            if (only1 != null && !only1.isEmpty()) {
                for (PackageDto pkg : only1) {
                    sb.append(formatPackageCompact(pkg)).append("\n");
                }
            }

            List<PackageDto> only2 = archDto.getOnlyInBranch2();
            sb.append("Уникальные в ветке 2: ").append(only2 != null ? only2.size() : 0).append("\n");
            if (only2 != null && !only2.isEmpty()) {
                for (PackageDto pkg : only2) {
                    sb.append(formatPackageCompact(pkg)).append("\n");
                }
            }

            List<PackageDto> greater1 = archDto.getVersionGreaterInBranch1();
            sb.append("Версия больше в ветке 1: ").append(greater1 != null ? greater1.size() : 0).append("\n");
            if (greater1 != null && !greater1.isEmpty()) {
                for (PackageDto pkg : greater1) {
                    sb.append(formatPackageCompact(pkg)).append("\n");
                }
            }

            sb.append("\n");
        }

        return sb.toString();
    }

    public String formatPaginatedTwoBranchesPackages(PaginatedTwoBranchesPackagesDto dto) {
        StringBuilder sb = new StringBuilder();

        sb.append("=== ПАГИНИРОВАННЫЕ ПАКЕТЫ ДВУХ ВЕТВЕЙ ===\n\n");

        if (dto.getBranch1() == null && dto.getBranch2() == null) {
            sb.append("Нет данных для отображения.\n");
            return sb.toString();
        }

        if (dto.getBranch1() != null) {
            Page<PackageDto> page1 = dto.getBranch1();
            sb.append("== Ветвь 1 ==\n");
            sb.append(String.format("Страница: %d / %d (размер: %d, всего: %d)\n\n",
                    page1.getNumber() + 1,
                    page1.getTotalPages(),
                    page1.getSize(),
                    page1.getTotalElements()));

            if (!page1.getContent().isEmpty()) {
                for (int i = 0; i < page1.getContent().size(); i++) {
                    PackageDto pkg = page1.getContent().get(i);
                    sb.append(String.format("  [%d] %s\n", i + 1, formatPackageCompact(pkg)));
                    sb.append(formatPackageDetails(pkg, "    "));
                }
            } else {
                sb.append("  (пакеты отсутствуют)\n");
            }
            sb.append("\n");
        }

        if (dto.getBranch2() != null) {
            Page<PackageDto> page2 = dto.getBranch2();
            sb.append("== Ветвь 2 ==\n");
            sb.append(String.format("Страница: %d / %d (размер: %d, всего: %d)\n\n",
                    page2.getNumber() + 1,
                    page2.getTotalPages(),
                    page2.getSize(),
                    page2.getTotalElements()));

            if (!page2.getContent().isEmpty()) {
                for (int i = 0; i < page2.getContent().size(); i++) {
                    PackageDto pkg = page2.getContent().get(i);
                    sb.append(String.format("  [%d] %s\n", i + 1, formatPackageCompact(pkg)));
                    sb.append(formatPackageDetails(pkg, "    "));
                }
            } else {
                sb.append("  (пакеты отсутствуют)\n");
            }
        }

        return sb.toString();
    }

    private String formatPackageCompact(PackageDto pkg) {
        return String.format("%s-%s-%s (arch: %s)",
                pkg.getName(),
                pkg.getVersion(),
                pkg.getRelease(),
                pkg.getArch()
        );
    }

    private static StringBuilder formatPackageDetails(PackageDto pkg, String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("Эпоха: ").append(pkg.getEpoch()).append("\n");
        sb.append(indent).append("Дист‑тег: ").append(pkg.getDisttag()).append("\n");
        sb.append(indent).append("Время сборки: ").append(pkg.getBuildtime()).append("\n");
        sb.append(indent).append("Исходный пакет: ").append(pkg.getSource()).append("\n");
        return sb;
    }
}
