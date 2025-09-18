package com.nyxses.device.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DeviceDTO {
    private  Long id;
    private Long number;
    private String description;
    private LocalDateTime lastupdate;
    private Long configurationid;
    private Long oldconfigurationid;
    private String info;
    private String imei;
    private String phone;
    private Long customerid;
    private String imeiupdates;
    private String custom1;
    private String custom2;
    private String custom3;
    private String oldnumber;
    private String fastsearch;
    private LocalDateTime enrolltime;
    private String infojson;
    private String publicip;
}
