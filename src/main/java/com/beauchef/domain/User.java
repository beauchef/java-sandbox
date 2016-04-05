package com.beauchef.domain;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * @author jbeauchef
 */
@Builder
@Getter
@ToString
@EqualsAndHashCode(of = {"email"})
public class User {

    @NonNull private String firstName;
    @NonNull private String lastName;
    @NonNull @Email private String email;
    @Singular @Size(max = 5) private List<Phone> phones;
    private LocalDate dateOfBirth;
}