package ml.cloverkit.interfaces;

sealed interface Employee permits CLevel, Programmer {}

record CLevel(String type) implements Employee {}
record Programmer(String experience) implements Employee {}