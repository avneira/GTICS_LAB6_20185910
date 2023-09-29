package com.example.lab6_20185910.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deviceid", nullable = false)
    private Integer deviceid;

    @Column(name = "deviceName")
    private String deviceName;

    @Column(name = "deviceType")
    private String deviceType;

    @Column(name = "model")
    private String model;

    @Column(name = "serialNumber")
    private String serialNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "siteID")
    private Site siteID;

}