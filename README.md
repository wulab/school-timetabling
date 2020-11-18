# School Timetabling

A minimal OptaPlanner project to solve a school timetabling problem

## Problem description

School timetabling is an NP-hard problem. It is difficult to scale. AI constraint solvers such as [OptaPlanner](https://www.optaplanner.org) have advanced algorithms that deliver a near-optimal solution in a reasonable amount of time.

![timeTableApp](https://docs.optaplanner.org/7.45.0.Final/optaplanner-docs/html_single/QuickStart/SpringBoot/timeTableAppScreenshot.png)

## Define constraints

The solver will assign Lesson instances to Timeslot and Room instances automatically by using AI to adhere to the following hard and soft constraints.

- A room can have at most one lesson at the same time.
- A teacher can teach at most one lesson at the same time.
- A student can attend at most one lesson at the same time.
- A teacher prefers to teach every lesson in a single room.
- A teacher prefers to teach sequential lessons and dislikes gaps between lessons.

The constraints are implemented in the [Drools score file](app/src/main/resources/schooltimetabling/schoolTimetablingConstraints.drl).

## Load the problem

All lessons, timeslots and rooms from the above screenshot are specified in the [App file](app/src/main/java/schooltimetabling/App.java).

## Solve for a solution

Make sure you have [Gradle](https://gradle.org) on your computer and run:

    $ ./gradlew run
    Solved TimeTable with 5 timeslots, 3 rooms and 10 lessons:

    * Geography(1) -> Room A, MONDAY 09:30
    * Physics(2) -> Room A, MONDAY 08:30
    * Physics(3) -> Room A, MONDAY 13:30
    * Chemistry(4) -> Room A, MONDAY 10:30
    * Math(5) -> Room C, MONDAY 14:30
    * Math(6) -> Room C, MONDAY 10:30
    * Spanish(7) -> Room B, MONDAY 08:30
    * Spanish(8) -> Room B, MONDAY 13:30
    * English(9) -> Room B, MONDAY 09:30
    * English(10) -> Room B, MONDAY 14:30

    Score: 0hard/-6soft

Increase the time limit in the [solver config file](app/src/main/resources/schooltimetabling/solverConfig.xml) to get a better result.
