package com.beauchef;

import com.beauchef.domain.Phone;
import com.beauchef.domain.User;
import java.time.LocalDate;

/**
 * @author jbeauchef
 */
public class App {

    public static void main(String[] args) {

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