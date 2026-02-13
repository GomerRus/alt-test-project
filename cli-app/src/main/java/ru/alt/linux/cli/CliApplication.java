package ru.alt.linux.cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.command.annotation.CommandScan;

@SpringBootApplication
@CommandScan(basePackages = {"ru.alt.linux.cli.commands", "ru.alt.linux.core.service",
"ru.alt.linux.core.api", "ru.linux.cli.config"})
public class CliApplication {
    public static void main(String[] args) {
        SpringApplication.run(CliApplication.class,args);
    }
}
