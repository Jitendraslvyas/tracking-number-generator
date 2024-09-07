package com.getrosoft.service.impl;

import com.getrosoft.model.entity.TrackingNumber;
import com.getrosoft.repository.TrackingNumberRepository;
import com.getrosoft.service.TrackingNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.UUID;

@Service
@Transactional
public class TrackingNumberServiceImpl implements TrackingNumberService {

    @Autowired
    private TrackingNumberRepository trackingNumberRepository;

    private String generateUniqueTrackingNumber() {
        String trackingNumber;
        do {
            trackingNumber = UUID.randomUUID().toString().replace("-", "").substring(0, 16).toUpperCase();
        } while (trackingNumberRepository.existsByTrackingNumber(trackingNumber));

        return trackingNumber;
    }

    @Override
    public TrackingNumber createTrackingNumber(UUID customerId) {
        TrackingNumber trackingNumber = new TrackingNumber(null, customerId, generateUniqueTrackingNumber(), OffsetDateTime.now());
        return trackingNumberRepository.save(trackingNumber);
    }

}
