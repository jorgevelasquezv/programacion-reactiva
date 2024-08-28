package co.com.jorge.lesson.two;

import co.com.jorge.lesson.two.workshop.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Jorge", 30, "M"),
                new Person("Maria", 25, "F"),
                new Person("Pedro", 40, "M"),
                new Person("Ana", 35, "F")
        );

        // Filter: Filtrar personas mayores de 25 años.
        System.out.println("Personas mayores de 25 años: " +
                persons.stream()
                        .filter(person -> person.getAge() > 25)
                        .collect(Collectors.toList())
        );

        // Map: Obtener una lista con los nombres de las personas.
        System.out.println("Nombres de las personas: " +
                persons.stream()
                        .map(Person::getName)
                        .collect(Collectors.toList())
        );

        // Reduce: Obtener la suma de las edades de todas las personas.
        System.out.println("Suma de las edades de todas las personas: " +
                persons.stream()
                        .map(Person::getAge)
                        .reduce(0, Integer::sum)
        );

        // Contar la cantidad de personas de cada género.
        System.out.println("Cantidad de personas de cada género: " +
                persons.stream()
                        .collect(Collectors.groupingBy(Person::getGender, Collectors.counting()))
        );


        // Calcular el promedio de edades de las personas.
        System.out.println("Promedio de edades de las personas: " +
                persons.stream()
                        .mapToInt(Person::getAge)
                        .average()
                        .orElse(0.0)
        );

        // Encontrar la persona de mayor edad.
        System.out.println("Persona de mayor edad: " +
                persons.stream()
                        .max((person1, person2) -> person1.getAge() - person2.getAge())
                        .orElse(null)
        );
    }
}
