package com.company;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// MUST WATCH --> https://youtu.be/f5j1TaJlc0w
public class Main {

    private static List<Person> getPeople() {
        return List.of(
                new Person("Antonio", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)
        );
    }

    public static void main(String[] args) {
        List<Person> people = getPeople();

        /*
    Imperative approach ❌

    List<Person> females = new ArrayList<>();
    for (Person person : people) {
      if (person.getGender().equals(Gender.FEMALE)) {
        females.add(person);
      }
    }
    females.forEach(System.out::println);
    */
        // Declarative approach ✅
        System.out.println("----------- FEMALES -----------");
        List<Person> FEMALES = people.stream()
                .filter(Person -> Person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
        FEMALES.forEach(System.out::println);

        System.out.println("----------- SORTED BY AGE -----------");
        List<Person> SORTED = people.stream()
                .sorted(Comparator.comparing(Person -> Person.getAge()))
                .collect(Collectors.toList());
        SORTED.forEach(System.out::println);

        System.out.println("----------- FEMALE & AGE > 60 -----------");
        // Filter
        List<Person> females = people.stream()
                .filter(Person -> Person.getGender().equals(Gender.FEMALE) & Person.getAge() > 60)
                .sorted()
                .collect(Collectors.toList());
        females.forEach(System.out::println);

        System.out.println("----------- ALLMATCH & AGE > 8 -----------");
        System.out.println("----------- IF PRESENT WILL RETURN TRUE -----------");
        // All match
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 8);
        System.out.println(allMatch);

        System.out.println("----------- ANYMATCH & AGE > 121 -----------");
        System.out.println("----------- IF PRESENT WILL RETURN TRUE -----------");
        // Any match
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 121);

        System.out.println(anyMatch);

        System.out.println("----------- NONEMATCH & NAME > Antonio -----------");
        System.out.println("----------- IF PRESENT WILL RETURN TRUE -----------");
        // None match
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Antonio"));

        System.out.println(noneMatch);

        System.out.println("----------- MAX &  Person::getAge -----------");
        // Max
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        System.out.println("----------- MIN &  Person::getAge -----------");
        // Min
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        System.out.println("----------- GROUP WITH MAP -----------");
        // Group
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
            System.out.println();
        });

        System.out.println("----------- OPTIONAL -----------");
        Optional<String> oldestFemaleAge = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);

        oldestFemaleAge.ifPresent(System.out::println);
    }
}

class Person {

    private final String name;
    private final int age;
    private final Gender gender;

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}

enum Gender {
    MALE, FEMALE
}