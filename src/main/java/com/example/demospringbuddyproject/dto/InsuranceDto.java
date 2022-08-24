package com.example.demospringbuddyproject.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.example.demospringbuddyproject.model.Insurance} entity
 */
public class InsuranceDto implements Serializable {
    private final String name;
    private final String subject;
    private final Integer amount;

    public InsuranceDto(String name, String subject, Integer amount) {
        this.name = name;
        this.subject = subject;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuranceDto entity = (InsuranceDto) o;
        return Objects.equals(this.name, entity.name) &&
                Objects.equals(this.subject, entity.subject) &&
                Objects.equals(this.amount, entity.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subject, amount);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
                "subject = " + subject + ", " +
                "amount = " + amount + ")";
    }
}