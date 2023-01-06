package com.kodilla.travel_backend.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "Accommodation")
public class Accommodation {

    @Id
    @Column(name = "A_id")
    private Long aId;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "location")
    @NotNull
    private String location;

    @Column(name = "price")
    @NotNull
    private double price;

    @Column(name = "availability")
    @NotNull
    private boolean availability;

    @Column(name = "date")
    @NotNull
    private LocalDate accommodationDate;

    @Column(name = "number_of_people")
    @NotNull
    private int numberOfPeople;

    @ManyToOne
    @JoinColumn(name= "order_id")
    private Order order;

    public Accommodation(Long aId, String name, String location, double price, boolean availability) {
        this.aId = aId;
        this.name = name;
        this.location = location;
        this.price = price;
        this.availability = availability;
    }
}
