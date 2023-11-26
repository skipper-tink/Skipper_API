package com.backend.tinkoff_backend.entityes;

import jakarta.persistence.*;

@Entity
@Table(name = "DemandEmployee")
public class DemandEmployee {

    @Id
    @Column(name = "demandEmployeeId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idInvolvedEmployee;
}
