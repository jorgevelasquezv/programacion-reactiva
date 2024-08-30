package co.com.jorge.lesson.two;

import co.com.jorge.lesson.two.workshop.Person;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Jorge", 30, "M"),
                new Person("Maria", 25, "F"),
                new Person("Pedro", 40, "M"),
                new Person("Ana", 35, "F")
        );

        // Filter: Filtrar personas mayores de 25 años.
        logger.log(Level.INFO, "Personas mayores de 25 años: {0}",
                persons.stream()
                        .filter(person -> person.getAge() > 25)
                        .collect(Collectors.toList())
        );

        // Map: Obtener una lista con los nombres de las personas.
        logger.log(Level.INFO, "Nombres de las personas: {0}",
                persons.stream()
                        .map(Person::getName)
                        .collect(Collectors.toList())
        );

        // Reduce: Obtener la suma de las edades de todas las personas.
        logger.log(Level.INFO, "Suma de las edades de todas las personas: {0}",
                persons.stream()
                        .map(Person::getAge)
                        .reduce(0, Integer::sum)
        );

        // Contar la cantidad de personas de cada género.
        logger.log(Level.INFO, "Cantidad de personas de cada género: {0}",
                persons.stream()
                        .collect(Collectors.groupingBy(Person::getGender, Collectors.counting()))
        );


        // Calcular el promedio de edades de las personas.
        logger.log(Level.INFO, "Promedio de edades de las personas: {0}",
                persons.stream()
                        .mapToInt(Person::getAge)
                        .average()
                        .orElse(0.0)
        );

        // Encontrar la persona de mayor edad.
        logger.log(Level.INFO, "Persona de mayor edad: {0}",
                persons.stream()
                        .max((person1, person2) -> person1.getAge() - person2.getAge())
                        .orElse(null)
        );
    }
}
