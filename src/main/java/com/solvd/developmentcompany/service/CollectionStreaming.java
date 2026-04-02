package com.solvd.developmentcompany.service;

import com.solvd.developmentcompany.person.Employee;
import com.solvd.developmentcompany.project.Material;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CollectionStreaming {

    private static final Logger LOGGER = LoggerFactory.getLogger(CollectionStreaming.class);

    public static void demonstrate(List<Employee> employees,
                                   List<Material> materials) {

        LOGGER.info("\nStream 1: High earners (salary > 3000)");
        employees.stream()
                .filter(e -> e.getSalary() > 3000)
                .forEach(e -> LOGGER.info("  " + e.getRole() + ": $" + e.getSalary()));

        LOGGER.info("\nStream 2: All employee names");
        List<String> names = employees.stream()
                .map(e -> e.getFirstName() + " " + e.getLastName())
                .collect(Collectors.toList());
        LOGGER.info("  " + names);

        LOGGER.info("\nStream 3: Materials sorted by cost (cheapest first)");
        List<Material> sorted = materials.stream()
                .sorted(Comparator.comparingDouble(Material::getCost))
                .collect(Collectors.toList());
        sorted.forEach(m -> LOGGER.info("  " + m.getName() + " → $" + m.getCost()));

        LOGGER.info("\nStream 4: Total material cost");
        double total = materials.stream()
                .map(Material::getCost)
                .reduce(0.0, Double::sum);
        LOGGER.info("  Total: $" + total);

        LOGGER.info("\nStream 5: Employees grouped by role");
        Map<String, List<Employee>> byRole = employees.stream()
                .collect(Collectors.groupingBy(Employee::getRole));
        byRole.forEach((role, emps) ->
                LOGGER.info("  " + role + ": " + emps.size() + " person(s)")
        );
    }
}