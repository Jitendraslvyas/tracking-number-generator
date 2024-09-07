package com.getrosoft.controller;

import com.getrosoft.model.request.TrackingNumberRequest;
import com.getrosoft.model.response.TrackingNumberResponse;
import com.getrosoft.service.TrackingNumberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Exposed an API that generates unique tracking number
 *
 * @author Jitendra
 * @version 1.0
 *
 */
@RestController
@RequestMapping("/api")
public class TrackingNumberController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TrackingNumberService trackingNumberService;

    @GetMapping("/next-tracking-number")
    public ResponseEntity<TrackingNumberResponse> getNextTrackingNumber(@Valid @ModelAttribute TrackingNumberRequest request) {
        return new ResponseEntity<TrackingNumberResponse>(
                modelMapper.map(
                        trackingNumberService.createTrackingNumber(request.getCustomer_id()), TrackingNumberResponse.class), HttpStatus.OK);
    }

}
