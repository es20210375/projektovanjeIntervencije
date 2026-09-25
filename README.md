# Dental Clinic Information System

A Java desktop application for managing patients, dental records and interventions. Developed as an academic project at the Faculty of Organizational Sciences, University of Belgrade.

## Technologies

- Java 17 and Swing for the desktop user interface
- Java sockets for client–server communication
- JDBC and MySQL for data storage
- NetBeans and Apache Ant

## Features

- Medical worker login and logout
- Adding, viewing, searching and updating patients
- Creating and managing dental records and their entries
- Recording interventions, diagnoses, materials and therapy
- Filtering records by patient, medical worker, intervention and year

## Structure

The application consists of three NetBeans projects:

- `Intervencija_Klijent` — desktop client and user interface
- `Intervencija_Server` — server, application operations and database access
- `Intervencija_Zajednicki` — shared domain classes and communication objects

The client sends requests to the server, which processes them and reads or updates data in MySQL. This is a Java socket application, not a REST API.

## Running locally

The project requires JDK 17, NetBeans, MySQL and MySQL Connector/J. Open all three projects in NetBeans and build `Intervencija_Zajednicki` first. Configure the MySQL connection in the server project for your own local database, then run the server before starting the client.

The repository does not include a public demo database. Use fictional records and your own local configuration when testing the application.
