package com.kodilla.travel_backend.domain;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name= "Flight")
public class Flight {

    @Id
    @Column(name = "flight_id")
    private Long flightId;

    @Column(name = "starting_place")
    @NotNull
    private String startingPlace;

    @Column(name = "final_place")
    @NotNull
    private String finalPlace;

    @Column(name = "flight_date")
    @NotNull
    private LocalDate flightDate;

    @Column(name = "flight_time")
    @NotNull
    private LocalTime flightTime;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Flight(Long flightId, String finalPlace, LocalDate flightDate, LocalTime flightTime) {
        this.flightId = flightId;
        this.finalPlace = finalPlace;
        this.flightDate = flightDate;
        this.flightTime = flightTime;
    }
}
