# Microsoft Kiota Demo Project

This repository contains a demo project that showcases how to use [Microsoft Kiota](https://github.com/microsoft/kiota), the OpenAPI based HTTP client generator tool.

The main purpose of this project is to provide supplementary material for my blog post at [2ndworst.dev](https://2ndworst.dev).

The project is divided into three submodules:

- `api`: Contains a RESTful API using Spring Boot to list, create and update authors and quotes. Also, the build process generates the OpenAPI specification file (`openapi.json`).

- `sdk-kiota`: Using the OpenAPI specification file and the [Kiota Maven plugin](https://github.com/kiota-community/kiota-java-extra), this submodule generates a Java SDK that can be used to interact with the API.

- `client`: A simple command-line client that uses the generated SDK to interact with the API.

Please note that this project is only for demonstration purposes and for the sake of simplicity, it does not follow the best practices for production-ready code.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [License](#license)

## Installation

### Requirements

This project requires the following tools to be installed:

- [JDK 17](https://adoptium.net/en-GB/temurin/releases/?version=17)
- [Maven](https://maven.apache.org/download.cgi)
- [Python 3](https://www.python.org/downloads/) (optional, if you wish to run everything I cover in my blog post)
- [Kiota CLI](https://learn.microsoft.com/en-gb/openapi/kiota/install?tabs=bash)

It is highly recommended to launch the GitHub Codespaces environment for this project, as it comes pre-installed with all the necessary tools.

For local development, you can install the required tools and check out this repository.

Next, you need to build the project using the following command:

```bash
mvn clean install
```

This will build the submodules (`api`, `client`, and `sdk-kiota`) and install them in your local Maven repository.

## Usage

To run the API locally:
    
```bash
mvn clean install
cd api
mvn spring-boot:run
```

You can access the API at `http://localhost:8080` and the OpenAPI specification at `http://localhost:8080/openapi.json`.

Finally, to access the Swagger UI, go to `http://localhost:8080/swagger-ui.html`.

To run the client:

```bash
cd client
mvn clean compile exec:java
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
