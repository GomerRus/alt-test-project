package ru.alt.linux.cli.commands;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;
import ru.alt.linux.core.dto.ArchComparisonDto;
import ru.alt.linux.core.dto.ComparisonResultDto;

import java.util.List;
import java.util.Map;

@Component
public class OutputFormat {

    private final static Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public String formatComparisonResult(ComparisonResultDto result) {
        List<ArchComparisonDto> archComparison = result.getArchComparisons();

        if (archComparison == null || archComparison.isEmpty()) {
            return GSON.toJson(Map.of("message", "Данных для сравнения не обнаружено"));
        }
        return GSON.toJson(result);
    }
}
