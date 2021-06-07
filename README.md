
# Awesome-api


<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#built-with">Built With</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>


### Built With

* [Java 11](https://adoptopenjdk.net)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Jackson](https://github.com/FasterXML/jackson)
* [Gradle](https://gradle.org/)

## Getting Started

To get a local copy up and running follow these steps:

### Prerequisites

* Java 11 AdoptOpenJDK
  [Installation Guide](https://adoptopenjdk.net/installation.html)
  
* Postman, Insomnia, Swagger UI, Paw or similar API tool 

* Gradle [Installation Guide](https://gradle.org/install/)
  
  

### Installation

1. Clone the project to your local environment
2. Go to the project root file
3. Run the command: ``` gradle build ```
4. Once the build is completed execute: ```java -jar build/libs/awesome-api-1.0.0-SNAPSHOT.jar```
5. On your API tool do the request

## Usage

There is a single endpoint that takes a list of watches ID and return the total cost.

Once is running you can call the endpoint: localhost:8080/checkout as a Post request with a list of watches as a body.

Available Watches: 

![image](https://user-images.githubusercontent.com/77287382/121061347-08cb7100-c7c4-11eb-9c27-f6961c431195.png)


## Roadmap
[![Issues][issues-shield]][issues-url]

See the [open issues](https://github.com/AdrianMedico/awesome-api/issues) for a list of proposed features.

## Contact

[![LinkedIn][linkedin-shield]][linkedin-url]

[issues-shield]: https://img.shields.io/github/issues/AdrianMedico/awesome-api?style=for-the-badge
[issues-url]: https://github.com/AdrianMedico/awesome-api/issues
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/adrian-medico
