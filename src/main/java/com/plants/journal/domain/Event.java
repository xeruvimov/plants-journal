package com.plants.journal.domain;

import com.plants.journal.domain.enums.EventType;
import com.plants.journal.domain.standard.StandardAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Event extends StandardAuditEntity {

    @Column(name = "event_type")
    private EventType eventType;

    @Column(name = "date")
    private long date;

    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "id")
    private Plant plant;
}