package com.priceengine.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Penguin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private int numberOfSingleUnits;

    @Override
    public String toString() {
        return "Penguin{" +
                "id=" + id +
                ", customerId='" + customerId + '\'' +
                ", numberOfSingleUnits=" + numberOfSingleUnits +
                '}';
    }
}
