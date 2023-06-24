[![Java CI](https://github.com/marsidmali/marsidmali-seip-assignments/actions/workflows/main.yml/badge.svg)](https://github.com/marsidmali/marsidmali-seip-assignments/actions/workflows/main.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Language: Java](https://img.shields.io/badge/Language-Java-blue.svg)](https://www.java.com/)


# **Grades Histogram Java Application**

## About the project

The project is a Java application that reads a file containing student grades and generates a histogram representing the distribution of grades. The application is built using the Maven build automation tool, which simplifies the build process by managing dependencies and compiling the source code.

## Running the Program
To compile your source code, run any tests, and package your application into a JAR file, run:
     
    mvn package

Once you have built the Java application using Maven with the mvn package command, you can run the application with the following command: 

    java -jar gradeshistogram/target/gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar <path_to_grades.txt_file>


Replace ```<path_to_grades.txt_file>``` with the absolute or relative path to your grades.txt file.

<br>

## The output should be this:

<h1 align="center">

![image](https://user-images.githubusercontent.com/93339789/236683213-8faa2622-0b2f-4717-97b2-01725a83720a.png)

</h1>

