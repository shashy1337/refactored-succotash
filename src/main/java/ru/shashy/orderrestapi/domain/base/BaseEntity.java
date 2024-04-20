package ru.shashy.orderrestapi.domain.base;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity <ID> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;
}
