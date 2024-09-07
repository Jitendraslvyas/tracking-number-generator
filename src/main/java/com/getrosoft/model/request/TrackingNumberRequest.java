package com.getrosoft.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackingNumberRequest {

    @NotBlank(message = "Origin country ID is required")
    @Pattern(regexp = "^[A-Z]{2}$", message = "Invalid origin country ID format")
    private String origin_country_id;

    @NotBlank(message = "Destination country ID is required")
    @Pattern(regexp = "^[A-Z]{2}$", message = "Invalid destination country ID format")
    private String destination_country_id;

    @NotBlank(message = "Weight is required")
    @DecimalMin(value = "0.001", message = "Weight must be greater than 0")
    @DecimalMax(value = "1000.000", message = "Weight must be less than or equal to 1000 kilograms")
    @Digits(integer = 4, fraction = 3, message = "Weight must be a valid decimal number with up to three decimal places")
    private String weight;

    @NotNull(message = "Created at timestamp is required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime created_at;

    @NotNull(message = "Customer ID is required")
    private UUID customer_id;

    @NotBlank(message = "Customer name is required")
    @Size(max = 100, message = "Customer name must be less than or equal to 100 characters")
    private String customer_name;

    @NotBlank(message = "Customer slug is required")
    @Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$", message = "Invalid customer slug format")
    private String customer_slug;
}
