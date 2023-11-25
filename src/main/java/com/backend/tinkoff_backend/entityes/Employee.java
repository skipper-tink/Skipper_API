package com.backend.tinkoff_backend.entityes;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "idEmployee")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name = "user_login", referencedColumnName = "login")
    private String userLogin;

    @Column(name = "free time per week")
    private long freeTimePerWeek;

    @Column(name = "this free time until date")
    private Date untilDate;

    public Employee(){
    }

    public Employee(long id,
                    String userLogin,
                    long freeTimePerWeek,
                    Date untilDate) {
        this.id = id;
        this.userLogin = userLogin;
        this.freeTimePerWeek = freeTimePerWeek;
        this.untilDate = untilDate;
    }
}
