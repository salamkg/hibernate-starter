package com.test.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public record Birthday(LocalDate birthdate) {
    public long getAge() {
        return ChronoUnit.YEARS.between(birthdate, LocalDate.now());
    }
}
