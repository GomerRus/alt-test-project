package ru.alt.linux.cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.command.annotation.CommandScan;

@SpringBootApplication
@CommandScan("ru.alt.linux.commands")
public class CliApplication {
    public static void main(String[] args) {
        SpringApplication.run(CliApplication.class,args);
    }
}
