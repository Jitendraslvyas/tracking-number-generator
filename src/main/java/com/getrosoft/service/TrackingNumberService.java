package com.getrosoft.service;

import com.getrosoft.model.entity.TrackingNumber;

import java.util.UUID;

public interface TrackingNumberService {

    public TrackingNumber createTrackingNumber(UUID customerId);
}
