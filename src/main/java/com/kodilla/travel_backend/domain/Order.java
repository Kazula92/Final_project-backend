package com.kodilla.travel_backend.domain;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "u_id")
    @NotNull
    private Long userId;

    @Column(name = "accommodation_id")
    @NotNull
    private Long accommodationId;

    @Column(name = "flight_id")
    @NotNull
    private Long flightId;

    @OneToMany(
            targetEntity = Flight.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Flight> flightsList = new ArrayList<>();

    @OneToMany(
            targetEntity = Accommodation.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )

    private List<Accommodation> accommodationsList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Order(Long orderId, Long userId, Long accommodationId, Long flightId) {
        this.orderId = orderId;
        this.userId = userId;
        this.accommodationId = accommodationId;
        this.flightId = flightId;
    }
}
