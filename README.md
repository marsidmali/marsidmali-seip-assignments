
# **Grades Histogram Java Application**

## About the project

The project is a Java application that reads a file containing student grades and generates a histogram representing the distribution of grades. The application is built using the Maven build automation tool, which simplifies the build process by managing dependencies and compiling the source code.

## Requirements
To run this application, you need to have the following software installed on your system:

    - Java Development Kit (JDK) 8 or later
    - Apache Maven 3.6.0 or later

## Usage
1. Clone this repository to your local machine.
2. Navigate to the project root directory.

## Running the Program
To compile your source code, run any tests, and package your application into a JAR file, run:
     
    mvn package

Once you have built the Java application using Maven with the mvn package command, you can run the application with the following command: 

    java -jar gradeshistogram/target/gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar <path_to_grades.txt_file>


Replace ```<path_to_grades.txt_file>``` with the absolute or relative path to your grades.txt file.

<br>

## The output should be this:

<h1 align="center">

![image](https://user-images.githubusercontent.com/93339789/236013529-7aadd1f9-1210-49f9-b949-d86b8e2853b2.png)
</h1>

