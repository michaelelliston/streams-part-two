package com.pluralsight.streams;

import utilities.InputGetter;

import java.util.*;

public class Program {

    public static void main(String[] args) {


        List<Person> people = new ArrayList<Person>(List.of(
                new Person("Avery", "Bennett", 17),
                new Person("Mateo", "Cortez", 22),
                new Person("Maya", "Singh", 28),
                new Person("Elias", "Romero", 19),
                new Person("Harper", "Nguyen", 34),
                new Person("Noah", "Patel", 28),
                new Person("Isla", "Chen", 27),
                new Person("Mateo", "Brooks", 25),
                new Person("Zara", "Thompson", 19),
                new Person("Caleb", "Foster", 21)
        ));

        String userInput = InputGetter.getString("Please enter the name you are searching for: ");

        List<Person> filteredPeople = people.stream()
                .filter(p -> p.getFirstName().equalsIgnoreCase(userInput) || p.getLastName().equalsIgnoreCase(userInput))
                .toList();

        filteredPeople.stream()
                .forEach(System.out::println);

        int ageSum = people.stream()
                .mapToInt(Person::getAge)
                .reduce(0, Integer::sum);

        System.out.println("\nAverage age of everyone: " + ageSum / people.size());

        Optional<Person> youngestPerson = people.stream()
                .min(Comparator.comparingInt(Person::getAge));

        Optional<Person> oldestPerson = people.stream()
                .max(Comparator.comparingInt(Person::getAge));

        System.out.println("Youngest person: " + youngestPerson.get());
        System.out.println("Oldest person: " + oldestPerson.get());

        youngestPerson.ifPresent(System.out::println); // Testing other way to print the actual person object held inside the Optional<Person> type variable, checks if the variable is empty or not before printing

    }
}
