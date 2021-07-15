package com.plants.journal.domain;

import com.plants.journal.domain.standard.StandardAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Plant extends StandardAuditEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "plant")
    private List<Event> events;

    public Plant(String name, String description) {
        this.name = name;
        this.description = description;
    }
}