package com.beauchef;

import com.beauchef.domain.Phone;
import com.beauchef.domain.User;
import java.time.LocalDate;

/**
 * @author jbeauchef
 */
public class App {

    public static void main(String[] args) {

        Phone home = Phone.builder().type("Home").number("450-671-3458").build();
        Phone mobile = Phone.builder().type("Mobile").number("438-390-0252").build();
        User johnDoe = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .dateOfBirth(LocalDate.of(1973,5,2))
                .phone(home)
                .phone(mobile)
                .build();
        System.out.println(johnDoe);
    }
}