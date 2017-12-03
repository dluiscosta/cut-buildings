# cut-buildings

First project with clojure, with learning purposes.

## Description

There are *n* buildings at a city, with different heights, and a horizontal laser is activated to cut through some of them. The application holds the heights of *n* registered buildings and there are 2 kinds of interactions: either a user inputs a new building height to be stored or inputs a laser height to check how many buildings would get cut by it. 

The application is web based, with use of Ring and Compojure routes. Unitary tests are conducted with Midje.

## Prerequisites

You will need [Java JDK] 8 or above and [Leiningen][] 2.0.0 or above installed.

[Java JDK]: http://www.oracle.com/technetwork/java/javase/downloads/index.html
[leiningen]: https://leiningen.org/

## Running the Application

To start a web server for the application, run:

    lein ring server

## Running Tests

To run tests, run:

    lein midje

