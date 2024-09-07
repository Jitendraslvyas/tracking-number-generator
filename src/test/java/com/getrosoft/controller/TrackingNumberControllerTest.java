package com.getrosoft.controller;

import com.getrosoft.integration.AbstractIntegrationTest;
import com.getrosoft.repository.TrackingNumberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TrackingNumberControllerTest extends AbstractIntegrationTest {

    @Autowired
    private TrackingNumberRepository trackingNumberRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() { trackingNumberRepository.deleteAll(); }

    @Test
    public void testGetNextTrackingNumber_Success() throws Exception {
        mockMvc.perform(get("/api/next-tracking-number")
                        .queryParam("origin_country_id", "MY")
                        .queryParam("destination_country_id", "ID")
                        .queryParam("weight", "1.234")
                        .queryParam("created_at", "2018-11-20T19:29:32+08:00")
                        .queryParam("customer_id", "de619854-b59b-425e-9db4-943979e1bd49")
                        .queryParam("customer_name", "RedBox Logistics")
                        .queryParam("customer_slug", "redbox-logistics")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerId").value("de619854-b59b-425e-9db4-943979e1bd49"));
    }

    @Test
    public void testGetNextTrackingNumber_ValidationError() throws Exception {
        mockMvc.perform(get("/api/next-tracking-number")
                        .queryParam("origin_country_id", "MY")
                        .queryParam("destination_country_id", "ID")
                        .queryParam("weight", "-1.234")
                        .queryParam("created_at", "2018-11-20T19:29:32+08:00")
                        .queryParam("customer_id", "de619854-b59b-425e-9db4-943979e1bd49")
                        .queryParam("customer_name", "RedBox Logistics")
                        .queryParam("customer_slug", "redbox-logistics")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.weight").value("Weight must be greater than 0"));
    }

}
