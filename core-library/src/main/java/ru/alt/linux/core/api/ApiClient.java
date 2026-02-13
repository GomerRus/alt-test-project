package ru.alt.linux.core.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ru.alt.linux.core.dto.PackageDto;
import ru.alt.linux.core.exception.PackageBadRequestException;
import ru.alt.linux.core.exception.PackageNotFoundException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ApiClient {

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    public List<PackageDto> fetchPackages(String branch) {
        URI uri = URI.create("https://rdb.altlinux.org/api/export/branch_binary_packages/" + branch);

        try {
            HttpResponse<String> response = httpClient.send(
                    HttpRequest.newBuilder(uri)
                            .GET()
                            .build(),
                    HttpResponse.BodyHandlers.ofString()
            );
            int statusCode = response.statusCode();

            return switch (statusCode) {
                case 200 -> GSON.fromJson(response.body(), new TypeToken<List<PackageDto>>() {
                }.getType());
                case 400 ->
                        throw new PackageBadRequestException("ОШИБКА валидации параметров запроса: " + response.body());
                case 404 -> throw new PackageNotFoundException("Данные не найдены: " + response.body());
                default -> throw new RuntimeException(
                        String.format("HTTP-статус: %d. Тело ответа: %s.", statusCode, response.body()));
            };

        } catch (IOException | InterruptedException exp) {
            throw new RuntimeException("Ошибка при запросе к API", exp);
        }
    }
}