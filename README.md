# DrivingHistory
Java program with Spock TDD

## Problem Statement (adapted from prompt)

This program tracks driving history for multiple drivers.

The code will process an input file, each line in the input file starts with a command, either ```Driver``` or ```Trip```.

```Driver``` will register a new Driver in the app. Example: `Driver Dan`

```Trip``` will record a trip attributed to a driver. The line will be space delimited with the following fields: the command (Trip), driver name, start time, stop time, miles driven. Times will be given in the format of hours:minutes. We'll use a 24-hour clock and will assume that drivers never drive past midnight (the start time will always be before the end time). Example: `Trip Dan 07:15 07:45 17.3`

Any trips that average a speed of less than 5 mph or greater than 100 mph will be discarded.

Generate a report containing each driver with total miles driven and average speed. Sort the output by most miles driven to least. Round miles and miles per hour to the nearest integer.

Example input:

```
Driver Dan
Driver Alex
Driver Bob
Trip Dan 07:15 07:45 17.3
Trip Dan 06:12 06:32 21.8
Trip Alex 12:01 13:16 42.0
```

Expected output:

```
Alex: 42 miles @ 34 mph
Dan: 39 miles @ 47 mph
Bob: 0 miles
```

## Initial plan:
This is my initial thoughts for what I want to do.
- [x] Spock Tests for each class with logic
- [x] DrivingHistory class with main[] to read filename from console and print results
- [x] TripDataService to build Driver and Trip objects from input file
- [x] Driver object
- [x] Trip object
- [x] Calculating distance and speed

## Running this project
1. Clone this repo from Github.
2. In terminal, navigate to DrivingHistory.java:
> cd DrivingHistory/src/main/
3. Compile sources:
> javac DrivingHistory.java
4. Create a new test file in the directory of your choice.
5. Run the program with the filename as an input:
> java DrivingHistory ../test/resources/standard.txt
6. Check the terminal for output.

## Thoughts and Decisions

This will be a list of thought process and decisions made in finishing the solution.

Starting out I wanted a class with a main function, to compile it and run with a filename.
I made TripDataService to handle the input and build objects.
I thought I'd need a service to calculate speed/distance, and another to sort and print output,
but I distributed those to the objects themselves, and implementing `Comparable` made sorting much cleaner.
I think some would say `getAverageSpeed` et. al. should be in a service. I can see it both ways:
you may want a unified service layer that handles all logic, or you may want the objects to be responsible
for their individual calculations. To me it's a matter of preference.
This project is a pretty simple solution to the prompt, so I'll list improvements below.

## Possible Improvements
- Using a logging framework instead of System output for debug info and errors.
- Output to a file instead of System output, if the use case called for it.
- Extract Trip creation from `processTripLine`, it adds 4 lines that bloat the function a bit.
- Factory for input types, especially if there's more than 2 types.
- Store `Driver` and `Trip`, include `id` to track equivalence easier, use JPA/Hibernate/etc.
- Take in more Driver info to differentiate, as of now the program can't handle duplicates.
- More testing for Driver/Trip calculations and sorting