package com.nyxses.device.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "devices")

public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name="number", nullable = false)
    private Long number;
    @Column(name="description", nullable = false)
    private String description;
    @Column(name="lastupdate", nullable = true)
    private LocalDateTime lastupdate;
    @Column(name="configurationid", nullable = false)
    private Long configurationId;
    @Column(name="oldconfigurationid", nullable = false)
    private Long oldConfigurationId;
    @Column(name="info", nullable = false)
    private String info;
    @Column(name="imei", nullable = false)
    private String imei;
    @Column(name="phone", nullable = false)
    private String phone;
    @Column(name="customerid", nullable = false)
    private Long customerId;
    @Column(name="imeiupdates", nullable = false)
    private String imeiupdates;
    @Column(name="custom1", nullable = true)
    private String custom1;
    @Column(name="custom2", nullable = true)
    private String custom2;
    @Column(name="custom3", nullable = true)
    private String custom3;
    @Column(name="oldnumber", nullable = true)
    private String oldnumber;
    @Column(name="fastsearch", nullable = true)
    private String fastsearch;
    @Column(name="enrolltime", nullable = true)
    private LocalDateTime enrolltime;
    @Column(columnDefinition = "TEXT")
    private String infojson;
    @Column(name="publicip", nullable = true)
    private String publicip;
}
