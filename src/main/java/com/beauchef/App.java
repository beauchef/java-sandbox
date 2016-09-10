package com.beauchef;

import com.beauchef.domain.Phone;
import com.beauchef.domain.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jbeauchef
 */
public class App {

    public static void main(String[] args) {

        new Thread(() -> System.out.println("I am running in " + Thread.currentThread().getName()), "My Thread").start();

        List<String> ids = Arrays.asList("1", "2" ,"3", "4", "5");
        System.out.println(String.format("[%s]", String.join(", ", ids.stream().toArray(String[]::new))));

        User johnDoe = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .dateOfBirth(LocalDate.of(1973, 5, 2))
                .phone(new Phone("Home", "450-671-3458"))
                .phone(new Phone("Mobile", "438-390-0252"))
                .build();
        System.out.println(johnDoe);
    }
}