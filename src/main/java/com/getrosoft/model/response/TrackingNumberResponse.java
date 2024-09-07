package com.getrosoft.model.response;

import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class TrackingNumberResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private UUID customerId;
    private String trackingNumber;
    private OffsetDateTime createdAt;
}
