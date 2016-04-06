package com.beauchef.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * @author jbeauchef
 */
@Data
@EqualsAndHashCode(of = {"number"})
public class Phone {

    @NonNull private String type;
    @NonNull private String number;
}