package ru.alt.linux.cli.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.alt.linux.core.api.ApiClient;
import ru.alt.linux.core.service.PackageService;
import ru.alt.linux.core.service.PackageServiceImpl;


@Configuration
public class AppConfig {

    @Bean
    public ApiClient apiClient() {
        return new ApiClient();
    }

    @Bean
    public PackageService packageService(ApiClient apiClient) {
        return new PackageServiceImpl(apiClient);
    }
}
