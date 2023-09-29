package com.example.lab6_20185910.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "TicketID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SiteID")
    private Site siteID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TechnicianID")
    private Technician technicianID;

    @Column(name = "Status", length = 50)
    private String status;

    @Column(name = "openeddate")
    private Instant openeddate;

    @Column(name = "closeddate")
    private Instant closeddate;

}