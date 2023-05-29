# Selenide Test Suite

This repository contains a Selenium Test Suite using Java, Selenide, TestNG, Maven, Allure and Docker.

## Environment Setup

The instructions are for MacOS.

### Java 20 Installation

1. If you don't have Homebrew installed, install it first with the following command:

    ```bash
    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
    ```

2. Install Java:

    ```bash
    brew install --cask temurin
    ```

3. Validate the installation:

    ```bash
    java -version
    ```

### Allure Installation

1. Install Allure with brew:

    ```bash
    brew install allure
    ```

2. Validate the installation:

    ```bash
    allure --version
    ```

### Maven Installation

1. Install Maven with brew:

    ```bash
    brew install maven
    ```

2. Validate the installation:

    ```bash
    mvn -v
    ```

### Chromedriver Installation

1. Install Chromedriver with brew (make sure you have Google Chrome installed):

    ```bash
    brew install --cask chromedriver
    ```

2. Validate the installation:

    ```bash
    chromedriver --version
    ```

## Run Tests Locally

1. Clone this repository:

    ```bash
    git clone https://github.com/barranquerox/selenide.git
    ```

2. Navigate to the repository directory:

    ```bash
    cd selenide
    ```

3. Run the tests with Maven:

    ```bash
    mvn clean test
    ```

## Allure Report

1. View the report:

    ```bash
    allure serve target/allure-results
    ```

## Docker Setup

### Build Docker Image

1. Build the Docker image:

    ```bash
    docker build -t selenide-tests .
    ```

