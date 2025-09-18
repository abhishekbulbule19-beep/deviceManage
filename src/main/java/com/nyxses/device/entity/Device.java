package com.nyxses.device.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "devices")

public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


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
    @Column(columnDefinition = "TEXT")
    private String infojson;
    private String publicip;

}
