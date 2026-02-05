# alt-test-project #
## Description
This is a Java project that implements a tool for working with ALT Linux packages. It is built on Spring Boot and uses Spring Shell to provide a CLI (Command Line Interface) for interacting with the system. The tool allows retrieving, comparing, and paginating package data across different branches.
## Building the Project
To build the project, follow these steps:
>1) Clone the repository locally.
>2) Open a terminal in the project directory.
>3) Run the command: mvn clean package
>- This will compile the project and generate an executable JAR file in the target folder.
## Running Infrastructure (Docker)
Before using the CLI, it is recommended to start dependent services (e.g., the database) via Docker Compose: 
>- docker compose up -d
## Using the CLI Mode
### Launching the Utility
Run the CLI utility with the following command:
>- java -jar target/alt-test-project-0.0.1-SNAPSHOT.jar
### Listing Available Commands
To view all available commands, type:
>- help
### Getting Information About a Specific Command
>- <command_name> help
### Example:
>- java -jar target/alt-test-project-0.0.1-SNAPSHOT.jar getPackages help
## Available Methods
>1) getPackages
>
>Purpose: Retrieve a list of binary packages for a specified branch and architecture.
#### Return Type: BranchBinaryPackagesDto.
>2) getListPackages
>
>Purpose: Retrieve package lists for two branches.
#### Return Type: TwoBranchesPackagesDto.
>3) comparePackages
>
>Purpose: Compare packages between two branches. Returns:
>- Packages present only in the first branch;
>- Packages present only in the second branch;
>- Packages with a higher version in the first branch.
#### Return Type: ComparisonResultDto.
>4) getPaginatedListPackages
>
>Purpose: Paginate package lists for two branches (useful for large datasets).
#### Return Type: PaginatedTwoBranchesPackagesDto.
## Technologies and Dependencies Used
### Key Versions
>- ##### Java: 21
>- ##### Spring Boot: 3.3.5
>- ##### Spring Shell: 3.3.3
>- ##### springdoc-openapi-starter: 2.6.0
>- ##### MapStruct: 1.6.2
>- ##### Maven Compiler Plugin: 3.11.0
### Core Dependencies
>- ##### spring-boot-starter-validation — for data validation;
>- ##### spring-boot-starter-data-jpa — for database interaction via JPA;
>- ##### postgresql — PostgreSQL JDBC driver;
>- ##### lombok — to reduce boilerplate code;
>- ##### mapstruct — for mapping between entities and DTOs;
>- ##### spring-shell-starter — foundation for the CLI interface.
## Developer
 **Alekseev Mikhail** 

 **GitHub**: https://github.com/GomerRus/alt-test-project
 
 **Email**: alekseev.m.a.rus@gmail.com