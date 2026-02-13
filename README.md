# Alt-test-project #
## Description
The project is designed to compare binary packages from two repository branches and output the results in JSON format. It consists of two modules:
>1) Core — an independent reusable library that can be integrated into any project.
>2) CLI — a console utility built on Spring Boot + Spring Shell that:
>- requests package lists from the API;
>- compares packages between two branches;
>- generates a structured JSON report.
## Architecture
### Core-library Module
Contains:
>- DTO classes (PackageDto, ComparisonResultDto, etc.) — data models for information exchange.
>- Services (ApiClient, PackageService):
> ApiClient — HTTP client for interacting with the https://rdb.altlinux.org/api
> PackageService — logic for comparing packages.
#### __Goal__: make the module reusable, allowing integration into any non-Spring projects.
### CLI-App Module
>- Built on Spring Boot with Spring Shell for an interactive CLI.
>- Entry point: a class annotated with @SpringBootApplication.
>- A configuration class registers beans from the Core module (ApiClient, PackageService) to enable Spring dependency management.
>- Commands are defined via @ShellComponent, allowing creation of branch comparison and result output commands.
## Using the CLI Mode
### Launching the Utility
Run the CLI utility with the following command:
>- java -jar target/cli-app-0.0.1-SNAPSHOT.jar
### Listing Available Commands
To view all available commands, type:
>- help
### Getting Information About a Specific Command
>- <command_name> help
### Example:
>- java -jar target/cli-app-0.0.1-SNAPSHOT.jar comparePackages help
## Available Method
>1) comparePackages
>
>Purpose: Compare packages between two branches. Returns:
>- Packages present only in the first branch;
>- Packages present only in the second branch;
>- Packages with a higher version in the first branch.
#### Return Type: ComparisonResultDto.

## Technologies and Dependencies Used
### Key Versions
>- ##### Java: 21
>- ##### Spring Boot: 3.3.5
>- ##### Spring Shell: 3.3.3
>- ##### springdoc-openapi-starter: 2.6.0
>- ##### Maven Compiler Plugin: 3.11.0
>- ##### lombok — to reduce boilerplate code
>- ##### Gson - for generating JSON reports
>- ##### spring-shell-starter — foundation for the CLI interface.
## Developer
 **Alekseev Mikhail** 

 **GitHub**: https://github.com/GomerRus/alt-test-project
 
 **Email**: alekseev.m.a.rus@gmail.com