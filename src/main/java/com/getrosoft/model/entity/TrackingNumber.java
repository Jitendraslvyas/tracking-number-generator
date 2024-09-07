package com.getrosoft.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tracking_number", indexes = {
        @Index(name = "idx_tracking_number", columnList = "trackingNumber", unique = true)
})
public class TrackingNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID customerId;

    @Column(nullable = false)
    private String trackingNumber;

    private OffsetDateTime createdAt;
}
