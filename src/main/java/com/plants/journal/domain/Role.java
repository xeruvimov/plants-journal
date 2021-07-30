package com.plants.journal.domain;

import com.plants.journal.domain.standard.StandardAuditEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role extends StandardAuditEntity implements GrantedAuthority {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
