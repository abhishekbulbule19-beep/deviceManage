package com.nyxses.device.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Schema(
        name="Device",
        description = "It holds device information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DeviceDTO {
    @JsonProperty("id")
    @Schema(example = "1")
    private  Long id;
    @Schema(example = "1021")
    @JsonProperty("number")
    private Long number;
    @Schema(example = "Test Device for QA 8")
    @JsonProperty("description")
    private String description;
    @Schema(example = "2025-09-12T10:30:00")
    @JsonProperty("lastupdate")
    private LocalDateTime lastupdate;
    @Schema(example = "3")
    @JsonProperty("configurationid")
    private Long configurationid;
    @Schema(example = "0")
    @JsonProperty("oldconfigurationid")
    private Long oldconfigurationid;
    @Schema(example = "Test device registered for API validation")
    @JsonProperty("info")
    private String info;
    @Schema(example = "3598761234567567")
    @JsonProperty("imei")
    private String imei;
    @Schema(example = "+918553514407")
    @JsonProperty("phone")
    private String phone;
    @Schema(example = "107")
    @JsonProperty("customerid")
    private Long customerid;
    @Schema(example = "2025-09-12T10:30:00")
    @JsonProperty("imeiupdates")
    private String imeiupdates;
    @Schema(example = "Location: QA Lab America")
    @JsonProperty("custom1")
    private String custom1;
    @Schema(example = "OS: Android 14")
    @JsonProperty("custom2")
    private String custom2;
    @Schema(example = "Batch: TestRun_09")
    @JsonProperty("custom3")
    private String custom3;
    @Schema(example = "1006")
    @JsonProperty("oldnumber")
    private String oldnumber;
    @Schema(example = "TESTDEVICE07")
    @JsonProperty("fastsearch")
    private String fastsearch;
    @Schema(example = "2025-09-12T10:32:00")
    @JsonProperty("enrolltime")
    private LocalDateTime enrolltime;
    @Schema(
            description = "JSON data stored as a string. Must be valid JSON in string format.",
            example = "{\"osVersion\":\"14\",\"model\":\"Pixel 8\"}"
    )
    @JsonProperty("infojson")
    private String infojson;
    @Schema(example = "203.0.113.90")
    @JsonProperty("publicip")
    private String publicip;
}
