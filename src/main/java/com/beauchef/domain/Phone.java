package com.beauchef.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * @author jbeauchef
 */
@Builder
@Getter
@ToString
@EqualsAndHashCode(of = {"number"})
public class Phone {

    @NonNull private String type;
    @NonNull private String number;
}