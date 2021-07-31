package com.plants.journal.domain;

import com.plants.journal.domain.standard.StandardAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Plant extends StandardAuditEntity implements SecurityEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "plant")
    private List<Event> events;

    public Plant(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
