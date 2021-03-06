package com.plants.journal.domain;

import com.plants.journal.domain.enums.EventType;
import com.plants.journal.domain.standard.StandardAuditEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Event extends StandardAuditEntity implements SecurityEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type")
    private EventType eventType;

    @Column(name = "date")
    private long date;

    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "plant_id", nullable = false)
    private Plant plant;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
