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
- [ ] Spock Tests for each class with logic
- [ ] DrivingHistory class with main[] to read filename from console
- [ ] TripDataService to build Driver and Trip objects from input file
- [ ] Driver object
- [ ] Trip object
- [ ] Speed calculator class

## Running this project
**TODO**

Once I'm done I'll include detailed instructions.

## Thoughts and Decisions

This will be a list of thought process and decisions made in finishing the solution.

- `Round miles and miles per hour to the nearest integer.` 
For best sorting seems like I should take in float and output the rounded int.



## Possible Improvements

I'm going to get this into a nice working state and then identify Nice To Haves.

- Using a logging framework instead of System output
- Extract Trip creation from processTripLine, it adds 4 lines that bloat the function a bit.
- Factory for input types, especially if there's more than 2 types. 