package dev.erikestr;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.erikestr.beans.entities.Person;
import dev.erikestr.config.ProjectConfig;

public class Main {
        public static void main(String[] args) {

                System.err.println("\u001B[35m--------------------------------\u001B[0m");
                System.err.println("\u001B[35mStarting application context...\u001B[0m");
                System.err.println("\u001B[35m--------------------------------\u001B[0m");

                var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

                Person person = context.getBean(Person.class);
                person.getVehicle().performVehicleTestFunctions();

                context.close();
        }
}