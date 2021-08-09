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
public class PlantsCollection extends StandardAuditEntity implements SecurityEntity {

    @Column(name = "title")
    private String title;

    @ManyToMany
    @JoinTable(
            name = "plants_collection_ref",
            joinColumns = @JoinColumn(name = "collection_id"),
            inverseJoinColumns = @JoinColumn(name = "plant_id"))
    private List<Plant> plants;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
