package ru.shashy.orderrestapi.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.shashy.orderrestapi.domain.base.BaseEntity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Categories extends BaseEntity<Long> {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = true)
    private String description;
}
