package com.backend.tinkoff_backend.entityes;

import jakarta.persistence.*;

@Entity
@Table(name = "InvolvedEmployee")
public class InvolvedEmployee {

    @Id
    @Column(name = "idInvolvedEmployee")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idInvolvedEmployee;
}
