package com.jdm.jdm_vehicle_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String imageFileName;

    @Column(nullable = false)
    private String status;
}