package ru.shashy.orderrestapi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.shashy.orderrestapi.domain.base.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "audit_log")
public class AuditLog extends BaseEntity<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "action", nullable = false)
    private String action;

    @Column(name = "description")
    private String description;

    @Column(name = "action_timestamp")
    private LocalDateTime actionTimestamp;
}
