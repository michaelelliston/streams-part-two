package com.pluralsight.streams;

import utilities.InputGetter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        List<Person> filteredPeople = new ArrayList<Person>();

        for (Person person : people) {
            if (person.getFirstName().equalsIgnoreCase(userInput) || person.getLastName().equalsIgnoreCase(userInput)) {
                filteredPeople.add(person);
            }
        }

        for (Person person : filteredPeople) {
            System.out.println(person);
        }

        int ageSum = 0;
        for (Person person : people) {
            ageSum += person.getAge();
        }

        System.out.println("\nAverage age of everyone: " + ageSum / people.size());

        Collections.sort(people);

        System.out.println("Youngest person: " + people.get(0));
        System.out.println("Oldest person: " + people.get(people.size() - 1));

    }
}
