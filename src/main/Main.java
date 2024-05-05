package src.main;

import company.beans.Person;
import company.extensions.InvalidAgeException;
import company.implementations.EmailMessenger;
import company.interfaces.Messenger;

public class Main {
    public static void main(String[] args) {

        Person[] people = new Person[5];

        final int b = 10;

        try {
            people[0] = new Person("Anna", 20);
            people[1] = new Person("Maria", 25);
            people[2] = new Person("Amelia", 49);
            people[3] = new Person("Bob", 24);
            people[4] = new Person("Eva", 30);

            for (Person person : people) {
                int result = MathUtils.add(person.getAge(), b);
                String message = "Wynik dla osoby " + person.getName() + ": " + result;

                EmailMessenger emailMessenger = new EmailMessenger();
                emailMessenger.sendMessage(message);
            }
        } catch (InvalidAgeException e) {

            System.err.println("Invalid age: " + e.getMessage());
        }
    }
}