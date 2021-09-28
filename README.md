# AutoMate

- [Introduction](#introduction)
- [Installation](#installation)

## Introduction
Sringboot application to act as backend server for the [AutoMate](https://github.com/avikumar15/AutoMate) app.

### Getting started
See the Guide on how to contribute [here](CONTRIBUTING.md) for instructions on how to fork and set up your repository. Refer [here](CODE_OF_CONDUCT.md) for code of conduct.

### About DWoC
<a href="url"><img src="https://camo.githubusercontent.com/1ba815f1289125317c999a059ec95bfa5cba3894/68747470733a2f2f696d6775722e636f6d2f544c78357273762e706e67" height="180" width="550"> </a>

DWoC is a winter long program organised by [Delta Force](https://delta.nitt.edu/), the coding club of NIT Trichy. With an aim to support and improve the culture of open source software around us, this serves as a platform for young student developers (or even starters) to hone their technical skills by working on projects of their interests. We hope this encourages collabrative experiences and allows students from all backgrounds to contribute to quality technical projects from diverse fields.
For more information, visit [DWoC](https://dwoc.io/)

## Installation

### Requirements
- [JDK-11](https://linuxize.com/post/install-java-on-ubuntu-20-04/)
- [Maven](https://linuxize.com/post/how-to-install-apache-maven-on-ubuntu-20-04/) 
- [MySQL](https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-20-04)
- IDE - Intellij IDEA (Optional)

### Setup
1. Fork and clone the repository: `git clone https://github.com/<YOUR-USERNAME>/AutoMate`
2. Make a file named `application.properties` in `src/main/resources` folder and copy the contents of `application.properties.example`. Set the database connection details in `application.properties`, as required
3. Run `src/main/java/com/example/automate/AutoMateApplication.java`.
4. The application will be running at `http://localhost:<port>/`. Port is currently set to 8090 in `application.yml` file.
<br />   The routes can be tested with swagger at `http://localhost:<port>/swagger-ui/`.